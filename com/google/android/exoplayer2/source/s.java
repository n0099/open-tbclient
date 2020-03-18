package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
public final class s extends x {
    private static final Object muP = new Object();
    private final boolean isDynamic;
    private final long mci;
    private final long mcj;
    private final boolean mck;
    private final long muQ;
    private final long muR;
    private final long muS;
    private final long muT;

    public s(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    public s(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2);
    }

    public s(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.mci = j;
        this.mcj = j2;
        this.muQ = j3;
        this.muR = j4;
        this.muS = j5;
        this.muT = j6;
        this.mck = z;
        this.isDynamic = z2;
    }

    @Override // com.google.android.exoplayer2.x
    public int dtZ() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.b a(int i, x.b bVar, boolean z, long j) {
        com.google.android.exoplayer2.util.a.aj(i, 0, 1);
        Object obj = z ? muP : null;
        long j2 = this.muT;
        if (this.isDynamic) {
            j2 += j;
            if (j2 > this.muR) {
                j2 = -9223372036854775807L;
            }
        }
        return bVar.a(obj, this.mci, this.mcj, this.mck, this.isDynamic, j2, this.muR, 0, 0, this.muS);
    }

    @Override // com.google.android.exoplayer2.x
    public int dua() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.a a(int i, x.a aVar, boolean z) {
        com.google.android.exoplayer2.util.a.aj(i, 0, 1);
        Object obj = z ? muP : null;
        return aVar.a(obj, obj, 0, this.muQ, -this.muS);
    }

    @Override // com.google.android.exoplayer2.x
    public int bw(Object obj) {
        return muP.equals(obj) ? 0 : -1;
    }
}
