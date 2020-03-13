package com.google.android.exoplayer2.text.g;

import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
final class c implements com.google.android.exoplayer2.text.e {
    private final List<com.google.android.exoplayer2.text.b> mzr;

    public c(List<com.google.android.exoplayer2.text.b> list) {
        this.mzr = Collections.unmodifiableList(list);
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxL() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gx(long j) {
        return j >= 0 ? this.mzr : Collections.emptyList();
    }
}
