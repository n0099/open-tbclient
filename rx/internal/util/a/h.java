package rx.internal.util.a;
/* loaded from: classes5.dex */
public final class h {
    public static int Sp(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean SI(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
