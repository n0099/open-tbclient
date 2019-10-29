package rx.internal.util.a;
/* loaded from: classes2.dex */
public final class h {
    public static int Dy(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean Dz(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
