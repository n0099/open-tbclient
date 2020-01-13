package kotlin.random;
/* loaded from: classes5.dex */
public final class c {
    public static final int NE(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final double ep(int i, int i2) {
        return ((i << 27) + i2) / 9007199254740992L;
    }
}
