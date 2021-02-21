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
    private g pAY;
    private com.facebook.imagepipeline.a.f pFi;
    private m pII;
    private com.facebook.imagepipeline.b.e pIN;
    private com.facebook.imagepipeline.b.e pIO;
    private final at pIQ;
    private final h pJG;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pJH;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pJI;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> pJJ;
    private o<com.facebook.cache.common.b, PooledByteBuffer> pJK;
    private com.facebook.cache.disk.h pJL;
    private l pJM;
    private com.facebook.cache.disk.h pJN;
    private com.facebook.imagepipeline.h.e pJO;
    private com.facebook.imagepipeline.animated.a.a pJP;
    private com.facebook.imagepipeline.decoder.b pJc;
    private static final Class<?> pyc = j.class;
    private static j pJF = null;

    public static j ext() {
        return (j) com.facebook.common.internal.g.checkNotNull(pJF, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.im(context).exe());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (pJF != null) {
                com.facebook.common.c.a.h(pyc, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            pJF = new j(hVar);
        }
    }

    public j(h hVar) {
        this.pJG = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.pIQ = new at(hVar.ewQ().ewE());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a exu() {
        if (this.pJP == null) {
            this.pJP = com.facebook.imagepipeline.animated.a.b.a(exB(), this.pJG.ewQ(), exv());
        }
        return this.pJP;
    }

    @Nullable
    public com.facebook.imagepipeline.e.a ik(Context context) {
        com.facebook.imagepipeline.animated.a.a exu = exu();
        if (exu == null) {
            return null;
        }
        return exu.ik(context);
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> exv() {
        if (this.pJH == null) {
            this.pJH = com.facebook.imagepipeline.b.a.a(this.pJG.ewJ(), this.pJG.ewV(), this.pJG.ewK());
        }
        return this.pJH;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> exw() {
        if (this.pJI == null) {
            this.pJI = com.facebook.imagepipeline.b.b.a(exv(), this.pJG.ewR());
        }
        return this.pJI;
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> exx() {
        if (this.pJJ == null) {
            this.pJJ = com.facebook.imagepipeline.b.l.a(this.pJG.ewP(), this.pJG.ewV());
        }
        return this.pJJ;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> exy() {
        if (this.pJK == null) {
            this.pJK = com.facebook.imagepipeline.b.m.a(exx(), this.pJG.ewR());
        }
        return this.pJK;
    }

    private com.facebook.imagepipeline.decoder.b ewS() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2;
        if (this.pJc == null) {
            if (this.pJG.ewS() != null) {
                this.pJc = this.pJG.ewS();
            } else {
                com.facebook.imagepipeline.animated.a.a exu = exu();
                if (exu != null) {
                    com.facebook.imagepipeline.decoder.b c = exu.c(this.pJG.ews());
                    bVar = exu.d(this.pJG.ews());
                    bVar2 = c;
                } else {
                    bVar = null;
                    bVar2 = null;
                }
                if (this.pJG.exc() == null) {
                    this.pJc = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, exC());
                } else {
                    this.pJc = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, exC(), this.pJG.exc().eyg());
                    com.facebook.c.d.evC().gJ(this.pJG.exc().eyh());
                }
            }
        }
        return this.pJc;
    }

    public com.facebook.imagepipeline.b.e exz() {
        if (this.pIN == null) {
            this.pIN = new com.facebook.imagepipeline.b.e(exA(), this.pJG.ewX().ezj(), this.pJG.ewX().ezk(), this.pJG.ewQ().ewA(), this.pJG.ewQ().ewB(), this.pJG.ewR());
        }
        return this.pIN;
    }

    public com.facebook.cache.disk.h exA() {
        if (this.pJL == null) {
            this.pJL = this.pJG.ewM().a(this.pJG.ewU());
        }
        return this.pJL;
    }

    public g ety() {
        if (this.pAY == null) {
            this.pAY = new g(exE(), this.pJG.ewZ(), this.pJG.ewT(), exw(), exy(), exz(), exG(), this.pJG.ewI(), this.pIQ, com.facebook.common.internal.k.bc(false), this.pJG.exd().exr());
        }
        return this.pAY;
    }

    public static com.facebook.imagepipeline.a.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.a.a(qVar.ezf());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.a.e(new com.facebook.imagepipeline.a.b(qVar.ezj()), eVar);
        }
        return new com.facebook.imagepipeline.a.c();
    }

    public com.facebook.imagepipeline.a.f exB() {
        if (this.pFi == null) {
            this.pFi = a(this.pJG.ewX(), exC());
        }
        return this.pFi;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int ezh = qVar.ezh();
            return new com.facebook.imagepipeline.h.a(qVar.ezf(), ezh, new Pools.SynchronizedPool(ezh));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.ezg());
        }
    }

    public com.facebook.imagepipeline.h.e exC() {
        if (this.pJO == null) {
            this.pJO = a(this.pJG.ewX(), this.pJG.exd().exh());
        }
        return this.pJO;
    }

    private l exD() {
        if (this.pJM == null) {
            this.pJM = this.pJG.exd().exp().a(this.pJG.getContext(), this.pJG.ewX().ezl(), ewS(), this.pJG.ewY(), this.pJG.ewN(), this.pJG.exa(), this.pJG.exd().exi(), this.pJG.ewQ(), this.pJG.ewX().ezj(), exw(), exy(), exz(), exG(), this.pJG.ewI(), exB(), this.pJG.exd().exm(), this.pJG.exd().exn(), this.pJG.exd().exq());
        }
        return this.pJM;
    }

    private m exE() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.pJG.exd().exl();
        if (this.pII == null) {
            this.pII = new m(this.pJG.getContext().getApplicationContext().getContentResolver(), exD(), this.pJG.ewW(), this.pJG.exa(), this.pJG.exd().exh(), this.pIQ, this.pJG.exd().exg(), z, this.pJG.exd().exo(), this.pJG.ewO());
        }
        return this.pII;
    }

    public com.facebook.cache.disk.h exF() {
        if (this.pJN == null) {
            this.pJN = this.pJG.ewM().a(this.pJG.exb());
        }
        return this.pJN;
    }

    private com.facebook.imagepipeline.b.e exG() {
        if (this.pIO == null) {
            this.pIO = new com.facebook.imagepipeline.b.e(exF(), this.pJG.ewX().ezj(), this.pJG.ewX().ezk(), this.pJG.ewQ().ewA(), this.pJG.ewQ().ewB(), this.pJG.ewR());
        }
        return this.pIO;
    }
}
