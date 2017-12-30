package gitwithgig;

import java.text.DecimalFormat;

public class FloatTest {
    public static void main(String[] args) {
        float f2 = .2f;
        float f4 = .04f;
        float f2sq = f2*f2;
        DecimalFormat d2 = new DecimalFormat("##.##");
        String F2 = d2.format(f2sq);
        String F4 = d2.format(f4);
        System.out.println("f2 = " + f2);
        System.out.println("f4 = " + f4);
        System.out.println("f2sq = " + f2sq);
        System.out.println(F2 + " " + F4);
        System.out.println(F2.equals(F4));
    }
}
