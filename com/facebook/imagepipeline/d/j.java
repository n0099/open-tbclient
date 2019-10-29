package com.facebook.imagepipeline.d;

import android.content.Context;
import android.os.Build;
import android.support.v4.util.Pools;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.n;
import com.facebook.imagepipeline.c.r;
import com.facebook.imagepipeline.c.s;
import com.facebook.imagepipeline.c.t;
import com.facebook.imagepipeline.c.y;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.ar;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class j {
    private static j kjc = null;
    private g kcH;
    private com.facebook.imagepipeline.c.e khD;
    private com.facebook.imagepipeline.decoder.b kiB;
    private com.facebook.imagepipeline.b.f kiF;
    private m kik;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kin;
    private t<com.facebook.cache.common.b, PooledByteBuffer> kio;
    private com.facebook.imagepipeline.c.e kip;
    private final ar kiq;
    private final h kjd;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kje;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> kjf;
    private com.facebook.cache.disk.h kjg;
    private l kjh;
    private com.facebook.cache.disk.h kji;
    private r kjj;
    private com.facebook.imagepipeline.h.e kjk;
    private com.facebook.imagepipeline.a.a.b kjl;

    public static j cGS() {
        return (j) com.facebook.common.internal.g.checkNotNull(kjc, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.ev(context).cGG());
    }

    public static void a(h hVar) {
        kjc = new j(hVar);
    }

    public j(h hVar) {
        this.kjd = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.kiq = new ar(hVar.cGr().cGi());
    }

    public com.facebook.imagepipeline.a.a.b cGT() {
        if (this.kjl == null) {
            this.kjl = com.facebook.imagepipeline.a.a.c.a(cGZ(), this.kjd.cGr());
        }
        return this.kjl;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cGU() {
        if (this.kje == null) {
            this.kje = com.facebook.imagepipeline.c.a.a(this.kjd.cGm(), this.kjd.cGw(), cGZ(), this.kjd.cGE().cGI());
        }
        return this.kje;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cGk() {
        if (this.kin == null) {
            this.kin = com.facebook.imagepipeline.c.b.a(cGU(), this.kjd.cGs());
        }
        return this.kin;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cGV() {
        if (this.kjf == null) {
            this.kjf = com.facebook.imagepipeline.c.m.a(this.kjd.cGq(), this.kjd.cGw(), cGZ());
        }
        return this.kjf;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cGW() {
        if (this.kio == null) {
            this.kio = n.a(cGV(), this.kjd.cGs());
        }
        return this.kio;
    }

    private com.facebook.imagepipeline.decoder.b cGt() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.kiB == null) {
            if (this.kjd.cGt() != null) {
                this.kiB = this.kjd.cGt();
            } else {
                if (cGT() != null) {
                    dVar = cGT().cFn();
                } else {
                    dVar = null;
                }
                if (this.kjd.cGD() == null) {
                    this.kiB = new com.facebook.imagepipeline.decoder.a(dVar, cHa(), this.kjd.cFW());
                } else {
                    this.kiB = new com.facebook.imagepipeline.decoder.a(dVar, cHa(), this.kjd.cFW(), this.kjd.cGD().cHD());
                    com.facebook.c.d.cFm().eS(this.kjd.cGD().cHE());
                }
            }
        }
        return this.kiB;
    }

    private com.facebook.imagepipeline.c.e cGX() {
        if (this.kip == null) {
            this.kip = new com.facebook.imagepipeline.c.e(cGY(), this.kjd.cGy().cIC(), this.kjd.cGy().cID(), this.kjd.cGr().cGe(), this.kjd.cGr().cGf(), this.kjd.cGs());
        }
        return this.kip;
    }

    public com.facebook.cache.disk.h cGY() {
        if (this.kjg == null) {
            this.kjg = this.kjd.cGo().a(this.kjd.cGv());
        }
        return this.kjg;
    }

    public g cDD() {
        if (this.kcH == null) {
            this.kcH = new g(cHc(), this.kjd.cGA(), this.kjd.cGu(), cGk(), cGW(), cGX(), cHe(), this.kjd.cGl(), this.kiq, com.facebook.common.internal.j.ay(false));
        }
        return this.kcH;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.cIy());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.cIC()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cGZ() {
        if (this.kiF == null) {
            this.kiF = a(this.kjd.cGy(), cHa());
        }
        return this.kiF;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int cIA = qVar.cIA();
            return new com.facebook.imagepipeline.h.a(qVar.cIy(), cIA, new Pools.SynchronizedPool(cIA));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.cIz());
        }
    }

    public com.facebook.imagepipeline.h.e cHa() {
        if (this.kjk == null) {
            this.kjk = a(this.kjd.cGy(), this.kjd.cGE().cGN());
        }
        return this.kjk;
    }

    private l cHb() {
        if (this.kjh == null) {
            this.kjh = new l(this.kjd.getContext(), this.kjd.cGy().cIE(), cGt(), this.kjd.cGz(), this.kjd.cGp(), this.kjd.cGB(), this.kjd.cGE().cGO(), this.kjd.cGr(), this.kjd.cGy().cIC(), cGk(), cGW(), cGX(), cHe(), cHf(), this.kjd.cGE().cGL(), this.kjd.cGl(), cGZ(), this.kjd.cGE().cGJ());
        }
        return this.kjh;
    }

    private m cHc() {
        if (this.kik == null) {
            this.kik = new m(cHb(), this.kjd.cGx(), this.kjd.cGB(), this.kjd.cGE().cGN(), this.kiq, this.kjd.cGE().cGM());
        }
        return this.kik;
    }

    public com.facebook.cache.disk.h cHd() {
        if (this.kji == null) {
            this.kji = this.kjd.cGo().a(this.kjd.cGC());
        }
        return this.kji;
    }

    private com.facebook.imagepipeline.c.e cHe() {
        if (this.khD == null) {
            this.khD = new com.facebook.imagepipeline.c.e(cHd(), this.kjd.cGy().cIC(), this.kjd.cGy().cID(), this.kjd.cGr().cGe(), this.kjd.cGr().cGf(), this.kjd.cGs());
        }
        return this.khD;
    }

    public r cHf() {
        if (this.kjj == null) {
            this.kjj = this.kjd.cGE().cGK() ? new s(this.kjd.getContext(), this.kjd.cGr().cGe(), this.kjd.cGr().cGf()) : new y();
        }
        return this.kjj;
    }
}
