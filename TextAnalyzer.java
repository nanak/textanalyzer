package textanalyzer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This Class implements the text analyzer logic
 * @author nanak
 *
 */
public class TextAnalyzer {
	private int lines;
	private int sentences;
	private int words;
	private int avgwlength;
	private String line;
	private String text;
	
	
	/**
	 * This Method counts the sentences in a specified line
	 * @param line The line in which sentences will be counted
	 */
	public void countSentences(String line){
		String[] sentences = line.split("[\\!\\.\\?]");
		this.sentences = sentences.length;
	}
	
	/**
	 * This Method counts the words in a specified line
	 * @param line The line in which words will be counted
	 */
	public void countWords(String line){
		String[] words = line.split(" ");
		this.words = words.length;
	}
	
	/**
	 * Ths Method calculates the average word length
	 * @param line The line in which the average length sould be calculated
	 */
	public void avgWLength(String line){
		//TODO implement logic
	}
	
	/**
	 * Reads a File and analyzes it
	 * @param path
	 * @throws FileNotFoundException
	 */
	public void readFile(String path) throws FileNotFoundException{
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		try{
			line = null;
			while ((line = br.readLine()) != null){
				this.lines += 1;
				countSentences(line);
				countWords(line);
				avgWLength(line);
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	
}
