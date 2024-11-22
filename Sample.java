package stats;

import java.util.ArrayList;
import java.util.Collections;

public class Sample {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(1000000);
		for (int i = 0; i < 1000000; i++) {
			double ran = Math.random();
			if (ran <= .35) {
				arr.add(i, 1);
			}
			if (ran > .35 && ran <= .75) {
				arr.add(i, -1);
			}

			if (ran > .75) {
				arr.add(i, 0);
			}
		}
		int one = 0;
		int zero = 0;
		int negative = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == 0) {
				zero++;
			} else if (arr.get(i) == 1) {
				one++;
			} else if (arr.get(i) == -1) {
				negative++;
			}
		}
		System.out.println("one: " + one + " zero: " + zero + " negative: " + negative);

		
		for (int k = 0; k < 100; k++) {
			int negativeMajority = 0;
			for (int i = 0; i < 200; i++) {
				int onec = 0;
				int zeroc = 0;
				int negativec = 0;
				Collections.shuffle(arr);
				// change sample size
				for (int j = 0; j < 700; j++) {
					if (arr.get(j) == 0) {
						zeroc++;
					} else if (arr.get(j) == 1) {
						onec++;
					} else if (arr.get(j) == -1) {
						negativec++;
					}
				}
				//System.out.println("one: " + onec + " zero: " + zeroc + " negative: " + negativec);
				//System.out.println(Math.max(onec, Math.max(zeroc, negativec)));
				if (negativec > zeroc && negativec > onec) {
					negativeMajority++;
				}
			}
			if ((double) negativeMajority / 200 < .9) {
				System.out.println("Negative majority: " + negativeMajority + "/200");
				//System.out.println("no");
			}
		}
		System.out.println("done");
	
	}
}
