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
    private static final Class<?> lIR = j.class;
    private static j lUH = null;
    private g lLR;
    private com.facebook.imagepipeline.b.f lQb;
    private m lTK;
    private com.facebook.imagepipeline.c.e lTP;
    private com.facebook.imagepipeline.c.e lTQ;
    private final at lTS;
    private final h lUI;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lUJ;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lUK;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> lUL;
    private o<com.facebook.cache.common.b, PooledByteBuffer> lUM;
    private com.facebook.cache.disk.h lUN;
    private l lUO;
    private com.facebook.cache.disk.h lUP;
    private com.facebook.imagepipeline.i.e lUQ;
    private com.facebook.imagepipeline.animated.a.a lUR;
    private com.facebook.imagepipeline.decoder.b lUe;

    public static j dpU() {
        return (j) com.facebook.common.internal.g.checkNotNull(lUH, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gm(context).dpF());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (lUH != null) {
                com.facebook.common.c.a.g(lIR, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            lUH = new j(hVar);
        }
    }

    public j(h hVar) {
        this.lUI = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.lTS = new at(hVar.dpr().dpf());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dpV() {
        if (this.lUR == null) {
            this.lUR = com.facebook.imagepipeline.animated.a.b.a(dqc(), this.lUI.dpr(), dpW());
        }
        return this.lUR;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gl(Context context) {
        com.facebook.imagepipeline.animated.a.a dpV = dpV();
        if (dpV == null) {
            return null;
        }
        return dpV.gl(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dpW() {
        if (this.lUJ == null) {
            this.lUJ = com.facebook.imagepipeline.c.a.a(this.lUI.dpk(), this.lUI.dpw(), this.lUI.dpl());
        }
        return this.lUJ;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dpX() {
        if (this.lUK == null) {
            this.lUK = com.facebook.imagepipeline.c.b.a(dpW(), this.lUI.dps());
        }
        return this.lUK;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dpY() {
        if (this.lUL == null) {
            this.lUL = com.facebook.imagepipeline.c.l.a(this.lUI.dpq(), this.lUI.dpw());
        }
        return this.lUL;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dpZ() {
        if (this.lUM == null) {
            this.lUM = com.facebook.imagepipeline.c.m.a(dpY(), this.lUI.dps());
        }
        return this.lUM;
    }

    private com.facebook.imagepipeline.decoder.b dpt() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.lUe == null) {
            if (this.lUI.dpt() != null) {
                this.lUe = this.lUI.dpt();
            } else {
                com.facebook.imagepipeline.animated.a.a dpV = dpV();
                if (dpV != null) {
                    bVar = dpV.a(this.lUI.doS());
                    bVar2 = dpV.b(this.lUI.doS());
                } else {
                    bVar = null;
                }
                if (this.lUI.dpD() == null) {
                    this.lUe = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dqd());
                } else {
                    this.lUe = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dqd(), this.lUI.dpD().dqH());
                    com.facebook.c.d.doc().eT(this.lUI.dpD().dqI());
                }
            }
        }
        return this.lUe;
    }

    public com.facebook.imagepipeline.c.e dqa() {
        if (this.lTP == null) {
            this.lTP = new com.facebook.imagepipeline.c.e(dqb(), this.lUI.dpy().drP(), this.lUI.dpy().drQ(), this.lUI.dpr().dpb(), this.lUI.dpr().dpc(), this.lUI.dps());
        }
        return this.lTP;
    }

    public com.facebook.cache.disk.h dqb() {
        if (this.lUN == null) {
            this.lUN = this.lUI.dpn().a(this.lUI.dpv());
        }
        return this.lUN;
    }

    public g dlY() {
        if (this.lLR == null) {
            this.lLR = new g(dqf(), this.lUI.dpA(), this.lUI.dpu(), dpX(), dpZ(), dqa(), dqh(), this.lUI.dpj(), this.lTS, com.facebook.common.internal.k.aU(false), this.lUI.dpE().dpS());
        }
        return this.lLR;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.drL());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.drP()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dqc() {
        if (this.lQb == null) {
            this.lQb = a(this.lUI.dpy(), dqd());
        }
        return this.lQb;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int drN = qVar.drN();
            return new com.facebook.imagepipeline.i.a(qVar.drL(), drN, new Pools.SynchronizedPool(drN));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.drM());
        }
    }

    public com.facebook.imagepipeline.i.e dqd() {
        if (this.lUQ == null) {
            this.lUQ = a(this.lUI.dpy(), this.lUI.dpE().dpI());
        }
        return this.lUQ;
    }

    private l dqe() {
        if (this.lUO == null) {
            this.lUO = this.lUI.dpE().dpQ().a(this.lUI.getContext(), this.lUI.dpy().drR(), dpt(), this.lUI.dpz(), this.lUI.dpo(), this.lUI.dpB(), this.lUI.dpE().dpJ(), this.lUI.dpr(), this.lUI.dpy().drP(), dpX(), dpZ(), dqa(), dqh(), this.lUI.dpj(), dqc(), this.lUI.dpE().dpN(), this.lUI.dpE().dpO(), this.lUI.dpE().dpR());
        }
        return this.lUO;
    }

    private m dqf() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.lUI.dpE().dpM();
        if (this.lTK == null) {
            this.lTK = new m(this.lUI.getContext().getApplicationContext().getContentResolver(), dqe(), this.lUI.dpx(), this.lUI.dpB(), this.lUI.dpE().dpI(), this.lTS, this.lUI.dpE().dpH(), z, this.lUI.dpE().dpP(), this.lUI.dpp());
        }
        return this.lTK;
    }

    public com.facebook.cache.disk.h dqg() {
        if (this.lUP == null) {
            this.lUP = this.lUI.dpn().a(this.lUI.dpC());
        }
        return this.lUP;
    }

    private com.facebook.imagepipeline.c.e dqh() {
        if (this.lTQ == null) {
            this.lTQ = new com.facebook.imagepipeline.c.e(dqg(), this.lUI.dpy().drP(), this.lUI.dpy().drQ(), this.lUI.dpr().dpb(), this.lUI.dpr().dpc(), this.lUI.dps());
        }
        return this.lTQ;
    }
}
