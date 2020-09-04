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
/* loaded from: classes8.dex */
public class j {
    private static final Class<?> njM = j.class;
    private static j nvS = null;
    private g nmL;
    private com.facebook.imagepipeline.b.f nri;
    private m nuV;
    private final h nvT;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nvU;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nvV;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> nvW;
    private o<com.facebook.cache.common.b, PooledByteBuffer> nvX;
    private com.facebook.cache.disk.h nvY;
    private l nvZ;
    private com.facebook.imagepipeline.c.e nva;
    private com.facebook.imagepipeline.c.e nvb;
    private final at nvd;
    private com.facebook.imagepipeline.decoder.b nvp;
    private com.facebook.cache.disk.h nwa;
    private com.facebook.imagepipeline.i.e nwb;
    private com.facebook.imagepipeline.animated.a.a nwc;

    public static j dTx() {
        return (j) com.facebook.common.internal.g.checkNotNull(nvS, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gu(context).dTi());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (nvS != null) {
                com.facebook.common.c.a.g(njM, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            nvS = new j(hVar);
        }
    }

    public j(h hVar) {
        this.nvT = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.nvd = new at(hVar.dSU().dSJ());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dTy() {
        if (this.nwc == null) {
            this.nwc = com.facebook.imagepipeline.animated.a.b.a(dTF(), this.nvT.dSU(), dTz());
        }
        return this.nwc;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gs(Context context) {
        com.facebook.imagepipeline.animated.a.a dTy = dTy();
        if (dTy == null) {
            return null;
        }
        return dTy.gs(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dTz() {
        if (this.nvU == null) {
            this.nvU = com.facebook.imagepipeline.c.a.a(this.nvT.dSN(), this.nvT.dSZ(), this.nvT.dSO());
        }
        return this.nvU;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dTA() {
        if (this.nvV == null) {
            this.nvV = com.facebook.imagepipeline.c.b.a(dTz(), this.nvT.dSV());
        }
        return this.nvV;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dTB() {
        if (this.nvW == null) {
            this.nvW = com.facebook.imagepipeline.c.l.a(this.nvT.dST(), this.nvT.dSZ());
        }
        return this.nvW;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dTC() {
        if (this.nvX == null) {
            this.nvX = com.facebook.imagepipeline.c.m.a(dTB(), this.nvT.dSV());
        }
        return this.nvX;
    }

    private com.facebook.imagepipeline.decoder.b dSW() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.nvp == null) {
            if (this.nvT.dSW() != null) {
                this.nvp = this.nvT.dSW();
            } else {
                com.facebook.imagepipeline.animated.a.a dTy = dTy();
                if (dTy != null) {
                    bVar = dTy.a(this.nvT.dSw());
                    bVar2 = dTy.b(this.nvT.dSw());
                } else {
                    bVar = null;
                }
                if (this.nvT.dTg() == null) {
                    this.nvp = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dTG());
                } else {
                    this.nvp = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dTG(), this.nvT.dTg().dUk());
                    com.facebook.c.d.dRE().fI(this.nvT.dTg().dUl());
                }
            }
        }
        return this.nvp;
    }

    public com.facebook.imagepipeline.c.e dTD() {
        if (this.nva == null) {
            this.nva = new com.facebook.imagepipeline.c.e(dTE(), this.nvT.dTb().dVr(), this.nvT.dTb().dVs(), this.nvT.dSU().dSF(), this.nvT.dSU().dSG(), this.nvT.dSV());
        }
        return this.nva;
    }

    public com.facebook.cache.disk.h dTE() {
        if (this.nvY == null) {
            this.nvY = this.nvT.dSQ().a(this.nvT.dSY());
        }
        return this.nvY;
    }

    public g dPy() {
        if (this.nmL == null) {
            this.nmL = new g(dTI(), this.nvT.dTd(), this.nvT.dSX(), dTA(), dTC(), dTD(), dTK(), this.nvT.dSM(), this.nvd, com.facebook.common.internal.k.aS(false), this.nvT.dTh().dTv());
        }
        return this.nmL;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dVn());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dVr()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dTF() {
        if (this.nri == null) {
            this.nri = a(this.nvT.dTb(), dTG());
        }
        return this.nri;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dVp = qVar.dVp();
            return new com.facebook.imagepipeline.i.a(qVar.dVn(), dVp, new Pools.SynchronizedPool(dVp));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dVo());
        }
    }

    public com.facebook.imagepipeline.i.e dTG() {
        if (this.nwb == null) {
            this.nwb = a(this.nvT.dTb(), this.nvT.dTh().dTl());
        }
        return this.nwb;
    }

    private l dTH() {
        if (this.nvZ == null) {
            this.nvZ = this.nvT.dTh().dTt().a(this.nvT.getContext(), this.nvT.dTb().dVt(), dSW(), this.nvT.dTc(), this.nvT.dSR(), this.nvT.dTe(), this.nvT.dTh().dTm(), this.nvT.dSU(), this.nvT.dTb().dVr(), dTA(), dTC(), dTD(), dTK(), this.nvT.dSM(), dTF(), this.nvT.dTh().dTq(), this.nvT.dTh().dTr(), this.nvT.dTh().dTu());
        }
        return this.nvZ;
    }

    private m dTI() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.nvT.dTh().dTp();
        if (this.nuV == null) {
            this.nuV = new m(this.nvT.getContext().getApplicationContext().getContentResolver(), dTH(), this.nvT.dTa(), this.nvT.dTe(), this.nvT.dTh().dTl(), this.nvd, this.nvT.dTh().dTk(), z, this.nvT.dTh().dTs(), this.nvT.dSS());
        }
        return this.nuV;
    }

    public com.facebook.cache.disk.h dTJ() {
        if (this.nwa == null) {
            this.nwa = this.nvT.dSQ().a(this.nvT.dTf());
        }
        return this.nwa;
    }

    private com.facebook.imagepipeline.c.e dTK() {
        if (this.nvb == null) {
            this.nvb = new com.facebook.imagepipeline.c.e(dTJ(), this.nvT.dTb().dVr(), this.nvT.dTb().dVs(), this.nvT.dSU().dSF(), this.nvT.dSU().dSG(), this.nvT.dSV());
        }
        return this.nvb;
    }
}
