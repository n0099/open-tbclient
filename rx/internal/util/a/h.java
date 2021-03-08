package rx.internal.util.a;
/* loaded from: classes4.dex */
public final class h {
    public static int So(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean SH(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
