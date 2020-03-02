package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
final class o {
    private int dU;
    private boolean lYD;
    private x timeline;
    private final x.a lbH = new x.a();
    private final x.b lbG = new x.b();

    /* loaded from: classes6.dex */
    public static final class a {
        public final long lZA;
        public final long lZB;
        public final long lZC;
        public final long lZD;
        public final boolean lZE;
        public final boolean lZF;
        public final l.b lZz;

        private a(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.lZz = bVar;
            this.lZA = j;
            this.lZB = j2;
            this.lZC = j3;
            this.lZD = j4;
            this.lZE = z;
            this.lZF = z2;
        }

        public a IX(int i) {
            return new a(this.lZz.KF(i), this.lZA, this.lZB, this.lZC, this.lZD, this.lZE, this.lZF);
        }

        public a fy(long j) {
            return new a(this.lZz, j, this.lZB, this.lZC, this.lZD, this.lZE, this.lZF);
        }
    }

    public void a(x xVar) {
        this.timeline = xVar;
    }

    public void setRepeatMode(int i) {
        this.dU = i;
    }

    public void vz(boolean z) {
        this.lYD = z;
    }

    public a a(p pVar) {
        return a(pVar.lZG, pVar.lZC, pVar.lZA);
    }

    public a a(a aVar, long j, long j2) {
        long j3;
        if (aVar.lZE) {
            int a2 = this.timeline.a(aVar.lZz.periodIndex, this.lbH, this.lbG, this.dU, this.lYD);
            if (a2 == -1) {
                return null;
            }
            int i = this.timeline.a(a2, this.lbH).windowIndex;
            if (this.timeline.a(i, this.lbG).mat == a2) {
                Pair<Integer, Long> a3 = this.timeline.a(this.lbG, this.lbH, i, -9223372036854775807L, Math.max(0L, (aVar.lZD + j) - j2));
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
        l.b bVar = aVar.lZz;
        if (bVar.dwu()) {
            int i2 = bVar.msf;
            this.timeline.a(bVar.periodIndex, this.lbH);
            int Jc = this.lbH.Jc(i2);
            if (Jc == -1) {
                return null;
            }
            int i3 = bVar.msh + 1;
            if (i3 < Jc) {
                if (this.lbH.dG(i2, i3)) {
                    return e(bVar.periodIndex, i2, i3, aVar.lZC);
                }
                return null;
            }
            int fB = this.lbH.fB(aVar.lZC);
            return f(bVar.periodIndex, aVar.lZC, fB == -1 ? Long.MIN_VALUE : this.lbH.IZ(fB));
        } else if (aVar.lZB != Long.MIN_VALUE) {
            int fA = this.lbH.fA(aVar.lZB);
            if (this.lbH.dG(fA, 0)) {
                return e(bVar.periodIndex, fA, 0, aVar.lZB);
            }
            return null;
        } else {
            int dtG = this.lbH.dtG();
            if (dtG == 0 || this.lbH.IZ(dtG - 1) != Long.MIN_VALUE || this.lbH.Jb(dtG - 1) || !this.lbH.dG(dtG - 1, 0)) {
                return null;
            }
            return e(bVar.periodIndex, dtG - 1, 0, this.lbH.getDurationUs());
        }
    }

    public l.b B(int i, long j) {
        this.timeline.a(i, this.lbH);
        int fA = this.lbH.fA(j);
        if (fA == -1) {
            return new l.b(i);
        }
        return new l.b(i, fA, this.lbH.Ja(fA));
    }

    public a a(a aVar) {
        return a(aVar, aVar.lZz);
    }

    public a a(a aVar, int i) {
        return a(aVar, aVar.lZz.KF(i));
    }

    private a a(a aVar, l.b bVar) {
        long durationUs;
        long j = aVar.lZA;
        long j2 = aVar.lZB;
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.lbH);
        if (bVar.dwu()) {
            durationUs = this.lbH.dH(bVar.msf, bVar.msh);
        } else {
            durationUs = j2 == Long.MIN_VALUE ? this.lbH.getDurationUs() : j2;
        }
        return new a(bVar, j, j2, aVar.lZC, durationUs, b, a2);
    }

    private a a(l.b bVar, long j, long j2) {
        this.timeline.a(bVar.periodIndex, this.lbH);
        if (bVar.dwu()) {
            if (!this.lbH.dG(bVar.msf, bVar.msh)) {
                return null;
            }
            return e(bVar.periodIndex, bVar.msf, bVar.msh, j);
        }
        int fB = this.lbH.fB(j2);
        return f(bVar.periodIndex, j2, fB == -1 ? Long.MIN_VALUE : this.lbH.IZ(fB));
    }

    private a e(int i, int i2, int i3, long j) {
        l.b bVar = new l.b(i, i2, i3);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a2 = a(bVar, b);
        return new a(bVar, i3 == this.lbH.Ja(i2) ? this.lbH.dtH() : 0L, Long.MIN_VALUE, j, this.timeline.a(bVar.periodIndex, this.lbH).dH(bVar.msf, bVar.msh), b, a2);
    }

    private a f(int i, long j, long j2) {
        l.b bVar = new l.b(i);
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.lbH);
        return new a(bVar, j, j2, -9223372036854775807L, j2 == Long.MIN_VALUE ? this.lbH.getDurationUs() : j2, b, a2);
    }

    private boolean b(l.b bVar, long j) {
        boolean z = false;
        int dtG = this.timeline.a(bVar.periodIndex, this.lbH).dtG();
        if (dtG == 0) {
            return true;
        }
        int i = dtG - 1;
        boolean dwu = bVar.dwu();
        if (this.lbH.IZ(i) != Long.MIN_VALUE) {
            return !dwu && j == Long.MIN_VALUE;
        }
        int Jc = this.lbH.Jc(i);
        if (Jc == -1) {
            return false;
        }
        if ((dwu && bVar.msf == i && bVar.msh == Jc + (-1)) || (!dwu && this.lbH.Ja(i) == Jc)) {
            z = true;
        }
        return z;
    }

    private boolean a(l.b bVar, boolean z) {
        return !this.timeline.a(this.timeline.a(bVar.periodIndex, this.lbH).windowIndex, this.lbG).isDynamic && this.timeline.b(bVar.periodIndex, this.lbH, this.lbG, this.dU, this.lYD) && z;
    }
}
