package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
/* loaded from: classes4.dex */
public abstract class a extends l {
    private b moC;
    private int[] moD;

    public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
    }

    public void a(b bVar) {
        this.moC = bVar;
        this.moD = bVar.dul();
    }

    public final int KE(int i) {
        return this.moD[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b duk() {
        return this.moC;
    }
}
