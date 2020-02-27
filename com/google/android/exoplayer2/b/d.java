package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.source.t;
/* loaded from: classes6.dex */
public final class d extends b {
    private final Object data;
    private final int reason;

    public d(t tVar, int i) {
        this(tVar, i, 0, null);
    }

    public d(t tVar, int i, int i2, Object obj) {
        super(tVar, i);
        this.reason = i2;
        this.data = obj;
    }

    @Override // com.google.android.exoplayer2.b.f
    public void g(long j, long j2, long j3) {
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dxh() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dxi() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.b.f
    public Object dxj() {
        return this.data;
    }
}
