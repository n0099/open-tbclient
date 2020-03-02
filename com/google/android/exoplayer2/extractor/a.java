package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class a implements l {
    private final long lZD;
    public final int length;
    public final int[] mdR;
    public final long[] mdS;
    public final long[] mdT;
    public final long[] mdU;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.mdR = iArr;
        this.mdS = jArr;
        this.mdT = jArr2;
        this.mdU = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.lZD = jArr2[this.length - 1] + jArr3[this.length - 1];
        } else {
            this.lZD = 0L;
        }
    }

    public int fK(long j) {
        return v.a(this.mdU, j, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duQ() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZD;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        return this.mdS[fK(j)];
    }
}
