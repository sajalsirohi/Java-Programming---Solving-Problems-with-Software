
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part3 {
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
     int count = 0;
     while ( true ) {
         String result = findGene(dna,startindex);
         if (result == "") break;
         System.out.println("Gene Found : " + result);
         startindex = dna.indexOf(result) + result.length();
        }
    }
    public int countgenes(String dna)
    {
     int startindex = 0;
     int count = 0;
     while ( true ) {
         String result = findGene(dna,startindex);
         if (result == "") break;
         count++;
         startindex = dna.indexOf(result) + result.length();
        }
        return count;
    }
 public void test(){
     String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGAATGTAA";
     printgenes(dna);
     System.out.println("Number of Genes : " + countgenes(dna));
    }
}
