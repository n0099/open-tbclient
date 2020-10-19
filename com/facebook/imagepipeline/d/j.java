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
/* loaded from: classes18.dex */
public class j {
    private static final Class<?> nJf = j.class;
    private static j nVi = null;
    private g nMe;
    private com.facebook.imagepipeline.b.f nQz;
    private com.facebook.imagepipeline.decoder.b nUF;
    private m nUl;
    private com.facebook.imagepipeline.c.e nUq;
    private com.facebook.imagepipeline.c.e nUr;
    private final at nUt;
    private final h nVj;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nVk;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nVl;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> nVm;
    private o<com.facebook.cache.common.b, PooledByteBuffer> nVn;
    private com.facebook.cache.disk.h nVo;
    private l nVp;
    private com.facebook.cache.disk.h nVq;
    private com.facebook.imagepipeline.i.e nVr;
    private com.facebook.imagepipeline.animated.a.a nVs;

    public static j ebg() {
        return (j) com.facebook.common.internal.g.checkNotNull(nVi, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gI(context).eaR());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (nVi != null) {
                com.facebook.common.c.a.g(nJf, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            nVi = new j(hVar);
        }
    }

    public j(h hVar) {
        this.nVj = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.nUt = new at(hVar.eaD().eas());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a ebh() {
        if (this.nVs == null) {
            this.nVs = com.facebook.imagepipeline.animated.a.b.a(ebo(), this.nVj.eaD(), ebi());
        }
        return this.nVs;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gG(Context context) {
        com.facebook.imagepipeline.animated.a.a ebh = ebh();
        if (ebh == null) {
            return null;
        }
        return ebh.gG(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> ebi() {
        if (this.nVk == null) {
            this.nVk = com.facebook.imagepipeline.c.a.a(this.nVj.eaw(), this.nVj.eaI(), this.nVj.eax());
        }
        return this.nVk;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> ebj() {
        if (this.nVl == null) {
            this.nVl = com.facebook.imagepipeline.c.b.a(ebi(), this.nVj.eaE());
        }
        return this.nVl;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> ebk() {
        if (this.nVm == null) {
            this.nVm = com.facebook.imagepipeline.c.l.a(this.nVj.eaC(), this.nVj.eaI());
        }
        return this.nVm;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> ebl() {
        if (this.nVn == null) {
            this.nVn = com.facebook.imagepipeline.c.m.a(ebk(), this.nVj.eaE());
        }
        return this.nVn;
    }

    private com.facebook.imagepipeline.decoder.b eaF() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.nUF == null) {
            if (this.nVj.eaF() != null) {
                this.nUF = this.nVj.eaF();
            } else {
                com.facebook.imagepipeline.animated.a.a ebh = ebh();
                if (ebh != null) {
                    bVar = ebh.a(this.nVj.eaf());
                    bVar2 = ebh.b(this.nVj.eaf());
                } else {
                    bVar = null;
                }
                if (this.nVj.eaP() == null) {
                    this.nUF = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, ebp());
                } else {
                    this.nUF = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, ebp(), this.nVj.eaP().ebT());
                    com.facebook.c.d.dZn().fU(this.nVj.eaP().ebU());
                }
            }
        }
        return this.nUF;
    }

    public com.facebook.imagepipeline.c.e ebm() {
        if (this.nUq == null) {
            this.nUq = new com.facebook.imagepipeline.c.e(ebn(), this.nVj.eaK().eda(), this.nVj.eaK().edb(), this.nVj.eaD().eao(), this.nVj.eaD().eap(), this.nVj.eaE());
        }
        return this.nUq;
    }

    public com.facebook.cache.disk.h ebn() {
        if (this.nVo == null) {
            this.nVo = this.nVj.eaz().a(this.nVj.eaH());
        }
        return this.nVo;
    }

    public g dXh() {
        if (this.nMe == null) {
            this.nMe = new g(ebr(), this.nVj.eaM(), this.nVj.eaG(), ebj(), ebl(), ebm(), ebt(), this.nVj.eav(), this.nUt, com.facebook.common.internal.k.aX(false), this.nVj.eaQ().ebe());
        }
        return this.nMe;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.ecW());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.eda()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f ebo() {
        if (this.nQz == null) {
            this.nQz = a(this.nVj.eaK(), ebp());
        }
        return this.nQz;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int ecY = qVar.ecY();
            return new com.facebook.imagepipeline.i.a(qVar.ecW(), ecY, new Pools.SynchronizedPool(ecY));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.ecX());
        }
    }

    public com.facebook.imagepipeline.i.e ebp() {
        if (this.nVr == null) {
            this.nVr = a(this.nVj.eaK(), this.nVj.eaQ().eaU());
        }
        return this.nVr;
    }

    private l ebq() {
        if (this.nVp == null) {
            this.nVp = this.nVj.eaQ().ebc().a(this.nVj.getContext(), this.nVj.eaK().edc(), eaF(), this.nVj.eaL(), this.nVj.eaA(), this.nVj.eaN(), this.nVj.eaQ().eaV(), this.nVj.eaD(), this.nVj.eaK().eda(), ebj(), ebl(), ebm(), ebt(), this.nVj.eav(), ebo(), this.nVj.eaQ().eaZ(), this.nVj.eaQ().eba(), this.nVj.eaQ().ebd());
        }
        return this.nVp;
    }

    private m ebr() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.nVj.eaQ().eaY();
        if (this.nUl == null) {
            this.nUl = new m(this.nVj.getContext().getApplicationContext().getContentResolver(), ebq(), this.nVj.eaJ(), this.nVj.eaN(), this.nVj.eaQ().eaU(), this.nUt, this.nVj.eaQ().eaT(), z, this.nVj.eaQ().ebb(), this.nVj.eaB());
        }
        return this.nUl;
    }

    public com.facebook.cache.disk.h ebs() {
        if (this.nVq == null) {
            this.nVq = this.nVj.eaz().a(this.nVj.eaO());
        }
        return this.nVq;
    }

    private com.facebook.imagepipeline.c.e ebt() {
        if (this.nUr == null) {
            this.nUr = new com.facebook.imagepipeline.c.e(ebs(), this.nVj.eaK().eda(), this.nVj.eaK().edb(), this.nVj.eaD().eao(), this.nVj.eaD().eap(), this.nVj.eaE());
        }
        return this.nUr;
    }
}
