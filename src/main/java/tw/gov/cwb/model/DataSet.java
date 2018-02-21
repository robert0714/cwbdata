package tw.gov.cwb.model;
 
 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude; 
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "dataSet")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataSet {

	@JacksonXmlProperty(localName = "datasetInfo")
	private DataSetInfo info;
	
	@JacksonXmlProperty(localName = "location")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Location[] locations;

	public DataSetInfo getInfo() {
		return info;
	}

	public void setInfo(DataSetInfo info) {
		this.info = info;
	}

	public Location[] getLocations() {
		return locations;
	}

	public void setLocations(Location[] locations) {
		this.locations = locations;
	}
	
 
}
