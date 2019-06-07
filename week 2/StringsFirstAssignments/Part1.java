
/**
 *  
 * @author (Sajal Sirohi) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna)
    {
        String result = "";
        int taa = -1 ;
        int ata = dna.indexOf("ATG");
        if (ata == -1){
            result = "";
        }
        else {
        taa = dna.indexOf("TAA",ata);
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
        String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println(" DNA string : " + dna1 + " DNA Gene : " + findSimpleGene(dna1));
        
        String dna2 = "ATGCCGGGCGGGACT";
        System.out.println(" DNA string : " + dna2 + " DNA Gene : " + findSimpleGene(dna2));
        
        String dna3 = "ATCCCGGGCGGGTAGA";
        System.out.println(" DNA string : " + dna3 + " DNA Gene : " + findSimpleGene(dna3));
        
        String dna4 = "ATGCCGGGCGGGTAA";
        System.out.println(" DNA string : " + dna4 + " DNA Gene : " + findSimpleGene(dna4));
        
        String dna5 = "ATCCCGGGCGGGTGGATAA";
        System.out.println(" DNA string : " + dna5 + " DNA Gene : " + findSimpleGene(dna5));
    }
    
}
