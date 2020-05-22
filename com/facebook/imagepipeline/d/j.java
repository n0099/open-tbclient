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
    private static final Class<?> mki = j.class;
    private static j mwp = null;
    private g mnh;
    private com.facebook.imagepipeline.b.f mrE;
    private final at mvA;
    private com.facebook.imagepipeline.decoder.b mvM;
    private m mvs;
    private com.facebook.imagepipeline.c.e mvx;
    private com.facebook.imagepipeline.c.e mvy;
    private final h mwq;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mwr;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mws;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> mwt;
    private o<com.facebook.cache.common.b, PooledByteBuffer> mwu;
    private com.facebook.cache.disk.h mwv;
    private l mww;
    private com.facebook.cache.disk.h mwx;
    private com.facebook.imagepipeline.i.e mwy;
    private com.facebook.imagepipeline.animated.a.a mwz;

    public static j dzi() {
        return (j) com.facebook.common.internal.g.checkNotNull(mwp, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.fX(context).dyT());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (mwp != null) {
                com.facebook.common.c.a.g(mki, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            mwp = new j(hVar);
        }
    }

    public j(h hVar) {
        this.mwq = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.mvA = new at(hVar.dyF().dyu());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dzj() {
        if (this.mwz == null) {
            this.mwz = com.facebook.imagepipeline.animated.a.b.a(dzq(), this.mwq.dyF(), dzk());
        }
        return this.mwz;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a fV(Context context) {
        com.facebook.imagepipeline.animated.a.a dzj = dzj();
        if (dzj == null) {
            return null;
        }
        return dzj.fV(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dzk() {
        if (this.mwr == null) {
            this.mwr = com.facebook.imagepipeline.c.a.a(this.mwq.dyy(), this.mwq.dyK(), this.mwq.dyz());
        }
        return this.mwr;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dzl() {
        if (this.mws == null) {
            this.mws = com.facebook.imagepipeline.c.b.a(dzk(), this.mwq.dyG());
        }
        return this.mws;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dzm() {
        if (this.mwt == null) {
            this.mwt = com.facebook.imagepipeline.c.l.a(this.mwq.dyE(), this.mwq.dyK());
        }
        return this.mwt;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dzn() {
        if (this.mwu == null) {
            this.mwu = com.facebook.imagepipeline.c.m.a(dzm(), this.mwq.dyG());
        }
        return this.mwu;
    }

    private com.facebook.imagepipeline.decoder.b dyH() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.mvM == null) {
            if (this.mwq.dyH() != null) {
                this.mvM = this.mwq.dyH();
            } else {
                com.facebook.imagepipeline.animated.a.a dzj = dzj();
                if (dzj != null) {
                    bVar = dzj.a(this.mwq.dyh());
                    bVar2 = dzj.b(this.mwq.dyh());
                } else {
                    bVar = null;
                }
                if (this.mwq.dyR() == null) {
                    this.mvM = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dzr());
                } else {
                    this.mvM = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dzr(), this.mwq.dyR().dzV());
                    com.facebook.c.d.dxp().fb(this.mwq.dyR().dzW());
                }
            }
        }
        return this.mvM;
    }

    public com.facebook.imagepipeline.c.e dzo() {
        if (this.mvx == null) {
            this.mvx = new com.facebook.imagepipeline.c.e(dzp(), this.mwq.dyM().dBc(), this.mwq.dyM().dBd(), this.mwq.dyF().dyq(), this.mwq.dyF().dyr(), this.mwq.dyG());
        }
        return this.mvx;
    }

    public com.facebook.cache.disk.h dzp() {
        if (this.mwv == null) {
            this.mwv = this.mwq.dyB().a(this.mwq.dyJ());
        }
        return this.mwv;
    }

    public g dvh() {
        if (this.mnh == null) {
            this.mnh = new g(dzt(), this.mwq.dyO(), this.mwq.dyI(), dzl(), dzn(), dzo(), dzv(), this.mwq.dyx(), this.mvA, com.facebook.common.internal.k.aP(false), this.mwq.dyS().dzg());
        }
        return this.mnh;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dAY());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dBc()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dzq() {
        if (this.mrE == null) {
            this.mrE = a(this.mwq.dyM(), dzr());
        }
        return this.mrE;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dBa = qVar.dBa();
            return new com.facebook.imagepipeline.i.a(qVar.dAY(), dBa, new Pools.SynchronizedPool(dBa));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dAZ());
        }
    }

    public com.facebook.imagepipeline.i.e dzr() {
        if (this.mwy == null) {
            this.mwy = a(this.mwq.dyM(), this.mwq.dyS().dyW());
        }
        return this.mwy;
    }

    private l dzs() {
        if (this.mww == null) {
            this.mww = this.mwq.dyS().dze().a(this.mwq.getContext(), this.mwq.dyM().dBe(), dyH(), this.mwq.dyN(), this.mwq.dyC(), this.mwq.dyP(), this.mwq.dyS().dyX(), this.mwq.dyF(), this.mwq.dyM().dBc(), dzl(), dzn(), dzo(), dzv(), this.mwq.dyx(), dzq(), this.mwq.dyS().dzb(), this.mwq.dyS().dzc(), this.mwq.dyS().dzf());
        }
        return this.mww;
    }

    private m dzt() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.mwq.dyS().dza();
        if (this.mvs == null) {
            this.mvs = new m(this.mwq.getContext().getApplicationContext().getContentResolver(), dzs(), this.mwq.dyL(), this.mwq.dyP(), this.mwq.dyS().dyW(), this.mvA, this.mwq.dyS().dyV(), z, this.mwq.dyS().dzd(), this.mwq.dyD());
        }
        return this.mvs;
    }

    public com.facebook.cache.disk.h dzu() {
        if (this.mwx == null) {
            this.mwx = this.mwq.dyB().a(this.mwq.dyQ());
        }
        return this.mwx;
    }

    private com.facebook.imagepipeline.c.e dzv() {
        if (this.mvy == null) {
            this.mvy = new com.facebook.imagepipeline.c.e(dzu(), this.mwq.dyM().dBc(), this.mwq.dyM().dBd(), this.mwq.dyF().dyq(), this.mwq.dyF().dyr(), this.mwq.dyG());
        }
        return this.mvy;
    }
}
