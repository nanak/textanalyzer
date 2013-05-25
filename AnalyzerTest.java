package textanalyzer;

import java.io.FileNotFoundException;

public class AnalyzerTest {
	public static void main(String[] args) {
		if (args.length == 2){
			TextAnalyzer ta = new TextAnalyzer();
			try {
				ta.readAnalyzeFile(args[0], Integer.parseInt(args[1]));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (args.length !=2){
			System.out.println("Synopsis: java -jar textanalyzer.jar <path_to_textfile> <line_length_stdout>");
		}
		
		
		
	}
}
