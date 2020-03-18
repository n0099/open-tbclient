package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
final class o {
    private int dT;
    private boolean maw;
    private x timeline;
    private final x.a ldy = new x.a();
    private final x.b ldx = new x.b();

    /* loaded from: classes6.dex */
    public static final class a {
        public final l.b mbt;
        public final long mbu;
        public final long mbv;
        public final long mbw;
        public final long mbx;
        public final boolean mby;
        public final boolean mbz;

        private a(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.mbt = bVar;
            this.mbu = j;
            this.mbv = j2;
            this.mbw = j3;
            this.mbx = j4;
            this.mby = z;
            this.mbz = z2;
        }

        public a Jd(int i) {
            return new a(this.mbt.KL(i), this.mbu, this.mbv, this.mbw, this.mbx, this.mby, this.mbz);
        }

        public a fz(long j) {
            return new a(this.mbt, j, this.mbv, this.mbw, this.mbx, this.mby, this.mbz);
        }
    }

    public void a(x xVar) {
        this.timeline = xVar;
    }

    public void setRepeatMode(int i) {
        this.dT = i;
    }

    public void vG(boolean z) {
        this.maw = z;
    }

    public a a(p pVar) {
        return a(pVar.mbA, pVar.mbw, pVar.mbu);
    }

    public a a(a aVar, long j, long j2) {
        long j3;
        if (aVar.mby) {
            int a2 = this.timeline.a(aVar.mbt.periodIndex, this.ldy, this.ldx, this.dT, this.maw);
            if (a2 == -1) {
                return null;
            }
            int i = this.timeline.a(a2, this.ldy).windowIndex;
            if (this.timeline.a(i, this.ldx).mcl == a2) {
                Pair<Integer, Long> a3 = this.timeline.a(this.ldx, this.ldy, i, -9223372036854775807L, Math.max(0L, (aVar.mbx + j) - j2));
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
        l.b bVar = aVar.mbt;
        if (bVar.dwS()) {
            int i2 = bVar.mtY;
            this.timeline.a(bVar.periodIndex, this.ldy);
            int Ji = this.ldy.Ji(i2);
            if (Ji == -1) {
                return null;
            }
            int i3 = bVar.mtZ + 1;
            if (i3 < Ji) {
                if (this.ldy.dH(i2, i3)) {
                    return e(bVar.periodIndex, i2, i3, aVar.mbw);
                }
                return null;
            }
            int fC = this.ldy.fC(aVar.mbw);
            return f(bVar.periodIndex, aVar.mbw, fC == -1 ? Long.MIN_VALUE : this.ldy.Jf(fC));
        } else if (aVar.mbv != Long.MIN_VALUE) {
            int fB = this.ldy.fB(aVar.mbv);
            if (this.ldy.dH(fB, 0)) {
                return e(bVar.periodIndex, fB, 0, aVar.mbv);
            }
            return null;
        } else {
            int due = this.ldy.due();
            if (due == 0 || this.ldy.Jf(due - 1) != Long.MIN_VALUE || this.ldy.Jh(due - 1) || !this.ldy.dH(due - 1, 0)) {
                return null;
            }
            return e(bVar.periodIndex, due - 1, 0, this.ldy.getDurationUs());
        }
    }

    public l.b B(int i, long j) {
        this.timeline.a(i, this.ldy);
        int fB = this.ldy.fB(j);
        if (fB == -1) {
            return new l.b(i);
        }
        return new l.b(i, fB, this.ldy.Jg(fB));
    }

    public a a(a aVar) {
        return a(aVar, aVar.mbt);
    }

    public a a(a aVar, int i) {
        return a(aVar, aVar.mbt.KL(i));
    }

    private a a(a aVar, l.b bVar) {
        long durationUs;
        long j = aVar.mbu;
        long j2 = aVar.mbv;
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.ldy);
        if (bVar.dwS()) {
            durationUs = this.ldy.dI(bVar.mtY, bVar.mtZ);
        } else {
            durationUs = j2 == Long.MIN_VALUE ? this.ldy.getDurationUs() : j2;
        }
        return new a(bVar, j, j2, aVar.mbw, durationUs, b, a2);
    }

    private a a(l.b bVar, long j, long j2) {
        this.timeline.a(bVar.periodIndex, this.ldy);
        if (bVar.dwS()) {
            if (!this.ldy.dH(bVar.mtY, bVar.mtZ)) {
                return null;
            }
            return e(bVar.periodIndex, bVar.mtY, bVar.mtZ, j);
        }
        int fC = this.ldy.fC(j2);
        return f(bVar.periodIndex, j2, fC == -1 ? Long.MIN_VALUE : this.ldy.Jf(fC));
    }

    private a e(int i, int i2, int i3, long j) {
        l.b bVar = new l.b(i, i2, i3);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a2 = a(bVar, b);
        return new a(bVar, i3 == this.ldy.Jg(i2) ? this.ldy.duf() : 0L, Long.MIN_VALUE, j, this.timeline.a(bVar.periodIndex, this.ldy).dI(bVar.mtY, bVar.mtZ), b, a2);
    }

    private a f(int i, long j, long j2) {
        l.b bVar = new l.b(i);
        boolean b = b(bVar, j2);
        boolean a2 = a(bVar, b);
        this.timeline.a(bVar.periodIndex, this.ldy);
        return new a(bVar, j, j2, -9223372036854775807L, j2 == Long.MIN_VALUE ? this.ldy.getDurationUs() : j2, b, a2);
    }

    private boolean b(l.b bVar, long j) {
        boolean z = false;
        int due = this.timeline.a(bVar.periodIndex, this.ldy).due();
        if (due == 0) {
            return true;
        }
        int i = due - 1;
        boolean dwS = bVar.dwS();
        if (this.ldy.Jf(i) != Long.MIN_VALUE) {
            return !dwS && j == Long.MIN_VALUE;
        }
        int Ji = this.ldy.Ji(i);
        if (Ji == -1) {
            return false;
        }
        if ((dwS && bVar.mtY == i && bVar.mtZ == Ji + (-1)) || (!dwS && this.ldy.Jg(i) == Ji)) {
            z = true;
        }
        return z;
    }

    private boolean a(l.b bVar, boolean z) {
        return !this.timeline.a(this.timeline.a(bVar.periodIndex, this.ldy).windowIndex, this.ldx).isDynamic && this.timeline.b(bVar.periodIndex, this.ldy, this.ldx, this.dT, this.maw) && z;
    }
}
