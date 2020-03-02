package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.p;
import java.io.IOException;
/* loaded from: classes6.dex */
final class k implements p {
    public final int group;
    private final l mwr;

    public k(l lVar, int i) {
        this.mwr = lVar;
        this.group = i;
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.mwr.KE(this.group);
    }

    @Override // com.google.android.exoplayer2.source.p
    public void dwl() throws IOException {
        this.mwr.dwl();
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        return this.mwr.a(this.group, mVar, eVar, z);
    }

    @Override // com.google.android.exoplayer2.source.p
    public int ge(long j) {
        return this.mwr.E(this.group, j);
    }
}
