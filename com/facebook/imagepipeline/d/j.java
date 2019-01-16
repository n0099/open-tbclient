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
    private static j isc = null;
    private g ilQ;
    private com.facebook.imagepipeline.c.e iqE;
    private com.facebook.imagepipeline.decoder.b irB;
    private com.facebook.imagepipeline.b.f irF;
    private m irk;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> irn;
    private t<com.facebook.cache.common.b, PooledByteBuffer> iro;
    private com.facebook.imagepipeline.c.e irp;
    private final aq irq;
    private final h isd;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ise;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> isf;
    private com.facebook.cache.disk.h isg;
    private l ish;
    private com.facebook.cache.disk.h isi;
    private r isj;
    private com.facebook.imagepipeline.h.e isk;
    private com.facebook.imagepipeline.a.a.b isl;

    public static j bYF() {
        return (j) com.facebook.common.internal.g.checkNotNull(isc, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.du(context).bYt());
    }

    public static void a(h hVar) {
        isc = new j(hVar);
    }

    public j(h hVar) {
        this.isd = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.irq = new aq(hVar.bYe().bXV());
    }

    public com.facebook.imagepipeline.a.a.b bYG() {
        if (this.isl == null) {
            this.isl = com.facebook.imagepipeline.a.a.c.a(bYM(), this.isd.bYe());
        }
        return this.isl;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bYH() {
        if (this.ise == null) {
            this.ise = com.facebook.imagepipeline.c.a.a(this.isd.bXZ(), this.isd.bYj(), bYM(), this.isd.bYr().bYv());
        }
        return this.ise;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bXX() {
        if (this.irn == null) {
            this.irn = com.facebook.imagepipeline.c.b.a(bYH(), this.isd.bYf());
        }
        return this.irn;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> bYI() {
        if (this.isf == null) {
            this.isf = com.facebook.imagepipeline.c.m.a(this.isd.bYd(), this.isd.bYj(), bYM());
        }
        return this.isf;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> bYJ() {
        if (this.iro == null) {
            this.iro = n.a(bYI(), this.isd.bYf());
        }
        return this.iro;
    }

    private com.facebook.imagepipeline.decoder.b bYg() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.irB == null) {
            if (this.isd.bYg() != null) {
                this.irB = this.isd.bYg();
            } else {
                if (bYG() != null) {
                    dVar = bYG().bXa();
                } else {
                    dVar = null;
                }
                if (this.isd.bYq() == null) {
                    this.irB = new com.facebook.imagepipeline.decoder.a(dVar, bYN(), this.isd.bXJ());
                } else {
                    this.irB = new com.facebook.imagepipeline.decoder.a(dVar, bYN(), this.isd.bXJ(), this.isd.bYq().bZm());
                    com.facebook.c.d.bWZ().eu(this.isd.bYq().bZn());
                }
            }
        }
        return this.irB;
    }

    private com.facebook.imagepipeline.c.e bYK() {
        if (this.irp == null) {
            this.irp = new com.facebook.imagepipeline.c.e(bYL(), this.isd.bYl().cak(), this.isd.bYl().cal(), this.isd.bYe().bXR(), this.isd.bYe().bXS(), this.isd.bYf());
        }
        return this.irp;
    }

    public com.facebook.cache.disk.h bYL() {
        if (this.isg == null) {
            this.isg = this.isd.bYb().a(this.isd.bYi());
        }
        return this.isg;
    }

    public g bVv() {
        if (this.ilQ == null) {
            this.ilQ = new g(bYP(), this.isd.bYn(), this.isd.bYh(), bXX(), bYJ(), bYK(), bYR(), this.isd.bXY(), this.irq, com.facebook.common.internal.j.ap(false));
        }
        return this.ilQ;
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
        if (this.irF == null) {
            this.irF = a(this.isd.bYl(), bYN());
        }
        return this.irF;
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
        if (this.isk == null) {
            this.isk = a(this.isd.bYl(), this.isd.bYr().bYA());
        }
        return this.isk;
    }

    private l bYO() {
        if (this.ish == null) {
            this.ish = new l(this.isd.getContext(), this.isd.bYl().cam(), bYg(), this.isd.bYm(), this.isd.bYc(), this.isd.bYo(), this.isd.bYr().bYB(), this.isd.bYe(), this.isd.bYl().cak(), bXX(), bYJ(), bYK(), bYR(), bYS(), this.isd.bYr().bYy(), this.isd.bXY(), bYM(), this.isd.bYr().bYw());
        }
        return this.ish;
    }

    private m bYP() {
        if (this.irk == null) {
            this.irk = new m(bYO(), this.isd.bYk(), this.isd.bYo(), this.isd.bYr().bYA(), this.irq, this.isd.bYr().bYz());
        }
        return this.irk;
    }

    public com.facebook.cache.disk.h bYQ() {
        if (this.isi == null) {
            this.isi = this.isd.bYb().a(this.isd.bYp());
        }
        return this.isi;
    }

    private com.facebook.imagepipeline.c.e bYR() {
        if (this.iqE == null) {
            this.iqE = new com.facebook.imagepipeline.c.e(bYQ(), this.isd.bYl().cak(), this.isd.bYl().cal(), this.isd.bYe().bXR(), this.isd.bYe().bXS(), this.isd.bYf());
        }
        return this.iqE;
    }

    public r bYS() {
        if (this.isj == null) {
            this.isj = this.isd.bYr().bYx() ? new s(this.isd.getContext(), this.isd.bYe().bXR(), this.isd.bYe().bXS()) : new y();
        }
        return this.isj;
    }
}
