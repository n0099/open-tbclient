package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.l;
/* loaded from: classes6.dex */
final class p {
    public final l.b mbA;
    public volatile long mbB;
    public volatile long mbC;
    public final Object mbo;
    public final long mbu;
    public final long mbw;
    public final x timeline;

    public p(x xVar, Object obj, int i, long j) {
        this(xVar, obj, new l.b(i), j, -9223372036854775807L);
    }

    public p(x xVar, Object obj, l.b bVar, long j, long j2) {
        this.timeline = xVar;
        this.mbo = obj;
        this.mbA = bVar;
        this.mbu = j;
        this.mbw = j2;
        this.mbB = j;
        this.mbC = j;
    }

    public p g(int i, long j, long j2) {
        return b(new l.b(i), j, j2);
    }

    public p b(l.b bVar, long j, long j2) {
        return new p(this.timeline, this.mbo, bVar, j, j2);
    }

    public p Je(int i) {
        p pVar = new p(this.timeline, this.mbo, this.mbA.KL(i), this.mbu, this.mbw);
        a(this, pVar);
        return pVar;
    }

    public p b(x xVar, Object obj) {
        p pVar = new p(xVar, obj, this.mbA, this.mbu, this.mbw);
        a(this, pVar);
        return pVar;
    }

    private static void a(p pVar, p pVar2) {
        pVar2.mbB = pVar.mbB;
        pVar2.mbC = pVar.mbC;
    }
}
