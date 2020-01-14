package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.l;
/* loaded from: classes5.dex */
final class p {
    public final Object lYM;
    public final long lYS;
    public final long lYU;
    public final l.b lYY;
    public volatile long lYZ;
    public volatile long lZa;
    public final x timeline;

    public p(x xVar, Object obj, int i, long j) {
        this(xVar, obj, new l.b(i), j, -9223372036854775807L);
    }

    public p(x xVar, Object obj, l.b bVar, long j, long j2) {
        this.timeline = xVar;
        this.lYM = obj;
        this.lYY = bVar;
        this.lYS = j;
        this.lYU = j2;
        this.lYZ = j;
        this.lZa = j;
    }

    public p g(int i, long j, long j2) {
        return b(new l.b(i), j, j2);
    }

    public p b(l.b bVar, long j, long j2) {
        return new p(this.timeline, this.lYM, bVar, j, j2);
    }

    public p IT(int i) {
        p pVar = new p(this.timeline, this.lYM, this.lYY.KA(i), this.lYS, this.lYU);
        a(this, pVar);
        return pVar;
    }

    public p b(x xVar, Object obj) {
        p pVar = new p(xVar, obj, this.lYY, this.lYS, this.lYU);
        a(this, pVar);
        return pVar;
    }

    private static void a(p pVar, p pVar2) {
        pVar2.lYZ = pVar.lYZ;
        pVar2.lZa = pVar.lZa;
    }
}
