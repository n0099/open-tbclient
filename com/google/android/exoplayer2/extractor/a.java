package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes4.dex */
public final class a implements l {
    private final long lUZ;
    public final int[] lZm;
    public final long[] lZn;
    public final long[] lZo;
    public final long[] lZp;
    public final int length;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.lZm = iArr;
        this.lZn = jArr;
        this.lZo = jArr2;
        this.lZp = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.lUZ = jArr2[this.length - 1] + jArr3[this.length - 1];
        } else {
            this.lUZ = 0L;
        }
    }

    public int fH(long j) {
        return v.a(this.lZp, j, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dsp() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long drc() {
        return this.lUZ;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fI(long j) {
        return this.lZn[fH(j)];
    }
}
