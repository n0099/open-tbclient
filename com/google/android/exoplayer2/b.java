package com.google.android.exoplayer2;

import java.util.UUID;
/* loaded from: classes6.dex */
public final class b {
    public static final int lYp;
    public static final UUID lYq;
    public static final UUID lYr;
    public static final UUID lYs;
    public static final UUID lYt;
    public static final UUID lYu;

    static {
        lYp = com.google.android.exoplayer2.util.v.SDK_INT < 23 ? 1020 : 6396;
        lYq = new UUID(0L, 0L);
        lYr = new UUID(1186680826959645954L, -5988876978535335093L);
        lYs = new UUID(-2129748144642739255L, 8654423357094679310L);
        lYt = new UUID(-1301668207276963122L, -6645017420763422227L);
        lYu = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long fn(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static long fo(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }
}
