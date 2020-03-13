package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class a implements l {
    private final long lZO;
    public final int length;
    public final int[] mec;
    public final long[] med;
    public final long[] mee;
    public final long[] mef;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.mec = iArr;
        this.med = jArr;
        this.mee = jArr2;
        this.mef = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.lZO = jArr2[this.length - 1] + jArr3[this.length - 1];
        } else {
            this.lZO = 0L;
        }
    }

    public int fK(long j) {
        return v.a(this.mef, j, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duR() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZO;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        return this.med[fK(j)];
    }
}
