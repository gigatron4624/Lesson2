/* The following program prints all the values a byte can take as a table of strings. Each row contains the decimal,
 * hexadecimal, octal, and binary representations of each unsigned byte value in increasing decimal order. */
package gitwithgig;

import java.lang.Byte;
import java.lang.Integer;

public class AttackofTheBytes {

    /* Fields: These are constant values.
     * AbsMin holds a value of -128, the minimum value a byte can take.
     * AbsMax holds a value of 127, the maximum value a byte can take.*/
    private static final Byte AbsMin = Byte.MIN_VALUE; // MIN_VALUE = (-2)^7 = -128;
    private static final Byte AbsMax = Byte.MAX_VALUE; // MAX_VALUE = 2^7 - 1 = 128 - 1 = 127;

    /* Package-Private Methods */

    /** dec2bin converts an integer to a binary string of 8 digits
     * @param x is an integer in decimal format (i.e. base 10)
     * @return a padded binary (i.e. base 2) string of integer x
     */
    String dec2bin(int x){

        //initialize binary string of int x
        String bs = Integer.toBinaryString(x); // bs = binary string

        // Is the binary string 8 digits in length?
        if (x >= 128){
            // binary string starts with a 1
            return bs; // binary string already padded
        }
        else {
            // pad bs with zeros until bs.length() = 8;
            while (bs.length() < 8){
                bs = "0" + bs; // pads bs
            }
            return bs; // yields padded binary string
        }
    }

    /** dec2oct converts an integer to an octal string of 3 digits
     * @param y is an integer in decimal format
     * @return a padded octal (i.e. base 8) string of integer y
     */
    String dec2oct(int y){

        // initialize octal string of int y
        String os = Integer.toOctalString(y); // os = octal string

        // Is octal string 3 digits long?
        if (y >= 64){
            // The octal value is at least 100 (64 in decimal mode).
            return os; // There is no need to pad octal string.
        }
        else {
            // pad os with 0s until os.length() = 3;
            while (os.length() < 3){
                os = "0" + os; // pads os
            }
            return os;
        }
    }

    /** dec2hex converts an integer to a hexadecimal string of two digits
     * @param z is an integer in decimal format
     * @return a padded hexadecimal (i.e. base 16) string of integer z
     */
    String dec2hex(int z){

        // initialize hexadecimal string of int z
        String hs = Integer.toHexString(z); // hs = hex string

        // Does the hex string have two digits?
        if (z < 16){
            return "0" + hs; // pads hs with one zero
        }
        else {
            // hex value is at least 10 (16 in decimal mode)
            return hs; // hex string doesn't need padding
        }
    }

    /* Private Methods */

    /** pval prints out the padded hexadecimal, octal, and binary strings to the screen in columns
     * @param u1 is the local minimum
     * @param u2 is the local maximum
     */
    private void pval (int u1, int u2){
        System.out.printf("%-1s %-1s %-1s %-1s\n", "Decimal", "Hex", "Octal", "Binary"); // header line
        for (int i = u1; i <= u2; i++){
            System.out.printf("%-7s %-3s %-5s %-1s", i, dec2hex(i), dec2oct(i), dec2bin(i));
            System.out.println();
        }
    }

    /**  This is the main method. It's always the last method in the code.
     * @param args carries the command line arguments as an array of strings
     * method intValue() converts bytes to integers.
     * v1 represents the lower bound of unsigned byte range.
     * v2 represents the upper bound of the unsigned byte range.
     * The offset of 128 adjusts the signed byte range (-128 to 127) to the unsigned byte range (0 to 255).*/
    public static void main(String[] args){
        AttackofTheBytes obj = new AttackofTheBytes(); // new instance; obj = object
        int v1 = AbsMin.intValue()+128; // Minimum value is -128; offset to 0
        int v2 = AbsMax.intValue()+128; // Maximum value is 127; offset to 255
        obj.pval(v1,v2); // runs v1 and v2 through pval
    }
}
