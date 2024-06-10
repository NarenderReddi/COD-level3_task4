package Grade;

import java.util.*;

public class Marks {
	public int s1, s2, s3, s4, s5, s6, total;// variables to store the marks
	public String result = "Result-->Pass!!!";// result initially assigned with pass
	public float avg;// to store the average

	public void entermarks() {
		Scanner sc = new Scanner(System.in); // scanner object

		int sub[] = new int[7]; // array to store the marks

		for (int i = 1; i < sub.length; i++) {// loop for assigning the marks to sub

			System.out.println("Enter Sub-" + i + " marks:");
			sub[i] = sc.nextInt();// takes the marks dynamically

			if (sub[i] > 100) {// marks should not be greater than 100

				System.out.println("Enter valid marks...!" + "\nExiting from Application.");
				System.exit(0); // exits the operation
			}
		}
		setmarkss1(sub[1]);
		setmarkss2(sub[2]);
		setmarkss3(sub[3]);
		setmarkss4(sub[4]);
		setmarkss5(sub[5]);
		setmarkss5(sub[6]);
		// sets the marks to the subjects

		for (int k = 1; k < sub.length; k++) {// loop to check failed in any sub

			if (sub[k] <= 34) {
				// validating the marks
				System.out.println("Failed in sub-" + k);
				result = "Result-->Fail!!!"; // if fails in any sub result sets to fail
				setfail(result);
			}
		}

		for (int j = 1; j < sub.length; j++) {// loop for calculating the total,avg

			total += sub[j];// total which stores the total marks
			settotal(total);
			avg = total / 6;// avg stores the average marks
			setavg(avg);

		}
		sc.close(); // close scanner when we are done with it

	}

//below all are getters and setters for the sub marks ,total,avg,result etc..,
	public void setmarkss1(int s1) {
		this.s1 = s1;
	}

	public void setmarkss2(int s2) {
		this.s2 = s2;
	}

	public void setmarkss3(int s3) {
		this.s3 = s3;
	}

	public void setmarkss4(int s4) {
		this.s4 = s4;
	}

	public void setmarkss5(int s5) {
		this.s5 = s5;
	}

	public void setmarkss6(int s6) {

		this.s6 = s6;
	}

	public void settotal(int total) {
		this.total = total;
	}

	public void setavg(float avg) {
		this.avg = avg;
	}

	public void setfail(String result) {
		this.result = result;
	}

	public int getmarkss1() {
		return this.s1;
	}

	public int getmarkss2() {
		return this.s2;
	}

	public int getmarkss3() {
		return this.s3;
	}

	public int getmarkss4() {
		return this.s4;
	}

	public int getmarkss5() {
		return this.s5;
	}

	public int getmarkss6() {
		return this.s6;
	}

	public int gettotal() {
		return this.total;
	}

	public float getavg() {
		return this.avg;
	}

	public String getresult() {
		System.out.println("\n" + result);
		return "";
	}

}
