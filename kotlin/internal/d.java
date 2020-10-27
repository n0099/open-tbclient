package kotlin.internal;

import kotlin.h;
@h
/* loaded from: classes10.dex */
public final class d {
    private static final int en(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final long P(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    private static final int an(int i, int i2, int i3) {
        return en(en(i, i3) - en(i2, i3), i3);
    }

    private static final long i(long j, long j2, long j3) {
        return P(P(j, j3) - P(j2, j3), j3);
    }

    public static final int ao(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - an(i2, i, i3);
        } else if (i3 < 0) {
            return i > i2 ? i2 + an(i, i2, -i3) : i2;
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    public static final long j(long j, long j2, long j3) {
        if (j3 > 0) {
            return j >= j2 ? j2 : j2 - i(j2, j, j3);
        } else if (j3 < 0) {
            return j > j2 ? j2 + i(j, j2, -j3) : j2;
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
