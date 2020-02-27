package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
public final class s extends x {
    private static final Object msV = new Object();
    private final boolean isDynamic;
    private final long man;
    private final long mao;
    private final boolean maq;
    private final long msW;
    private final long msX;
    private final long msY;
    private final long msZ;

    public s(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    public s(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2);
    }

    public s(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.man = j;
        this.mao = j2;
        this.msW = j3;
        this.msX = j4;
        this.msY = j5;
        this.msZ = j6;
        this.maq = z;
        this.isDynamic = z2;
    }

    @Override // com.google.android.exoplayer2.x
    public int dtz() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.b a(int i, x.b bVar, boolean z, long j) {
        com.google.android.exoplayer2.util.a.aj(i, 0, 1);
        Object obj = z ? msV : null;
        long j2 = this.msZ;
        if (this.isDynamic) {
            j2 += j;
            if (j2 > this.msX) {
                j2 = -9223372036854775807L;
            }
        }
        return bVar.a(obj, this.man, this.mao, this.maq, this.isDynamic, j2, this.msX, 0, 0, this.msY);
    }

    @Override // com.google.android.exoplayer2.x
    public int dtA() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.a a(int i, x.a aVar, boolean z) {
        com.google.android.exoplayer2.util.a.aj(i, 0, 1);
        Object obj = z ? msV : null;
        return aVar.a(obj, obj, 0, this.msW, -this.msY);
    }

    @Override // com.google.android.exoplayer2.x
    public int bw(Object obj) {
        return msV.equals(obj) ? 0 : -1;
    }
}
