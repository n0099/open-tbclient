package rx.internal.util.a;
/* loaded from: classes7.dex */
public final class h {
    public static int Ow(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean OW(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
