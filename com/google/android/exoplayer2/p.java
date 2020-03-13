package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.l;
/* loaded from: classes6.dex */
final class p {
    public final Object lZF;
    public final long lZL;
    public final long lZN;
    public final l.b lZR;
    public volatile long lZS;
    public volatile long lZT;
    public final x timeline;

    public p(x xVar, Object obj, int i, long j) {
        this(xVar, obj, new l.b(i), j, -9223372036854775807L);
    }

    public p(x xVar, Object obj, l.b bVar, long j, long j2) {
        this.timeline = xVar;
        this.lZF = obj;
        this.lZR = bVar;
        this.lZL = j;
        this.lZN = j2;
        this.lZS = j;
        this.lZT = j;
    }

    public p g(int i, long j, long j2) {
        return b(new l.b(i), j, j2);
    }

    public p b(l.b bVar, long j, long j2) {
        return new p(this.timeline, this.lZF, bVar, j, j2);
    }

    public p IY(int i) {
        p pVar = new p(this.timeline, this.lZF, this.lZR.KF(i), this.lZL, this.lZN);
        a(this, pVar);
        return pVar;
    }

    public p b(x xVar, Object obj) {
        p pVar = new p(xVar, obj, this.lZR, this.lZL, this.lZN);
        a(this, pVar);
        return pVar;
    }

    private static void a(p pVar, p pVar2) {
        pVar2.lZS = pVar.lZS;
        pVar2.lZT = pVar.lZT;
    }
}
