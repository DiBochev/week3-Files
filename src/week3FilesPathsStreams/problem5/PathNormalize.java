package week3FilesPathsStreams.problem5;

import java.nio.file.Path;

public class PathNormalize {

	public static String normalize(Path p){
		return p.toUri().normalize().toString();
	}
}
