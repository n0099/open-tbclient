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

    public static j drP() {
        return (j) com.facebook.common.internal.g.checkNotNull(mcy, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.fF(context).drA());
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
        this.mbJ = new at(hVar.drm().drb());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a drQ() {
        if (this.mcI == null) {
            this.mcI = com.facebook.imagepipeline.animated.a.b.a(drX(), this.mcz.drm(), drR());
        }
        return this.mcI;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a fD(Context context) {
        com.facebook.imagepipeline.animated.a.a drQ = drQ();
        if (drQ == null) {
            return null;
        }
        return drQ.fD(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> drR() {
        if (this.mcA == null) {
            this.mcA = com.facebook.imagepipeline.c.a.a(this.mcz.drf(), this.mcz.drr(), this.mcz.drg());
        }
        return this.mcA;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> drS() {
        if (this.mcB == null) {
            this.mcB = com.facebook.imagepipeline.c.b.a(drR(), this.mcz.drn());
        }
        return this.mcB;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> drT() {
        if (this.mcC == null) {
            this.mcC = com.facebook.imagepipeline.c.l.a(this.mcz.drl(), this.mcz.drr());
        }
        return this.mcC;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> drU() {
        if (this.mcD == null) {
            this.mcD = com.facebook.imagepipeline.c.m.a(drT(), this.mcz.drn());
        }
        return this.mcD;
    }

    private com.facebook.imagepipeline.decoder.b dro() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.mbV == null) {
            if (this.mcz.dro() != null) {
                this.mbV = this.mcz.dro();
            } else {
                com.facebook.imagepipeline.animated.a.a drQ = drQ();
                if (drQ != null) {
                    bVar = drQ.a(this.mcz.dqO());
                    bVar2 = drQ.b(this.mcz.dqO());
                } else {
                    bVar = null;
                }
                if (this.mcz.dry() == null) {
                    this.mbV = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, drY());
                } else {
                    this.mbV = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, drY(), this.mcz.dry().dsC());
                    com.facebook.c.d.dpW().eU(this.mcz.dry().dsD());
                }
            }
        }
        return this.mbV;
    }

    public com.facebook.imagepipeline.c.e drV() {
        if (this.mbG == null) {
            this.mbG = new com.facebook.imagepipeline.c.e(drW(), this.mcz.drt().dtK(), this.mcz.drt().dtL(), this.mcz.drm().dqX(), this.mcz.drm().dqY(), this.mcz.drn());
        }
        return this.mbG;
    }

    public com.facebook.cache.disk.h drW() {
        if (this.mcE == null) {
            this.mcE = this.mcz.dri().a(this.mcz.drq());
        }
        return this.mcE;
    }

    public g dnO() {
        if (this.lTp == null) {
            this.lTp = new g(dsa(), this.mcz.drv(), this.mcz.drp(), drS(), drU(), drV(), dsc(), this.mcz.dre(), this.mbJ, com.facebook.common.internal.k.aL(false), this.mcz.drz().drN());
        }
        return this.lTp;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dtG());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dtK()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f drX() {
        if (this.lXK == null) {
            this.lXK = a(this.mcz.drt(), drY());
        }
        return this.lXK;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dtI = qVar.dtI();
            return new com.facebook.imagepipeline.i.a(qVar.dtG(), dtI, new Pools.SynchronizedPool(dtI));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dtH());
        }
    }

    public com.facebook.imagepipeline.i.e drY() {
        if (this.mcH == null) {
            this.mcH = a(this.mcz.drt(), this.mcz.drz().drD());
        }
        return this.mcH;
    }

    private l drZ() {
        if (this.mcF == null) {
            this.mcF = this.mcz.drz().drL().a(this.mcz.getContext(), this.mcz.drt().dtM(), dro(), this.mcz.dru(), this.mcz.drj(), this.mcz.drw(), this.mcz.drz().drE(), this.mcz.drm(), this.mcz.drt().dtK(), drS(), drU(), drV(), dsc(), this.mcz.dre(), drX(), this.mcz.drz().drI(), this.mcz.drz().drJ(), this.mcz.drz().drM());
        }
        return this.mcF;
    }

    private m dsa() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.mcz.drz().drH();
        if (this.mbB == null) {
            this.mbB = new m(this.mcz.getContext().getApplicationContext().getContentResolver(), drZ(), this.mcz.drs(), this.mcz.drw(), this.mcz.drz().drD(), this.mbJ, this.mcz.drz().drC(), z, this.mcz.drz().drK(), this.mcz.drk());
        }
        return this.mbB;
    }

    public com.facebook.cache.disk.h dsb() {
        if (this.mcG == null) {
            this.mcG = this.mcz.dri().a(this.mcz.drx());
        }
        return this.mcG;
    }

    private com.facebook.imagepipeline.c.e dsc() {
        if (this.mbH == null) {
            this.mbH = new com.facebook.imagepipeline.c.e(dsb(), this.mcz.drt().dtK(), this.mcz.drt().dtL(), this.mcz.drm().dqX(), this.mcz.drm().dqY(), this.mcz.drn());
        }
        return this.mbH;
    }
}
