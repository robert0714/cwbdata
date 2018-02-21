package tw.gov.cwb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "location")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
	@JacksonXmlProperty(localName = "locationName")
	private String name;
	 
	
	@JacksonXmlProperty(localName = "weatherElement")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Weather[] weather;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}
 
	
	
}
