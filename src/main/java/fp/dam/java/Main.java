package fp.dam.java;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static ArrayList<String> m1(String s) {
		char[] cadena = s.toCharArray();
		ArrayList<String> out = new ArrayList<>();
		for (int i = 0; i < cadena.length; i++) {
			int j = 0;
			while (cadena[i] == cadena[i + j]) {
				j++;
			}
			out.add(s.substring(i, j));
		}

		return out;

	}

	static ArrayList<String> m2(String s) {
		ArrayList<String> out = new ArrayList<>();
		String regex = "(.)\1+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(regex);
		while (m.find()) {
			out.add(m.group());
		}
		return out;
	}

	static Integer m3a(int[][] m) {
		int max = Integer.MIN_VALUE;
		int suma = 0;
		if (m.length < 3 || m[0].length < 3) {
			return null;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				suma += m[i][j];
				if (suma > max) {
					max = suma;
				}
			}
		}
		return max;
	}

	static int[][] m3b(int tipo) {
		if (tipo < 1 || tipo > 3)
			return null;
		Random r = new Random();
		int[][] tablero;
		int minas = 0;
		switch (tipo) {
		case 1:
			tablero = new int[8][8];
			minas = 10;
			break;
		case 2:
			tablero = new int[16][16];
			minas = 40;
			break;
		case 3:
			tablero = new int[16][30];
			minas = 99;
			break;
		default:
			return null;
		}
		int fila;
		int columna;
		for (int i = 0; i < tablero.length; i++) {
			fila = r.nextInt(tablero.length);
			for (int j = 0; j < tablero[i].length; j++) {
				columna = r.nextInt(tablero[i].length);
				for (int w = 0; w < minas; w++) {
					tablero[fila][columna] = -1;
				}
			}
		}
		return tablero;
	}
}
