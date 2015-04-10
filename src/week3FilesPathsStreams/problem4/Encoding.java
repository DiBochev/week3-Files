package week3FilesPathsStreams.problem4;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encoding {

	public static void fixEncoding(Path path) throws IOException{
		String a = null;
		a = readFile(path, a);
		writeToFile(a, path);
	}

	private static String readFile(Path path, String a) throws IOException {
		a = new String(Files.readAllBytes(path));
		return a;
	}

	private static void writeToFile(String a, Path path) throws IOException {
		try(Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path.toFile() + "S"), "UTF-8"))){
			out.write(a);
		}
	}
}
