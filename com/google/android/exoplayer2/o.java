package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
/* loaded from: classes5.dex */
final class o {
    private int dT;
    private boolean lXQ;
    private x timeline;
    private final x.a laU = new x.a();
    private final x.b laT = new x.b();

    /* loaded from: classes5.dex */
    public static final class a {
        public final l.b lYM;
        public final long lYN;
        public final long lYO;
        public final long lYP;
        public final long lYQ;
        public final boolean lYR;
        public final boolean lYS;

        private a(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.lYM = bVar;
            this.lYN = j;
            this.lYO = j2;
            this.lYP = j3;
            this.lYQ = j4;
            this.lYR = z;
            this.lYS = z2;
        }

        public a IS(int i) {
            return new a(this.lYM.KA(i), this.lYN, this.lYO, this.lYP, this.lYQ, this.lYR, this.lYS);
        }

        public a fA(long j) {
            return new a(this.lYM, j, this.lYO, this.lYP, this.lYQ, this.lYR, this.lYS);
        }
    }

    public void a(x xVar) {
        this.timeline = xVar;
    }

    public void setRepeatMode(int i) {
        this.dT = i;
    }

    public void vv(boolean z) {
        this.lXQ = z;
    }

    public a a(p pVar) {
        return a(pVar.lYT, pVar.lYP, pVar.lYN);
    }

    public a a(a aVar, long j, long j2) {
        long j3;
        if (aVar.lYR) {
            int a2 = this.timeline.a(aVar.lYM.periodIndex, this.laU, this.laT, this.dT, this.lXQ);
            if (a2 == -1) {
                return null;
            }
            int i = this.timeline.a(a2, this.laU).windowIndex;
            if (this.timeline.a(i, this.laT).lZE == a2) {
                Pair<Integer, Long> a3 = this.timeline.a(this.laT, this.laU, i, -9223372036854775807L, Math.max(0L, (aVar.lYQ + j) - j2));
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
        l.b bVar = aVar.lYM;
        if (bVar.dvg()) {
            int i2 = bVar.mrs;
            this.timeline.a(bVar.periodIndex, this.laU);
            int IX = this.laU.IX(i2);
            if (IX == -1) {
                return null;
            }
            int i3 = bVar.mrt + 1;
            if (i3 < IX) {
                if (this.laU.dD(i2, i3)) {
                    return e(bVar.periodIndex, i2, i3, aVar.lYP);
                }
                return null;
            }
            int fD = this.laU.fD(aVar.lYP);
            return f(bVar.periodIndex, aVar.lYP, fD == -1 ? Long.MIN_VALUE : this.laU.IU(fD));
        } else if (aVar.lYO != Long.MIN_VALUE) {
            int fC = this.laU.fC(aVar.lYO);
            if (this.laU.dD(fC, 0)) {
                return e(bVar.periodIndex, fC, 0, aVar.lYO);
            }
            return null;
        } else {
            int dsr = this.laU.dsr();
            if (dsr == 0 || this.laU.IU(dsr - 1) != Long.MIN_VALUE || this.laU.IW(dsr - 1) || !this.laU.dD(dsr - 1, 0)) {
                return null;
            }
            return e(bVar.periodIndex, dsr - 1, 0, this.laU.dso());
        }
    }

    public l.b C(int i, long j) {
        this.timeline.a(i, this.laU);
        int fC = this.laU.fC(j);
        if (fC == -1) {
            return new l.b(i);
        }
        return new l.b(i, fC, this.laU.IV(fC));
    }

    public a a(a aVar) {
        return a(aVar, aVar.lYM);
    }

    public a a(a aVar, int i) {
        return a(aVar, aVar.lYM.KA(i));
    }

    private a a(a aVar, l.b bVar) {
        long dso;
        long j = aVar.lYN;
        long j2 = aVar.lYO;
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.laU);
        if (bVar.dvg()) {
            dso = this.laU.dE(bVar.mrs, bVar.mrt);
        } else {
            dso = j2 == Long.MIN_VALUE ? this.laU.dso() : j2;
        }
        return new a(bVar, j, j2, aVar.lYP, dso, b, a2);
    }

    private a a(l.b bVar, long j, long j2) {
        this.timeline.a(bVar.periodIndex, this.laU);
        if (bVar.dvg()) {
            if (!this.laU.dD(bVar.mrs, bVar.mrt)) {
                return null;
            }
            return e(bVar.periodIndex, bVar.mrs, bVar.mrt, j);
        }
        int fD = this.laU.fD(j2);
        return f(bVar.periodIndex, j2, fD == -1 ? Long.MIN_VALUE : this.laU.IU(fD));
    }

    private a e(int i, int i2, int i3, long j) {
        l.b bVar = new l.b(i, i2, i3);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a2 = a(bVar, b);
        return new a(bVar, i3 == this.laU.IV(i2) ? this.laU.dss() : 0L, Long.MIN_VALUE, j, this.timeline.a(bVar.periodIndex, this.laU).dE(bVar.mrs, bVar.mrt), b, a2);
    }

    private a f(int i, long j, long j2) {
        l.b bVar = new l.b(i);
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.laU);
        return new a(bVar, j, j2, -9223372036854775807L, j2 == Long.MIN_VALUE ? this.laU.dso() : j2, b, a2);
    }

    private boolean b(l.b bVar, long j) {
        boolean z = false;
        int dsr = this.timeline.a(bVar.periodIndex, this.laU).dsr();
        if (dsr == 0) {
            return true;
        }
        int i = dsr - 1;
        boolean dvg = bVar.dvg();
        if (this.laU.IU(i) != Long.MIN_VALUE) {
            return !dvg && j == Long.MIN_VALUE;
        }
        int IX = this.laU.IX(i);
        if (IX == -1) {
            return false;
        }
        if ((dvg && bVar.mrs == i && bVar.mrt == IX + (-1)) || (!dvg && this.laU.IV(i) == IX)) {
            z = true;
        }
        return z;
    }

    private boolean a(l.b bVar, boolean z) {
        return !this.timeline.a(this.timeline.a(bVar.periodIndex, this.laU).windowIndex, this.laT).isDynamic && this.timeline.b(bVar.periodIndex, this.laU, this.laT, this.dT, this.lXQ) && z;
    }
}
