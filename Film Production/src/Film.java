import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
public class Film {

	static String text;
	static String currentTag;
	
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
  
          
          switch (eventType) {
          
          case XmlPullParser.START_DOCUMENT:

        	  System.out.println("Start Document");
        	  
        	  
        	  break;
        	  
          case XmlPullParser.START_TAG:

        	 
        	  
        	   currentTag = xpp.getName();
        	   
          if (currentTag.equalsIgnoreCase("item")) {
          
        	  System.out.println("Yes, this is item tag");
          } else if (currentTag != null) {
        	  
         
          
          if (currentTag.equalsIgnoreCase("title")) {
       
        	  System.out.println("Title tag comes here" + xpp.getText());
        	  
          } else if (currentTag.equalsIgnoreCase("description")) {
          
         	  System.out.println("Description tag comes here");
         	  
          } else if (currentTag.equalsIgnoreCase("link")) {
          
         	  System.out.println("Link tag comes here");
          }
          }
          break;
          case XmlPullParser.END_TAG:
          currentTag = xpp.getName();
          if (currentTag.equalsIgnoreCase("item")) {
          
         	  System.out.println("End of item tag");
          }
          break;
          } // end of while loop

          
  			eventType = xpp.next();
         }
         
     } // end of try 
		  
		  catch (XmlPullParserException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
 }
}
