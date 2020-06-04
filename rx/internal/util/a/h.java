package rx.internal.util.a;
/* loaded from: classes6.dex */
public final class h {
    public static int JN(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean Kn(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
