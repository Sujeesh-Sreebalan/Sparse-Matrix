package programmingFundamental;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SparseMatrixMainClass {

	public static void printMatrix(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr1[][] = { { 0, 0, 1 }, { 0, 0, 3 }, { 1, 3, 0 } };
		int arr2[][] = { { 0, 1, 0 }, { 0, 0, 2 }, { 3, 0, 0 } };
		
		System.out.println("First Matrix: ");
		SparseMatrixMainClass.printMatrix(arr1);
		
		System.out.println("Second Matrix: ");
		SparseMatrixMainClass.printMatrix(arr2);

		SparseMatrix m1 = new SparseMatrix(arr1);
		SparseMatrix m2 = new SparseMatrix(arr2);

		try {
			while (true) {
				System.out.println("\n1.Transpose of Matrix \n2.Check Symmetrix \n3.Addition of two matrix \n4.Multiplication of two matrix");
				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					int transpose[][] = m1.transposeMatrix();
					System.out.println("Transpose of the Matrix: ");
					SparseMatrixMainClass.printMatrix(transpose);
					System.out.println();
					break;

				case 2:
					if (m1.symmetric()) {
						System.out.println("M1 matrix is symmetrix");
					} else {
						System.out.println("M1 matrix is not symmetrix");
					}
					
					break;

				case 3:
					System.out.println("\nAddition of two Matrix: ");
					int add[][] = SparseMatrix.matrixAddition(m1, m2);
					SparseMatrixMainClass.printMatrix(add);
					System.out.println();
					break;

				case 4:
					System.out.println("Multiplication of two matrix: ");
					int multiply[][] = SparseMatrix.matrixMultiplication(m1, m2);
					SparseMatrixMainClass.printMatrix(multiply);
					System.out.println();
					break;
				}

			}
		} catch (InputMismatchException e) {
			System.out.println("Enter correct input");
		}finally {
			sc.close();
		}
	}

}
