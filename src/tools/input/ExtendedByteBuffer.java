package tools.input;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExtendedByteBuffer {
	private byte[] arr;
	private int pos;
	
	private boolean isLittleEndian = false;
	
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
	
	public void changeEndianness(boolean isLittleEndian) {
		this.isLittleEndian = isLittleEndian;
	}
	
	public void changePosition(int newPosition) {
		this.pos = newPosition;
	}
	
	public byte read() {
		byte b = arr[pos++];
		
		return b;
	}
	
	public int readInt() {
		byte byte0 = read();
		byte byte1 = read();
		byte byte2 = read();
		byte byte3 = read();
		
		if (isLittleEndian) {
			return (byte3 << 24) + (byte2 << 16) + (byte1 << 8) + byte0;
		}
		
		return (byte0 << 24) + (byte1 << 16) + (byte2 << 8) + byte3;
	}
	
	public byte[] readBytes(int n) {
		byte[] bytes = new byte[n];
		
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = read();
		}
		
		return bytes;
	}
	
	public String readNullTerminatedString() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		byte b;
		while ((b = read()) != 0) {
			baos.write(b);
		}
		
		return new String(baos.toByteArray());
	}
	
	// Returns the next n bytes but doesn't change the position of the buffer.
	public byte[] peekNext(int n) {
		byte[] bytes = new byte[n];
		
		for (int i = 0; i < n; i++) {
			bytes[i] = arr[pos + i];
		}
		
		return bytes;
	}
}
