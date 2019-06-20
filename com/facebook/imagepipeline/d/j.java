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
    private static j kag = null;
    private g jTR;
    private com.facebook.imagepipeline.c.e jYI;
    private com.facebook.imagepipeline.decoder.b jZF;
    private com.facebook.imagepipeline.b.f jZJ;
    private m jZo;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jZr;
    private t<com.facebook.cache.common.b, PooledByteBuffer> jZs;
    private com.facebook.imagepipeline.c.e jZt;
    private final ar jZu;
    private final h kah;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kai;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> kaj;
    private com.facebook.cache.disk.h kak;
    private l kal;
    private com.facebook.cache.disk.h kam;
    private r kan;
    private com.facebook.imagepipeline.h.e kao;
    private com.facebook.imagepipeline.a.a.b kap;

    public static j cFJ() {
        return (j) com.facebook.common.internal.g.checkNotNull(kag, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eD(context).cFx());
    }

    public static void a(h hVar) {
        kag = new j(hVar);
    }

    public j(h hVar) {
        this.kah = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.jZu = new ar(hVar.cFi().cEZ());
    }

    public com.facebook.imagepipeline.a.a.b cFK() {
        if (this.kap == null) {
            this.kap = com.facebook.imagepipeline.a.a.c.a(cFQ(), this.kah.cFi());
        }
        return this.kap;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cFL() {
        if (this.kai == null) {
            this.kai = com.facebook.imagepipeline.c.a.a(this.kah.cFd(), this.kah.cFn(), cFQ(), this.kah.cFv().cFz());
        }
        return this.kai;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cFb() {
        if (this.jZr == null) {
            this.jZr = com.facebook.imagepipeline.c.b.a(cFL(), this.kah.cFj());
        }
        return this.jZr;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cFM() {
        if (this.kaj == null) {
            this.kaj = com.facebook.imagepipeline.c.m.a(this.kah.cFh(), this.kah.cFn(), cFQ());
        }
        return this.kaj;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cFN() {
        if (this.jZs == null) {
            this.jZs = n.a(cFM(), this.kah.cFj());
        }
        return this.jZs;
    }

    private com.facebook.imagepipeline.decoder.b cFk() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.jZF == null) {
            if (this.kah.cFk() != null) {
                this.jZF = this.kah.cFk();
            } else {
                if (cFK() != null) {
                    dVar = cFK().cEe();
                } else {
                    dVar = null;
                }
                if (this.kah.cFu() == null) {
                    this.jZF = new com.facebook.imagepipeline.decoder.a(dVar, cFR(), this.kah.cEN());
                } else {
                    this.jZF = new com.facebook.imagepipeline.decoder.a(dVar, cFR(), this.kah.cEN(), this.kah.cFu().cGu());
                    com.facebook.c.d.cEd().eD(this.kah.cFu().cGv());
                }
            }
        }
        return this.jZF;
    }

    private com.facebook.imagepipeline.c.e cFO() {
        if (this.jZt == null) {
            this.jZt = new com.facebook.imagepipeline.c.e(cFP(), this.kah.cFp().cHs(), this.kah.cFp().cHt(), this.kah.cFi().cEV(), this.kah.cFi().cEW(), this.kah.cFj());
        }
        return this.jZt;
    }

    public com.facebook.cache.disk.h cFP() {
        if (this.kak == null) {
            this.kak = this.kah.cFf().a(this.kah.cFm());
        }
        return this.kak;
    }

    public g cCv() {
        if (this.jTR == null) {
            this.jTR = new g(cFT(), this.kah.cFr(), this.kah.cFl(), cFb(), cFN(), cFO(), cFV(), this.kah.cFc(), this.jZu, com.facebook.common.internal.j.aD(false));
        }
        return this.jTR;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.cHo());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.cHs()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cFQ() {
        if (this.jZJ == null) {
            this.jZJ = a(this.kah.cFp(), cFR());
        }
        return this.jZJ;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int cHq = qVar.cHq();
            return new com.facebook.imagepipeline.h.a(qVar.cHo(), cHq, new Pools.SynchronizedPool(cHq));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.cHp());
        }
    }

    public com.facebook.imagepipeline.h.e cFR() {
        if (this.kao == null) {
            this.kao = a(this.kah.cFp(), this.kah.cFv().cFE());
        }
        return this.kao;
    }

    private l cFS() {
        if (this.kal == null) {
            this.kal = new l(this.kah.getContext(), this.kah.cFp().cHu(), cFk(), this.kah.cFq(), this.kah.cFg(), this.kah.cFs(), this.kah.cFv().cFF(), this.kah.cFi(), this.kah.cFp().cHs(), cFb(), cFN(), cFO(), cFV(), cFW(), this.kah.cFv().cFC(), this.kah.cFc(), cFQ(), this.kah.cFv().cFA());
        }
        return this.kal;
    }

    private m cFT() {
        if (this.jZo == null) {
            this.jZo = new m(cFS(), this.kah.cFo(), this.kah.cFs(), this.kah.cFv().cFE(), this.jZu, this.kah.cFv().cFD());
        }
        return this.jZo;
    }

    public com.facebook.cache.disk.h cFU() {
        if (this.kam == null) {
            this.kam = this.kah.cFf().a(this.kah.cFt());
        }
        return this.kam;
    }

    private com.facebook.imagepipeline.c.e cFV() {
        if (this.jYI == null) {
            this.jYI = new com.facebook.imagepipeline.c.e(cFU(), this.kah.cFp().cHs(), this.kah.cFp().cHt(), this.kah.cFi().cEV(), this.kah.cFi().cEW(), this.kah.cFj());
        }
        return this.jYI;
    }

    public r cFW() {
        if (this.kan == null) {
            this.kan = this.kah.cFv().cFB() ? new s(this.kah.getContext(), this.kah.cFi().cEV(), this.kah.cFi().cEW()) : new y();
        }
        return this.kan;
    }
}
