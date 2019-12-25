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
/* loaded from: classes9.dex */
public class j {
    private static final Class<?> lCO = j.class;
    private static j lOq = null;
    private g lFO;
    private com.facebook.imagepipeline.b.f lJL;
    private final at lNB;
    private com.facebook.imagepipeline.decoder.b lNN;
    private m lNt;
    private com.facebook.imagepipeline.c.e lNy;
    private com.facebook.imagepipeline.c.e lNz;
    private com.facebook.imagepipeline.animated.a.a lOA;
    private final h lOr;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lOs;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lOt;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> lOu;
    private o<com.facebook.cache.common.b, PooledByteBuffer> lOv;
    private com.facebook.cache.disk.h lOw;
    private l lOx;
    private com.facebook.cache.disk.h lOy;
    private com.facebook.imagepipeline.i.e lOz;

    public static j dmZ() {
        return (j) com.facebook.common.internal.g.checkNotNull(lOq, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gn(context).dmK());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (lOq != null) {
                com.facebook.common.c.a.g(lCO, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            lOq = new j(hVar);
        }
    }

    public j(h hVar) {
        this.lOr = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.lNB = new at(hVar.dmw().dmk());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dna() {
        if (this.lOA == null) {
            this.lOA = com.facebook.imagepipeline.animated.a.b.a(dnh(), this.lOr.dmw(), dnb());
        }
        return this.lOA;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gm(Context context) {
        com.facebook.imagepipeline.animated.a.a dna = dna();
        if (dna == null) {
            return null;
        }
        return dna.gm(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dnb() {
        if (this.lOs == null) {
            this.lOs = com.facebook.imagepipeline.c.a.a(this.lOr.dmp(), this.lOr.dmB(), this.lOr.dmq());
        }
        return this.lOs;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dnc() {
        if (this.lOt == null) {
            this.lOt = com.facebook.imagepipeline.c.b.a(dnb(), this.lOr.dmx());
        }
        return this.lOt;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dnd() {
        if (this.lOu == null) {
            this.lOu = com.facebook.imagepipeline.c.l.a(this.lOr.dmv(), this.lOr.dmB());
        }
        return this.lOu;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dne() {
        if (this.lOv == null) {
            this.lOv = com.facebook.imagepipeline.c.m.a(dnd(), this.lOr.dmx());
        }
        return this.lOv;
    }

    private com.facebook.imagepipeline.decoder.b dmy() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.lNN == null) {
            if (this.lOr.dmy() != null) {
                this.lNN = this.lOr.dmy();
            } else {
                com.facebook.imagepipeline.animated.a.a dna = dna();
                if (dna != null) {
                    bVar = dna.a(this.lOr.dlY());
                    bVar2 = dna.b(this.lOr.dlY());
                } else {
                    bVar = null;
                }
                if (this.lOr.dmI() == null) {
                    this.lNN = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dni());
                } else {
                    this.lNN = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dni(), this.lOr.dmI().dnN());
                    com.facebook.c.d.dli().eY(this.lOr.dmI().dnO());
                }
            }
        }
        return this.lNN;
    }

    public com.facebook.imagepipeline.c.e dnf() {
        if (this.lNy == null) {
            this.lNy = new com.facebook.imagepipeline.c.e(dng(), this.lOr.dmD().doS(), this.lOr.dmD().doT(), this.lOr.dmw().dmg(), this.lOr.dmw().dmh(), this.lOr.dmx());
        }
        return this.lNy;
    }

    public com.facebook.cache.disk.h dng() {
        if (this.lOw == null) {
            this.lOw = this.lOr.dms().a(this.lOr.dmA());
        }
        return this.lOw;
    }

    public g dji() {
        if (this.lFO == null) {
            this.lFO = new g(dnk(), this.lOr.dmF(), this.lOr.dmz(), dnc(), dne(), dnf(), dnm(), this.lOr.dmo(), this.lNB, com.facebook.common.internal.k.aS(false), this.lOr.dmJ().dmX());
        }
        return this.lFO;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.doO());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.doS()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dnh() {
        if (this.lJL == null) {
            this.lJL = a(this.lOr.dmD(), dni());
        }
        return this.lJL;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int doQ = qVar.doQ();
            return new com.facebook.imagepipeline.i.a(qVar.doO(), doQ, new Pools.SynchronizedPool(doQ));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.doP());
        }
    }

    public com.facebook.imagepipeline.i.e dni() {
        if (this.lOz == null) {
            this.lOz = a(this.lOr.dmD(), this.lOr.dmJ().dmN());
        }
        return this.lOz;
    }

    private l dnj() {
        if (this.lOx == null) {
            this.lOx = this.lOr.dmJ().dmV().a(this.lOr.getContext(), this.lOr.dmD().doU(), dmy(), this.lOr.dmE(), this.lOr.dmt(), this.lOr.dmG(), this.lOr.dmJ().dmO(), this.lOr.dmw(), this.lOr.dmD().doS(), dnc(), dne(), dnf(), dnm(), this.lOr.dmo(), dnh(), this.lOr.dmJ().dmS(), this.lOr.dmJ().dmT(), this.lOr.dmJ().dmW());
        }
        return this.lOx;
    }

    private m dnk() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.lOr.dmJ().dmR();
        if (this.lNt == null) {
            this.lNt = new m(this.lOr.getContext().getApplicationContext().getContentResolver(), dnj(), this.lOr.dmC(), this.lOr.dmG(), this.lOr.dmJ().dmN(), this.lNB, this.lOr.dmJ().dmM(), z, this.lOr.dmJ().dmU(), this.lOr.dmu());
        }
        return this.lNt;
    }

    public com.facebook.cache.disk.h dnl() {
        if (this.lOy == null) {
            this.lOy = this.lOr.dms().a(this.lOr.dmH());
        }
        return this.lOy;
    }

    private com.facebook.imagepipeline.c.e dnm() {
        if (this.lNz == null) {
            this.lNz = new com.facebook.imagepipeline.c.e(dnl(), this.lOr.dmD().doS(), this.lOr.dmD().doT(), this.lOr.dmw().dmg(), this.lOr.dmw().dmh(), this.lOr.dmx());
        }
        return this.lNz;
    }
}
