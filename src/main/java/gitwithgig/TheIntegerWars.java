/* This program prints values that a 32-bit signed integer can accept as tables of strings. Each row lists the decimal,
 * hexadecimal, octal, and binary representations for each integer value. */
package gitwithgig;

import java.lang.Integer;

public class TheIntegerWars {

    /* Fields: These are constant values.
     * AbsMin holds a value of -2147483648, the minimum value for a 32-bit signed integer.
     * AbsMax holds a value of 2147483647, the maximum value for a 32-bit signed integer. */
    private static final Integer AbsMin = Integer.MIN_VALUE; // MIN_VALUE = (-2)^31 = -2147483648
    private static final Integer AbsMax = Integer.MAX_VALUE; // MAX_VALUE = 2^31 - 1 = 2147483647

    /* Package-Private Methods */

    /** dec2bin converts an integer to a 32-digit binary string
     * @param a is the decimal integer accepted as an input
     * @return a padded binary string representation of int a */
    String dec2bin(int a){

        //initialize binary string of int a
        String bs = Integer.toBinaryString(a); // bs =  binary string

        // to pad or not to pad?
        if (bs.length() < 32){
            while (bs.length() < 32){
                // pads binary string with zeros until the string has 32 digits
                bs = "0" + bs;
            }
            return bs;
        }
        else {
            // no need to pad binary string
            return bs;
        }
    }

    /** dec2oct converts an integer to an 11-digit octal string
     * @param b is the decimal integer accepted as an input
     * @return a padded octal string representation of int b */
    String dec2oct(int b){

        // initialize octal string of int b
        String os = Integer.toOctalString(b); // os = octal string

        // to pad or not to pad?
        if (os.length() < 11){
            while (os.length()<11){
                // pads octal string with zeros until said string has 11 digits
                os = "0" + os;
            }
            return os;
        }
        else {
            // no need to pad octal string
            return os;
        }
    }

    /** dec2hex converts an integer to an 8-digit hexadecimal string
     * @param c is the decimal integer accepted as an input
     * @return a padded hex string representation of int c */
    String dec2hex(int c){

        // initialize hexadecimal string of int c;
        String hs = Integer.toHexString(c); // hs = hex string

        // to pad or not to pad?
        if (hs.length() < 8){
            while (hs.length()< 8){
                // pads hex string with zeros up to 8 digits
                hs = "0" + hs;
            }
            return hs;
        }
        else{
            // no need to pad hex string
            return hs;
        }
    }

    /* Private Methods */

    /** PC (Print Columns) prints out the decimal integers and the padded strings in columns.
     * order: decimal integer, hex string, octal string, binary string
     * @param d1 is the lower bound of the range of input values
     * @param d2 is the upper bound of the range of input values */
    private void PC(int d1, int d2){
        System.out.printf("%-16s %-13s %-16s %-1s\n", "Decimal", "Hex", "Octal", "Binary"); // column header
        for (int i = d1; i <= d2; i++){
            System.out.printf("%-16s %-13s %-16s %-1s\n", i, dec2hex(i), dec2oct(i), dec2bin(i));
        } System.out.println();
    }

    /** SC (Special Columns) is similar to PC in the sense that it prints columns of padded strings.
     * SC accepts an integer array as an input instead of two primitive variables like PC does.
     * @param Ec is the Euler cusp, after mathematician Leonhard Euler.
     * The maximum integer value (i.e. MAX_VALUE), 2147483647, is the 8th Mersenne prime number.
     * Euler discovered the 8th Mersenne prime in 1772. Euler cusps are arrays that contain integer values
     * that are either slightly greater/less than MAX_VALUE (2147483647) or slightly greater/less than
     * MIN_VALUE (-2147483648). Euler cusps circumvent the discontinuity between MAX_VALUE and MIN_VALUE
     * and thus avoid overflow and underflow of integers, respectively. */
    private void SC(int[] Ec){
        System.out.printf("%-16s %-13s %-16s %-1s\n", "Decimal", "Hex", "Octal", "Binary"); // column header
        for (int j = 0; j < Ec.length; j++){
            System.out.printf("%-16s %-13s %-16s %-1s\n", Ec[j], dec2hex(Ec[j]), dec2oct(Ec[j]), dec2bin(Ec[j]));
        } System.out.println();
    }

    /** This is the main method. Almost all classes require a main method to run code.
     * In this program, main calls PC to print the first two sequences and SC to print the other two sequences.
     * @param args carries the command line arguments as an array of strings.*/
    public static void main(String[] args){
        TheIntegerWars obj = new TheIntegerWars(); // new instance; obj = object.

        int[] Ec1 = {AbsMax-2,AbsMax-1,AbsMax,AbsMax+1,AbsMax+2}; // Ec1 = Euler cusp 1
        // Integer.MAX_VALUE - 2 = 2147483647 - 2 = 2147483645
        // Integer.MAX_VALUE + 2 = 2147483647 + 2 = 2147483649
        // The value 2147483649 is stored as -2147483647 to circumvent integer overflow.

        int[] Ec2 = {AbsMin+1, AbsMin, AbsMin-1, AbsMin-2, AbsMin-3}; // Ec2 = Euler cusp 2
        // Integer.MIN_VALUE + 1 = -2147483648 + 1 = -2147483647
        // Integer.MIN VALUE - 3 = -2147483647 - 3 = -2147483651
        // The value -2147483651 is stored as 2147483645 to circumvent integer underflow.

        System.out.println("Range: -32 to -1"); // first sequence of values
        obj.PC(-32, -1); // prints sequence

        System.out.println("Range: 0 to 31"); // second sequence of values
        obj.PC(0,31); // prints sequence

        System.out.println("Range: AbsMax+2 to AbsMax-2"); // third sequence of values
        obj.SC(Ec1); // prints sequence of first Euler cusp

        System.out.println("Range: AbsMin+1 to AbsMin-3"); // fourth and final sequence of values
        obj.SC(Ec2); // prints sequence of second Euler cusp
    }
}
