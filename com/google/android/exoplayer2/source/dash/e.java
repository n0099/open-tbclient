package com.google.android.exoplayer2.source.dash;
/* loaded from: classes6.dex */
public final class e implements d {
    private final com.google.android.exoplayer2.extractor.a mwn;

    public e(com.google.android.exoplayer2.extractor.a aVar) {
        this.mwn = aVar;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int dxv() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int gr(long j) {
        return this.mwn.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long Lb(int i) {
        return this.mwn.mfL[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long F(int i, long j) {
        return this.mwn.mfK[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public com.google.android.exoplayer2.source.dash.manifest.f Lc(int i) {
        return new com.google.android.exoplayer2.source.dash.manifest.f(null, this.mwn.mfJ[i], this.mwn.mfI[i]);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int T(long j, long j2) {
        return this.mwn.fL(j);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public boolean dxw() {
        return true;
    }
}
