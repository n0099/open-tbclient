package com.google.android.exoplayer2.text.b;

import com.google.android.exoplayer2.text.e;
import java.util.List;
/* loaded from: classes5.dex */
final class c implements e {
    private final List<com.google.android.exoplayer2.text.b> myy;

    public c(List<com.google.android.exoplayer2.text.b> list) {
        this.myy = list;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gy(long j) {
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dwy() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lf(int i) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gz(long j) {
        return this.myy;
    }
}
