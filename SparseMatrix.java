package programmingFundamental;

final class SparseMatrix {
	private int rows;
	private int columns;
	private int nonZero;
	private int matrix[][];
	
	/**
	 * 
	 * @param arr Input array 
	 * @throws IllegalArgumentException if size is of array is zero or Count of non zero is more than zeros then exception is thrown
	 */
	public SparseMatrix(int arr[][]) throws IllegalArgumentException {
		if (countZeros(arr)) {
			throw new IllegalArgumentException("Not a sparse matrix");
		}
		if (arr.length == 0) {
			throw new IllegalArgumentException("Empty Array");
		}

		this.rows = arr.length;
		this.columns = arr[0].length;
		int count = 0;
		// for space efficiency, storing only non zero elements of a matrix.
		matrix = new int[nonZero][3];
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != 0) {
					// Storing row
					matrix[count][0] = i;
					// Storing column
					matrix[count][1] = j;
					// Storing value
					matrix[count][2] = arr[i][j];
					count++;
				}
			}
		}
	}
	
	/**
	 * Function to transpose the matrix
	 * 
	 * @return transposed Matrix
	 */
	public int[][] transposeMatrix() {
		int transMat[][] = new int[nonZero][3];
		for (int i = 0; i < nonZero; i++) {
			transMat[i][0] = matrix[i][1];
			transMat[i][1] = matrix[i][0];
			transMat[i][2] = matrix[i][2];
		}

		int result[][] = new int[rows][columns];
		for (int i = 0; i < nonZero; i++) {
			result[transMat[i][0]][transMat[i][1]] = transMat[i][2];
		}

		return result;
	}

	/**
	 * Function to Check matrix is symmetric or not
	 * 
	 * @return if matrix is symmetric then return true else false
	 */
	public boolean symmetric() throws IllegalArgumentException{
		if(this.rows != this.columns) {
			throw new IllegalArgumentException("Given matrix is not a square matrix");
		}
		boolean flag = true;
		for (int i = 0; i < nonZero; i++) {
			if (getElement(matrix[i][0], matrix[i][1]) != getElement(matrix[i][1], matrix[i][0])) {
				flag = false;
			}
		}
		return flag;
	}
	
	/**
	 * Helper function to retrive the value from the sparseMatrix
	 * 
	 * @param row checking if any value is present 
	 * @param col checking if any value is present
	 * @return the value if present else zero
	 */
	private int getElement(int row, int col) {
		int value = 0;
		for (int i = 0; i < nonZero; i++) {
			if (matrix[i][0] == row && matrix[i][1] == col) {
				value = matrix[i][2];
			}
		}
		return value;
	}
	
	/**
	 * Function to calculate addition of two matrix
	 * 
	 * @param mat1 input matrix 
	 * @param mat2 input matrix
	 * @return addition of both array
	 * @throws IllegalArgumentException if rows and columns of both matrix are same then exception is thrown
	 */
	public static int[][] matrixAddition(SparseMatrix mat1, SparseMatrix mat2) throws IllegalArgumentException {

		if (mat1.rows != mat2.rows || mat1.columns != mat2.columns) {
			throw new IllegalArgumentException("Cannot Do Addition");
		}

		int add[][] = new int[mat1.rows][mat1.columns];
		for (int i = 0; i < mat1.rows; i++) {
			for (int j = 0; j < mat1.columns; j++) {
				add[i][j] = mat1.getElement(i, j) + mat2.getElement(i, j);
			}
		}
		return add;
	}
	
	/**
	 * Function tio chcek the multiplication od two matrix 
	 * 
	 * @param mat1 input matrix 
	 * @param mat2 input matrix
	 * @return multiplication of both matrix
	 * @throws IllegalArgumentException if columns of first does not match with rows of second matrix then exception is thrown
	 */
	public static int[][] matrixMultiplication(SparseMatrix mat1, SparseMatrix mat2) throws IllegalArgumentException {

		if (mat1.columns != mat2.rows) {
			throw new IllegalArgumentException("Multiplication cannot be performed");
		}

		int multiply[][] = new int[mat1.rows][mat2.columns];

		for (int i = 0; i < mat1.rows; i++) {
			for (int j = 0; j < mat2.columns; j++) {
				for (int k = 0; k < mat1.columns; k++) {
					multiply[i][j] += mat1.getElement(i, k) * mat2.getElement(k, j);
				}
			}
		}
		return multiply;
	}
	
	/**
	 * Function to count the non zeros element in the input array
	 * 
	 * @param arr input array
	 * @return if nonZero value are more than zeros then return false else true
	 */
	private boolean countZeros(int arr[][]) {
		int zeros = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					zeros++;
				} else {
					this.nonZero++;
				}
			}

		}
		if (zeros > this.nonZero)
			return false;
		return true;
	}

	/**
	 * Function to print the sparse matrix
	 */
	void print() {
		System.out.println(" ");
		System.out.println(" ");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(matrix[i][0] + " " + matrix[i][1] + " " + matrix[i][2]);
		}
	}

}

