package com.google.android.exoplayer2.source.dash;
/* loaded from: classes5.dex */
public final class e implements d {
    private final com.google.android.exoplayer2.extractor.a mtO;

    public e(com.google.android.exoplayer2.extractor.a aVar) {
        this.mtO = aVar;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int dvL() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int gs(long j) {
        return this.mtO.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long KQ(int i) {
        return this.mtO.mdm[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long G(int i, long j) {
        return this.mtO.mdl[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public com.google.android.exoplayer2.source.dash.manifest.f KR(int i) {
        return new com.google.android.exoplayer2.source.dash.manifest.f(null, this.mtO.mdk[i], this.mtO.mdj[i]);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int U(long j, long j2) {
        return this.mtO.fM(j);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public boolean dvM() {
        return true;
    }
}
