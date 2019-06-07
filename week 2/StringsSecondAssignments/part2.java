
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    public int howMany(String stringa, String stringb)
    {
        int index = stringb.indexOf(stringa);
        int count =0 ;
        while(index != -1)
        {
            count+=1;
            index = stringb.indexOf(stringa, index+ stringa.length());
        }
        return count;
    }
    
    public void test()
    {
        System.out.println("Result : " + howMany("AA", "ATAAA"));
    }
}
