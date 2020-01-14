package com.google.android.exoplayer2.text.c;

import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
final class b implements e {
    private final com.google.android.exoplayer2.text.b[] mAw;
    private final long[] mAx;

    public b(com.google.android.exoplayer2.text.b[] bVarArr, long[] jArr) {
        this.mAw = bVarArr;
        this.mAx = jArr;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gy(long j) {
        int b = v.b(this.mAx, j, false, false);
        if (b < this.mAx.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dwy() {
        return this.mAx.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lf(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.a.checkArgument(i < this.mAx.length);
        return this.mAx[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gz(long j) {
        int a = v.a(this.mAx, j, true, false);
        return (a == -1 || this.mAw[a] == null) ? Collections.emptyList() : Collections.singletonList(this.mAw[a]);
    }
}
