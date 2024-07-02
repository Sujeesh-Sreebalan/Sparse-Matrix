package programmingFundamental;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SparseMatrixTest {

	SparseMatrix obj1 = new SparseMatrix(new int[][] { { 0, 10, 0, 12 }, { 0, 0, 0, 0 }, { 0, 0, 5, 0 }, { 15, 12, 0, 0 } });
	SparseMatrix obj2 = new SparseMatrix(new int[][] { { 0, 0, 8, 0 }, { 0, 0, 0, 23 }, { 0, 0, 9, 0 }, { 20, 25, 0, 0 } });

	@Test
	public void transposeTest1() {
		int result[][] = obj1.transposeMatrix();
		int transpose[][] = new int[][] { { 0, 0, 0, 15 }, { 10, 0, 0, 12 }, { 0, 0, 5, 0 }, { 12, 0, 0, 0 } };
		assertArrayEquals(transpose, result);

	}
		
	@Test
	public void symmetryTest1() {
		SparseMatrix obj3 = new SparseMatrix(new int[][] { { 0, 5, 0 }, { 5, 0, 7 }, { 0, 7, 0 } });
		boolean result = obj3.symmetric();
		assertEquals(true, result);

	}
	
	@Test
	public void symmetryTest2() {
		SparseMatrix obj3 = new SparseMatrix(new int[][] { { 0, 5, 0, 0 }, { 5, 0, 7, 0 }, { 0, 7, 0, 0} });
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> obj3.symmetric());
		assertEquals("Given matrix is not a square matrix", exception.getMessage());	

	}

	@Test
	public void additionTest1() {
		int add[][] = SparseMatrix.matrixAddition(obj2, obj1);
		int sum[][] = new int[][] { { 0, 10, 8, 12 }, { 0, 0, 0, 23 }, { 0, 0, 14, 0 }, { 35, 37, 0, 0 } };
		assertArrayEquals(sum, add);

	}
	
	@Test
	public void additionTest2() {
		SparseMatrix add1 = new SparseMatrix(new int[][] { { 0, 10, 0 }, { 0, 0, 0 }, { 0, 0, 5}, { 15, 12, 0 } });
		SparseMatrix add2 = new SparseMatrix(new int[][] { { 0, 0, 8, 0 }, { 0, 0, 0, 23 }, { 0, 0, 9, 0 }, { 20, 25, 0, 0 } });
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SparseMatrix.matrixAddition(add1, add2));
		assertEquals("Cannot Do Addition", exception.getMessage());

	}

	@Test
	public void multiplicationTes1t() {
		int product[][] = SparseMatrix.matrixMultiplication(obj1, obj2);
		int multiplication[][] = new int[][] { { 240, 300, 0, 230 }, { 0, 0, 0, 0 }, { 0, 0, 45, 0 },
				{ 0, 0, 120, 276 } };
		assertArrayEquals(multiplication, product);

	}
	
	@Test
	public void multiplicationTest2() {
		SparseMatrix multiply1 = new SparseMatrix(new int[][] { { 0, 10, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 5, 0}, { 15, 12, 0, 0 } });
		SparseMatrix multiply2 = new SparseMatrix(new int[][] { { 0, 0, 8 }, { 0, 0, 0 }, { 0, 0, 9} });
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SparseMatrix.matrixMultiplication(multiply1, multiply2));
		assertEquals("Multiplication cannot be performed", exception.getMessage());

	}

}
