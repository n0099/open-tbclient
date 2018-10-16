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
    private static j ieO = null;
    private g hYB;
    private m idW;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> idZ;
    private com.facebook.imagepipeline.c.e ido;
    private final h ieP;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ieQ;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> ieR;
    private com.facebook.cache.disk.h ieS;
    private l ieT;
    private com.facebook.cache.disk.h ieU;
    private r ieV;
    private com.facebook.imagepipeline.h.e ieW;
    private com.facebook.imagepipeline.a.a.b ieX;
    private t<com.facebook.cache.common.b, PooledByteBuffer> iea;
    private com.facebook.imagepipeline.c.e ieb;
    private final aq iec;
    private com.facebook.imagepipeline.decoder.b ien;
    private com.facebook.imagepipeline.b.f ier;

    public static j bVG() {
        return (j) com.facebook.common.internal.g.checkNotNull(ieO, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.dv(context).bVu());
    }

    public static void a(h hVar) {
        ieO = new j(hVar);
    }

    public j(h hVar) {
        this.ieP = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.iec = new aq(hVar.bVf().bUW());
    }

    public com.facebook.imagepipeline.a.a.b bVH() {
        if (this.ieX == null) {
            this.ieX = com.facebook.imagepipeline.a.a.c.a(bVN(), this.ieP.bVf());
        }
        return this.ieX;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bVI() {
        if (this.ieQ == null) {
            this.ieQ = com.facebook.imagepipeline.c.a.a(this.ieP.bVa(), this.ieP.bVk(), bVN(), this.ieP.bVs().bVw());
        }
        return this.ieQ;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bUY() {
        if (this.idZ == null) {
            this.idZ = com.facebook.imagepipeline.c.b.a(bVI(), this.ieP.bVg());
        }
        return this.idZ;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> bVJ() {
        if (this.ieR == null) {
            this.ieR = com.facebook.imagepipeline.c.m.a(this.ieP.bVe(), this.ieP.bVk(), bVN());
        }
        return this.ieR;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> bVK() {
        if (this.iea == null) {
            this.iea = n.a(bVJ(), this.ieP.bVg());
        }
        return this.iea;
    }

    private com.facebook.imagepipeline.decoder.b bVh() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.ien == null) {
            if (this.ieP.bVh() != null) {
                this.ien = this.ieP.bVh();
            } else {
                if (bVH() != null) {
                    dVar = bVH().bUb();
                } else {
                    dVar = null;
                }
                if (this.ieP.bVr() == null) {
                    this.ien = new com.facebook.imagepipeline.decoder.a(dVar, bVO(), this.ieP.bUK());
                } else {
                    this.ien = new com.facebook.imagepipeline.decoder.a(dVar, bVO(), this.ieP.bUK(), this.ieP.bVr().bWn());
                    com.facebook.c.d.bUa().eq(this.ieP.bVr().bWo());
                }
            }
        }
        return this.ien;
    }

    private com.facebook.imagepipeline.c.e bVL() {
        if (this.ieb == null) {
            this.ieb = new com.facebook.imagepipeline.c.e(bVM(), this.ieP.bVm().bXl(), this.ieP.bVm().bXm(), this.ieP.bVf().bUS(), this.ieP.bVf().bUT(), this.ieP.bVg());
        }
        return this.ieb;
    }

    public com.facebook.cache.disk.h bVM() {
        if (this.ieS == null) {
            this.ieS = this.ieP.bVc().a(this.ieP.bVj());
        }
        return this.ieS;
    }

    public g bSw() {
        if (this.hYB == null) {
            this.hYB = new g(bVQ(), this.ieP.bVo(), this.ieP.bVi(), bUY(), bVK(), bVL(), bVS(), this.ieP.bUZ(), this.iec, com.facebook.common.internal.j.ap(false));
        }
        return this.hYB;
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
        if (this.ier == null) {
            this.ier = a(this.ieP.bVm(), bVO());
        }
        return this.ier;
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
        if (this.ieW == null) {
            this.ieW = a(this.ieP.bVm(), this.ieP.bVs().bVB());
        }
        return this.ieW;
    }

    private l bVP() {
        if (this.ieT == null) {
            this.ieT = new l(this.ieP.getContext(), this.ieP.bVm().bXn(), bVh(), this.ieP.bVn(), this.ieP.bVd(), this.ieP.bVp(), this.ieP.bVs().bVC(), this.ieP.bVf(), this.ieP.bVm().bXl(), bUY(), bVK(), bVL(), bVS(), bVT(), this.ieP.bVs().bVz(), this.ieP.bUZ(), bVN(), this.ieP.bVs().bVx());
        }
        return this.ieT;
    }

    private m bVQ() {
        if (this.idW == null) {
            this.idW = new m(bVP(), this.ieP.bVl(), this.ieP.bVp(), this.ieP.bVs().bVB(), this.iec, this.ieP.bVs().bVA());
        }
        return this.idW;
    }

    public com.facebook.cache.disk.h bVR() {
        if (this.ieU == null) {
            this.ieU = this.ieP.bVc().a(this.ieP.bVq());
        }
        return this.ieU;
    }

    private com.facebook.imagepipeline.c.e bVS() {
        if (this.ido == null) {
            this.ido = new com.facebook.imagepipeline.c.e(bVR(), this.ieP.bVm().bXl(), this.ieP.bVm().bXm(), this.ieP.bVf().bUS(), this.ieP.bVf().bUT(), this.ieP.bVg());
        }
        return this.ido;
    }

    public r bVT() {
        if (this.ieV == null) {
            this.ieV = this.ieP.bVs().bVy() ? new s(this.ieP.getContext(), this.ieP.bVf().bUS(), this.ieP.bVf().bUT()) : new y();
        }
        return this.ieV;
    }
}
