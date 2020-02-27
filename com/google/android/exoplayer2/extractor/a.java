package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class a implements l {
    private final long lZB;
    public final int length;
    public final int[] mdP;
    public final long[] mdQ;
    public final long[] mdR;
    public final long[] mdS;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.mdP = iArr;
        this.mdQ = jArr;
        this.mdR = jArr2;
        this.mdS = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.lZB = jArr2[this.length - 1] + jArr3[this.length - 1];
        } else {
            this.lZB = 0L;
        }
    }

    public int fK(long j) {
        return v.a(this.mdS, j, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duO() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZB;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        return this.mdQ[fK(j)];
    }
}
