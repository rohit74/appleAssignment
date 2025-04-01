import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GeoCodingService geoService = new GeoCodingService();
        ForecastService forecastService = new ForecastService();

        System.out.print("Enter an address: ");
        String address = scanner.nextLine();

        String zip = geoService.getZipCodeFromAddress(address);
        String forecast = forecastService.getForecast(zip);

        System.out.println("Forecast for ZIP " + zip + ": " + forecast);
    }
}
