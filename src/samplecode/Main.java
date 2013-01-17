package samplecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int roopNum = Integer.parseInt(br.readLine());
			StringBuilder input = new StringBuilder();
			for (int i = 0; i < roopNum; ++i) {
				input.append(br.readLine()+"\n");
			}
			System.out.print(calc(new String(input)));
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}

	private static String calc(String input) {
		return input.replaceAll("Hoshino", "Hoshina");
	}
}