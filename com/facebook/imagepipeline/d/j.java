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
    private static j jHp = null;
    private g jAY;
    private com.facebook.imagepipeline.c.e jFR;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jGA;
    private t<com.facebook.cache.common.b, PooledByteBuffer> jGB;
    private com.facebook.imagepipeline.c.e jGC;
    private final ar jGD;
    private com.facebook.imagepipeline.decoder.b jGO;
    private com.facebook.imagepipeline.b.f jGS;
    private m jGx;
    private final h jHq;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jHr;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> jHs;
    private com.facebook.cache.disk.h jHt;
    private l jHu;
    private com.facebook.cache.disk.h jHv;
    private r jHw;
    private com.facebook.imagepipeline.h.e jHx;
    private com.facebook.imagepipeline.a.a.b jHy;

    public static j cxM() {
        return (j) com.facebook.common.internal.g.checkNotNull(jHp, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eN(context).cxA());
    }

    public static void a(h hVar) {
        jHp = new j(hVar);
    }

    public j(h hVar) {
        this.jHq = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.jGD = new ar(hVar.cxl().cxc());
    }

    public com.facebook.imagepipeline.a.a.b cxN() {
        if (this.jHy == null) {
            this.jHy = com.facebook.imagepipeline.a.a.c.a(cxT(), this.jHq.cxl());
        }
        return this.jHy;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxO() {
        if (this.jHr == null) {
            this.jHr = com.facebook.imagepipeline.c.a.a(this.jHq.cxg(), this.jHq.cxq(), cxT(), this.jHq.cxy().cxC());
        }
        return this.jHr;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxe() {
        if (this.jGA == null) {
            this.jGA = com.facebook.imagepipeline.c.b.a(cxO(), this.jHq.cxm());
        }
        return this.jGA;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cxP() {
        if (this.jHs == null) {
            this.jHs = com.facebook.imagepipeline.c.m.a(this.jHq.cxk(), this.jHq.cxq(), cxT());
        }
        return this.jHs;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cxQ() {
        if (this.jGB == null) {
            this.jGB = n.a(cxP(), this.jHq.cxm());
        }
        return this.jGB;
    }

    private com.facebook.imagepipeline.decoder.b cxn() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.jGO == null) {
            if (this.jHq.cxn() != null) {
                this.jGO = this.jHq.cxn();
            } else {
                if (cxN() != null) {
                    dVar = cxN().cwh();
                } else {
                    dVar = null;
                }
                if (this.jHq.cxx() == null) {
                    this.jGO = new com.facebook.imagepipeline.decoder.a(dVar, cxU(), this.jHq.cwQ());
                } else {
                    this.jGO = new com.facebook.imagepipeline.decoder.a(dVar, cxU(), this.jHq.cwQ(), this.jHq.cxx().cyx());
                    com.facebook.c.d.cwg().ev(this.jHq.cxx().cyy());
                }
            }
        }
        return this.jGO;
    }

    private com.facebook.imagepipeline.c.e cxR() {
        if (this.jGC == null) {
            this.jGC = new com.facebook.imagepipeline.c.e(cxS(), this.jHq.cxs().czv(), this.jHq.cxs().czw(), this.jHq.cxl().cwY(), this.jHq.cxl().cwZ(), this.jHq.cxm());
        }
        return this.jGC;
    }

    public com.facebook.cache.disk.h cxS() {
        if (this.jHt == null) {
            this.jHt = this.jHq.cxi().a(this.jHq.cxp());
        }
        return this.jHt;
    }

    public g cuy() {
        if (this.jAY == null) {
            this.jAY = new g(cxW(), this.jHq.cxu(), this.jHq.cxo(), cxe(), cxQ(), cxR(), cxY(), this.jHq.cxf(), this.jGD, com.facebook.common.internal.j.aB(false));
        }
        return this.jAY;
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
        if (this.jGS == null) {
            this.jGS = a(this.jHq.cxs(), cxU());
        }
        return this.jGS;
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
        if (this.jHx == null) {
            this.jHx = a(this.jHq.cxs(), this.jHq.cxy().cxH());
        }
        return this.jHx;
    }

    private l cxV() {
        if (this.jHu == null) {
            this.jHu = new l(this.jHq.getContext(), this.jHq.cxs().czx(), cxn(), this.jHq.cxt(), this.jHq.cxj(), this.jHq.cxv(), this.jHq.cxy().cxI(), this.jHq.cxl(), this.jHq.cxs().czv(), cxe(), cxQ(), cxR(), cxY(), cxZ(), this.jHq.cxy().cxF(), this.jHq.cxf(), cxT(), this.jHq.cxy().cxD());
        }
        return this.jHu;
    }

    private m cxW() {
        if (this.jGx == null) {
            this.jGx = new m(cxV(), this.jHq.cxr(), this.jHq.cxv(), this.jHq.cxy().cxH(), this.jGD, this.jHq.cxy().cxG());
        }
        return this.jGx;
    }

    public com.facebook.cache.disk.h cxX() {
        if (this.jHv == null) {
            this.jHv = this.jHq.cxi().a(this.jHq.cxw());
        }
        return this.jHv;
    }

    private com.facebook.imagepipeline.c.e cxY() {
        if (this.jFR == null) {
            this.jFR = new com.facebook.imagepipeline.c.e(cxX(), this.jHq.cxs().czv(), this.jHq.cxs().czw(), this.jHq.cxl().cwY(), this.jHq.cxl().cwZ(), this.jHq.cxm());
        }
        return this.jFR;
    }

    public r cxZ() {
        if (this.jHw == null) {
            this.jHw = this.jHq.cxy().cxE() ? new s(this.jHq.getContext(), this.jHq.cxl().cwY(), this.jHq.cxl().cwZ()) : new y();
        }
        return this.jHw;
    }
}
