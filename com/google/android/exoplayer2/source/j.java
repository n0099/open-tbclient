package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
public abstract class j extends x {
    protected final x timeline;

    public j(x xVar) {
        this.timeline = xVar;
    }

    @Override // com.google.android.exoplayer2.x
    public int dtZ() {
        return this.timeline.dtZ();
    }

    @Override // com.google.android.exoplayer2.x
    public int p(int i, int i2, boolean z) {
        return this.timeline.p(i, i2, z);
    }

    @Override // com.google.android.exoplayer2.x
    public int q(int i, int i2, boolean z) {
        return this.timeline.q(i, i2, z);
    }

    @Override // com.google.android.exoplayer2.x
    public int vK(boolean z) {
        return this.timeline.vK(z);
    }

    @Override // com.google.android.exoplayer2.x
    public int vL(boolean z) {
        return this.timeline.vL(z);
    }

    @Override // com.google.android.exoplayer2.x
    public x.b a(int i, x.b bVar, boolean z, long j) {
        return this.timeline.a(i, bVar, z, j);
    }

    @Override // com.google.android.exoplayer2.x
    public int dua() {
        return this.timeline.dua();
    }

    @Override // com.google.android.exoplayer2.x
    public x.a a(int i, x.a aVar, boolean z) {
        return this.timeline.a(i, aVar, z);
    }

    @Override // com.google.android.exoplayer2.x
    public int bw(Object obj) {
        return this.timeline.bw(obj);
    }
}
