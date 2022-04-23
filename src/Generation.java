import java.util.Arrays;
import java.util.StringJoiner;

public class Generation {

	private boolean[] cellStates;

	// Create a Generation with one cell for each element in the given array.
	// The state of each cell is specified by the value of the corresponding
	// element.
	public Generation(boolean... states) {
		// If the array is empty or the method is given a null reference,
		// create a Generation with one cell in the false state.
		if (states == null || states.length == 0) {
			cellStates = new boolean[] { false };
		} else {
			boolean[] copy = new boolean[states.length];
			for (int i = 0; i < states.length; ++i) {
				copy[i] = states[i];
			}
			// cellStates = Arrays.copyOf(states, states.length);
			cellStates = Arrays.copyOf(copy, copy.length);
		}
	}

	public Generation(String states, char trueSymbol) {
		if (states == null || states.equals("")) {
			cellStates = new boolean[] { false };
		} else {
			char[] find = states.toCharArray();
			cellStates = new boolean[find.length];
			for (int i = 0; i < states.length(); ++i) {
				if (find[i] == trueSymbol) {
					cellStates[i] = true;
				} else
					cellStates[i] = false;
			}
		}
	}

	public boolean getState(int idx) {
		return cellStates[idx];
	}

	public boolean[] getStates() {
		return Arrays.copyOf(cellStates, cellStates.length);
	}

	public String getStates(char falseSymbol, char trueSymbol) {
		String t = String.valueOf(trueSymbol);
		String f = String.valueOf(falseSymbol);
		StringJoiner sj = new StringJoiner("");
		for (int i = 0; i < cellStates.length; ++i) {
			if (cellStates[i] == false)
				sj.add(f);
			else
				sj.add(t);
		}
		return sj.toString();
	}

	public int size() {
		return cellStates.length;
	}
}
