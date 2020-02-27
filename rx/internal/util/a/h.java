package rx.internal.util.a;
/* loaded from: classes6.dex */
public final class h {
    public static int NA(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean Oa(int i) {
        return ((i + (-1)) & i) == 0;
    }
}
