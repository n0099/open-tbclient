package com.google.android.exoplayer2.text.c;

import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
final class b implements e {
    private final com.google.android.exoplayer2.text.b[] mBe;
    private final long[] mBf;

    public b(com.google.android.exoplayer2.text.b[] bVarArr, long[] jArr) {
        this.mBe = bVarArr;
        this.mBf = jArr;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        int b = v.b(this.mBf, j, false, false);
        if (b < this.mBf.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxK() {
        return this.mBf.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.a.checkArgument(i < this.mBf.length);
        return this.mBf[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gx(long j) {
        int a = v.a(this.mBf, j, true, false);
        return (a == -1 || this.mBe[a] == null) ? Collections.emptyList() : Collections.singletonList(this.mBe[a]);
    }
}
