package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
public final class s extends x {
    private static final Object msX = new Object();
    private final boolean isDynamic;
    private final long maq;
    private final long mar;
    private final boolean mas;
    private final long msY;
    private final long msZ;
    private final long mta;
    private final long mtb;

    public s(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    public s(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2);
    }

    public s(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.maq = j;
        this.mar = j2;
        this.msY = j3;
        this.msZ = j4;
        this.mta = j5;
        this.mtb = j6;
        this.mas = z;
        this.isDynamic = z2;
    }

    @Override // com.google.android.exoplayer2.x
    public int dtB() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.b a(int i, x.b bVar, boolean z, long j) {
        com.google.android.exoplayer2.util.a.aj(i, 0, 1);
        Object obj = z ? msX : null;
        long j2 = this.mtb;
        if (this.isDynamic) {
            j2 += j;
            if (j2 > this.msZ) {
                j2 = -9223372036854775807L;
            }
        }
        return bVar.a(obj, this.maq, this.mar, this.mas, this.isDynamic, j2, this.msZ, 0, 0, this.mta);
    }

    @Override // com.google.android.exoplayer2.x
    public int dtC() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.a a(int i, x.a aVar, boolean z) {
        com.google.android.exoplayer2.util.a.aj(i, 0, 1);
        Object obj = z ? msX : null;
        return aVar.a(obj, obj, 0, this.msY, -this.mta);
    }

    @Override // com.google.android.exoplayer2.x
    public int bw(Object obj) {
        return msX.equals(obj) ? 0 : -1;
    }
}
