import java.util.List;

public class DefaultDeliveryStrategy implements DeliveryStrategy {

    private final double SPEED = 20; // Avg Speed = 20 km/hr

    @Override
    public double calculateTotalTime(List<Order> orders, Location deliveryPersonLocation) {
        Order order1 = orders.get(0);
        Order order2 = orders.get(1);

        double totalTime1 = getTotalTime(deliveryPersonLocation, order1, order2);
//        System.out.println("Time taken if order for customer C1 is delivered first : " + totalTime1);

        double totalTime2 = getTotalTime(deliveryPersonLocation, order2, order1);
//        System.out.println("Time taken if order for customer C2 is delivered first : " + totalTime2);

        return Math.min(totalTime1, totalTime2);
    }

    private double getTotalTime(Location deliveryPersonLocation, Order order1, Order order2) {
        double totalTimeToDeliver = 0;

        // Collect & deliver order1
        totalTimeToDeliver += Math.max(findDistance(deliveryPersonLocation, order1.getRestaurantLocation()) / SPEED * 60, order1.getPreparationTime());
        totalTimeToDeliver += findDistance(order1.getRestaurantLocation(), order1.getCustomerLocation()) / SPEED * 60;

        // Collect & deliver order2
        totalTimeToDeliver += findDistance(order1.getCustomerLocation(), order2.getRestaurantLocation()) / SPEED * 60;
        totalTimeToDeliver += Math.max(0, order2.getPreparationTime() - totalTimeToDeliver);
        totalTimeToDeliver += findDistance(order2.getRestaurantLocation(), order2.getCustomerLocation()) / SPEED * 60;

        return totalTimeToDeliver;
    }
}
