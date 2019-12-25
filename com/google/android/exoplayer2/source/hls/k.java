package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.p;
import java.io.IOException;
/* loaded from: classes4.dex */
final class k implements p {
    public final int group;
    private final l mrP;

    public k(l lVar, int i) {
        this.mrP = lVar;
        this.group = i;
    }

    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return this.mrP.Kq(this.group);
    }

    @Override // com.google.android.exoplayer2.source.p
    public void dtM() throws IOException {
        this.mrP.dtM();
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        return this.mrP.a(this.group, mVar, eVar, z);
    }

    @Override // com.google.android.exoplayer2.source.p
    public int gb(long j) {
        return this.mrP.F(this.group, j);
    }
}
