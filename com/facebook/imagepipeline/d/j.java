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
    private static j inL = null;
    private g ihz;
    private m imS;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> imV;
    private t<com.facebook.cache.common.b, PooledByteBuffer> imW;
    private com.facebook.imagepipeline.c.e imX;
    private final aq imY;
    private com.facebook.imagepipeline.c.e imm;
    private final h inM;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> inN;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> inO;
    private com.facebook.cache.disk.h inP;
    private l inQ;
    private com.facebook.cache.disk.h inR;
    private r inS;
    private com.facebook.imagepipeline.h.e inT;
    private com.facebook.imagepipeline.a.a.b inU;
    private com.facebook.imagepipeline.decoder.b inj;
    private com.facebook.imagepipeline.b.f inn;

    public static j bXg() {
        return (j) com.facebook.common.internal.g.checkNotNull(inL, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.du(context).bWU());
    }

    public static void a(h hVar) {
        inL = new j(hVar);
    }

    public j(h hVar) {
        this.inM = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.imY = new aq(hVar.bWF().bWw());
    }

    public com.facebook.imagepipeline.a.a.b bXh() {
        if (this.inU == null) {
            this.inU = com.facebook.imagepipeline.a.a.c.a(bXn(), this.inM.bWF());
        }
        return this.inU;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bXi() {
        if (this.inN == null) {
            this.inN = com.facebook.imagepipeline.c.a.a(this.inM.bWA(), this.inM.bWK(), bXn(), this.inM.bWS().bWW());
        }
        return this.inN;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bWy() {
        if (this.imV == null) {
            this.imV = com.facebook.imagepipeline.c.b.a(bXi(), this.inM.bWG());
        }
        return this.imV;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> bXj() {
        if (this.inO == null) {
            this.inO = com.facebook.imagepipeline.c.m.a(this.inM.bWE(), this.inM.bWK(), bXn());
        }
        return this.inO;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> bXk() {
        if (this.imW == null) {
            this.imW = n.a(bXj(), this.inM.bWG());
        }
        return this.imW;
    }

    private com.facebook.imagepipeline.decoder.b bWH() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.inj == null) {
            if (this.inM.bWH() != null) {
                this.inj = this.inM.bWH();
            } else {
                if (bXh() != null) {
                    dVar = bXh().bVB();
                } else {
                    dVar = null;
                }
                if (this.inM.bWR() == null) {
                    this.inj = new com.facebook.imagepipeline.decoder.a(dVar, bXo(), this.inM.bWk());
                } else {
                    this.inj = new com.facebook.imagepipeline.decoder.a(dVar, bXo(), this.inM.bWk(), this.inM.bWR().bXN());
                    com.facebook.c.d.bVA().es(this.inM.bWR().bXO());
                }
            }
        }
        return this.inj;
    }

    private com.facebook.imagepipeline.c.e bXl() {
        if (this.imX == null) {
            this.imX = new com.facebook.imagepipeline.c.e(bXm(), this.inM.bWM().bYL(), this.inM.bWM().bYM(), this.inM.bWF().bWs(), this.inM.bWF().bWt(), this.inM.bWG());
        }
        return this.imX;
    }

    public com.facebook.cache.disk.h bXm() {
        if (this.inP == null) {
            this.inP = this.inM.bWC().a(this.inM.bWJ());
        }
        return this.inP;
    }

    public g bTW() {
        if (this.ihz == null) {
            this.ihz = new g(bXq(), this.inM.bWO(), this.inM.bWI(), bWy(), bXk(), bXl(), bXs(), this.inM.bWz(), this.imY, com.facebook.common.internal.j.ap(false));
        }
        return this.ihz;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.bYH());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.bYL()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f bXn() {
        if (this.inn == null) {
            this.inn = a(this.inM.bWM(), bXo());
        }
        return this.inn;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int bYJ = qVar.bYJ();
            return new com.facebook.imagepipeline.h.a(qVar.bYH(), bYJ, new Pools.SynchronizedPool(bYJ));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.bYI());
        }
    }

    public com.facebook.imagepipeline.h.e bXo() {
        if (this.inT == null) {
            this.inT = a(this.inM.bWM(), this.inM.bWS().bXb());
        }
        return this.inT;
    }

    private l bXp() {
        if (this.inQ == null) {
            this.inQ = new l(this.inM.getContext(), this.inM.bWM().bYN(), bWH(), this.inM.bWN(), this.inM.bWD(), this.inM.bWP(), this.inM.bWS().bXc(), this.inM.bWF(), this.inM.bWM().bYL(), bWy(), bXk(), bXl(), bXs(), bXt(), this.inM.bWS().bWZ(), this.inM.bWz(), bXn(), this.inM.bWS().bWX());
        }
        return this.inQ;
    }

    private m bXq() {
        if (this.imS == null) {
            this.imS = new m(bXp(), this.inM.bWL(), this.inM.bWP(), this.inM.bWS().bXb(), this.imY, this.inM.bWS().bXa());
        }
        return this.imS;
    }

    public com.facebook.cache.disk.h bXr() {
        if (this.inR == null) {
            this.inR = this.inM.bWC().a(this.inM.bWQ());
        }
        return this.inR;
    }

    private com.facebook.imagepipeline.c.e bXs() {
        if (this.imm == null) {
            this.imm = new com.facebook.imagepipeline.c.e(bXr(), this.inM.bWM().bYL(), this.inM.bWM().bYM(), this.inM.bWF().bWs(), this.inM.bWF().bWt(), this.inM.bWG());
        }
        return this.imm;
    }

    public r bXt() {
        if (this.inS == null) {
            this.inS = this.inM.bWS().bWY() ? new s(this.inM.getContext(), this.inM.bWF().bWs(), this.inM.bWF().bWt()) : new y();
        }
        return this.inS;
    }
}
