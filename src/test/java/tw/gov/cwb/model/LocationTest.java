package tw.gov.cwb.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocationTest  extends BaseModelTest{
	 

	@Test
	public void testTimeConvert() throws Exception {  	 
		basicConvertTest("/F-C0032-003-location.xml", Location.class);
	}

}

