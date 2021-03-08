package com.facebook.imagepipeline.c;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.o;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.at;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class j {
    private static final Class<?> pAh = j.class;
    private static j pLK = null;
    private g pDd;
    private com.facebook.imagepipeline.a.f pHn;
    private m pKN;
    private com.facebook.imagepipeline.b.e pKS;
    private com.facebook.imagepipeline.b.e pKT;
    private final at pKV;
    private final h pLL;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pLM;
    private o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pLN;
    private com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> pLO;
    private o<com.facebook.cache.common.b, PooledByteBuffer> pLP;
    private com.facebook.cache.disk.h pLQ;
    private l pLR;
    private com.facebook.cache.disk.h pLS;
    private com.facebook.imagepipeline.h.e pLT;
    private com.facebook.imagepipeline.animated.a.a pLU;
    private com.facebook.imagepipeline.decoder.b pLh;

    public static j exC() {
        return (j) com.facebook.common.internal.g.checkNotNull(pLK, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized void initialize(Context context) {
        synchronized (j.class) {
            a(h.il(context).exn());
        }
    }

    public static synchronized void a(h hVar) {
        synchronized (j.class) {
            if (pLK != null) {
                com.facebook.common.c.a.h(pAh, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            pLK = new j(hVar);
        }
    }

    public j(h hVar) {
        this.pLL = (h) com.facebook.common.internal.g.checkNotNull(hVar);
        this.pKV = new at(hVar.ewZ().ewN());
    }

    @Nullable
    private com.facebook.imagepipeline.animated.a.a exD() {
        if (this.pLU == null) {
            this.pLU = com.facebook.imagepipeline.animated.a.b.a(exK(), this.pLL.ewZ(), exE());
        }
        return this.pLU;
    }

    @Nullable
    public com.facebook.imagepipeline.e.a ij(Context context) {
        com.facebook.imagepipeline.animated.a.a exD = exD();
        if (exD == null) {
            return null;
        }
        return exD.ij(context);
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> exE() {
        if (this.pLM == null) {
            this.pLM = com.facebook.imagepipeline.b.a.a(this.pLL.ewS(), this.pLL.exe(), this.pLL.ewT());
        }
        return this.pLM;
    }

    public o<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> exF() {
        if (this.pLN == null) {
            this.pLN = com.facebook.imagepipeline.b.b.a(exE(), this.pLL.exa());
        }
        return this.pLN;
    }

    public com.facebook.imagepipeline.b.h<com.facebook.cache.common.b, PooledByteBuffer> exG() {
        if (this.pLO == null) {
            this.pLO = com.facebook.imagepipeline.b.l.a(this.pLL.ewY(), this.pLL.exe());
        }
        return this.pLO;
    }

    public o<com.facebook.cache.common.b, PooledByteBuffer> exH() {
        if (this.pLP == null) {
            this.pLP = com.facebook.imagepipeline.b.m.a(exG(), this.pLL.exa());
        }
        return this.pLP;
    }

    private com.facebook.imagepipeline.decoder.b exb() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2;
        if (this.pLh == null) {
            if (this.pLL.exb() != null) {
                this.pLh = this.pLL.exb();
            } else {
                com.facebook.imagepipeline.animated.a.a exD = exD();
                if (exD != null) {
                    com.facebook.imagepipeline.decoder.b c = exD.c(this.pLL.ewB());
                    bVar = exD.d(this.pLL.ewB());
                    bVar2 = c;
                } else {
                    bVar = null;
                    bVar2 = null;
                }
                if (this.pLL.exl() == null) {
                    this.pLh = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, exL());
                } else {
                    this.pLh = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, exL(), this.pLL.exl().eyp());
                    com.facebook.c.d.evL().gJ(this.pLL.exl().eyq());
                }
            }
        }
        return this.pLh;
    }

    public com.facebook.imagepipeline.b.e exI() {
        if (this.pKS == null) {
            this.pKS = new com.facebook.imagepipeline.b.e(exJ(), this.pLL.exg().ezs(), this.pLL.exg().ezt(), this.pLL.ewZ().ewJ(), this.pLL.ewZ().ewK(), this.pLL.exa());
        }
        return this.pKS;
    }

    public com.facebook.cache.disk.h exJ() {
        if (this.pLQ == null) {
            this.pLQ = this.pLL.ewV().a(this.pLL.exd());
        }
        return this.pLQ;
    }

    public g etH() {
        if (this.pDd == null) {
            this.pDd = new g(exN(), this.pLL.exi(), this.pLL.exc(), exF(), exH(), exI(), exP(), this.pLL.ewR(), this.pKV, com.facebook.common.internal.k.be(false), this.pLL.exm().exA());
        }
        return this.pDd;
    }

    public static com.facebook.imagepipeline.a.f a(q qVar, com.facebook.imagepipeline.h.e eVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.facebook.imagepipeline.a.a(qVar.ezo());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new com.facebook.imagepipeline.a.e(new com.facebook.imagepipeline.a.b(qVar.ezs()), eVar);
        }
        return new com.facebook.imagepipeline.a.c();
    }

    public com.facebook.imagepipeline.a.f exK() {
        if (this.pHn == null) {
            this.pHn = a(this.pLL.exg(), exL());
        }
        return this.pHn;
    }

    public static com.facebook.imagepipeline.h.e a(q qVar, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int ezq = qVar.ezq();
            return new com.facebook.imagepipeline.h.a(qVar.ezo(), ezq, new Pools.SynchronizedPool(ezq));
        } else if (z && Build.VERSION.SDK_INT < 19) {
            return new com.facebook.imagepipeline.h.c();
        } else {
            return new com.facebook.imagepipeline.h.d(qVar.ezp());
        }
    }

    public com.facebook.imagepipeline.h.e exL() {
        if (this.pLT == null) {
            this.pLT = a(this.pLL.exg(), this.pLL.exm().exq());
        }
        return this.pLT;
    }

    private l exM() {
        if (this.pLR == null) {
            this.pLR = this.pLL.exm().exy().a(this.pLL.getContext(), this.pLL.exg().ezu(), exb(), this.pLL.exh(), this.pLL.ewW(), this.pLL.exj(), this.pLL.exm().exr(), this.pLL.ewZ(), this.pLL.exg().ezs(), exF(), exH(), exI(), exP(), this.pLL.ewR(), exK(), this.pLL.exm().exv(), this.pLL.exm().exw(), this.pLL.exm().exz());
        }
        return this.pLR;
    }

    private m exN() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.pLL.exm().exu();
        if (this.pKN == null) {
            this.pKN = new m(this.pLL.getContext().getApplicationContext().getContentResolver(), exM(), this.pLL.exf(), this.pLL.exj(), this.pLL.exm().exq(), this.pKV, this.pLL.exm().exp(), z, this.pLL.exm().exx(), this.pLL.ewX());
        }
        return this.pKN;
    }

    public com.facebook.cache.disk.h exO() {
        if (this.pLS == null) {
            this.pLS = this.pLL.ewV().a(this.pLL.exk());
        }
        return this.pLS;
    }

    private com.facebook.imagepipeline.b.e exP() {
        if (this.pKT == null) {
            this.pKT = new com.facebook.imagepipeline.b.e(exO(), this.pLL.exg().ezs(), this.pLL.exg().ezt(), this.pLL.ewZ().ewJ(), this.pLL.ewZ().ewK(), this.pLL.exa());
        }
        return this.pKT;
    }
}
