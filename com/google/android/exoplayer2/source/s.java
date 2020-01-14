package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.x;
/* loaded from: classes5.dex */
public final class s extends x {
    private static final Object msp = new Object();
    private final boolean isDynamic;
    private final long lZG;
    private final long lZH;
    private final boolean lZI;
    private final long msq;
    private final long msr;
    private final long mss;
    private final long mst;

    public s(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    public s(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2);
    }

    public s(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.lZG = j;
        this.lZH = j2;
        this.msq = j3;
        this.msr = j4;
        this.mss = j5;
        this.mst = j6;
        this.lZI = z;
        this.isDynamic = z2;
    }

    @Override // com.google.android.exoplayer2.x
    public int dsn() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.b a(int i, x.b bVar, boolean z, long j) {
        com.google.android.exoplayer2.util.a.ai(i, 0, 1);
        Object obj = z ? msp : null;
        long j2 = this.mst;
        if (this.isDynamic) {
            j2 += j;
            if (j2 > this.msr) {
                j2 = -9223372036854775807L;
            }
        }
        return bVar.a(obj, this.lZG, this.lZH, this.lZI, this.isDynamic, j2, this.msr, 0, 0, this.mss);
    }

    @Override // com.google.android.exoplayer2.x
    public int dso() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.a a(int i, x.a aVar, boolean z) {
        com.google.android.exoplayer2.util.a.ai(i, 0, 1);
        Object obj = z ? msp : null;
        return aVar.a(obj, obj, 0, this.msq, -this.mss);
    }

    @Override // com.google.android.exoplayer2.x
    public int bu(Object obj) {
        return msp.equals(obj) ? 0 : -1;
    }
}
