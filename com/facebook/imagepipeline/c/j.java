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
/* loaded from: classes5.dex */
public class j {
    private m pAT;
    private com.facebook.imagepipeline.b.e pAY;
    private com.facebook.imagepipeline.b.e pAZ;
    private final h pBR;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pBS;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pBT;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> pBU;
    private o<com.facebook.cache.common.b, PooledByteBuffer> pBV;
    private com.facebook.cache.disk.h pBW;
    private l pBX;
    private com.facebook.cache.disk.h pBY;
    private com.facebook.imagepipeline.h.e pBZ;
    private final at pBb;
    private com.facebook.imagepipeline.decoder.b pBn;
    private com.facebook.imagepipeline.animated.factory.a pCa;
    private g puJ;
    private com.facebook.imagepipeline.a.f pzp;
    private static final Class<?> prQ = j.class;
    private static j pBQ = null;

    public static j eyi() {
        return (j) com.facebook.common.internal.g.checkNotNull(pBQ, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.il(context).exT());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (pBQ != null) {
                com.facebook.common.c.a.h(prQ, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            pBQ = new j(hVar);
        }
    }

    public j(h hVar) {
        this.pBR = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.pBb = new at(hVar.exF().exu());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.factory.a eyj() {
        if (this.pCa == null) {
            this.pCa = com.facebook.imagepipeline.animated.factory.b.a(eyq(), this.pBR.exF(), eyk());
        }
        return this.pCa;
    }

    @Nullable
    public com.facebook.imagepipeline.e.a ij(Context context) {
        com.facebook.imagepipeline.animated.factory.a eyj = eyj();
        if (eyj == null) {
            return null;
        }
        return eyj.ij(context);
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> eyk() {
        if (this.pBS == null) {
            this.pBS = com.facebook.imagepipeline.b.a.a(this.pBR.exy(), this.pBR.exK(), this.pBR.exz());
        }
        return this.pBS;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> eyl() {
        if (this.pBT == null) {
            this.pBT = com.facebook.imagepipeline.b.b.a(eyk(), this.pBR.exG());
        }
        return this.pBT;
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> eym() {
        if (this.pBU == null) {
            this.pBU = com.facebook.imagepipeline.b.l.a(this.pBR.exE(), this.pBR.exK());
        }
        return this.pBU;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> eyn() {
        if (this.pBV == null) {
            this.pBV = com.facebook.imagepipeline.b.m.a(eym(), this.pBR.exG());
        }
        return this.pBV;
    }

    private com.facebook.imagepipeline.decoder.b exH() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2;
        if (this.pBn == null) {
            if (this.pBR.exH() != null) {
                this.pBn = this.pBR.exH();
            } else {
                com.facebook.imagepipeline.animated.factory.a eyj = eyj();
                if (eyj != null) {
                    com.facebook.imagepipeline.decoder.b c = eyj.c(this.pBR.exi());
                    bVar = eyj.d(this.pBR.exi());
                    bVar2 = c;
                } else {
                    bVar = null;
                    bVar2 = null;
                }
                if (this.pBR.exR() == null) {
                    this.pBn = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, eyr());
                } else {
                    this.pBn = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, eyr(), this.pBR.exR().eyV());
                    com.facebook.c.d.ewz().gL(this.pBR.exR().eyW());
                }
            }
        }
        return this.pBn;
    }

    public com.facebook.imagepipeline.b.e eyo() {
        if (this.pAY == null) {
            this.pAY = new com.facebook.imagepipeline.b.e(eyp(), this.pBR.exM().ezX(), this.pBR.exM().ezY(), this.pBR.exF().exq(), this.pBR.exF().exr(), this.pBR.exG());
        }
        return this.pAY;
    }

    public com.facebook.cache.disk.h eyp() {
        if (this.pBW == null) {
            this.pBW = this.pBR.exB().a(this.pBR.exJ());
        }
        return this.pBW;
    }

    public g euK() {
        if (this.puJ == null) {
            this.puJ = new g(eyt(), this.pBR.exO(), this.pBR.exI(), eyl(), eyn(), eyo(), eyv(), this.pBR.exx(), this.pBb, com.facebook.common.internal.k.bc(false), this.pBR.exS().eyg());
        }
        return this.puJ;
    }

    public static com.facebook.imagepipeline.a.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.a.a(qVar.ezT());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.a.e(new com.facebook.imagepipeline.a.b(qVar.ezX()), eVar);
        }
        return new com.facebook.imagepipeline.a.c();
    }

    public com.facebook.imagepipeline.a.f eyq() {
        if (this.pzp == null) {
            this.pzp = a(this.pBR.exM(), eyr());
        }
        return this.pzp;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int ezV = qVar.ezV();
            return new com.facebook.imagepipeline.h.a(qVar.ezT(), ezV, new Pools.SynchronizedPool(ezV));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.ezU());
        }
    }

    public com.facebook.imagepipeline.h.e eyr() {
        if (this.pBZ == null) {
            this.pBZ = a(this.pBR.exM(), this.pBR.exS().exW());
        }
        return this.pBZ;
    }

    private l eys() {
        if (this.pBX == null) {
            this.pBX = this.pBR.exS().eye().a(this.pBR.getContext(), this.pBR.exM().ezZ(), exH(), this.pBR.exN(), this.pBR.exC(), this.pBR.exP(), this.pBR.exS().exX(), this.pBR.exF(), this.pBR.exM().ezX(), eyl(), eyn(), eyo(), eyv(), this.pBR.exx(), eyq(), this.pBR.exS().eyb(), this.pBR.exS().eyc(), this.pBR.exS().eyf());
        }
        return this.pBX;
    }

    private m eyt() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.pBR.exS().eya();
        if (this.pAT == null) {
            this.pAT = new m(this.pBR.getContext().getApplicationContext().getContentResolver(), eys(), this.pBR.exL(), this.pBR.exP(), this.pBR.exS().exW(), this.pBb, this.pBR.exS().exV(), z, this.pBR.exS().eyd(), this.pBR.exD());
        }
        return this.pAT;
    }

    public com.facebook.cache.disk.h eyu() {
        if (this.pBY == null) {
            this.pBY = this.pBR.exB().a(this.pBR.exQ());
        }
        return this.pBY;
    }

    private com.facebook.imagepipeline.b.e eyv() {
        if (this.pAZ == null) {
            this.pAZ = new com.facebook.imagepipeline.b.e(eyu(), this.pBR.exM().ezX(), this.pBR.exM().ezY(), this.pBR.exF().exq(), this.pBR.exF().exr(), this.pBR.exG());
        }
        return this.pAZ;
    }
}
