package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.x;
/* loaded from: classes5.dex */
abstract class a extends x {
    private final int mpP;
    private final r mpQ;

    protected abstract int Kt(int i);

    protected abstract int Ku(int i);

    protected abstract x Kv(int i);

    protected abstract int Kw(int i);

    protected abstract int Kx(int i);

    protected abstract Object Ky(int i);

    protected abstract int bw(Object obj);

    public a(r rVar) {
        this.mpQ = rVar;
        this.mpP = rVar.bRx();
    }

    @Override // com.google.android.exoplayer2.x
    public int p(int i, int i2, boolean z) {
        int Ku = Ku(i);
        int Kx = Kx(Ku);
        int p = Kv(Ku).p(i - Kx, i2 == 2 ? 0 : i2, z);
        if (p != -1) {
            return p + Kx;
        }
        int ac = ac(Ku, z);
        while (ac != -1 && Kv(ac).isEmpty()) {
            ac = ac(ac, z);
        }
        if (ac != -1) {
            return Kv(ac).vA(z) + Kx(ac);
        } else if (i2 == 2) {
            return vA(z);
        } else {
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.x
    public int q(int i, int i2, boolean z) {
        int Ku = Ku(i);
        int Kx = Kx(Ku);
        int q = Kv(Ku).q(i - Kx, i2 == 2 ? 0 : i2, z);
        if (q != -1) {
            return q + Kx;
        }
        int ad = ad(Ku, z);
        while (ad != -1 && Kv(ad).isEmpty()) {
            ad = ad(ad, z);
        }
        if (ad != -1) {
            return Kv(ad).vz(z) + Kx(ad);
        } else if (i2 == 2) {
            return vz(z);
        } else {
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.x
    public int vz(boolean z) {
        if (this.mpP == 0) {
            return -1;
        }
        int dvt = z ? this.mpQ.dvt() : this.mpP - 1;
        while (Kv(dvt).isEmpty()) {
            dvt = ad(dvt, z);
            if (dvt == -1) {
                return -1;
            }
        }
        return Kv(dvt).vz(z) + Kx(dvt);
    }

    @Override // com.google.android.exoplayer2.x
    public int vA(boolean z) {
        if (this.mpP == 0) {
            return -1;
        }
        int dvu = z ? this.mpQ.dvu() : 0;
        while (Kv(dvu).isEmpty()) {
            dvu = ac(dvu, z);
            if (dvu == -1) {
                return -1;
            }
        }
        return Kv(dvu).vA(z) + Kx(dvu);
    }

    @Override // com.google.android.exoplayer2.x
    public final x.b a(int i, x.b bVar, boolean z, long j) {
        int Ku = Ku(i);
        int Kx = Kx(Ku);
        int Kw = Kw(Ku);
        Kv(Ku).a(i - Kx, bVar, z, j);
        bVar.lZE += Kw;
        bVar.lZF += Kw;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.x
    public final x.a a(int i, x.a aVar, boolean z) {
        int Kt = Kt(i);
        int Kx = Kx(Kt);
        Kv(Kt).a(i - Kw(Kt), aVar, z);
        aVar.windowIndex = Kx + aVar.windowIndex;
        if (z) {
            aVar.lYw = Pair.create(Ky(Kt), aVar.lYw);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.x
    public final int bu(Object obj) {
        int bu;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int bw = bw(obj2);
            if (bw == -1 || (bu = Kv(bw).bu(obj3)) == -1) {
                return -1;
            }
            return Kw(bw) + bu;
        }
        return -1;
    }

    private int ac(int i, boolean z) {
        if (z) {
            return this.mpQ.KJ(i);
        }
        if (i < this.mpP - 1) {
            return i + 1;
        }
        return -1;
    }

    private int ad(int i, boolean z) {
        if (z) {
            return this.mpQ.KK(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }
}
