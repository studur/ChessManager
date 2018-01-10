package chess;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Cevtables {

   public Cevtables() {
   }

   public static void convertCsvToXml(String file) throws Exception {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder parser = factory.newDocumentBuilder();
      Document doc = parser.newDocument();
      Element table = doc.createElement("table");
      table.setAttribute("class", "tablecev");
      doc.appendChild(table);
      String csvfile = file + ".csv";
      String line = "";
      BufferedReader br = new BufferedReader(new FileReader(csvfile));
      int counter = 0;

      for (Element tbody = null; (line = br.readLine()) != null; ++counter) {
         String[] ligne = line.split(";");
         int i;
         if (counter != 0) {
            Element row = doc.createElement("tr");
            tbody.appendChild(row);

            for (i = 0; i < ligne.length; ++i) {
               Element td = doc.createElement("td");
               td.setTextContent(ligne[i]);
               row.appendChild(td);
            }
         } else {
            Element thead = doc.createElement("thead");
            table.appendChild(thead);

            for (i = 0; i < ligne.length; ++i) {
               Element th = doc.createElement("th");
               th.setTextContent(ligne[i]);
               thead.appendChild(th);
            }

            tbody = doc.createElement("tbody");
            table.appendChild(tbody);
         }
      }

      br.close();
      TransformerFactory tfact = TransformerFactory.newInstance();
      Transformer transformer = tfact.newTransformer();
      transformer.setOutputProperty("encoding", "ISO-8859-1");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
      transformer.setOutputProperty("indent", "yes");
      DOMSource source = new DOMSource(doc);
      String nouveau = file + ".xml";
      FileWriter fw = new FileWriter(nouveau);
      StreamResult result = new StreamResult(fw);
      transformer.transform(source, result);
      fw.close();
   }

}
