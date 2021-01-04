package rx.internal.util.a;
/* loaded from: classes15.dex */
public final class h {
    public static int Tk(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean TD(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
