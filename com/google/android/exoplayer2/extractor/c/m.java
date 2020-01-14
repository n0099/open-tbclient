package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
final class m {
    public final int maximumSize;
    public final int[] mdj;
    public final long[] mdk;
    public final int[] miz;
    public final long[] mkr;
    public final int sampleCount;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        com.google.android.exoplayer2.util.a.checkArgument(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.checkArgument(iArr2.length == jArr2.length);
        this.mdk = jArr;
        this.mdj = iArr;
        this.maximumSize = i;
        this.mkr = jArr2;
        this.miz = iArr2;
        this.sampleCount = jArr.length;
    }

    public int fS(long j) {
        for (int a = v.a(this.mkr, j, true, false); a >= 0; a--) {
            if ((this.miz[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int fT(long j) {
        for (int b = v.b(this.mkr, j, true, false); b < this.mkr.length; b++) {
            if ((this.miz[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
