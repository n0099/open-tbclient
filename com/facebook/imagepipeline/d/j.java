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
    private static j jHU = null;
    private g jBD;
    private com.facebook.imagepipeline.c.e jGw;
    private final h jHV;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jHW;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> jHX;
    private com.facebook.cache.disk.h jHY;
    private l jHZ;
    private m jHc;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jHf;
    private t<com.facebook.cache.common.b, PooledByteBuffer> jHg;
    private com.facebook.imagepipeline.c.e jHh;
    private final ar jHi;
    private com.facebook.imagepipeline.decoder.b jHt;
    private com.facebook.imagepipeline.b.f jHx;
    private com.facebook.cache.disk.h jIa;
    private r jIb;
    private com.facebook.imagepipeline.h.e jIc;
    private com.facebook.imagepipeline.a.a.b jId;

    public static j cxT() {
        return (j) com.facebook.common.internal.g.checkNotNull(jHU, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eO(context).cxH());
    }

    public static void a(h hVar) {
        jHU = new j(hVar);
    }

    public j(h hVar) {
        this.jHV = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.jHi = new ar(hVar.cxs().cxj());
    }

    public com.facebook.imagepipeline.a.a.b cxU() {
        if (this.jId == null) {
            this.jId = com.facebook.imagepipeline.a.a.c.a(cya(), this.jHV.cxs());
        }
        return this.jId;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxV() {
        if (this.jHW == null) {
            this.jHW = com.facebook.imagepipeline.c.a.a(this.jHV.cxn(), this.jHV.cxx(), cya(), this.jHV.cxF().cxJ());
        }
        return this.jHW;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxl() {
        if (this.jHf == null) {
            this.jHf = com.facebook.imagepipeline.c.b.a(cxV(), this.jHV.cxt());
        }
        return this.jHf;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cxW() {
        if (this.jHX == null) {
            this.jHX = com.facebook.imagepipeline.c.m.a(this.jHV.cxr(), this.jHV.cxx(), cya());
        }
        return this.jHX;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cxX() {
        if (this.jHg == null) {
            this.jHg = n.a(cxW(), this.jHV.cxt());
        }
        return this.jHg;
    }

    private com.facebook.imagepipeline.decoder.b cxu() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.jHt == null) {
            if (this.jHV.cxu() != null) {
                this.jHt = this.jHV.cxu();
            } else {
                if (cxU() != null) {
                    dVar = cxU().cwo();
                } else {
                    dVar = null;
                }
                if (this.jHV.cxE() == null) {
                    this.jHt = new com.facebook.imagepipeline.decoder.a(dVar, cyb(), this.jHV.cwX());
                } else {
                    this.jHt = new com.facebook.imagepipeline.decoder.a(dVar, cyb(), this.jHV.cwX(), this.jHV.cxE().cyE());
                    com.facebook.c.d.cwn().ey(this.jHV.cxE().cyF());
                }
            }
        }
        return this.jHt;
    }

    private com.facebook.imagepipeline.c.e cxY() {
        if (this.jHh == null) {
            this.jHh = new com.facebook.imagepipeline.c.e(cxZ(), this.jHV.cxz().czC(), this.jHV.cxz().czD(), this.jHV.cxs().cxf(), this.jHV.cxs().cxg(), this.jHV.cxt());
        }
        return this.jHh;
    }

    public com.facebook.cache.disk.h cxZ() {
        if (this.jHY == null) {
            this.jHY = this.jHV.cxp().a(this.jHV.cxw());
        }
        return this.jHY;
    }

    public g cuF() {
        if (this.jBD == null) {
            this.jBD = new g(cyd(), this.jHV.cxB(), this.jHV.cxv(), cxl(), cxX(), cxY(), cyf(), this.jHV.cxm(), this.jHi, com.facebook.common.internal.j.aF(false));
        }
        return this.jBD;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.czy());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.czC()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cya() {
        if (this.jHx == null) {
            this.jHx = a(this.jHV.cxz(), cyb());
        }
        return this.jHx;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int czA = qVar.czA();
            return new com.facebook.imagepipeline.h.a(qVar.czy(), czA, new Pools.SynchronizedPool(czA));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.czz());
        }
    }

    public com.facebook.imagepipeline.h.e cyb() {
        if (this.jIc == null) {
            this.jIc = a(this.jHV.cxz(), this.jHV.cxF().cxO());
        }
        return this.jIc;
    }

    private l cyc() {
        if (this.jHZ == null) {
            this.jHZ = new l(this.jHV.getContext(), this.jHV.cxz().czE(), cxu(), this.jHV.cxA(), this.jHV.cxq(), this.jHV.cxC(), this.jHV.cxF().cxP(), this.jHV.cxs(), this.jHV.cxz().czC(), cxl(), cxX(), cxY(), cyf(), cyg(), this.jHV.cxF().cxM(), this.jHV.cxm(), cya(), this.jHV.cxF().cxK());
        }
        return this.jHZ;
    }

    private m cyd() {
        if (this.jHc == null) {
            this.jHc = new m(cyc(), this.jHV.cxy(), this.jHV.cxC(), this.jHV.cxF().cxO(), this.jHi, this.jHV.cxF().cxN());
        }
        return this.jHc;
    }

    public com.facebook.cache.disk.h cye() {
        if (this.jIa == null) {
            this.jIa = this.jHV.cxp().a(this.jHV.cxD());
        }
        return this.jIa;
    }

    private com.facebook.imagepipeline.c.e cyf() {
        if (this.jGw == null) {
            this.jGw = new com.facebook.imagepipeline.c.e(cye(), this.jHV.cxz().czC(), this.jHV.cxz().czD(), this.jHV.cxs().cxf(), this.jHV.cxs().cxg(), this.jHV.cxt());
        }
        return this.jGw;
    }

    public r cyg() {
        if (this.jIb == null) {
            this.jIb = this.jHV.cxF().cxL() ? new s(this.jHV.getContext(), this.jHV.cxs().cxf(), this.jHV.cxs().cxg()) : new y();
        }
        return this.jIb;
    }
}
