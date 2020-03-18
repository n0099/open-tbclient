package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.p;
import java.io.IOException;
/* loaded from: classes6.dex */
final class k implements p {
    public final int group;
    private final l myi;

    public k(l lVar, int i) {
        this.myi = lVar;
        this.group = i;
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.myi.KK(this.group);
    }

    @Override // com.google.android.exoplayer2.source.p
    public void dwJ() throws IOException {
        this.myi.dwJ();
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        return this.myi.a(this.group, mVar, eVar, z);
    }

    @Override // com.google.android.exoplayer2.source.p
    public int gf(long j) {
        return this.myi.E(this.group, j);
    }
}
