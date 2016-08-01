package address;

import org.testng.annotations.Test;
import static commonUtils.Utils.takescreenshot;
import static commonUtils.Utils.Compare;

import runthis.setup;

import static commonUtils.Utils.Crop;
//import static uiCases.Feedpage.takescreenshot;

import java.io.IOException;

public class AddHomeAddress extends setup {
	
	@Test
	public void add_address() throws IOException
	{
		System.out.println("add_address");
		String function = new Object(){}.getClass().getEnclosingMethod().getName();
		takescreenshot(function);
		Crop(720,186,0,708);
		System.out.println("Croped");
		Compare(function);
        
        
		
		
		}
	
	
	
	

}
