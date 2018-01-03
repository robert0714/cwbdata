package tw.gov.cwb.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
 
import org.junit.After;
import org.junit.Before;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
 

public class BaseModelTest {
	protected  ObjectMapper mapper;
	protected  XmlMapper xmlMapper;

	boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

	@Before
	public void setUp() throws Exception { 
		JacksonXmlModule module = new JacksonXmlModule();
		module.setDefaultUseWrapper(false);
		this.xmlMapper = new XmlMapper(module);
		// this.xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
		this.mapper= new ObjectMapper();
	} 

	@After
	public void tearDown() throws Exception {
	}
	
	protected String readResourceAsString(String resource) throws IOException, URISyntaxException {
		String result = new String(Files.readAllBytes(Paths.get(getClass().getResource(resource).toURI())),
				java.nio.charset.StandardCharsets.UTF_8);
		return result;
	}

	protected void basicConvertTest(final String resource, final Class<?> clazz) throws Exception {
		String xml = readResourceAsString(resource);
		Object object = this.xmlMapper.readValue(xml, clazz);

		String covertedXml = this.xmlMapper.writeValueAsString(object);
		String covertedJson = this.mapper.writeValueAsString(object);
		System.out.println(covertedXml);
		System.out.println(covertedJson);
	}
	

}
