package com.google.android.exoplayer2.source.dash;
/* loaded from: classes6.dex */
public final class e implements d {
    private final com.google.android.exoplayer2.extractor.a muu;

    public e(com.google.android.exoplayer2.extractor.a aVar) {
        this.muu = aVar;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int dwV() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int gq(long j) {
        return this.muu.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long KV(int i) {
        return this.muu.mdS[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long F(int i, long j) {
        return this.muu.mdR[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public com.google.android.exoplayer2.source.dash.manifest.f KW(int i) {
        return new com.google.android.exoplayer2.source.dash.manifest.f(null, this.muu.mdQ[i], this.muu.mdP[i]);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int T(long j, long j2) {
        return this.muu.fK(j);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public boolean dwW() {
        return true;
    }
}
