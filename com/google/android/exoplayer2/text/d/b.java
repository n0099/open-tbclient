package com.google.android.exoplayer2.text.d;

import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
final class b implements e {
    private final com.google.android.exoplayer2.text.b[] mAr;
    private final long[] mAs;

    public b(com.google.android.exoplayer2.text.b[] bVarArr, long[] jArr) {
        this.mAr = bVarArr;
        this.mAs = jArr;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gy(long j) {
        int b = v.b(this.mAs, j, false, false);
        if (b < this.mAs.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dww() {
        return this.mAs.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lf(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.a.checkArgument(i < this.mAs.length);
        return this.mAs[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gz(long j) {
        int a = v.a(this.mAs, j, true, false);
        return (a == -1 || this.mAr[a] == null) ? Collections.emptyList() : Collections.singletonList(this.mAr[a]);
    }
}
