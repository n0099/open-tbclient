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
    private static j khm = null;
    private g kaV;
    private com.facebook.imagepipeline.c.e kfO;
    private final ar kgA;
    private com.facebook.imagepipeline.decoder.b kgL;
    private com.facebook.imagepipeline.b.f kgP;
    private m kgu;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kgx;
    private t<com.facebook.cache.common.b, PooledByteBuffer> kgy;
    private com.facebook.imagepipeline.c.e kgz;
    private final h khn;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kho;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> khp;
    private com.facebook.cache.disk.h khq;
    private l khr;
    private com.facebook.cache.disk.h khs;
    private r kht;
    private com.facebook.imagepipeline.h.e khu;
    private com.facebook.imagepipeline.a.a.b khv;

    public static j cIM() {
        return (j) com.facebook.common.internal.g.checkNotNull(khm, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eE(context).cIA());
    }

    public static void a(h hVar) {
        khm = new j(hVar);
    }

    public j(h hVar) {
        this.khn = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.kgA = new ar(hVar.cIl().cIc());
    }

    public com.facebook.imagepipeline.a.a.b cIN() {
        if (this.khv == null) {
            this.khv = com.facebook.imagepipeline.a.a.c.a(cIT(), this.khn.cIl());
        }
        return this.khv;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cIO() {
        if (this.kho == null) {
            this.kho = com.facebook.imagepipeline.c.a.a(this.khn.cIg(), this.khn.cIq(), cIT(), this.khn.cIy().cIC());
        }
        return this.kho;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cIe() {
        if (this.kgx == null) {
            this.kgx = com.facebook.imagepipeline.c.b.a(cIO(), this.khn.cIm());
        }
        return this.kgx;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cIP() {
        if (this.khp == null) {
            this.khp = com.facebook.imagepipeline.c.m.a(this.khn.cIk(), this.khn.cIq(), cIT());
        }
        return this.khp;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cIQ() {
        if (this.kgy == null) {
            this.kgy = n.a(cIP(), this.khn.cIm());
        }
        return this.kgy;
    }

    private com.facebook.imagepipeline.decoder.b cIn() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.kgL == null) {
            if (this.khn.cIn() != null) {
                this.kgL = this.khn.cIn();
            } else {
                if (cIN() != null) {
                    dVar = cIN().cHh();
                } else {
                    dVar = null;
                }
                if (this.khn.cIx() == null) {
                    this.kgL = new com.facebook.imagepipeline.decoder.a(dVar, cIU(), this.khn.cHQ());
                } else {
                    this.kgL = new com.facebook.imagepipeline.decoder.a(dVar, cIU(), this.khn.cHQ(), this.khn.cIx().cJx());
                    com.facebook.c.d.cHg().eG(this.khn.cIx().cJy());
                }
            }
        }
        return this.kgL;
    }

    private com.facebook.imagepipeline.c.e cIR() {
        if (this.kgz == null) {
            this.kgz = new com.facebook.imagepipeline.c.e(cIS(), this.khn.cIs().cKw(), this.khn.cIs().cKx(), this.khn.cIl().cHY(), this.khn.cIl().cHZ(), this.khn.cIm());
        }
        return this.kgz;
    }

    public com.facebook.cache.disk.h cIS() {
        if (this.khq == null) {
            this.khq = this.khn.cIi().a(this.khn.cIp());
        }
        return this.khq;
    }

    public g cFw() {
        if (this.kaV == null) {
            this.kaV = new g(cIW(), this.khn.cIu(), this.khn.cIo(), cIe(), cIQ(), cIR(), cIY(), this.khn.cIf(), this.kgA, com.facebook.common.internal.j.aD(false));
        }
        return this.kaV;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.cKs());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.cKw()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cIT() {
        if (this.kgP == null) {
            this.kgP = a(this.khn.cIs(), cIU());
        }
        return this.kgP;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int cKu = qVar.cKu();
            return new com.facebook.imagepipeline.h.a(qVar.cKs(), cKu, new Pools.SynchronizedPool(cKu));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.cKt());
        }
    }

    public com.facebook.imagepipeline.h.e cIU() {
        if (this.khu == null) {
            this.khu = a(this.khn.cIs(), this.khn.cIy().cIH());
        }
        return this.khu;
    }

    private l cIV() {
        if (this.khr == null) {
            this.khr = new l(this.khn.getContext(), this.khn.cIs().cKy(), cIn(), this.khn.cIt(), this.khn.cIj(), this.khn.cIv(), this.khn.cIy().cII(), this.khn.cIl(), this.khn.cIs().cKw(), cIe(), cIQ(), cIR(), cIY(), cIZ(), this.khn.cIy().cIF(), this.khn.cIf(), cIT(), this.khn.cIy().cID());
        }
        return this.khr;
    }

    private m cIW() {
        if (this.kgu == null) {
            this.kgu = new m(cIV(), this.khn.cIr(), this.khn.cIv(), this.khn.cIy().cIH(), this.kgA, this.khn.cIy().cIG());
        }
        return this.kgu;
    }

    public com.facebook.cache.disk.h cIX() {
        if (this.khs == null) {
            this.khs = this.khn.cIi().a(this.khn.cIw());
        }
        return this.khs;
    }

    private com.facebook.imagepipeline.c.e cIY() {
        if (this.kfO == null) {
            this.kfO = new com.facebook.imagepipeline.c.e(cIX(), this.khn.cIs().cKw(), this.khn.cIs().cKx(), this.khn.cIl().cHY(), this.khn.cIl().cHZ(), this.khn.cIm());
        }
        return this.kfO;
    }

    public r cIZ() {
        if (this.kht == null) {
            this.kht = this.khn.cIy().cIE() ? new s(this.khn.getContext(), this.khn.cIl().cHY(), this.khn.cIl().cHZ()) : new y();
        }
        return this.kht;
    }
}
