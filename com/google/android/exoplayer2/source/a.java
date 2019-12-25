package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.x;
/* loaded from: classes4.dex */
abstract class a extends x {
    private final int mma;
    private final r mmb;

    protected abstract int Kk(int i);

    protected abstract int Kl(int i);

    protected abstract x Km(int i);

    protected abstract int Kn(int i);

    protected abstract int Ko(int i);

    protected abstract Object Kp(int i);

    protected abstract int bv(Object obj);

    public a(r rVar) {
        this.mmb = rVar;
        this.mma = rVar.bQo();
    }

    @Override // com.google.android.exoplayer2.x
    public int p(int i, int i2, boolean z) {
        int Kl = Kl(i);
        int Ko = Ko(Kl);
        int p = Km(Kl).p(i - Ko, i2 == 2 ? 0 : i2, z);
        if (p != -1) {
            return p + Ko;
        }
        int ac = ac(Kl, z);
        while (ac != -1 && Km(ac).isEmpty()) {
            ac = ac(ac, z);
        }
        if (ac != -1) {
            return Km(ac).vo(z) + Ko(ac);
        } else if (i2 == 2) {
            return vo(z);
        } else {
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.x
    public int q(int i, int i2, boolean z) {
        int Kl = Kl(i);
        int Ko = Ko(Kl);
        int q = Km(Kl).q(i - Ko, i2 == 2 ? 0 : i2, z);
        if (q != -1) {
            return q + Ko;
        }
        int ad = ad(Kl, z);
        while (ad != -1 && Km(ad).isEmpty()) {
            ad = ad(ad, z);
        }
        if (ad != -1) {
            return Km(ad).vn(z) + Ko(ad);
        } else if (i2 == 2) {
            return vn(z);
        } else {
            return -1;
        }
    }

    @Override // com.google.android.exoplayer2.x
    public int vn(boolean z) {
        if (this.mma == 0) {
            return -1;
        }
        int dui = z ? this.mmb.dui() : this.mma - 1;
        while (Km(dui).isEmpty()) {
            dui = ad(dui, z);
            if (dui == -1) {
                return -1;
            }
        }
        return Km(dui).vn(z) + Ko(dui);
    }

    @Override // com.google.android.exoplayer2.x
    public int vo(boolean z) {
        if (this.mma == 0) {
            return -1;
        }
        int duj = z ? this.mmb.duj() : 0;
        while (Km(duj).isEmpty()) {
            duj = ac(duj, z);
            if (duj == -1) {
                return -1;
            }
        }
        return Km(duj).vo(z) + Ko(duj);
    }

    @Override // com.google.android.exoplayer2.x
    public final x.b a(int i, x.b bVar, boolean z, long j) {
        int Kl = Kl(i);
        int Ko = Ko(Kl);
        int Kn = Kn(Kl);
        Km(Kl).a(i - Ko, bVar, z, j);
        bVar.lVP += Kn;
        bVar.lVQ += Kn;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.x
    public final x.a a(int i, x.a aVar, boolean z) {
        int Kk = Kk(i);
        int Ko = Ko(Kk);
        Km(Kk).a(i - Kn(Kk), aVar, z);
        aVar.windowIndex = Ko + aVar.windowIndex;
        if (z) {
            aVar.lUF = Pair.create(Kp(Kk), aVar.lUF);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.x
    public final int bt(Object obj) {
        int bt;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int bv = bv(obj2);
            if (bv == -1 || (bt = Km(bv).bt(obj3)) == -1) {
                return -1;
            }
            return Kn(bv) + bt;
        }
        return -1;
    }

    private int ac(int i, boolean z) {
        if (z) {
            return this.mmb.KA(i);
        }
        if (i < this.mma - 1) {
            return i + 1;
        }
        return -1;
    }

    private int ad(int i, boolean z) {
        if (z) {
            return this.mmb.KB(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }
}
