package common;

import java.io.FileInputStream;
import java.util.Properties;

public class ExtractionProperties {
	
    private static final String Path = ".\\src\\main\\java\\common\\config.properties";

    private Properties property;

	public ExtractionProperties() {
		property = new Properties();
	    try {
	        FileInputStream file = new FileInputStream(Path);
	        property.load(file);
	    }
	    catch (Exception e) {
	        throw new IllegalAccessError();
	    }
	}
	


	public String getChromeBrowser() {
		return property.getProperty("ChromeBrowser");
	}

	public String getFirefoxBrowser() {
		return property.getProperty("FirefoxBrowser");
	}
	
	public String getHomepage() {
		return property.getProperty("homeUrl");
	}
	public String getcompanyUrl() {
		return property.getProperty("companyUrl");
	}
	
	public String getjoinUsUrl() {
		return property.getProperty("joinUsUrl");
	}
	
	public String getfacebookUrl() {
		return property.getProperty("facebookUrl");
	}

}
