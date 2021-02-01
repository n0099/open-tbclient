package com.facebook.imagepipeline.c;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.o;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.at;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class j {
    private g pAy;
    private com.facebook.imagepipeline.a.f pEI;
    private com.facebook.imagepipeline.decoder.b pIC;
    private m pIi;
    private com.facebook.imagepipeline.b.e pIn;
    private com.facebook.imagepipeline.b.e pIo;
    private final at pIq;
    private final h pJg;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pJh;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pJi;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> pJj;
    private o<com.facebook.cache.common.b, PooledByteBuffer> pJk;
    private com.facebook.cache.disk.h pJl;
    private l pJm;
    private com.facebook.cache.disk.h pJn;
    private com.facebook.imagepipeline.h.e pJo;
    private com.facebook.imagepipeline.animated.a.a pJp;
    private static final Class<?> pxC = j.class;
    private static j pJf = null;

    public static j exl() {
        return (j) com.facebook.common.internal.g.checkNotNull(pJf, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.im(context).ewW());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (pJf != null) {
                com.facebook.common.c.a.h(pxC, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            pJf = new j(hVar);
        }
    }

    public j(h hVar) {
        this.pJg = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.pIq = new at(hVar.ewI().eww());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a exm() {
        if (this.pJp == null) {
            this.pJp = com.facebook.imagepipeline.animated.a.b.a(ext(), this.pJg.ewI(), exn());
        }
        return this.pJp;
    }

    @Nullable
    public com.facebook.imagepipeline.e.a ik(Context context) {
        com.facebook.imagepipeline.animated.a.a exm = exm();
        if (exm == null) {
            return null;
        }
        return exm.ik(context);
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> exn() {
        if (this.pJh == null) {
            this.pJh = com.facebook.imagepipeline.b.a.a(this.pJg.ewB(), this.pJg.ewN(), this.pJg.ewC());
        }
        return this.pJh;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> exo() {
        if (this.pJi == null) {
            this.pJi = com.facebook.imagepipeline.b.b.a(exn(), this.pJg.ewJ());
        }
        return this.pJi;
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> exp() {
        if (this.pJj == null) {
            this.pJj = com.facebook.imagepipeline.b.l.a(this.pJg.ewH(), this.pJg.ewN());
        }
        return this.pJj;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> exq() {
        if (this.pJk == null) {
            this.pJk = com.facebook.imagepipeline.b.m.a(exp(), this.pJg.ewJ());
        }
        return this.pJk;
    }

    private com.facebook.imagepipeline.decoder.b ewK() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2;
        if (this.pIC == null) {
            if (this.pJg.ewK() != null) {
                this.pIC = this.pJg.ewK();
            } else {
                com.facebook.imagepipeline.animated.a.a exm = exm();
                if (exm != null) {
                    com.facebook.imagepipeline.decoder.b c = exm.c(this.pJg.ewk());
                    bVar = exm.d(this.pJg.ewk());
                    bVar2 = c;
                } else {
                    bVar = null;
                    bVar2 = null;
                }
                if (this.pJg.ewU() == null) {
                    this.pIC = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, exu());
                } else {
                    this.pIC = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, exu(), this.pJg.ewU().exY());
                    com.facebook.c.d.evu().gJ(this.pJg.ewU().exZ());
                }
            }
        }
        return this.pIC;
    }

    public com.facebook.imagepipeline.b.e exr() {
        if (this.pIn == null) {
            this.pIn = new com.facebook.imagepipeline.b.e(exs(), this.pJg.ewP().ezb(), this.pJg.ewP().ezc(), this.pJg.ewI().ews(), this.pJg.ewI().ewt(), this.pJg.ewJ());
        }
        return this.pIn;
    }

    public com.facebook.cache.disk.h exs() {
        if (this.pJl == null) {
            this.pJl = this.pJg.ewE().a(this.pJg.ewM());
        }
        return this.pJl;
    }

    public g etq() {
        if (this.pAy == null) {
            this.pAy = new g(exw(), this.pJg.ewR(), this.pJg.ewL(), exo(), exq(), exr(), exy(), this.pJg.ewA(), this.pIq, com.facebook.common.internal.k.bc(false), this.pJg.ewV().exj());
        }
        return this.pAy;
    }

    public static com.facebook.imagepipeline.a.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.a.a(qVar.eyX());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.a.e(new com.facebook.imagepipeline.a.b(qVar.ezb()), eVar);
        }
        return new com.facebook.imagepipeline.a.c();
    }

    public com.facebook.imagepipeline.a.f ext() {
        if (this.pEI == null) {
            this.pEI = a(this.pJg.ewP(), exu());
        }
        return this.pEI;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int eyZ = qVar.eyZ();
            return new com.facebook.imagepipeline.h.a(qVar.eyX(), eyZ, new Pools.SynchronizedPool(eyZ));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.eyY());
        }
    }

    public com.facebook.imagepipeline.h.e exu() {
        if (this.pJo == null) {
            this.pJo = a(this.pJg.ewP(), this.pJg.ewV().ewZ());
        }
        return this.pJo;
    }

    private l exv() {
        if (this.pJm == null) {
            this.pJm = this.pJg.ewV().exh().a(this.pJg.getContext(), this.pJg.ewP().ezd(), ewK(), this.pJg.ewQ(), this.pJg.ewF(), this.pJg.ewS(), this.pJg.ewV().exa(), this.pJg.ewI(), this.pJg.ewP().ezb(), exo(), exq(), exr(), exy(), this.pJg.ewA(), ext(), this.pJg.ewV().exe(), this.pJg.ewV().exf(), this.pJg.ewV().exi());
        }
        return this.pJm;
    }

    private m exw() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.pJg.ewV().exd();
        if (this.pIi == null) {
            this.pIi = new m(this.pJg.getContext().getApplicationContext().getContentResolver(), exv(), this.pJg.ewO(), this.pJg.ewS(), this.pJg.ewV().ewZ(), this.pIq, this.pJg.ewV().ewY(), z, this.pJg.ewV().exg(), this.pJg.ewG());
        }
        return this.pIi;
    }

    public com.facebook.cache.disk.h exx() {
        if (this.pJn == null) {
            this.pJn = this.pJg.ewE().a(this.pJg.ewT());
        }
        return this.pJn;
    }

    private com.facebook.imagepipeline.b.e exy() {
        if (this.pIo == null) {
            this.pIo = new com.facebook.imagepipeline.b.e(exx(), this.pJg.ewP().ezb(), this.pJg.ewP().ezc(), this.pJg.ewI().ews(), this.pJg.ewI().ewt(), this.pJg.ewJ());
        }
        return this.pIo;
    }
}
