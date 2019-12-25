package com.google.android.exoplayer2.text.c;

import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
final class b implements e {
    private final com.google.android.exoplayer2.text.b[] mwD;
    private final long[] mwE;

    public b(com.google.android.exoplayer2.text.b[] bVarArr, long[] jArr) {
        this.mwD = bVarArr;
        this.mwE = jArr;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gt(long j) {
        int b = v.b(this.mwE, j, false, false);
        if (b < this.mwE.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dvl() {
        return this.mwE.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long KW(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.a.checkArgument(i < this.mwE.length);
        return this.mwE[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gu(long j) {
        int a = v.a(this.mwE, j, true, false);
        return (a == -1 || this.mwD[a] == null) ? Collections.emptyList() : Collections.singletonList(this.mwD[a]);
    }
}
