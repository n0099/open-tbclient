package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.x;
/* loaded from: classes5.dex */
public abstract class j extends x {
    protected final x timeline;

    public j(x xVar) {
        this.timeline = xVar;
    }

    @Override // com.google.android.exoplayer2.x
    public int dsl() {
        return this.timeline.dsl();
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
    public int vz(boolean z) {
        return this.timeline.vz(z);
    }

    @Override // com.google.android.exoplayer2.x
    public int vA(boolean z) {
        return this.timeline.vA(z);
    }

    @Override // com.google.android.exoplayer2.x
    public x.b a(int i, x.b bVar, boolean z, long j) {
        return this.timeline.a(i, bVar, z, j);
    }

    @Override // com.google.android.exoplayer2.x
    public int dsm() {
        return this.timeline.dsm();
    }

    @Override // com.google.android.exoplayer2.x
    public x.a a(int i, x.a aVar, boolean z) {
        return this.timeline.a(i, aVar, z);
    }

    @Override // com.google.android.exoplayer2.x
    public int bu(Object obj) {
        return this.timeline.bu(obj);
    }
}
