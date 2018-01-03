package tw.gov.cwb.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeatherTest extends BaseModelTest{
	 

	@Test
	public void testWeathrtConvert() throws Exception {  	 
		basicConvertTest("/F-C0032-003-wether-element.xml", Weather.class);
	}
	
}
