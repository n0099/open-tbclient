package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
public final class a implements l {
    private final long lYV;
    public final int length;
    public final int[] mdj;
    public final long[] mdk;
    public final long[] mdl;
    public final long[] mdm;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.mdj = iArr;
        this.mdk = jArr;
        this.mdl = jArr2;
        this.mdm = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.lYV = jArr2[this.length - 1] + jArr3[this.length - 1];
        } else {
            this.lYV = 0L;
        }
    }

    public int fM(long j) {
        return v.a(this.mdm, j, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dtD() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dsq() {
        return this.lYV;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        return this.mdk[fM(j)];
    }
}
