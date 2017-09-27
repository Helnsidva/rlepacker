package packrle;

import static org.junit.Assert.*;

import org.junit.Test;

public class RleTests {

	@Test
	public void test() {
		
		String data = new String();
		data = "HFSUG8IURG4OIG3JJJJJJFAJDLLLLLLLAAABBCDHD8SDJJJJJ";
		FileWork.fileRecorder("data.txt", data);
		
		String[] packArgMain = new String[] {"-z", "-out", "code.txt", "data.txt" };
		Main.main(packArgMain);
		
		String[] repackArgMain = new String[] {"-u", "-out", "decode.txt", "code.txt" };
		Main.main(repackArgMain);
		
		String recData = new String();
		recData = FileWork.fileReader("decode.txt");
		
		assertEquals(data, recData);
		
	}

}
