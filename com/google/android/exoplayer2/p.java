package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.l;
/* loaded from: classes6.dex */
final class p {
    public final long lZA;
    public final long lZC;
    public final l.b lZG;
    public volatile long lZH;
    public volatile long lZI;
    public final Object lZu;
    public final x timeline;

    public p(x xVar, Object obj, int i, long j) {
        this(xVar, obj, new l.b(i), j, -9223372036854775807L);
    }

    public p(x xVar, Object obj, l.b bVar, long j, long j2) {
        this.timeline = xVar;
        this.lZu = obj;
        this.lZG = bVar;
        this.lZA = j;
        this.lZC = j2;
        this.lZH = j;
        this.lZI = j;
    }

    public p g(int i, long j, long j2) {
        return b(new l.b(i), j, j2);
    }

    public p b(l.b bVar, long j, long j2) {
        return new p(this.timeline, this.lZu, bVar, j, j2);
    }

    public p IY(int i) {
        p pVar = new p(this.timeline, this.lZu, this.lZG.KF(i), this.lZA, this.lZC);
        a(this, pVar);
        return pVar;
    }

    public p b(x xVar, Object obj) {
        p pVar = new p(xVar, obj, this.lZG, this.lZA, this.lZC);
        a(this, pVar);
        return pVar;
    }

    private static void a(p pVar, p pVar2) {
        pVar2.lZH = pVar.lZH;
        pVar2.lZI = pVar.lZI;
    }
}
