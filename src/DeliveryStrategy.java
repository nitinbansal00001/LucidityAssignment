import java.util.List;

public interface DeliveryStrategy {
    double calculateTotalTime(List<Order> orders, Location deliveryPersonLocation);
    default double findDistance(Location location1, Location location2) {
        double lat1 = location1.getLatitude();
        double lon1 = location1.getLongitude();
        double lat2 = location2.getLatitude();
        double lon2 = location2.getLongitude();

        double latitudeDiff = Math.toRadians(lat2 - lat1);
        double longitudeDiff = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double x = Math.pow(Math.sin(latitudeDiff/2), 2) + (Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(longitudeDiff/2), 2));
        double rad = 6371;
        double c = Math.asin(Math.sqrt(x));
        return 2 * rad * c;
    }
}
