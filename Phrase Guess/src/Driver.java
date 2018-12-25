import java.util.Scanner;

/**
 * This program takes in a phrase from the user and will use the genetic algorithm to
 * figure out what that phrase is and return it to the user.
 * 
 * @author Zach Dummer
 *
 * Last modified: Dec 22, 2018
 */
public class Driver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a word or phrase: ");
		String target = scan.nextLine();
		
		Population test = new Population(target, 0.01f, 150);
		
		while( !test.finished ) {
			System.out.println("Generation: " + test.numGen() + "\t" + 
			"Average fitness: " + test.getAvgFit() + "\t" + "Best Guess: " + test.getBest());
			test.selction();
			test.createNextGen();
			test.calcFitnessPop();
		}
	}

}
