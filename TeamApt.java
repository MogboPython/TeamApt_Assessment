import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TeamApt{


    //Here I am declaring the lists to store the numbers for each network
    private static List<String> mtn = new ArrayList<String>();
    private static List<String> airtel = new ArrayList<String>();
    private static List<String> glo = new ArrayList<String>();
    private static List<String> nineMobile = new ArrayList<String>();
    private static List<String> mtel = new ArrayList<String>();

    //This function accepts the file to be read and reads its content
    static void readFile(String file){

        //declaring variables to store get the number and its code
        String number = "";
        String firstFourDigits = "";

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
                checkNumber(number, firstFourDigits);
            }

            sc.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //This function uses the code gotten from the readFile function to assign add
    //the numbers to the list they belong to 
    static void checkNumber(String number, String code){

        List<String> mtnCode = Arrays.asList("0703","0706","0803","0806","0810","0813","0814","0816","0903","0906","0913","0916","07025","07026","0704");
        List<String> airtelCode = Arrays.asList("0701","0708","0802","0808","0812","0901","0902","0904","0907","0912");
        List<String> gloCode = Arrays.asList("0705","0805","0807","0811","0815","0905","0915");
        List<String> nineMobileCode = Arrays.asList("0809","0817","0818","0909","0908");
        List<String> mtelCode = Arrays.asList("0804");


        if(mtnCode.contains(code)){
            mtn.add(number);
        }
        else if (airtelCode.contains(code)){
            airtel.add(number);
        }
        else if(gloCode.contains(code)){
            glo.add(number);
        }
        else if(nineMobileCode.contains(code)){
            nineMobile.add(number);
        }
        else if(mtelCode.contains(code)){
            mtel.add(number);
        }

    }

    public static void main(String args[]){

        TeamApt.readFile("PhoneNumbers.txt");

        System.out.println("MTN numbers: " + mtn.toString()+"\n");
        System.out.println("Airtel numbers: " + airtel.toString()+"\n");
        System.out.println("Globacom numbers: " + glo.toString()+"\n");
        System.out.println("9Mobile numbers: " + nineMobile.toString()+"\n");
        System.out.println("MTEL numbers: " + mtel.toString());
    }
}