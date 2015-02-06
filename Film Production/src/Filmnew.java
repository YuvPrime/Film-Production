import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Filmnew {

	static String text;
   
    static int c=0;
	
	public static void main(String[] args) throws XmlPullParserException, IOException
	{
		  try {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		
		 factory.setNamespaceAware(true);
         XmlPullParser xpp = factory.newPullParser();
         
         File xmlFile = new File("employees.xml");
         FileInputStream fis = new FileInputStream(xmlFile);
         xpp.setInput(fis, null);
        // xpp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
         int eventType=xpp.getEventType();
         xpp.nextTag();
         boolean correctSection = false;
         while (eventType!= XmlPullParser.END_DOCUMENT) {
             String name = xpp.getName();
           

       		 
        		 switch (eventType) {
                 case XmlPullParser.START_TAG:
                     if (name.equalsIgnoreCase("item")) {
                    	 System.out.println("This is item start tag");                	
                    	
                     }	 
      
                     break;
  
                 case XmlPullParser.TEXT:
                     text = xpp.getText();
                     break;
  
                 case XmlPullParser.END_TAG:
                	 if (name.equalsIgnoreCase("item")) {
                    	 System.out.println("This is item end tag");
                     }                	
                	 break;
                	 
                 default:
                     break;
               
      
         }
         
        		 eventType = xpp.next();
         }
         
       
     }  
		  
		  catch (XmlPullParserException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
 }



	


}

