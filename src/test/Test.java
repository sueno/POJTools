package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {

	private static final String INPUT_FILEDIR = "SampleInput/";
	private static final String OUTPUT_FILEDIR = "SampleOutput/";
	
	
	public static String exec(String targetClass, String fileName) {

		try {
			Process process = Runtime.getRuntime().exec("sh run.sh "+targetClass+" "+INPUT_FILEDIR + fileName);
			
			InputStream is = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			// output
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line+"\n");
			}
			br.close();
			is.close();

			// err output
			InputStream es = process.getErrorStream();
			br = new BufferedReader(new InputStreamReader(es));
			while ((line = br.readLine()) != null) {
				sb.append(line+"\n");
			}
			br.close();
			es.close();
			return new String(sb);
		} catch (Throwable th) {
			return th.getMessage();
		}
	}
	
	public static String readFile(String fileDir, String fileName) {
		try {
			FileReader fr = new FileReader(fileDir+fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line+"\n");
			}
			br.close();
			fr.close();
			return new String(sb);
		} catch (IOException ioex) {
			ioex.printStackTrace();
			return null;
		}
	}
	public static String readFile(String fileName) {
		return readFile(OUTPUT_FILEDIR, fileName);
	}
	
	
	public static String execResult(String targetClass, String fileName) {
		StringBuilder sb = new StringBuilder();
		sb.append("*************SampleInput************\n");
		sb.append(readFile(INPUT_FILEDIR,fileName));
		sb.append("\n*************ExecResult*************\n");
		sb.append(exec(targetClass, fileName));
		sb.append("\n*************SampleOutput***********\n");
		sb.append(readFile(OUTPUT_FILEDIR,fileName));
		return new String(sb);
	}
}
