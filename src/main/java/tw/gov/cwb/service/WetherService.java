package tw.gov.cwb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
 
import tw.gov.cwb.model.CwbOpenData;

@Component
public class WetherService {
	private RestTemplate restTemplate;
	private XmlMapper xmlMapper;
	private String resource = "http://opendata.cwb.gov.tw/opendataapi?dataid=F-D0047-071&authorizationkey=CWB-F85F7030-762F-4B20-B961-6F1EF7DEEF5A";
	//一般天氣預報-七天天氣預報	F-C0032-003
	//新北市未來1週天氣預報 	F-D0047-071
	public WetherService() {
		super();
		JacksonXmlModule module = new JacksonXmlModule();
		module.setDefaultUseWrapper(false);
		this.xmlMapper = new XmlMapper(module);

		this.restTemplate = new RestTemplate();
	}

	public CwbOpenData retrieveData() {
		ResponseEntity<CwbOpenData> forEntity = restTemplate.getForEntity(resource, CwbOpenData.class);
		CwbOpenData result = forEntity.getBody();

		return result;
	}
}
