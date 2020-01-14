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
/* loaded from: classes10.dex */
public class j {
    private static final Class<?> lGr = j.class;
    private static j lSh = null;
    private g lJr;
    private com.facebook.imagepipeline.b.f lNB;
    private com.facebook.imagepipeline.decoder.b lRE;
    private m lRk;
    private com.facebook.imagepipeline.c.e lRp;
    private com.facebook.imagepipeline.c.e lRq;
    private final at lRs;
    private final h lSi;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lSj;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lSk;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> lSl;
    private o<com.facebook.cache.common.b, PooledByteBuffer> lSm;
    private com.facebook.cache.disk.h lSn;
    private l lSo;
    private com.facebook.cache.disk.h lSp;
    private com.facebook.imagepipeline.i.e lSq;
    private com.facebook.imagepipeline.animated.a.a lSr;

    public static j doi() {
        return (j) com.facebook.common.internal.g.checkNotNull(lSh, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.go(context).dnT());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (lSh != null) {
                com.facebook.common.c.a.g(lGr, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            lSh = new j(hVar);
        }
    }

    public j(h hVar) {
        this.lSi = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.lRs = new at(hVar.dnF().dnt());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a doj() {
        if (this.lSr == null) {
            this.lSr = com.facebook.imagepipeline.animated.a.b.a(doq(), this.lSi.dnF(), dok());
        }
        return this.lSr;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gn(Context context) {
        com.facebook.imagepipeline.animated.a.a doj = doj();
        if (doj == null) {
            return null;
        }
        return doj.gn(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dok() {
        if (this.lSj == null) {
            this.lSj = com.facebook.imagepipeline.c.a.a(this.lSi.dny(), this.lSi.dnK(), this.lSi.dnz());
        }
        return this.lSj;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dol() {
        if (this.lSk == null) {
            this.lSk = com.facebook.imagepipeline.c.b.a(dok(), this.lSi.dnG());
        }
        return this.lSk;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dom() {
        if (this.lSl == null) {
            this.lSl = com.facebook.imagepipeline.c.l.a(this.lSi.dnE(), this.lSi.dnK());
        }
        return this.lSl;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> don() {
        if (this.lSm == null) {
            this.lSm = com.facebook.imagepipeline.c.m.a(dom(), this.lSi.dnG());
        }
        return this.lSm;
    }

    private com.facebook.imagepipeline.decoder.b dnH() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.lRE == null) {
            if (this.lSi.dnH() != null) {
                this.lRE = this.lSi.dnH();
            } else {
                com.facebook.imagepipeline.animated.a.a doj = doj();
                if (doj != null) {
                    bVar = doj.a(this.lSi.dnf());
                    bVar2 = doj.b(this.lSi.dnf());
                } else {
                    bVar = null;
                }
                if (this.lSi.dnR() == null) {
                    this.lRE = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dor());
                } else {
                    this.lRE = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dor(), this.lSi.dnR().doV());
                    com.facebook.c.d.dmp().eY(this.lSi.dnR().doW());
                }
            }
        }
        return this.lRE;
    }

    public com.facebook.imagepipeline.c.e doo() {
        if (this.lRp == null) {
            this.lRp = new com.facebook.imagepipeline.c.e(dop(), this.lSi.dnM().dqd(), this.lSi.dnM().dqe(), this.lSi.dnF().dno(), this.lSi.dnF().dnp(), this.lSi.dnG());
        }
        return this.lRp;
    }

    public com.facebook.cache.disk.h dop() {
        if (this.lSn == null) {
            this.lSn = this.lSi.dnB().a(this.lSi.dnJ());
        }
        return this.lSn;
    }

    public g dkl() {
        if (this.lJr == null) {
            this.lJr = new g(dot(), this.lSi.dnO(), this.lSi.dnI(), dol(), don(), doo(), dov(), this.lSi.dnx(), this.lRs, com.facebook.common.internal.k.aS(false), this.lSi.dnS().dog());
        }
        return this.lJr;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dpZ());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dqd()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f doq() {
        if (this.lNB == null) {
            this.lNB = a(this.lSi.dnM(), dor());
        }
        return this.lNB;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dqb = qVar.dqb();
            return new com.facebook.imagepipeline.i.a(qVar.dpZ(), dqb, new Pools.SynchronizedPool(dqb));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dqa());
        }
    }

    public com.facebook.imagepipeline.i.e dor() {
        if (this.lSq == null) {
            this.lSq = a(this.lSi.dnM(), this.lSi.dnS().dnW());
        }
        return this.lSq;
    }

    private l dos() {
        if (this.lSo == null) {
            this.lSo = this.lSi.dnS().doe().a(this.lSi.getContext(), this.lSi.dnM().dqf(), dnH(), this.lSi.dnN(), this.lSi.dnC(), this.lSi.dnP(), this.lSi.dnS().dnX(), this.lSi.dnF(), this.lSi.dnM().dqd(), dol(), don(), doo(), dov(), this.lSi.dnx(), doq(), this.lSi.dnS().dob(), this.lSi.dnS().doc(), this.lSi.dnS().dof());
        }
        return this.lSo;
    }

    private m dot() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.lSi.dnS().doa();
        if (this.lRk == null) {
            this.lRk = new m(this.lSi.getContext().getApplicationContext().getContentResolver(), dos(), this.lSi.dnL(), this.lSi.dnP(), this.lSi.dnS().dnW(), this.lRs, this.lSi.dnS().dnV(), z, this.lSi.dnS().dod(), this.lSi.dnD());
        }
        return this.lRk;
    }

    public com.facebook.cache.disk.h dou() {
        if (this.lSp == null) {
            this.lSp = this.lSi.dnB().a(this.lSi.dnQ());
        }
        return this.lSp;
    }

    private com.facebook.imagepipeline.c.e dov() {
        if (this.lRq == null) {
            this.lRq = new com.facebook.imagepipeline.c.e(dou(), this.lSi.dnM().dqd(), this.lSi.dnM().dqe(), this.lSi.dnF().dno(), this.lSi.dnF().dnp(), this.lSi.dnG());
        }
        return this.lRq;
    }
}
