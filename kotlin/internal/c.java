package kotlin.internal;
/* loaded from: classes5.dex */
public final class c {
    private static final int eo(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final int as(int i, int i2, int i3) {
        return eo(eo(i, i3) - eo(i2, i3), i3);
    }

    public static final int at(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - as(i2, i, i3);
        } else if (i3 < 0) {
            return i > i2 ? i2 + as(i, i2, -i3) : i2;
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
