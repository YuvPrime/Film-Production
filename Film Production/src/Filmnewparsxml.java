import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Filmnewparsxml {

	static String text;
   static  String prevtag;
   
    static int c=0;
	static ArrayList<Feed> feed = new ArrayList<Feed>();;
	static Feed f;
	static int token;
	
	public static void main(String[] args) throws XmlPullParserException, IOException
	{
		
		  try {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		
		 //factory.setNamespaceAware(true);
         XmlPullParser xpp = factory.newPullParser();
         
         File xmlFile = new File("employees.xml");
         FileInputStream fis = new FileInputStream(xmlFile);
         xpp.setInput(fis, null);
         xpp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
         int eventType=xpp.getEventType();
         xpp.nextTag();
         while (eventType!= XmlPullParser.END_DOCUMENT) {
             String name = xpp.getName();
             
             if(name!=null)
             {
            	// System.out.println("Tag name : " +name + "and its depth : " +xpp.getDepth());
             }
            	
        		 switch (eventType) {
                 case XmlPullParser.START_TAG:
                     if (name.equalsIgnoreCase("item")) {
                    	 System.out.println("<item>");
                    	 
                    	 
                    	f = new Feed();
                    	 
                     }	
                     
                     if (name.equalsIgnoreCase("title")) {
                    	 if (xpp.getDepth()<4) {
                    		 
                    		 eventType = xpp.next();
                    		 continue;	
						}
                    	System.out.print("<title>");                	                    	
                     }
                     
                     if (name.equalsIgnoreCase("content:encoded")) {
                    	 if (xpp.getDepth()<4) {
                    		 
                    		 eventType = xpp.next();
                    		 continue;	
						}
                    	System.out.print("<content:encoded>");
                    	
                    //	System.out.println("yeh" + xpp.nextText());
                    	
                         //xpp.nextToken();
                         
                     }
      
                     break;
  
                 case XmlPullParser.TEXT:
                	 
                	 
                	 
                      
                     text = xpp.getText();
                         System.out.println("hoo " +xpp.getName() +text);
                     
                     break;
                     
                     
                 case XmlPullParser.CDSECT:
                	 System.out.println("yeah");
                	 
                	 break;
                     
  
                 case XmlPullParser.END_TAG:
                	 if (name.equalsIgnoreCase("item")) {
                    	 System.out.println("</item>");
                    	feed.add(f);
                     } 
                	 
                	 if (name.equalsIgnoreCase("title")) {
                		 
                		 	if (xpp.getDepth()<4) {
                    		 eventType = xpp.next();
                    		 continue;
						}
                    	 System.out.println(text + "</title>");
                    	 f.setId(text);
                     }
                	 
                	 if (name.equalsIgnoreCase("content:encoded")) {
                		 
             		 	if (xpp.getDepth()<4) {
                 		 eventType = xpp.next();
                 		 continue;
						}
             		 	
                 	 System.out.println(text + "</content:encoded>");
                 	 
					
                 	 
                 	 f.setName(text);
                  }
                	 
                	 
                	 break;
                	 
                 default:
                     break;
                                   
        	} // end of switch
            	  
              
        		 eventType = xpp.next();
        		 
         } // end of while loop
         
       
     }  
		  
		  catch (XmlPullParserException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
		  
		 
		  
//		  for (int i = 0; i < 2; i++) {
//			
//			  System.out.println(feed.get(i).getId());
//			  System.out.println(feed.get(i).getName());
//			  
//			  
//		}
		  
 }




}

