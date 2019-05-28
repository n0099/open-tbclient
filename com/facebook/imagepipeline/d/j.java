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
    private static j kad = null;
    private g jTO;
    private com.facebook.imagepipeline.c.e jYF;
    private com.facebook.imagepipeline.decoder.b jZC;
    private com.facebook.imagepipeline.b.f jZG;
    private m jZl;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jZo;
    private t<com.facebook.cache.common.b, PooledByteBuffer> jZp;
    private com.facebook.imagepipeline.c.e jZq;
    private final ar jZr;
    private final h kae;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kaf;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> kag;
    private com.facebook.cache.disk.h kah;
    private l kai;
    private com.facebook.cache.disk.h kaj;
    private r kak;
    private com.facebook.imagepipeline.h.e kal;
    private com.facebook.imagepipeline.a.a.b kam;

    public static j cFK() {
        return (j) com.facebook.common.internal.g.checkNotNull(kad, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eD(context).cFy());
    }

    public static void a(h hVar) {
        kad = new j(hVar);
    }

    public j(h hVar) {
        this.kae = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.jZr = new ar(hVar.cFj().cFa());
    }

    public com.facebook.imagepipeline.a.a.b cFL() {
        if (this.kam == null) {
            this.kam = com.facebook.imagepipeline.a.a.c.a(cFR(), this.kae.cFj());
        }
        return this.kam;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cFM() {
        if (this.kaf == null) {
            this.kaf = com.facebook.imagepipeline.c.a.a(this.kae.cFe(), this.kae.cFo(), cFR(), this.kae.cFw().cFA());
        }
        return this.kaf;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cFc() {
        if (this.jZo == null) {
            this.jZo = com.facebook.imagepipeline.c.b.a(cFM(), this.kae.cFk());
        }
        return this.jZo;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cFN() {
        if (this.kag == null) {
            this.kag = com.facebook.imagepipeline.c.m.a(this.kae.cFi(), this.kae.cFo(), cFR());
        }
        return this.kag;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cFO() {
        if (this.jZp == null) {
            this.jZp = n.a(cFN(), this.kae.cFk());
        }
        return this.jZp;
    }

    private com.facebook.imagepipeline.decoder.b cFl() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.jZC == null) {
            if (this.kae.cFl() != null) {
                this.jZC = this.kae.cFl();
            } else {
                if (cFL() != null) {
                    dVar = cFL().cEf();
                } else {
                    dVar = null;
                }
                if (this.kae.cFv() == null) {
                    this.jZC = new com.facebook.imagepipeline.decoder.a(dVar, cFS(), this.kae.cEO());
                } else {
                    this.jZC = new com.facebook.imagepipeline.decoder.a(dVar, cFS(), this.kae.cEO(), this.kae.cFv().cGv());
                    com.facebook.c.d.cEe().eD(this.kae.cFv().cGw());
                }
            }
        }
        return this.jZC;
    }

    private com.facebook.imagepipeline.c.e cFP() {
        if (this.jZq == null) {
            this.jZq = new com.facebook.imagepipeline.c.e(cFQ(), this.kae.cFq().cHt(), this.kae.cFq().cHu(), this.kae.cFj().cEW(), this.kae.cFj().cEX(), this.kae.cFk());
        }
        return this.jZq;
    }

    public com.facebook.cache.disk.h cFQ() {
        if (this.kah == null) {
            this.kah = this.kae.cFg().a(this.kae.cFn());
        }
        return this.kah;
    }

    public g cCw() {
        if (this.jTO == null) {
            this.jTO = new g(cFU(), this.kae.cFs(), this.kae.cFm(), cFc(), cFO(), cFP(), cFW(), this.kae.cFd(), this.jZr, com.facebook.common.internal.j.aD(false));
        }
        return this.jTO;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.cHp());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.cHt()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cFR() {
        if (this.jZG == null) {
            this.jZG = a(this.kae.cFq(), cFS());
        }
        return this.jZG;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int cHr = qVar.cHr();
            return new com.facebook.imagepipeline.h.a(qVar.cHp(), cHr, new Pools.SynchronizedPool(cHr));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.cHq());
        }
    }

    public com.facebook.imagepipeline.h.e cFS() {
        if (this.kal == null) {
            this.kal = a(this.kae.cFq(), this.kae.cFw().cFF());
        }
        return this.kal;
    }

    private l cFT() {
        if (this.kai == null) {
            this.kai = new l(this.kae.getContext(), this.kae.cFq().cHv(), cFl(), this.kae.cFr(), this.kae.cFh(), this.kae.cFt(), this.kae.cFw().cFG(), this.kae.cFj(), this.kae.cFq().cHt(), cFc(), cFO(), cFP(), cFW(), cFX(), this.kae.cFw().cFD(), this.kae.cFd(), cFR(), this.kae.cFw().cFB());
        }
        return this.kai;
    }

    private m cFU() {
        if (this.jZl == null) {
            this.jZl = new m(cFT(), this.kae.cFp(), this.kae.cFt(), this.kae.cFw().cFF(), this.jZr, this.kae.cFw().cFE());
        }
        return this.jZl;
    }

    public com.facebook.cache.disk.h cFV() {
        if (this.kaj == null) {
            this.kaj = this.kae.cFg().a(this.kae.cFu());
        }
        return this.kaj;
    }

    private com.facebook.imagepipeline.c.e cFW() {
        if (this.jYF == null) {
            this.jYF = new com.facebook.imagepipeline.c.e(cFV(), this.kae.cFq().cHt(), this.kae.cFq().cHu(), this.kae.cFj().cEW(), this.kae.cFj().cEX(), this.kae.cFk());
        }
        return this.jYF;
    }

    public r cFX() {
        if (this.kak == null) {
            this.kak = this.kae.cFw().cFC() ? new s(this.kae.getContext(), this.kae.cFj().cEW(), this.kae.cFj().cEX()) : new y();
        }
        return this.kak;
    }
}
