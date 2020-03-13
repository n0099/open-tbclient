package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class m {
    public final int maximumSize;
    public final int[] mec;
    public final long[] med;
    public final int[] mjs;
    public final long[] mlk;
    public final int sampleCount;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        com.google.android.exoplayer2.util.a.checkArgument(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(iArr2.length == jArr2.length);
        this.med = jArr;
        this.mec = iArr;
        this.maximumSize = i;
        this.mlk = jArr2;
        this.mjs = iArr2;
        this.sampleCount = jArr.length;
    }

    public int fQ(long j) {
        for (int a = v.a(this.mlk, j, true, false); a >= 0; a--) {
            if ((this.mjs[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int fR(long j) {
        for (int b = v.b(this.mlk, j, true, false); b < this.mlk.length; b++) {
            if ((this.mjs[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
