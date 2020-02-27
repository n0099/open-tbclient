package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class m {
    public final int maximumSize;
    public final int[] mdP;
    public final long[] mdQ;
    public final int[] mjf;
    public final long[] mkX;
    public final int sampleCount;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        com.google.android.exoplayer2.util.a.checkArgument(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(iArr2.length == jArr2.length);
        this.mdQ = jArr;
        this.mdP = iArr;
        this.maximumSize = i;
        this.mkX = jArr2;
        this.mjf = iArr2;
        this.sampleCount = jArr.length;
    }

    public int fQ(long j) {
        for (int a = v.a(this.mkX, j, true, false); a >= 0; a--) {
            if ((this.mjf[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int fR(long j) {
        for (int b = v.b(this.mkX, j, true, false); b < this.mkX.length; b++) {
            if ((this.mjf[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
