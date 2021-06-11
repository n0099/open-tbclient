package d.g.c.f;

import com.google.common.primitives.Ints;
import java.math.RoundingMode;
/* loaded from: classes6.dex */
public final class c {

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f70048a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f70048a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f70048a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f70048a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f70048a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f70048a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f70048a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f70048a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f70048a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i2, int i3) {
        long j = i2 + i3;
        int i4 = (int) j;
        e.b(j == ((long) i4), "checkedAdd", i2, i3);
        return i4;
    }

    public static boolean b(int i2) {
        return (i2 > 0) & ((i2 & (i2 + (-1))) == 0);
    }

    public static int c(int i2, int i3) {
        return (~(~(i2 - i3))) >>> 31;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int d(int i2, RoundingMode roundingMode) {
        e.c("x", i2);
        switch (a.f70048a[roundingMode.ordinal()]) {
            case 1:
                e.d(b(i2));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i2 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i2);
                return (31 - numberOfLeadingZeros) + c((-1257966797) >>> numberOfLeadingZeros, i2);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static int e(int i2, int i3) {
        return Ints.j(i2 + i3);
    }
}
