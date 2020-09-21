package com.facebook.imagepipeline.d;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.o;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.at;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes25.dex */
public class j {
    private com.facebook.imagepipeline.b.f nBg;
    private m nES;
    private com.facebook.imagepipeline.c.e nEX;
    private com.facebook.imagepipeline.c.e nEY;
    private final h nFQ;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nFR;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nFS;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> nFT;
    private o<com.facebook.cache.common.b, PooledByteBuffer> nFU;
    private com.facebook.cache.disk.h nFV;
    private l nFW;
    private com.facebook.cache.disk.h nFX;
    private com.facebook.imagepipeline.i.e nFY;
    private com.facebook.imagepipeline.animated.a.a nFZ;
    private final at nFa;
    private com.facebook.imagepipeline.decoder.b nFm;
    private g nwL;
    private static final Class<?> ntL = j.class;
    private static j nFP = null;

    public static j dXv() {
        return (j) com.facebook.common.internal.g.checkNotNull(nFP, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.gB(context).dXg());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (nFP != null) {
                com.facebook.common.c.a.g(ntL, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            nFP = new j(hVar);
        }
    }

    public j(h hVar) {
        this.nFQ = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.nFa = new at(hVar.dWS().dWH());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a dXw() {
        if (this.nFZ == null) {
            this.nFZ = com.facebook.imagepipeline.animated.a.b.a(dXD(), this.nFQ.dWS(), dXx());
        }
        return this.nFZ;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gy(Context context) {
        com.facebook.imagepipeline.animated.a.a dXw = dXw();
        if (dXw == null) {
            return null;
        }
        return dXw.gy(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dXx() {
        if (this.nFR == null) {
            this.nFR = com.facebook.imagepipeline.c.a.a(this.nFQ.dWL(), this.nFQ.dWX(), this.nFQ.dWM());
        }
        return this.nFR;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dXy() {
        if (this.nFS == null) {
            this.nFS = com.facebook.imagepipeline.c.b.a(dXx(), this.nFQ.dWT());
        }
        return this.nFS;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> dXz() {
        if (this.nFT == null) {
            this.nFT = com.facebook.imagepipeline.c.l.a(this.nFQ.dWR(), this.nFQ.dWX());
        }
        return this.nFT;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> dXA() {
        if (this.nFU == null) {
            this.nFU = com.facebook.imagepipeline.c.m.a(dXz(), this.nFQ.dWT());
        }
        return this.nFU;
    }

    private com.facebook.imagepipeline.decoder.b dWU() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.nFm == null) {
            if (this.nFQ.dWU() != null) {
                this.nFm = this.nFQ.dWU();
            } else {
                com.facebook.imagepipeline.animated.a.a dXw = dXw();
                if (dXw != null) {
                    bVar = dXw.a(this.nFQ.dWu());
                    bVar2 = dXw.b(this.nFQ.dWu());
                } else {
                    bVar = null;
                }
                if (this.nFQ.dXe() == null) {
                    this.nFm = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dXE());
                } else {
                    this.nFm = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, dXE(), this.nFQ.dXe().dYi());
                    com.facebook.c.d.dVC().fR(this.nFQ.dXe().dYj());
                }
            }
        }
        return this.nFm;
    }

    public com.facebook.imagepipeline.c.e dXB() {
        if (this.nEX == null) {
            this.nEX = new com.facebook.imagepipeline.c.e(dXC(), this.nFQ.dWZ().dZp(), this.nFQ.dWZ().dZq(), this.nFQ.dWS().dWD(), this.nFQ.dWS().dWE(), this.nFQ.dWT());
        }
        return this.nEX;
    }

    public com.facebook.cache.disk.h dXC() {
        if (this.nFV == null) {
            this.nFV = this.nFQ.dWO().a(this.nFQ.dWW());
        }
        return this.nFV;
    }

    public g dTw() {
        if (this.nwL == null) {
            this.nwL = new g(dXG(), this.nFQ.dXb(), this.nFQ.dWV(), dXy(), dXA(), dXB(), dXI(), this.nFQ.dWK(), this.nFa, com.facebook.common.internal.k.aU(false), this.nFQ.dXf().dXt());
        }
        return this.nwL;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.dZl());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.dZp()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f dXD() {
        if (this.nBg == null) {
            this.nBg = a(this.nFQ.dWZ(), dXE());
        }
        return this.nBg;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dZn = qVar.dZn();
            return new com.facebook.imagepipeline.i.a(qVar.dZl(), dZn, new Pools.SynchronizedPool(dZn));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.dZm());
        }
    }

    public com.facebook.imagepipeline.i.e dXE() {
        if (this.nFY == null) {
            this.nFY = a(this.nFQ.dWZ(), this.nFQ.dXf().dXj());
        }
        return this.nFY;
    }

    private l dXF() {
        if (this.nFW == null) {
            this.nFW = this.nFQ.dXf().dXr().a(this.nFQ.getContext(), this.nFQ.dWZ().dZr(), dWU(), this.nFQ.dXa(), this.nFQ.dWP(), this.nFQ.dXc(), this.nFQ.dXf().dXk(), this.nFQ.dWS(), this.nFQ.dWZ().dZp(), dXy(), dXA(), dXB(), dXI(), this.nFQ.dWK(), dXD(), this.nFQ.dXf().dXo(), this.nFQ.dXf().dXp(), this.nFQ.dXf().dXs());
        }
        return this.nFW;
    }

    private m dXG() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.nFQ.dXf().dXn();
        if (this.nES == null) {
            this.nES = new m(this.nFQ.getContext().getApplicationContext().getContentResolver(), dXF(), this.nFQ.dWY(), this.nFQ.dXc(), this.nFQ.dXf().dXj(), this.nFa, this.nFQ.dXf().dXi(), z, this.nFQ.dXf().dXq(), this.nFQ.dWQ());
        }
        return this.nES;
    }

    public com.facebook.cache.disk.h dXH() {
        if (this.nFX == null) {
            this.nFX = this.nFQ.dWO().a(this.nFQ.dXd());
        }
        return this.nFX;
    }

    private com.facebook.imagepipeline.c.e dXI() {
        if (this.nEY == null) {
            this.nEY = new com.facebook.imagepipeline.c.e(dXH(), this.nFQ.dWZ().dZp(), this.nFQ.dWZ().dZq(), this.nFQ.dWS().dWD(), this.nFQ.dWS().dWE(), this.nFQ.dWT());
        }
        return this.nEY;
    }
}
