package com.facebook.imagepipeline.c;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.o;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.at;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
public class j {
    private static final Class<?> paF = j.class;
    private static j pmn = null;
    private g pdD;
    private com.facebook.imagepipeline.a.f phL;
    private com.facebook.imagepipeline.decoder.b plK;
    private m plq;
    private com.facebook.imagepipeline.b.e plv;
    private com.facebook.imagepipeline.b.e plw;
    private final at ply;
    private final h pmo;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pmp;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pmq;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> pmr;
    private o<com.facebook.cache.common.b, PooledByteBuffer> pms;
    private com.facebook.cache.disk.h pmt;
    private l pmu;
    private com.facebook.cache.disk.h pmv;
    private com.facebook.imagepipeline.h.e pmw;
    private com.facebook.imagepipeline.animated.a.a pmx;

    public static j euz() {
        return (j) com.facebook.common.internal.g.checkNotNull(pmn, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.hJ(context).euk());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (pmn != null) {
                com.facebook.common.c.a.g(paF, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            pmn = new j(hVar);
        }
    }

    public j(h hVar) {
        this.pmo = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.ply = new at(hVar.etW().etL());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a euA() {
        if (this.pmx == null) {
            this.pmx = com.facebook.imagepipeline.animated.a.b.a(euH(), this.pmo.etW(), euB());
        }
        return this.pmx;
    }

    @Nullable
    public com.facebook.imagepipeline.e.a hH(Context context) {
        com.facebook.imagepipeline.animated.a.a euA = euA();
        if (euA == null) {
            return null;
        }
        return euA.hH(context);
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> euB() {
        if (this.pmp == null) {
            this.pmp = com.facebook.imagepipeline.b.a.a(this.pmo.etP(), this.pmo.eub(), this.pmo.etQ());
        }
        return this.pmp;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> euC() {
        if (this.pmq == null) {
            this.pmq = com.facebook.imagepipeline.b.b.a(euB(), this.pmo.etX());
        }
        return this.pmq;
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> euD() {
        if (this.pmr == null) {
            this.pmr = com.facebook.imagepipeline.b.l.a(this.pmo.etV(), this.pmo.eub());
        }
        return this.pmr;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> euE() {
        if (this.pms == null) {
            this.pms = com.facebook.imagepipeline.b.m.a(euD(), this.pmo.etX());
        }
        return this.pms;
    }

    private com.facebook.imagepipeline.decoder.b etY() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.plK == null) {
            if (this.pmo.etY() != null) {
                this.plK = this.pmo.etY();
            } else {
                com.facebook.imagepipeline.animated.a.a euA = euA();
                if (euA != null) {
                    bVar = euA.a(this.pmo.etz());
                    bVar2 = euA.b(this.pmo.etz());
                } else {
                    bVar = null;
                }
                if (this.pmo.eui() == null) {
                    this.plK = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, euI());
                } else {
                    this.plK = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, euI(), this.pmo.eui().evm());
                    com.facebook.c.d.esK().gO(this.pmo.eui().evn());
                }
            }
        }
        return this.plK;
    }

    public com.facebook.imagepipeline.b.e euF() {
        if (this.plv == null) {
            this.plv = new com.facebook.imagepipeline.b.e(euG(), this.pmo.eud().ewq(), this.pmo.eud().ewr(), this.pmo.etW().etH(), this.pmo.etW().etI(), this.pmo.etX());
        }
        return this.plv;
    }

    public com.facebook.cache.disk.h euG() {
        if (this.pmt == null) {
            this.pmt = this.pmo.etS().a(this.pmo.eua());
        }
        return this.pmt;
    }

    public g eqI() {
        if (this.pdD == null) {
            this.pdD = new g(euK(), this.pmo.euf(), this.pmo.etZ(), euC(), euE(), euF(), euM(), this.pmo.etO(), this.ply, com.facebook.common.internal.k.bc(false), this.pmo.euj().eux());
        }
        return this.pdD;
    }

    public static com.facebook.imagepipeline.a.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.a.a(qVar.ewm());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.a.e(new com.facebook.imagepipeline.a.b(qVar.ewq()), eVar);
        }
        return new com.facebook.imagepipeline.a.c();
    }

    public com.facebook.imagepipeline.a.f euH() {
        if (this.phL == null) {
            this.phL = a(this.pmo.eud(), euI());
        }
        return this.phL;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int ewo = qVar.ewo();
            return new com.facebook.imagepipeline.h.a(qVar.ewm(), ewo, new Pools.SynchronizedPool(ewo));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.ewn());
        }
    }

    public com.facebook.imagepipeline.h.e euI() {
        if (this.pmw == null) {
            this.pmw = a(this.pmo.eud(), this.pmo.euj().eun());
        }
        return this.pmw;
    }

    private l euJ() {
        if (this.pmu == null) {
            this.pmu = this.pmo.euj().euv().a(this.pmo.getContext(), this.pmo.eud().ews(), etY(), this.pmo.eue(), this.pmo.etT(), this.pmo.eug(), this.pmo.euj().euo(), this.pmo.etW(), this.pmo.eud().ewq(), euC(), euE(), euF(), euM(), this.pmo.etO(), euH(), this.pmo.euj().eus(), this.pmo.euj().eut(), this.pmo.euj().euw());
        }
        return this.pmu;
    }

    private m euK() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.pmo.euj().eur();
        if (this.plq == null) {
            this.plq = new m(this.pmo.getContext().getApplicationContext().getContentResolver(), euJ(), this.pmo.euc(), this.pmo.eug(), this.pmo.euj().eun(), this.ply, this.pmo.euj().eum(), z, this.pmo.euj().euu(), this.pmo.etU());
        }
        return this.plq;
    }

    public com.facebook.cache.disk.h euL() {
        if (this.pmv == null) {
            this.pmv = this.pmo.etS().a(this.pmo.euh());
        }
        return this.pmv;
    }

    private com.facebook.imagepipeline.b.e euM() {
        if (this.plw == null) {
            this.plw = new com.facebook.imagepipeline.b.e(euL(), this.pmo.eud().ewq(), this.pmo.eud().ewr(), this.pmo.etW().etH(), this.pmo.etW().etI(), this.pmo.etX());
        }
        return this.plw;
    }
}
