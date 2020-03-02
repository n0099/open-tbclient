package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class m {
    public final int maximumSize;
    public final int[] mdR;
    public final long[] mdS;
    public final int[] mjh;
    public final long[] mkZ;
    public final int sampleCount;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        com.google.android.exoplayer2.util.a.checkArgument(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(iArr2.length == jArr2.length);
        this.mdS = jArr;
        this.mdR = iArr;
        this.maximumSize = i;
        this.mkZ = jArr2;
        this.mjh = iArr2;
        this.sampleCount = jArr.length;
    }

    public int fQ(long j) {
        for (int a = v.a(this.mkZ, j, true, false); a >= 0; a--) {
            if ((this.mjh[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int fR(long j) {
        for (int b = v.b(this.mkZ, j, true, false); b < this.mkZ.length; b++) {
            if ((this.mjh[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
