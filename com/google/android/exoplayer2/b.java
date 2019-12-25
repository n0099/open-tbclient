package com.google.android.exoplayer2;

import java.util.UUID;
/* loaded from: classes4.dex */
public final class b {
    public static final int lTA;
    public static final UUID lTB;
    public static final UUID lTC;
    public static final UUID lTD;
    public static final UUID lTE;
    public static final UUID lTF;

    static {
        lTA = com.google.android.exoplayer2.util.v.SDK_INT < 23 ? 1020 : 6396;
        lTB = new UUID(0L, 0L);
        lTC = new UUID(1186680826959645954L, -5988876978535335093L);
        lTD = new UUID(-2129748144642739255L, 8654423357094679310L);
        lTE = new UUID(-1301668207276963122L, -6645017420763422227L);
        lTF = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long fk(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static long fl(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }
}
