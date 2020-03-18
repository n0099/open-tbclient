package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class m {
    public final int maximumSize;
    public final int[] mfI;
    public final long[] mfJ;
    public final int[] mkY;
    public final long[] mmQ;
    public final int sampleCount;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        com.google.android.exoplayer2.util.a.checkArgument(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(iArr2.length == jArr2.length);
        this.mfJ = jArr;
        this.mfI = iArr;
        this.maximumSize = i;
        this.mmQ = jArr2;
        this.mkY = iArr2;
        this.sampleCount = jArr.length;
    }

    public int fR(long j) {
        for (int a = v.a(this.mmQ, j, true, false); a >= 0; a--) {
            if ((this.mkY[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int fS(long j) {
        for (int b = v.b(this.mmQ, j, true, false); b < this.mmQ.length; b++) {
            if ((this.mkY[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
