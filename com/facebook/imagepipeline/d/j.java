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

    public static j bXh() {
        return (j) com.facebook.common.internal.g.checkNotNull(inL, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.du(context).bWV());
    }

    public static void a(h hVar) {
        inL = new j(hVar);
    }

    public j(h hVar) {
        this.inM = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.imY = new aq(hVar.bWG().bWx());
    }

    public com.facebook.imagepipeline.a.a.b bXi() {
        if (this.inU == null) {
            this.inU = com.facebook.imagepipeline.a.a.c.a(bXo(), this.inM.bWG());
        }
        return this.inU;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bXj() {
        if (this.inN == null) {
            this.inN = com.facebook.imagepipeline.c.a.a(this.inM.bWB(), this.inM.bWL(), bXo(), this.inM.bWT().bWX());
        }
        return this.inN;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bWz() {
        if (this.imV == null) {
            this.imV = com.facebook.imagepipeline.c.b.a(bXj(), this.inM.bWH());
        }
        return this.imV;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> bXk() {
        if (this.inO == null) {
            this.inO = com.facebook.imagepipeline.c.m.a(this.inM.bWF(), this.inM.bWL(), bXo());
        }
        return this.inO;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> bXl() {
        if (this.imW == null) {
            this.imW = n.a(bXk(), this.inM.bWH());
        }
        return this.imW;
    }

    private com.facebook.imagepipeline.decoder.b bWI() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.inj == null) {
            if (this.inM.bWI() != null) {
                this.inj = this.inM.bWI();
            } else {
                if (bXi() != null) {
                    dVar = bXi().bVC();
                } else {
                    dVar = null;
                }
                if (this.inM.bWS() == null) {
                    this.inj = new com.facebook.imagepipeline.decoder.a(dVar, bXp(), this.inM.bWl());
                } else {
                    this.inj = new com.facebook.imagepipeline.decoder.a(dVar, bXp(), this.inM.bWl(), this.inM.bWS().bXO());
                    com.facebook.c.d.bVB().es(this.inM.bWS().bXP());
                }
            }
        }
        return this.inj;
    }

    private com.facebook.imagepipeline.c.e bXm() {
        if (this.imX == null) {
            this.imX = new com.facebook.imagepipeline.c.e(bXn(), this.inM.bWN().bYM(), this.inM.bWN().bYN(), this.inM.bWG().bWt(), this.inM.bWG().bWu(), this.inM.bWH());
        }
        return this.imX;
    }

    public com.facebook.cache.disk.h bXn() {
        if (this.inP == null) {
            this.inP = this.inM.bWD().a(this.inM.bWK());
        }
        return this.inP;
    }

    public g bTX() {
        if (this.ihz == null) {
            this.ihz = new g(bXr(), this.inM.bWP(), this.inM.bWJ(), bWz(), bXl(), bXm(), bXt(), this.inM.bWA(), this.imY, com.facebook.common.internal.j.ap(false));
        }
        return this.ihz;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.bYI());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.bYM()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f bXo() {
        if (this.inn == null) {
            this.inn = a(this.inM.bWN(), bXp());
        }
        return this.inn;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int bYK = qVar.bYK();
            return new com.facebook.imagepipeline.h.a(qVar.bYI(), bYK, new Pools.SynchronizedPool(bYK));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.bYJ());
        }
    }

    public com.facebook.imagepipeline.h.e bXp() {
        if (this.inT == null) {
            this.inT = a(this.inM.bWN(), this.inM.bWT().bXc());
        }
        return this.inT;
    }

    private l bXq() {
        if (this.inQ == null) {
            this.inQ = new l(this.inM.getContext(), this.inM.bWN().bYO(), bWI(), this.inM.bWO(), this.inM.bWE(), this.inM.bWQ(), this.inM.bWT().bXd(), this.inM.bWG(), this.inM.bWN().bYM(), bWz(), bXl(), bXm(), bXt(), bXu(), this.inM.bWT().bXa(), this.inM.bWA(), bXo(), this.inM.bWT().bWY());
        }
        return this.inQ;
    }

    private m bXr() {
        if (this.imS == null) {
            this.imS = new m(bXq(), this.inM.bWM(), this.inM.bWQ(), this.inM.bWT().bXc(), this.imY, this.inM.bWT().bXb());
        }
        return this.imS;
    }

    public com.facebook.cache.disk.h bXs() {
        if (this.inR == null) {
            this.inR = this.inM.bWD().a(this.inM.bWR());
        }
        return this.inR;
    }

    private com.facebook.imagepipeline.c.e bXt() {
        if (this.imm == null) {
            this.imm = new com.facebook.imagepipeline.c.e(bXs(), this.inM.bWN().bYM(), this.inM.bWN().bYN(), this.inM.bWG().bWt(), this.inM.bWG().bWu(), this.inM.bWH());
        }
        return this.imm;
    }

    public r bXu() {
        if (this.inS == null) {
            this.inS = this.inM.bWT().bWZ() ? new s(this.inM.getContext(), this.inM.bWG().bWt(), this.inM.bWG().bWu()) : new y();
        }
        return this.inS;
    }
}
