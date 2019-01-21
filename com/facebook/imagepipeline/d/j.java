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
import com.facebook.imagepipeline.producers.aq;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class j {
    private static j isd = null;
    private g ilR;
    private com.facebook.imagepipeline.c.e iqF;
    private com.facebook.imagepipeline.decoder.b irC;
    private com.facebook.imagepipeline.b.f irG;
    private m irl;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iro;
    private t<com.facebook.cache.common.b, PooledByteBuffer> irp;
    private com.facebook.imagepipeline.c.e irq;
    private final aq irr;
    private final h ise;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> isf;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> isg;
    private com.facebook.cache.disk.h ish;
    private l isi;
    private com.facebook.cache.disk.h isj;
    private r isk;
    private com.facebook.imagepipeline.h.e isl;
    private com.facebook.imagepipeline.a.a.b ism;

    public static j bYF() {
        return (j) com.facebook.common.internal.g.checkNotNull(isd, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.du(context).bYt());
    }

    public static void a(h hVar) {
        isd = new j(hVar);
    }

    public j(h hVar) {
        this.ise = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.irr = new aq(hVar.bYe().bXV());
    }

    public com.facebook.imagepipeline.a.a.b bYG() {
        if (this.ism == null) {
            this.ism = com.facebook.imagepipeline.a.a.c.a(bYM(), this.ise.bYe());
        }
        return this.ism;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bYH() {
        if (this.isf == null) {
            this.isf = com.facebook.imagepipeline.c.a.a(this.ise.bXZ(), this.ise.bYj(), bYM(), this.ise.bYr().bYv());
        }
        return this.isf;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bXX() {
        if (this.iro == null) {
            this.iro = com.facebook.imagepipeline.c.b.a(bYH(), this.ise.bYf());
        }
        return this.iro;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> bYI() {
        if (this.isg == null) {
            this.isg = com.facebook.imagepipeline.c.m.a(this.ise.bYd(), this.ise.bYj(), bYM());
        }
        return this.isg;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> bYJ() {
        if (this.irp == null) {
            this.irp = n.a(bYI(), this.ise.bYf());
        }
        return this.irp;
    }

    private com.facebook.imagepipeline.decoder.b bYg() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.irC == null) {
            if (this.ise.bYg() != null) {
                this.irC = this.ise.bYg();
            } else {
                if (bYG() != null) {
                    dVar = bYG().bXa();
                } else {
                    dVar = null;
                }
                if (this.ise.bYq() == null) {
                    this.irC = new com.facebook.imagepipeline.decoder.a(dVar, bYN(), this.ise.bXJ());
                } else {
                    this.irC = new com.facebook.imagepipeline.decoder.a(dVar, bYN(), this.ise.bXJ(), this.ise.bYq().bZm());
                    com.facebook.c.d.bWZ().eu(this.ise.bYq().bZn());
                }
            }
        }
        return this.irC;
    }

    private com.facebook.imagepipeline.c.e bYK() {
        if (this.irq == null) {
            this.irq = new com.facebook.imagepipeline.c.e(bYL(), this.ise.bYl().cak(), this.ise.bYl().cal(), this.ise.bYe().bXR(), this.ise.bYe().bXS(), this.ise.bYf());
        }
        return this.irq;
    }

    public com.facebook.cache.disk.h bYL() {
        if (this.ish == null) {
            this.ish = this.ise.bYb().a(this.ise.bYi());
        }
        return this.ish;
    }

    public g bVv() {
        if (this.ilR == null) {
            this.ilR = new g(bYP(), this.ise.bYn(), this.ise.bYh(), bXX(), bYJ(), bYK(), bYR(), this.ise.bXY(), this.irr, com.facebook.common.internal.j.ap(false));
        }
        return this.ilR;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.cag());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.cak()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f bYM() {
        if (this.irG == null) {
            this.irG = a(this.ise.bYl(), bYN());
        }
        return this.irG;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int cai = qVar.cai();
            return new com.facebook.imagepipeline.h.a(qVar.cag(), cai, new Pools.SynchronizedPool(cai));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.cah());
        }
    }

    public com.facebook.imagepipeline.h.e bYN() {
        if (this.isl == null) {
            this.isl = a(this.ise.bYl(), this.ise.bYr().bYA());
        }
        return this.isl;
    }

    private l bYO() {
        if (this.isi == null) {
            this.isi = new l(this.ise.getContext(), this.ise.bYl().cam(), bYg(), this.ise.bYm(), this.ise.bYc(), this.ise.bYo(), this.ise.bYr().bYB(), this.ise.bYe(), this.ise.bYl().cak(), bXX(), bYJ(), bYK(), bYR(), bYS(), this.ise.bYr().bYy(), this.ise.bXY(), bYM(), this.ise.bYr().bYw());
        }
        return this.isi;
    }

    private m bYP() {
        if (this.irl == null) {
            this.irl = new m(bYO(), this.ise.bYk(), this.ise.bYo(), this.ise.bYr().bYA(), this.irr, this.ise.bYr().bYz());
        }
        return this.irl;
    }

    public com.facebook.cache.disk.h bYQ() {
        if (this.isj == null) {
            this.isj = this.ise.bYb().a(this.ise.bYp());
        }
        return this.isj;
    }

    private com.facebook.imagepipeline.c.e bYR() {
        if (this.iqF == null) {
            this.iqF = new com.facebook.imagepipeline.c.e(bYQ(), this.ise.bYl().cak(), this.ise.bYl().cal(), this.ise.bYe().bXR(), this.ise.bYe().bXS(), this.ise.bYf());
        }
        return this.iqF;
    }

    public r bYS() {
        if (this.isk == null) {
            this.isk = this.ise.bYr().bYx() ? new s(this.ise.getContext(), this.ise.bYe().bXR(), this.ise.bYe().bXS()) : new y();
        }
        return this.isk;
    }
}
