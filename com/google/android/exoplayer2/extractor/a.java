package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
public final class a implements l {
    private final long lYQ;
    public final int length;
    public final int[] mde;
    public final long[] mdf;
    public final long[] mdg;
    public final long[] mdh;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.mde = iArr;
        this.mdf = jArr;
        this.mdg = jArr2;
        this.mdh = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.lYQ = jArr2[this.length - 1] + jArr3[this.length - 1];
        } else {
            this.lYQ = 0L;
        }
    }

    public int fM(long j) {
        return v.a(this.mdh, j, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dtB() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dso() {
        return this.lYQ;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        return this.mdf[fM(j)];
    }
}
