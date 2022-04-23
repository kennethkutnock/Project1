import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Driver {

    public static void main(String[] args) {
    	char trueSymbol = 't';
    	char falseSymbol = 'f';
    	boolean[][] ruleStates = new boolean[][] { { true, true, true }, { true, true, false },
			{ true, false, true }, { true, false, false }, { false, true, true }, { false, true, false },
			{ false, false, true }, { false, false, false }, };
       
			boolean[] neighborhood = new boolean[] {true, true, false, false, false};
    	
			String pp = Integer.toBinaryString(22);
			int rulBin = Integer.parseInt(pp);
			pp = String.format("%06d", rulBin);
			//System.out.println(Integer.toBinaryString(63));
			System.out.println(pp);
			
			char[] binary = pp.toCharArray();
			char[] reverse = new char[6];
			boolean[] test = new boolean[6];
			int countTrue = 0;
			int l = 6;
			
			for(int j = 0; j < 6; ++j) {
				reverse[j] = binary[5-j];
			}
			
			System.out.println(Arrays.toString(reverse));
			for (int i = 0; i < 6; ++i) {
				if (reverse[i] == '1') {
					test[i] = true;
				}
				else {
					test[i] = false;
				}
			}
			System.out.println(Arrays.toString(test));

			for (int idx = 0; idx < 5; idx++) {
				if(neighborhood[idx] == true) {
					++countTrue;
				}
			}
			System.out.println(countTrue);
			System.out.println(test[countTrue]);
        
    }
}
