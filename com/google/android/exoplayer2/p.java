package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.l;
/* loaded from: classes6.dex */
final class p {
    public final long lZA;
    public final l.b lZE;
    public volatile long lZF;
    public volatile long lZG;
    public final Object lZs;
    public final long lZy;
    public final x timeline;

    public p(x xVar, Object obj, int i, long j) {
        this(xVar, obj, new l.b(i), j, -9223372036854775807L);
    }

    public p(x xVar, Object obj, l.b bVar, long j, long j2) {
        this.timeline = xVar;
        this.lZs = obj;
        this.lZE = bVar;
        this.lZy = j;
        this.lZA = j2;
        this.lZF = j;
        this.lZG = j;
    }

    public p g(int i, long j, long j2) {
        return b(new l.b(i), j, j2);
    }

    public p b(l.b bVar, long j, long j2) {
        return new p(this.timeline, this.lZs, bVar, j, j2);
    }

    public p IY(int i) {
        p pVar = new p(this.timeline, this.lZs, this.lZE.KF(i), this.lZy, this.lZA);
        a(this, pVar);
        return pVar;
    }

    public p b(x xVar, Object obj) {
        p pVar = new p(xVar, obj, this.lZE, this.lZy, this.lZA);
        a(this, pVar);
        return pVar;
    }

    private static void a(p pVar, p pVar2) {
        pVar2.lZF = pVar.lZF;
        pVar2.lZG = pVar.lZG;
    }
}
