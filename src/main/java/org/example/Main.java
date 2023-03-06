package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		ProcessBuilder builder = new ProcessBuilder("bash", "./target/server/bin/standalone.sh");

		ExecutorService executor = Executors.newFixedThreadPool(1);

		executor.execute(() -> {
			try {
				Process process = builder.start();
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Thread.sleep(5000);

		executor.shutdownNow();

	}
}