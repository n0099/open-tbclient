package com.google.android.exoplayer2;

import java.util.UUID;
/* loaded from: classes5.dex */
public final class b {
    public static final UUID lXA;
    public static final UUID lXB;
    public static final int lXw;
    public static final UUID lXx;
    public static final UUID lXy;
    public static final UUID lXz;

    static {
        lXw = com.google.android.exoplayer2.util.v.SDK_INT < 23 ? 1020 : 6396;
        lXx = new UUID(0L, 0L);
        lXy = new UUID(1186680826959645954L, -5988876978535335093L);
        lXz = new UUID(-2129748144642739255L, 8654423357094679310L);
        lXA = new UUID(-1301668207276963122L, -6645017420763422227L);
        lXB = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long fp(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static long fq(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }
}
