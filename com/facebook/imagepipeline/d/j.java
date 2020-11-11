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
/* loaded from: classes18.dex */
public class j {
    private static final Class<?> oJR = j.class;
    private static j oVT = null;
    private g oMQ;
    private com.facebook.imagepipeline.b.f oRk;
    private m oUW;
    private final h oVU;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oVV;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oVW;
    private com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> oVX;
    private o<com.facebook.cache.common.b, PooledByteBuffer> oVY;
    private com.facebook.cache.disk.h oVZ;
    private com.facebook.imagepipeline.c.e oVb;
    private com.facebook.imagepipeline.c.e oVc;
    private final at oVe;
    private com.facebook.imagepipeline.decoder.b oVq;
    private l oWa;
    private com.facebook.cache.disk.h oWb;
    private com.facebook.imagepipeline.i.e oWc;
    private com.facebook.imagepipeline.animated.a.a oWd;

    public static j eoV() {
        return (j) com.facebook.common.internal.g.checkNotNull(oVT, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.hc(context).eoG());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (oVT != null) {
                com.facebook.common.c.a.g(oJR, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            oVT = new j(hVar);
        }
    }

    public j(h hVar) {
        this.oVU = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.oVe = new at(hVar.eos().eoh());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a eoW() {
        if (this.oWd == null) {
            this.oWd = com.facebook.imagepipeline.animated.a.b.a(epd(), this.oVU.eos(), eoX());
        }
        return this.oWd;
    }

    @Nullable
    public com.facebook.imagepipeline.f.a ha(Context context) {
        com.facebook.imagepipeline.animated.a.a eoW = eoW();
        if (eoW == null) {
            return null;
        }
        return eoW.ha(context);
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> eoX() {
        if (this.oVV == null) {
            this.oVV = com.facebook.imagepipeline.c.a.a(this.oVU.eol(), this.oVU.eox(), this.oVU.eom());
        }
        return this.oVV;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> eoY() {
        if (this.oVW == null) {
            this.oVW = com.facebook.imagepipeline.c.b.a(eoX(), this.oVU.eot());
        }
        return this.oVW;
    }

    public com.facebook.imagepipeline.c.h<com.facebook.cache.common.b, PooledByteBuffer> eoZ() {
        if (this.oVX == null) {
            this.oVX = com.facebook.imagepipeline.c.l.a(this.oVU.eor(), this.oVU.eox());
        }
        return this.oVX;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> epa() {
        if (this.oVY == null) {
            this.oVY = com.facebook.imagepipeline.c.m.a(eoZ(), this.oVU.eot());
        }
        return this.oVY;
    }

    private com.facebook.imagepipeline.decoder.b eou() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2 = null;
        if (this.oVq == null) {
            if (this.oVU.eou() != null) {
                this.oVq = this.oVU.eou();
            } else {
                com.facebook.imagepipeline.animated.a.a eoW = eoW();
                if (eoW != null) {
                    bVar = eoW.a(this.oVU.enT());
                    bVar2 = eoW.b(this.oVU.enT());
                } else {
                    bVar = null;
                }
                if (this.oVU.eoE() == null) {
                    this.oVq = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, epe());
                } else {
                    this.oVq = new com.facebook.imagepipeline.decoder.a(bVar, bVar2, epe(), this.oVU.eoE().epI());
                    com.facebook.c.d.ena().gz(this.oVU.eoE().epJ());
                }
            }
        }
        return this.oVq;
    }

    public com.facebook.imagepipeline.c.e epb() {
        if (this.oVb == null) {
            this.oVb = new com.facebook.imagepipeline.c.e(epc(), this.oVU.eoz().eqP(), this.oVU.eoz().eqQ(), this.oVU.eos().eoc(), this.oVU.eos().eod(), this.oVU.eot());
        }
        return this.oVb;
    }

    public com.facebook.cache.disk.h epc() {
        if (this.oVZ == null) {
            this.oVZ = this.oVU.eoo().a(this.oVU.eow());
        }
        return this.oVZ;
    }

    public g ekU() {
        if (this.oMQ == null) {
            this.oMQ = new g(epg(), this.oVU.eoB(), this.oVU.eov(), eoY(), epa(), epb(), epi(), this.oVU.eok(), this.oVe, com.facebook.common.internal.k.bb(false), this.oVU.eoF().eoT());
        }
        return this.oMQ;
    }

    public static com.facebook.imagepipeline.b.f a(q qVar, com.facebook.imagepipeline.i.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.b.a(qVar.eqL());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.b.e(new com.facebook.imagepipeline.b.b(qVar.eqP()), eVar);
        }
        return new com.facebook.imagepipeline.b.c();
    }

    public com.facebook.imagepipeline.b.f epd() {
        if (this.oRk == null) {
            this.oRk = a(this.oVU.eoz(), epe());
        }
        return this.oRk;
    }

    public static com.facebook.imagepipeline.i.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int eqN = qVar.eqN();
            return new com.facebook.imagepipeline.i.a(qVar.eqL(), eqN, new Pools.SynchronizedPool(eqN));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.i.c();
        } else {
            return new com.facebook.imagepipeline.i.d(qVar.eqM());
        }
    }

    public com.facebook.imagepipeline.i.e epe() {
        if (this.oWc == null) {
            this.oWc = a(this.oVU.eoz(), this.oVU.eoF().eoJ());
        }
        return this.oWc;
    }

    private l epf() {
        if (this.oWa == null) {
            this.oWa = this.oVU.eoF().eoR().a(this.oVU.getContext(), this.oVU.eoz().eqR(), eou(), this.oVU.eoA(), this.oVU.eop(), this.oVU.eoC(), this.oVU.eoF().eoK(), this.oVU.eos(), this.oVU.eoz().eqP(), eoY(), epa(), epb(), epi(), this.oVU.eok(), epd(), this.oVU.eoF().eoO(), this.oVU.eoF().eoP(), this.oVU.eoF().eoS());
        }
        return this.oWa;
    }

    private m epg() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.oVU.eoF().eoN();
        if (this.oUW == null) {
            this.oUW = new m(this.oVU.getContext().getApplicationContext().getContentResolver(), epf(), this.oVU.eoy(), this.oVU.eoC(), this.oVU.eoF().eoJ(), this.oVe, this.oVU.eoF().eoI(), z, this.oVU.eoF().eoQ(), this.oVU.eoq());
        }
        return this.oUW;
    }

    public com.facebook.cache.disk.h eph() {
        if (this.oWb == null) {
            this.oWb = this.oVU.eoo().a(this.oVU.eoD());
        }
        return this.oWb;
    }

    private com.facebook.imagepipeline.c.e epi() {
        if (this.oVc == null) {
            this.oVc = new com.facebook.imagepipeline.c.e(eph(), this.oVU.eoz().eqP(), this.oVU.eoz().eqQ(), this.oVU.eos().eoc(), this.oVU.eos().eod(), this.oVU.eot());
        }
        return this.oVc;
    }
}
