package rx.internal.util.a;
/* loaded from: classes12.dex */
public final class h {
    public static int RR(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean Sk(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
