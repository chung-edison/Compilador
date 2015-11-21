package com.epn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lex {

	private static int linea;

	public static void main(String[] args) throws IOException {
		
		LexEspec comparador = new LexEspec();

		BufferedReader input = null;
		BufferedWriter output = null;
		
		linea = 0;

		try {

			File inputFile = new File("input.txt");

			input = new BufferedReader(new FileReader(inputFile));
			
			File outputFile = new File("output.csv");
			
			output = new BufferedWriter(new FileWriter(outputFile));
			
			while (input.ready()) {
				output.write(comparador.analyzeLine(input.readLine()));
				linea++;
				if(comparador.hayError()){
					System.out.println("Error lexico en la linea " + linea);
					comparador.setError(false);
				}
			}

			System.out.println("Lineas analizadas: " + linea);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null)
					input.close();
				if (output != null)
					output.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
