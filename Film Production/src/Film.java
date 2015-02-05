import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Film {

	static String text;
    private static final String ns = null;

	
	public static void main(String[] args) throws XmlPullParserException, IOException
	{
		  try {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		
		 factory.setNamespaceAware(true);
         XmlPullParser xpp = factory.newPullParser();
         
         File xmlFile = new File("employees.xml");
         FileInputStream fis = new FileInputStream(xmlFile);
         xpp.setInput(fis, null);
         xpp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
         xpp.nextTag();
         parse(fis);
         
          	
       
     } // end of try 
		  
		  catch (XmlPullParserException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
 }

	public static List parse(FileInputStream in)
	{
		return null;
		
		
	}

	private static Object readFeed(XmlPullParser xpp) {
		// TODO Auto-generated method stub
		return null;
	}


	private static void skip(XmlPullParser xpp) {
		// TODO Auto-generated method stub
		
	}


	private static void readEntry(XmlPullParser xpp) throws XmlPullParserException, IOException 
	{
		xpp.require(XmlPullParser.START_TAG, ns, "channel");

		 while (xpp.next() != XmlPullParser.END_TAG) {
       	  
        	 if (xpp.getEventType() != XmlPullParser.START_TAG) {
                 continue;
             }
 
        	  
        	  String tagname = xpp.getName();
        	  
        	  if (tagname.equals("entry")) {
                  readEntry(xpp);
              } else {
                  skip(xpp);
              }

	}
}

}