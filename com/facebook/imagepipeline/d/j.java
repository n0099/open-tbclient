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
    private static final Class<?> mls = j.class;
    private static j mxz = null;
    private g mos;
    private com.facebook.imagepipeline.b.f msP;
    private m mwC;
    private com.facebook.imagepipeline.c.e mwH;
    private com.facebook.imagepipeline.c.e mwI;
    private final at mwK;
    private com.facebook.imagepipeline.decoder.b mwW;
    private final h mxA;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mxB;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mxC;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> mxD;
    private o<com.facebook.cache.common.b, PooledByteBuffer> mxE;
    private com.facebook.cache.disk.h mxF;
    private l mxG;
    private com.facebook.cache.disk.h mxH;
    private com.facebook.imagepipeline.i.e mxI;
    private com.facebook.imagepipeline.animated.a.a mxJ;

    public static j dzw() {
        return (j) com.facebook.common.internal.g.checkNotNull(mxz, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.fX(context).dzh());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (mxz != null) {
                com.facebook.common.c.a.g(mls, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            mxz = new j(hVar);
        }
    }

    public j(h hVar) {
        this.mxA = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.mwK = new at(hVar.dyT().dyI());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dzx() {
        if (this.mxJ == null) {
            this.mxJ = com.facebook.imagepipeline.animated.a.b.a(dzE(), this.mxA.dyT(), dzy());
        }
        return this.mxJ;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a fV(Context context) {
        com.facebook.imagepipeline.animated.a.a dzx = dzx();
        if (dzx == null) {
            return null;
        }
        return dzx.fV(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dzy() {
        if (this.mxB == null) {
            this.mxB = com.facebook.imagepipeline.c.a.a(this.mxA.dyM(), this.mxA.dyY(), this.mxA.dyN());
        }
        return this.mxB;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dzz() {
        if (this.mxC == null) {
            this.mxC = com.facebook.imagepipeline.c.b.a(dzy(), this.mxA.dyU());
        }
        return this.mxC;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dzA() {
        if (this.mxD == null) {
            this.mxD = com.facebook.imagepipeline.c.l.a(this.mxA.dyS(), this.mxA.dyY());
        }
        return this.mxD;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dzB() {
        if (this.mxE == null) {
            this.mxE = com.facebook.imagepipeline.c.m.a(dzA(), this.mxA.dyU());
        }
        return this.mxE;
    }

    private com.facebook.imagepipeline.decoder.b dyV() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.mwW == null) {
            if (this.mxA.dyV() != null) {
                this.mwW = this.mxA.dyV();
            } else {
                com.facebook.imagepipeline.animated.a.a dzx = dzx();
                if (dzx != null) {
                    bVar = dzx.a(this.mxA.dyv());
                    bVar2 = dzx.b(this.mxA.dyv());
                } else {
                    bVar = null;
                }
                if (this.mxA.dzf() == null) {
                    this.mwW = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dzF());
                } else {
                    this.mwW = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dzF(), this.mxA.dzf().dAj());
                    com.facebook.c.d.dxD().fd(this.mxA.dzf().dAk());
                }
            }
        }
        return this.mwW;
    }

    public com.facebook.imagepipeline.c.e dzC() {
        if (this.mwH == null) {
            this.mwH = new com.facebook.imagepipeline.c.e(dzD(), this.mxA.dza().dBq(), this.mxA.dza().dBr(), this.mxA.dyT().dyE(), this.mxA.dyT().dyF(), this.mxA.dyU());
        }
        return this.mwH;
    }

    public com.facebook.cache.disk.h dzD() {
        if (this.mxF == null) {
            this.mxF = this.mxA.dyP().a(this.mxA.dyX());
        }
        return this.mxF;
    }

    public g dvv() {
        if (this.mos == null) {
            this.mos = new g(dzH(), this.mxA.dzc(), this.mxA.dyW(), dzz(), dzB(), dzC(), dzJ(), this.mxA.dyL(), this.mwK, com.facebook.common.internal.k.aP(false), this.mxA.dzg().dzu());
        }
        return this.mos;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dBm());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dBq()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dzE() {
        if (this.msP == null) {
            this.msP = a(this.mxA.dza(), dzF());
        }
        return this.msP;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dBo = qVar.dBo();
            return new com.facebook.imagepipeline.i.a(qVar.dBm(), dBo, new Pools.SynchronizedPool(dBo));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dBn());
        }
    }

    public com.facebook.imagepipeline.i.e dzF() {
        if (this.mxI == null) {
            this.mxI = a(this.mxA.dza(), this.mxA.dzg().dzk());
        }
        return this.mxI;
    }

    private l dzG() {
        if (this.mxG == null) {
            this.mxG = this.mxA.dzg().dzs().a(this.mxA.getContext(), this.mxA.dza().dBs(), dyV(), this.mxA.dzb(), this.mxA.dyQ(), this.mxA.dzd(), this.mxA.dzg().dzl(), this.mxA.dyT(), this.mxA.dza().dBq(), dzz(), dzB(), dzC(), dzJ(), this.mxA.dyL(), dzE(), this.mxA.dzg().dzp(), this.mxA.dzg().dzq(), this.mxA.dzg().dzt());
        }
        return this.mxG;
    }

    private m dzH() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.mxA.dzg().dzo();
        if (this.mwC == null) {
            this.mwC = new m(this.mxA.getContext().getApplicationContext().getContentResolver(), dzG(), this.mxA.dyZ(), this.mxA.dzd(), this.mxA.dzg().dzk(), this.mwK, this.mxA.dzg().dzj(), z, this.mxA.dzg().dzr(), this.mxA.dyR());
        }
        return this.mwC;
    }

    public com.facebook.cache.disk.h dzI() {
        if (this.mxH == null) {
            this.mxH = this.mxA.dyP().a(this.mxA.dze());
        }
        return this.mxH;
    }

    private com.facebook.imagepipeline.c.e dzJ() {
        if (this.mwI == null) {
            this.mwI = new com.facebook.imagepipeline.c.e(dzI(), this.mxA.dza().dBq(), this.mxA.dza().dBr(), this.mxA.dyT().dyE(), this.mxA.dyT().dyF(), this.mxA.dyU());
        }
        return this.mwI;
    }
}
