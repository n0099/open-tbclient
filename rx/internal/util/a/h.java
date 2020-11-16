package rx.internal.util.a;
/* loaded from: classes14.dex */
public final class h {
    public static int RR(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean Sr(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
