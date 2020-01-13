package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.l;
/* loaded from: classes5.dex */
final class p {
    public final Object lYH;
    public final long lYN;
    public final long lYP;
    public final l.b lYT;
    public volatile long lYU;
    public volatile long lYV;
    public final x timeline;

    public p(x xVar, Object obj, int i, long j) {
        this(xVar, obj, new l.b(i), j, -9223372036854775807L);
    }

    public p(x xVar, Object obj, l.b bVar, long j, long j2) {
        this.timeline = xVar;
        this.lYH = obj;
        this.lYT = bVar;
        this.lYN = j;
        this.lYP = j2;
        this.lYU = j;
        this.lYV = j;
    }

    public p g(int i, long j, long j2) {
        return b(new l.b(i), j, j2);
    }

    public p b(l.b bVar, long j, long j2) {
        return new p(this.timeline, this.lYH, bVar, j, j2);
    }

    public p IT(int i) {
        p pVar = new p(this.timeline, this.lYH, this.lYT.KA(i), this.lYN, this.lYP);
        a(this, pVar);
        return pVar;
    }

    public p b(x xVar, Object obj) {
        p pVar = new p(xVar, obj, this.lYT, this.lYN, this.lYP);
        a(this, pVar);
        return pVar;
    }

    private static void a(p pVar, p pVar2) {
        pVar2.lYU = pVar.lYU;
        pVar2.lYV = pVar.lYV;
    }
}
