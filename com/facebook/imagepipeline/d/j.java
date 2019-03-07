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
    private static j jHJ = null;
    private g jBs;
    private m jGR;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jGU;
    private t<com.facebook.cache.common.b, PooledByteBuffer> jGV;
    private com.facebook.imagepipeline.c.e jGW;
    private final ar jGX;
    private com.facebook.imagepipeline.c.e jGl;
    private final h jHK;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jHL;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> jHM;
    private com.facebook.cache.disk.h jHN;
    private l jHO;
    private com.facebook.cache.disk.h jHP;
    private r jHQ;
    private com.facebook.imagepipeline.h.e jHR;
    private com.facebook.imagepipeline.a.a.b jHS;
    private com.facebook.imagepipeline.decoder.b jHi;
    private com.facebook.imagepipeline.b.f jHm;

    public static j cxG() {
        return (j) com.facebook.common.internal.g.checkNotNull(jHJ, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.eP(context).cxu());
    }

    public static void a(h hVar) {
        jHJ = new j(hVar);
    }

    public j(h hVar) {
        this.jHK = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.jGX = new ar(hVar.cxf().cwW());
    }

    public com.facebook.imagepipeline.a.a.b cxH() {
        if (this.jHS == null) {
            this.jHS = com.facebook.imagepipeline.a.a.c.a(cxN(), this.jHK.cxf());
        }
        return this.jHS;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxI() {
        if (this.jHL == null) {
            this.jHL = com.facebook.imagepipeline.c.a.a(this.jHK.cxa(), this.jHK.cxk(), cxN(), this.jHK.cxs().cxw());
        }
        return this.jHL;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cwY() {
        if (this.jGU == null) {
            this.jGU = com.facebook.imagepipeline.c.b.a(cxI(), this.jHK.cxg());
        }
        return this.jGU;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> cxJ() {
        if (this.jHM == null) {
            this.jHM = com.facebook.imagepipeline.c.m.a(this.jHK.cxe(), this.jHK.cxk(), cxN());
        }
        return this.jHM;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> cxK() {
        if (this.jGV == null) {
            this.jGV = n.a(cxJ(), this.jHK.cxg());
        }
        return this.jGV;
    }

    private com.facebook.imagepipeline.decoder.b cxh() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.jHi == null) {
            if (this.jHK.cxh() != null) {
                this.jHi = this.jHK.cxh();
            } else {
                if (cxH() != null) {
                    dVar = cxH().cwb();
                } else {
                    dVar = null;
                }
                if (this.jHK.cxr() == null) {
                    this.jHi = new com.facebook.imagepipeline.decoder.a(dVar, cxO(), this.jHK.cwK());
                } else {
                    this.jHi = new com.facebook.imagepipeline.decoder.a(dVar, cxO(), this.jHK.cwK(), this.jHK.cxr().cyr());
                    com.facebook.c.d.cwa().ey(this.jHK.cxr().cys());
                }
            }
        }
        return this.jHi;
    }

    private com.facebook.imagepipeline.c.e cxL() {
        if (this.jGW == null) {
            this.jGW = new com.facebook.imagepipeline.c.e(cxM(), this.jHK.cxm().czp(), this.jHK.cxm().czq(), this.jHK.cxf().cwS(), this.jHK.cxf().cwT(), this.jHK.cxg());
        }
        return this.jGW;
    }

    public com.facebook.cache.disk.h cxM() {
        if (this.jHN == null) {
            this.jHN = this.jHK.cxc().a(this.jHK.cxj());
        }
        return this.jHN;
    }

    public g cus() {
        if (this.jBs == null) {
            this.jBs = new g(cxQ(), this.jHK.cxo(), this.jHK.cxi(), cwY(), cxK(), cxL(), cxS(), this.jHK.cwZ(), this.jGX, com.facebook.common.internal.j.aE(false));
        }
        return this.jBs;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.czl());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.czp()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f cxN() {
        if (this.jHm == null) {
            this.jHm = a(this.jHK.cxm(), cxO());
        }
        return this.jHm;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int czn = qVar.czn();
            return new com.facebook.imagepipeline.h.a(qVar.czl(), czn, new Pools.SynchronizedPool(czn));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.czm());
        }
    }

    public com.facebook.imagepipeline.h.e cxO() {
        if (this.jHR == null) {
            this.jHR = a(this.jHK.cxm(), this.jHK.cxs().cxB());
        }
        return this.jHR;
    }

    private l cxP() {
        if (this.jHO == null) {
            this.jHO = new l(this.jHK.getContext(), this.jHK.cxm().czr(), cxh(), this.jHK.cxn(), this.jHK.cxd(), this.jHK.cxp(), this.jHK.cxs().cxC(), this.jHK.cxf(), this.jHK.cxm().czp(), cwY(), cxK(), cxL(), cxS(), cxT(), this.jHK.cxs().cxz(), this.jHK.cwZ(), cxN(), this.jHK.cxs().cxx());
        }
        return this.jHO;
    }

    private m cxQ() {
        if (this.jGR == null) {
            this.jGR = new m(cxP(), this.jHK.cxl(), this.jHK.cxp(), this.jHK.cxs().cxB(), this.jGX, this.jHK.cxs().cxA());
        }
        return this.jGR;
    }

    public com.facebook.cache.disk.h cxR() {
        if (this.jHP == null) {
            this.jHP = this.jHK.cxc().a(this.jHK.cxq());
        }
        return this.jHP;
    }

    private com.facebook.imagepipeline.c.e cxS() {
        if (this.jGl == null) {
            this.jGl = new com.facebook.imagepipeline.c.e(cxR(), this.jHK.cxm().czp(), this.jHK.cxm().czq(), this.jHK.cxf().cwS(), this.jHK.cxf().cwT(), this.jHK.cxg());
        }
        return this.jGl;
    }

    public r cxT() {
        if (this.jHQ == null) {
            this.jHQ = this.jHK.cxs().cxy() ? new s(this.jHK.getContext(), this.jHK.cxf().cwS(), this.jHK.cxf().cwT()) : new y();
        }
        return this.jHQ;
    }
}
