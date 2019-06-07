
/**
 * Write a description of part1 here.
 * 
 * @author (sajal) 
 * @version (3 june 2019)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class part1 {
    public void test()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryinfo(parser,"Nauru"));
        //listExportersTwoProducts(parser,"cotton","flowers");
        //System.out.println("Number of countries : " + numberofexporters(parser,"cocoa"));
        bigexporters(parser,"$999,999,999,999.");
    }
    
    public String countryinfo(CSVParser parser, String country) {
        String result = "";
        for (CSVRecord record : parser) {
            if (record.get("Country").equals(country)) {
               result = record.get("Country");
               result = result.concat(": ");
               result = result.concat(record.get("Exports"));
               result = result.concat(": ");
               result = result.concat(record.get("Value (dollars)"));
            }
        }
        if (result == "") {
           return "NOT FOUND";
        }
        else {
           return result;
        }
    }

public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String testRecord = record.get("Exports");
            if (testRecord.contains(exportItem1) && testRecord.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }
public int numberofexporters(CSVParser pr, String exportitem) { 
    int count=0;
    for(CSVRecord record : pr)
    {
        String countrydata = record.get("Exports");
        if (countrydata.contains(exportitem)){count+=1;}
    }
    return count;
}
public void bigexporters(CSVParser pr, String amount){
    for(CSVRecord record : pr)
    {
        String countrydata = record.get("Value (dollars)");
        if (countrydata.length() > amount.length())
        {
            System.out.println(record.get("Country") + " " + countrydata);
        }
    }
    
}
}
