import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public int getNumPoints (Shape s) {
        int h = 0;
        for (Point p : s.getPoints()){
            h = h+1;
        }
        return h;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avg = getPerimeter(s)/getNumPoints(s);
        return avg;
    }

    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        double currDist = 0;
        double longest = 0;
        double lastdistance = 0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            currDist = prevPt.distance(currPt);
            if (currDist > longest){
                longest = currDist; }
            prevPt = currPt;
        }
        // totalPerim is the answer
        
        return longest;
    }

    public double getLargestX(Shape s) {
        Point prevPt = s.getLastPoint();
        double largestx = 0;
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.getX();
            if (currDist > largestx){
                largestx = currDist;
            }
            
            prevPt = currPt;
        }
        return largestx;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largest = 0;
        double currper = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource p = new FileResource(f);
            Shape s = new Shape(p);
            currper = getPerimeter(s);
            if (currper > largest){
                largest = currper;}
            
        }
        return largest;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null; 
        double largest = 0;
        double currper = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource p = new FileResource(f);
            Shape s = new Shape(p);
            currper = getPerimeter(s);
            if (currper > largest){
                temp = f;
            } 
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int result = getNumPoints(s);
        double avg  = getAverageLength(s);
        double longest = getLargestSide(s);
        double largestx = getLargestX(s);
        System.out.println("Longest X value = " + largestx);
        System.out.println("Longest side = " + longest);
        System.out.println("Total number of points = " + result);
        System.out.println("Average Length = " + avg);
        System.out.println("Perimeter = " + length);
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println("Largest parameter = " + largest);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largest = getFileWithLargestPerimeter();
        System.out.println("Name of file with largest parameter " + largest);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
