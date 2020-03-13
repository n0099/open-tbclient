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
    private static final Class<?> lHl = j.class;
    private static j lTb = null;
    private g lKl;
    private com.facebook.imagepipeline.b.f lOv;
    private m lSe;
    private com.facebook.imagepipeline.c.e lSj;
    private com.facebook.imagepipeline.c.e lSk;
    private final at lSm;
    private com.facebook.imagepipeline.decoder.b lSy;
    private final h lTc;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTd;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTe;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> lTf;
    private o<com.facebook.cache.common.b, PooledByteBuffer> lTg;
    private com.facebook.cache.disk.h lTh;
    private l lTi;
    private com.facebook.cache.disk.h lTj;
    private com.facebook.imagepipeline.i.e lTk;
    private com.facebook.imagepipeline.animated.a.a lTl;

    public static j dpx() {
        return (j) com.facebook.common.internal.g.checkNotNull(lTb, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gn(context).dpi());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (lTb != null) {
                com.facebook.common.c.a.g(lHl, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            lTb = new j(hVar);
        }
    }

    public j(h hVar) {
        this.lTc = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.lSm = new at(hVar.doU().doI());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dpy() {
        if (this.lTl == null) {
            this.lTl = com.facebook.imagepipeline.animated.a.b.a(dpF(), this.lTc.doU(), dpz());
        }
        return this.lTl;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gm(Context context) {
        com.facebook.imagepipeline.animated.a.a dpy = dpy();
        if (dpy == null) {
            return null;
        }
        return dpy.gm(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dpz() {
        if (this.lTd == null) {
            this.lTd = com.facebook.imagepipeline.c.a.a(this.lTc.doN(), this.lTc.doZ(), this.lTc.doO());
        }
        return this.lTd;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dpA() {
        if (this.lTe == null) {
            this.lTe = com.facebook.imagepipeline.c.b.a(dpz(), this.lTc.doV());
        }
        return this.lTe;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dpB() {
        if (this.lTf == null) {
            this.lTf = com.facebook.imagepipeline.c.l.a(this.lTc.doT(), this.lTc.doZ());
        }
        return this.lTf;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dpC() {
        if (this.lTg == null) {
            this.lTg = com.facebook.imagepipeline.c.m.a(dpB(), this.lTc.doV());
        }
        return this.lTg;
    }

    private com.facebook.imagepipeline.decoder.b doW() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.lSy == null) {
            if (this.lTc.doW() != null) {
                this.lSy = this.lTc.doW();
            } else {
                com.facebook.imagepipeline.animated.a.a dpy = dpy();
                if (dpy != null) {
                    bVar = dpy.a(this.lTc.dov());
                    bVar2 = dpy.b(this.lTc.dov());
                } else {
                    bVar = null;
                }
                if (this.lTc.dpg() == null) {
                    this.lSy = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dpG());
                } else {
                    this.lSy = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dpG(), this.lTc.dpg().dqk());
                    com.facebook.c.d.dnF().eT(this.lTc.dpg().dql());
                }
            }
        }
        return this.lSy;
    }

    public com.facebook.imagepipeline.c.e dpD() {
        if (this.lSj == null) {
            this.lSj = new com.facebook.imagepipeline.c.e(dpE(), this.lTc.dpb().drs(), this.lTc.dpb().drt(), this.lTc.doU().doE(), this.lTc.doU().doF(), this.lTc.doV());
        }
        return this.lSj;
    }

    public com.facebook.cache.disk.h dpE() {
        if (this.lTh == null) {
            this.lTh = this.lTc.doQ().a(this.lTc.doY());
        }
        return this.lTh;
    }

    public g dlB() {
        if (this.lKl == null) {
            this.lKl = new g(dpI(), this.lTc.dpd(), this.lTc.doX(), dpA(), dpC(), dpD(), dpK(), this.lTc.doM(), this.lSm, com.facebook.common.internal.k.aU(false), this.lTc.dph().dpv());
        }
        return this.lKl;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dro());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.drs()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dpF() {
        if (this.lOv == null) {
            this.lOv = a(this.lTc.dpb(), dpG());
        }
        return this.lOv;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int drq = qVar.drq();
            return new com.facebook.imagepipeline.i.a(qVar.dro(), drq, new Pools.SynchronizedPool(drq));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.drp());
        }
    }

    public com.facebook.imagepipeline.i.e dpG() {
        if (this.lTk == null) {
            this.lTk = a(this.lTc.dpb(), this.lTc.dph().dpl());
        }
        return this.lTk;
    }

    private l dpH() {
        if (this.lTi == null) {
            this.lTi = this.lTc.dph().dpt().a(this.lTc.getContext(), this.lTc.dpb().dru(), doW(), this.lTc.dpc(), this.lTc.doR(), this.lTc.dpe(), this.lTc.dph().dpm(), this.lTc.doU(), this.lTc.dpb().drs(), dpA(), dpC(), dpD(), dpK(), this.lTc.doM(), dpF(), this.lTc.dph().dpq(), this.lTc.dph().dpr(), this.lTc.dph().dpu());
        }
        return this.lTi;
    }

    private m dpI() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.lTc.dph().dpp();
        if (this.lSe == null) {
            this.lSe = new m(this.lTc.getContext().getApplicationContext().getContentResolver(), dpH(), this.lTc.dpa(), this.lTc.dpe(), this.lTc.dph().dpl(), this.lSm, this.lTc.dph().dpk(), z, this.lTc.dph().dps(), this.lTc.doS());
        }
        return this.lSe;
    }

    public com.facebook.cache.disk.h dpJ() {
        if (this.lTj == null) {
            this.lTj = this.lTc.doQ().a(this.lTc.dpf());
        }
        return this.lTj;
    }

    private com.facebook.imagepipeline.c.e dpK() {
        if (this.lSk == null) {
            this.lSk = new com.facebook.imagepipeline.c.e(dpJ(), this.lTc.dpb().drs(), this.lTc.dpb().drt(), this.lTc.doU().doE(), this.lTc.doU().doF(), this.lTc.doV());
        }
        return this.lSk;
    }
}
