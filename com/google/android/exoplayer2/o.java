package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
/* loaded from: classes5.dex */
final class o {
    private int dT;
    private boolean lXV;
    private x timeline;
    private final x.a laZ = new x.a();
    private final x.b laY = new x.b();

    /* loaded from: classes5.dex */
    public static final class a {
        public final l.b lYR;
        public final long lYS;
        public final long lYT;
        public final long lYU;
        public final long lYV;
        public final boolean lYW;
        public final boolean lYX;

        private a(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.lYR = bVar;
            this.lYS = j;
            this.lYT = j2;
            this.lYU = j3;
            this.lYV = j4;
            this.lYW = z;
            this.lYX = z2;
        }

        public a IS(int i) {
            return new a(this.lYR.KA(i), this.lYS, this.lYT, this.lYU, this.lYV, this.lYW, this.lYX);
        }

        public a fA(long j) {
            return new a(this.lYR, j, this.lYT, this.lYU, this.lYV, this.lYW, this.lYX);
        }
    }

    public void a(x xVar) {
        this.timeline = xVar;
    }

    public void setRepeatMode(int i) {
        this.dT = i;
    }

    public void vv(boolean z) {
        this.lXV = z;
    }

    public a a(p pVar) {
        return a(pVar.lYY, pVar.lYU, pVar.lYS);
    }

    public a a(a aVar, long j, long j2) {
        long j3;
        if (aVar.lYW) {
            int a2 = this.timeline.a(aVar.lYR.periodIndex, this.laZ, this.laY, this.dT, this.lXV);
            if (a2 == -1) {
                return null;
            }
            int i = this.timeline.a(a2, this.laZ).windowIndex;
            if (this.timeline.a(i, this.laY).lZJ == a2) {
                Pair<Integer, Long> a3 = this.timeline.a(this.laY, this.laZ, i, -9223372036854775807L, Math.max(0L, (aVar.lYV + j) - j2));
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
        l.b bVar = aVar.lYR;
        if (bVar.dvi()) {
            int i2 = bVar.mrx;
            this.timeline.a(bVar.periodIndex, this.laZ);
            int IX = this.laZ.IX(i2);
            if (IX == -1) {
                return null;
            }
            int i3 = bVar.mry + 1;
            if (i3 < IX) {
                if (this.laZ.dD(i2, i3)) {
                    return e(bVar.periodIndex, i2, i3, aVar.lYU);
                }
                return null;
            }
            int fD = this.laZ.fD(aVar.lYU);
            return f(bVar.periodIndex, aVar.lYU, fD == -1 ? Long.MIN_VALUE : this.laZ.IU(fD));
        } else if (aVar.lYT != Long.MIN_VALUE) {
            int fC = this.laZ.fC(aVar.lYT);
            if (this.laZ.dD(fC, 0)) {
                return e(bVar.periodIndex, fC, 0, aVar.lYT);
            }
            return null;
        } else {
            int dst = this.laZ.dst();
            if (dst == 0 || this.laZ.IU(dst - 1) != Long.MIN_VALUE || this.laZ.IW(dst - 1) || !this.laZ.dD(dst - 1, 0)) {
                return null;
            }
            return e(bVar.periodIndex, dst - 1, 0, this.laZ.dsq());
        }
    }

    public l.b C(int i, long j) {
        this.timeline.a(i, this.laZ);
        int fC = this.laZ.fC(j);
        if (fC == -1) {
            return new l.b(i);
        }
        return new l.b(i, fC, this.laZ.IV(fC));
    }

    public a a(a aVar) {
        return a(aVar, aVar.lYR);
    }

    public a a(a aVar, int i) {
        return a(aVar, aVar.lYR.KA(i));
    }

    private a a(a aVar, l.b bVar) {
        long dsq;
        long j = aVar.lYS;
        long j2 = aVar.lYT;
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.laZ);
        if (bVar.dvi()) {
            dsq = this.laZ.dE(bVar.mrx, bVar.mry);
        } else {
            dsq = j2 == Long.MIN_VALUE ? this.laZ.dsq() : j2;
        }
        return new a(bVar, j, j2, aVar.lYU, dsq, b, a2);
    }

    private a a(l.b bVar, long j, long j2) {
        this.timeline.a(bVar.periodIndex, this.laZ);
        if (bVar.dvi()) {
            if (!this.laZ.dD(bVar.mrx, bVar.mry)) {
                return null;
            }
            return e(bVar.periodIndex, bVar.mrx, bVar.mry, j);
        }
        int fD = this.laZ.fD(j2);
        return f(bVar.periodIndex, j2, fD == -1 ? Long.MIN_VALUE : this.laZ.IU(fD));
    }

    private a e(int i, int i2, int i3, long j) {
        l.b bVar = new l.b(i, i2, i3);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a2 = a(bVar, b);
        return new a(bVar, i3 == this.laZ.IV(i2) ? this.laZ.dsu() : 0L, Long.MIN_VALUE, j, this.timeline.a(bVar.periodIndex, this.laZ).dE(bVar.mrx, bVar.mry), b, a2);
    }

    private a f(int i, long j, long j2) {
        l.b bVar = new l.b(i);
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.laZ);
        return new a(bVar, j, j2, -9223372036854775807L, j2 == Long.MIN_VALUE ? this.laZ.dsq() : j2, b, a2);
    }

    private boolean b(l.b bVar, long j) {
        boolean z = false;
        int dst = this.timeline.a(bVar.periodIndex, this.laZ).dst();
        if (dst == 0) {
            return true;
        }
        int i = dst - 1;
        boolean dvi = bVar.dvi();
        if (this.laZ.IU(i) != Long.MIN_VALUE) {
            return !dvi && j == Long.MIN_VALUE;
        }
        int IX = this.laZ.IX(i);
        if (IX == -1) {
            return false;
        }
        if ((dvi && bVar.mrx == i && bVar.mry == IX + (-1)) || (!dvi && this.laZ.IV(i) == IX)) {
            z = true;
        }
        return z;
    }

    private boolean a(l.b bVar, boolean z) {
        return !this.timeline.a(this.timeline.a(bVar.periodIndex, this.laZ).windowIndex, this.laY).isDynamic && this.timeline.b(bVar.periodIndex, this.laZ, this.laY, this.dT, this.lXV) && z;
    }
}
