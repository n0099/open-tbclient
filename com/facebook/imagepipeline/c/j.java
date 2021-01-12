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
    private static final Class<?> pnm = j.class;
    private static j pyW = null;
    private g pqo;
    private com.facebook.imagepipeline.a.f puz;
    private m pxZ;
    private final h pyX;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pyY;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pyZ;
    private com.facebook.imagepipeline.b.e pye;
    private com.facebook.imagepipeline.b.e pyf;
    private final at pyh;
    private com.facebook.imagepipeline.decoder.b pyt;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> pza;
    private o<com.facebook.cache.common.b, PooledByteBuffer> pzb;
    private com.facebook.cache.disk.h pzc;
    private l pzd;
    private com.facebook.cache.disk.h pze;
    private com.facebook.imagepipeline.h.e pzf;
    private com.facebook.imagepipeline.animated.a.a pzg;

    public static j euS() {
        return (j) com.facebook.common.internal.g.checkNotNull(pyW, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.ij(context).euD());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (pyW != null) {
                com.facebook.common.c.a.h(pnm, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            pyW = new j(hVar);
        }
    }

    public j(h hVar) {
        this.pyX = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.pyh = new at(hVar.eup().eue());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a euT() {
        if (this.pzg == null) {
            this.pzg = com.facebook.imagepipeline.animated.a.b.a(eva(), this.pyX.eup(), euU());
        }
        return this.pzg;
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
        if (this.pyY == null) {
            this.pyY = com.facebook.imagepipeline.b.a.a(this.pyX.eui(), this.pyX.euu(), this.pyX.euj());
        }
        return this.pyY;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> euV() {
        if (this.pyZ == null) {
            this.pyZ = com.facebook.imagepipeline.b.b.a(euU(), this.pyX.euq());
        }
        return this.pyZ;
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> euW() {
        if (this.pza == null) {
            this.pza = com.facebook.imagepipeline.b.l.a(this.pyX.euo(), this.pyX.euu());
        }
        return this.pza;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> euX() {
        if (this.pzb == null) {
            this.pzb = com.facebook.imagepipeline.b.m.a(euW(), this.pyX.euq());
        }
        return this.pzb;
    }

    private com.facebook.imagepipeline.decoder.b eur() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2;
        if (this.pyt == null) {
            if (this.pyX.eur() != null) {
                this.pyt = this.pyX.eur();
            } else {
                com.facebook.imagepipeline.animated.a.a euT = euT();
                if (euT != null) {
                    com.facebook.imagepipeline.decoder.b c = euT.c(this.pyX.etS());
                    bVar = euT.d(this.pyX.etS());
                    bVar2 = c;
                } else {
                    bVar = null;
                    bVar2 = null;
                }
                if (this.pyX.euB() == null) {
                    this.pyt = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, evb());
                } else {
                    this.pyt = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, evb(), this.pyX.euB().evF());
                    com.facebook.c.d.etc().gL(this.pyX.euB().evG());
                }
            }
        }
        return this.pyt;
    }

    public com.facebook.imagepipeline.b.e euY() {
        if (this.pye == null) {
            this.pye = new com.facebook.imagepipeline.b.e(euZ(), this.pyX.euw().ewJ(), this.pyX.euw().ewK(), this.pyX.eup().eua(), this.pyX.eup().eub(), this.pyX.euq());
        }
        return this.pye;
    }

    public com.facebook.cache.disk.h euZ() {
        if (this.pzc == null) {
            this.pzc = this.pyX.eul().a(this.pyX.eut());
        }
        return this.pzc;
    }

    public g eqX() {
        if (this.pqo == null) {
            this.pqo = new g(evd(), this.pyX.euy(), this.pyX.eus(), euV(), euX(), euY(), evf(), this.pyX.euh(), this.pyh, com.facebook.common.internal.k.bc(false), this.pyX.euC().euQ());
        }
        return this.pqo;
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
        if (this.puz == null) {
            this.puz = a(this.pyX.euw(), evb());
        }
        return this.puz;
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
        if (this.pzf == null) {
            this.pzf = a(this.pyX.euw(), this.pyX.euC().euG());
        }
        return this.pzf;
    }

    private l evc() {
        if (this.pzd == null) {
            this.pzd = this.pyX.euC().euO().a(this.pyX.getContext(), this.pyX.euw().ewL(), eur(), this.pyX.eux(), this.pyX.eum(), this.pyX.euz(), this.pyX.euC().euH(), this.pyX.eup(), this.pyX.euw().ewJ(), euV(), euX(), euY(), evf(), this.pyX.euh(), eva(), this.pyX.euC().euL(), this.pyX.euC().euM(), this.pyX.euC().euP());
        }
        return this.pzd;
    }

    private m evd() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.pyX.euC().euK();
        if (this.pxZ == null) {
            this.pxZ = new m(this.pyX.getContext().getApplicationContext().getContentResolver(), evc(), this.pyX.euv(), this.pyX.euz(), this.pyX.euC().euG(), this.pyh, this.pyX.euC().euF(), z, this.pyX.euC().euN(), this.pyX.eun());
        }
        return this.pxZ;
    }

    public com.facebook.cache.disk.h eve() {
        if (this.pze == null) {
            this.pze = this.pyX.eul().a(this.pyX.euA());
        }
        return this.pze;
    }

    private com.facebook.imagepipeline.b.e evf() {
        if (this.pyf == null) {
            this.pyf = new com.facebook.imagepipeline.b.e(eve(), this.pyX.euw().ewJ(), this.pyX.euw().ewK(), this.pyX.eup().eua(), this.pyX.eup().eub(), this.pyX.euq());
        }
        return this.pyf;
    }
}
