import java.io.File;
import java.io.IOException;

import tools.HexTools;
import tools.input.ExtendedByteBuffer;
import unity.UnityFile;

public class Reader {
	ExtendedByteBuffer buffer;
	
	public static void main(String[] args) throws IOException {
		new Reader(new File("9e36e89cace0b413fa7f8087fae194bf"));
	}
	
	public Reader(File file) throws IOException {
		buffer = new ExtendedByteBuffer(file);
		
		UnityFile unityFile = new UnityFile(buffer);
	}
}
