import java.util.List;

public class BatchDeliveryStrategy implements DeliveryStrategy {

    private final double SPEED = 20;

    @Override
    public double calculateTotalTime(List<Order> orders, Location deliveryPersonLocation) {
        Order order1 = orders.get(0);
        Order order2 = orders.get(1);

        double totalTime1 = getTotalTimeToDeliver(deliveryPersonLocation, order1, order2);
//        System.out.println("\nTime taken if order for pickup is order1 -> order2 : " + totalTime1);

        double totalTime2 = getTotalTimeToDeliver(deliveryPersonLocation, order2, order1);
//        System.out.println("Time taken if order for pickup is order2 -> order1 : " + totalTime2);

        return Math.min(totalTime1, totalTime2);
    }

    private double getTotalTimeToDeliver(Location deliveryPersonLocation, Order order1, Order order2) {
        double totalTimeToDeliver = 0;

        // Time taken for collection of orders
        totalTimeToDeliver = Math.max(findDistance(deliveryPersonLocation, order1.getRestaurantLocation()) / SPEED * 60, order1.getPreparationTime());

        totalTimeToDeliver += findDistance(order1.getRestaurantLocation(), order2.getRestaurantLocation()) / SPEED * 60;

        totalTimeToDeliver += Math.max(0, order2.getPreparationTime() - totalTimeToDeliver);

        // Time taken for delivery of orders
        totalTimeToDeliver += findDistance(order1.getCustomerLocation(), order2.getCustomerLocation()) / SPEED * 60;

        totalTimeToDeliver += Math.min(
                findDistance(order2.getRestaurantLocation(), order1.getCustomerLocation()) / SPEED * 60,
                findDistance(order2.getRestaurantLocation(), order2.getCustomerLocation()) / SPEED * 60
        );

        return totalTimeToDeliver;
    }
}
