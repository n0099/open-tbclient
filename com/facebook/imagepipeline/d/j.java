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
    private static j kit = null;
    private g kcb;
    private com.facebook.imagepipeline.c.e kgU;
    private m khA;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> khD;
    private t<com.facebook.cache.common.b, PooledByteBuffer> khE;
    private com.facebook.imagepipeline.c.e khF;
    private final ar khG;
    private com.facebook.imagepipeline.decoder.b khR;
    private com.facebook.imagepipeline.b.f khV;
    private r kiA;
    private com.facebook.imagepipeline.h.e kiB;
    private com.facebook.imagepipeline.a.a.b kiC;
    private final h kiu;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kiv;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> kiw;
    private com.facebook.cache.disk.h kix;
    private l kiy;
    private com.facebook.cache.disk.h kiz;

    public static j cJh() {
        return (j) com.facebook.common.internal.g.checkNotNull(kit, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eF(context).cIV());
    }

    public static void a(h hVar) {
        kit = new j(hVar);
    }

    public j(h hVar) {
        this.kiu = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.khG = new ar(hVar.cIG().cIx());
    }

    public com.facebook.imagepipeline.a.a.b cJi() {
        if (this.kiC == null) {
            this.kiC = com.facebook.imagepipeline.a.a.c.a(cJo(), this.kiu.cIG());
        }
        return this.kiC;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cJj() {
        if (this.kiv == null) {
            this.kiv = com.facebook.imagepipeline.c.a.a(this.kiu.cIB(), this.kiu.cIL(), cJo(), this.kiu.cIT().cIX());
        }
        return this.kiv;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cIz() {
        if (this.khD == null) {
            this.khD = com.facebook.imagepipeline.c.b.a(cJj(), this.kiu.cIH());
        }
        return this.khD;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cJk() {
        if (this.kiw == null) {
            this.kiw = com.facebook.imagepipeline.c.m.a(this.kiu.cIF(), this.kiu.cIL(), cJo());
        }
        return this.kiw;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cJl() {
        if (this.khE == null) {
            this.khE = n.a(cJk(), this.kiu.cIH());
        }
        return this.khE;
    }

    private com.facebook.imagepipeline.decoder.b cII() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.khR == null) {
            if (this.kiu.cII() != null) {
                this.khR = this.kiu.cII();
            } else {
                if (cJi() != null) {
                    dVar = cJi().cHC();
                } else {
                    dVar = null;
                }
                if (this.kiu.cIS() == null) {
                    this.khR = new com.facebook.imagepipeline.decoder.a(dVar, cJp(), this.kiu.cIl());
                } else {
                    this.khR = new com.facebook.imagepipeline.decoder.a(dVar, cJp(), this.kiu.cIl(), this.kiu.cIS().cJS());
                    com.facebook.c.d.cHB().eF(this.kiu.cIS().cJT());
                }
            }
        }
        return this.khR;
    }

    private com.facebook.imagepipeline.c.e cJm() {
        if (this.khF == null) {
            this.khF = new com.facebook.imagepipeline.c.e(cJn(), this.kiu.cIN().cKR(), this.kiu.cIN().cKS(), this.kiu.cIG().cIt(), this.kiu.cIG().cIu(), this.kiu.cIH());
        }
        return this.khF;
    }

    public com.facebook.cache.disk.h cJn() {
        if (this.kix == null) {
            this.kix = this.kiu.cID().a(this.kiu.cIK());
        }
        return this.kix;
    }

    public g cFR() {
        if (this.kcb == null) {
            this.kcb = new g(cJr(), this.kiu.cIP(), this.kiu.cIJ(), cIz(), cJl(), cJm(), cJt(), this.kiu.cIA(), this.khG, com.facebook.common.internal.j.aD(false));
        }
        return this.kcb;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.cKN());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.cKR()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cJo() {
        if (this.khV == null) {
            this.khV = a(this.kiu.cIN(), cJp());
        }
        return this.khV;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int cKP = qVar.cKP();
            return new com.facebook.imagepipeline.h.a(qVar.cKN(), cKP, new Pools.SynchronizedPool(cKP));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.cKO());
        }
    }

    public com.facebook.imagepipeline.h.e cJp() {
        if (this.kiB == null) {
            this.kiB = a(this.kiu.cIN(), this.kiu.cIT().cJc());
        }
        return this.kiB;
    }

    private l cJq() {
        if (this.kiy == null) {
            this.kiy = new l(this.kiu.getContext(), this.kiu.cIN().cKT(), cII(), this.kiu.cIO(), this.kiu.cIE(), this.kiu.cIQ(), this.kiu.cIT().cJd(), this.kiu.cIG(), this.kiu.cIN().cKR(), cIz(), cJl(), cJm(), cJt(), cJu(), this.kiu.cIT().cJa(), this.kiu.cIA(), cJo(), this.kiu.cIT().cIY());
        }
        return this.kiy;
    }

    private m cJr() {
        if (this.khA == null) {
            this.khA = new m(cJq(), this.kiu.cIM(), this.kiu.cIQ(), this.kiu.cIT().cJc(), this.khG, this.kiu.cIT().cJb());
        }
        return this.khA;
    }

    public com.facebook.cache.disk.h cJs() {
        if (this.kiz == null) {
            this.kiz = this.kiu.cID().a(this.kiu.cIR());
        }
        return this.kiz;
    }

    private com.facebook.imagepipeline.c.e cJt() {
        if (this.kgU == null) {
            this.kgU = new com.facebook.imagepipeline.c.e(cJs(), this.kiu.cIN().cKR(), this.kiu.cIN().cKS(), this.kiu.cIG().cIt(), this.kiu.cIG().cIu(), this.kiu.cIH());
        }
        return this.kgU;
    }

    public r cJu() {
        if (this.kiA == null) {
            this.kiA = this.kiu.cIT().cIZ() ? new s(this.kiu.getContext(), this.kiu.cIG().cIt(), this.kiu.cIG().cIu()) : new y();
        }
        return this.kiA;
    }
}
