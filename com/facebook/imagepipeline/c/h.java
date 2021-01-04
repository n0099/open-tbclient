package com.facebook.imagepipeline.c;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.common.g.b;
import com.facebook.imagepipeline.b.h;
import com.facebook.imagepipeline.b.n;
import com.facebook.imagepipeline.b.q;
import com.facebook.imagepipeline.b.t;
import com.facebook.imagepipeline.c.i;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.u;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class h {
    private static b pBz = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final com.facebook.common.internal.j<Boolean> pAV;
    private final com.facebook.imagepipeline.b.f pBa;
    private final com.facebook.common.internal.j<q> pBi;
    private final h.a pBj;
    private final boolean pBk;
    private final f pBl;
    private final com.facebook.common.internal.j<q> pBm;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b pBn;
    private final com.facebook.cache.disk.b pBo;
    private final com.facebook.common.memory.c pBp;
    private final af pBq;
    private final int pBr;
    private final com.facebook.imagepipeline.memory.q pBs;
    private final com.facebook.imagepipeline.decoder.d pBt;
    private final boolean pBu;
    private final com.facebook.cache.disk.b pBv;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c pBw;
    private final i pBx;
    private final boolean pBy;
    private final Set<com.facebook.imagepipeline.g.c> puH;
    private final n pzN;
    private final e pzo;
    @Nullable
    private final com.facebook.imagepipeline.a.f pzp;

    private h(a aVar) {
        com.facebook.imagepipeline.b.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b eup;
        this.pBx = aVar.pBC.eyh();
        this.pBi = aVar.pBi == null ? new com.facebook.imagepipeline.b.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.pBi;
        this.pBj = aVar.pBj == null ? new com.facebook.imagepipeline.b.d() : aVar.pBj;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.pBa == null) {
            fVar = com.facebook.imagepipeline.b.j.ewO();
        } else {
            fVar = aVar.pBa;
        }
        this.pBa = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.pBl = aVar.pBl == null ? new com.facebook.imagepipeline.c.b(new d()) : aVar.pBl;
        this.pBk = aVar.pBk;
        this.pBm = aVar.pBm == null ? new com.facebook.imagepipeline.b.k() : aVar.pBm;
        if (aVar.pzN == null) {
            nVar = t.ewX();
        } else {
            nVar = aVar.pzN;
        }
        this.pzN = nVar;
        this.pBn = aVar.pBn;
        this.pAV = aVar.pAV == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: etW */
            public Boolean get() {
                return true;
            }
        } : aVar.pAV;
        this.pBo = aVar.pBo == null ? ik(aVar.mContext) : aVar.pBo;
        if (aVar.pBp == null) {
            cVar = com.facebook.common.memory.d.etY();
        } else {
            cVar = aVar.pBp;
        }
        this.pBp = cVar;
        this.pBr = aVar.pBB < 0 ? 30000 : aVar.pBB;
        this.pBq = aVar.pBq == null ? new u(this.pBr) : aVar.pBq;
        this.pzp = aVar.pzp;
        if (aVar.pBs == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.ezR().ezS());
        } else {
            qVar = aVar.pBs;
        }
        this.pBs = qVar;
        this.pBt = aVar.pBt == null ? new com.facebook.imagepipeline.decoder.f() : aVar.pBt;
        this.puH = aVar.puH == null ? new HashSet<>() : aVar.puH;
        this.pBu = aVar.pBu;
        this.pBv = aVar.pBv == null ? this.pBo : aVar.pBv;
        this.pBw = aVar.pBw;
        this.pzo = aVar.pzo == null ? new com.facebook.imagepipeline.c.a(this.pBs.ezV()) : aVar.pzo;
        this.pBy = aVar.pBy;
        com.facebook.common.g.b exZ = this.pBx.exZ();
        if (exZ != null) {
            a(exZ, this.pBx, new com.facebook.imagepipeline.a.d(exM()));
        } else if (this.pBx.exW() && com.facebook.common.g.c.ptO && (eup = com.facebook.common.g.c.eup()) != null) {
            a(eup, this.pBx, new com.facebook.imagepipeline.a.d(exM()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.ptR = bVar;
        b.a exY = iVar.exY();
        if (exY != null) {
            bVar.a(exY);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b ik(Context context) {
        return com.facebook.cache.disk.b.ig(context).etD();
    }

    public Bitmap.Config exi() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> exy() {
        return this.pBi;
    }

    public h.a exz() {
        return this.pBj;
    }

    public com.facebook.imagepipeline.b.f exx() {
        return this.pBa;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b exA() {
        return pBz;
    }

    public f exB() {
        return this.pBl;
    }

    public boolean exC() {
        return this.pBk;
    }

    public boolean exD() {
        return this.pBy;
    }

    public com.facebook.common.internal.j<q> exE() {
        return this.pBm;
    }

    public e exF() {
        return this.pzo;
    }

    public n exG() {
        return this.pzN;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b exH() {
        return this.pBn;
    }

    public com.facebook.common.internal.j<Boolean> exI() {
        return this.pAV;
    }

    public com.facebook.cache.disk.b exJ() {
        return this.pBo;
    }

    public com.facebook.common.memory.c exK() {
        return this.pBp;
    }

    public af exL() {
        return this.pBq;
    }

    public com.facebook.imagepipeline.memory.q exM() {
        return this.pBs;
    }

    public com.facebook.imagepipeline.decoder.d exN() {
        return this.pBt;
    }

    public Set<com.facebook.imagepipeline.g.c> exO() {
        return Collections.unmodifiableSet(this.puH);
    }

    public boolean exP() {
        return this.pBu;
    }

    public com.facebook.cache.disk.b exQ() {
        return this.pBv;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c exR() {
        return this.pBw;
    }

    public i exS() {
        return this.pBx;
    }

    public static a il(Context context) {
        return new a(context);
    }

    /* loaded from: classes5.dex */
    public static class b {
        private boolean pBD;

        private b() {
            this.pBD = false;
        }

        public boolean exU() {
            return this.pBD;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private com.facebook.common.internal.j<Boolean> pAV;
        private int pBB;
        private final i.a pBC;
        private com.facebook.imagepipeline.b.f pBa;
        private com.facebook.common.internal.j<q> pBi;
        private h.a pBj;
        private boolean pBk;
        private f pBl;
        private com.facebook.common.internal.j<q> pBm;
        private com.facebook.imagepipeline.decoder.b pBn;
        private com.facebook.cache.disk.b pBo;
        private com.facebook.common.memory.c pBp;
        private af pBq;
        private com.facebook.imagepipeline.memory.q pBs;
        private com.facebook.imagepipeline.decoder.d pBt;
        private boolean pBu;
        private com.facebook.cache.disk.b pBv;
        private com.facebook.imagepipeline.decoder.c pBw;
        private boolean pBy;
        private Set<com.facebook.imagepipeline.g.c> puH;
        private n pzN;
        private e pzo;
        private com.facebook.imagepipeline.a.f pzp;

        private a(Context context) {
            this.pBk = false;
            this.pBu = true;
            this.pBB = -1;
            this.pBC = new i.a(this);
            this.pBy = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h exT() {
            return new h(this);
        }
    }
}
