package gitwithgig;
/* This program uses TestNG assertion methods to analyze the padding of string representations of decimal integers.
* The strings and methods tested are called from AttackofTheBytes.java.
* Each hexadecimal (i.e. base 16) string should be two digits in length.
* Each octal (i.e. base 8) string should be three digits in length.
* Each binary (i.e. base 2) string should be eight digits in length. */

import java.lang.Byte;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByteInspection{

    /* Fields: These are constant values.
    * MinB holds a value of -128, the minimum value a byte can take.
    * MaxB holds a value of 127, the maximum value a byte can take.
    * intValue() converts bytes to integers.
    * minv represents the lower bound of unsigned byte range.
    * maxv represents the upper bound of the unsigned byte range.
    * The offset adjusts the signed byte range (-128 to 127) to the unsigned byte range (0 to 255).*/
    private static final Byte MinB = Byte.MIN_VALUE; // MIN_VALUE = (-2)^7 = -128
    private static final Byte MaxB = Byte.MAX_VALUE; // MAX_VALUE = 2^7 - 1 = 127
    private int minv = MinB.intValue() + 128; // minv = -128 + 128 = 0
    private int maxv = MaxB.intValue() + 128; // maxv = 127 + 128 = 255

    /** Method boo() is called when assertEquals throws an assertion error.
     * @return error message indicating that the string is not fully padded
     */
    private String boo(){
        return "Wait a minute! The string is too short!";
    }

    /* Test Methods
    * testbin, testoct, and testhex check lengths on binary strings, octal strings, and hex strings, respectively.
    * Each test method will throw an exception if the actual length and expected length don't match.*/

    @Test
    public void testbin(){
        AttackofTheBytes obj = new AttackofTheBytes(); // invokes source code and instantiates object

        /* dec2bin: converts decimal integers to padded binary strings
        * bsl: length of binary string
        * (maxv - 1)/2 = (255 - 1)/2 = 254/2 = 127 (01111111 in base 2) */
        int bsl = obj.dec2bin((maxv-1)/2).length();

        // asserts that the binary string is fully padded
        Assert.assertEquals(bsl, 8, boo()); // throws assertion error if bsl != 8
    }

    @Test
    public void testoct() throws Exception{
        AttackofTheBytes obj = new AttackofTheBytes(); // invokes source code and instantiates object

        /* dec2oct: converts decimal integers to padded octal strings
        * osl: length of octal string
        * minv + 63 = 0 + 63 = 63 (077 in base 8) */
        int osl = obj.dec2oct(minv+63).length();

        // asserts that the octal string is fully padded
        Assert.assertEquals(osl, 3, boo()); // throws assertion error if osl != 3
    }

    @Test
    public void testhex() throws Exception{
        AttackofTheBytes obj = new AttackofTheBytes(); // invokes source code and instantiates object

        /* dec2hex: converts decimal integers to padded hex strings
        * hsl: length of hex string
        * minv + 15 = 0 + 15 = 15 (0f in base 16) */
        int hsl = obj.dec2hex(minv+15).length(); // determines and declares length of hex string

        // asserts that the hex string is fully padded
        Assert.assertEquals(hsl, 2, boo()); // throws assertion error if hsl != 2
    }
}