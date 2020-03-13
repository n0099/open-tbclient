package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
final class o {
    private int dU;
    private boolean lYO;
    private x timeline;
    private final x.a lbT = new x.a();
    private final x.b lbS = new x.b();

    /* loaded from: classes6.dex */
    public static final class a {
        public final l.b lZK;
        public final long lZL;
        public final long lZM;
        public final long lZN;
        public final long lZO;
        public final boolean lZP;
        public final boolean lZQ;

        private a(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.lZK = bVar;
            this.lZL = j;
            this.lZM = j2;
            this.lZN = j3;
            this.lZO = j4;
            this.lZP = z;
            this.lZQ = z2;
        }

        public a IX(int i) {
            return new a(this.lZK.KF(i), this.lZL, this.lZM, this.lZN, this.lZO, this.lZP, this.lZQ);
        }

        public a fy(long j) {
            return new a(this.lZK, j, this.lZM, this.lZN, this.lZO, this.lZP, this.lZQ);
        }
    }

    public void a(x xVar) {
        this.timeline = xVar;
    }

    public void setRepeatMode(int i) {
        this.dU = i;
    }

    public void vz(boolean z) {
        this.lYO = z;
    }

    public a a(p pVar) {
        return a(pVar.lZR, pVar.lZN, pVar.lZL);
    }

    public a a(a aVar, long j, long j2) {
        long j3;
        if (aVar.lZP) {
            int a2 = this.timeline.a(aVar.lZK.periodIndex, this.lbT, this.lbS, this.dU, this.lYO);
            if (a2 == -1) {
                return null;
            }
            int i = this.timeline.a(a2, this.lbT).windowIndex;
            if (this.timeline.a(i, this.lbS).maF == a2) {
                Pair<Integer, Long> a3 = this.timeline.a(this.lbS, this.lbT, i, -9223372036854775807L, Math.max(0L, (aVar.lZO + j) - j2));
                if (a3 == null) {
                    return null;
                }
                int intValue = ((Integer) a3.first).intValue();
                j3 = ((Long) a3.second).longValue();
                a2 = intValue;
            } else {
                j3 = 0;
            }
            return a(B(a2, j3), j3, j3);
        }
        l.b bVar = aVar.lZK;
        if (bVar.dwv()) {
            int i2 = bVar.msr;
            this.timeline.a(bVar.periodIndex, this.lbT);
            int Jc = this.lbT.Jc(i2);
            if (Jc == -1) {
                return null;
            }
            int i3 = bVar.mss + 1;
            if (i3 < Jc) {
                if (this.lbT.dG(i2, i3)) {
                    return e(bVar.periodIndex, i2, i3, aVar.lZN);
                }
                return null;
            }
            int fB = this.lbT.fB(aVar.lZN);
            return f(bVar.periodIndex, aVar.lZN, fB == -1 ? Long.MIN_VALUE : this.lbT.IZ(fB));
        } else if (aVar.lZM != Long.MIN_VALUE) {
            int fA = this.lbT.fA(aVar.lZM);
            if (this.lbT.dG(fA, 0)) {
                return e(bVar.periodIndex, fA, 0, aVar.lZM);
            }
            return null;
        } else {
            int dtH = this.lbT.dtH();
            if (dtH == 0 || this.lbT.IZ(dtH - 1) != Long.MIN_VALUE || this.lbT.Jb(dtH - 1) || !this.lbT.dG(dtH - 1, 0)) {
                return null;
            }
            return e(bVar.periodIndex, dtH - 1, 0, this.lbT.getDurationUs());
        }
    }

    public l.b B(int i, long j) {
        this.timeline.a(i, this.lbT);
        int fA = this.lbT.fA(j);
        if (fA == -1) {
            return new l.b(i);
        }
        return new l.b(i, fA, this.lbT.Ja(fA));
    }

    public a a(a aVar) {
        return a(aVar, aVar.lZK);
    }

    public a a(a aVar, int i) {
        return a(aVar, aVar.lZK.KF(i));
    }

    private a a(a aVar, l.b bVar) {
        long durationUs;
        long j = aVar.lZL;
        long j2 = aVar.lZM;
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.lbT);
        if (bVar.dwv()) {
            durationUs = this.lbT.dH(bVar.msr, bVar.mss);
        } else {
            durationUs = j2 == Long.MIN_VALUE ? this.lbT.getDurationUs() : j2;
        }
        return new a(bVar, j, j2, aVar.lZN, durationUs, b, a2);
    }

    private a a(l.b bVar, long j, long j2) {
        this.timeline.a(bVar.periodIndex, this.lbT);
        if (bVar.dwv()) {
            if (!this.lbT.dG(bVar.msr, bVar.mss)) {
                return null;
            }
            return e(bVar.periodIndex, bVar.msr, bVar.mss, j);
        }
        int fB = this.lbT.fB(j2);
        return f(bVar.periodIndex, j2, fB == -1 ? Long.MIN_VALUE : this.lbT.IZ(fB));
    }

    private a e(int i, int i2, int i3, long j) {
        l.b bVar = new l.b(i, i2, i3);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a2 = a(bVar, b);
        return new a(bVar, i3 == this.lbT.Ja(i2) ? this.lbT.dtI() : 0L, Long.MIN_VALUE, j, this.timeline.a(bVar.periodIndex, this.lbT).dH(bVar.msr, bVar.mss), b, a2);
    }

    private a f(int i, long j, long j2) {
        l.b bVar = new l.b(i);
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.lbT);
        return new a(bVar, j, j2, -9223372036854775807L, j2 == Long.MIN_VALUE ? this.lbT.getDurationUs() : j2, b, a2);
    }

    private boolean b(l.b bVar, long j) {
        boolean z = false;
        int dtH = this.timeline.a(bVar.periodIndex, this.lbT).dtH();
        if (dtH == 0) {
            return true;
        }
        int i = dtH - 1;
        boolean dwv = bVar.dwv();
        if (this.lbT.IZ(i) != Long.MIN_VALUE) {
            return !dwv && j == Long.MIN_VALUE;
        }
        int Jc = this.lbT.Jc(i);
        if (Jc == -1) {
            return false;
        }
        if ((dwv && bVar.msr == i && bVar.mss == Jc + (-1)) || (!dwv && this.lbT.Ja(i) == Jc)) {
            z = true;
        }
        return z;
    }

    private boolean a(l.b bVar, boolean z) {
        return !this.timeline.a(this.timeline.a(bVar.periodIndex, this.lbT).windowIndex, this.lbS).isDynamic && this.timeline.b(bVar.periodIndex, this.lbT, this.lbS, this.dU, this.lYO) && z;
    }
}
