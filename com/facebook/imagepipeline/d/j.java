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
    private static j kil = null;
    private g kbQ;
    private com.facebook.imagepipeline.c.e kgM;
    private com.facebook.imagepipeline.decoder.b khJ;
    private com.facebook.imagepipeline.b.f khN;
    private m khs;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> khv;
    private t<com.facebook.cache.common.b, PooledByteBuffer> khw;
    private com.facebook.imagepipeline.c.e khx;
    private final ar khy;
    private final h kim;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kin;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> kio;
    private com.facebook.cache.disk.h kip;
    private l kiq;
    private com.facebook.cache.disk.h kir;
    private r kis;
    private com.facebook.imagepipeline.h.e kit;
    private com.facebook.imagepipeline.a.a.b kiu;

    public static j cGQ() {
        return (j) com.facebook.common.internal.g.checkNotNull(kil, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.ev(context).cGE());
    }

    public static void a(h hVar) {
        kil = new j(hVar);
    }

    public j(h hVar) {
        this.kim = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.khy = new ar(hVar.cGp().cGg());
    }

    public com.facebook.imagepipeline.a.a.b cGR() {
        if (this.kiu == null) {
            this.kiu = com.facebook.imagepipeline.a.a.c.a(cGX(), this.kim.cGp());
        }
        return this.kiu;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cGS() {
        if (this.kin == null) {
            this.kin = com.facebook.imagepipeline.c.a.a(this.kim.cGk(), this.kim.cGu(), cGX(), this.kim.cGC().cGG());
        }
        return this.kin;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cGi() {
        if (this.khv == null) {
            this.khv = com.facebook.imagepipeline.c.b.a(cGS(), this.kim.cGq());
        }
        return this.khv;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cGT() {
        if (this.kio == null) {
            this.kio = com.facebook.imagepipeline.c.m.a(this.kim.cGo(), this.kim.cGu(), cGX());
        }
        return this.kio;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cGU() {
        if (this.khw == null) {
            this.khw = n.a(cGT(), this.kim.cGq());
        }
        return this.khw;
    }

    private com.facebook.imagepipeline.decoder.b cGr() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.khJ == null) {
            if (this.kim.cGr() != null) {
                this.khJ = this.kim.cGr();
            } else {
                if (cGR() != null) {
                    dVar = cGR().cFl();
                } else {
                    dVar = null;
                }
                if (this.kim.cGB() == null) {
                    this.khJ = new com.facebook.imagepipeline.decoder.a(dVar, cGY(), this.kim.cFU());
                } else {
                    this.khJ = new com.facebook.imagepipeline.decoder.a(dVar, cGY(), this.kim.cFU(), this.kim.cGB().cHB());
                    com.facebook.c.d.cFk().eS(this.kim.cGB().cHC());
                }
            }
        }
        return this.khJ;
    }

    private com.facebook.imagepipeline.c.e cGV() {
        if (this.khx == null) {
            this.khx = new com.facebook.imagepipeline.c.e(cGW(), this.kim.cGw().cIA(), this.kim.cGw().cIB(), this.kim.cGp().cGc(), this.kim.cGp().cGd(), this.kim.cGq());
        }
        return this.khx;
    }

    public com.facebook.cache.disk.h cGW() {
        if (this.kip == null) {
            this.kip = this.kim.cGm().a(this.kim.cGt());
        }
        return this.kip;
    }

    public g cDB() {
        if (this.kbQ == null) {
            this.kbQ = new g(cHa(), this.kim.cGy(), this.kim.cGs(), cGi(), cGU(), cGV(), cHc(), this.kim.cGj(), this.khy, com.facebook.common.internal.j.ay(false));
        }
        return this.kbQ;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.cIw());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.cIA()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cGX() {
        if (this.khN == null) {
            this.khN = a(this.kim.cGw(), cGY());
        }
        return this.khN;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int cIy = qVar.cIy();
            return new com.facebook.imagepipeline.h.a(qVar.cIw(), cIy, new Pools.SynchronizedPool(cIy));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.cIx());
        }
    }

    public com.facebook.imagepipeline.h.e cGY() {
        if (this.kit == null) {
            this.kit = a(this.kim.cGw(), this.kim.cGC().cGL());
        }
        return this.kit;
    }

    private l cGZ() {
        if (this.kiq == null) {
            this.kiq = new l(this.kim.getContext(), this.kim.cGw().cIC(), cGr(), this.kim.cGx(), this.kim.cGn(), this.kim.cGz(), this.kim.cGC().cGM(), this.kim.cGp(), this.kim.cGw().cIA(), cGi(), cGU(), cGV(), cHc(), cHd(), this.kim.cGC().cGJ(), this.kim.cGj(), cGX(), this.kim.cGC().cGH());
        }
        return this.kiq;
    }

    private m cHa() {
        if (this.khs == null) {
            this.khs = new m(cGZ(), this.kim.cGv(), this.kim.cGz(), this.kim.cGC().cGL(), this.khy, this.kim.cGC().cGK());
        }
        return this.khs;
    }

    public com.facebook.cache.disk.h cHb() {
        if (this.kir == null) {
            this.kir = this.kim.cGm().a(this.kim.cGA());
        }
        return this.kir;
    }

    private com.facebook.imagepipeline.c.e cHc() {
        if (this.kgM == null) {
            this.kgM = new com.facebook.imagepipeline.c.e(cHb(), this.kim.cGw().cIA(), this.kim.cGw().cIB(), this.kim.cGp().cGc(), this.kim.cGp().cGd(), this.kim.cGq());
        }
        return this.kgM;
    }

    public r cHd() {
        if (this.kis == null) {
            this.kis = this.kim.cGC().cGI() ? new s(this.kim.getContext(), this.kim.cGp().cGc(), this.kim.cGp().cGd()) : new y();
        }
        return this.kis;
    }
}
