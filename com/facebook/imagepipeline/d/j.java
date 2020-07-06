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
    private static final Class<?> mHr = j.class;
    private static j mTG = null;
    private g mKu;
    private com.facebook.imagepipeline.b.f mOP;
    private m mSG;
    private com.facebook.imagepipeline.c.e mSL;
    private com.facebook.imagepipeline.c.e mSM;
    private final at mSO;
    private final h mTH;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mTI;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mTJ;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> mTK;
    private o<com.facebook.cache.common.b, PooledByteBuffer> mTL;
    private com.facebook.cache.disk.h mTM;
    private l mTN;
    private com.facebook.cache.disk.h mTO;
    private com.facebook.imagepipeline.i.e mTP;
    private com.facebook.imagepipeline.animated.a.a mTQ;
    private com.facebook.imagepipeline.decoder.b mTb;

    public static j dEc() {
        return (j) com.facebook.common.internal.g.checkNotNull(mTG, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.fY(context).dDN());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (mTG != null) {
                com.facebook.common.c.a.g(mHr, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            mTG = new j(hVar);
        }
    }

    public j(h hVar) {
        this.mTH = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.mSO = new at(hVar.dDz().dDo());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dEd() {
        if (this.mTQ == null) {
            this.mTQ = com.facebook.imagepipeline.animated.a.b.a(dEk(), this.mTH.dDz(), dEe());
        }
        return this.mTQ;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a fW(Context context) {
        com.facebook.imagepipeline.animated.a.a dEd = dEd();
        if (dEd == null) {
            return null;
        }
        return dEd.fW(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dEe() {
        if (this.mTI == null) {
            this.mTI = com.facebook.imagepipeline.c.a.a(this.mTH.dDs(), this.mTH.dDE(), this.mTH.dDt());
        }
        return this.mTI;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dEf() {
        if (this.mTJ == null) {
            this.mTJ = com.facebook.imagepipeline.c.b.a(dEe(), this.mTH.dDA());
        }
        return this.mTJ;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dEg() {
        if (this.mTK == null) {
            this.mTK = com.facebook.imagepipeline.c.l.a(this.mTH.dDy(), this.mTH.dDE());
        }
        return this.mTK;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dEh() {
        if (this.mTL == null) {
            this.mTL = com.facebook.imagepipeline.c.m.a(dEg(), this.mTH.dDA());
        }
        return this.mTL;
    }

    private com.facebook.imagepipeline.decoder.b dDB() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.mTb == null) {
            if (this.mTH.dDB() != null) {
                this.mTb = this.mTH.dDB();
            } else {
                com.facebook.imagepipeline.animated.a.a dEd = dEd();
                if (dEd != null) {
                    bVar = dEd.a(this.mTH.dDb());
                    bVar2 = dEd.b(this.mTH.dDb());
                } else {
                    bVar = null;
                }
                if (this.mTH.dDL() == null) {
                    this.mTb = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dEl());
                } else {
                    this.mTb = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dEl(), this.mTH.dDL().dEP());
                    com.facebook.c.d.dCj().fp(this.mTH.dDL().dEQ());
                }
            }
        }
        return this.mTb;
    }

    public com.facebook.imagepipeline.c.e dEi() {
        if (this.mSL == null) {
            this.mSL = new com.facebook.imagepipeline.c.e(dEj(), this.mTH.dDG().dFW(), this.mTH.dDG().dFX(), this.mTH.dDz().dDk(), this.mTH.dDz().dDl(), this.mTH.dDA());
        }
        return this.mSL;
    }

    public com.facebook.cache.disk.h dEj() {
        if (this.mTM == null) {
            this.mTM = this.mTH.dDv().a(this.mTH.dDD());
        }
        return this.mTM;
    }

    public g dAc() {
        if (this.mKu == null) {
            this.mKu = new g(dEn(), this.mTH.dDI(), this.mTH.dDC(), dEf(), dEh(), dEi(), dEp(), this.mTH.dDr(), this.mSO, com.facebook.common.internal.k.aQ(false), this.mTH.dDM().dEa());
        }
        return this.mKu;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dFS());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dFW()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dEk() {
        if (this.mOP == null) {
            this.mOP = a(this.mTH.dDG(), dEl());
        }
        return this.mOP;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dFU = qVar.dFU();
            return new com.facebook.imagepipeline.i.a(qVar.dFS(), dFU, new Pools.SynchronizedPool(dFU));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dFT());
        }
    }

    public com.facebook.imagepipeline.i.e dEl() {
        if (this.mTP == null) {
            this.mTP = a(this.mTH.dDG(), this.mTH.dDM().dDQ());
        }
        return this.mTP;
    }

    private l dEm() {
        if (this.mTN == null) {
            this.mTN = this.mTH.dDM().dDY().a(this.mTH.getContext(), this.mTH.dDG().dFY(), dDB(), this.mTH.dDH(), this.mTH.dDw(), this.mTH.dDJ(), this.mTH.dDM().dDR(), this.mTH.dDz(), this.mTH.dDG().dFW(), dEf(), dEh(), dEi(), dEp(), this.mTH.dDr(), dEk(), this.mTH.dDM().dDV(), this.mTH.dDM().dDW(), this.mTH.dDM().dDZ());
        }
        return this.mTN;
    }

    private m dEn() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.mTH.dDM().dDU();
        if (this.mSG == null) {
            this.mSG = new m(this.mTH.getContext().getApplicationContext().getContentResolver(), dEm(), this.mTH.dDF(), this.mTH.dDJ(), this.mTH.dDM().dDQ(), this.mSO, this.mTH.dDM().dDP(), z, this.mTH.dDM().dDX(), this.mTH.dDx());
        }
        return this.mSG;
    }

    public com.facebook.cache.disk.h dEo() {
        if (this.mTO == null) {
            this.mTO = this.mTH.dDv().a(this.mTH.dDK());
        }
        return this.mTO;
    }

    private com.facebook.imagepipeline.c.e dEp() {
        if (this.mSM == null) {
            this.mSM = new com.facebook.imagepipeline.c.e(dEo(), this.mTH.dDG().dFW(), this.mTH.dDG().dFX(), this.mTH.dDz().dDk(), this.mTH.dDz().dDl(), this.mTH.dDA());
        }
        return this.mSM;
    }
}
