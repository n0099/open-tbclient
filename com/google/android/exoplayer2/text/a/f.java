package com.google.android.exoplayer2.text.a;

import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
final class f implements com.google.android.exoplayer2.text.e {
    private final List<com.google.android.exoplayer2.text.b> muG;

    public f(List<com.google.android.exoplayer2.text.b> list) {
        this.muG = list;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gt(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dvl() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long KW(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gu(long j) {
        return j >= 0 ? this.muG : Collections.emptyList();
    }
}
