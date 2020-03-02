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
    private static final Class<?> lHa = j.class;
    private static j lSQ = null;
    private g lKa;
    private com.facebook.imagepipeline.b.f lOk;
    private m lRT;
    private com.facebook.imagepipeline.c.e lRY;
    private com.facebook.imagepipeline.c.e lRZ;
    private final h lSR;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lSS;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lST;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> lSU;
    private o<com.facebook.cache.common.b, PooledByteBuffer> lSV;
    private com.facebook.cache.disk.h lSW;
    private l lSX;
    private com.facebook.cache.disk.h lSY;
    private com.facebook.imagepipeline.i.e lSZ;
    private final at lSb;
    private com.facebook.imagepipeline.decoder.b lSn;
    private com.facebook.imagepipeline.animated.a.a lTa;

    public static j dpw() {
        return (j) com.facebook.common.internal.g.checkNotNull(lSQ, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gn(context).dph());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (lSQ != null) {
                com.facebook.common.c.a.g(lHa, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            lSQ = new j(hVar);
        }
    }

    public j(h hVar) {
        this.lSR = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.lSb = new at(hVar.doT().doH());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dpx() {
        if (this.lTa == null) {
            this.lTa = com.facebook.imagepipeline.animated.a.b.a(dpE(), this.lSR.doT(), dpy());
        }
        return this.lTa;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gm(Context context) {
        com.facebook.imagepipeline.animated.a.a dpx = dpx();
        if (dpx == null) {
            return null;
        }
        return dpx.gm(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dpy() {
        if (this.lSS == null) {
            this.lSS = com.facebook.imagepipeline.c.a.a(this.lSR.doM(), this.lSR.doY(), this.lSR.doN());
        }
        return this.lSS;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dpz() {
        if (this.lST == null) {
            this.lST = com.facebook.imagepipeline.c.b.a(dpy(), this.lSR.doU());
        }
        return this.lST;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dpA() {
        if (this.lSU == null) {
            this.lSU = com.facebook.imagepipeline.c.l.a(this.lSR.doS(), this.lSR.doY());
        }
        return this.lSU;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dpB() {
        if (this.lSV == null) {
            this.lSV = com.facebook.imagepipeline.c.m.a(dpA(), this.lSR.doU());
        }
        return this.lSV;
    }

    private com.facebook.imagepipeline.decoder.b doV() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.lSn == null) {
            if (this.lSR.doV() != null) {
                this.lSn = this.lSR.doV();
            } else {
                com.facebook.imagepipeline.animated.a.a dpx = dpx();
                if (dpx != null) {
                    bVar = dpx.a(this.lSR.dou());
                    bVar2 = dpx.b(this.lSR.dou());
                } else {
                    bVar = null;
                }
                if (this.lSR.dpf() == null) {
                    this.lSn = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dpF());
                } else {
                    this.lSn = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dpF(), this.lSR.dpf().dqj());
                    com.facebook.c.d.dnE().eT(this.lSR.dpf().dqk());
                }
            }
        }
        return this.lSn;
    }

    public com.facebook.imagepipeline.c.e dpC() {
        if (this.lRY == null) {
            this.lRY = new com.facebook.imagepipeline.c.e(dpD(), this.lSR.dpa().drr(), this.lSR.dpa().drs(), this.lSR.doT().doD(), this.lSR.doT().doE(), this.lSR.doU());
        }
        return this.lRY;
    }

    public com.facebook.cache.disk.h dpD() {
        if (this.lSW == null) {
            this.lSW = this.lSR.doP().a(this.lSR.doX());
        }
        return this.lSW;
    }

    public g dlA() {
        if (this.lKa == null) {
            this.lKa = new g(dpH(), this.lSR.dpc(), this.lSR.doW(), dpz(), dpB(), dpC(), dpJ(), this.lSR.doL(), this.lSb, com.facebook.common.internal.k.aU(false), this.lSR.dpg().dpu());
        }
        return this.lKa;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.drn());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.drr()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dpE() {
        if (this.lOk == null) {
            this.lOk = a(this.lSR.dpa(), dpF());
        }
        return this.lOk;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int drp = qVar.drp();
            return new com.facebook.imagepipeline.i.a(qVar.drn(), drp, new Pools.SynchronizedPool(drp));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dro());
        }
    }

    public com.facebook.imagepipeline.i.e dpF() {
        if (this.lSZ == null) {
            this.lSZ = a(this.lSR.dpa(), this.lSR.dpg().dpk());
        }
        return this.lSZ;
    }

    private l dpG() {
        if (this.lSX == null) {
            this.lSX = this.lSR.dpg().dps().a(this.lSR.getContext(), this.lSR.dpa().drt(), doV(), this.lSR.dpb(), this.lSR.doQ(), this.lSR.dpd(), this.lSR.dpg().dpl(), this.lSR.doT(), this.lSR.dpa().drr(), dpz(), dpB(), dpC(), dpJ(), this.lSR.doL(), dpE(), this.lSR.dpg().dpp(), this.lSR.dpg().dpq(), this.lSR.dpg().dpt());
        }
        return this.lSX;
    }

    private m dpH() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.lSR.dpg().dpo();
        if (this.lRT == null) {
            this.lRT = new m(this.lSR.getContext().getApplicationContext().getContentResolver(), dpG(), this.lSR.doZ(), this.lSR.dpd(), this.lSR.dpg().dpk(), this.lSb, this.lSR.dpg().dpj(), z, this.lSR.dpg().dpr(), this.lSR.doR());
        }
        return this.lRT;
    }

    public com.facebook.cache.disk.h dpI() {
        if (this.lSY == null) {
            this.lSY = this.lSR.doP().a(this.lSR.dpe());
        }
        return this.lSY;
    }

    private com.facebook.imagepipeline.c.e dpJ() {
        if (this.lRZ == null) {
            this.lRZ = new com.facebook.imagepipeline.c.e(dpI(), this.lSR.dpa().drr(), this.lSR.dpa().drs(), this.lSR.doT().doD(), this.lSR.doT().doE(), this.lSR.doU());
        }
        return this.lRZ;
    }
}
