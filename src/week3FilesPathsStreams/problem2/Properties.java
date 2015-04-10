package week3FilesPathsStreams.problem2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Properties {

	public static Map<String, String> readFile(File file) throws FileNotFoundException, IOException{
		
		Map<String, String> parseProperties = new HashMap<String, String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = br.readLine();
	        
	        line = line.trim();
	        
	        while (line != null) {
	        	for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == '#') {
						break;
					}if (line.charAt(i) == '=') {
						if (!line.contains("#")) {
							parseProperties.put(line.substring(0, i), line.substring(i + 1, line.length()));
							break;
						}else{
							int temp = line.indexOf("#");
							parseProperties.put(line.substring(0, i), line.substring(i + 1, temp));
							break;
						}
					}
				}
	            line = br.readLine();
	        }
	        return parseProperties;
		}
	}
}
