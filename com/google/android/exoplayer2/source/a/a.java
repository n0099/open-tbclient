package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public abstract class a extends l {
    private b muW;
    private int[] muX;

    public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
    }

    public void a(b bVar) {
        this.muW = bVar;
        this.muX = bVar.dxi();
    }

    public final int KY(int i) {
        return this.muX[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b dxh() {
        return this.muW;
    }
}
