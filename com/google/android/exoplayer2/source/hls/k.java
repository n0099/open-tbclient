package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.p;
import java.io.IOException;
/* loaded from: classes5.dex */
final class k implements p {
    public final int group;
    private final l mvE;

    public k(l lVar, int i) {
        this.mvE = lVar;
        this.group = i;
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.mvE.Kz(this.group);
    }

    @Override // com.google.android.exoplayer2.source.p
    public void duX() throws IOException {
        this.mvE.duX();
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        return this.mvE.a(this.group, mVar, eVar, z);
    }

    @Override // com.google.android.exoplayer2.source.p
    public int gg(long j) {
        return this.mvE.F(this.group, j);
    }
}
