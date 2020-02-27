package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
final class o {
    private int dU;
    private boolean lYB;
    private x timeline;
    private final x.a lbF = new x.a();
    private final x.b lbE = new x.b();

    /* loaded from: classes6.dex */
    public static final class a {
        public final long lZA;
        public final long lZB;
        public final boolean lZC;
        public final boolean lZD;
        public final l.b lZx;
        public final long lZy;
        public final long lZz;

        private a(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.lZx = bVar;
            this.lZy = j;
            this.lZz = j2;
            this.lZA = j3;
            this.lZB = j4;
            this.lZC = z;
            this.lZD = z2;
        }

        public a IX(int i) {
            return new a(this.lZx.KF(i), this.lZy, this.lZz, this.lZA, this.lZB, this.lZC, this.lZD);
        }

        public a fy(long j) {
            return new a(this.lZx, j, this.lZz, this.lZA, this.lZB, this.lZC, this.lZD);
        }
    }

    public void a(x xVar) {
        this.timeline = xVar;
    }

    public void setRepeatMode(int i) {
        this.dU = i;
    }

    public void vz(boolean z) {
        this.lYB = z;
    }

    public a a(p pVar) {
        return a(pVar.lZE, pVar.lZA, pVar.lZy);
    }

    public a a(a aVar, long j, long j2) {
        long j3;
        if (aVar.lZC) {
            int a2 = this.timeline.a(aVar.lZx.periodIndex, this.lbF, this.lbE, this.dU, this.lYB);
            if (a2 == -1) {
                return null;
            }
            int i = this.timeline.a(a2, this.lbF).windowIndex;
            if (this.timeline.a(i, this.lbE).mar == a2) {
                Pair<Integer, Long> a3 = this.timeline.a(this.lbE, this.lbF, i, -9223372036854775807L, Math.max(0L, (aVar.lZB + j) - j2));
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
        l.b bVar = aVar.lZx;
        if (bVar.dws()) {
            int i2 = bVar.msd;
            this.timeline.a(bVar.periodIndex, this.lbF);
            int Jc = this.lbF.Jc(i2);
            if (Jc == -1) {
                return null;
            }
            int i3 = bVar.mse + 1;
            if (i3 < Jc) {
                if (this.lbF.dG(i2, i3)) {
                    return e(bVar.periodIndex, i2, i3, aVar.lZA);
                }
                return null;
            }
            int fB = this.lbF.fB(aVar.lZA);
            return f(bVar.periodIndex, aVar.lZA, fB == -1 ? Long.MIN_VALUE : this.lbF.IZ(fB));
        } else if (aVar.lZz != Long.MIN_VALUE) {
            int fA = this.lbF.fA(aVar.lZz);
            if (this.lbF.dG(fA, 0)) {
                return e(bVar.periodIndex, fA, 0, aVar.lZz);
            }
            return null;
        } else {
            int dtE = this.lbF.dtE();
            if (dtE == 0 || this.lbF.IZ(dtE - 1) != Long.MIN_VALUE || this.lbF.Jb(dtE - 1) || !this.lbF.dG(dtE - 1, 0)) {
                return null;
            }
            return e(bVar.periodIndex, dtE - 1, 0, this.lbF.getDurationUs());
        }
    }

    public l.b B(int i, long j) {
        this.timeline.a(i, this.lbF);
        int fA = this.lbF.fA(j);
        if (fA == -1) {
            return new l.b(i);
        }
        return new l.b(i, fA, this.lbF.Ja(fA));
    }

    public a a(a aVar) {
        return a(aVar, aVar.lZx);
    }

    public a a(a aVar, int i) {
        return a(aVar, aVar.lZx.KF(i));
    }

    private a a(a aVar, l.b bVar) {
        long durationUs;
        long j = aVar.lZy;
        long j2 = aVar.lZz;
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.lbF);
        if (bVar.dws()) {
            durationUs = this.lbF.dH(bVar.msd, bVar.mse);
        } else {
            durationUs = j2 == Long.MIN_VALUE ? this.lbF.getDurationUs() : j2;
        }
        return new a(bVar, j, j2, aVar.lZA, durationUs, b, a2);
    }

    private a a(l.b bVar, long j, long j2) {
        this.timeline.a(bVar.periodIndex, this.lbF);
        if (bVar.dws()) {
            if (!this.lbF.dG(bVar.msd, bVar.mse)) {
                return null;
            }
            return e(bVar.periodIndex, bVar.msd, bVar.mse, j);
        }
        int fB = this.lbF.fB(j2);
        return f(bVar.periodIndex, j2, fB == -1 ? Long.MIN_VALUE : this.lbF.IZ(fB));
    }

    private a e(int i, int i2, int i3, long j) {
        l.b bVar = new l.b(i, i2, i3);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a2 = a(bVar, b);
        return new a(bVar, i3 == this.lbF.Ja(i2) ? this.lbF.dtF() : 0L, Long.MIN_VALUE, j, this.timeline.a(bVar.periodIndex, this.lbF).dH(bVar.msd, bVar.mse), b, a2);
    }

    private a f(int i, long j, long j2) {
        l.b bVar = new l.b(i);
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.lbF);
        return new a(bVar, j, j2, -9223372036854775807L, j2 == Long.MIN_VALUE ? this.lbF.getDurationUs() : j2, b, a2);
    }

    private boolean b(l.b bVar, long j) {
        boolean z = false;
        int dtE = this.timeline.a(bVar.periodIndex, this.lbF).dtE();
        if (dtE == 0) {
            return true;
        }
        int i = dtE - 1;
        boolean dws = bVar.dws();
        if (this.lbF.IZ(i) != Long.MIN_VALUE) {
            return !dws && j == Long.MIN_VALUE;
        }
        int Jc = this.lbF.Jc(i);
        if (Jc == -1) {
            return false;
        }
        if ((dws && bVar.msd == i && bVar.mse == Jc + (-1)) || (!dws && this.lbF.Ja(i) == Jc)) {
            z = true;
        }
        return z;
    }

    private boolean a(l.b bVar, boolean z) {
        return !this.timeline.a(this.timeline.a(bVar.periodIndex, this.lbF).windowIndex, this.lbE).isDynamic && this.timeline.b(bVar.periodIndex, this.lbF, this.lbE, this.dU, this.lYB) && z;
    }
}
