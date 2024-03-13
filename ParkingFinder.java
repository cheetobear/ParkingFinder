import edu.cwi.parking.ParkingSpot;
import java.text.*;
import java.util.*;

public class ParkingFinder {
    public static void main(String[] args) {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        Random generator;
        Scanner keyboard = new Scanner(System.in);
        long seedValue;
        double parkingTime;

        System.out.println("What is the seed value?");
        seedValue = keyboard.nextLong();
        generator = new Random(seedValue);

        System.out.println("What is the parking time (minutes)?");
        parkingTime = keyboard.nextInt()/10.0 + 0.1;
        
        int carX = generator.nextInt(100);
        int carY = generator.nextInt(100);

        System.out.println("The position of your vehicle is: X:"+carX+" Y:"+carY);
        System.out.println();
            //Parking Spot 1
            int parkingSpot1X = generator.nextInt(100);
            int parkingSpot1Y = generator.nextInt(100);
            ParkingSpot parkingSpot1 = new ParkingSpot("Baltic Avenue", parkingSpot1X, parkingSpot1Y);
            System.out.println("Spot 1: " + parkingSpot1);
            // distance 1
            int distance1 = Math.abs(parkingSpot1X - carX) + Math.abs(parkingSpot1Y - carY);
            System.out.println("\tDistance: " + distance1 + " blocks.");
            // cost 1
            double cost1 = (double)parkingSpot1.getCostPerInterval() * (double)Math.ceil(parkingTime);
            String money1 = fmt.format(cost1);
            System.out.println("\tTotal Cost: " + money1);
            System.out.println();

            //Parking Spot 2
            int parkingSpot2X = generator.nextInt(100);
            int parkingSpot2Y = generator.nextInt(100);
            ParkingSpot parkingSpot2 = new ParkingSpot("Park Place", parkingSpot2X, parkingSpot2Y);
            System.out.println("Spot 2: " + parkingSpot2);
            // distance 2
            int distance2 = Math.abs(parkingSpot2X - carX) + Math.abs(parkingSpot2Y - carY);
            System.out.println("\tDistance: " + distance2 + " blocks.");
            // cost 2
            double cost2 = (double)parkingSpot2.getCostPerInterval() * (double)Math.ceil(parkingTime);
            String money2 = fmt.format(cost2);
            System.out.println("\tTotal Cost: " + money2);
            System.out.println();

            //Parking Spot 3
            int parkingSpot3X = generator.nextInt(100);
            int parkingSpot3Y = generator.nextInt(100);
            ParkingSpot parkingSpot3 = new ParkingSpot("Marvins Gardens", parkingSpot3X, parkingSpot3Y);
            parkingSpot3.setCostPerInterval(.30);
            System.out.println("Spot 3: " + parkingSpot3);
            // distance 3
            int distance3 = Math.abs(parkingSpot3X - carX) + Math.abs(parkingSpot3Y - carY);
            System.out.println("\tDistance: " + distance3 + " blocks.");
            // cost 3
            double cost3 = (double)parkingSpot3.getCostPerInterval() * (double)Math.ceil(parkingTime);
            String money3 = fmt.format(cost3);
            System.out.println("\tTotal Cost " + money3);
            System.out.println();

            //Parking Spot 4
            int parkingSpot4X = generator.nextInt(100);
            int parkingSpot4Y = generator.nextInt(100);
            ParkingSpot parkingSpot4 = new ParkingSpot("Indiana Avenue", parkingSpot4X, parkingSpot4Y);
            parkingSpot4.setCostPerInterval(.30);
            System.out.println("Spot 4: " + parkingSpot4);
            // distance 4
            int distance4 = Math.abs(parkingSpot4X - carX) + Math.abs(parkingSpot4Y - carY);
            System.out.println("\tDistance: " + distance4 + " blocks.");
            // cost 4
            double cost4 = (double)parkingSpot4.getCostPerInterval() * (double)Math.ceil(parkingTime);
            String money4 = fmt.format(cost4);
            System.out.println("\tTotal Cost " + money4);
            System.out.println();

            //Closest Spot
            int closestSpotDistance = Math.min(Math.min(distance1, distance2), Math.min(distance3, distance4));
            System.out.println("Distance to closest spot: " + closestSpotDistance);
            if (distance1 == closestSpotDistance) {
                ParkingSpot closestParkingSpot = new ParkingSpot(parkingSpot1.getStreet(), parkingSpot1.getLocationX(), parkingSpot1.getLocationY());
                System.out.println("The closest spot is: " + closestParkingSpot);
            } else if (distance2 == closestSpotDistance) {
                ParkingSpot closestParkingSpot = new ParkingSpot(parkingSpot2.getStreet(), parkingSpot2.getLocationX(), parkingSpot2.getLocationY());
                System.out.println("The closest spot is: " + closestParkingSpot);
            } else if (distance3 == closestSpotDistance) {
                ParkingSpot closestParkingSpot = new ParkingSpot(parkingSpot3.getStreet(), parkingSpot3.getLocationX(), parkingSpot3.getLocationY());
                System.out.println("The closest spot is: " + closestParkingSpot);
            } else {
                ParkingSpot closestParkingSpot = new ParkingSpot(parkingSpot4.getStreet(), parkingSpot4.getLocationX(), parkingSpot4.getLocationY());
                System.out.println("The closest spot is: " + closestParkingSpot);
            }
            

            keyboard.close();
    }
}
