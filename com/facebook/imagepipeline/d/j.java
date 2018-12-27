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
    private static j iqV = null;
    private g ikJ;
    private com.facebook.imagepipeline.c.e ipx;
    private final h iqW;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iqX;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> iqY;
    private com.facebook.cache.disk.h iqZ;
    private m iqd;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iqg;
    private t<com.facebook.cache.common.b, PooledByteBuffer> iqh;
    private com.facebook.imagepipeline.c.e iqi;
    private final aq iqj;
    private com.facebook.imagepipeline.decoder.b iqu;
    private com.facebook.imagepipeline.b.f iqy;
    private l ira;
    private com.facebook.cache.disk.h irb;
    private r irc;
    private com.facebook.imagepipeline.h.e ird;
    private com.facebook.imagepipeline.a.a.b ire;

    public static j bXX() {
        return (j) com.facebook.common.internal.g.checkNotNull(iqV, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        a(h.du(context).bXL());
    }

    public static void a(h hVar) {
        iqV = new j(hVar);
    }

    public j(h hVar) {
        this.iqW = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.iqj = new aq(hVar.bXw().bXn());
    }

    public com.facebook.imagepipeline.a.a.b bXY() {
        if (this.ire == null) {
            this.ire = com.facebook.imagepipeline.a.a.c.a(bYe(), this.iqW.bXw());
        }
        return this.ire;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bXZ() {
        if (this.iqX == null) {
            this.iqX = com.facebook.imagepipeline.c.a.a(this.iqW.bXr(), this.iqW.bXB(), bYe(), this.iqW.bXJ().bXN());
        }
        return this.iqX;
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bXp() {
        if (this.iqg == null) {
            this.iqg = com.facebook.imagepipeline.c.b.a(bXZ(), this.iqW.bXx());
        }
        return this.iqg;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> bYa() {
        if (this.iqY == null) {
            this.iqY = com.facebook.imagepipeline.c.m.a(this.iqW.bXv(), this.iqW.bXB(), bYe());
        }
        return this.iqY;
    }

    public t<com.facebook.cache.common.b, PooledByteBuffer> bYb() {
        if (this.iqh == null) {
            this.iqh = n.a(bYa(), this.iqW.bXx());
        }
        return this.iqh;
    }

    private com.facebook.imagepipeline.decoder.b bXy() {
        com.facebook.imagepipeline.a.a.d dVar;
        if (this.iqu == null) {
            if (this.iqW.bXy() != null) {
                this.iqu = this.iqW.bXy();
            } else {
                if (bXY() != null) {
                    dVar = bXY().bWs();
                } else {
                    dVar = null;
                }
                if (this.iqW.bXI() == null) {
                    this.iqu = new com.facebook.imagepipeline.decoder.a(dVar, bYf(), this.iqW.bXb());
                } else {
                    this.iqu = new com.facebook.imagepipeline.decoder.a(dVar, bYf(), this.iqW.bXb(), this.iqW.bXI().bYE());
                    com.facebook.c.d.bWr().et(this.iqW.bXI().bYF());
                }
            }
        }
        return this.iqu;
    }

    private com.facebook.imagepipeline.c.e bYc() {
        if (this.iqi == null) {
            this.iqi = new com.facebook.imagepipeline.c.e(bYd(), this.iqW.bXD().bZC(), this.iqW.bXD().bZD(), this.iqW.bXw().bXj(), this.iqW.bXw().bXk(), this.iqW.bXx());
        }
        return this.iqi;
    }

    public com.facebook.cache.disk.h bYd() {
        if (this.iqZ == null) {
            this.iqZ = this.iqW.bXt().a(this.iqW.bXA());
        }
        return this.iqZ;
    }

    public g bUN() {
        if (this.ikJ == null) {
            this.ikJ = new g(bYh(), this.iqW.bXF(), this.iqW.bXz(), bXp(), bYb(), bYc(), bYj(), this.iqW.bXq(), this.iqj, com.facebook.common.internal.j.ap(false));
        }
        return this.ikJ;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.bZy());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.bZC()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f bYe() {
        if (this.iqy == null) {
            this.iqy = a(this.iqW.bXD(), bYf());
        }
        return this.iqy;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int bZA = qVar.bZA();
            return new com.facebook.imagepipeline.h.a(qVar.bZy(), bZA, new Pools.SynchronizedPool(bZA));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.bZz());
        }
    }

    public com.facebook.imagepipeline.h.e bYf() {
        if (this.ird == null) {
            this.ird = a(this.iqW.bXD(), this.iqW.bXJ().bXS());
        }
        return this.ird;
    }

    private l bYg() {
        if (this.ira == null) {
            this.ira = new l(this.iqW.getContext(), this.iqW.bXD().bZE(), bXy(), this.iqW.bXE(), this.iqW.bXu(), this.iqW.bXG(), this.iqW.bXJ().bXT(), this.iqW.bXw(), this.iqW.bXD().bZC(), bXp(), bYb(), bYc(), bYj(), bYk(), this.iqW.bXJ().bXQ(), this.iqW.bXq(), bYe(), this.iqW.bXJ().bXO());
        }
        return this.ira;
    }

    private m bYh() {
        if (this.iqd == null) {
            this.iqd = new m(bYg(), this.iqW.bXC(), this.iqW.bXG(), this.iqW.bXJ().bXS(), this.iqj, this.iqW.bXJ().bXR());
        }
        return this.iqd;
    }

    public com.facebook.cache.disk.h bYi() {
        if (this.irb == null) {
            this.irb = this.iqW.bXt().a(this.iqW.bXH());
        }
        return this.irb;
    }

    private com.facebook.imagepipeline.c.e bYj() {
        if (this.ipx == null) {
            this.ipx = new com.facebook.imagepipeline.c.e(bYi(), this.iqW.bXD().bZC(), this.iqW.bXD().bZD(), this.iqW.bXw().bXj(), this.iqW.bXw().bXk(), this.iqW.bXx());
        }
        return this.ipx;
    }

    public r bYk() {
        if (this.irc == null) {
            this.irc = this.iqW.bXJ().bXP() ? new s(this.iqW.getContext(), this.iqW.bXw().bXj(), this.iqW.bXw().bXk()) : new y();
        }
        return this.irc;
    }
}
