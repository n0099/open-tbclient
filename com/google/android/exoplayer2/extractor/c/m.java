package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes4.dex */
final class m {
    public final int[] lZm;
    public final long[] lZn;
    public final int maximumSize;
    public final int[] meD;
    public final long[] mgv;
    public final int sampleCount;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        com.google.android.exoplayer2.util.a.checkArgument(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(iArr2.length == jArr2.length);
        this.lZn = jArr;
        this.lZm = iArr;
        this.maximumSize = i;
        this.mgv = jArr2;
        this.meD = iArr2;
        this.sampleCount = jArr.length;
    }

    public int fN(long j) {
        for (int a = v.a(this.mgv, j, true, false); a >= 0; a--) {
            if ((this.meD[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int fO(long j) {
        for (int b = v.b(this.mgv, j, true, false); b < this.mgv.length; b++) {
            if ((this.meD[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
