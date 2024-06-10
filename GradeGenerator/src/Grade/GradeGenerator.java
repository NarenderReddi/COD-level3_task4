package Grade;

public class GradeGenerator {
	public static void main(String[] args) {
		Marks mar = new Marks();//object creation for marks class

		System.out.println("Wel-come to Grade generator-->\n ");
		System.out.println("Enter the Marks out of 100.");

		mar.entermarks();//calling the method

		System.out.println("\nTotal Marks: " + mar.gettotal());
		System.out.println("Average Marks: " + mar.getavg());

		// above printing the total and avg marks
		
		if (mar.avg >= 90) {
			System.out.println("A -Grade");
		} else if (mar.avg >= 75) {
			System.out.println("B -Grade");
		} else if (mar.avg >= 65) {
			System.out.println("C -Grade");
		} else if (mar.avg >= 45) {
			System.out.println("D -Grade");
		} else if (mar.avg >= 35) {
			System.out.println("E -Grade");
		} else if (mar.avg < 35) {
			System.out.println("F -Grade");
		}
		//conditions for grades
		
		mar.getresult();
		//returning the student wheather he/her has pass or fail
		
	}
}
