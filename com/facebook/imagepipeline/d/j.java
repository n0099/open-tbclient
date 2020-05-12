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
    private static final Class<?> lQq = j.class;
    private static j mcy = null;
    private g lTp;
    private com.facebook.imagepipeline.b.f lXK;
    private m mbB;
    private com.facebook.imagepipeline.c.e mbG;
    private com.facebook.imagepipeline.c.e mbH;
    private final at mbJ;
    private com.facebook.imagepipeline.decoder.b mbV;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mcA;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mcB;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> mcC;
    private o<com.facebook.cache.common.b, PooledByteBuffer> mcD;
    private com.facebook.cache.disk.h mcE;
    private l mcF;
    private com.facebook.cache.disk.h mcG;
    private com.facebook.imagepipeline.i.e mcH;
    private com.facebook.imagepipeline.animated.a.a mcI;
    private final h mcz;

    public static j drQ() {
        return (j) com.facebook.common.internal.g.checkNotNull(mcy, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.fF(context).drB());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (mcy != null) {
                com.facebook.common.c.a.g(lQq, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            mcy = new j(hVar);
        }
    }

    public j(h hVar) {
        this.mcz = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.mbJ = new at(hVar.drn().drc());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a drR() {
        if (this.mcI == null) {
            this.mcI = com.facebook.imagepipeline.animated.a.b.a(drY(), this.mcz.drn(), drS());
        }
        return this.mcI;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a fD(Context context) {
        com.facebook.imagepipeline.animated.a.a drR = drR();
        if (drR == null) {
            return null;
        }
        return drR.fD(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> drS() {
        if (this.mcA == null) {
            this.mcA = com.facebook.imagepipeline.c.a.a(this.mcz.drg(), this.mcz.drs(), this.mcz.drh());
        }
        return this.mcA;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> drT() {
        if (this.mcB == null) {
            this.mcB = com.facebook.imagepipeline.c.b.a(drS(), this.mcz.dro());
        }
        return this.mcB;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> drU() {
        if (this.mcC == null) {
            this.mcC = com.facebook.imagepipeline.c.l.a(this.mcz.drm(), this.mcz.drs());
        }
        return this.mcC;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> drV() {
        if (this.mcD == null) {
            this.mcD = com.facebook.imagepipeline.c.m.a(drU(), this.mcz.dro());
        }
        return this.mcD;
    }

    private com.facebook.imagepipeline.decoder.b drp() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.mbV == null) {
            if (this.mcz.drp() != null) {
                this.mbV = this.mcz.drp();
            } else {
                com.facebook.imagepipeline.animated.a.a drR = drR();
                if (drR != null) {
                    bVar = drR.a(this.mcz.dqP());
                    bVar2 = drR.b(this.mcz.dqP());
                } else {
                    bVar = null;
                }
                if (this.mcz.drz() == null) {
                    this.mbV = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, drZ());
                } else {
                    this.mbV = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, drZ(), this.mcz.drz().dsD());
                    com.facebook.c.d.dpX().eU(this.mcz.drz().dsE());
                }
            }
        }
        return this.mbV;
    }

    public com.facebook.imagepipeline.c.e drW() {
        if (this.mbG == null) {
            this.mbG = new com.facebook.imagepipeline.c.e(drX(), this.mcz.dru().dtL(), this.mcz.dru().dtM(), this.mcz.drn().dqY(), this.mcz.drn().dqZ(), this.mcz.dro());
        }
        return this.mbG;
    }

    public com.facebook.cache.disk.h drX() {
        if (this.mcE == null) {
            this.mcE = this.mcz.drj().a(this.mcz.drr());
        }
        return this.mcE;
    }

    public g dnP() {
        if (this.lTp == null) {
            this.lTp = new g(dsb(), this.mcz.drw(), this.mcz.drq(), drT(), drV(), drW(), dsd(), this.mcz.drf(), this.mbJ, com.facebook.common.internal.k.aL(false), this.mcz.drA().drO());
        }
        return this.lTp;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dtH());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dtL()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f drY() {
        if (this.lXK == null) {
            this.lXK = a(this.mcz.dru(), drZ());
        }
        return this.lXK;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dtJ = qVar.dtJ();
            return new com.facebook.imagepipeline.i.a(qVar.dtH(), dtJ, new Pools.SynchronizedPool(dtJ));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dtI());
        }
    }

    public com.facebook.imagepipeline.i.e drZ() {
        if (this.mcH == null) {
            this.mcH = a(this.mcz.dru(), this.mcz.drA().drE());
        }
        return this.mcH;
    }

    private l dsa() {
        if (this.mcF == null) {
            this.mcF = this.mcz.drA().drM().a(this.mcz.getContext(), this.mcz.dru().dtN(), drp(), this.mcz.drv(), this.mcz.drk(), this.mcz.drx(), this.mcz.drA().drF(), this.mcz.drn(), this.mcz.dru().dtL(), drT(), drV(), drW(), dsd(), this.mcz.drf(), drY(), this.mcz.drA().drJ(), this.mcz.drA().drK(), this.mcz.drA().drN());
        }
        return this.mcF;
    }

    private m dsb() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.mcz.drA().drI();
        if (this.mbB == null) {
            this.mbB = new m(this.mcz.getContext().getApplicationContext().getContentResolver(), dsa(), this.mcz.drt(), this.mcz.drx(), this.mcz.drA().drE(), this.mbJ, this.mcz.drA().drD(), z, this.mcz.drA().drL(), this.mcz.drl());
        }
        return this.mbB;
    }

    public com.facebook.cache.disk.h dsc() {
        if (this.mcG == null) {
            this.mcG = this.mcz.drj().a(this.mcz.dry());
        }
        return this.mcG;
    }

    private com.facebook.imagepipeline.c.e dsd() {
        if (this.mbH == null) {
            this.mbH = new com.facebook.imagepipeline.c.e(dsc(), this.mcz.dru().dtL(), this.mcz.dru().dtM(), this.mcz.drn().dqY(), this.mcz.drn().dqZ(), this.mcz.dro());
        }
        return this.mbH;
    }
}
