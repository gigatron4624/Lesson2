package gitwithgig;
/* This program uses TestNG assertion methods to analyze the padding of non-decimal string representations
 * of integer values. The strings and methods tested are called from TheIntegerWars.java.
 * Each hexadecimal (i.e. base 16) string should be eight digits in length.
 * Each octal (i.e. base 8) string should be eleven digits in length.
 * Each binary (i.e. base 2) string should be 32 digits in length. */

import java.lang.Integer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntReview {

    /* Fields: These are constant values.
     * MinI holds a value of -2147483648, the minimum value for a 32-bit signed integer.
     * MaxI holds a value of 2147483647, the maximum value for a 32-bit signed integer. */
    private static final int MinI = Integer.MIN_VALUE; // MIN_VALUE = (-2)^31 = -2147483648
    private static final int MaxI = Integer.MAX_VALUE; // MAX_VALUE = 2^31 - 1 = 2147483647

    /** Method boo() is called when assertEquals throws an assertion error.
     * @return error message indicating that the string is not fully padded */
    private String boo(){
        return "Wait a minute! The string is too short!";
    }

     /* Test Methods
     * testbin, testoct, and testhex check lengths on binary strings, octal strings, and hex strings, respectively.
     * Each test method will throw an exception if the actual length and expected length don't match.*/

    @Test
    public void testbin() throws Exception{
        TheIntegerWars obj = new TheIntegerWars(); // invokes source code and instantiates object

        /* dec2bin: converts decimal integers to padded binary strings
        * bsl: length of binary string
        * 255 is just a test value */
        int bsl = obj.dec2bin(255).length();

        // asserts that the binary string is fully padded
        Assert.assertEquals(bsl, 32, boo()); // throws assertion error if bsl != 32
    }

    @Test
    public void testoct() throws Exception{
        TheIntegerWars obj = new TheIntegerWars();; // invokes source code and instantiates object

        /* dec2oct: converts decimal integers to padded octal strings
         * osl: length of octal string
         * 63 is just a test value */
        int osl = obj.dec2oct(63).length();

        // asserts that the octal string is fully padded
        Assert.assertEquals(osl, 11, boo()); // throws assertion error if osl != 11
    }

    @Test
    public void testhex() throws Exception{
        TheIntegerWars obj = new TheIntegerWars();; // invokes source code and instantiates object

        /* dec2hex: converts decimal integers to padded hex strings
         * hsl: length of hex string
         * 15 is just a test value*/
        int hsl = obj.dec2hex(15).length(); // determines and declares length of hex string

        // asserts that the hex string is fully padded
        Assert.assertEquals(hsl, 8, boo()); // throws assertion error if hsl != 8
    }

}
