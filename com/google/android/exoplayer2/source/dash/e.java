package com.google.android.exoplayer2.source.dash;
/* loaded from: classes4.dex */
public final class e implements d {
    private final com.google.android.exoplayer2.extractor.a mpT;

    public e(com.google.android.exoplayer2.extractor.a aVar) {
        this.mpT = aVar;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int duy() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int gn(long j) {
        return this.mpT.length;
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long KH(int i) {
        return this.mpT.lZp[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public long G(int i, long j) {
        return this.mpT.lZo[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public com.google.android.exoplayer2.source.dash.manifest.f KI(int i) {
        return new com.google.android.exoplayer2.source.dash.manifest.f(null, this.mpT.lZn[i], this.mpT.lZm[i]);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public int U(long j, long j2) {
        return this.mpT.fH(j);
    }

    @Override // com.google.android.exoplayer2.source.dash.d
    public boolean duz() {
        return true;
    }
}
