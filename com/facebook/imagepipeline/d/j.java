package com.facebook.imagepipeline.d;

import android.content.Context;
import android.os.Build;
import android.support.v4.util.Pools;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.n;
import com.facebook.imagepipeline.c.r;
import com.facebook.imagepipeline.c.s;
import com.facebook.imagepipeline.c.t;
import com.facebook.imagepipeline.c.y;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.ar;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class j {
    private static j kac = null;
    private g jTN;
    private com.facebook.imagepipeline.c.e jYE;
    private com.facebook.imagepipeline.decoder.b jZB;
    private com.facebook.imagepipeline.b.f jZF;
    private m jZk;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jZn;
    private t<com.facebook.cache.common.b, PooledByteBuffer> jZo;
    private com.facebook.imagepipeline.c.e jZp;
    private final ar jZq;
    private final h kad;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kae;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> kaf;
    private com.facebook.cache.disk.h kag;
    private l kah;
    private com.facebook.cache.disk.h kai;
    private r kaj;
    private com.facebook.imagepipeline.h.e kak;
    private com.facebook.imagepipeline.a.a.b kal;

    public static j cFI() {
        return (j) com.facebook.common.internal.g.checkNotNull(kac, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eD(context).cFw());
    }

    public static void a(h hVar) {
        kac = new j(hVar);
    }

    public j(h hVar) {
        this.kad = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.jZq = new ar(hVar.cFh().cEY());
    }

    public com.facebook.imagepipeline.a.a.b cFJ() {
        if (this.kal == null) {
            this.kal = com.facebook.imagepipeline.a.a.c.a(cFP(), this.kad.cFh());
        }
        return this.kal;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cFK() {
        if (this.kae == null) {
            this.kae = com.facebook.imagepipeline.c.a.a(this.kad.cFc(), this.kad.cFm(), cFP(), this.kad.cFu().cFy());
        }
        return this.kae;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cFa() {
        if (this.jZn == null) {
            this.jZn = com.facebook.imagepipeline.c.b.a(cFK(), this.kad.cFi());
        }
        return this.jZn;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cFL() {
        if (this.kaf == null) {
            this.kaf = com.facebook.imagepipeline.c.m.a(this.kad.cFg(), this.kad.cFm(), cFP());
        }
        return this.kaf;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cFM() {
        if (this.jZo == null) {
            this.jZo = n.a(cFL(), this.kad.cFi());
        }
        return this.jZo;
    }

    private com.facebook.imagepipeline.decoder.b cFj() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.jZB == null) {
            if (this.kad.cFj() != null) {
                this.jZB = this.kad.cFj();
            } else {
                if (cFJ() != null) {
                    dVar = cFJ().cEd();
                } else {
                    dVar = null;
                }
                if (this.kad.cFt() == null) {
                    this.jZB = new com.facebook.imagepipeline.decoder.a(dVar, cFQ(), this.kad.cEM());
                } else {
                    this.jZB = new com.facebook.imagepipeline.decoder.a(dVar, cFQ(), this.kad.cEM(), this.kad.cFt().cGt());
                    com.facebook.c.d.cEc().eD(this.kad.cFt().cGu());
                }
            }
        }
        return this.jZB;
    }

    private com.facebook.imagepipeline.c.e cFN() {
        if (this.jZp == null) {
            this.jZp = new com.facebook.imagepipeline.c.e(cFO(), this.kad.cFo().cHr(), this.kad.cFo().cHs(), this.kad.cFh().cEU(), this.kad.cFh().cEV(), this.kad.cFi());
        }
        return this.jZp;
    }

    public com.facebook.cache.disk.h cFO() {
        if (this.kag == null) {
            this.kag = this.kad.cFe().a(this.kad.cFl());
        }
        return this.kag;
    }

    public g cCu() {
        if (this.jTN == null) {
            this.jTN = new g(cFS(), this.kad.cFq(), this.kad.cFk(), cFa(), cFM(), cFN(), cFU(), this.kad.cFb(), this.jZq, com.facebook.common.internal.j.aD(false));
        }
        return this.jTN;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.cHn());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.cHr()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cFP() {
        if (this.jZF == null) {
            this.jZF = a(this.kad.cFo(), cFQ());
        }
        return this.jZF;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int cHp = qVar.cHp();
            return new com.facebook.imagepipeline.h.a(qVar.cHn(), cHp, new Pools.SynchronizedPool(cHp));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.cHo());
        }
    }

    public com.facebook.imagepipeline.h.e cFQ() {
        if (this.kak == null) {
            this.kak = a(this.kad.cFo(), this.kad.cFu().cFD());
        }
        return this.kak;
    }

    private l cFR() {
        if (this.kah == null) {
            this.kah = new l(this.kad.getContext(), this.kad.cFo().cHt(), cFj(), this.kad.cFp(), this.kad.cFf(), this.kad.cFr(), this.kad.cFu().cFE(), this.kad.cFh(), this.kad.cFo().cHr(), cFa(), cFM(), cFN(), cFU(), cFV(), this.kad.cFu().cFB(), this.kad.cFb(), cFP(), this.kad.cFu().cFz());
        }
        return this.kah;
    }

    private m cFS() {
        if (this.jZk == null) {
            this.jZk = new m(cFR(), this.kad.cFn(), this.kad.cFr(), this.kad.cFu().cFD(), this.jZq, this.kad.cFu().cFC());
        }
        return this.jZk;
    }

    public com.facebook.cache.disk.h cFT() {
        if (this.kai == null) {
            this.kai = this.kad.cFe().a(this.kad.cFs());
        }
        return this.kai;
    }

    private com.facebook.imagepipeline.c.e cFU() {
        if (this.jYE == null) {
            this.jYE = new com.facebook.imagepipeline.c.e(cFT(), this.kad.cFo().cHr(), this.kad.cFo().cHs(), this.kad.cFh().cEU(), this.kad.cFh().cEV(), this.kad.cFi());
        }
        return this.jYE;
    }

    public r cFV() {
        if (this.kaj == null) {
            this.kaj = this.kad.cFu().cFA() ? new s(this.kad.getContext(), this.kad.cFh().cEU(), this.kad.cFh().cEV()) : new y();
        }
        return this.kaj;
    }
}
