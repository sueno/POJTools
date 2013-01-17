package test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestRun {

	private static Class<?> runMainClass;
	private static String inputStream;
	
	public static void runMain(Class<?> runClass, String filename) {
		runMainClass = runClass;
		inputStream = readFile(filename);
		try {
			Runnable run_main = new Runnable() {
				@Override
				public void run() {
					try {
						Method main = ((Class<?>)TestRun.getRunClass()).getDeclaredMethod("main", new Class[]{String[].class});
						main.invoke(null, new Object[]{null});
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			};
			Runnable run_input = new Runnable() {
				@Override
				public void run() {
					try {
						System.out.print(TestRun.getInput());
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			};


	        Thread thread_main = new Thread(run_main);
	        Thread thread_input = new Thread(run_input);
	        
	        thread_main.start();
	        Thread.sleep(1000);
	        thread_input.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String readFile(String filename) {
		try {
			FileReader fr = new FileReader(filename);
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

	public static Class<?> getRunClass() {
		return runMainClass;
	}
	public static String getInput() {
		return inputStream;
	}
}
