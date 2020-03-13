package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.p;
import java.io.IOException;
/* loaded from: classes6.dex */
final class k implements p {
    public final int group;
    private final l mwC;

    public k(l lVar, int i) {
        this.mwC = lVar;
        this.group = i;
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.mwC.KE(this.group);
    }

    @Override // com.google.android.exoplayer2.source.p
    public void dwm() throws IOException {
        this.mwC.dwm();
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        return this.mwC.a(this.group, mVar, eVar, z);
    }

    @Override // com.google.android.exoplayer2.source.p
    public int ge(long j) {
        return this.mwC.E(this.group, j);
    }
}
