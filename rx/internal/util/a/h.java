package rx.internal.util.a;
/* loaded from: classes16.dex */
public final class h {
    public static int QT(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean Rt(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
