import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class TeamApt{


    //Here I am declaring and initialising the variables to store the count of numbers for each network
    private static int mtn = 0;
    private static int airtel = 0;
    private static int glo = 0;
    private static int nineMobile = 0;
    private static int mtel = 0;

    //This function accepts the file to be read and reads its content
    static void readFile(String file){

        //declaring variables to store get the number and its code
        String number = "";
        String firstFourDigits = "";
	String firstFiveDigits = "";

        try
        {
            //Using the Scanner method to read the file line by line
            //But first getting the file to be used with the FileInputStream method
            FileInputStream fis = new FileInputStream(file);
            Scanner sc = new Scanner(fis);

            while(sc.hasNextLine())
            {
                number = sc.nextLine();
                firstFourDigits = number.substring(0,4);
				
                //here I am checling to see if it's a 0702 number so I can expand it to 07025 or 07026
		if (firstFourDigits.equals("0702")){
			firstFiveDigits = number.substring(0,5);
			checkNumber(number, firstFiveDigits);
		}
		else{
			checkNumber(number, firstFourDigits);
		}
            }

            sc.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //This function uses the code gotten from the readFile function to assign and count the numbers 
    static void checkNumber(String number, String code){

        List<String> mtnCode = Arrays.asList("0703","0706","0803","0806","0810","0813","0814","0816","0903","0906","0913","0916","07025","07026","0704");
        List<String> airtelCode = Arrays.asList("0701","0708","0802","0808","0812","0901","0902","0904","0907","0912");
        List<String> gloCode = Arrays.asList("0705","0805","0807","0811","0815","0905","0915");
        List<String> nineMobileCode = Arrays.asList("0809","0817","0818","0909","0908");
        List<String> mtelCode = Arrays.asList("0804");


        if(mtnCode.contains(code)){
            mtn += 1;
        }
        else if (airtelCode.contains(code)){
            airtel += 1;
        }
        else if(gloCode.contains(code)){
            glo += 1;
        }
        else if(nineMobileCode.contains(code)){
            nineMobile += 1;
        }
        else if(mtelCode.contains(code)){
            mtel += 1;
        }

    }

    public static void main(String args[]){
		
	int total;

        TeamApt.readFile("PhoneNumbers.txt");

        System.out.println("Total MTN numbers: " + mtn);
        System.out.println("Total Airtel numbers: " + airtel);
        System.out.println("Total Globacom numbers: " + glo);
        System.out.println("Total 9Mobile numbers: " + nineMobile);
        System.out.println("Total MTEL numbers: " + mtel);
		
	total = mtn + glo + airtel + nineMobile +mtel;
		
	System.out.println("Total numbers available: " + total); 
    }
}
