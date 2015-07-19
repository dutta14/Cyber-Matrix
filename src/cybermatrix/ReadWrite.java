package cybermatrix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadWrite {

	String str, ret = "", path;

	ReadWrite(String st, String pt) {
		str = st;
		path = pt;
	}

	void writeinto() {	
		try {
			PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter(path)));
			pw.println(str);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String readfrom() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			return in.readLine();
		} catch (Exception e) {
			return "error";
		}
	}
}