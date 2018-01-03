package tw.gov.cwb.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "weatherElement")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
	@JsonCreator
	public Weather() {}
	
	@JacksonXmlProperty(localName = "elementName")
	private String name;

	@JacksonXmlProperty(localName = "time")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Time[] time;

 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time[] getTime() {
		return time;
	}

	public void setTime(Time[] time) {
		this.time = time;
	}
	
	
	
}
