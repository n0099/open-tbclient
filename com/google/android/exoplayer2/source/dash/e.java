package com.google.android.exoplayer2.source.dash;
/* loaded from: classes5.dex */
public final class e implements d {
    private final com.google.android.exoplayer2.extractor.a mtJ;

    public e(com.google.android.exoplayer2.extractor.a aVar) {
        this.mtJ = aVar;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int dvJ() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int gs(long j) {
        return this.mtJ.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long KQ(int i) {
        return this.mtJ.mdh[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long G(int i, long j) {
        return this.mtJ.mdg[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public com.google.android.exoplayer2.source.dash.manifest.f KR(int i) {
        return new com.google.android.exoplayer2.source.dash.manifest.f(null, this.mtJ.mdf[i], this.mtJ.mde[i]);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int U(long j, long j2) {
        return this.mtJ.fM(j);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public boolean dvK() {
        return true;
    }
}
