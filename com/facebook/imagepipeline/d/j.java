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
    private static final Class<?> lGm = j.class;
    private static j lSc = null;
    private g lJm;
    private com.facebook.imagepipeline.b.f lNw;
    private m lRf;
    private com.facebook.imagepipeline.c.e lRk;
    private com.facebook.imagepipeline.c.e lRl;
    private final at lRn;
    private com.facebook.imagepipeline.decoder.b lRz;
    private final h lSd;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lSe;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lSf;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> lSg;
    private o<com.facebook.cache.common.b, PooledByteBuffer> lSh;
    private com.facebook.cache.disk.h lSi;
    private l lSj;
    private com.facebook.cache.disk.h lSk;
    private com.facebook.imagepipeline.i.e lSl;
    private com.facebook.imagepipeline.animated.a.a lSm;

    public static j dog() {
        return (j) com.facebook.common.internal.g.checkNotNull(lSc, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.go(context).dnR());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (lSc != null) {
                com.facebook.common.c.a.g(lGm, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            lSc = new j(hVar);
        }
    }

    public j(h hVar) {
        this.lSd = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.lRn = new at(hVar.dnD().dnq());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a doh() {
        if (this.lSm == null) {
            this.lSm = com.facebook.imagepipeline.animated.a.b.a(doo(), this.lSd.dnD(), doi());
        }
        return this.lSm;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gn(Context context) {
        com.facebook.imagepipeline.animated.a.a doh = doh();
        if (doh == null) {
            return null;
        }
        return doh.gn(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> doi() {
        if (this.lSe == null) {
            this.lSe = com.facebook.imagepipeline.c.a.a(this.lSd.dnw(), this.lSd.dnI(), this.lSd.dnx());
        }
        return this.lSe;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> doj() {
        if (this.lSf == null) {
            this.lSf = com.facebook.imagepipeline.c.b.a(doi(), this.lSd.dnE());
        }
        return this.lSf;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dok() {
        if (this.lSg == null) {
            this.lSg = com.facebook.imagepipeline.c.l.a(this.lSd.dnC(), this.lSd.dnI());
        }
        return this.lSg;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dol() {
        if (this.lSh == null) {
            this.lSh = com.facebook.imagepipeline.c.m.a(dok(), this.lSd.dnE());
        }
        return this.lSh;
    }

    private com.facebook.imagepipeline.decoder.b dnF() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.lRz == null) {
            if (this.lSd.dnF() != null) {
                this.lRz = this.lSd.dnF();
            } else {
                com.facebook.imagepipeline.animated.a.a doh = doh();
                if (doh != null) {
                    bVar = doh.a(this.lSd.dnd());
                    bVar2 = doh.b(this.lSd.dnd());
                } else {
                    bVar = null;
                }
                if (this.lSd.dnP() == null) {
                    this.lRz = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dop());
                } else {
                    this.lRz = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dop(), this.lSd.dnP().doT());
                    com.facebook.c.d.dmn().eY(this.lSd.dnP().doU());
                }
            }
        }
        return this.lRz;
    }

    public com.facebook.imagepipeline.c.e dom() {
        if (this.lRk == null) {
            this.lRk = new com.facebook.imagepipeline.c.e(don(), this.lSd.dnK().dqb(), this.lSd.dnK().dqc(), this.lSd.dnD().dnm(), this.lSd.dnD().dnn(), this.lSd.dnE());
        }
        return this.lRk;
    }

    public com.facebook.cache.disk.h don() {
        if (this.lSi == null) {
            this.lSi = this.lSd.dnz().a(this.lSd.dnH());
        }
        return this.lSi;
    }

    public g dkj() {
        if (this.lJm == null) {
            this.lJm = new g(dor(), this.lSd.dnM(), this.lSd.dnG(), doj(), dol(), dom(), dot(), this.lSd.dnv(), this.lRn, com.facebook.common.internal.k.aS(false), this.lSd.dnQ().doe());
        }
        return this.lJm;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dpX());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dqb()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f doo() {
        if (this.lNw == null) {
            this.lNw = a(this.lSd.dnK(), dop());
        }
        return this.lNw;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dpZ = qVar.dpZ();
            return new com.facebook.imagepipeline.i.a(qVar.dpX(), dpZ, new Pools.SynchronizedPool(dpZ));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dpY());
        }
    }

    public com.facebook.imagepipeline.i.e dop() {
        if (this.lSl == null) {
            this.lSl = a(this.lSd.dnK(), this.lSd.dnQ().dnU());
        }
        return this.lSl;
    }

    private l doq() {
        if (this.lSj == null) {
            this.lSj = this.lSd.dnQ().doc().a(this.lSd.getContext(), this.lSd.dnK().dqd(), dnF(), this.lSd.dnL(), this.lSd.dnA(), this.lSd.dnN(), this.lSd.dnQ().dnV(), this.lSd.dnD(), this.lSd.dnK().dqb(), doj(), dol(), dom(), dot(), this.lSd.dnv(), doo(), this.lSd.dnQ().dnZ(), this.lSd.dnQ().doa(), this.lSd.dnQ().dod());
        }
        return this.lSj;
    }

    private m dor() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.lSd.dnQ().dnY();
        if (this.lRf == null) {
            this.lRf = new m(this.lSd.getContext().getApplicationContext().getContentResolver(), doq(), this.lSd.dnJ(), this.lSd.dnN(), this.lSd.dnQ().dnU(), this.lRn, this.lSd.dnQ().dnT(), z, this.lSd.dnQ().dob(), this.lSd.dnB());
        }
        return this.lRf;
    }

    public com.facebook.cache.disk.h dos() {
        if (this.lSk == null) {
            this.lSk = this.lSd.dnz().a(this.lSd.dnO());
        }
        return this.lSk;
    }

    private com.facebook.imagepipeline.c.e dot() {
        if (this.lRl == null) {
            this.lRl = new com.facebook.imagepipeline.c.e(dos(), this.lSd.dnK().dqb(), this.lSd.dnK().dqc(), this.lSd.dnD().dnm(), this.lSd.dnD().dnn(), this.lSd.dnE());
        }
        return this.lRl;
    }
}
