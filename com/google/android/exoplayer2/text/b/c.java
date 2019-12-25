package com.google.android.exoplayer2.text.b;

import com.google.android.exoplayer2.text.e;
import java.util.List;
/* loaded from: classes4.dex */
final class c implements e {
    private final List<com.google.android.exoplayer2.text.b> muG;

    public c(List<com.google.android.exoplayer2.text.b> list) {
        this.muG = list;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gt(long j) {
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dvl() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long KW(int i) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gu(long j) {
        return this.muG;
    }
}
