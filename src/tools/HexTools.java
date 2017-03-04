package tools;

public class HexTools {
	public static void printHexArray(byte[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i > 0 && i % 32 == 0) {
				System.out.println();
			}
			
			System.out.print(byteToHexString(arr[i]) + " ");
		}
	}
	
	public static String byteToHexString(byte b) {
		String result = Integer.toHexString(b).toUpperCase();
		return result.length() == 1 ? "0" + result : result;
	}
}
