
/**
 *  
 * @author (Sajal Sirohi) 
 * @version (a version number or a date)
 */
import java.lang.*;

public class Part3 {
    
    public boolean twoOccurrences( String stringa, String stringb){
        boolean result = false;
        int pos = 0;
        int pos2 = 0;
        pos = stringb.indexOf(stringa);
        System.out.println("First Found at : " + pos);
        if (pos != -1){
            pos2 = stringb.indexOf(stringa,pos+1);
            if ( pos2 != -1){
                result = true; 
            System.out.println("Second Found at : " + pos2);
        }
            else
            result = false;
        }
        else
        result = false;
        return result;
}

public String lastPart(String a, String b){
    int pos = 0;
    String result;
    pos = b.indexOf(a);
    if (pos == -1){
        result = b;}
    else{
        
        result = b.substring(pos, a.length()+2);
    }
    return result;
}

public void test()
{
    System.out.println("Last Part : " + lastPart( "zoo","forest"));   
    System.out.println("Two Ocurrences : " + twoOccurrences("a","Sajl is an alright lad"));
}
    
}
