package textanalyzer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This Class implements the text analyzer logic
 * 
 * @author nanak
 */
public class TextAnalyzer {
	private String line;
	private int lineCount;
	private int sentenceCount;
	private int wordCount;
	private int charCount;
	private int avrgWLength;

	/**
	 * This Method counts the sentences in a specified line
	 * 
	 * @param line
	 *            The line in which sentences will be counted
	 */
	public int countSentences(String line) {
		String[] sentences = line.split("[\\!\\.\\?]");
		int sentenceCount = sentences.length;
		return sentenceCount;
	}

	/**
	 * This Method counts the words in a specified line
	 * 
	 * @param line
	 *            The line in which words will be counted
	 */
	public int countWords(String line) {
		String[] words = line.split("\\s+");
		int wordCount = words.length;
		return wordCount;
	}

	/**
	 * This Method calculates the average word length
	 * 
	 * @param line
	 *            The line in which the average length should be calculated
	 */
	public int countChars(String line) {
		return line.length();
	}

	public void writeFileToStdOut(String path, int newLineLength)
			throws FileNotFoundException {
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String longline = "";
		String newline = "";
		String[] chars = null;
		line = "";
		int i = 0;
		try {
			while ((line = br.readLine()) != null) {
				longline += line;
			}
			chars = longline.split("(?!^)");
			int j = 0;
			while (i < (longline.length()/newLineLength)){
				while (newline.length() < newLineLength && newline.length() < chars.length) {
					newline += chars[j];
					j++;
				}
				System.out.println(newline);
				newline = "";
				i++;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Reads a File and analyzes it
	 * 
	 * @param path
	 *            Path to the text file which should be analyzed
	 * @throws FileNotFoundException
	 */
	public void readAnalyzeFile(String path, int newLineLength)
			throws FileNotFoundException {
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		try {
			line = null;
			while ((line = br.readLine()) != null) {
				lineCount += 1;
				sentenceCount += countSentences(line);
				wordCount += countWords(line);
				charCount += countChars(line);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		avrgWLength = charCount / wordCount;
		writeFileToStdOut(path, newLineLength);
		System.out.println("\n\nlines: " + lineCount + ", sentences: "
				+ sentenceCount + ", words: " + wordCount + ", characters: "
				+ charCount + ", average word length: " + avrgWLength);
	}

}
