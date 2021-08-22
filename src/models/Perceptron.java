package models;


public class Perceptron {

	public static double APRENDIZAJE = 0.25;
	private int [][] dataSet = {{1,0,1,0,0,1,1},{0,0,1,0,0,1,1},{0,1,1,1,1,0,0}};
	public double pesoX1, pesoX2,pesoX3,pesoX4,pesoX5,pesoX6, baias;
	
	public Perceptron() {
		this.pesoX1 = 0;
		this.pesoX2 = 0;
		this.pesoX3 = 0;
		this.pesoX4 = 0;
		this.pesoX5 = 0;
		this.pesoX6 = 0;
		this.baias = 0;
	}
	
	private int hardLimit(double value) {
		if (value >= 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public void aprendizaje() {
		System.out.println("Iniciando Aprendizaje....");
		for (int i = 0; i < 100; i++) {
			evaluarPesos();
		}
		System.out.println("Aprendizaje terminado");
//		imprimirSalida();
	}

//	private void imprimirSalida() {
//		for (int i = 0; i < dataSetNeurona1.length; i++) {
//			int hardLimitN1 = hardLimit(dataSetNeurona1[i][0] * pesoN1X1 + dataSetNeurona1[i][1] * pesoN1X2 - baiasN1);
//			int hardLimitN2 = hardLimit(dataSetNeurona2[i][0] * pesoN2X1 + dataSetNeurona2[i][1] * pesoN2X2 - baiasN2);
//			
//			if (i == 1) {
//				System.out.println(hardLimitN2+" | "+hardLimitN1+" = "+resultado(hardLimitN2, hardLimitN1));
//			} else {
//				System.out.println(hardLimitN1+" | "+hardLimitN2+" = "+resultado(hardLimitN1, hardLimitN2));
//			}
//		}
//	}

//	private int resultado(int x1, int x2) {
//		return x1==1&&x2==0||x1==0&&x2==1?1:0;
//	}
	
	private double calculeYValue(int x1,int x2,int x3,int x4,int x5,int x6) {
		return x1* pesoX1 + x2 * pesoX2 + x3 * pesoX3 + x4 * pesoX4 + x5 * pesoX5 + x6 * pesoX6 - baias;
	}
	 
	private void evaluarPesos() {
		
//		imprimirSalida();
		for (int i = 0; i < dataSet.length; i++) {
			
			double y = calculeYValue(dataSet[i][0], dataSet[i][1], dataSet[i][2], dataSet[i][3], dataSet[i][4], dataSet[i][5]);

			int hardLimit = hardLimit(y);

			int error = dataSet[i][6] - hardLimit;

			double delta1 = APRENDIZAJE * error * dataSet[i][0];
			double delta2 = APRENDIZAJE * error * dataSet[i][1];
			double delta3 = APRENDIZAJE * error * dataSet[i][2];
			double delta4 = APRENDIZAJE * error * dataSet[i][3];
			double delta5 = APRENDIZAJE * error * dataSet[i][4];
			double delta6 = APRENDIZAJE * error * dataSet[i][5];


			pesoX1 = pesoX1 + delta1;
			pesoX2 = pesoX2 + delta2;
			pesoX3 = pesoX3 + delta3;
			pesoX4 = pesoX4 + delta4;
			pesoX5 = pesoX5 + delta5;
			pesoX6 = pesoX6 + delta6;
			baias = baias - (APRENDIZAJE * error);
//			System.out.println("----------------------------------");
		}
	}

//	public void mostrarEcuaciones() {
//		System.out.println("Ecuacion de la neurona 1: " + pesoN1X1 + " * X1 + " + pesoN1X2 + " * X2 - " + baiasN1);
//		System.out.println("Ecuacion de la neurona 2: " + pesoN2X1 + " * X1 + " + pesoN2X2 + " * X2 - " + baiasN2);
//	}
	
	public String textPerceptron(int x1,int x2,int x3,int x4,int x5,int x6) {
		return (hardLimit(calculeYValue(x1, x2, x3, x4, x5, x6)) == 1) ? "Hombre":"Mujer";
	}
	
	public static void main(String[] args) {
		Perceptron perceptron = new Perceptron();
		perceptron.aprendizaje();
		System.out.println(perceptron.textPerceptron(1, 1, 1, 0, 1, 0));
	}
}
