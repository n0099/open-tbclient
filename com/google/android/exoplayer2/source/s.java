package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.x;
/* loaded from: classes5.dex */
public final class s extends x {
    private static final Object msk = new Object();
    private final boolean isDynamic;
    private final long lZB;
    private final long lZC;
    private final boolean lZD;
    private final long msl;
    private final long msm;
    private final long msn;
    private final long mso;

    public s(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    public s(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2);
    }

    public s(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.lZB = j;
        this.lZC = j2;
        this.msl = j3;
        this.msm = j4;
        this.msn = j5;
        this.mso = j6;
        this.lZD = z;
        this.isDynamic = z2;
    }

    @Override // com.google.android.exoplayer2.x
    public int dsl() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.b a(int i, x.b bVar, boolean z, long j) {
        com.google.android.exoplayer2.util.a.ai(i, 0, 1);
        Object obj = z ? msk : null;
        long j2 = this.mso;
        if (this.isDynamic) {
            j2 += j;
            if (j2 > this.msm) {
                j2 = -9223372036854775807L;
            }
        }
        return bVar.a(obj, this.lZB, this.lZC, this.lZD, this.isDynamic, j2, this.msm, 0, 0, this.msn);
    }

    @Override // com.google.android.exoplayer2.x
    public int dsm() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.a a(int i, x.a aVar, boolean z) {
        com.google.android.exoplayer2.util.a.ai(i, 0, 1);
        Object obj = z ? msk : null;
        return aVar.a(obj, obj, 0, this.msl, -this.msn);
    }

    @Override // com.google.android.exoplayer2.x
    public int bu(Object obj) {
        return msk.equals(obj) ? 0 : -1;
    }
}
