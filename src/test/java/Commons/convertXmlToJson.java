package test.java.Commons;



import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class convertXmlToJson {

    public static int INDENTATION = 4;

    public String readXmlFile() {

        BufferedReader br = null;
        FileReader fr = null;
        StringBuffer testResultData = new StringBuffer();

        try {
            fr = new FileReader("E:/demo/DemoTNG/DemoTNG/DemoTNG/test-output/testng-results.xml");
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                testResultData.append(sCurrentLine + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return String.valueOf(testResultData);
    }

    public void convertXmlFileDataToJson(String xmlData){
        try {
            JSONObject jsonObj = XML.toJSONObject(xmlData);
            String json = jsonObj.toString(INDENTATION);

            System.out.println("=============================================================================================");
            System.out.println(json);
            System.out.println("=============================================================================================");

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        convertXmlToJson convertXmlToJson=new convertXmlToJson();
        convertXmlToJson.convertXmlFileDataToJson(convertXmlToJson.readXmlFile());
    }

}
