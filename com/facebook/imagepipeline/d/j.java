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
    private static final Class<?> oAy = j.class;
    private static j oMA = null;
    private g oDx;
    private com.facebook.imagepipeline.b.f oHR;
    private m oLD;
    private com.facebook.imagepipeline.c.e oLI;
    private com.facebook.imagepipeline.c.e oLJ;
    private final at oLL;
    private com.facebook.imagepipeline.decoder.b oLX;
    private final h oMB;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oMC;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oMD;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> oME;
    private o<com.facebook.cache.common.b, PooledByteBuffer> oMF;
    private com.facebook.cache.disk.h oMG;
    private l oMH;
    private com.facebook.cache.disk.h oMI;
    private com.facebook.imagepipeline.i.e oMJ;
    private com.facebook.imagepipeline.animated.a.a oMK;

    public static j ele() {
        return (j) com.facebook.common.internal.g.checkNotNull(oMA, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.hc(context).ekP());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (oMA != null) {
                com.facebook.common.c.a.g(oAy, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            oMA = new j(hVar);
        }
    }

    public j(h hVar) {
        this.oMB = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.oLL = new at(hVar.ekB().ekq());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a elf() {
        if (this.oMK == null) {
            this.oMK = com.facebook.imagepipeline.animated.a.b.a(elm(), this.oMB.ekB(), elg());
        }
        return this.oMK;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a ha(Context context) {
        com.facebook.imagepipeline.animated.a.a elf = elf();
        if (elf == null) {
            return null;
        }
        return elf.ha(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> elg() {
        if (this.oMC == null) {
            this.oMC = com.facebook.imagepipeline.c.a.a(this.oMB.eku(), this.oMB.ekG(), this.oMB.ekv());
        }
        return this.oMC;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> elh() {
        if (this.oMD == null) {
            this.oMD = com.facebook.imagepipeline.c.b.a(elg(), this.oMB.ekC());
        }
        return this.oMD;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> eli() {
        if (this.oME == null) {
            this.oME = com.facebook.imagepipeline.c.l.a(this.oMB.ekA(), this.oMB.ekG());
        }
        return this.oME;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> elj() {
        if (this.oMF == null) {
            this.oMF = com.facebook.imagepipeline.c.m.a(eli(), this.oMB.ekC());
        }
        return this.oMF;
    }

    private com.facebook.imagepipeline.decoder.b ekD() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.oLX == null) {
            if (this.oMB.ekD() != null) {
                this.oLX = this.oMB.ekD();
            } else {
                com.facebook.imagepipeline.animated.a.a elf = elf();
                if (elf != null) {
                    bVar = elf.a(this.oMB.ekd());
                    bVar2 = elf.b(this.oMB.ekd());
                } else {
                    bVar = null;
                }
                if (this.oMB.ekN() == null) {
                    this.oLX = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, eln());
                } else {
                    this.oLX = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, eln(), this.oMB.ekN().elR());
                    com.facebook.c.d.ejl().gq(this.oMB.ekN().elS());
                }
            }
        }
        return this.oLX;
    }

    public com.facebook.imagepipeline.c.e elk() {
        if (this.oLI == null) {
            this.oLI = new com.facebook.imagepipeline.c.e(ell(), this.oMB.ekI().emY(), this.oMB.ekI().emZ(), this.oMB.ekB().ekm(), this.oMB.ekB().ekn(), this.oMB.ekC());
        }
        return this.oLI;
    }

    public com.facebook.cache.disk.h ell() {
        if (this.oMG == null) {
            this.oMG = this.oMB.ekx().a(this.oMB.ekF());
        }
        return this.oMG;
    }

    public g ehf() {
        if (this.oDx == null) {
            this.oDx = new g(elp(), this.oMB.ekK(), this.oMB.ekE(), elh(), elj(), elk(), elr(), this.oMB.ekt(), this.oLL, com.facebook.common.internal.k.bb(false), this.oMB.ekO().elc());
        }
        return this.oDx;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.emU());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.emY()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f elm() {
        if (this.oHR == null) {
            this.oHR = a(this.oMB.ekI(), eln());
        }
        return this.oHR;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int emW = qVar.emW();
            return new com.facebook.imagepipeline.i.a(qVar.emU(), emW, new Pools.SynchronizedPool(emW));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.emV());
        }
    }

    public com.facebook.imagepipeline.i.e eln() {
        if (this.oMJ == null) {
            this.oMJ = a(this.oMB.ekI(), this.oMB.ekO().ekS());
        }
        return this.oMJ;
    }

    private l elo() {
        if (this.oMH == null) {
            this.oMH = this.oMB.ekO().ela().a(this.oMB.getContext(), this.oMB.ekI().ena(), ekD(), this.oMB.ekJ(), this.oMB.eky(), this.oMB.ekL(), this.oMB.ekO().ekT(), this.oMB.ekB(), this.oMB.ekI().emY(), elh(), elj(), elk(), elr(), this.oMB.ekt(), elm(), this.oMB.ekO().ekX(), this.oMB.ekO().ekY(), this.oMB.ekO().elb());
        }
        return this.oMH;
    }

    private m elp() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.oMB.ekO().ekW();
        if (this.oLD == null) {
            this.oLD = new m(this.oMB.getContext().getApplicationContext().getContentResolver(), elo(), this.oMB.ekH(), this.oMB.ekL(), this.oMB.ekO().ekS(), this.oLL, this.oMB.ekO().ekR(), z, this.oMB.ekO().ekZ(), this.oMB.ekz());
        }
        return this.oLD;
    }

    public com.facebook.cache.disk.h elq() {
        if (this.oMI == null) {
            this.oMI = this.oMB.ekx().a(this.oMB.ekM());
        }
        return this.oMI;
    }

    private com.facebook.imagepipeline.c.e elr() {
        if (this.oLJ == null) {
            this.oLJ = new com.facebook.imagepipeline.c.e(elq(), this.oMB.ekI().emY(), this.oMB.ekI().emZ(), this.oMB.ekB().ekm(), this.oMB.ekB().ekn(), this.oMB.ekC());
        }
        return this.oLJ;
    }
}
