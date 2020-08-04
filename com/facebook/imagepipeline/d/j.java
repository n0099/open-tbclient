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
    private static final Class<?> mPz = j.class;
    private static j nbK = null;
    private g mSA;
    private com.facebook.imagepipeline.b.f mXb;
    private m naN;
    private com.facebook.imagepipeline.c.e naS;
    private com.facebook.imagepipeline.c.e naT;
    private final at naV;
    private final h nbL;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nbM;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nbN;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> nbO;
    private o<com.facebook.cache.common.b, PooledByteBuffer> nbP;
    private com.facebook.cache.disk.h nbQ;
    private l nbR;
    private com.facebook.cache.disk.h nbS;
    private com.facebook.imagepipeline.i.e nbT;
    private com.facebook.imagepipeline.animated.a.a nbU;
    private com.facebook.imagepipeline.decoder.b nbh;

    public static j dHp() {
        return (j) com.facebook.common.internal.g.checkNotNull(nbK, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gb(context).dHa());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (nbK != null) {
                com.facebook.common.c.a.g(mPz, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            nbK = new j(hVar);
        }
    }

    public j(h hVar) {
        this.nbL = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.naV = new at(hVar.dGM().dGB());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dHq() {
        if (this.nbU == null) {
            this.nbU = com.facebook.imagepipeline.animated.a.b.a(dHx(), this.nbL.dGM(), dHr());
        }
        return this.nbU;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a fZ(Context context) {
        com.facebook.imagepipeline.animated.a.a dHq = dHq();
        if (dHq == null) {
            return null;
        }
        return dHq.fZ(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dHr() {
        if (this.nbM == null) {
            this.nbM = com.facebook.imagepipeline.c.a.a(this.nbL.dGF(), this.nbL.dGR(), this.nbL.dGG());
        }
        return this.nbM;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dHs() {
        if (this.nbN == null) {
            this.nbN = com.facebook.imagepipeline.c.b.a(dHr(), this.nbL.dGN());
        }
        return this.nbN;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dHt() {
        if (this.nbO == null) {
            this.nbO = com.facebook.imagepipeline.c.l.a(this.nbL.dGL(), this.nbL.dGR());
        }
        return this.nbO;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dHu() {
        if (this.nbP == null) {
            this.nbP = com.facebook.imagepipeline.c.m.a(dHt(), this.nbL.dGN());
        }
        return this.nbP;
    }

    private com.facebook.imagepipeline.decoder.b dGO() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.nbh == null) {
            if (this.nbL.dGO() != null) {
                this.nbh = this.nbL.dGO();
            } else {
                com.facebook.imagepipeline.animated.a.a dHq = dHq();
                if (dHq != null) {
                    bVar = dHq.a(this.nbL.dGo());
                    bVar2 = dHq.b(this.nbL.dGo());
                } else {
                    bVar = null;
                }
                if (this.nbL.dGY() == null) {
                    this.nbh = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dHy());
                } else {
                    this.nbh = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dHy(), this.nbL.dGY().dIc());
                    com.facebook.c.d.dFw().fy(this.nbL.dGY().dId());
                }
            }
        }
        return this.nbh;
    }

    public com.facebook.imagepipeline.c.e dHv() {
        if (this.naS == null) {
            this.naS = new com.facebook.imagepipeline.c.e(dHw(), this.nbL.dGT().dJj(), this.nbL.dGT().dJk(), this.nbL.dGM().dGx(), this.nbL.dGM().dGy(), this.nbL.dGN());
        }
        return this.naS;
    }

    public com.facebook.cache.disk.h dHw() {
        if (this.nbQ == null) {
            this.nbQ = this.nbL.dGI().a(this.nbL.dGQ());
        }
        return this.nbQ;
    }

    public g dDp() {
        if (this.mSA == null) {
            this.mSA = new g(dHA(), this.nbL.dGV(), this.nbL.dGP(), dHs(), dHu(), dHv(), dHC(), this.nbL.dGE(), this.naV, com.facebook.common.internal.k.aQ(false), this.nbL.dGZ().dHn());
        }
        return this.mSA;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dJf());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dJj()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dHx() {
        if (this.mXb == null) {
            this.mXb = a(this.nbL.dGT(), dHy());
        }
        return this.mXb;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dJh = qVar.dJh();
            return new com.facebook.imagepipeline.i.a(qVar.dJf(), dJh, new Pools.SynchronizedPool(dJh));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dJg());
        }
    }

    public com.facebook.imagepipeline.i.e dHy() {
        if (this.nbT == null) {
            this.nbT = a(this.nbL.dGT(), this.nbL.dGZ().dHd());
        }
        return this.nbT;
    }

    private l dHz() {
        if (this.nbR == null) {
            this.nbR = this.nbL.dGZ().dHl().a(this.nbL.getContext(), this.nbL.dGT().dJl(), dGO(), this.nbL.dGU(), this.nbL.dGJ(), this.nbL.dGW(), this.nbL.dGZ().dHe(), this.nbL.dGM(), this.nbL.dGT().dJj(), dHs(), dHu(), dHv(), dHC(), this.nbL.dGE(), dHx(), this.nbL.dGZ().dHi(), this.nbL.dGZ().dHj(), this.nbL.dGZ().dHm());
        }
        return this.nbR;
    }

    private m dHA() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.nbL.dGZ().dHh();
        if (this.naN == null) {
            this.naN = new m(this.nbL.getContext().getApplicationContext().getContentResolver(), dHz(), this.nbL.dGS(), this.nbL.dGW(), this.nbL.dGZ().dHd(), this.naV, this.nbL.dGZ().dHc(), z, this.nbL.dGZ().dHk(), this.nbL.dGK());
        }
        return this.naN;
    }

    public com.facebook.cache.disk.h dHB() {
        if (this.nbS == null) {
            this.nbS = this.nbL.dGI().a(this.nbL.dGX());
        }
        return this.nbS;
    }

    private com.facebook.imagepipeline.c.e dHC() {
        if (this.naT == null) {
            this.naT = new com.facebook.imagepipeline.c.e(dHB(), this.nbL.dGT().dJj(), this.nbL.dGT().dJk(), this.nbL.dGM().dGx(), this.nbL.dGM().dGy(), this.nbL.dGN());
        }
        return this.naT;
    }
}
