package kotlin.internal;
/* loaded from: classes2.dex */
public final class a {
    private static final int cJ(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final int ac(int i, int i2, int i3) {
        return cJ(cJ(i, i3) - cJ(i2, i3), i3);
    }

    public static final int ad(int i, int i2, int i3) {
        if (i3 > 0) {
            return i2 - ac(i2, i, i3);
        }
        if (i3 < 0) {
            return ac(i, i2, -i3) + i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
