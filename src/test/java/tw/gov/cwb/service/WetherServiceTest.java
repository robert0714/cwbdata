package tw.gov.cwb.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tw.gov.cwb.model.CwbOpenData;

public class WetherServiceTest {
	WetherService service ;
	@Before
	public void setUp() throws Exception {
		service =new WetherService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRetrieveData() throws Exception {
		CwbOpenData data = service.retrieveData();
		System.out.println(data);;
	}

}
