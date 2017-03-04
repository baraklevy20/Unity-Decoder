package unity;

import tools.HexTools;
import tools.input.ExtendedByteBuffer;

public class UnityFile {
	private int unknown1;
	private int size;
	private int unknown2;
	private int biasUnknown;
	private int unknown4;
	private String unityVersion;
	private byte unknown5;
	private int unknown6;
	private int unknown7;
	
	public UnityFile(ExtendedByteBuffer buffer) {
		buffer.changeEndianness(false);
		unknown1 = buffer.readInt();
		size = buffer.readInt();
		unknown2 = buffer.readInt();
		biasUnknown = buffer.readInt();
		unknown4 = buffer.readInt();
		unityVersion = buffer.readNullTerminatedString();
		buffer.changeEndianness(true);
		unknown5 = buffer.read();
		unknown6 = buffer.readInt();
		unknown7 = buffer.readInt();
		
		for (int i = 0; i < 1; i++) {
			int type = buffer.readInt();
			System.out.print("Type: " + type + " Hash: ");
			HexTools.printHexArray(buffer.readBytes(16));
			System.out.println();
		}
		
//		System.out.println(unknown7);
		
//		buffer.changePosition(0x1000);
		
//		System.out.println(size);
		HexTools.printHexArray(buffer.peekNext(40));
	}
}
