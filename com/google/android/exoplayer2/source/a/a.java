package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
/* loaded from: classes5.dex */
public abstract class a extends l {
    private b msr;
    private int[] mss;

    public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
    }

    public void a(b bVar) {
        this.msr = bVar;
        this.mss = bVar.dvw();
    }

    public final int KN(int i) {
        return this.mss[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b dvv() {
        return this.msr;
    }
}
