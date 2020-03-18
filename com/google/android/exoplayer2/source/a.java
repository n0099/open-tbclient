package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.x;
/* loaded from: classes6.dex */
abstract class a extends x {
    private final int msu;
    private final r msv;

    protected abstract int KE(int i);

    protected abstract int KF(int i);

    protected abstract x KG(int i);

    protected abstract int KH(int i);

    protected abstract int KI(int i);

    protected abstract Object KJ(int i);

    protected abstract int by(Object obj);

    public a(r rVar) {
        this.msv = rVar;
        this.msu = rVar.bTt();
    }

    @Override // com.google.android.exoplayer2.x
    public int p(int i, int i2, boolean z) {
        int KF = KF(i);
        int KI = KI(KF);
        int p = KG(KF).p(i - KI, i2 == 2 ? 0 : i2, z);
        if (p != -1) {
            return p + KI;
        }
        int ab = ab(KF, z);
        while (ab != -1 && KG(ab).isEmpty()) {
            ab = ab(ab, z);
        }
        if (ab != -1) {
            return KG(ab).vL(z) + KI(ab);
        } else if (i2 == 2) {
            return vL(z);
        } else {
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.x
    public int q(int i, int i2, boolean z) {
        int KF = KF(i);
        int KI = KI(KF);
        int q = KG(KF).q(i - KI, i2 == 2 ? 0 : i2, z);
        if (q != -1) {
            return q + KI;
        }
        int ac = ac(KF, z);
        while (ac != -1 && KG(ac).isEmpty()) {
            ac = ac(ac, z);
        }
        if (ac != -1) {
            return KG(ac).vK(z) + KI(ac);
        } else if (i2 == 2) {
            return vK(z);
        } else {
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.x
    public int vK(boolean z) {
        if (this.msu == 0) {
            return -1;
        }
        int dxf = z ? this.msv.dxf() : this.msu - 1;
        while (KG(dxf).isEmpty()) {
            dxf = ac(dxf, z);
            if (dxf == -1) {
                return -1;
            }
        }
        return KG(dxf).vK(z) + KI(dxf);
    }

    @Override // com.google.android.exoplayer2.x
    public int vL(boolean z) {
        if (this.msu == 0) {
            return -1;
        }
        int dxg = z ? this.msv.dxg() : 0;
        while (KG(dxg).isEmpty()) {
            dxg = ab(dxg, z);
            if (dxg == -1) {
                return -1;
            }
        }
        return KG(dxg).vL(z) + KI(dxg);
    }

    @Override // com.google.android.exoplayer2.x
    public final x.b a(int i, x.b bVar, boolean z, long j) {
        int KF = KF(i);
        int KI = KI(KF);
        int KH = KH(KF);
        KG(KF).a(i - KI, bVar, z, j);
        bVar.mcl += KH;
        bVar.mcm += KH;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.x
    public final x.a a(int i, x.a aVar, boolean z) {
        int KE = KE(i);
        int KI = KI(KE);
        KG(KE).a(i - KH(KE), aVar, z);
        aVar.windowIndex = KI + aVar.windowIndex;
        if (z) {
            aVar.mbd = Pair.create(KJ(KE), aVar.mbd);
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
            if (by == -1 || (bw = KG(by).bw(obj3)) == -1) {
                return -1;
            }
            return KH(by) + bw;
        }
        return -1;
    }

    private int ab(int i, boolean z) {
        if (z) {
            return this.msv.KU(i);
        }
        if (i < this.msu - 1) {
            return i + 1;
        }
        return -1;
    }

    private int ac(int i, boolean z) {
        if (z) {
            return this.msv.KV(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }
}
