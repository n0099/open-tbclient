package com.google.android.exoplayer2.text.c;

import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
final class b implements e {
    private final com.google.android.exoplayer2.text.b[] mCX;
    private final long[] mCY;

    public b(com.google.android.exoplayer2.text.b[] bVarArr, long[] jArr) {
        this.mCX = bVarArr;
        this.mCY = jArr;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gx(long j) {
        int b = v.b(this.mCY, j, false, false);
        if (b < this.mCY.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dyi() {
        return this.mCY.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lq(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.a.checkArgument(i < this.mCY.length);
        return this.mCY[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gy(long j) {
        int a = v.a(this.mCY, j, true, false);
        return (a == -1 || this.mCX[a] == null) ? Collections.emptyList() : Collections.singletonList(this.mCX[a]);
    }
}
