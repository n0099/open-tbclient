package kotlin.internal;
/* loaded from: classes4.dex */
public final class c {
    private static final int el(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final int as(int i, int i2, int i3) {
        return el(el(i, i3) - el(i2, i3), i3);
    }

    public static final int at(int i, int i2, int i3) {
        if (i3 > 0) {
            return i2 - as(i2, i, i3);
        }
        if (i3 < 0) {
            return as(i, i2, -i3) + i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
