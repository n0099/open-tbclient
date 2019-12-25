package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.l;
/* loaded from: classes4.dex */
final class p {
    public final Object lUQ;
    public final long lUW;
    public final long lUY;
    public final l.b lVc;
    public volatile long lVd;
    public volatile long lVe;
    public final x timeline;

    public p(x xVar, Object obj, int i, long j) {
        this(xVar, obj, new l.b(i), j, -9223372036854775807L);
    }

    public p(x xVar, Object obj, l.b bVar, long j, long j2) {
        this.timeline = xVar;
        this.lUQ = obj;
        this.lVc = bVar;
        this.lUW = j;
        this.lUY = j2;
        this.lVd = j;
        this.lVe = j;
    }

    public p g(int i, long j, long j2) {
        return b(new l.b(i), j, j2);
    }

    public p b(l.b bVar, long j, long j2) {
        return new p(this.timeline, this.lUQ, bVar, j, j2);
    }

    public p IK(int i) {
        p pVar = new p(this.timeline, this.lUQ, this.lVc.Kr(i), this.lUW, this.lUY);
        a(this, pVar);
        return pVar;
    }

    public p b(x xVar, Object obj) {
        p pVar = new p(xVar, obj, this.lVc, this.lUW, this.lUY);
        a(this, pVar);
        return pVar;
    }

    private static void a(p pVar, p pVar2) {
        pVar2.lVd = pVar.lVd;
        pVar2.lVe = pVar.lVe;
    }
}
