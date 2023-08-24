import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GeoLocationInfo {

    private final JsonObject data;

    public GeoLocationInfo(JsonObject data) {
        this.data = data;
    }

    public String getCountryName() {
        return getString("country", "name");
    }

    public String getCountryCode() {
        return getString("country", "code");
    }

    public String getFlagSvgUrl() {
        return getString("country", "flag_urls", "svg");
    }

    public String getFlagPngUrl() {
        return getString("country", "flag_urls", "png");
    }

    public String getOfficialName() {
        return getString("country", "official_name");
    }

    public String getIso3() {
        return getString("country", "iso_3");
    }

    public String getDialingCode() {
        return getString("country", "dialing_code");
    }

    public String getCurrencyName() {
        return getString("country", "currency", "name");
    }

    public String getCurrencyCode() {
        return getString("country", "currency", "code");
    }

    public String getCurrencySymbol() {
        return getString("country", "currency", "symbol");
    }

    public String getEmojiSymbol() {
        return getString("country", "emoji", "symbol");
    }

    public String getTourismSlogan() {
        return getString("country", "tourism_slogan");
    }

    public String getRegion() {
        return getString("locationInfo", "region");
    }

    public String getPostalCode() {
        return getString("locationInfo", "postal_code");
    }

    public String getCity() {
        return getString("locationInfo", "city");
    }

    public String getCountryCodePortable() {
        return getString("portable", "country_code");
    }

    public String getRegionPortable() {
        return getString("portable", "region");
    }

    public String getPostalCodePortable() {
        return getString("portable", "postal_code");
    }

    public String getAdminArea1() {
        return getString("portable", "admin_area_1");
    }

    public String getTimeZoneName() {
        return getString("portable", "timezone", "name");
    }

    public String getTimeZoneAlias() {
        return getString("portable", "timezone", "alias_of");
    }

    public int getUtcOffset() {
        return getInt("portable", "timezone", "utc_offset");
    }

    public String getUtcOffsetStr() {
        return getString("portable", "timezone", "utc_offsetStr");
    }

    public int getDstOffset() {
        return getInt("portable", "timezone", "dst_offset");
    }

    public String getDstOffsetStr() {
        return getString("portable", "timezone", "dst_offsetStr");
    }

    public String getCurrentTime() {
        return getString("portable", "timezone", "current_time");
    }

    private JsonElement getElement(String... keys) {
        JsonObject currentObject = data;
        for (String key : keys) {
            if (currentObject.has(key)) {
                JsonElement element = currentObject.get(key);
                if (element.isJsonObject()) {
                    currentObject = element.getAsJsonObject();
                } else {
                    return element;
                }
            } else {
                throw new IllegalArgumentException("JSON element not found for key: " + key);
            }
        }
        return currentObject;
    }

    private String getString(String... keys) {
        JsonElement element = getElement(keys);
        if (element.isJsonPrimitive()) {
            return element.getAsString();
        } else {
            throw new IllegalArgumentException("JSON primitive not found for key: " + keys[keys.length - 1]);
        }
    }

    private int getInt(String... keys) {
        JsonElement element = getElement(keys);
        if (element.isJsonPrimitive()) {
            return element.getAsInt();
        } else {
            throw new IllegalArgumentException("JSON primitive not found for key: " + keys[keys.length - 1]);
        }
    }
}