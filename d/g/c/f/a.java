package d.g.c.f;

import java.math.RoundingMode;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: d.g.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C1909a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f70047a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f70047a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f70047a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f70047a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f70047a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f70047a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f70047a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f70047a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f70047a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        Math.log(2.0d);
    }

    public static boolean a(double d2) {
        return b.c(d2) && (d2 == 0.0d || 52 - Long.numberOfTrailingZeros(b.b(d2)) <= Math.getExponent(d2));
    }

    public static double b(double d2, RoundingMode roundingMode) {
        if (b.c(d2)) {
            switch (C1909a.f70047a[roundingMode.ordinal()]) {
                case 1:
                    e.d(a(d2));
                    return d2;
                case 2:
                    return (d2 >= 0.0d || a(d2)) ? d2 : ((long) d2) - 1;
                case 3:
                    return (d2 <= 0.0d || a(d2)) ? d2 : ((long) d2) + 1;
                case 4:
                    return d2;
                case 5:
                    if (a(d2)) {
                        return d2;
                    }
                    return ((long) d2) + (d2 > 0.0d ? 1 : -1);
                case 6:
                    return Math.rint(d2);
                case 7:
                    double rint = Math.rint(d2);
                    return Math.abs(d2 - rint) == 0.5d ? d2 + Math.copySign(0.5d, d2) : rint;
                case 8:
                    double rint2 = Math.rint(d2);
                    return Math.abs(d2 - rint2) == 0.5d ? d2 : rint2;
                default:
                    throw new AssertionError();
            }
        }
        throw new ArithmeticException("input is infinite or NaN");
    }

    public static long c(double d2, RoundingMode roundingMode) {
        double b2 = b(d2, roundingMode);
        e.a(((-9.223372036854776E18d) - b2 < 1.0d) & (b2 < 9.223372036854776E18d), d2, roundingMode);
        return (long) b2;
    }
}
