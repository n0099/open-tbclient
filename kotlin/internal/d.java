package kotlin.internal;

import kotlin.e;
@e
/* loaded from: classes6.dex */
public final class d {
    private static final int el(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final long Z(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    private static final int al(int i, int i2, int i3) {
        return el(el(i, i3) - el(i2, i3), i3);
    }

    private static final long i(long j, long j2, long j3) {
        return Z(Z(j, j3) - Z(j2, j3), j3);
    }

    public static final int am(int i, int i2, int i3) {
        if (i3 > 0) {
            return i2 - al(i2, i, i3);
        }
        if (i3 < 0) {
            return al(i, i2, -i3) + i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long j(long j, long j2, long j3) {
        if (j3 > 0) {
            return j2 - i(j2, j, j3);
        }
        if (j3 < 0) {
            return i(j, j2, -j3) + j2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
