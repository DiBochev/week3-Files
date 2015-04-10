package week3FilesPathsStreams.problem3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class WordCountResult {
	
	private int newLines;
	private String content;
	
	private WordCountResult(int newLines, String content){
		this.newLines = newLines;
		this.content = content;
	}

	public int getLineCount(){
		return this.newLines;
	}
	
	public int getCharacterCount(){
		return content.length();
	}
	
	public int getWordCount(){
		String[] temp = content.split(" ");
		return temp.length;
	}
	
	public static WordCountResult wordCount(File file) throws FileNotFoundException, IOException{
		int newLines = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	        	
	            sb.append(line);

	            newLines++;
	            line = br.readLine();
	        }
	        return new WordCountResult(newLines, sb.toString());
	    }
	}
	
	public static WordCountResult wordCount(Path path) throws FileNotFoundException, IOException{
		return wordCount(path.toFile());
	}
}
