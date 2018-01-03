package tw.gov.cwb.model;
 
import org.junit.Test;
 
 

public class TimeTest extends BaseModelTest{
	 

	@Test
	public void testTimeConvert() throws Exception {  	 
		basicConvertTest("/F-C0032-003-time.xml", Time.class);
	}

}
