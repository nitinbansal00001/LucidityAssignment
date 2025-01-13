import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Location deliveryPersonLocation = new Location(12.9340, 77.6101);

        Location restaurantLocation1 = new Location(12.9200, 77.6105);
        Location customerLocation1 = new Location(12.9450, 77.6020);
        double preparationTime1 = 20;

        Location restaurantLocation2 = new Location(12.9305, 77.6000);
        Location customerLocation2 = new Location(12.9250, 77.6300);
        double preparationTime2 = 20;

        Order order1 = new Order(customerLocation1, restaurantLocation1, preparationTime1);
        Order order2 = new Order(customerLocation2, restaurantLocation2, preparationTime2);

        DeliveryStrategy defaultDeliveryStrategy = new DefaultDeliveryStrategy();
        double minTime1 = defaultDeliveryStrategy.calculateTotalTime(Arrays.asList(order1, order2), deliveryPersonLocation);
        System.out.println("Time to deliver using default delivery strategy : " + minTime1);

        DeliveryStrategy batchDeliveryStrategy = new BatchDeliveryStrategy();
        double minTime2 = batchDeliveryStrategy.calculateTotalTime(Arrays.asList(order1, order2), deliveryPersonLocation);
        System.out.println("Time to deliver using batch delivery strategy : " + minTime2);

        System.out.println("\nMinimum time to deliver both orders : " + Math.min(minTime1, minTime2));
    }
}