package com.google.android.exoplayer2.source.dash;
/* loaded from: classes6.dex */
public final class e implements d {
    private final com.google.android.exoplayer2.extractor.a muw;

    public e(com.google.android.exoplayer2.extractor.a aVar) {
        this.muw = aVar;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int dwX() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int gq(long j) {
        return this.muw.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long KV(int i) {
        return this.muw.mdU[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long F(int i, long j) {
        return this.muw.mdT[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public com.google.android.exoplayer2.source.dash.manifest.f KW(int i) {
        return new com.google.android.exoplayer2.source.dash.manifest.f(null, this.muw.mdS[i], this.muw.mdR[i]);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int T(long j, long j2) {
        return this.muw.fK(j);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public boolean dwY() {
        return true;
    }
}
