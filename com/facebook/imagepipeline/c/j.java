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
    private static final Class<?> paD = j.class;
    private static j pml = null;
    private g pdB;
    private com.facebook.imagepipeline.a.f phJ;
    private com.facebook.imagepipeline.decoder.b plI;
    private m plo;
    private com.facebook.imagepipeline.b.e plt;
    private com.facebook.imagepipeline.b.e plu;
    private final at plw;
    private final h pmm;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pmn;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pmo;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> pmp;
    private o<com.facebook.cache.common.b, PooledByteBuffer> pmq;
    private com.facebook.cache.disk.h pmr;
    private l pms;
    private com.facebook.cache.disk.h pmt;
    private com.facebook.imagepipeline.h.e pmu;
    private com.facebook.imagepipeline.animated.a.a pmv;

    public static j euy() {
        return (j) com.facebook.common.internal.g.checkNotNull(pml, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.hJ(context).euj());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (pml != null) {
                com.facebook.common.c.a.g(paD, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            pml = new j(hVar);
        }
    }

    public j(h hVar) {
        this.pmm = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.plw = new at(hVar.etV().etK());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a euz() {
        if (this.pmv == null) {
            this.pmv = com.facebook.imagepipeline.animated.a.b.a(euG(), this.pmm.etV(), euA());
        }
        return this.pmv;
    }

    @Nullable
    public com.facebook.imagepipeline.e.a hH(Context context) {
        com.facebook.imagepipeline.animated.a.a euz = euz();
        if (euz == null) {
            return null;
        }
        return euz.hH(context);
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> euA() {
        if (this.pmn == null) {
            this.pmn = com.facebook.imagepipeline.b.a.a(this.pmm.etO(), this.pmm.eua(), this.pmm.etP());
        }
        return this.pmn;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> euB() {
        if (this.pmo == null) {
            this.pmo = com.facebook.imagepipeline.b.b.a(euA(), this.pmm.etW());
        }
        return this.pmo;
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> euC() {
        if (this.pmp == null) {
            this.pmp = com.facebook.imagepipeline.b.l.a(this.pmm.etU(), this.pmm.eua());
        }
        return this.pmp;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> euD() {
        if (this.pmq == null) {
            this.pmq = com.facebook.imagepipeline.b.m.a(euC(), this.pmm.etW());
        }
        return this.pmq;
    }

    private com.facebook.imagepipeline.decoder.b etX() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.plI == null) {
            if (this.pmm.etX() != null) {
                this.plI = this.pmm.etX();
            } else {
                com.facebook.imagepipeline.animated.a.a euz = euz();
                if (euz != null) {
                    bVar = euz.a(this.pmm.ety());
                    bVar2 = euz.b(this.pmm.ety());
                } else {
                    bVar = null;
                }
                if (this.pmm.euh() == null) {
                    this.plI = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, euH());
                } else {
                    this.plI = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, euH(), this.pmm.euh().evl());
                    com.facebook.c.d.esJ().gO(this.pmm.euh().evm());
                }
            }
        }
        return this.plI;
    }

    public com.facebook.imagepipeline.b.e euE() {
        if (this.plt == null) {
            this.plt = new com.facebook.imagepipeline.b.e(euF(), this.pmm.euc().ewp(), this.pmm.euc().ewq(), this.pmm.etV().etG(), this.pmm.etV().etH(), this.pmm.etW());
        }
        return this.plt;
    }

    public com.facebook.cache.disk.h euF() {
        if (this.pmr == null) {
            this.pmr = this.pmm.etR().a(this.pmm.etZ());
        }
        return this.pmr;
    }

    public g eqH() {
        if (this.pdB == null) {
            this.pdB = new g(euJ(), this.pmm.eue(), this.pmm.etY(), euB(), euD(), euE(), euL(), this.pmm.etN(), this.plw, com.facebook.common.internal.k.bc(false), this.pmm.eui().euw());
        }
        return this.pdB;
    }

    public static com.facebook.imagepipeline.a.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.a.a(qVar.ewl());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.a.e(new com.facebook.imagepipeline.a.b(qVar.ewp()), eVar);
        }
        return new com.facebook.imagepipeline.a.c();
    }

    public com.facebook.imagepipeline.a.f euG() {
        if (this.phJ == null) {
            this.phJ = a(this.pmm.euc(), euH());
        }
        return this.phJ;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int ewn = qVar.ewn();
            return new com.facebook.imagepipeline.h.a(qVar.ewl(), ewn, new Pools.SynchronizedPool(ewn));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.ewm());
        }
    }

    public com.facebook.imagepipeline.h.e euH() {
        if (this.pmu == null) {
            this.pmu = a(this.pmm.euc(), this.pmm.eui().eum());
        }
        return this.pmu;
    }

    private l euI() {
        if (this.pms == null) {
            this.pms = this.pmm.eui().euu().a(this.pmm.getContext(), this.pmm.euc().ewr(), etX(), this.pmm.eud(), this.pmm.etS(), this.pmm.euf(), this.pmm.eui().eun(), this.pmm.etV(), this.pmm.euc().ewp(), euB(), euD(), euE(), euL(), this.pmm.etN(), euG(), this.pmm.eui().eur(), this.pmm.eui().eus(), this.pmm.eui().euv());
        }
        return this.pms;
    }

    private m euJ() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.pmm.eui().euq();
        if (this.plo == null) {
            this.plo = new m(this.pmm.getContext().getApplicationContext().getContentResolver(), euI(), this.pmm.eub(), this.pmm.euf(), this.pmm.eui().eum(), this.plw, this.pmm.eui().eul(), z, this.pmm.eui().eut(), this.pmm.etT());
        }
        return this.plo;
    }

    public com.facebook.cache.disk.h euK() {
        if (this.pmt == null) {
            this.pmt = this.pmm.etR().a(this.pmm.eug());
        }
        return this.pmt;
    }

    private com.facebook.imagepipeline.b.e euL() {
        if (this.plu == null) {
            this.plu = new com.facebook.imagepipeline.b.e(euK(), this.pmm.euc().ewp(), this.pmm.euc().ewq(), this.pmm.etV().etG(), this.pmm.etV().etH(), this.pmm.etW());
        }
        return this.plu;
    }
}
