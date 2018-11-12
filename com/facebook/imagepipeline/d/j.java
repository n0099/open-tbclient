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
    private static j igz = null;
    private g iam;
    private m ifH;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ifK;
    private t<com.facebook.cache.common.b, PooledByteBuffer> ifL;
    private com.facebook.imagepipeline.c.e ifM;
    private final aq ifN;
    private com.facebook.imagepipeline.decoder.b ifY;
    private com.facebook.imagepipeline.c.e ifb;
    private final h igA;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> igB;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> igC;
    private com.facebook.cache.disk.h igD;
    private l igE;
    private com.facebook.cache.disk.h igF;
    private r igG;
    private com.facebook.imagepipeline.h.e igH;
    private com.facebook.imagepipeline.a.a.b igI;
    private com.facebook.imagepipeline.b.f igc;

    public static j bVb() {
        return (j) com.facebook.common.internal.g.checkNotNull(igz, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.dq(context).bUP());
    }

    public static void a(h hVar) {
        igz = new j(hVar);
    }

    public j(h hVar) {
        this.igA = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.ifN = new aq(hVar.bUA().bUr());
    }

    public com.facebook.imagepipeline.a.a.b bVc() {
        if (this.igI == null) {
            this.igI = com.facebook.imagepipeline.a.a.c.a(bVi(), this.igA.bUA());
        }
        return this.igI;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bVd() {
        if (this.igB == null) {
            this.igB = com.facebook.imagepipeline.c.a.a(this.igA.bUv(), this.igA.bUF(), bVi(), this.igA.bUN().bUR());
        }
        return this.igB;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bUt() {
        if (this.ifK == null) {
            this.ifK = com.facebook.imagepipeline.c.b.a(bVd(), this.igA.bUB());
        }
        return this.ifK;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> bVe() {
        if (this.igC == null) {
            this.igC = com.facebook.imagepipeline.c.m.a(this.igA.bUz(), this.igA.bUF(), bVi());
        }
        return this.igC;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> bVf() {
        if (this.ifL == null) {
            this.ifL = n.a(bVe(), this.igA.bUB());
        }
        return this.ifL;
    }

    private com.facebook.imagepipeline.decoder.b bUC() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.ifY == null) {
            if (this.igA.bUC() != null) {
                this.ifY = this.igA.bUC();
            } else {
                if (bVc() != null) {
                    dVar = bVc().bTw();
                } else {
                    dVar = null;
                }
                if (this.igA.bUM() == null) {
                    this.ifY = new com.facebook.imagepipeline.decoder.a(dVar, bVj(), this.igA.bUf());
                } else {
                    this.ifY = new com.facebook.imagepipeline.decoder.a(dVar, bVj(), this.igA.bUf(), this.igA.bUM().bVI());
                    com.facebook.c.d.bTv().eo(this.igA.bUM().bVJ());
                }
            }
        }
        return this.ifY;
    }

    private com.facebook.imagepipeline.c.e bVg() {
        if (this.ifM == null) {
            this.ifM = new com.facebook.imagepipeline.c.e(bVh(), this.igA.bUH().bWG(), this.igA.bUH().bWH(), this.igA.bUA().bUn(), this.igA.bUA().bUo(), this.igA.bUB());
        }
        return this.ifM;
    }

    public com.facebook.cache.disk.h bVh() {
        if (this.igD == null) {
            this.igD = this.igA.bUx().a(this.igA.bUE());
        }
        return this.igD;
    }

    public g bRR() {
        if (this.iam == null) {
            this.iam = new g(bVl(), this.igA.bUJ(), this.igA.bUD(), bUt(), bVf(), bVg(), bVn(), this.igA.bUu(), this.ifN, com.facebook.common.internal.j.ao(false));
        }
        return this.iam;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.bWC());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.bWG()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f bVi() {
        if (this.igc == null) {
            this.igc = a(this.igA.bUH(), bVj());
        }
        return this.igc;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int bWE = qVar.bWE();
            return new com.facebook.imagepipeline.h.a(qVar.bWC(), bWE, new Pools.SynchronizedPool(bWE));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.bWD());
        }
    }

    public com.facebook.imagepipeline.h.e bVj() {
        if (this.igH == null) {
            this.igH = a(this.igA.bUH(), this.igA.bUN().bUW());
        }
        return this.igH;
    }

    private l bVk() {
        if (this.igE == null) {
            this.igE = new l(this.igA.getContext(), this.igA.bUH().bWI(), bUC(), this.igA.bUI(), this.igA.bUy(), this.igA.bUK(), this.igA.bUN().bUX(), this.igA.bUA(), this.igA.bUH().bWG(), bUt(), bVf(), bVg(), bVn(), bVo(), this.igA.bUN().bUU(), this.igA.bUu(), bVi(), this.igA.bUN().bUS());
        }
        return this.igE;
    }

    private m bVl() {
        if (this.ifH == null) {
            this.ifH = new m(bVk(), this.igA.bUG(), this.igA.bUK(), this.igA.bUN().bUW(), this.ifN, this.igA.bUN().bUV());
        }
        return this.ifH;
    }

    public com.facebook.cache.disk.h bVm() {
        if (this.igF == null) {
            this.igF = this.igA.bUx().a(this.igA.bUL());
        }
        return this.igF;
    }

    private com.facebook.imagepipeline.c.e bVn() {
        if (this.ifb == null) {
            this.ifb = new com.facebook.imagepipeline.c.e(bVm(), this.igA.bUH().bWG(), this.igA.bUH().bWH(), this.igA.bUA().bUn(), this.igA.bUA().bUo(), this.igA.bUB());
        }
        return this.ifb;
    }

    public r bVo() {
        if (this.igG == null) {
            this.igG = this.igA.bUN().bUT() ? new s(this.igA.getContext(), this.igA.bUA().bUn(), this.igA.bUA().bUo()) : new y();
        }
        return this.igG;
    }
}
