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
/* loaded from: classes3.dex */
public class j {
    private static final Class<?> pnn = j.class;
    private static j pyX = null;
    private g pqp;
    private com.facebook.imagepipeline.a.f puA;
    private final h pyY;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pyZ;
    private m pya;
    private com.facebook.imagepipeline.b.e pyf;
    private com.facebook.imagepipeline.b.e pyg;
    private final at pyi;
    private com.facebook.imagepipeline.decoder.b pyu;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pza;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> pzb;
    private o<com.facebook.cache.common.b, PooledByteBuffer> pzc;
    private com.facebook.cache.disk.h pzd;
    private l pze;
    private com.facebook.cache.disk.h pzf;
    private com.facebook.imagepipeline.h.e pzg;
    private com.facebook.imagepipeline.animated.a.a pzh;

    public static j euS() {
        return (j) com.facebook.common.internal.g.checkNotNull(pyX, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.ij(context).euD());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (pyX != null) {
                com.facebook.common.c.a.h(pnn, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            pyX = new j(hVar);
        }
    }

    public j(h hVar) {
        this.pyY = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.pyi = new at(hVar.eup().eue());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a euT() {
        if (this.pzh == null) {
            this.pzh = com.facebook.imagepipeline.animated.a.b.a(eva(), this.pyY.eup(), euU());
        }
        return this.pzh;
    }

    @Nullable
    public com.facebook.imagepipeline.e.a ih(Context context) {
        com.facebook.imagepipeline.animated.a.a euT = euT();
        if (euT == null) {
            return null;
        }
        return euT.ih(context);
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> euU() {
        if (this.pyZ == null) {
            this.pyZ = com.facebook.imagepipeline.b.a.a(this.pyY.eui(), this.pyY.euu(), this.pyY.euj());
        }
        return this.pyZ;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> euV() {
        if (this.pza == null) {
            this.pza = com.facebook.imagepipeline.b.b.a(euU(), this.pyY.euq());
        }
        return this.pza;
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> euW() {
        if (this.pzb == null) {
            this.pzb = com.facebook.imagepipeline.b.l.a(this.pyY.euo(), this.pyY.euu());
        }
        return this.pzb;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> euX() {
        if (this.pzc == null) {
            this.pzc = com.facebook.imagepipeline.b.m.a(euW(), this.pyY.euq());
        }
        return this.pzc;
    }

    private com.facebook.imagepipeline.decoder.b eur() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2;
        if (this.pyu == null) {
            if (this.pyY.eur() != null) {
                this.pyu = this.pyY.eur();
            } else {
                com.facebook.imagepipeline.animated.a.a euT = euT();
                if (euT != null) {
                    com.facebook.imagepipeline.decoder.b c = euT.c(this.pyY.etS());
                    bVar = euT.d(this.pyY.etS());
                    bVar2 = c;
                } else {
                    bVar = null;
                    bVar2 = null;
                }
                if (this.pyY.euB() == null) {
                    this.pyu = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, evb());
                } else {
                    this.pyu = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, evb(), this.pyY.euB().evF());
                    com.facebook.c.d.etc().gL(this.pyY.euB().evG());
                }
            }
        }
        return this.pyu;
    }

    public com.facebook.imagepipeline.b.e euY() {
        if (this.pyf == null) {
            this.pyf = new com.facebook.imagepipeline.b.e(euZ(), this.pyY.euw().ewJ(), this.pyY.euw().ewK(), this.pyY.eup().eua(), this.pyY.eup().eub(), this.pyY.euq());
        }
        return this.pyf;
    }

    public com.facebook.cache.disk.h euZ() {
        if (this.pzd == null) {
            this.pzd = this.pyY.eul().a(this.pyY.eut());
        }
        return this.pzd;
    }

    public g eqX() {
        if (this.pqp == null) {
            this.pqp = new g(evd(), this.pyY.euy(), this.pyY.eus(), euV(), euX(), euY(), evf(), this.pyY.euh(), this.pyi, com.facebook.common.internal.k.bc(false), this.pyY.euC().euQ());
        }
        return this.pqp;
    }

    public static com.facebook.imagepipeline.a.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.a.a(qVar.ewF());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.a.e(new com.facebook.imagepipeline.a.b(qVar.ewJ()), eVar);
        }
        return new com.facebook.imagepipeline.a.c();
    }

    public com.facebook.imagepipeline.a.f eva() {
        if (this.puA == null) {
            this.puA = a(this.pyY.euw(), evb());
        }
        return this.puA;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int ewH = qVar.ewH();
            return new com.facebook.imagepipeline.h.a(qVar.ewF(), ewH, new Pools.SynchronizedPool(ewH));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.ewG());
        }
    }

    public com.facebook.imagepipeline.h.e evb() {
        if (this.pzg == null) {
            this.pzg = a(this.pyY.euw(), this.pyY.euC().euG());
        }
        return this.pzg;
    }

    private l evc() {
        if (this.pze == null) {
            this.pze = this.pyY.euC().euO().a(this.pyY.getContext(), this.pyY.euw().ewL(), eur(), this.pyY.eux(), this.pyY.eum(), this.pyY.euz(), this.pyY.euC().euH(), this.pyY.eup(), this.pyY.euw().ewJ(), euV(), euX(), euY(), evf(), this.pyY.euh(), eva(), this.pyY.euC().euL(), this.pyY.euC().euM(), this.pyY.euC().euP());
        }
        return this.pze;
    }

    private m evd() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.pyY.euC().euK();
        if (this.pya == null) {
            this.pya = new m(this.pyY.getContext().getApplicationContext().getContentResolver(), evc(), this.pyY.euv(), this.pyY.euz(), this.pyY.euC().euG(), this.pyi, this.pyY.euC().euF(), z, this.pyY.euC().euN(), this.pyY.eun());
        }
        return this.pya;
    }

    public com.facebook.cache.disk.h eve() {
        if (this.pzf == null) {
            this.pzf = this.pyY.eul().a(this.pyY.euA());
        }
        return this.pzf;
    }

    private com.facebook.imagepipeline.b.e evf() {
        if (this.pyg == null) {
            this.pyg = new com.facebook.imagepipeline.b.e(eve(), this.pyY.euw().ewJ(), this.pyY.euw().ewK(), this.pyY.eup().eua(), this.pyY.eup().eub(), this.pyY.euq());
        }
        return this.pyg;
    }
}
