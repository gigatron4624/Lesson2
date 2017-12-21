/* This program prints values that a 32-bit signed integer can accept. */
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
     * @return a padded binary string representation of int a
     */
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
     * @return a padded octal string representation of int b
     */
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
     * @return a padded hex string representation of int c
     */
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

    /** pcol prints out the decimal integers and the padded strings in columns
     * order: decimal integer, hex string, octal string, binary string
     * @param d1 is the lower bound
     * @param d2 is the upper bound
     */
    private void pcol(int d1, int d2){
        System.out.printf("%-16s %-13s %-16s %-1s\n", "Decimal", "Hex", "Octal", "Binary"); // header line
        for (int i = d1; i <= d2; i++){
            System.out.printf("%-16s %-13s %-16s %-1s\n", i, dec2hex(i), dec2oct(i), dec2bin(i));
        }
    }

    /* This is the main method.
    * */
    public static void main(String[] args){
        TheIntegerWars obj = new TheIntegerWars(); // new instance; obj = object.
        System.out.println(AbsMax+2); // Integer.MAX_VALUE + 2;
        System.out.println(AbsMax-2); // Integer.MAX_VALUE - 2;
        System.out.println(AbsMin+1); // Integer.MIN_VALUE + 1;
        System.out.println(AbsMin-3); // Integer.MIN VALUE - 3;

        System.out.println("Range: -32 to -1");
        obj.pcol(-32, -1);
        System.out.println("Range: 0 to 31");
        obj.pcol(0,31);

        obj.pcol(2147483645,  2147483646);
        obj.pcol(-2147483648, -2147483646);

        System.out.println("Range: AbsMax+2 to AbsMax-2");
        obj.pcol(AbsMax+2, AbsMax-2);

        System.out.println("Range: AbsMin+1 to AbsMin-3");
        obj.pcol(AbsMin+1, AbsMin-3);

    }
}