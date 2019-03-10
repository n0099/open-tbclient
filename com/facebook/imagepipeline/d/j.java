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
    private static j jIc = null;
    private g jBL;
    private com.facebook.imagepipeline.c.e jGE;
    private com.facebook.imagepipeline.decoder.b jHB;
    private com.facebook.imagepipeline.b.f jHF;
    private m jHk;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jHn;
    private t<com.facebook.cache.common.b, PooledByteBuffer> jHo;
    private com.facebook.imagepipeline.c.e jHp;
    private final ar jHq;
    private final h jId;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jIe;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> jIf;
    private com.facebook.cache.disk.h jIg;
    private l jIh;
    private com.facebook.cache.disk.h jIi;
    private r jIj;
    private com.facebook.imagepipeline.h.e jIk;
    private com.facebook.imagepipeline.a.a.b jIl;

    public static j cxQ() {
        return (j) com.facebook.common.internal.g.checkNotNull(jIc, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eP(context).cxE());
    }

    public static void a(h hVar) {
        jIc = new j(hVar);
    }

    public j(h hVar) {
        this.jId = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.jHq = new ar(hVar.cxp().cxg());
    }

    public com.facebook.imagepipeline.a.a.b cxR() {
        if (this.jIl == null) {
            this.jIl = com.facebook.imagepipeline.a.a.c.a(cxX(), this.jId.cxp());
        }
        return this.jIl;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxS() {
        if (this.jIe == null) {
            this.jIe = com.facebook.imagepipeline.c.a.a(this.jId.cxk(), this.jId.cxu(), cxX(), this.jId.cxC().cxG());
        }
        return this.jIe;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxi() {
        if (this.jHn == null) {
            this.jHn = com.facebook.imagepipeline.c.b.a(cxS(), this.jId.cxq());
        }
        return this.jHn;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cxT() {
        if (this.jIf == null) {
            this.jIf = com.facebook.imagepipeline.c.m.a(this.jId.cxo(), this.jId.cxu(), cxX());
        }
        return this.jIf;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cxU() {
        if (this.jHo == null) {
            this.jHo = n.a(cxT(), this.jId.cxq());
        }
        return this.jHo;
    }

    private com.facebook.imagepipeline.decoder.b cxr() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.jHB == null) {
            if (this.jId.cxr() != null) {
                this.jHB = this.jId.cxr();
            } else {
                if (cxR() != null) {
                    dVar = cxR().cwl();
                } else {
                    dVar = null;
                }
                if (this.jId.cxB() == null) {
                    this.jHB = new com.facebook.imagepipeline.decoder.a(dVar, cxY(), this.jId.cwU());
                } else {
                    this.jHB = new com.facebook.imagepipeline.decoder.a(dVar, cxY(), this.jId.cwU(), this.jId.cxB().cyB());
                    com.facebook.c.d.cwk().ey(this.jId.cxB().cyC());
                }
            }
        }
        return this.jHB;
    }

    private com.facebook.imagepipeline.c.e cxV() {
        if (this.jHp == null) {
            this.jHp = new com.facebook.imagepipeline.c.e(cxW(), this.jId.cxw().czz(), this.jId.cxw().czA(), this.jId.cxp().cxc(), this.jId.cxp().cxd(), this.jId.cxq());
        }
        return this.jHp;
    }

    public com.facebook.cache.disk.h cxW() {
        if (this.jIg == null) {
            this.jIg = this.jId.cxm().a(this.jId.cxt());
        }
        return this.jIg;
    }

    public g cuC() {
        if (this.jBL == null) {
            this.jBL = new g(cya(), this.jId.cxy(), this.jId.cxs(), cxi(), cxU(), cxV(), cyc(), this.jId.cxj(), this.jHq, com.facebook.common.internal.j.aF(false));
        }
        return this.jBL;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.czv());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.czz()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cxX() {
        if (this.jHF == null) {
            this.jHF = a(this.jId.cxw(), cxY());
        }
        return this.jHF;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int czx = qVar.czx();
            return new com.facebook.imagepipeline.h.a(qVar.czv(), czx, new Pools.SynchronizedPool(czx));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.czw());
        }
    }

    public com.facebook.imagepipeline.h.e cxY() {
        if (this.jIk == null) {
            this.jIk = a(this.jId.cxw(), this.jId.cxC().cxL());
        }
        return this.jIk;
    }

    private l cxZ() {
        if (this.jIh == null) {
            this.jIh = new l(this.jId.getContext(), this.jId.cxw().czB(), cxr(), this.jId.cxx(), this.jId.cxn(), this.jId.cxz(), this.jId.cxC().cxM(), this.jId.cxp(), this.jId.cxw().czz(), cxi(), cxU(), cxV(), cyc(), cyd(), this.jId.cxC().cxJ(), this.jId.cxj(), cxX(), this.jId.cxC().cxH());
        }
        return this.jIh;
    }

    private m cya() {
        if (this.jHk == null) {
            this.jHk = new m(cxZ(), this.jId.cxv(), this.jId.cxz(), this.jId.cxC().cxL(), this.jHq, this.jId.cxC().cxK());
        }
        return this.jHk;
    }

    public com.facebook.cache.disk.h cyb() {
        if (this.jIi == null) {
            this.jIi = this.jId.cxm().a(this.jId.cxA());
        }
        return this.jIi;
    }

    private com.facebook.imagepipeline.c.e cyc() {
        if (this.jGE == null) {
            this.jGE = new com.facebook.imagepipeline.c.e(cyb(), this.jId.cxw().czz(), this.jId.cxw().czA(), this.jId.cxp().cxc(), this.jId.cxp().cxd(), this.jId.cxq());
        }
        return this.jGE;
    }

    public r cyd() {
        if (this.jIj == null) {
            this.jIj = this.jId.cxC().cxI() ? new s(this.jId.getContext(), this.jId.cxp().cxc(), this.jId.cxp().cxd()) : new y();
        }
        return this.jIj;
    }
}
