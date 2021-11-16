package Matrix;
import java.util.Scanner;
import java.util.ArrayList;
	public class MultiplyMatrix {
	public static Scanner get = new Scanner(System.in);
    int MatrixNumber;
    int [] rows, columns, matrix;
    int Row, Column;
    ArrayList<int[]>MultiplyMatrix;
    ArrayList<int[]>temp = new ArrayList <>(1);
    int [] tempRow = new int [1];
    int [] tempColumn = new int [1];

	public void declaration(){
    	SettingUpMatrix();
	}
	private void SettingUpMatrix(){
    	/*
    	This method is for the setting up of the Matrix.
    	*/
    	System.out.print("Enter Number of Matrix: ");
    	this.MatrixNumber = get.nextInt();
    	this.MultiplyMatrix = new ArrayList<>(this.MatrixNumber);

    	this.rows = new int[this.MatrixNumber];
    	this.columns = new int[this.MatrixNumber];

    	CreatingMatrix();
	}
	private void CreatingMatrix(){
    	/*
    	This method is where the number of rows, columns and the value of the numbers inside the matrix is indicated.
    	*/

    	for (int i=0; i<this.MatrixNumber;i++){
        	System.out.println("\nCreating Matrix "+(i+1));
        	System.out.print("\t Enter Number of Rows: ");
        	Row = get.nextInt();
        	rows[i] = Row;

        	System.out.print("\t Enter Number of Columns: ");
        	Column = get.nextInt();
        	columns[i] = Column;

        	matrix = new int[Row*Column];
        	System.out.println("Matrix "+(i+1+" :"));
        	for (int j=0;j<matrix.length;j++){
            	System.out.print("\tMatrix Value "+(j+1)+" : ");
            	matrix[j] = get.nextInt();
        	}
        	MultiplyMatrix.add(matrix);
    	}
    	MultiplicationOfMatrix();
	}
	private void MultiplicationOfMatrix(){
    	/*
	 This method is where the multiplication of matrices happens if they have the same dimension.
	 */
    	int count = 1;
    	int [] Fmatrix, Smatrix;
    	int rowA, rowB, colA, colB = 0;
    	rowA = rows[(count-1)];
    	colA = columns[(count-1)];
    	temp.add(MultiplyMatrix.get(0));
    	MultiplyMatrix.remove(0);

    	while (!this.MultiplyMatrix.isEmpty()) {
        	rowB = this.columns[count];
        	colB = this.columns[count];
        	Fmatrix = this.temp.get(0);
        	Smatrix = this.MultiplyMatrix.get(0);
        	int [] product  = new int [rowA * colB];
        	int counter = 0;

        	for(int i = 0; i< rowA;i++) {
        		for(int j = 0; j<colB;j++){
                	for(int k = 0; k<colA;k++){
                		product[counter] += Fmatrix[(i* colA + k)] * Smatrix[(k*colB + j)];
                	}
                	counter++;
            	}
        	}
        	colA = colB;
        	count++;
        	MultiplyMatrix.remove(0);
        	temp.remove(0);
        	temp.add(product);
 }
    	int [] Temp;
    	Temp = temp.get(0);
    	System.out.println("\nProduct Of Matrices:");
    	for (int i=0; i<rowA*colA;i+=colA){
        	for (int j=0; j<colA;j++){
        	 System.out.print(Temp[(i+j)] +"\t");
        	}
        	System.out.println();
    	}
	}
}
