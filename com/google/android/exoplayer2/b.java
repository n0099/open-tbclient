package com.google.android.exoplayer2;

import java.util.UUID;
/* loaded from: classes6.dex */
public final class b {
    public static final int lYc;
    public static final UUID lYd;
    public static final UUID lYe;
    public static final UUID lYf;
    public static final UUID lYg;
    public static final UUID lYh;

    static {
        lYc = com.google.android.exoplayer2.util.v.SDK_INT < 23 ? 1020 : 6396;
        lYd = new UUID(0L, 0L);
        lYe = new UUID(1186680826959645954L, -5988876978535335093L);
        lYf = new UUID(-2129748144642739255L, 8654423357094679310L);
        lYg = new UUID(-1301668207276963122L, -6645017420763422227L);
        lYh = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long fn(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static long fo(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }
}
