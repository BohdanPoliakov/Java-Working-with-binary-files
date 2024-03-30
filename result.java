import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choise;
		String choiseStr;

		loop: while (true) {

			System.out.println("\n1) Create");
			System.out.println("2) Calculate");
			System.out.println("3) View");
			System.out.println("4) About");
			System.out.println("5) Exit");
			System.out.println("\nInput number from 1 till 5: ");
			
			choiseStr = sc.nextLine();
			
			try {
				choise = Integer.parseInt(choiseStr);
				if (choise < 1 || choise > 5) {
					throw new Exception();
				}
			}
			catch (Exception ex) {
				System.out.println("please, input number from 1 till 5");
				continue;
			}
			

			switch (choise) {
			case 1:
				create();
				break;
			case 2:
				calculate();
				break;
			case 3:
				view();
				break;
			case 4:
				about();
				break;
			case 5:
				break loop;
			}
		}

		sc.close();

	}

	public static void create() {
		
		String filename;
		System.out.print("\nInput file name: ");
		filename = sc.nextLine();
		
		int count;
		String inputStr;
		
		System.out.print("input count of numbers: ");
		try {
			inputStr = sc.nextLine();
			count = Integer.parseInt(inputStr);
		}
		catch (Exception ex){
			System.out.println("input-output error");
			return;
		}

		try {
			DataOutputStream out = new DataOutputStream(
					new FileOutputStream(filename));

			for (int i = 1; i <= count; i++) {
				System.out.print("input number: ");
				try {
					inputStr = sc.nextLine();
					int number = Integer.parseInt(inputStr);
					out.writeInt(number);
				}
				catch (Exception e) {
					System.out.println("input-output error");
					break;
				}
			}
			
			out.close();
		} 
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void calculate() {
    String filename;
    int numberToDelete;

    System.out.print("\nInput file name: ");
    filename = sc.nextLine();

    System.out.print("Input number to delete: ");
    try {
        numberToDelete = sc.nextInt();
    } catch (Exception ex) {
        System.out.println("Input error");
        sc.nextLine(); 
        return;
    }

    try {
        DataInputStream in = new DataInputStream(new FileInputStream(filename));
        DataOutputStream out = new DataOutputStream(new FileOutputStream(filename + ".tmp"));

        boolean EOF = false;
        while (!EOF) {
            try {
                int i = in.readInt();
                if (i != numberToDelete) {
                    out.writeInt(i);
                }
            } catch (EOFException e) {
                EOF = true;
            } catch (IOException e) {
                System.out.println("Error reading from file");
                break;
            }
        }

        in.close();
        out.close();

        // Pārdēvējam pagaidu failu par galveno failu
        File oldFile = new File(filename);
        File newFile = new File(filename + ".tmp");
        if (newFile.renameTo(oldFile)) {
            System.out.println("Numbers deleted successfully.");
        } else {
            System.out.println("Error renaming the file.");
        }

    } catch (FileNotFoundException ex) {
        System.out.println("File not found: " + ex.getMessage());
    } catch (IOException ex) {
        System.out.println("IO error: " + ex.getMessage());
    }
}

	public static void view() {
		String filename;
		DataInputStream in = null;
		int i = 0;

		System.out.print("\nInput file name: ");
		filename = sc.nextLine();
		
		try {
			in = new DataInputStream(new FileInputStream(filename));
		} 
		catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			return;
		}

		System.out.print("\nContent of file: ");
		boolean EOF = false;
		while (!EOF) {
			try {
				i = in.readInt();
				System.out.print(i + " ");
			} 
			catch (EOFException e) {
				EOF = true;
			} 
			catch (IOException e) {
				System.out.println("bad file format, not all numbers has been read succesfully");
				break;
			}
		}
		
		try {
			in.close();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
	}

	public static void about() {
		// TODO insert information about author
		System.out.println("Poliakov Bohdan");
	}

}