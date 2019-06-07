
/**
 *  
 * @author (Sajal Sirohi) 
 * @version (a version number or a date)
 */
import java.lang.*;

public class Part2 {
    public String findSimpleGene(String dna, String start, String stop)
    {
        
        boolean islower = false;
        boolean isupper = true;
        
        if( Character.isUpperCase(dna.charAt(0)) ) {
            start = start.toUpperCase();
            stop = stop.toUpperCase();
        } else {
            start = start.toLowerCase();
            stop = stop.toLowerCase();
        }
        String result = "";
        int taa = -1 ;
        int ata = dna.indexOf(start);
        if (ata == -1){
            result = "";
        }
        else {
        taa = dna.indexOf(stop,ata);
        if (taa == -1){
            result = "";
        }
    }
    if (taa > -1 && ata > -1){
        
    if ((taa - ata) % 3 == 0)
        {
            result= dna.substring(ata,taa+3);
        }
    else
        result = "";  
    }
    return result;
}
    public void testSimpleGene()
    {
        String dna1 = "ATCCCGGGCGGGTAA";
        System.out.println(" DNA string : " + dna1 + " DNA Gene : " + findSimpleGene(dna1, "ATG", "TAA"));
        
        String dna2 = "ATGCCGGGCGGGACT";
        System.out.println(" DNA string : " + dna2 + " DNA Gene : " + findSimpleGene(dna2, "ATG", "TAA"));
        
        String dna3 = "ATCCCGGGCGGGTAGA";
        System.out.println(" DNA string : " + dna3 + " DNA Gene : " + findSimpleGene(dna3, "ATG", "TAA"));
        
        String dna4 = "ATGCCGGGCGGGTAA";
        System.out.println(" DNA string : " + dna4 + " DNA Gene : " + findSimpleGene(dna4, "ATG", "TAA"));
        
        String dna5 = "ATCCCGGGCGGGTGGATAA";
        System.out.println(" DNA string : " + dna5 + " DNA Gene : " + findSimpleGene(dna5, "ATG", "TAA"));
    }
    
}
