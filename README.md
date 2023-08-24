# GeoAPIWrapper
Java Wrapper for GEO IP API

## How to Use the GeoAPIWrapper?

### Adding Dependency

To use the GeoAPIWrapper in your Java project, you need to add the dependency to your project's configuration file (e.g., `pom.xml` if you're using Maven).

1. Add the JitPack repository to your project's repositories section:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

2. Add the GeoAPIWrapper dependency to your project's dependencies section:

```xml
<dependencies>
    <dependency>
        <groupId>com.github.Waterbroodje</groupId>
        <artifactId>GeoAPIWrapper</artifactId>
        <version>382793fff8</version>
    </dependency>
</dependencies>
```

### Using the GeoAPIWrapper

Here's an example of how to use the GeoAPIWrapper to perform a GEO IP lookup:

```java
import com.google.gson.JsonObject;
import com.github.waterbroodje.geoapiwrapper.GeoAPIWrapper;
import com.github.waterbroodje.geoapiwrapper.GeoLocationInfo;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String apiKey = "your_api_key_here";
        String ipAddress = "ip_address"; // Replace with the IP address you want to look up

        GeoAPIWrapper apiWrapper = new GeoAPIWrapper(apiKey);

        try {
            GeoLocationInfo geoLocationInfo = apiWrapper.lookupIP(ipAddress);

            // Accessing various information using the GeoLocationInfo object
            String countryName = geoLocationInfo.getCountryName();
            String countryCode = geoLocationInfo.getCountryCode();
            String flagSvgUrl = geoLocationInfo.getFlagSvgUrl();
            String officialName = geoLocationInfo.getOfficialName();
            // ... (Access other information)

            // Printing the obtained information
            System.out.println("Country Name: " + countryName);
            System.out.println("Country Code: " + countryCode);
            System.out.println("Flag SVG URL: " + flagSvgUrl);
            System.out.println("Official Name: " + officialName);
            // ... (Print other information)
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error fetching data from API.");
        }
    }
}
```

### Note

Please replace `"your_api_key_here"` with your actual API key, you can get this at https://portal.thatapicompany.com/keys. This example demonstrates how to perform a GEO IP lookup using the GeoAPIWrapper and access various information using the `GeoLocationInfo` object.

For more detailed documentation on the available methods and functionality of the GeoAPIWrapper, you can refer to the class documentation and comments provided in the code.

Remember to handle exceptions appropriately in your application code to ensure a smooth user experience even in case of errors during API calls.
