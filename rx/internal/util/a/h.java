package rx.internal.util.a;
/* loaded from: classes5.dex */
public final class h {
    public static int Nx(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean NX(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
