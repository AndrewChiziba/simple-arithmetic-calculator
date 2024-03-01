import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //String filepath = args[0];
        String filepath = "readme.txt";
        BufferedWriter myWriter;
        BufferedReader myReader;
        try {
            //read from this file
            myReader = new BufferedReader(new FileReader(filepath));
            //write to this file
            myWriter = new BufferedWriter(new FileWriter("output.txt"));
            String myBuffer;
            //read line by line until end of file
            while((myBuffer = myReader.readLine()) != null){
                //get value from cal. and write to file
                myWriter.write(String.valueOf(getResult(myBuffer)));
                myWriter.append('\n');
            }
            myWriter.close();
            myReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static double getResult(String mathExpression) {
        String mathOperand = "";
        int operandIndex = 0;

        //loop through line to find operand
        for(int i=0;i<mathExpression.length();i++){
            if((mathExpression.charAt(i) == '+') || (mathExpression.charAt(i) == '-')
                    || (mathExpression.charAt(i) == '*') || (mathExpression.charAt(i) == '/')){
                mathOperand = String.valueOf(mathExpression.charAt(i));
                operandIndex= i;
                //stop loop on operand
                break;
            }
        }
        //get first value, convert from str to double
        double firstVal = Double.parseDouble(mathExpression.substring(0,(operandIndex)));
        //get second value, convert from str to double
        double secondVal = Double.parseDouble(mathExpression.substring(operandIndex+1));
        double result = 0;
        switch (mathOperand){
            //execute equation according to operand
            case "+":
                result = firstVal+secondVal;
                break;
            case "-":
                result = firstVal-secondVal;
                break;
            case "*":
                result = firstVal*secondVal;
                break;
            case "/":
                result = firstVal/secondVal;
                break;
        }
        return result;
    }
}