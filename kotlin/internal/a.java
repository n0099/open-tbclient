package kotlin.internal;
/* loaded from: classes2.dex */
public final class a {
    private static final int cO(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final int ak(int i, int i2, int i3) {
        return cO(cO(i, i3) - cO(i2, i3), i3);
    }

    public static final int al(int i, int i2, int i3) {
        if (i3 > 0) {
            return i2 - ak(i2, i, i3);
        }
        if (i3 < 0) {
            return ak(i, i2, -i3) + i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
