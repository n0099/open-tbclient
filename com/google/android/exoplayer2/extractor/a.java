package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class a implements l {
    public final int length;
    private final long mbx;
    public final int[] mfI;
    public final long[] mfJ;
    public final long[] mfK;
    public final long[] mfL;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.mfI = iArr;
        this.mfJ = jArr;
        this.mfK = jArr2;
        this.mfL = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.mbx = jArr2[this.length - 1] + jArr3[this.length - 1];
        } else {
            this.mbx = 0L;
        }
    }

    public int fL(long j) {
        return v.a(this.mfL, j, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dvo() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.mbx;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fM(long j) {
        return this.mfJ[fL(j)];
    }
}
