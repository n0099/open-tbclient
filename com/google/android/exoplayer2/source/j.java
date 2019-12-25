package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.x;
/* loaded from: classes4.dex */
public abstract class j extends x {
    protected final x timeline;

    public j(x xVar) {
        this.timeline = xVar;
    }

    @Override // com.google.android.exoplayer2.x
    public int dqZ() {
        return this.timeline.dqZ();
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
    public int vn(boolean z) {
        return this.timeline.vn(z);
    }

    @Override // com.google.android.exoplayer2.x
    public int vo(boolean z) {
        return this.timeline.vo(z);
    }

    @Override // com.google.android.exoplayer2.x
    public x.b a(int i, x.b bVar, boolean z, long j) {
        return this.timeline.a(i, bVar, z, j);
    }

    @Override // com.google.android.exoplayer2.x
    public int dra() {
        return this.timeline.dra();
    }

    @Override // com.google.android.exoplayer2.x
    public x.a a(int i, x.a aVar, boolean z) {
        return this.timeline.a(i, aVar, z);
    }

    @Override // com.google.android.exoplayer2.x
    public int bt(Object obj) {
        return this.timeline.bt(obj);
    }
}
