package rx.internal.util.a;
/* loaded from: classes5.dex */
public final class h {
    public static int NR(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean Or(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
