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
/* loaded from: classes12.dex */
public class j {
    private static final Class<?> mHo = j.class;
    private static j mTD = null;
    private g mKr;
    private com.facebook.imagepipeline.b.f mOM;
    private m mSD;
    private com.facebook.imagepipeline.c.e mSI;
    private com.facebook.imagepipeline.c.e mSJ;
    private final at mSL;
    private com.facebook.imagepipeline.decoder.b mSY;
    private final h mTE;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mTF;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mTG;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> mTH;
    private o<com.facebook.cache.common.b, PooledByteBuffer> mTI;
    private com.facebook.cache.disk.h mTJ;
    private l mTK;
    private com.facebook.cache.disk.h mTL;
    private com.facebook.imagepipeline.i.e mTM;
    private com.facebook.imagepipeline.animated.a.a mTN;

    public static j dDY() {
        return (j) com.facebook.common.internal.g.checkNotNull(mTD, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.fY(context).dDJ());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (mTD != null) {
                com.facebook.common.c.a.g(mHo, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            mTD = new j(hVar);
        }
    }

    public j(h hVar) {
        this.mTE = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.mSL = new at(hVar.dDv().dDk());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dDZ() {
        if (this.mTN == null) {
            this.mTN = com.facebook.imagepipeline.animated.a.b.a(dEg(), this.mTE.dDv(), dEa());
        }
        return this.mTN;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a fW(Context context) {
        com.facebook.imagepipeline.animated.a.a dDZ = dDZ();
        if (dDZ == null) {
            return null;
        }
        return dDZ.fW(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dEa() {
        if (this.mTF == null) {
            this.mTF = com.facebook.imagepipeline.c.a.a(this.mTE.dDo(), this.mTE.dDA(), this.mTE.dDp());
        }
        return this.mTF;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dEb() {
        if (this.mTG == null) {
            this.mTG = com.facebook.imagepipeline.c.b.a(dEa(), this.mTE.dDw());
        }
        return this.mTG;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dEc() {
        if (this.mTH == null) {
            this.mTH = com.facebook.imagepipeline.c.l.a(this.mTE.dDu(), this.mTE.dDA());
        }
        return this.mTH;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dEd() {
        if (this.mTI == null) {
            this.mTI = com.facebook.imagepipeline.c.m.a(dEc(), this.mTE.dDw());
        }
        return this.mTI;
    }

    private com.facebook.imagepipeline.decoder.b dDx() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.mSY == null) {
            if (this.mTE.dDx() != null) {
                this.mSY = this.mTE.dDx();
            } else {
                com.facebook.imagepipeline.animated.a.a dDZ = dDZ();
                if (dDZ != null) {
                    bVar = dDZ.a(this.mTE.dCX());
                    bVar2 = dDZ.b(this.mTE.dCX());
                } else {
                    bVar = null;
                }
                if (this.mTE.dDH() == null) {
                    this.mSY = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dEh());
                } else {
                    this.mSY = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dEh(), this.mTE.dDH().dEL());
                    com.facebook.c.d.dCf().fp(this.mTE.dDH().dEM());
                }
            }
        }
        return this.mSY;
    }

    public com.facebook.imagepipeline.c.e dEe() {
        if (this.mSI == null) {
            this.mSI = new com.facebook.imagepipeline.c.e(dEf(), this.mTE.dDC().dFS(), this.mTE.dDC().dFT(), this.mTE.dDv().dDg(), this.mTE.dDv().dDh(), this.mTE.dDw());
        }
        return this.mSI;
    }

    public com.facebook.cache.disk.h dEf() {
        if (this.mTJ == null) {
            this.mTJ = this.mTE.dDr().a(this.mTE.dDz());
        }
        return this.mTJ;
    }

    public g dzY() {
        if (this.mKr == null) {
            this.mKr = new g(dEj(), this.mTE.dDE(), this.mTE.dDy(), dEb(), dEd(), dEe(), dEl(), this.mTE.dDn(), this.mSL, com.facebook.common.internal.k.aQ(false), this.mTE.dDI().dDW());
        }
        return this.mKr;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dFO());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dFS()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dEg() {
        if (this.mOM == null) {
            this.mOM = a(this.mTE.dDC(), dEh());
        }
        return this.mOM;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dFQ = qVar.dFQ();
            return new com.facebook.imagepipeline.i.a(qVar.dFO(), dFQ, new Pools.SynchronizedPool(dFQ));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dFP());
        }
    }

    public com.facebook.imagepipeline.i.e dEh() {
        if (this.mTM == null) {
            this.mTM = a(this.mTE.dDC(), this.mTE.dDI().dDM());
        }
        return this.mTM;
    }

    private l dEi() {
        if (this.mTK == null) {
            this.mTK = this.mTE.dDI().dDU().a(this.mTE.getContext(), this.mTE.dDC().dFU(), dDx(), this.mTE.dDD(), this.mTE.dDs(), this.mTE.dDF(), this.mTE.dDI().dDN(), this.mTE.dDv(), this.mTE.dDC().dFS(), dEb(), dEd(), dEe(), dEl(), this.mTE.dDn(), dEg(), this.mTE.dDI().dDR(), this.mTE.dDI().dDS(), this.mTE.dDI().dDV());
        }
        return this.mTK;
    }

    private m dEj() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.mTE.dDI().dDQ();
        if (this.mSD == null) {
            this.mSD = new m(this.mTE.getContext().getApplicationContext().getContentResolver(), dEi(), this.mTE.dDB(), this.mTE.dDF(), this.mTE.dDI().dDM(), this.mSL, this.mTE.dDI().dDL(), z, this.mTE.dDI().dDT(), this.mTE.dDt());
        }
        return this.mSD;
    }

    public com.facebook.cache.disk.h dEk() {
        if (this.mTL == null) {
            this.mTL = this.mTE.dDr().a(this.mTE.dDG());
        }
        return this.mTL;
    }

    private com.facebook.imagepipeline.c.e dEl() {
        if (this.mSJ == null) {
            this.mSJ = new com.facebook.imagepipeline.c.e(dEk(), this.mTE.dDC().dFS(), this.mTE.dDC().dFT(), this.mTE.dDv().dDg(), this.mTE.dDv().dDh(), this.mTE.dDw());
        }
        return this.mSJ;
    }
}
