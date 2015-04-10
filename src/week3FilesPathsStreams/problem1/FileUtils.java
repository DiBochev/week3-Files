package week3FilesPathsStreams.problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileUtils {
	
	private static FileUtils instance = null;

	private FileUtils(){
	}
	
	public static FileUtils getInstance(){
		if (instance == null) {
			instance = new FileUtils();
		}
		return instance;
	}
	
	public String readFrom(File file) throws FileNotFoundException, IOException{
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        return sb.toString();
		}
	}
	
	public String readFrom(Path path) throws FileNotFoundException, IOException{
		return readFrom(path.toFile());
	}

	public void writeTo(File file, String content) throws IOException{
        try(BufferedWriter writer =  new BufferedWriter(new FileWriter(file));) {
            writer.write(content);
        }
	}
	
	public void writeTo(Path path, String content) throws IOException{
		writeTo(path.toFile(), content);
	}
}
