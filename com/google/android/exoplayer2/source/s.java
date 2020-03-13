package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
public final class s extends x {
    private static final Object mti = new Object();
    private final boolean isDynamic;
    private final long maC;
    private final long maD;
    private final boolean maE;
    private final long mtj;
    private final long mtk;
    private final long mtl;
    private final long mtm;

    public s(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    public s(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2);
    }

    public s(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.maC = j;
        this.maD = j2;
        this.mtj = j3;
        this.mtk = j4;
        this.mtl = j5;
        this.mtm = j6;
        this.maE = z;
        this.isDynamic = z2;
    }

    @Override // com.google.android.exoplayer2.x
    public int dtC() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.b a(int i, x.b bVar, boolean z, long j) {
        com.google.android.exoplayer2.util.a.aj(i, 0, 1);
        Object obj = z ? mti : null;
        long j2 = this.mtm;
        if (this.isDynamic) {
            j2 += j;
            if (j2 > this.mtk) {
                j2 = -9223372036854775807L;
            }
        }
        return bVar.a(obj, this.maC, this.maD, this.maE, this.isDynamic, j2, this.mtk, 0, 0, this.mtl);
    }

    @Override // com.google.android.exoplayer2.x
    public int dtD() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.a a(int i, x.a aVar, boolean z) {
        com.google.android.exoplayer2.util.a.aj(i, 0, 1);
        Object obj = z ? mti : null;
        return aVar.a(obj, obj, 0, this.mtj, -this.mtl);
    }

    @Override // com.google.android.exoplayer2.x
    public int bw(Object obj) {
        return mti.equals(obj) ? 0 : -1;
    }
}
