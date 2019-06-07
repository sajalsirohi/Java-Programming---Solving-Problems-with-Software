
/**
 * Write a description of babyname here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.*;  
import java.io.*;

public class babyname {
    public void totalbirths(){
     FileResource fr = new FileResource();
     int totalnum = 0;
     int totalboys = 0;
     int totalgirls = 0;
     int namegirls = 0;
     int nametotal = 0;
     int nameboys = 0;
     for (CSVRecord curr : fr.getCSVParser(false)){
         int numborn = Integer.parseInt(curr.get(2));
         totalnum+=numborn;
         nametotal+=1;
         if (curr.get(1).equals("M")){
             totalboys+=numborn;
             nameboys+=1;
            }
            else{
                totalgirls+=numborn;
                namegirls+=1;
            }
        }
        System.out.println("Total Births = " + totalnum);
        System.out.println("Total Names = " + nametotal);
        System.out.println("Total Boys = " + totalboys);
        System.out.println("Total Names for boys = " + nameboys);
        System.out.println("Total Girls = " + totalgirls);
        System.out.println("Total Names for girls = " + namegirls);
        System.out.println(getrank(2012,"Sajal","F"));
            
        }
        public int getrank(int year, String name, String gender){
            String file = "yob"+ String.valueOf(year) + ".csv";
            FileResource fr = new FileResource(file);
            int rank = 0;
            if (gender.equals("F")){                
                for (CSVRecord curr : fr.getCSVParser(false)){
                    if(!curr.get(1).equals("M")){
                        rank+=1;
                        if (curr.get(0).equals(name)){
                            return rank;
                        }
                    }
                }
                return -1;
            }
            else{
                for (CSVRecord curr : fr.getCSVParser(false)){
                    if(curr.get(1).equals("M")){
                        rank+=1;
                        if (curr.get(0).equals(name))
                        {
                            return rank;
                        }
                    }
        }
        return -1;
    }
}
public String getname(int year, int rank, String gender){
    String file = "yob"+ String.valueOf(year) + ".csv";
      
    FileResource fr = new FileResource(file);
    int localrank = 0;
    if( gender.equals("F")){
        for (CSVRecord curr : fr.getCSVParser(false)){
            localrank+=1;
            if(localrank == rank){
                return curr.get(0);
            }
        }
        return "No Name";
    }
    else{
        for(CSVRecord curr : fr.getCSVParser(false)){
            if (curr.get(1).equals("M")){
                localrank+=1;
                if(localrank == rank){
                    return curr.get(0);
                }
            }
        }
        return "No Name";
    }
}                   
public void whatIsNameInYear(String name, int year, int newyear, String gender){
    int rankold = getrank(2012,name,gender);
    String newname = getname(2014,rankold,gender);
    System.out.println(name + " born in " +  String.valueOf(year) + " would be " + newname + " if she was born in " +  String.valueOf(newyear) + ".");
}
public void yearOfHighestRank(String name, String gender){
    DirectoryResource dr =  new DirectoryResource();
    int bestyear = 0;
    int lowest = 0;
    double totalfiles=0;
    double totalrank = 0;
    double avgrank = 0;
    for (File f: dr.selectedFiles()){
        totalfiles+=1;
        FileResource fr = new FileResource(f);
        String curryear = f.getName().replaceAll("[^0-9]", "");
        int curr_year = Integer.parseInt(curryear);
        int currrank = getrank(curr_year, name,gender);
        totalrank+=currrank;
        if (currrank != -1){
        if(lowest == 0)
        { lowest = currrank;
          bestyear = curr_year;
        }
        else{
            if(currrank < lowest){
                lowest = currrank;
                bestyear = curr_year;
            }
        }
    }}
    avgrank = totalrank/totalfiles;
    System.out.println("Best Rank for " + name + " is for year " + String.valueOf(bestyear) + " with rank of " + String.valueOf(lowest));
    System.out.println("Average Rank = " + avgrank);
    
}
public int getTotalBirthsRankedHigher(int year, String name, String gender){
    int localrank=1;
    int result = 0;
    int rank = getrank(year,name,gender);
    System.out.println(rank);
    String file = "yob"+year+".csv";
    FileResource fr = new FileResource(file);
    if (gender.equals("F")){
        for(CSVRecord curr : fr.getCSVParser(false)){
           if(localrank != rank){ 
               result += Integer.parseInt(curr.get(2));
               localrank+=1;
            }
        }
    }
    else{
        for(CSVRecord curr : fr.getCSVParser(false)){
            if(curr.get(1).equals("M")){
                if(localrank != rank){
                    result+=Integer.parseInt(curr.get(2));
                    localrank+=1;
                }
            }
        }
    }
    return result;
        
}
public void test(){
    //whatIsNameInYear("Isabella",2012,2014,"F");
    yearOfHighestRank("Robert","M");
    //System.out.println("Births ranked higher = " + getTotalBirthsRankedHigher(2012,"Ethan","M"));
}
}

