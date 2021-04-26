package d.g.c.f;

import d.g.c.a.n;
/* loaded from: classes6.dex */
public final class b {
    public static double a(double d2) {
        n.d(!Double.isNaN(d2));
        if (d2 > 0.0d) {
            return d2;
        }
        return 0.0d;
    }

    public static long b(double d2) {
        n.e(c(d2), "not a normal value");
        int exponent = Math.getExponent(d2);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d2) & 4503599627370495L;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
    }

    public static boolean c(double d2) {
        return Math.getExponent(d2) <= 1023;
    }
}
