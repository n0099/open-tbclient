package kotlin.internal;
/* loaded from: classes2.dex */
public final class a {
    private static final int cH(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final int aj(int i, int i2, int i3) {
        return cH(cH(i, i3) - cH(i2, i3), i3);
    }

    public static final int ak(int i, int i2, int i3) {
        if (i3 > 0) {
            return i2 - aj(i2, i, i3);
        }
        if (i3 < 0) {
            return aj(i, i2, -i3) + i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
