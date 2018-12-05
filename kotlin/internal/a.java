package kotlin.internal;
/* loaded from: classes2.dex */
public final class a {
    private static final int cl(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final int ag(int i, int i2, int i3) {
        return cl(cl(i, i3) - cl(i2, i3), i3);
    }

    public static final int ah(int i, int i2, int i3) {
        if (i3 > 0) {
            return i2 - ag(i2, i, i3);
        }
        if (i3 < 0) {
            return ag(i, i2, -i3) + i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
