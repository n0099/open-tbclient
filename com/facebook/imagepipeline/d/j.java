package com.facebook.imagepipeline.d;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.o;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.at;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes4.dex */
public class j {
    private static final Class<?> mPx = j.class;
    private static j nbI = null;
    private g mSy;
    private com.facebook.imagepipeline.b.f mWZ;
    private m naL;
    private com.facebook.imagepipeline.c.e naQ;
    private com.facebook.imagepipeline.c.e naR;
    private final at naT;
    private final h nbJ;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nbK;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nbL;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> nbM;
    private o<com.facebook.cache.common.b, PooledByteBuffer> nbN;
    private com.facebook.cache.disk.h nbO;
    private l nbP;
    private com.facebook.cache.disk.h nbQ;
    private com.facebook.imagepipeline.i.e nbR;
    private com.facebook.imagepipeline.animated.a.a nbS;
    private com.facebook.imagepipeline.decoder.b nbf;

    public static j dHo() {
        return (j) com.facebook.common.internal.g.checkNotNull(nbI, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gb(context).dGZ());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (nbI != null) {
                com.facebook.common.c.a.g(mPx, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            nbI = new j(hVar);
        }
    }

    public j(h hVar) {
        this.nbJ = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.naT = new at(hVar.dGL().dGA());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dHp() {
        if (this.nbS == null) {
            this.nbS = com.facebook.imagepipeline.animated.a.b.a(dHw(), this.nbJ.dGL(), dHq());
        }
        return this.nbS;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a fZ(Context context) {
        com.facebook.imagepipeline.animated.a.a dHp = dHp();
        if (dHp == null) {
            return null;
        }
        return dHp.fZ(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dHq() {
        if (this.nbK == null) {
            this.nbK = com.facebook.imagepipeline.c.a.a(this.nbJ.dGE(), this.nbJ.dGQ(), this.nbJ.dGF());
        }
        return this.nbK;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dHr() {
        if (this.nbL == null) {
            this.nbL = com.facebook.imagepipeline.c.b.a(dHq(), this.nbJ.dGM());
        }
        return this.nbL;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dHs() {
        if (this.nbM == null) {
            this.nbM = com.facebook.imagepipeline.c.l.a(this.nbJ.dGK(), this.nbJ.dGQ());
        }
        return this.nbM;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dHt() {
        if (this.nbN == null) {
            this.nbN = com.facebook.imagepipeline.c.m.a(dHs(), this.nbJ.dGM());
        }
        return this.nbN;
    }

    private com.facebook.imagepipeline.decoder.b dGN() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.nbf == null) {
            if (this.nbJ.dGN() != null) {
                this.nbf = this.nbJ.dGN();
            } else {
                com.facebook.imagepipeline.animated.a.a dHp = dHp();
                if (dHp != null) {
                    bVar = dHp.a(this.nbJ.dGn());
                    bVar2 = dHp.b(this.nbJ.dGn());
                } else {
                    bVar = null;
                }
                if (this.nbJ.dGX() == null) {
                    this.nbf = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dHx());
                } else {
                    this.nbf = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dHx(), this.nbJ.dGX().dIb());
                    com.facebook.c.d.dFv().fy(this.nbJ.dGX().dIc());
                }
            }
        }
        return this.nbf;
    }

    public com.facebook.imagepipeline.c.e dHu() {
        if (this.naQ == null) {
            this.naQ = new com.facebook.imagepipeline.c.e(dHv(), this.nbJ.dGS().dJi(), this.nbJ.dGS().dJj(), this.nbJ.dGL().dGw(), this.nbJ.dGL().dGx(), this.nbJ.dGM());
        }
        return this.naQ;
    }

    public com.facebook.cache.disk.h dHv() {
        if (this.nbO == null) {
            this.nbO = this.nbJ.dGH().a(this.nbJ.dGP());
        }
        return this.nbO;
    }

    public g dDo() {
        if (this.mSy == null) {
            this.mSy = new g(dHz(), this.nbJ.dGU(), this.nbJ.dGO(), dHr(), dHt(), dHu(), dHB(), this.nbJ.dGD(), this.naT, com.facebook.common.internal.k.aQ(false), this.nbJ.dGY().dHm());
        }
        return this.mSy;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dJe());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dJi()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dHw() {
        if (this.mWZ == null) {
            this.mWZ = a(this.nbJ.dGS(), dHx());
        }
        return this.mWZ;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dJg = qVar.dJg();
            return new com.facebook.imagepipeline.i.a(qVar.dJe(), dJg, new Pools.SynchronizedPool(dJg));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dJf());
        }
    }

    public com.facebook.imagepipeline.i.e dHx() {
        if (this.nbR == null) {
            this.nbR = a(this.nbJ.dGS(), this.nbJ.dGY().dHc());
        }
        return this.nbR;
    }

    private l dHy() {
        if (this.nbP == null) {
            this.nbP = this.nbJ.dGY().dHk().a(this.nbJ.getContext(), this.nbJ.dGS().dJk(), dGN(), this.nbJ.dGT(), this.nbJ.dGI(), this.nbJ.dGV(), this.nbJ.dGY().dHd(), this.nbJ.dGL(), this.nbJ.dGS().dJi(), dHr(), dHt(), dHu(), dHB(), this.nbJ.dGD(), dHw(), this.nbJ.dGY().dHh(), this.nbJ.dGY().dHi(), this.nbJ.dGY().dHl());
        }
        return this.nbP;
    }

    private m dHz() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.nbJ.dGY().dHg();
        if (this.naL == null) {
            this.naL = new m(this.nbJ.getContext().getApplicationContext().getContentResolver(), dHy(), this.nbJ.dGR(), this.nbJ.dGV(), this.nbJ.dGY().dHc(), this.naT, this.nbJ.dGY().dHb(), z, this.nbJ.dGY().dHj(), this.nbJ.dGJ());
        }
        return this.naL;
    }

    public com.facebook.cache.disk.h dHA() {
        if (this.nbQ == null) {
            this.nbQ = this.nbJ.dGH().a(this.nbJ.dGW());
        }
        return this.nbQ;
    }

    private com.facebook.imagepipeline.c.e dHB() {
        if (this.naR == null) {
            this.naR = new com.facebook.imagepipeline.c.e(dHA(), this.nbJ.dGS().dJi(), this.nbJ.dGS().dJj(), this.nbJ.dGL().dGw(), this.nbJ.dGL().dGx(), this.nbJ.dGM());
        }
        return this.naR;
    }
}
