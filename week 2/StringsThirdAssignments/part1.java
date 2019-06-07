
/**
 * Write a description of part1 here.
 * 
 * @author (shri Sajal) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class part1 {
    public int findStopCodon(String dna, int startindex, String stopcodon)
 {
     int stopindex = dna.indexOf(stopcodon,startindex+1);
     while (stopindex != -1){
         if ((stopindex - startindex) % 3 != 0){
             stopindex = dna.indexOf(stopcodon, stopindex+1);
            }
         else {
             return stopindex;
         }    
     }
     return dna.length();
    }

 public String findGene(String dna, int where)
 {
     String result;
     int indexatg = dna.indexOf("ATG",where);
     if (indexatg == -1){
         return "";
     }
     
     int taastop = findStopCodon(dna,indexatg,"TAA");
     int tagstop = findStopCodon(dna,indexatg,"TAG");
     int tgastop = findStopCodon(dna,indexatg,"TGA");
     int temp = Math.min(taastop,tagstop);
     int minindex = Math.min(temp, tgastop);
     if ( minindex == dna.length()) return "";
     else return dna.substring(indexatg,minindex+3);
    }
 public void  testFindStopCodon()
 {
     System.out.println("Result : " + findStopCodon("ATGGTATTATAA",0,"TQA"));
    }
 public void printgenes(String dna)
 {
     int startindex = 0;
     while ( true ) {
         String result = findGene(dna,startindex);
         if (result == "") break;
         System.out.println("Gene Found : " + result);
         startindex = dna.indexOf(result) + result.length();
        }
    }
    public StorageResource getallgenes(String dna)
 {
     int startindex = 0;
     StorageResource result_data = new StorageResource();
     while ( true ) {
         //System.out.println(dna);
         String result = findGene(dna,startindex);
         //System.out.println("Gene result : " + result);
         if (result == "") break;
         result_data.add(result);
         startindex = dna.indexOf(result) + result.length();
         }
         //for (String s : result_data.data())
        //{
          //  System.out.println("gene detected : " + s);
        // }
         return result_data;
         
}
   public double cgratio(String dna){
     int index_c = dna.indexOf("C");
     int index_g = dna.indexOf("G");
     double ccount = 0;
     double gcount = 0;
     int temp=0;
     double result = 0;
     while(index_c != -1)
     {
         ccount+=1;
         temp = index_c+1;
         index_c = dna.indexOf("C",temp);
     }
     while(index_g != -1)
     {
         gcount+=1;
         temp = index_g+1;
         index_g = dna.indexOf("G",temp);
     }
     System.out.println("C length : " + ccount + " G length : " + gcount);
     return ((ccount+gcount)/dna.length());
     
    }
    public int countctg(String dna)
    {
        int index_ctg = dna.indexOf("CTG");
        int ccount = 0;
        int temp;
        while(index_ctg != -1)
     {
         ccount+=1;
         temp = index_ctg+1;
         index_ctg = dna.indexOf("CTG",temp);
     }
     return ccount;
    }
    public void processGenes(StorageResource sr)
    {
        int count = 0;
        int largest = 0;
        
        for (String s : sr.data())
        {
            if (s.length() > 60)
            {
                System.out.println(" Gene Size greater then 9 : " + s);
                count+=1;
            }
        }
        System.out.println("Number of Genes greater then 9 : " + count);
        
        count = 0;
        for (String s : sr.data())
        {
            if (countctg(s) > 0.35)
            {
                System.out.println(" Gene cgratio greater then 0.35 " + s);
                count+=1;
            }
            if (s.length() > largest)
            {
                largest = s.length();
            }
        }
        System.out.println(" Number of gene having cgratio greater then 0.35 " + count);
        System.out.println("Largest gene size : " + largest);

    }
    public void testprocessgenes()
    {
        FileResource fr = new FileResource("brca1.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        StorageResource sr = new StorageResource();
        
        sr = getallgenes(dna);
        processGenes(sr);
        System.out.println("Length of the dna : " + dna.length());
    }
 public void test(){
     printgenes("AATGCTAACTAGCTGACTAATATGTAA");
     System.out.println(cgratio("ATGCCATAG"));
    }

}
