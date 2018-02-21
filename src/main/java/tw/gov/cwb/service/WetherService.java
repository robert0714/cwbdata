package tw.gov.cwb.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
 
import tw.gov.cwb.model.CwbOpenData;

@Component
public class WetherService {
	
	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(WetherService.class);
	private RestTemplate restTemplate;
	private XmlMapper xmlMapper;
	protected  ObjectMapper mapper;
	private String resource = "http://opendata.cwb.gov.tw/opendataapi?dataid=F-C0032-001&authorizationkey=CWB-F85F7030-762F-4B20-B961-6F1EF7DEEF5A";

	// F-C0032-001,F-C0032-005
	public WetherService() {
		super();
		JacksonXmlModule module = new JacksonXmlModule();
		module.setDefaultUseWrapper(false);
		this.xmlMapper = new XmlMapper(module);
		this.mapper = new ObjectMapper();
		this.restTemplate = new RestTemplate();
	}

	public CwbOpenData retrieveData() {
		ResponseEntity<CwbOpenData> forEntity = restTemplate.getForEntity(resource, CwbOpenData.class);
		CwbOpenData result = forEntity.getBody();

		return result;
	}

	public CwbOpenData retrieveData(final String dataid) {
		final String templateUrl = "http://opendata.cwb.gov.tw/opendataapi?dataid=%s&authorizationkey=CWB-F85F7030-762F-4B20-B961-6F1EF7DEEF5A";
		final String url = String.format(templateUrl, dataid);
		final ResponseEntity<CwbOpenData> forEntity = restTemplate.getForEntity(url, CwbOpenData.class);
		final ResponseEntity<String> testData = restTemplate.getForEntity(url, String.class);
		final CwbOpenData result = forEntity.getBody();
		String xml = testData.getBody();

		try {
			Object object = this.xmlMapper.readValue(xml, CwbOpenData.class);
			String covertedXml = this.xmlMapper.writeValueAsString(object);
			String covertedJson = this.mapper.writeValueAsString(object);
			LOGGER.info(covertedJson);
			LOGGER.info(covertedXml);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		
		return result;
	}
}
