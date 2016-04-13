import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Element;
import java.io.File;
 
public class ReadXMLFile3 {
	public static void main(String[] args) {
    	try {
			// File file = new File("/Users/mkyong/staff.xml");
			File file = new File("staff-001.xml");
 		   	DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);
 
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
	
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName()); 
			if (doc.hasChildNodes()) {
				printNode(doc.getChildNodes());
			}
 
		} catch (Exception e) {
			System.out.println(e.getMessage());
 	   }
	}
	
	private static void printNode(NodeList nodeList) {
    	for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			
			if (tempNode.getNodeType() == Node.TEXT_NODE) {
				System.out.print("\t" + tempNode.getTextContent());
			} else {
				System.out.print(tempNode.getNodeName());				
			}
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				if (tempNode.hasChildNodes()) {
					printNode(tempNode.getChildNodes());
				}
			}			
		}
	}
	
	static String nodeType(short type) {
	    switch(type) {
	      case Node.ELEMENT_NODE:                return "Element";
	      case Node.DOCUMENT_TYPE_NODE:          return "Document type";
	      case Node.ENTITY_NODE:                 return "Entity";
	      case Node.ENTITY_REFERENCE_NODE:       return "Entity reference";
	      case Node.NOTATION_NODE:               return "Notation";
	      case Node.TEXT_NODE:                   return "Text";
	      case Node.COMMENT_NODE:                return "Comment";
	      case Node.CDATA_SECTION_NODE:          return "CDATA Section";
	      case Node.ATTRIBUTE_NODE:              return "Attribute";
	      case Node.PROCESSING_INSTRUCTION_NODE: return "Attribute";
		}
		    return "Unidentified";
	}
}