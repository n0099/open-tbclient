package kotlin.internal;

import kotlin.h;
@h
/* loaded from: classes5.dex */
public final class d {
    private static final int ef(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final long O(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    private static final int am(int i, int i2, int i3) {
        return ef(ef(i, i3) - ef(i2, i3), i3);
    }

    private static final long i(long j, long j2, long j3) {
        return O(O(j, j3) - O(j2, j3), j3);
    }

    public static final int an(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - am(i2, i, i3);
        } else if (i3 < 0) {
            return i > i2 ? i2 + am(i, i2, -i3) : i2;
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
