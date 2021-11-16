package Matrix;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception {
    	AddMatrix addmatrix = new AddMatrix();
    	MultiplyMatrix multiplymatrix = new MultiplyMatrix();
    	ExtendedMultiplication extendedmultiplication = new ExtendedMultiplication();

    	Scanner get = new Scanner(System.in);

    	char Y;
    	do{
        	System.out.println("1 - Adding Matrices\t 2 - Multiplying Matrices\t 3 - Transpose & Multiply Matrices");
        	System.out.print("Select Program To Run..: ");
        	int choice = get.nextInt();
        	System.out.println();

        	switch(choice){
            	case 1:
                	addmatrix.declaration();
                	break;
            	case 2:
            		multiplymatrix.declaration();
            		break;
            	case 3:
            		extendedmultiplication.declaration();
            		break;

            	default:
                	System.out.println("Sorry! Invalid Number..");
        	}

    	System.out.println();
    	System.out.println("Run Program Again? ");
    	System.out.println("Enter Y/N only.");
    	Y = get.next().charAt(0);
    	} while ( Y == 'y' || Y== 'Y');
	System.out.println("Thank you!");
	}

}
