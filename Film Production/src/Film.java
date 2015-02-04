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
          
          switch (eventType) {
          
          case XmlPullParser.START_TAG:
              if (tagname.equalsIgnoreCase("item")) {
                  System.out.println("This is the item tag : " +text);
              }
              break;

          case XmlPullParser.TEXT:
              text = xpp.getText();
              break;

          case XmlPullParser.END_TAG:
        	  
              if (tagname.equalsIgnoreCase("item")) {
            	  
                  System.out.println("This is item end tag " +text);

              } else if (tagname.equalsIgnoreCase("title")) {
            	  
                  System.out.println("This is title tag " +text);
            	  
              
            	  
              } else if (tagname.equalsIgnoreCase("link")) {
            	  
                  System.out.println("This is link tag " +text);

            	  
              } else if (tagname.equalsIgnoreCase("pubDate")) {
            	  
                  System.out.println("This is pubDate tag " +text);

            	  
              } 
              
              else if (tagname.equalsIgnoreCase("description")) {
            	  
                  System.out.println("This is employee type tag " +text);
                  
//                   org.jsoup.nodes.Document docHtml = Jsoup.parse(text);
//                   org.jsoup.select.Elements imgEle = docHtml.select("img");
//                   System.out.println((imgEle).attr("abs:src"));
                  
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
