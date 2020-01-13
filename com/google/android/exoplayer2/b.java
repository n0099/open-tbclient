package com.google.android.exoplayer2;

import java.util.UUID;
/* loaded from: classes5.dex */
public final class b {
    public static final int lXr;
    public static final UUID lXs;
    public static final UUID lXt;
    public static final UUID lXu;
    public static final UUID lXv;
    public static final UUID lXw;

    static {
        lXr = com.google.android.exoplayer2.util.v.SDK_INT < 23 ? 1020 : 6396;
        lXs = new UUID(0L, 0L);
        lXt = new UUID(1186680826959645954L, -5988876978535335093L);
        lXu = new UUID(-2129748144642739255L, 8654423357094679310L);
        lXv = new UUID(-1301668207276963122L, -6645017420763422227L);
        lXw = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long fp(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static long fq(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }
}
