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
    private static j jHo = null;
    private g jAX;
    private com.facebook.imagepipeline.c.e jFQ;
    private t<com.facebook.cache.common.b, PooledByteBuffer> jGA;
    private com.facebook.imagepipeline.c.e jGB;
    private final ar jGC;
    private com.facebook.imagepipeline.decoder.b jGN;
    private com.facebook.imagepipeline.b.f jGR;
    private m jGw;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jGz;
    private final h jHp;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jHq;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> jHr;
    private com.facebook.cache.disk.h jHs;
    private l jHt;
    private com.facebook.cache.disk.h jHu;
    private r jHv;
    private com.facebook.imagepipeline.h.e jHw;
    private com.facebook.imagepipeline.a.a.b jHx;

    public static j cxM() {
        return (j) com.facebook.common.internal.g.checkNotNull(jHo, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eN(context).cxA());
    }

    public static void a(h hVar) {
        jHo = new j(hVar);
    }

    public j(h hVar) {
        this.jHp = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.jGC = new ar(hVar.cxl().cxc());
    }

    public com.facebook.imagepipeline.a.a.b cxN() {
        if (this.jHx == null) {
            this.jHx = com.facebook.imagepipeline.a.a.c.a(cxT(), this.jHp.cxl());
        }
        return this.jHx;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxO() {
        if (this.jHq == null) {
            this.jHq = com.facebook.imagepipeline.c.a.a(this.jHp.cxg(), this.jHp.cxq(), cxT(), this.jHp.cxy().cxC());
        }
        return this.jHq;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxe() {
        if (this.jGz == null) {
            this.jGz = com.facebook.imagepipeline.c.b.a(cxO(), this.jHp.cxm());
        }
        return this.jGz;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cxP() {
        if (this.jHr == null) {
            this.jHr = com.facebook.imagepipeline.c.m.a(this.jHp.cxk(), this.jHp.cxq(), cxT());
        }
        return this.jHr;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cxQ() {
        if (this.jGA == null) {
            this.jGA = n.a(cxP(), this.jHp.cxm());
        }
        return this.jGA;
    }

    private com.facebook.imagepipeline.decoder.b cxn() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.jGN == null) {
            if (this.jHp.cxn() != null) {
                this.jGN = this.jHp.cxn();
            } else {
                if (cxN() != null) {
                    dVar = cxN().cwh();
                } else {
                    dVar = null;
                }
                if (this.jHp.cxx() == null) {
                    this.jGN = new com.facebook.imagepipeline.decoder.a(dVar, cxU(), this.jHp.cwQ());
                } else {
                    this.jGN = new com.facebook.imagepipeline.decoder.a(dVar, cxU(), this.jHp.cwQ(), this.jHp.cxx().cyx());
                    com.facebook.c.d.cwg().ev(this.jHp.cxx().cyy());
                }
            }
        }
        return this.jGN;
    }

    private com.facebook.imagepipeline.c.e cxR() {
        if (this.jGB == null) {
            this.jGB = new com.facebook.imagepipeline.c.e(cxS(), this.jHp.cxs().czv(), this.jHp.cxs().czw(), this.jHp.cxl().cwY(), this.jHp.cxl().cwZ(), this.jHp.cxm());
        }
        return this.jGB;
    }

    public com.facebook.cache.disk.h cxS() {
        if (this.jHs == null) {
            this.jHs = this.jHp.cxi().a(this.jHp.cxp());
        }
        return this.jHs;
    }

    public g cuy() {
        if (this.jAX == null) {
            this.jAX = new g(cxW(), this.jHp.cxu(), this.jHp.cxo(), cxe(), cxQ(), cxR(), cxY(), this.jHp.cxf(), this.jGC, com.facebook.common.internal.j.aB(false));
        }
        return this.jAX;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.czr());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.czv()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cxT() {
        if (this.jGR == null) {
            this.jGR = a(this.jHp.cxs(), cxU());
        }
        return this.jGR;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int czt = qVar.czt();
            return new com.facebook.imagepipeline.h.a(qVar.czr(), czt, new Pools.SynchronizedPool(czt));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.czs());
        }
    }

    public com.facebook.imagepipeline.h.e cxU() {
        if (this.jHw == null) {
            this.jHw = a(this.jHp.cxs(), this.jHp.cxy().cxH());
        }
        return this.jHw;
    }

    private l cxV() {
        if (this.jHt == null) {
            this.jHt = new l(this.jHp.getContext(), this.jHp.cxs().czx(), cxn(), this.jHp.cxt(), this.jHp.cxj(), this.jHp.cxv(), this.jHp.cxy().cxI(), this.jHp.cxl(), this.jHp.cxs().czv(), cxe(), cxQ(), cxR(), cxY(), cxZ(), this.jHp.cxy().cxF(), this.jHp.cxf(), cxT(), this.jHp.cxy().cxD());
        }
        return this.jHt;
    }

    private m cxW() {
        if (this.jGw == null) {
            this.jGw = new m(cxV(), this.jHp.cxr(), this.jHp.cxv(), this.jHp.cxy().cxH(), this.jGC, this.jHp.cxy().cxG());
        }
        return this.jGw;
    }

    public com.facebook.cache.disk.h cxX() {
        if (this.jHu == null) {
            this.jHu = this.jHp.cxi().a(this.jHp.cxw());
        }
        return this.jHu;
    }

    private com.facebook.imagepipeline.c.e cxY() {
        if (this.jFQ == null) {
            this.jFQ = new com.facebook.imagepipeline.c.e(cxX(), this.jHp.cxs().czv(), this.jHp.cxs().czw(), this.jHp.cxl().cwY(), this.jHp.cxl().cwZ(), this.jHp.cxm());
        }
        return this.jFQ;
    }

    public r cxZ() {
        if (this.jHv == null) {
            this.jHv = this.jHp.cxy().cxE() ? new s(this.jHp.getContext(), this.jHp.cxl().cwY(), this.jHp.cxl().cwZ()) : new y();
        }
        return this.jHv;
    }
}
