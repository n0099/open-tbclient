package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
/* loaded from: classes4.dex */
final class o {
    private int dU;
    private boolean lTZ;
    private x timeline;
    private final x.a kXu = new x.a();
    private final x.b kXt = new x.b();

    /* loaded from: classes4.dex */
    public static final class a {
        public final l.b lUV;
        public final long lUW;
        public final long lUX;
        public final long lUY;
        public final long lUZ;
        public final boolean lVa;
        public final boolean lVb;

        private a(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.lUV = bVar;
            this.lUW = j;
            this.lUX = j2;
            this.lUY = j3;
            this.lUZ = j4;
            this.lVa = z;
            this.lVb = z2;
        }

        public a IJ(int i) {
            return new a(this.lUV.Kr(i), this.lUW, this.lUX, this.lUY, this.lUZ, this.lVa, this.lVb);
        }

        public a fv(long j) {
            return new a(this.lUV, j, this.lUX, this.lUY, this.lUZ, this.lVa, this.lVb);
        }
    }

    public void a(x xVar) {
        this.timeline = xVar;
    }

    public void setRepeatMode(int i) {
        this.dU = i;
    }

    public void vj(boolean z) {
        this.lTZ = z;
    }

    public a a(p pVar) {
        return a(pVar.lVc, pVar.lUY, pVar.lUW);
    }

    public a a(a aVar, long j, long j2) {
        long j3;
        if (aVar.lVa) {
            int a2 = this.timeline.a(aVar.lUV.periodIndex, this.kXu, this.kXt, this.dU, this.lTZ);
            if (a2 == -1) {
                return null;
            }
            int i = this.timeline.a(a2, this.kXu).windowIndex;
            if (this.timeline.a(i, this.kXt).lVP == a2) {
                Pair<Integer, Long> a3 = this.timeline.a(this.kXt, this.kXu, i, -9223372036854775807L, Math.max(0L, (aVar.lUZ + j) - j2));
                if (a3 == null) {
                    return null;
                }
                int intValue = ((Integer) a3.first).intValue();
                j3 = ((Long) a3.second).longValue();
                a2 = intValue;
            } else {
                j3 = 0;
            }
            return a(C(a2, j3), j3, j3);
        }
        l.b bVar = aVar.lUV;
        if (bVar.dtV()) {
            int i2 = bVar.mnD;
            this.timeline.a(bVar.periodIndex, this.kXu);
            int IO = this.kXu.IO(i2);
            if (IO == -1) {
                return null;
            }
            int i3 = bVar.mnE + 1;
            if (i3 < IO) {
                if (this.kXu.dF(i2, i3)) {
                    return e(bVar.periodIndex, i2, i3, aVar.lUY);
                }
                return null;
            }
            int fy = this.kXu.fy(aVar.lUY);
            return f(bVar.periodIndex, aVar.lUY, fy == -1 ? Long.MIN_VALUE : this.kXu.IL(fy));
        } else if (aVar.lUX != Long.MIN_VALUE) {
            int fx = this.kXu.fx(aVar.lUX);
            if (this.kXu.dF(fx, 0)) {
                return e(bVar.periodIndex, fx, 0, aVar.lUX);
            }
            return null;
        } else {
            int drf = this.kXu.drf();
            if (drf == 0 || this.kXu.IL(drf - 1) != Long.MIN_VALUE || this.kXu.IN(drf - 1) || !this.kXu.dF(drf - 1, 0)) {
                return null;
            }
            return e(bVar.periodIndex, drf - 1, 0, this.kXu.drc());
        }
    }

    public l.b C(int i, long j) {
        this.timeline.a(i, this.kXu);
        int fx = this.kXu.fx(j);
        if (fx == -1) {
            return new l.b(i);
        }
        return new l.b(i, fx, this.kXu.IM(fx));
    }

    public a a(a aVar) {
        return a(aVar, aVar.lUV);
    }

    public a a(a aVar, int i) {
        return a(aVar, aVar.lUV.Kr(i));
    }

    private a a(a aVar, l.b bVar) {
        long drc;
        long j = aVar.lUW;
        long j2 = aVar.lUX;
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.kXu);
        if (bVar.dtV()) {
            drc = this.kXu.dG(bVar.mnD, bVar.mnE);
        } else {
            drc = j2 == Long.MIN_VALUE ? this.kXu.drc() : j2;
        }
        return new a(bVar, j, j2, aVar.lUY, drc, b, a2);
    }

    private a a(l.b bVar, long j, long j2) {
        this.timeline.a(bVar.periodIndex, this.kXu);
        if (bVar.dtV()) {
            if (!this.kXu.dF(bVar.mnD, bVar.mnE)) {
                return null;
            }
            return e(bVar.periodIndex, bVar.mnD, bVar.mnE, j);
        }
        int fy = this.kXu.fy(j2);
        return f(bVar.periodIndex, j2, fy == -1 ? Long.MIN_VALUE : this.kXu.IL(fy));
    }

    private a e(int i, int i2, int i3, long j) {
        l.b bVar = new l.b(i, i2, i3);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a2 = a(bVar, b);
        return new a(bVar, i3 == this.kXu.IM(i2) ? this.kXu.drg() : 0L, Long.MIN_VALUE, j, this.timeline.a(bVar.periodIndex, this.kXu).dG(bVar.mnD, bVar.mnE), b, a2);
    }

    private a f(int i, long j, long j2) {
        l.b bVar = new l.b(i);
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.kXu);
        return new a(bVar, j, j2, -9223372036854775807L, j2 == Long.MIN_VALUE ? this.kXu.drc() : j2, b, a2);
    }

    private boolean b(l.b bVar, long j) {
        boolean z = false;
        int drf = this.timeline.a(bVar.periodIndex, this.kXu).drf();
        if (drf == 0) {
            return true;
        }
        int i = drf - 1;
        boolean dtV = bVar.dtV();
        if (this.kXu.IL(i) != Long.MIN_VALUE) {
            return !dtV && j == Long.MIN_VALUE;
        }
        int IO = this.kXu.IO(i);
        if (IO == -1) {
            return false;
        }
        if ((dtV && bVar.mnD == i && bVar.mnE == IO + (-1)) || (!dtV && this.kXu.IM(i) == IO)) {
            z = true;
        }
        return z;
    }

    private boolean a(l.b bVar, boolean z) {
        return !this.timeline.a(this.timeline.a(bVar.periodIndex, this.kXu).windowIndex, this.kXt).isDynamic && this.timeline.b(bVar.periodIndex, this.kXu, this.kXt, this.dU, this.lTZ) && z;
    }
}
