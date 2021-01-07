package com.facebook.imagepipeline.c;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.o;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.at;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
public class j {
    private m pCA;
    private com.facebook.imagepipeline.b.e pCF;
    private com.facebook.imagepipeline.b.e pCG;
    private final at pCI;
    private com.facebook.imagepipeline.decoder.b pCU;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pDA;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> pDB;
    private o<com.facebook.cache.common.b, PooledByteBuffer> pDC;
    private com.facebook.cache.disk.h pDD;
    private l pDE;
    private com.facebook.cache.disk.h pDF;
    private com.facebook.imagepipeline.h.e pDG;
    private com.facebook.imagepipeline.animated.a.a pDH;
    private final h pDy;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pDz;
    private g puQ;
    private com.facebook.imagepipeline.a.f pza;
    private static final Class<?> prR = j.class;
    private static j pDx = null;

    public static j eyK() {
        return (j) com.facebook.common.internal.g.checkNotNull(pDx, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.il(context).eyv());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (pDx != null) {
                com.facebook.common.c.a.h(prR, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            pDx = new j(hVar);
        }
    }

    public j(h hVar) {
        this.pDy = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.pCI = new at(hVar.eyh().exW());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a eyL() {
        if (this.pDH == null) {
            this.pDH = com.facebook.imagepipeline.animated.a.b.a(eyS(), this.pDy.eyh(), eyM());
        }
        return this.pDH;
    }

    @Nullable
    public com.facebook.imagepipeline.e.a ij(Context context) {
        com.facebook.imagepipeline.animated.a.a eyL = eyL();
        if (eyL == null) {
            return null;
        }
        return eyL.ij(context);
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> eyM() {
        if (this.pDz == null) {
            this.pDz = com.facebook.imagepipeline.b.a.a(this.pDy.eya(), this.pDy.eym(), this.pDy.eyb());
        }
        return this.pDz;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> eyN() {
        if (this.pDA == null) {
            this.pDA = com.facebook.imagepipeline.b.b.a(eyM(), this.pDy.eyi());
        }
        return this.pDA;
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> eyO() {
        if (this.pDB == null) {
            this.pDB = com.facebook.imagepipeline.b.l.a(this.pDy.eyg(), this.pDy.eym());
        }
        return this.pDB;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> eyP() {
        if (this.pDC == null) {
            this.pDC = com.facebook.imagepipeline.b.m.a(eyO(), this.pDy.eyi());
        }
        return this.pDC;
    }

    private com.facebook.imagepipeline.decoder.b eyj() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2;
        if (this.pCU == null) {
            if (this.pDy.eyj() != null) {
                this.pCU = this.pDy.eyj();
            } else {
                com.facebook.imagepipeline.animated.a.a eyL = eyL();
                if (eyL != null) {
                    com.facebook.imagepipeline.decoder.b c = eyL.c(this.pDy.exK());
                    bVar = eyL.d(this.pDy.exK());
                    bVar2 = c;
                } else {
                    bVar = null;
                    bVar2 = null;
                }
                if (this.pDy.eyt() == null) {
                    this.pCU = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, eyT());
                } else {
                    this.pCU = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, eyT(), this.pDy.eyt().ezx());
                    com.facebook.c.d.ewU().gL(this.pDy.eyt().ezy());
                }
            }
        }
        return this.pCU;
    }

    public com.facebook.imagepipeline.b.e eyQ() {
        if (this.pCF == null) {
            this.pCF = new com.facebook.imagepipeline.b.e(eyR(), this.pDy.eyo().eAB(), this.pDy.eyo().eAC(), this.pDy.eyh().exS(), this.pDy.eyh().exT(), this.pDy.eyi());
        }
        return this.pCF;
    }

    public com.facebook.cache.disk.h eyR() {
        if (this.pDD == null) {
            this.pDD = this.pDy.eyd().a(this.pDy.eyl());
        }
        return this.pDD;
    }

    public g euR() {
        if (this.puQ == null) {
            this.puQ = new g(eyV(), this.pDy.eyq(), this.pDy.eyk(), eyN(), eyP(), eyQ(), eyX(), this.pDy.exZ(), this.pCI, com.facebook.common.internal.k.bc(false), this.pDy.eyu().eyI());
        }
        return this.puQ;
    }

    public static com.facebook.imagepipeline.a.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.a.a(qVar.eAx());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.a.e(new com.facebook.imagepipeline.a.b(qVar.eAB()), eVar);
        }
        return new com.facebook.imagepipeline.a.c();
    }

    public com.facebook.imagepipeline.a.f eyS() {
        if (this.pza == null) {
            this.pza = a(this.pDy.eyo(), eyT());
        }
        return this.pza;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int eAz = qVar.eAz();
            return new com.facebook.imagepipeline.h.a(qVar.eAx(), eAz, new Pools.SynchronizedPool(eAz));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.eAy());
        }
    }

    public com.facebook.imagepipeline.h.e eyT() {
        if (this.pDG == null) {
            this.pDG = a(this.pDy.eyo(), this.pDy.eyu().eyy());
        }
        return this.pDG;
    }

    private l eyU() {
        if (this.pDE == null) {
            this.pDE = this.pDy.eyu().eyG().a(this.pDy.getContext(), this.pDy.eyo().eAD(), eyj(), this.pDy.eyp(), this.pDy.eye(), this.pDy.eyr(), this.pDy.eyu().eyz(), this.pDy.eyh(), this.pDy.eyo().eAB(), eyN(), eyP(), eyQ(), eyX(), this.pDy.exZ(), eyS(), this.pDy.eyu().eyD(), this.pDy.eyu().eyE(), this.pDy.eyu().eyH());
        }
        return this.pDE;
    }

    private m eyV() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.pDy.eyu().eyC();
        if (this.pCA == null) {
            this.pCA = new m(this.pDy.getContext().getApplicationContext().getContentResolver(), eyU(), this.pDy.eyn(), this.pDy.eyr(), this.pDy.eyu().eyy(), this.pCI, this.pDy.eyu().eyx(), z, this.pDy.eyu().eyF(), this.pDy.eyf());
        }
        return this.pCA;
    }

    public com.facebook.cache.disk.h eyW() {
        if (this.pDF == null) {
            this.pDF = this.pDy.eyd().a(this.pDy.eys());
        }
        return this.pDF;
    }

    private com.facebook.imagepipeline.b.e eyX() {
        if (this.pCG == null) {
            this.pCG = new com.facebook.imagepipeline.b.e(eyW(), this.pDy.eyo().eAB(), this.pDy.eyo().eAC(), this.pDy.eyh().exS(), this.pDy.eyh().exT(), this.pDy.eyi());
        }
        return this.pCG;
    }
}
