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
    private static final Class<?> lGY = j.class;
    private static j lSO = null;
    private g lJY;
    private com.facebook.imagepipeline.b.f lOi;
    private m lRR;
    private com.facebook.imagepipeline.c.e lRW;
    private com.facebook.imagepipeline.c.e lRX;
    private final at lRZ;
    private final h lSP;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lSQ;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lSR;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> lSS;
    private o<com.facebook.cache.common.b, PooledByteBuffer> lST;
    private com.facebook.cache.disk.h lSU;
    private l lSV;
    private com.facebook.cache.disk.h lSW;
    private com.facebook.imagepipeline.i.e lSX;
    private com.facebook.imagepipeline.animated.a.a lSY;
    private com.facebook.imagepipeline.decoder.b lSl;

    public static j dpu() {
        return (j) com.facebook.common.internal.g.checkNotNull(lSO, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gn(context).dpf());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (lSO != null) {
                com.facebook.common.c.a.g(lGY, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            lSO = new j(hVar);
        }
    }

    public j(h hVar) {
        this.lSP = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.lRZ = new at(hVar.doR().doF());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dpv() {
        if (this.lSY == null) {
            this.lSY = com.facebook.imagepipeline.animated.a.b.a(dpC(), this.lSP.doR(), dpw());
        }
        return this.lSY;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gm(Context context) {
        com.facebook.imagepipeline.animated.a.a dpv = dpv();
        if (dpv == null) {
            return null;
        }
        return dpv.gm(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dpw() {
        if (this.lSQ == null) {
            this.lSQ = com.facebook.imagepipeline.c.a.a(this.lSP.doK(), this.lSP.doW(), this.lSP.doL());
        }
        return this.lSQ;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dpx() {
        if (this.lSR == null) {
            this.lSR = com.facebook.imagepipeline.c.b.a(dpw(), this.lSP.doS());
        }
        return this.lSR;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dpy() {
        if (this.lSS == null) {
            this.lSS = com.facebook.imagepipeline.c.l.a(this.lSP.doQ(), this.lSP.doW());
        }
        return this.lSS;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dpz() {
        if (this.lST == null) {
            this.lST = com.facebook.imagepipeline.c.m.a(dpy(), this.lSP.doS());
        }
        return this.lST;
    }

    private com.facebook.imagepipeline.decoder.b doT() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.lSl == null) {
            if (this.lSP.doT() != null) {
                this.lSl = this.lSP.doT();
            } else {
                com.facebook.imagepipeline.animated.a.a dpv = dpv();
                if (dpv != null) {
                    bVar = dpv.a(this.lSP.dos());
                    bVar2 = dpv.b(this.lSP.dos());
                } else {
                    bVar = null;
                }
                if (this.lSP.dpd() == null) {
                    this.lSl = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dpD());
                } else {
                    this.lSl = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dpD(), this.lSP.dpd().dqh());
                    com.facebook.c.d.dnC().eT(this.lSP.dpd().dqi());
                }
            }
        }
        return this.lSl;
    }

    public com.facebook.imagepipeline.c.e dpA() {
        if (this.lRW == null) {
            this.lRW = new com.facebook.imagepipeline.c.e(dpB(), this.lSP.doY().drp(), this.lSP.doY().drq(), this.lSP.doR().doB(), this.lSP.doR().doC(), this.lSP.doS());
        }
        return this.lRW;
    }

    public com.facebook.cache.disk.h dpB() {
        if (this.lSU == null) {
            this.lSU = this.lSP.doN().a(this.lSP.doV());
        }
        return this.lSU;
    }

    public g dly() {
        if (this.lJY == null) {
            this.lJY = new g(dpF(), this.lSP.dpa(), this.lSP.doU(), dpx(), dpz(), dpA(), dpH(), this.lSP.doJ(), this.lRZ, com.facebook.common.internal.k.aU(false), this.lSP.dpe().dps());
        }
        return this.lJY;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.drl());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.drp()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dpC() {
        if (this.lOi == null) {
            this.lOi = a(this.lSP.doY(), dpD());
        }
        return this.lOi;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int drn = qVar.drn();
            return new com.facebook.imagepipeline.i.a(qVar.drl(), drn, new Pools.SynchronizedPool(drn));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.drm());
        }
    }

    public com.facebook.imagepipeline.i.e dpD() {
        if (this.lSX == null) {
            this.lSX = a(this.lSP.doY(), this.lSP.dpe().dpi());
        }
        return this.lSX;
    }

    private l dpE() {
        if (this.lSV == null) {
            this.lSV = this.lSP.dpe().dpq().a(this.lSP.getContext(), this.lSP.doY().drr(), doT(), this.lSP.doZ(), this.lSP.doO(), this.lSP.dpb(), this.lSP.dpe().dpj(), this.lSP.doR(), this.lSP.doY().drp(), dpx(), dpz(), dpA(), dpH(), this.lSP.doJ(), dpC(), this.lSP.dpe().dpn(), this.lSP.dpe().dpo(), this.lSP.dpe().dpr());
        }
        return this.lSV;
    }

    private m dpF() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.lSP.dpe().dpm();
        if (this.lRR == null) {
            this.lRR = new m(this.lSP.getContext().getApplicationContext().getContentResolver(), dpE(), this.lSP.doX(), this.lSP.dpb(), this.lSP.dpe().dpi(), this.lRZ, this.lSP.dpe().dph(), z, this.lSP.dpe().dpp(), this.lSP.doP());
        }
        return this.lRR;
    }

    public com.facebook.cache.disk.h dpG() {
        if (this.lSW == null) {
            this.lSW = this.lSP.doN().a(this.lSP.dpc());
        }
        return this.lSW;
    }

    private com.facebook.imagepipeline.c.e dpH() {
        if (this.lRX == null) {
            this.lRX = new com.facebook.imagepipeline.c.e(dpG(), this.lSP.doY().drp(), this.lSP.doY().drq(), this.lSP.doR().doB(), this.lSP.doR().doC(), this.lSP.doS());
        }
        return this.lRX;
    }
}
