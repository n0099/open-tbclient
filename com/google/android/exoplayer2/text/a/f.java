package com.google.android.exoplayer2.text.a;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
final class f implements com.google.android.exoplayer2.text.e {
    private final List<com.google.android.exoplayer2.text.b> myy;

    public f(List<com.google.android.exoplayer2.text.b> list) {
        this.myy = list;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gy(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dwy() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lf(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gz(long j) {
        return j >= 0 ? this.myy : Collections.emptyList();
    }
}
