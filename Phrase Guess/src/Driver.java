import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This program takes in a phrase from the user and will use the genetic algorithm to
 * figure out what that phrase is and return it to the user.
 * 
 * @author Zach Dummer
 *
 * Last modified: Dec 27, 2018
 */
public class Driver {

	public static void main(String[] args) {
		
		boolean validPhrase = false;
		String target = "";
		Scanner scan;
		
		while (!validPhrase) {
			scan = new Scanner(System.in);
			System.out.print("Please enter a word or phrase (case doesn't matter): ");
			target = scan.nextLine().toLowerCase();
			Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(target);
			boolean b = m.find();
			if (b) {
				System.out.println("Special characters are invalid inputs\nPlease try again\n");
			}else {
				validPhrase = true;
			}
			
		}
		Population test = new Population(target, 0.01f, 200); // add "f" at the end to compile as a float
		
		while( !test.isFinished() ) {
			System.out.println("Generation: " + test.numGen() + "\t" + 
			"Average fitness: " + test.getAvgFit() + "\t" + "Best Guess: " + test.getBest());
			test.selction();
			test.createNextGen();
			test.calcFitnessPop();
		}
		
		
	}

}
