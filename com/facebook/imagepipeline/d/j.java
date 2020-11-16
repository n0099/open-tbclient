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
/* loaded from: classes15.dex */
public class j {
    private static final Class<?> oLv = j.class;
    private static j oXw = null;
    private g oOu;
    private com.facebook.imagepipeline.b.f oSN;
    private com.facebook.imagepipeline.c.e oWE;
    private com.facebook.imagepipeline.c.e oWF;
    private final at oWH;
    private com.facebook.imagepipeline.decoder.b oWT;
    private m oWz;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> oXA;
    private o<com.facebook.cache.common.b, PooledByteBuffer> oXB;
    private com.facebook.cache.disk.h oXC;
    private l oXD;
    private com.facebook.cache.disk.h oXE;
    private com.facebook.imagepipeline.i.e oXF;
    private com.facebook.imagepipeline.animated.a.a oXG;
    private final h oXx;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oXy;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oXz;

    public static j eoT() {
        return (j) com.facebook.common.internal.g.checkNotNull(oXw, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.ha(context).eoE());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (oXw != null) {
                com.facebook.common.c.a.g(oLv, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            oXw = new j(hVar);
        }
    }

    public j(h hVar) {
        this.oXx = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.oWH = new at(hVar.eoq().eoe());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a eoU() {
        if (this.oXG == null) {
            this.oXG = com.facebook.imagepipeline.animated.a.b.a(epb(), this.oXx.eoq(), eoV());
        }
        return this.oXG;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a gY(Context context) {
        com.facebook.imagepipeline.animated.a.a eoU = eoU();
        if (eoU == null) {
            return null;
        }
        return eoU.gY(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> eoV() {
        if (this.oXy == null) {
            this.oXy = com.facebook.imagepipeline.c.a.a(this.oXx.eoj(), this.oXx.eov(), this.oXx.eok());
        }
        return this.oXy;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> eoW() {
        if (this.oXz == null) {
            this.oXz = com.facebook.imagepipeline.c.b.a(eoV(), this.oXx.eor());
        }
        return this.oXz;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> eoX() {
        if (this.oXA == null) {
            this.oXA = com.facebook.imagepipeline.c.l.a(this.oXx.eop(), this.oXx.eov());
        }
        return this.oXA;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> eoY() {
        if (this.oXB == null) {
            this.oXB = com.facebook.imagepipeline.c.m.a(eoX(), this.oXx.eor());
        }
        return this.oXB;
    }

    private com.facebook.imagepipeline.decoder.b eos() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.oWT == null) {
            if (this.oXx.eos() != null) {
                this.oWT = this.oXx.eos();
            } else {
                com.facebook.imagepipeline.animated.a.a eoU = eoU();
                if (eoU != null) {
                    bVar = eoU.a(this.oXx.enR());
                    bVar2 = eoU.b(this.oXx.enR());
                } else {
                    bVar = null;
                }
                if (this.oXx.eoC() == null) {
                    this.oWT = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, epc());
                } else {
                    this.oWT = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, epc(), this.oXx.eoC().epG());
                    com.facebook.c.d.emY().gz(this.oXx.eoC().epH());
                }
            }
        }
        return this.oWT;
    }

    public com.facebook.imagepipeline.c.e eoZ() {
        if (this.oWE == null) {
            this.oWE = new com.facebook.imagepipeline.c.e(epa(), this.oXx.eox().eqN(), this.oXx.eox().eqO(), this.oXx.eoq().eoa(), this.oXx.eoq().eob(), this.oXx.eor());
        }
        return this.oWE;
    }

    public com.facebook.cache.disk.h epa() {
        if (this.oXC == null) {
            this.oXC = this.oXx.eom().a(this.oXx.eou());
        }
        return this.oXC;
    }

    public g ekS() {
        if (this.oOu == null) {
            this.oOu = new g(epe(), this.oXx.eoz(), this.oXx.eot(), eoW(), eoY(), eoZ(), epg(), this.oXx.eoi(), this.oWH, com.facebook.common.internal.k.bc(false), this.oXx.eoD().eoR());
        }
        return this.oOu;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.eqJ());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.eqN()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f epb() {
        if (this.oSN == null) {
            this.oSN = a(this.oXx.eox(), epc());
        }
        return this.oSN;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int eqL = qVar.eqL();
            return new com.facebook.imagepipeline.i.a(qVar.eqJ(), eqL, new Pools.SynchronizedPool(eqL));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.eqK());
        }
    }

    public com.facebook.imagepipeline.i.e epc() {
        if (this.oXF == null) {
            this.oXF = a(this.oXx.eox(), this.oXx.eoD().eoH());
        }
        return this.oXF;
    }

    private l epd() {
        if (this.oXD == null) {
            this.oXD = this.oXx.eoD().eoP().a(this.oXx.getContext(), this.oXx.eox().eqP(), eos(), this.oXx.eoy(), this.oXx.eon(), this.oXx.eoA(), this.oXx.eoD().eoI(), this.oXx.eoq(), this.oXx.eox().eqN(), eoW(), eoY(), eoZ(), epg(), this.oXx.eoi(), epb(), this.oXx.eoD().eoM(), this.oXx.eoD().eoN(), this.oXx.eoD().eoQ());
        }
        return this.oXD;
    }

    private m epe() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.oXx.eoD().eoL();
        if (this.oWz == null) {
            this.oWz = new m(this.oXx.getContext().getApplicationContext().getContentResolver(), epd(), this.oXx.eow(), this.oXx.eoA(), this.oXx.eoD().eoH(), this.oWH, this.oXx.eoD().eoG(), z, this.oXx.eoD().eoO(), this.oXx.eoo());
        }
        return this.oWz;
    }

    public com.facebook.cache.disk.h epf() {
        if (this.oXE == null) {
            this.oXE = this.oXx.eom().a(this.oXx.eoB());
        }
        return this.oXE;
    }

    private com.facebook.imagepipeline.c.e epg() {
        if (this.oWF == null) {
            this.oWF = new com.facebook.imagepipeline.c.e(epf(), this.oXx.eox().eqN(), this.oXx.eox().eqO(), this.oXx.eoq().eoa(), this.oXx.eoq().eob(), this.oXx.eor());
        }
        return this.oWF;
    }
}
