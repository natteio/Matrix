package Matrix;
import java.util.Scanner;
import java.util.ArrayList;

public class ExtendedMultiplication {
	public Scanner get = new Scanner (System.in);
	int [] rows, columns;
	ArrayList<int[][]>ExtendedMultiplication;
	ArrayList<int[][]>temp;

	int NumberOfMatrix = 2;

	public void declaration() {
		ExtendedMultiplication = new ArrayList<int[][]>(this.NumberOfMatrix);
		temp = new ArrayList<int [][]>(1);
		this.rows = new int [this.NumberOfMatrix];
		this.columns = new int [this.NumberOfMatrix];

		for (int i=0;i<this.NumberOfMatrix;i++) {
			System.out.println("\nCreating Matrix "+(i+1));

			System.out.print("\tEnter Number of Rows: ");
			int rows = get.nextInt();
			this.rows[i] = rows;

			System.out.print("\tEnter Number of Columns: ");
			int columns = get.nextInt();
			this.columns[i] = columns;

			int [][] matrix = new int [rows][columns];
			System.out.println("Matrix "+(i+1+" :"));
			for (int x=0, count=1;x<rows;x++) {
				for (int y=0; y<columns; y++,count++) {
					System.out.print("\tMatrix Value "+(count)+" : ");
					matrix[x][y] = get.nextInt();
				}
			}
			this.ExtendedMultiplication.add(matrix);
		}
		MultiplyMatrix();
	}
	private void DisplayMatrix() {
		int counter =0;
		for (int i=0; i<this.NumberOfMatrix;i++){
        	int [][] matrix = this.ExtendedMultiplication.get(counter);

        	System.out.println("\nMATRIX "+(counter+1));
        	for (int k=0;k<this.rows[counter];k++) {
                	for (int l=0; l<this.columns[counter];l++) {
                		System.out.print(matrix[k][l]+ "\t");
            	}
            	System.out.println();
        	}
        	counter++;
    	}
		ExtendedMultiplication();
	}
	private void MultiplyMatrix() {
		int matrix_1[][] = this.ExtendedMultiplication.get(0);
		int matrix_2[][] = this.ExtendedMultiplication.get(1);
		int count = 0;


		if (this.columns[count] == this.rows[(count+1)]) {
			int product[][]= new int [this.rows[count]][this.columns[(count+1)]];

			for(int i = 0; i < this.rows[0]; i++) {
				for (int x = 0; x < this.columns[(count+1)]; x++) {
					for (int y = 0; y < this.columns[0]; y++) {
						product[i][x] += matrix_1[i][y] * matrix_2[y][x];
					}
				}
			}
			this.temp.add(product);

			System.out.println("\nThe Product of Two Matrices");
			for(int i = 0; i < this.rows[0]; i ++) {
				for(int k = 0; k < this.columns[(count+1)]; k++) {
					System.out.print(product[i][k] + "\t");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("Matrix 1 (Column) is not the same with Matrix 2 (Row)");
		}
		DisplayMatrix();
	}
	private void ExtendedMultiplication() {
		System.out.println();
		System.out.println("\nThis process here shows the Extended Multiplication Processs");
		int counter = 0;
		int [][] matrixA = this.ExtendedMultiplication.get(0);
		int [][] matrixB = this.ExtendedMultiplication.get(1);

		int row_A [] = new int [this.columns[0]];
		int column_B [] = new int [this.rows[(counter+1)]];

		int node[] = new int [(row_A.length + column_B.length)/2];

		System.out.print("\tEnter Row Number: ");
		int Row = get.nextInt();
		for(int i = (Row-1); i < Row; i++) {
			for (int k = 0; k < this.columns[0]; k++) {
				row_A[k] = matrixA[i][k];
			}
		}
		for (int i = 0; i < row_A.length; i++) {
			System.out.print("\t"+row_A[i]);
		}
		System.out.println();

		System.out.print("\tEnter Column Number: ");
		int Column = get.nextInt();
		for(int i = 0; i < this.rows[(counter+1)]; i++) {
			for(int k = 0; k < this.columns[(counter+1)]; k++) {
				if (k == (Column-1)) {
					column_B[i] = matrixB[i][k];
				}
			}
		}
		for (int i = 0; i < column_B.length; i++) {
			System.out.print("\t");
			System.out.println(column_B[i]);
		}

		for(int i = 0; i <node.length; i++) {
			node[i] = row_A[i] * column_B[i];
		}
		System.out.println("\tTranspose Row:");
		for (int i = 0; i <row_A.length; i++) {
			System.out.println("\t\t"+row_A[i]);
		}
		System.out.println();

		int total = 0;
		for(int i = 0; i <node.length; i++) {
			total+= node[i];
		}
		System.out.println("The result is : " + total);

	}
}
