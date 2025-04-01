public class CacheEntry {
    private final String forecast;
    private final long timestamp;

    public CacheEntry(String forecast, long timestamp) {
        this.forecast = forecast;
        this.timestamp = timestamp;
    }

    public String getForecast() {
        return forecast;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
