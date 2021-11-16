package Matrix;
import java.util.Scanner;
import java.util.ArrayList;
public class AddMatrix {
public static Scanner get = new Scanner (System.in);

	int MatrixNumber;
	int getR, getC = 0;
	int [] rows, columns;
	int Rows, Columns;
	ArrayList<int[]>AddMatrix;

	public void declaration(){
    	SettingUpMatrix();
	}
	private void SettingUpMatrix(){
    	/*
    	This method is for the setting up of the Matrix.
    	*/
    	System.out.print("Enter Number of Matrix: ");
    	this.MatrixNumber = get.nextInt();
    	this.AddMatrix = new ArrayList<int[]>(this.MatrixNumber);

    	this.rows = new int[this.MatrixNumber];
    	this.columns = new int[this.MatrixNumber];

    	CreatingMatrix();
	}
	private void CreatingMatrix(){
    	/*
    	This method is where the number of rows, columns and the value of the numbers inside the matrix is indicated.
    	*/

    	for (int i=0; i<this.MatrixNumber;i++){
        	int [] matrix = null;
        	System.out.println("\nCreating Matrix "+(i+1));
        	System.out.print("\t Enter Number of Rows: ");
        	this.Rows = get.nextInt();
        	this.rows[i] = this.Rows;

        	System.out.print("\t Enter Number of Columns: ");
        	this.Columns = get.nextInt();
        	this.columns[i] = this.Columns;

        	matrix = new int[this.Rows*this.Columns];
        	System.out.println("Matrix "+(i+1+" :"));
        	for (int j=0;j<matrix.length;j++){
            	System.out.print("\tMatrix Value "+(j+1)+" : ");
            	matrix[j] = get.nextInt();
        	}
        	this.AddMatrix.add(matrix);
    	}
    	this.getC = this.columns[0];
    	this.getR = this.rows[0];

    	DimensionEvaluationOfMatrix();
	}
	private void DimensionEvaluationOfMatrix(){
    	/*
    	This method is where the evaluation of matrices happens.
    	*/
    	int counter = 1;
    	boolean evaluate = false;
    	int first = 1;
    	// row[0,1]
    	// col[0,1]
    	while (counter < this.MatrixNumber){
        	if (this.rows[0] == this.rows[(counter)] && this.columns[0] == this.columns[(counter)]) {
            	System.out.println();
            	System.out.println("Matrices have the same dimension.");
        	}
        	else {
            	System.out.println();
            	System.out.println("Matrices don't have the same dimension.");
        	}
        	counter++;
        	evaluate = true;
    	}
     	AdditionOfMatrix();
	}
	private void AdditionOfMatrix(){
    	/*
    	This method is where the addition of matrices happens if they have the same dimension.
    	*/
    	int [] total;
    	total = this.AddMatrix.get(0);
    	Display();
    	System.out.println();

    	for (int i=1;i<this.AddMatrix.size();i++){
        	int [] second = this.AddMatrix.get(i);
        	for (int y=0; y<total.length;y++){
            	total[y] = total[y]+second[y];
        	}
    	}

    	System.out.println("Sum Of Matrices:");
    	for (int i=0; i<this.getR*getC;i+=this.getC){
        	for (int j=0; j<this.getC;j++){
            	System.out.print(total[(i+j)] +"\t");
        	}
        	System.out.println();
    	}
	}
	private void Display(){
    	/*
    	This method is where the matrices is displayed.
    	*/
    	for (int i=0; i<this.MatrixNumber;i++){
        	int [] matrix = this.AddMatrix.get(i);

        	System.out.println("\nMATRIX "+(i+1));
        	for (int k=0;k<this.Rows*this.Columns;k+=this.Columns) {
                	for (int l=0; l<this.Columns;l++) {
                		System.out.print(matrix[(k+l)]+ "\t");
            	}
            	System.out.println();
        	}
    	}
	}
}
