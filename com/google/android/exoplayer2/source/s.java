package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.x;
/* loaded from: classes4.dex */
public final class s extends x {
    private static final Object mov = new Object();
    private final boolean isDynamic;
    private final long lVM;
    private final long lVN;
    private final boolean lVO;
    private final long mow;
    private final long mox;
    private final long moy;
    private final long moz;

    public s(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    public s(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2);
    }

    public s(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.lVM = j;
        this.lVN = j2;
        this.mow = j3;
        this.mox = j4;
        this.moy = j5;
        this.moz = j6;
        this.lVO = z;
        this.isDynamic = z2;
    }

    @Override // com.google.android.exoplayer2.x
    public int dqZ() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.b a(int i, x.b bVar, boolean z, long j) {
        com.google.android.exoplayer2.util.a.ai(i, 0, 1);
        Object obj = z ? mov : null;
        long j2 = this.moz;
        if (this.isDynamic) {
            j2 += j;
            if (j2 > this.mox) {
                j2 = -9223372036854775807L;
            }
        }
        return bVar.a(obj, this.lVM, this.lVN, this.lVO, this.isDynamic, j2, this.mox, 0, 0, this.moy);
    }

    @Override // com.google.android.exoplayer2.x
    public int dra() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.x
    public x.a a(int i, x.a aVar, boolean z) {
        com.google.android.exoplayer2.util.a.ai(i, 0, 1);
        Object obj = z ? mov : null;
        return aVar.a(obj, obj, 0, this.mow, -this.moy);
    }

    @Override // com.google.android.exoplayer2.x
    public int bt(Object obj) {
        return mov.equals(obj) ? 0 : -1;
    }
}
