import java.util.Arrays;

public class Rule {

	private String ruleString;
	private int ruleInt;
	private char trueSymbol = '1';
	
	// @author Bobby O'Brien
	private boolean[][] ruleStates = new boolean[][] {
        { true, true, true },
        { true, true, false },
        { true, false, true },
        { true, false, false },
        { false, true, true },
        { false, true, false },
        { false, false, true },
        { false, false, false },
	};
	
	public Rule(int ruleNum) {

		if (ruleNum > 255) {
			ruleNum = 255;
		} else if (ruleNum < 0) {
			ruleNum = 0;
		}

		ruleInt = ruleNum;
		// @author - Jacob Dearborn
		String rulBinary1 = Integer.toBinaryString(ruleNum);
		int rulBin = Integer.parseInt(rulBinary1);
		ruleString = String.format("%08d", rulBin);
	}

	public int getRuleNum() {
		return ruleInt;
	}

	public static boolean[] getNeighborhood(int idx, Generation gen) {
		
		if(gen.size() == 1) {
			return new boolean[] { gen.getState(idx), gen.getState(idx), gen.getState(idx) };
		}
		
		int left;
		int right;
		if (idx == 0) {
			left = gen.size() - 1;
			right = 1;
		} else if (idx == gen.size() - 1) {
			left = gen.size() - 2;
			right = 0;
		}

		else {
			left = idx - 1;
			right = idx + 1;
		}

		boolean[] dn = new boolean[] { gen.getState(left), gen.getState(idx), gen.getState(right) };
		return dn;

	}
	
	//code derived from Bobby O'Brien's code
	public boolean evolve(boolean[] neighborhood) {
		
		char[] binary = ruleString.toCharArray();
		boolean[] test = new boolean[8];
		
		for(int i = 0; i < 8; ++i) {
			if(binary[i] == trueSymbol)
				test[i] = true;
			else 
				test[i] = false;
		}
        
         for (int idx = 0; idx < 8; idx++) {
            if (Arrays.equals(neighborhood, ruleStates[idx])) {
                return test[idx];
            }
        }
        return false;
	}

	public Generation evolve(Generation gen) {
		boolean[] neighborhood;
		boolean[] end = new boolean[gen.getStates().length];
		for(int i = 0; i < gen.getStates().length; ++i) {
			neighborhood = getNeighborhood(i, gen);
			end[i] = evolve(neighborhood);
		}
		return new Generation(end);
	}
}
