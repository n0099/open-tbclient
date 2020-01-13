package com.google.android.exoplayer2.text.g;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
final class c implements com.google.android.exoplayer2.text.e {
    private final List<com.google.android.exoplayer2.text.b> myt;

    public c(List<com.google.android.exoplayer2.text.b> list) {
        this.myt = Collections.unmodifiableList(list);
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gy(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dww() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lf(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gz(long j) {
        return j >= 0 ? this.myt : Collections.emptyList();
    }
}
