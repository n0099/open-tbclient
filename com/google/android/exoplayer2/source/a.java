package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
abstract class a extends x {
    private final int mqN;
    private final r mqO;

    protected abstract x KA(int i);

    protected abstract int KB(int i);

    protected abstract int KC(int i);

    protected abstract Object KD(int i);

    protected abstract int Ky(int i);

    protected abstract int Kz(int i);

    protected abstract int by(Object obj);

    public a(r rVar) {
        this.mqO = rVar;
        this.mqN = rVar.bTb();
    }

    @Override // com.google.android.exoplayer2.x
    public int p(int i, int i2, boolean z) {
        int Kz = Kz(i);
        int KC = KC(Kz);
        int p = KA(Kz).p(i - KC, i2 == 2 ? 0 : i2, z);
        if (p != -1) {
            return p + KC;
        }
        int ab = ab(Kz, z);
        while (ab != -1 && KA(ab).isEmpty()) {
            ab = ab(ab, z);
        }
        if (ab != -1) {
            return KA(ab).vE(z) + KC(ab);
        } else if (i2 == 2) {
            return vE(z);
        } else {
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.x
    public int q(int i, int i2, boolean z) {
        int Kz = Kz(i);
        int KC = KC(Kz);
        int q = KA(Kz).q(i - KC, i2 == 2 ? 0 : i2, z);
        if (q != -1) {
            return q + KC;
        }
        int ac = ac(Kz, z);
        while (ac != -1 && KA(ac).isEmpty()) {
            ac = ac(ac, z);
        }
        if (ac != -1) {
            return KA(ac).vD(z) + KC(ac);
        } else if (i2 == 2) {
            return vD(z);
        } else {
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.x
    public int vD(boolean z) {
        if (this.mqN == 0) {
            return -1;
        }
        int dwI = z ? this.mqO.dwI() : this.mqN - 1;
        while (KA(dwI).isEmpty()) {
            dwI = ac(dwI, z);
            if (dwI == -1) {
                return -1;
            }
        }
        return KA(dwI).vD(z) + KC(dwI);
    }

    @Override // com.google.android.exoplayer2.x
    public int vE(boolean z) {
        if (this.mqN == 0) {
            return -1;
        }
        int dwJ = z ? this.mqO.dwJ() : 0;
        while (KA(dwJ).isEmpty()) {
            dwJ = ab(dwJ, z);
            if (dwJ == -1) {
                return -1;
            }
        }
        return KA(dwJ).vE(z) + KC(dwJ);
    }

    @Override // com.google.android.exoplayer2.x
    public final x.b a(int i, x.b bVar, boolean z, long j) {
        int Kz = Kz(i);
        int KC = KC(Kz);
        int KB = KB(Kz);
        KA(Kz).a(i - KC, bVar, z, j);
        bVar.maF += KB;
        bVar.maG += KB;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.x
    public final x.a a(int i, x.a aVar, boolean z) {
        int Ky = Ky(i);
        int KC = KC(Ky);
        KA(Ky).a(i - KB(Ky), aVar, z);
        aVar.windowIndex = KC + aVar.windowIndex;
        if (z) {
            aVar.lZu = Pair.create(KD(Ky), aVar.lZu);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.x
    public final int bw(Object obj) {
        int bw;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int by = by(obj2);
            if (by == -1 || (bw = KA(by).bw(obj3)) == -1) {
                return -1;
            }
            return KB(by) + bw;
        }
        return -1;
    }

    private int ab(int i, boolean z) {
        if (z) {
            return this.mqO.KO(i);
        }
        if (i < this.mqN - 1) {
            return i + 1;
        }
        return -1;
    }

    private int ac(int i, boolean z) {
        if (z) {
            return this.mqO.KP(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }
}
