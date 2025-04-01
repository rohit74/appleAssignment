import java.util.concurrent.ConcurrentHashMap;

public class ForecastService {
    private static final long CACHE_DURATION_MS = 30 * 60 * 1000;
    private final ConcurrentHashMap<String, CacheEntry> cache = new ConcurrentHashMap<>();

    public String getForecast(String zipCode) {
        long now = System.currentTimeMillis();

        // Check cache
        if (cache.containsKey(zipCode)) {
            CacheEntry entry = cache.get(zipCode);
            if (now - entry.getTimestamp() < CACHE_DURATION_MS) {
                System.out.println("[CACHE] Forecast from cache:");
                return entry.getForecast();
            }
        }

        // If not cached or expired
        String forecast = fetchForecastFromAPI(zipCode);
        cache.put(zipCode, new CacheEntry(forecast, now));
        return forecast;
    }

    private String fetchForecastFromAPI(String zipCode) {
        // Replace with real API call using OpenWeatherMap or similar
        return "Current: 70°F, High: 75°F, Low: 65°F (mock)";
    }
}
