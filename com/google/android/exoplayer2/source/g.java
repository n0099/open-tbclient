package com.google.android.exoplayer2.source;

import java.io.IOException;
/* loaded from: classes5.dex */
public final class g implements p {
    @Override // com.google.android.exoplayer2.source.p
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.p
    public void duZ() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.p
    public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        eVar.setFlags(4);
        return -4;
    }

    @Override // com.google.android.exoplayer2.source.p
    public int gg(long j) {
        return 0;
    }
}
