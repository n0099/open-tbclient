package kotlin.internal;

import kotlin.e;
@e
/* loaded from: classes17.dex */
public final class d {
    private static final int em(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final long P(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    private static final int ak(int i, int i2, int i3) {
        return em(em(i, i3) - em(i2, i3), i3);
    }

    private static final long i(long j, long j2, long j3) {
        return P(P(j, j3) - P(j2, j3), j3);
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
