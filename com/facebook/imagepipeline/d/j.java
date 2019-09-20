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
    private static j kkQ = null;
    private g kez;
    private m kjY;
    private com.facebook.imagepipeline.c.e kjs;
    private final h kkR;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kkS;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> kkT;
    private com.facebook.cache.disk.h kkU;
    private l kkV;
    private com.facebook.cache.disk.h kkW;
    private r kkX;
    private com.facebook.imagepipeline.h.e kkY;
    private com.facebook.imagepipeline.a.a.b kkZ;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kkb;
    private t<com.facebook.cache.common.b, PooledByteBuffer> kkc;
    private com.facebook.imagepipeline.c.e kkd;
    private final ar kke;
    private com.facebook.imagepipeline.decoder.b kkp;
    private com.facebook.imagepipeline.b.f kkt;

    public static j cJV() {
        return (j) com.facebook.common.internal.g.checkNotNull(kkQ, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eG(context).cJJ());
    }

    public static void a(h hVar) {
        kkQ = new j(hVar);
    }

    public j(h hVar) {
        this.kkR = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.kke = new ar(hVar.cJu().cJl());
    }

    public com.facebook.imagepipeline.a.a.b cJW() {
        if (this.kkZ == null) {
            this.kkZ = com.facebook.imagepipeline.a.a.c.a(cKc(), this.kkR.cJu());
        }
        return this.kkZ;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cJX() {
        if (this.kkS == null) {
            this.kkS = com.facebook.imagepipeline.c.a.a(this.kkR.cJp(), this.kkR.cJz(), cKc(), this.kkR.cJH().cJL());
        }
        return this.kkS;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cJn() {
        if (this.kkb == null) {
            this.kkb = com.facebook.imagepipeline.c.b.a(cJX(), this.kkR.cJv());
        }
        return this.kkb;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cJY() {
        if (this.kkT == null) {
            this.kkT = com.facebook.imagepipeline.c.m.a(this.kkR.cJt(), this.kkR.cJz(), cKc());
        }
        return this.kkT;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cJZ() {
        if (this.kkc == null) {
            this.kkc = n.a(cJY(), this.kkR.cJv());
        }
        return this.kkc;
    }

    private com.facebook.imagepipeline.decoder.b cJw() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.kkp == null) {
            if (this.kkR.cJw() != null) {
                this.kkp = this.kkR.cJw();
            } else {
                if (cJW() != null) {
                    dVar = cJW().cIq();
                } else {
                    dVar = null;
                }
                if (this.kkR.cJG() == null) {
                    this.kkp = new com.facebook.imagepipeline.decoder.a(dVar, cKd(), this.kkR.cIZ());
                } else {
                    this.kkp = new com.facebook.imagepipeline.decoder.a(dVar, cKd(), this.kkR.cIZ(), this.kkR.cJG().cKG());
                    com.facebook.c.d.cIp().eF(this.kkR.cJG().cKH());
                }
            }
        }
        return this.kkp;
    }

    private com.facebook.imagepipeline.c.e cKa() {
        if (this.kkd == null) {
            this.kkd = new com.facebook.imagepipeline.c.e(cKb(), this.kkR.cJB().cLF(), this.kkR.cJB().cLG(), this.kkR.cJu().cJh(), this.kkR.cJu().cJi(), this.kkR.cJv());
        }
        return this.kkd;
    }

    public com.facebook.cache.disk.h cKb() {
        if (this.kkU == null) {
            this.kkU = this.kkR.cJr().a(this.kkR.cJy());
        }
        return this.kkU;
    }

    public g cGF() {
        if (this.kez == null) {
            this.kez = new g(cKf(), this.kkR.cJD(), this.kkR.cJx(), cJn(), cJZ(), cKa(), cKh(), this.kkR.cJo(), this.kke, com.facebook.common.internal.j.aD(false));
        }
        return this.kez;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.cLB());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.cLF()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cKc() {
        if (this.kkt == null) {
            this.kkt = a(this.kkR.cJB(), cKd());
        }
        return this.kkt;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int cLD = qVar.cLD();
            return new com.facebook.imagepipeline.h.a(qVar.cLB(), cLD, new Pools.SynchronizedPool(cLD));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.cLC());
        }
    }

    public com.facebook.imagepipeline.h.e cKd() {
        if (this.kkY == null) {
            this.kkY = a(this.kkR.cJB(), this.kkR.cJH().cJQ());
        }
        return this.kkY;
    }

    private l cKe() {
        if (this.kkV == null) {
            this.kkV = new l(this.kkR.getContext(), this.kkR.cJB().cLH(), cJw(), this.kkR.cJC(), this.kkR.cJs(), this.kkR.cJE(), this.kkR.cJH().cJR(), this.kkR.cJu(), this.kkR.cJB().cLF(), cJn(), cJZ(), cKa(), cKh(), cKi(), this.kkR.cJH().cJO(), this.kkR.cJo(), cKc(), this.kkR.cJH().cJM());
        }
        return this.kkV;
    }

    private m cKf() {
        if (this.kjY == null) {
            this.kjY = new m(cKe(), this.kkR.cJA(), this.kkR.cJE(), this.kkR.cJH().cJQ(), this.kke, this.kkR.cJH().cJP());
        }
        return this.kjY;
    }

    public com.facebook.cache.disk.h cKg() {
        if (this.kkW == null) {
            this.kkW = this.kkR.cJr().a(this.kkR.cJF());
        }
        return this.kkW;
    }

    private com.facebook.imagepipeline.c.e cKh() {
        if (this.kjs == null) {
            this.kjs = new com.facebook.imagepipeline.c.e(cKg(), this.kkR.cJB().cLF(), this.kkR.cJB().cLG(), this.kkR.cJu().cJh(), this.kkR.cJu().cJi(), this.kkR.cJv());
        }
        return this.kjs;
    }

    public r cKi() {
        if (this.kkX == null) {
            this.kkX = this.kkR.cJH().cJN() ? new s(this.kkR.getContext(), this.kkR.cJu().cJh(), this.kkR.cJu().cJi()) : new y();
        }
        return this.kkX;
    }
}
