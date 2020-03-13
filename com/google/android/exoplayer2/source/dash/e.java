package com.google.android.exoplayer2.source.dash;
/* loaded from: classes6.dex */
public final class e implements d {
    private final com.google.android.exoplayer2.extractor.a muH;

    public e(com.google.android.exoplayer2.extractor.a aVar) {
        this.muH = aVar;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int dwY() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int gq(long j) {
        return this.muH.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long KV(int i) {
        return this.muH.mef[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long F(int i, long j) {
        return this.muH.mee[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public com.google.android.exoplayer2.source.dash.manifest.f KW(int i) {
        return new com.google.android.exoplayer2.source.dash.manifest.f(null, this.muH.med[i], this.muH.mec[i]);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int T(long j, long j2) {
        return this.muH.fK(j);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public boolean dwZ() {
        return true;
    }
}
