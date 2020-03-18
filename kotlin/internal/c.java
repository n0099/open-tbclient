package kotlin.internal;

import kotlin.h;
@h
/* loaded from: classes7.dex */
public final class c {
    private static final int es(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final long af(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    private static final int at(int i, int i2, int i3) {
        return es(es(i, i3) - es(i2, i3), i3);
    }

    private static final long k(long j, long j2, long j3) {
        return af(af(j, j3) - af(j2, j3), j3);
    }

    public static final int au(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - at(i2, i, i3);
        } else if (i3 < 0) {
            return i > i2 ? i2 + at(i, i2, -i3) : i2;
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    public static final long l(long j, long j2, long j3) {
        if (j3 > 0) {
            return j >= j2 ? j2 : j2 - k(j2, j, j3);
        } else if (j3 < 0) {
            return j > j2 ? j2 + k(j, j2, -j3) : j2;
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
