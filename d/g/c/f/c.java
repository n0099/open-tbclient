package d.g.c.f;

import com.google.common.primitives.Ints;
import java.math.RoundingMode;
/* loaded from: classes6.dex */
public final class c {

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67025a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f67025a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67025a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67025a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67025a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67025a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f67025a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f67025a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f67025a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i, int i2) {
        long j = i + i2;
        int i3 = (int) j;
        e.b(j == ((long) i3), "checkedAdd", i, i2);
        return i3;
    }

    public static boolean b(int i) {
        return (i > 0) & ((i & (i + (-1))) == 0);
    }

    public static int c(int i, int i2) {
        return (~(~(i - i2))) >>> 31;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int d(int i, RoundingMode roundingMode) {
        e.c("x", i);
        switch (a.f67025a[roundingMode.ordinal()]) {
            case 1:
                e.d(b(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + c((-1257966797) >>> numberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static int e(int i, int i2) {
        return Ints.j(i + i2);
    }
}
