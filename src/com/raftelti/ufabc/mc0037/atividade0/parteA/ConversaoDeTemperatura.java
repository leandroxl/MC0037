package com.raftelti.ufabc.mc0037.atividade0.parteA;

public class ConversaoDeTemperatura {
	public static void main(String[] args) {
		System.out.println("Testes de convers\u00e3o:");
		
		double c,f,k;
		
		c = Math.random() * 200;
		f = celsiusParaFahrenheit(c);
		k = celsiusParaKelvin(c);

		System.out.printf("%.2f C -> %.2f F\n", c, f);
        System.out.printf("%.2f F -> %.2f C\n\n", f, fahrenheitParaCelsius(f));

        System.out.printf("%.2f C -> %.2f K\n", c, k);
        System.out.printf("%.2f K -> %.2f C\n\n", k, kelvinParaCelsius(k));

        System.out.printf("%.2f F -> %.2f K\n", f, fahrenheitParaKelvin(f));
        System.out.printf("%.2f K -> %.2f F\n", k, kelvinParaFahrenheit(k));
	}
	
	public static double celsiusParaFahrenheit(double x) {
		return (9.0 / 5.0) * x + 32;
	}

	public static double celsiusParaKelvin(double x) {
		return x + 273.15;
	}

	public static double fahrenheitParaCelsius(double x) {
		return (5.0 / 9.0) * (x - 32);
	}

	public static double fahrenheitParaKelvin(double x) {
		return (5.0 / 9.0) * (x + 459.67);
	}

	public static double kelvinParaCelsius(double x) {
		return x - 273.15;
	}

	public static double kelvinParaFahrenheit(double x) {
		return (9.0 / 5.0) * x - 459.67;
	}
}
