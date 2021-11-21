package lockers_Pvt_Ltd;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class LookedMe {
	
	public static void printWelcomeScreen(){
        System.out.println("******************************\n" + "*  Welcome to LockeMe.com");
        System.out.println("*  Developed by Rushikesh Ghale\n" + "******************************");
        System.out.println("1. Registration\n"+"2. login\n"+"*****************************");
        System.out.println("you can use this appication to:-\n"+"*  retrive all files in \"main\" folder");
        System.out.println("* search,add or delete files in \"main\" folder \n"+"================================");
        System.out.println("****:- please be careful to ensure the correct filename is provided for searching or deleting file -:****");
    }
	
	
	 public static void main(String[] args) throws IOException {

		        printWelcomeScreen();


		        File ob = new File("C:\\Users\\hp\\eclipse-workspace\\LockedMe.com\\Main");
		        if (ob.exists()) {
		            System.out.println("\"Main\" folder is allready present is project directory\n");
		        } else {
		            ob.mkdir();
		            System.out.println("\"Main\" folder is created\n");
		        }

		        Scanner sc = new Scanner(System.in);

		        int input_choice = 0;
		        int input_choice_2 = 0;
		        boolean running=true;
		        int flag=0;
		      

		        do {
		            System.out.println("****** select any option number from below and press enter******");
		            System.out.println("Enter 1 Retrieve all the files inside the \"main\" folder ");
		            System.out.println("Enter 2 for display menu  for file operation");
		            System.out.println("Enter 3 for Exit the application");

		            input_choice = sc.nextInt();

		            switch (input_choice) {
		                case 1:
		                    if(ob.isDirectory()) {

		                        File array[] = ob.listFiles();
		                        Arrays.sort(array);
		                        System.out.println("total number of items present in the \"main\" folder: "+array.length);

		                        for (File file : array) {
		                            System.out.println(file.getName());
		                        }
		                    }
		                    break;

		                case 2:
		                    do {

		                        System.out.println("Enter 1 for creating new file in to \"main\" folder");
		                        System.out.println("Enter 2 for Delete File from \"main\" folder");
		                        System.out.println("Enter 3 for show the respective file name starting with given name form \"main\"folder");
		                        System.out.println("Enter 4 to go to the previous menu");
		                        System.out.println("Enter 5 to terminate the application");
		                        

		                        input_choice_2 = sc.nextInt();
		                        switch (input_choice_2) {
		                            case 1:
		                                // creating the file
		                                System.out.println("Enter File name,for creating new file");
		                                String fileName = sc.next();
		                                File myFile = new File("Main", fileName);
		                                myFile.createNewFile();
		                                
		                                System.out.println("file is successfully created");
		                                break;


		                            case 2:
		                                // here delete file
		                                System.out.println("Enter the file name to delete");
		                                String filename_2 = sc.next();
		                                File myFile_2 = new File("Main", filename_2);
		                                if (myFile_2.delete()) {
		                                    System.out.println("i have deleted:" + filename_2);
		                                } else {
		                                    System.out.println("some problems occurred while deleting file");
		                                }
		                                break;

		                            case 3:
		                                // here show the respective files starting with given name
		                                System.out.println("Enter the name to display respective files starting with entered name");
		                                File array[]=ob.listFiles();
		                                 String Name =sc.next();

		                                    for (File file : array){
		                                        if(file.getName().startsWith(Name)){
		                                            System.out.println(file.getName());
		                                        }
		                                    }

		                                    break;

		                            case 4:
		                            	System.out.println("returned to the previous menu");

		                                flag =1;
		                                break;

		                            case 5:
		                            	flag=1;
		                                running=false;
		                                System.out.println("Program is terminated successfully");
		                                break;

		                            default:
		                                System.out.println("please enter correct input value and retry");
		                                break;

		                        }
		                    } while (flag==0);
		                    break;

		                case 3:
		                    System.out.println("program terminated successfully");
		                    running=false;
		                    sc.close();
		                    break;

		                default:
		                    System.out.println("please enter correct input value and retry");
		            }
		        } while (running==true);
 
	 }
}
