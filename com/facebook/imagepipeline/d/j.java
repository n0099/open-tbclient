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
    private static final Class<?> nju = j.class;
    private static j nvA = null;
    private g nmt;
    private com.facebook.imagepipeline.b.f nqQ;
    private m nuD;
    private com.facebook.imagepipeline.c.e nuI;
    private com.facebook.imagepipeline.c.e nuJ;
    private final at nuL;
    private com.facebook.imagepipeline.decoder.b nuX;
    private final h nvB;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nvC;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nvD;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> nvE;
    private o<com.facebook.cache.common.b, PooledByteBuffer> nvF;
    private com.facebook.cache.disk.h nvG;
    private l nvH;
    private com.facebook.cache.disk.h nvI;
    private com.facebook.imagepipeline.i.e nvJ;
    private com.facebook.imagepipeline.animated.a.a nvK;

    public static j dTo() {
        return (j) com.facebook.common.internal.g.checkNotNull(nvA, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gu(context).dSZ());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (nvA != null) {
                com.facebook.common.c.a.g(nju, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            nvA = new j(hVar);
        }
    }

    public j(h hVar) {
        this.nvB = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.nuL = new at(hVar.dSL().dSA());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dTp() {
        if (this.nvK == null) {
            this.nvK = com.facebook.imagepipeline.animated.a.b.a(dTw(), this.nvB.dSL(), dTq());
        }
        return this.nvK;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gs(Context context) {
        com.facebook.imagepipeline.animated.a.a dTp = dTp();
        if (dTp == null) {
            return null;
        }
        return dTp.gs(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dTq() {
        if (this.nvC == null) {
            this.nvC = com.facebook.imagepipeline.c.a.a(this.nvB.dSE(), this.nvB.dSQ(), this.nvB.dSF());
        }
        return this.nvC;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dTr() {
        if (this.nvD == null) {
            this.nvD = com.facebook.imagepipeline.c.b.a(dTq(), this.nvB.dSM());
        }
        return this.nvD;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dTs() {
        if (this.nvE == null) {
            this.nvE = com.facebook.imagepipeline.c.l.a(this.nvB.dSK(), this.nvB.dSQ());
        }
        return this.nvE;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dTt() {
        if (this.nvF == null) {
            this.nvF = com.facebook.imagepipeline.c.m.a(dTs(), this.nvB.dSM());
        }
        return this.nvF;
    }

    private com.facebook.imagepipeline.decoder.b dSN() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.nuX == null) {
            if (this.nvB.dSN() != null) {
                this.nuX = this.nvB.dSN();
            } else {
                com.facebook.imagepipeline.animated.a.a dTp = dTp();
                if (dTp != null) {
                    bVar = dTp.a(this.nvB.dSn());
                    bVar2 = dTp.b(this.nvB.dSn());
                } else {
                    bVar = null;
                }
                if (this.nvB.dSX() == null) {
                    this.nuX = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dTx());
                } else {
                    this.nuX = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dTx(), this.nvB.dSX().dUb());
                    com.facebook.c.d.dRv().fI(this.nvB.dSX().dUc());
                }
            }
        }
        return this.nuX;
    }

    public com.facebook.imagepipeline.c.e dTu() {
        if (this.nuI == null) {
            this.nuI = new com.facebook.imagepipeline.c.e(dTv(), this.nvB.dSS().dVi(), this.nvB.dSS().dVj(), this.nvB.dSL().dSw(), this.nvB.dSL().dSx(), this.nvB.dSM());
        }
        return this.nuI;
    }

    public com.facebook.cache.disk.h dTv() {
        if (this.nvG == null) {
            this.nvG = this.nvB.dSH().a(this.nvB.dSP());
        }
        return this.nvG;
    }

    public g dPp() {
        if (this.nmt == null) {
            this.nmt = new g(dTz(), this.nvB.dSU(), this.nvB.dSO(), dTr(), dTt(), dTu(), dTB(), this.nvB.dSD(), this.nuL, com.facebook.common.internal.k.aS(false), this.nvB.dSY().dTm());
        }
        return this.nmt;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dVe());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dVi()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dTw() {
        if (this.nqQ == null) {
            this.nqQ = a(this.nvB.dSS(), dTx());
        }
        return this.nqQ;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dVg = qVar.dVg();
            return new com.facebook.imagepipeline.i.a(qVar.dVe(), dVg, new Pools.SynchronizedPool(dVg));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dVf());
        }
    }

    public com.facebook.imagepipeline.i.e dTx() {
        if (this.nvJ == null) {
            this.nvJ = a(this.nvB.dSS(), this.nvB.dSY().dTc());
        }
        return this.nvJ;
    }

    private l dTy() {
        if (this.nvH == null) {
            this.nvH = this.nvB.dSY().dTk().a(this.nvB.getContext(), this.nvB.dSS().dVk(), dSN(), this.nvB.dST(), this.nvB.dSI(), this.nvB.dSV(), this.nvB.dSY().dTd(), this.nvB.dSL(), this.nvB.dSS().dVi(), dTr(), dTt(), dTu(), dTB(), this.nvB.dSD(), dTw(), this.nvB.dSY().dTh(), this.nvB.dSY().dTi(), this.nvB.dSY().dTl());
        }
        return this.nvH;
    }

    private m dTz() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.nvB.dSY().dTg();
        if (this.nuD == null) {
            this.nuD = new m(this.nvB.getContext().getApplicationContext().getContentResolver(), dTy(), this.nvB.dSR(), this.nvB.dSV(), this.nvB.dSY().dTc(), this.nuL, this.nvB.dSY().dTb(), z, this.nvB.dSY().dTj(), this.nvB.dSJ());
        }
        return this.nuD;
    }

    public com.facebook.cache.disk.h dTA() {
        if (this.nvI == null) {
            this.nvI = this.nvB.dSH().a(this.nvB.dSW());
        }
        return this.nvI;
    }

    private com.facebook.imagepipeline.c.e dTB() {
        if (this.nuJ == null) {
            this.nuJ = new com.facebook.imagepipeline.c.e(dTA(), this.nvB.dSS().dVi(), this.nvB.dSS().dVj(), this.nvB.dSL().dSw(), this.nvB.dSL().dSx(), this.nvB.dSM());
        }
        return this.nuJ;
    }
}
