public class Order {
    private final Location customerLocation;
    private final Location restaurantLocation;
    private final double preparationTime;

    public Order(Location customerLocation, Location restaurantLocation, double preparationTime) {
        this.customerLocation = customerLocation;
        this.restaurantLocation = restaurantLocation;
        this.preparationTime = preparationTime;
    }

    public Location getCustomerLocation() {
        return customerLocation;
    }

    public Location getRestaurantLocation() {
        return restaurantLocation;
    }

    public double getPreparationTime() {
        return preparationTime;
    }
}
