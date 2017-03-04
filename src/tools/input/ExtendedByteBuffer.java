package tools.input;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExtendedByteBuffer {
	private byte[] arr;
	private int position;
	
	public ExtendedByteBuffer(File file) throws IOException {
		FileInputStream input = new FileInputStream(file);
		
		arr = new byte[(int) file.length()];
		input.read(arr);
		input.close();
	}
	
	public ExtendedByteBuffer(byte[] buffer) {
		arr = new byte[buffer.length];
		
		for (int i = 0; i < buffer.length; i++) {
			arr[i] = buffer[i];
		}
	}
	
	// Returns the next n bytes but doesn't change the position of the buffer.
	public byte[] peekNext(int n) {
		byte[] bytes = new byte[n];
		
		for (int i = 0; i < n; i++) {
			bytes[i] = arr[position + i];
		}
		
		return bytes;
	}
}
