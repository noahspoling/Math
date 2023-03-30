package lib;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Class: BigNumber.java
 * Author: Noah Poling
 * Description: Class for Implementing a Linked List to store large numbers and perform operations on them
 * Used in the child classes of the abstract term class.
 * 
 * TODO Using Regex validation with boolean fields to handle if statements on if there is a decimal
 * numbers, check for signifigant figures, and handle exponential values from strings
 */
public class BigNumber {
    /*
     * Uses linked list of Integers and Decimal Values 
     * TODO Add boolean support for imaginary numbers
     * TODO Add support for changing base value, maybe using static class HashMaps for conversion.
     */

    boolean negative = false;
    boolean imaginary = false;
    byte base = 10;
    public LinkedList<Byte> integer = new LinkedList<Byte>();
    public LinkedList<Byte> decimal = new LinkedList<Byte>();

    //Static Class Field for pattern for all real numbers TODO Add pattern support for exponential and imaginary
    //Map for converting numbers from strings to integers
    //Pattern positive/negative real number
    static Pattern pattern = Pattern.compile("[+-]?([0-9]*[.]?[0-9]+[.]?[0-9]*)");
    static Map<String, Byte> convert = new HashMap<String, Byte>() {{
        put("0", (byte) 0); put("1", (byte) 1);
        put("2", (byte) 2); put("3", (byte) 3);
        put("4", (byte) 4); put("5", (byte) 5);
        put("6", (byte) 6); put("7", (byte) 7);
        put("8", (byte) 8); put("9", (byte) 9);
    }};


    /*
     * Constructor for handling new BigNumber Instances using a string.
     */
    public BigNumber(String value){
        Matcher matcher = BigNumber.pattern.matcher(value);
        boolean match = matcher.find();
        if(match){
            System.out.println("Match worked for: " + value);

            //Standardizes the string to remove +/- symbols
            if(value.startsWith("-", 0)) {
                //If input is negative set field to negative
                this.negative = true;
                value = value.replaceAll("-", "");
            }
            else if(value.startsWith("+", 0)) {
                //remove optional plus symbol
                value = value.replaceAll("\\+", "");
            }

            //Splits the array by the period
            String[] valueArr = value.split("\\.", 2);

            //If statement to handle if there was a decimal found. Appends by digit to the end of the linked list
            if(valueArr.length == 2) {
                byte val = 0;
                valueArr[1] = valueArr[1].replaceAll("\\.", "");
                for(int i = 0; i < valueArr[0].length(); i++) {
                    val += BigNumber.convert.get("" + valueArr[0].charAt(i));
                    this.integer.addLast(
                        BigNumber.convert.get("" + valueArr[0].charAt(i))
                        );
                }
                for(int i = 0; i < valueArr[1].length(); i++) {
                    val += BigNumber.convert.get("" + valueArr[1].charAt(i));
                    //Blank space to cast char as string for HashMap
                    this.decimal.addLast(
                        BigNumber.convert.get("" + valueArr[1].charAt(i))
                        );
                }
            }
            //Else statement for numbers without a decimal value
            else {
                for(int i = 0; i < valueArr[0].length(); i++) {
                    this.integer.addLast(
                        BigNumber.convert.get("" + valueArr[0].charAt(i))
                        );
                }

            }

        }
        else{
            throw new Error("Error: Pattern Match not working for: " + value);
        }

    }
    public BigNumber(int value){
        int i = 1;
        //loop using modelo operator to get remainder of divide by 10 then move on to the next digit
        while(value > 10){
            int digit = value % 10;
            this.integer.addLast((byte) digit);
            value = (value - digit) / 10;
            i++;
        }
    }
    public BigNumber(double value){
        if(value < 0) {
            this.negative = true;
        }
        //If new it keeps the default empty array;
        if (value == 0) {
            return;
        }
        //remainder of divide by 1 gets the values after the decimal
        //int casting always rounds down number
        double decimalValue = value % 1;
        int integerValue = (int)value;
        int i = 1;
        //loop using modelo operator to get remainder of divide by 10 then move on to the next digit
        while(integerValue > 10){
            int digit = integerValue % 10;
            this.integer.addLast((byte) digit);
            integerValue = (integerValue - digit) / 10;
            i++;
        }
    }



    //Static class methods for operations with two parameters of the BigNumber class

    /*
     * Compare: Takes two numbers and finds the bigger one.
     * -1: n1 greater 0: equal 1: n2 greater
     * checks conditions that involve not iterating over data first
     * Boolean parameter to ignore sign in comparison for division.
     */
    public static byte compare(BigNumber n1, BigNumber n2, boolean ignoreSign){
        //If n1 if negative only
        if(n1.negative == true && n2.negative != true && ignoreSign == false ) {
            return 1;
        }
        else if (n1.negative != true && n2.negative == true && ignoreSign == false ) {
            return -1;
        }
        //If both are positive
        else if (n1.negative != true && n2.negative != true ) {
            //If integer value has more elements in Linked LIst (more digits)
            if(n1.integer.size() > n2.integer.size()) {
                return -1;
            }
            //If n2 has more integer digits
            else if (n1.integer.size() < n2.integer.size()) {
                return 1;
            }
            //If n1 and n2's first digit is the same
            else if (n1.integer.size() == n2.integer.size()) {
                //If two integer are 
                boolean lowerNumFound = false;
                while(lowerNumFound != true) {

                }
            }

        }
        else if (n1.negative != true && n2.negative != true) {

        }

    }
    public static BigNumber addition(BigNumber n1, BigNumber n2){
        String newNumber;
        int decimalDifference = n2.decimal.size() - n1.decimal.size(); 
        int integerDifference = n2.integer.size() - n1.integer.size(); 

        //If both negative or positive:
        //Will check again if negative at the end of method if a negative symbol is needed
        if(n1.negative == true && n2.negative == true || n1.negative != true && n2.negative != true) {
            
        }
        if(n1.negative == false)
        //If decimal difference is negative then n2 has less decimal places and vice versa
        if(decimalDifference < 0) {
        }
        else if (decimalDifference) {

        }
        return new BigNumber("1221");
    }
    public static BigNumber subtraction(BigNumber n1, BigNumber n2){
        return new BigNumber("2323");
    }
    public static BigNumber multiplication(BigNumber n1, BigNumber n2){
        return new BigNumber("2323");
    }
    public static BigNumber division(BigNumber n1, BigNumber n2){
        return new BigNumber("433434");
    }
    public static BigNumber factorial(BigNumber n){
        return new BigNumber("433434");
    }
    public static BigNumber exponent(BigNumber n1, BigNumber n2){
        return new BigNumber("433434");
    }
    //overloaded to handle the exponent value as int or double
    public static BigNumber exponent(BigNumber n, int e){
        return new BigNumber("433434");
    }
    public static BigNumber exponent(BigNumber n, double e){
        return new BigNumber("433434");
    }

    public String toString(){
        String output = "";
        //TODO 0.0 Could be handled incorrectly if handling signifigant figures.
        if((this.integer.isEmpty() == true || this.integer.get(0) == 0) && this.decimal.isEmpty() == true){
            output = "0";
            return output;
        }
        //If Negative block
        else if(this.negative == true){
            output = "-";
            if(this.decimal.isEmpty() == true){
                Iterator<Byte> intIt = this.integer.iterator();
                while(intIt.hasNext()){
                    output += "" + intIt.next();
                }
                
                return output;
            }
            else if(this.integer.isEmpty() == true){
                output = output + ".";
                Iterator<Byte> decIt = this.decimal.iterator();
                while(decIt.hasNext()){
                    //System.out.println(decIt.next());
                    output = output + decIt.next();
                }
                return output;
            }
            else {
                Iterator<Byte> intIt = this.integer.iterator();
                while(intIt.hasNext()){
                    //System.out.println(intIt.next());
                    output = output + intIt.next();
                }
                output = output + ".";
                Iterator<Byte> decIt = this.decimal.iterator();
                while(decIt.hasNext()){
                    //System.out.println(decIt.next());
                    output = output + decIt.next();
                }
                return output;
            }
        }
        //If positive block
        else if (this.negative != true) {
            //TODO 1.0 Could be handled incorrectly if handling signifigant figures.
            if(this.decimal.isEmpty() == true){
                Iterator<Byte> intIt = this.integer.iterator();
                while(intIt.hasNext()){
                    output = output + intIt.next();
                }
                return output;
            }
            //TODO Add feature to trim zeros at the start since they will never be signifigant
            else if(this.integer.isEmpty() == true || this.integer.get(0) == 0){
                output = output + "0.";
                Iterator<Byte> decIt = this.decimal.iterator();
                while(decIt.hasNext()){
                    //System.out.println(decIt.next());
                    output = output + decIt.next();
                }
                return output;
            }
            //If both 
            else if (this.integer.isEmpty() != true && this.integer.isEmpty() != true) {
                Iterator<Byte> intIt = this.integer.iterator();
                while(intIt.hasNext()){
                    //System.out.println(intIt.next());
                    output = output + intIt.next();
                }
                output = output + ".";
                Iterator<Byte> decIt = this.decimal.iterator();
                while(decIt.hasNext()){
                    //System.out.println(decIt.next());
                    output = output + decIt.next();
                }
                return output;
            }
            //Catches all unexpected inputs for negative numbers
            else {
                return "unexpected error";
            }
        }
        else {
            return "unexpected error";
        }
    }
}
