import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Film {

	static String text;
	
	public static void main(String[] args) throws XmlPullParserException, IOException
	{
		  try {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		
		 factory.setNamespaceAware(true);
         XmlPullParser xpp = factory.newPullParser();
         
         File xmlFile = new File("employees.xml");
         FileInputStream fis = new FileInputStream(xmlFile);
         xpp.setInput(fis, null);
          int eventType = xpp.getEventType();
         while (eventType != XmlPullParser.END_DOCUMENT) {
        	 
          String tagname = xpp.getName();
          
  if (tagname!=null) {

	  if (xpp.getEventType() == XmlPullParser.START_TAG) {
         
	  
        if (tagname.equalsIgnoreCase("item")) 
        {
            System.out.println("This is the item tag : " +tagname);
        }
        
        
  	} // end of start tag check 

  			} // end of if null check	 
        	
  			eventType = xpp.next();
        
         } // end of while loop
         
     } // end of try 
		  
		  catch (XmlPullParserException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
 }
}
