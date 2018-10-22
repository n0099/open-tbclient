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
    private static j ieP = null;
    private g hYC;
    private m idX;
    private com.facebook.imagepipeline.c.e idp;
    private final h ieQ;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ieR;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> ieS;
    private com.facebook.cache.disk.h ieT;
    private l ieU;
    private com.facebook.cache.disk.h ieV;
    private r ieW;
    private com.facebook.imagepipeline.h.e ieX;
    private com.facebook.imagepipeline.a.a.b ieY;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iea;
    private t<com.facebook.cache.common.b, PooledByteBuffer> ieb;
    private com.facebook.imagepipeline.c.e iec;
    private final aq ied;
    private com.facebook.imagepipeline.decoder.b ieo;
    private com.facebook.imagepipeline.b.f ies;

    public static j bVG() {
        return (j) com.facebook.common.internal.g.checkNotNull(ieP, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.dv(context).bVu());
    }

    public static void a(h hVar) {
        ieP = new j(hVar);
    }

    public j(h hVar) {
        this.ieQ = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.ied = new aq(hVar.bVf().bUW());
    }

    public com.facebook.imagepipeline.a.a.b bVH() {
        if (this.ieY == null) {
            this.ieY = com.facebook.imagepipeline.a.a.c.a(bVN(), this.ieQ.bVf());
        }
        return this.ieY;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bVI() {
        if (this.ieR == null) {
            this.ieR = com.facebook.imagepipeline.c.a.a(this.ieQ.bVa(), this.ieQ.bVk(), bVN(), this.ieQ.bVs().bVw());
        }
        return this.ieR;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bUY() {
        if (this.iea == null) {
            this.iea = com.facebook.imagepipeline.c.b.a(bVI(), this.ieQ.bVg());
        }
        return this.iea;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> bVJ() {
        if (this.ieS == null) {
            this.ieS = com.facebook.imagepipeline.c.m.a(this.ieQ.bVe(), this.ieQ.bVk(), bVN());
        }
        return this.ieS;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> bVK() {
        if (this.ieb == null) {
            this.ieb = n.a(bVJ(), this.ieQ.bVg());
        }
        return this.ieb;
    }

    private com.facebook.imagepipeline.decoder.b bVh() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.ieo == null) {
            if (this.ieQ.bVh() != null) {
                this.ieo = this.ieQ.bVh();
            } else {
                if (bVH() != null) {
                    dVar = bVH().bUb();
                } else {
                    dVar = null;
                }
                if (this.ieQ.bVr() == null) {
                    this.ieo = new com.facebook.imagepipeline.decoder.a(dVar, bVO(), this.ieQ.bUK());
                } else {
                    this.ieo = new com.facebook.imagepipeline.decoder.a(dVar, bVO(), this.ieQ.bUK(), this.ieQ.bVr().bWn());
                    com.facebook.c.d.bUa().eq(this.ieQ.bVr().bWo());
                }
            }
        }
        return this.ieo;
    }

    private com.facebook.imagepipeline.c.e bVL() {
        if (this.iec == null) {
            this.iec = new com.facebook.imagepipeline.c.e(bVM(), this.ieQ.bVm().bXl(), this.ieQ.bVm().bXm(), this.ieQ.bVf().bUS(), this.ieQ.bVf().bUT(), this.ieQ.bVg());
        }
        return this.iec;
    }

    public com.facebook.cache.disk.h bVM() {
        if (this.ieT == null) {
            this.ieT = this.ieQ.bVc().a(this.ieQ.bVj());
        }
        return this.ieT;
    }

    public g bSw() {
        if (this.hYC == null) {
            this.hYC = new g(bVQ(), this.ieQ.bVo(), this.ieQ.bVi(), bUY(), bVK(), bVL(), bVS(), this.ieQ.bUZ(), this.ied, com.facebook.common.internal.j.ap(false));
        }
        return this.hYC;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.bXh());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.bXl()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f bVN() {
        if (this.ies == null) {
            this.ies = a(this.ieQ.bVm(), bVO());
        }
        return this.ies;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int bXj = qVar.bXj();
            return new com.facebook.imagepipeline.h.a(qVar.bXh(), bXj, new Pools.SynchronizedPool(bXj));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.bXi());
        }
    }

    public com.facebook.imagepipeline.h.e bVO() {
        if (this.ieX == null) {
            this.ieX = a(this.ieQ.bVm(), this.ieQ.bVs().bVB());
        }
        return this.ieX;
    }

    private l bVP() {
        if (this.ieU == null) {
            this.ieU = new l(this.ieQ.getContext(), this.ieQ.bVm().bXn(), bVh(), this.ieQ.bVn(), this.ieQ.bVd(), this.ieQ.bVp(), this.ieQ.bVs().bVC(), this.ieQ.bVf(), this.ieQ.bVm().bXl(), bUY(), bVK(), bVL(), bVS(), bVT(), this.ieQ.bVs().bVz(), this.ieQ.bUZ(), bVN(), this.ieQ.bVs().bVx());
        }
        return this.ieU;
    }

    private m bVQ() {
        if (this.idX == null) {
            this.idX = new m(bVP(), this.ieQ.bVl(), this.ieQ.bVp(), this.ieQ.bVs().bVB(), this.ied, this.ieQ.bVs().bVA());
        }
        return this.idX;
    }

    public com.facebook.cache.disk.h bVR() {
        if (this.ieV == null) {
            this.ieV = this.ieQ.bVc().a(this.ieQ.bVq());
        }
        return this.ieV;
    }

    private com.facebook.imagepipeline.c.e bVS() {
        if (this.idp == null) {
            this.idp = new com.facebook.imagepipeline.c.e(bVR(), this.ieQ.bVm().bXl(), this.ieQ.bVm().bXm(), this.ieQ.bVf().bUS(), this.ieQ.bVf().bUT(), this.ieQ.bVg());
        }
        return this.idp;
    }

    public r bVT() {
        if (this.ieW == null) {
            this.ieW = this.ieQ.bVs().bVy() ? new s(this.ieQ.getContext(), this.ieQ.bVf().bUS(), this.ieQ.bVf().bUT()) : new y();
        }
        return this.ieW;
    }
}
