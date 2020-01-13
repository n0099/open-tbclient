package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
final class m {
    public final int maximumSize;
    public final int[] mde;
    public final long[] mdf;
    public final int[] miu;
    public final long[] mkm;
    public final int sampleCount;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        com.google.android.exoplayer2.util.a.checkArgument(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(iArr2.length == jArr2.length);
        this.mdf = jArr;
        this.mde = iArr;
        this.maximumSize = i;
        this.mkm = jArr2;
        this.miu = iArr2;
        this.sampleCount = jArr.length;
    }

    public int fS(long j) {
        for (int a = v.a(this.mkm, j, true, false); a >= 0; a--) {
            if ((this.miu[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int fT(long j) {
        for (int b = v.b(this.mkm, j, true, false); b < this.mkm.length; b++) {
            if ((this.miu[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
