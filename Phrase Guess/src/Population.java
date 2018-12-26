import java.util.ArrayList;

/**
 * This class represents a population of DNA and decides which
 * DNA objects are the best and which ones will pass on their 
 * information to the next generation through Natural Selection.
 * 
 * @author Zach Dummer
 *
 * Last modified: Dec 25, 2018
 */
public class Population {

	private DNA[] population;
	private ArrayList<DNA> matingPool;
	private float mutationRate;
	private String target;
	private int numGen = 1;
	private boolean finished = false;
	private int perfectFit = 1;
	
	/**
	 * Constructor method for the population class
	 * 
	 * @param String t is the target phrase
	 * @param float m is the mutation rate
	 * @param int popSize is the population size
	 */
	public Population(String t, float m, int popSize) {
		target = t;
		mutationRate = m;
		population = new DNA[popSize];
		
		for(int i = 0; i < population.length; i++) {
			population[i] = new DNA(target.length());
		}
		calcFitnessPop();
		matingPool = new ArrayList<DNA>();
		
	}
	/**
	 * Calculates and fills the population array with the fitness score of each DNA object
	 */
	public void calcFitnessPop() {
		for(int i = 0; i < population.length; i++) {
			population[i].calcFitnessDNA(target);
		}
	}
	/**
	 * Generates the mating pool to pick the parents for the next generation
	 */
	public void selction() {
		
		//make sure to clear the pool from the last generation
		matingPool.clear();
		
		float maxFitness = 0;
	    for (int i = 0; i < population.length; i++) {
	      if (population[i].fitness > maxFitness) {
	        maxFitness = population[i].fitness;
	      }
	      int add = (int)(population[i].fitness * 100);
	      for(int j = 0; j < add; j++) {
	    	  matingPool.add(population[i]);
	      }
	    }
	    //TODO need to decide how I want to add to the pool based on fitness
	    
	    
	}
	/**
	 * Creates the next generation by randomly selecting two parents from
	 * the mating pool, Then crossing over their information and filling
	 * population with the children for the next generation.
	 */
	public void createNextGen() {
		
		for(int i = 0; i < population.length; i++) {
			int randNum1 = (int)(Math.random() * (matingPool.size() - 1));
			int randNum2 = (int)(Math.random() * (matingPool.size() - 1));
			
			DNA parent1 = matingPool.get(randNum1);
			DNA parent2 = matingPool.get(randNum2);
			
			DNA child = parent1.crossover(parent2);
			child.mutate(mutationRate);
			
			population[i] = child;
		}
		
		numGen++;
		
	}
	/**
	 * Computes the DNA object with the best fitness score
	 * 
	 * @return String which is the closest phrase to the target
	 */
	public String getBest() {
		
		float highestFit = 0;
		int indexOfHighestFit = 0;
		
		for(int i = 0; i < population.length; i++) {
			if(highestFit < population[i].fitness) {
				highestFit = population[i].fitness;
				indexOfHighestFit = i;
			}
		}
		
		if(highestFit == perfectFit) {
			finished = true;
			System.out.println("The phrase " + '"' + target + '"' + " has been found");
		}
		
		return population[indexOfHighestFit].getPhrase();
	}
	/**
	 * Checks to see is the target phrase has been found
	 * 
	 * @return boolean finished
	 */
	public boolean isFinished() {
		return finished;
	}
	/**
	 * Checks the number of generations
	 * 
	 * @return int numGen
	 */
	public int numGen() {
		return numGen;
	}
	/**
	 * Computes the average fitness score among the DNA objects of the current generation
	 * 
	 * @return float which is the average fitness
	 */
	public float getAvgFit() {
		
		float avgFit = 0;
		
		for(int i = 0; i < population.length; i++) {
			avgFit += population[i].fitness;
		}
		
		return (avgFit / population.length);
	}
}
