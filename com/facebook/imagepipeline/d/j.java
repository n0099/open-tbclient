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
    private static final Class<?> lQm = j.class;
    private static j mcu = null;
    private g lTl;
    private com.facebook.imagepipeline.b.f lXG;
    private com.facebook.imagepipeline.c.e mbC;
    private com.facebook.imagepipeline.c.e mbD;
    private final at mbF;
    private com.facebook.imagepipeline.decoder.b mbR;
    private m mbx;
    private com.facebook.cache.disk.h mcA;
    private l mcB;
    private com.facebook.cache.disk.h mcC;
    private com.facebook.imagepipeline.i.e mcD;
    private com.facebook.imagepipeline.animated.a.a mcE;
    private final h mcv;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mcw;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mcx;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> mcy;
    private o<com.facebook.cache.common.b, PooledByteBuffer> mcz;

    public static j drS() {
        return (j) com.facebook.common.internal.g.checkNotNull(mcu, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.fR(context).drD());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (mcu != null) {
                com.facebook.common.c.a.g(lQm, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            mcu = new j(hVar);
        }
    }

    public j(h hVar) {
        this.mcv = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.mbF = new at(hVar.drp().dre());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a drT() {
        if (this.mcE == null) {
            this.mcE = com.facebook.imagepipeline.animated.a.b.a(dsa(), this.mcv.drp(), drU());
        }
        return this.mcE;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a fP(Context context) {
        com.facebook.imagepipeline.animated.a.a drT = drT();
        if (drT == null) {
            return null;
        }
        return drT.fP(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> drU() {
        if (this.mcw == null) {
            this.mcw = com.facebook.imagepipeline.c.a.a(this.mcv.dri(), this.mcv.dru(), this.mcv.drj());
        }
        return this.mcw;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> drV() {
        if (this.mcx == null) {
            this.mcx = com.facebook.imagepipeline.c.b.a(drU(), this.mcv.drq());
        }
        return this.mcx;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> drW() {
        if (this.mcy == null) {
            this.mcy = com.facebook.imagepipeline.c.l.a(this.mcv.dro(), this.mcv.dru());
        }
        return this.mcy;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> drX() {
        if (this.mcz == null) {
            this.mcz = com.facebook.imagepipeline.c.m.a(drW(), this.mcv.drq());
        }
        return this.mcz;
    }

    private com.facebook.imagepipeline.decoder.b drr() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.mbR == null) {
            if (this.mcv.drr() != null) {
                this.mbR = this.mcv.drr();
            } else {
                com.facebook.imagepipeline.animated.a.a drT = drT();
                if (drT != null) {
                    bVar = drT.a(this.mcv.dqR());
                    bVar2 = drT.b(this.mcv.dqR());
                } else {
                    bVar = null;
                }
                if (this.mcv.drB() == null) {
                    this.mbR = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dsb());
                } else {
                    this.mbR = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dsb(), this.mcv.drB().dsF());
                    com.facebook.c.d.dpZ().eU(this.mcv.drB().dsG());
                }
            }
        }
        return this.mbR;
    }

    public com.facebook.imagepipeline.c.e drY() {
        if (this.mbC == null) {
            this.mbC = new com.facebook.imagepipeline.c.e(drZ(), this.mcv.drw().dtN(), this.mcv.drw().dtO(), this.mcv.drp().dra(), this.mcv.drp().drb(), this.mcv.drq());
        }
        return this.mbC;
    }

    public com.facebook.cache.disk.h drZ() {
        if (this.mcA == null) {
            this.mcA = this.mcv.drl().a(this.mcv.drt());
        }
        return this.mcA;
    }

    public g dnR() {
        if (this.lTl == null) {
            this.lTl = new g(dsd(), this.mcv.dry(), this.mcv.drs(), drV(), drX(), drY(), dsf(), this.mcv.drh(), this.mbF, com.facebook.common.internal.k.aK(false), this.mcv.drC().drQ());
        }
        return this.lTl;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dtJ());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dtN()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dsa() {
        if (this.lXG == null) {
            this.lXG = a(this.mcv.drw(), dsb());
        }
        return this.lXG;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dtL = qVar.dtL();
            return new com.facebook.imagepipeline.i.a(qVar.dtJ(), dtL, new Pools.SynchronizedPool(dtL));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dtK());
        }
    }

    public com.facebook.imagepipeline.i.e dsb() {
        if (this.mcD == null) {
            this.mcD = a(this.mcv.drw(), this.mcv.drC().drG());
        }
        return this.mcD;
    }

    private l dsc() {
        if (this.mcB == null) {
            this.mcB = this.mcv.drC().drO().a(this.mcv.getContext(), this.mcv.drw().dtP(), drr(), this.mcv.drx(), this.mcv.drm(), this.mcv.drz(), this.mcv.drC().drH(), this.mcv.drp(), this.mcv.drw().dtN(), drV(), drX(), drY(), dsf(), this.mcv.drh(), dsa(), this.mcv.drC().drL(), this.mcv.drC().drM(), this.mcv.drC().drP());
        }
        return this.mcB;
    }

    private m dsd() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.mcv.drC().drK();
        if (this.mbx == null) {
            this.mbx = new m(this.mcv.getContext().getApplicationContext().getContentResolver(), dsc(), this.mcv.drv(), this.mcv.drz(), this.mcv.drC().drG(), this.mbF, this.mcv.drC().drF(), z, this.mcv.drC().drN(), this.mcv.drn());
        }
        return this.mbx;
    }

    public com.facebook.cache.disk.h dse() {
        if (this.mcC == null) {
            this.mcC = this.mcv.drl().a(this.mcv.drA());
        }
        return this.mcC;
    }

    private com.facebook.imagepipeline.c.e dsf() {
        if (this.mbD == null) {
            this.mbD = new com.facebook.imagepipeline.c.e(dse(), this.mcv.drw().dtN(), this.mcv.drw().dtO(), this.mcv.drp().dra(), this.mcv.drp().drb(), this.mcv.drq());
        }
        return this.mbD;
    }
}
