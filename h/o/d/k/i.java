package h.o.d.k;
/* loaded from: classes7.dex */
public final class i {
    public static boolean a(int i) {
        return (i & (i + (-1))) == 0;
    }

    public static int b(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
