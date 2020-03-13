package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public abstract class a extends l {
    private b mtp;
    private int[] mtq;

    public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
    }

    public void a(b bVar) {
        this.mtp = bVar;
        this.mtq = bVar.dwL();
    }

    public final int KS(int i) {
        return this.mtq[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b dwK() {
        return this.mtp;
    }
}
