package stats;

import java.util.ArrayList;
import java.util.Collections;

public class Sample {

	public static void main(String[] args) {
		double p = .5;
		int t = 16 * 10000;
		int crosses = 0;
		for (int j = 0; j < 50; j++) {
			int pos = 0;
			Boolean negative = false;
			int cross = 0;
			for (int i = 0; i < t; i++) {
				double ran = Math.random();
				if (ran > p) {
					pos += 1;
					if (negative == true && pos == 1) {
						if (t != 0)
							cross++;
						negative = false;
					}
				} else {
					pos -= 1;
					if (negative == false && pos == -1) {
						if (t != 0)
							cross++;
						negative = true;
					}
				}
			}
			crosses+=cross;
		}
		System.out.println("cross" + crosses);
		System.out.println("cross" + crosses/50);
	}
}
