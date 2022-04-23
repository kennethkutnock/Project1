
public enum Option {
	PRINT_RULE					("Show the current Rule"), 
	REINIT_AUTOMATON			("Reinitialize Automaton"),
	EVOLVE						("Evolve the Automaton a given number of steps"), 
	SET_TRUE_SYMBOL				("Set the true symbol represention"),
	SET_FALSE_SYMBOL			("Set the false symbol represention"),
	PRINT_CURRENT_GENERATION	("Show the current Generation of the Automaton"),
	PRINT_FULL_EVOLUTION		("Show the full evolution of the Automaton"), 
	QUIT						("Quit");

	private final String option;

	Option(String option) {
		this.option = option;
	}

	public int index() {
		return this.ordinal();
	}

	public String toString() {
		return this.option;
	}

	public static Option fromInt(int x) {
		return Option.values()[x];
	}
}
