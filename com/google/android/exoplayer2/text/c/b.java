package com.google.android.exoplayer2.text.c;

import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
final class b implements e {
    private final com.google.android.exoplayer2.text.b[] mBq;
    private final long[] mBr;

    public b(com.google.android.exoplayer2.text.b[] bVarArr, long[] jArr) {
        this.mBq = bVarArr;
        this.mBr = jArr;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        int b = v.b(this.mBr, j, false, false);
        if (b < this.mBr.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxL() {
        return this.mBr.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.a.checkArgument(i < this.mBr.length);
        return this.mBr[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gx(long j) {
        int a = v.a(this.mBr, j, true, false);
        return (a == -1 || this.mBq[a] == null) ? Collections.emptyList() : Collections.singletonList(this.mBq[a]);
    }
}
