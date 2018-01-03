package tw.gov.cwb.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CwbOpenDataTest  extends BaseModelTest{
	 

	@Test
	@Ignore
	public void testOpenDataConvert() throws Exception {  	 
		basicConvertTest("/F-C0032-003.xml", CwbOpenData.class);
	}
	
	
	@Test
	public void testOpenDataConvert2() throws Exception {  	 
		basicConvertTest("/F-D0047-071.xml", CwbOpenData.class);
	}
	
}