package rx.internal.util.a;
/* loaded from: classes16.dex */
public final class h {
    public static int Pc(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean PC(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
