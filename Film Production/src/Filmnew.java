import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Filmnew {

	static String text;
   static  String prevtag;
   
    static int c=0;
	static ArrayList<Feed> feed = new ArrayList<Feed>();;
	static Feed f;

	
	public static void main(String[] args) throws XmlPullParserException, IOException
	{
		
		  try {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		
		 factory.setNamespaceAware(true);
         XmlPullParser xpp = factory.newPullParser();
         
         File xmlFile = new File("emp.xml");
         FileInputStream fis = new FileInputStream(xmlFile);
         xpp.setInput(fis, null);
        // xpp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
         int eventType=xpp.getEventType();
         xpp.nextTag();
         while (eventType!= XmlPullParser.END_DOCUMENT) {
             String name = xpp.getName();
             
             if(name!=null)
             {
            	 //System.out.println(xpp.getName() + " : " +xpp.getDepth());
             }
            	
        		 switch (eventType) {
                 case XmlPullParser.START_TAG:
                     if (name.equalsIgnoreCase("item")) {
                    	 System.out.println("<item>");                	
                    	f = new Feed();
                    	 
                     }	
                     
                     if (name.equalsIgnoreCase("id")) {
                    	 if (xpp.getDepth()<3) {
                    		 
                    		 eventType = xpp.next();
                    		 continue;	
						}
                    	System.out.print("<id>");                	                    	
                     }
                     
                     if (name.equalsIgnoreCase("name")) {
                    	 if (xpp.getDepth()<3) {
                    		 
                    		 eventType = xpp.next();
                    		 continue;	
						}
                    	System.out.print("<name>");                	                    	
                     }
      
                     break;
  
                 case XmlPullParser.TEXT:
                     text = xpp.getText();
                     break;
  
                 case XmlPullParser.END_TAG:
                	 if (name.equalsIgnoreCase("item")) {
                    	 System.out.println("</item>");
                    	feed.add(f);
                     } 
                	 
                	 if (name.equalsIgnoreCase("id")) {
                		 
                		 	if (xpp.getDepth()<3) {
                    		 eventType = xpp.next();
                    		 continue;
						}
                    	 System.out.println(text + "</id>");
                    	 f.setId(text);
                     }
                	 
                	 if (name.equalsIgnoreCase("name")) {
                		 
             		 	if (xpp.getDepth()<3) {
                 		 eventType = xpp.next();
                 		 continue;
						}
             		 	
                 	 System.out.println(text + "</name>");
                 	 f.setId(text);
                  }
                	 
                	 
                	 break;
                	 
                 default:
                     break;
               
                     
                     
        		 		} // end of switch
            	  
              
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

