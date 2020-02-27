package com.google.android.exoplayer2.text.d;

import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
final class b implements e {
    private final com.google.android.exoplayer2.text.b[] mBc;
    private final long[] mBd;

    public b(com.google.android.exoplayer2.text.b[] bVarArr, long[] jArr) {
        this.mBc = bVarArr;
        this.mBd = jArr;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        int b = v.b(this.mBd, j, false, false);
        if (b < this.mBd.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxI() {
        return this.mBd.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.a.checkArgument(i < this.mBd.length);
        return this.mBd[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gx(long j) {
        int a = v.a(this.mBd, j, true, false);
        return (a == -1 || this.mBc[a] == null) ? Collections.emptyList() : Collections.singletonList(this.mBc[a]);
    }
}
