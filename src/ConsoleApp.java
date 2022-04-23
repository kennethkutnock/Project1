import java.util.Scanner;

public class ConsoleApp {

	/*
	 * NOTE: You do not need to modify any lines at or before 
	 * the printOptions() method.
	 */
	
	private static final Generation DEFAULT_GENERATION = new Generation(false, false, false, true, false, false, false);
	private static final int DEFAULT_RULE = 22;

	private Automaton automaton;
	private Scanner input;

	public ConsoleApp() {
		automaton = new Automaton(DEFAULT_RULE, DEFAULT_GENERATION);
		input = new Scanner(System.in);
	}

	public void run() {
		Option option; // store user's input Option

		do {
			// Show possible options
			printOptions();

			// Get user input
			System.out.print("Select option > ");

			try {
				int value = input.nextInt();
				option = Option.fromInt(value);
			} catch (Exception e) {
				// Quit on an invalid input (e.g., lack of input)
				option = Option.QUIT;
			}

			// Process user input
			processOption(option);

			// Print a blank line between each action
			System.out.println();
		} while (option != Option.QUIT);
	}

	private void processOption(Option option) {
		switch (option) {
			case PRINT_RULE:
				printRule();
				break;
			case REINIT_AUTOMATON:
				reinitAutomaton();
				break;
			case EVOLVE:
				evolve();
				break;
			case SET_TRUE_SYMBOL:
				setTrueSymbol();
				break;
			case SET_FALSE_SYMBOL:
				setFalseSymbol();
				break;
			case PRINT_CURRENT_GENERATION:
				printCurrentGeneration();
				break;
			case PRINT_FULL_EVOLUTION:
				printFullEvolution();
				break;
			case QUIT:
				printQuitMessage();
				break;
		}
	}

	private static void printOptions() {
		Option[] options = Option.values();
		for (Option o : options) {
			System.out.println(o.index() + ": " + o);
		}
	}

	/* You will need to implement the methods below. */

	private void printRule() {
		// TODO: Print out the current rule in the format specified by
		// the README.
		System.out.println("Rule: " + automaton.getRuleNum());
	}

	private void reinitAutomaton() {
		// This method's implementation is provided for you.
		setTrueSymbol();
		setFalseSymbol();
		setRuleAndGeneration();
	}

	private void setRuleAndGeneration() {
		// TODO: Prompt the user to enter a new rule number and initial
		// generation. Refer to the README for details.
		System.out.print("Enter new rule number > ");
		int ruleNum = input.nextInt();
		input.nextLine();
		System.out.print("Enter initial generation > ");
		String generation = input.nextLine();
		Generation gen = new Generation(generation, automaton.trueSymbol);
		char tempfalse = automaton.falseSymbol;
		char temptrue = automaton.trueSymbol;
		automaton = new Automaton (ruleNum, gen);
		automaton.falseSymbol = tempfalse;
		automaton.trueSymbol = temptrue;
		System.out.println("Rule number updated to " + automaton.getRuleNum());
		printCurrentGeneration();
	}

	private void setTrueSymbol() {
		// TODO: Prompts the user to enter a new true symbol representation.
		System.out.println("Current true symbol: " + automaton.trueSymbol);
		System.out.print("New true symbol > ");
		automaton.trueSymbol = input.next().charAt(0);
	}

	private void setFalseSymbol() {
		// TODO: Prompts the user to enter a new false symbol representation.
		System.out.println("Current false symbol: " + automaton.falseSymbol);
		System.out.print("New false symbol > ");
		automaton.falseSymbol = input.next().charAt(0);
	}

	private void evolve() {
		// TODO: Prompt the user to enter a number of evolutions and evolves
		// the Automaton.
		System.out.print("Enter number of evolutions > ");
		int evolutions = input.nextInt();
		 evolutions = automaton.evolve(evolutions);
		System.out.println("Evolved " + evolutions + " generation(s)");

	}

	private void printCurrentGeneration() {
		// TODO: Print the current generation of the Automaton using the
		// Automaton's true and false symbols.
		System.out.println("Generation " + automaton.getTotalSteps() + ":");
		System.out.println(automaton.getCurrentGeneration().getStates(automaton.falseSymbol, automaton.trueSymbol));
	}

	private void printFullEvolution() {
		// TODO: Print the full evolution of the automaton.
		System.out.print(automaton.toString());
	}

	private void printQuitMessage() {
		// TODO: Print "Bye bye!"
		System.out.println("Bye bye!");
	}
}
