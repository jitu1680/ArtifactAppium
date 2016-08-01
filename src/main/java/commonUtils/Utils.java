package commonUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import static uiCases.Feedpage.takescreenshot;
//import static uiCases.Feedpage.filename;


import runthis.setup;


public class Utils extends setup{
	
	/*
	 * Taking screen shot	
	 */
	public static String filename;
	
	public static void takescreenshot(String name){
		{
		
			// This will get the name of the method
			//String name = new Object(){}.getClass().getEnclosingMethod().getName();
          
			
			// This will create an directory.
			
            new File("/Users/jitenderyadav/Desktop/Screenshot/").mkdirs(); // Insure directory is there
            filename = "/Users/jitenderyadav/Desktop/Screenshot/" +name + ".jpg";
            System.out.println(filename);
           
            
            // This will copy the screen shot and save to an folder with provided name      
      
            try {
               
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(filename), true);
                System.out.println("wrote");
                
                //Calling commonUtils "crop" function.
                
                
            } catch (Exception e) {
                System.out.println("Error capturing screen shot of "  + " test failure.");
           
           }
            
        }
		
	}
		
	
	/*
	 * Croping the image
	 */
	
	
	public static void Crop(int width, int height, int startX, int startY) throws IOException
	{
		String convert = "/opt/ImageMagick/bin/convert";
		
		String crop = "-crop"; 
	    
	    String cordinates = width+"X"+height+"+"+startX+"+"+startY;
	    
	    //String[] shellcomand = { convert,filename,crop,cordinates,filename };
	    String[] shellcomand ={convert, filename, crop,cordinates, filename};
	    System.out.println(cordinates);
	 
	    System.out.println(shellcomand);
	   
	  /*  
	 // Alternate way to initiate process
	 		Process p = Runtime.getRuntime().exec(shellcomand);
	 		try {
				p.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
	 		
		  
	    ProcessBuilder pb = new ProcessBuilder(shellcomand).redirectErrorStream(true);
		Process p = pb.start();
		
		
		//TODO fix this for multiple devices 
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null; 
		while ((line = reader.readLine()) != null)
		{			System.out.println("jitu"+line);

		}
	}
		
	
	/*
	 * comparing image
	 */
	
	
//	compare -metric AE $BASELINE $SCREENSHOT $DEVIATION
	
	public static void Compare(String name) throws IOException
	{
		int foo = 0;
		/*
		 * compare command list
		 */
		String compare = "/opt/ImageMagick/bin/compare";
		String crop = "-metric"; 
		String AE ="AE";
		String baseline ="/Users/jitenderyadav/Desktop/baseline/add_address.jpg";
		String screenshot = filename;
		String deviation ="/Users/jitenderyadav/Desktop/baseline/"+name+".jpg";
		
		
		/*
		 * remove file if not deviated
		 */
		
		String remove = "rm";
		String par ="-r";
		String path = deviation;
		
		String[]remove_pass_file ={remove,par,path};
		
		
	    
	   String[] shellcomand ={compare, crop, AE,baseline, screenshot, deviation};
	   
	 
	    System.out.println(shellcomand);
	  
	 		
		  
	    ProcessBuilder pb = new ProcessBuilder(shellcomand).redirectErrorStream(true);
		Process p = pb.start();	
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null; 
		while ((line = reader.readLine()) != null)
			// foo = Integer.parseInt(line);
		System.out.println(line);

	
		}
	
		
		
	}
	
	