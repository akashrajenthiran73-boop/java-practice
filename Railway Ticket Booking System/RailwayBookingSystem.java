import java.util.*;
import java.util.stream.*;


interface Bookable {
    void book(Passenger passenger);
}

abstract class Ticket implements Bookable {

    protected int seatNo;
    protected Coach coach;
    protected boolean booked = false;

    Ticket(int seatNo, Coach coach) {
        this.seatNo = seatNo;
        this.coach = coach;
    }

    abstract void printTicket(Passenger passenger);
}


abstract class Coach {
    abstract double getFare();
}


class ACCoach extends Coach {

    @Override
    double getFare() {
        return 1000;
    }
}


class SleeperCoach extends Coach {

    @Override
    double getFare() {
        return 500;
    }
}


class Passenger {

    private int seatNo;
    private String passengerName;

    Passenger(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public String getPassengerName() {
        return passengerName;
    }
}


class SeatNotAvailableException extends Exception {

    SeatNotAvailableException(String message) {
        super(message);
    }
}


class RailwayTicket extends Ticket {

    RailwayTicket(int seatNo, Coach coach) {
        super(seatNo, coach);
    }

    @Override
    public synchronized void book(Passenger passenger) {

        passenger.setSeatNo(seatNo);
        booked = true;

        StringBuilder sb = new StringBuilder();

        sb.append(passenger.getPassengerName());
        sb.append(" booked Seat ");
        sb.append(passenger.getSeatNo());
        sb.append(" - Fare: ");
        sb.append(coach.getFare());

        System.out.println(sb);
    }

    @Override
    void printTicket(Passenger passenger) {

        System.out.println(
            "Passenger: " + passenger.getPassengerName()
            + " | Seat: " + passenger.getSeatNo()
        );
    }

    public boolean isBooked() {
        return booked;
    }
}


class TicketBookingSystem {

    private Queue<Ticket> ticketQueue = new LinkedList<>();

    private ArrayList<Passenger> passengers = new ArrayList<>();

    private ArrayList<Ticket> bookedTickets = new ArrayList<>();

    private boolean productionFinished = false;

   
    public synchronized void addTicket(Ticket ticket) {

        ticketQueue.add(ticket);

        System.out.println("Producer added Seat: " + ticket.seatNo);

        notifyAll();
    }

    
    public synchronized void finishProduction() {

        productionFinished = true;

        notifyAll();
    }

   
    public synchronized Ticket getTicket()
            throws InterruptedException, SeatNotAvailableException {

        while (ticketQueue.isEmpty() && !productionFinished) {

            System.out.println(
                Thread.currentThread().getName()
                + " trying to book - Waiting..."
            );

            wait();
        }

        if (ticketQueue.isEmpty() && productionFinished) {

            throw new SeatNotAvailableException(
                "Seat Not Available!"
            );
        }

        return ticketQueue.poll();
    }

    
    public void bookTicket(Passenger passenger) {

        try {

            Ticket ticket = getTicket();

            ticket.book(passenger);

            synchronized (this) {

                passengers.add(passenger);
                bookedTickets.add(ticket);
            }

        } catch (SeatNotAvailableException e) {

            System.out.println(
                passenger.getPassengerName()
                + " - " + e.getMessage()
            );

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println("Booking interrupted!");
        }
    }

   
    public void displayBookedTickets() {

        System.out.println("\n--- BOOKED TICKETS ---");

        List<Ticket> result = bookedTickets.stream()
                .filter(ticket -> ticket.isBooked())
                .collect(Collectors.toList());

        System.out.println("Total Booked Tickets: " + result.size());

        System.out.println("\n--- PASSENGER DETAILS ---");

        for (Passenger p : passengers) {

            System.out.println(
                p.getPassengerName()
                + " - Seat " + p.getSeatNo()
            );
        }
    }
}


class Producer extends Thread {

    private TicketBookingSystem system;

    Producer(TicketBookingSystem system) {
        this.system = system;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {

            Coach coach;

            if (i % 2 == 0) {
                coach = new ACCoach();
            } else {
                coach = new SleeperCoach();
            }

            Ticket ticket = new RailwayTicket(i, coach);

            system.addTicket(ticket);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        system.finishProduction();
    }
}


class Consumer extends Thread {

    private TicketBookingSystem system;

    private Passenger passenger;

    Consumer(TicketBookingSystem system, Passenger passenger) {

        this.system = system;
        this.passenger = passenger;
    }

    @Override
    public void run() {

        system.bookTicket(passenger);
    }
}


public class RailwayBookingSystem {

    public static void main(String[] args) {

        TicketBookingSystem system = new TicketBookingSystem();

        
        Producer producer = new Producer(system);

        producer.start();

        
        Consumer[] consumers = new Consumer[11];

        for (int i = 0; i < 11; i++) {

            Passenger passenger =
                new Passenger("User-" + (i + 1));

            consumers[i] = new Consumer(system, passenger);

            consumers[i].start();
        }

        
        try {

            producer.join();

            for (Consumer consumer : consumers) {
                consumer.join();
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

      
        system.displayBookedTickets();
    }
}