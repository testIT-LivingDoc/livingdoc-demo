import info.novatec.testit.livingdoc.report.XmlReport;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        DocumentBuilderFactory documentFactoryBuilder = DocumentBuilderFactory.newInstance();
        System.out.println("#### " + documentFactoryBuilder.getClass().getName());
        // Fail: org.apache.xerces.jaxp.DocumentBuilderFactoryImpl
        //   OK: com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
        try {
            XmlReport xmlReport = XmlReport.parse(new File("src\\Confluence_LD_Update order_report.xml").getAbsolutePath());
            System.out.println("#### " + xmlReport.getName());

        } catch (SAXException |IOException e) {
            e.printStackTrace();
            System.out.println("#### ERROR" + e.getMessage());
        }

        System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        documentFactoryBuilder = DocumentBuilderFactory.newInstance();
        System.out.println("#### " + documentFactoryBuilder.getClass().getName());

        try {
            XmlReport xmlReport = XmlReport.parse(new File("src\\Confluence_LD_Update order_report.xml"));
            System.out.println("#### " + xmlReport.getName());
        } catch (SAXException|IOException e) {
            e.printStackTrace();
            System.out.println("#### ERROR" + e.getMessage());
        }
    }
}
