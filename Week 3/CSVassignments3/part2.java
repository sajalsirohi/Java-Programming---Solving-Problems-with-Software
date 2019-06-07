
/**
 * Write a description of part2 here.
 * 
 * @author (sajal) 
 * @version (a version number or a date)
 */
import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.*;

public class part2 {
    public CSVRecord coldesthour(CSVParser pr){
    
        CSVRecord coldest = null;
        for(CSVRecord current : pr)
        {
            if(coldest == null) coldest = current;
            else {
                double currenttemp = Double.parseDouble(current.get("TemperatureF"));
                double coldesttemp = Double.parseDouble(coldest.get("TemperatureF"));
                if(currenttemp < coldesttemp && currenttemp != -9999){
                    coldest = current;}
                }
        }
        return coldest;
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        double lowest = 0;
        double current = 0;
        for (CSVRecord record: parser) {
            if (lowestSoFar == null) lowestSoFar = record;
            if (record.get("Humidity").equals("N/A")) {current = -999;}
            else {current = Double.parseDouble(record.get("Humidity"));}
            
            if (lowestSoFar.get("Humidity").equals("N/A")) {lowest = -999;}
            else {lowest = Double.parseDouble(lowestSoFar.get("Humidity"));}
            
            if (current < lowest && current != -999) lowestSoFar = record;
        }
        return lowestSoFar;
    }
    public String fileWithColdestTemperature(){
        CSVRecord coldest = null;
        String result = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = coldesthour(fr.getCSVParser());
            if (coldest == null) coldest = current;
            else{
                double currenttemp = Double.parseDouble(current.get("TemperatureF"));
                double coldesttemp = Double.parseDouble(coldest.get("TemperatureF"));
                if (currenttemp < coldesttemp) 
                {
                    coldest = current;
                    result = f.getName();
                }
            }
        }
        return result;
    }

    public void testFileWithColdestTemperature() {
        String file = fileWithColdestTemperature();
        System.out.print("Coldest day was in file ");
        System.out.println(file);
        FileResource fr = new FileResource(file);
        CSVRecord coldest = coldesthour(fr.getCSVParser());
        System.out.print("The coldest temperature on that way was ");
        System.out.println(coldest.get("TemperatureF"));
        System.out.println("All the temperatures on the coldest day were");
        for (CSVRecord record:fr.getCSVParser()) {
            System.out.print(record.get("DateUTC"));
            System.out.print(" ");
            System.out.println(record.get("TemperatureF"));
        }
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVRecord result = lowestHumidityInFile(fr.getCSVParser());
        System.out.print("Lowest Humidity was ");
        System.out.print(result.get("Humidity"));
        System.out.print(" at ");
        System.out.println(result.get("DateUTC"));
    }        
        
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord coldest = coldesthour(fr.getCSVParser());
        System.out.println("Coldest temp ; " + coldest.get("TemperatureF"));
    }
    public String lowestHumidityInManyFiles() {
        DirectoryResource dr =  new DirectoryResource();
        CSVRecord lowest = null;
        String filename = null;
        for (File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
            if (lowest == null) lowest = current;
            double currentHum = Double.parseDouble(current.get("Humidity"));
            double lowestHum = Double.parseDouble(lowest.get("Humidity"));
            if (currentHum < lowestHum) {
                lowest = current;
                filename = f.getName();
            }
        }
        return filename;
    }
    
    public void testLowestHumidityInManyFile() {
        String filename = lowestHumidityInManyFiles();
        System.out.print("Day with lowest humidity was in file ");
        System.out.println(filename);
        FileResource fr = new FileResource();
        CSVRecord lowest = lowestHumidityInFile(fr.getCSVParser());
        System.out.print("Lowest Humidity was ");
        System.out.print(lowest.get("Humidity"));
        System.out.print(" at ");
        System.out.println(lowest.get("DateUTC"));
    }
  
  public double TemperatureInFile(CSVParser parser) {
        double sum = 0;
        int number = 0;
        for (CSVRecord record:parser) {
            double current = Double.parseDouble(record.get("TemperatureF"));
            sum = sum + current;
            number = number + 1;
        }
        sum = sum / number;
        return sum;
    }
    
    public void testTemperatureInFile() {
        FileResource fr = new FileResource();
        double average = TemperatureInFile(fr.getCSVParser());
        System.out.print("Average temperature in file is ");
        System.out.println(average);
    }
    

  public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double sum = 0;
        double number = 0;
        double humidity = 0;
        for (CSVRecord record: parser) {
            if (record.get("Humidity").equals("N/A")) humidity = -999;
            else humidity = Double.parseDouble(record.get("Humidity"));
            if (humidity >= value) {
                number = number + 1;
                sum = sum + Double.parseDouble(record.get("TemperatureF"));
            }
        }
       
        return sum/number;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        double average = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
        if (average == 0) System.out.println("No temperatures with that humidity");
        else {
            System.out.print("Average temperature with high Humidity is ");
            System.out.println(average);
        }
    }
        
}
