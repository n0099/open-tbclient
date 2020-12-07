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
/* loaded from: classes15.dex */
public class h {
    private static b plU = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.g.c> pdz;
    @Nullable
    private final com.facebook.imagepipeline.a.f phJ;
    private final e piv;
    private final n pkh;
    private final com.facebook.common.internal.j<q> plD;
    private final h.a plE;
    private final boolean plF;
    private final f plG;
    private final com.facebook.common.internal.j<q> plH;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b plI;
    private final com.facebook.cache.disk.b plJ;
    private final com.facebook.common.memory.c plK;
    private final af plL;
    private final int plM;
    private final com.facebook.imagepipeline.memory.q plN;
    private final com.facebook.imagepipeline.decoder.d plO;
    private final boolean plP;
    private final com.facebook.cache.disk.b plQ;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c plR;
    private final i plS;
    private final boolean plT;
    private final com.facebook.common.internal.j<Boolean> plq;
    private final com.facebook.imagepipeline.b.f plv;

    private h(a aVar) {
        com.facebook.imagepipeline.b.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b eqm;
        this.plS = aVar.plX.eux();
        this.plD = aVar.plD == null ? new com.facebook.imagepipeline.b.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.plD;
        this.plE = aVar.plE == null ? new com.facebook.imagepipeline.b.d() : aVar.plE;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.plv == null) {
            fVar = com.facebook.imagepipeline.b.j.ete();
        } else {
            fVar = aVar.plv;
        }
        this.plv = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.plG = aVar.plG == null ? new com.facebook.imagepipeline.c.b(new d()) : aVar.plG;
        this.plF = aVar.plF;
        this.plH = aVar.plH == null ? new com.facebook.imagepipeline.b.k() : aVar.plH;
        if (aVar.pkh == null) {
            nVar = t.etn();
        } else {
            nVar = aVar.pkh;
        }
        this.pkh = nVar;
        this.plI = aVar.plI;
        this.plq = aVar.plq == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: epS */
            public Boolean get() {
                return true;
            }
        } : aVar.plq;
        this.plJ = aVar.plJ == null ? hI(aVar.mContext) : aVar.plJ;
        if (aVar.plK == null) {
            cVar = com.facebook.common.memory.d.epU();
        } else {
            cVar = aVar.plK;
        }
        this.plK = cVar;
        this.plM = aVar.plW < 0 ? 30000 : aVar.plW;
        this.plL = aVar.plL == null ? new u(this.plM) : aVar.plL;
        this.phJ = aVar.phJ;
        if (aVar.plN == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.ewj().ewk());
        } else {
            qVar = aVar.plN;
        }
        this.plN = qVar;
        this.plO = aVar.plO == null ? new com.facebook.imagepipeline.decoder.f() : aVar.plO;
        this.pdz = aVar.pdz == null ? new HashSet<>() : aVar.pdz;
        this.plP = aVar.plP;
        this.plQ = aVar.plQ == null ? this.plJ : aVar.plQ;
        this.plR = aVar.plR;
        this.piv = aVar.piv == null ? new com.facebook.imagepipeline.c.a(this.plN.ewn()) : aVar.piv;
        this.plT = aVar.plT;
        com.facebook.common.g.b eup = this.plS.eup();
        if (eup != null) {
            a(eup, this.plS, new com.facebook.imagepipeline.a.d(euc()));
        } else if (this.plS.eum() && com.facebook.common.g.c.pcG && (eqm = com.facebook.common.g.c.eqm()) != null) {
            a(eqm, this.plS, new com.facebook.imagepipeline.a.d(euc()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.pcJ = bVar;
        b.a euo = iVar.euo();
        if (euo != null) {
            bVar.a(euo);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b hI(Context context) {
        return com.facebook.cache.disk.b.hE(context).epx();
    }

    public Bitmap.Config ety() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> etO() {
        return this.plD;
    }

    public h.a etP() {
        return this.plE;
    }

    public com.facebook.imagepipeline.b.f etN() {
        return this.plv;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b etQ() {
        return plU;
    }

    public f etR() {
        return this.plG;
    }

    public boolean etS() {
        return this.plF;
    }

    public boolean etT() {
        return this.plT;
    }

    public com.facebook.common.internal.j<q> etU() {
        return this.plH;
    }

    public e etV() {
        return this.piv;
    }

    public n etW() {
        return this.pkh;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b etX() {
        return this.plI;
    }

    public com.facebook.common.internal.j<Boolean> etY() {
        return this.plq;
    }

    public com.facebook.cache.disk.b etZ() {
        return this.plJ;
    }

    public com.facebook.common.memory.c eua() {
        return this.plK;
    }

    public af eub() {
        return this.plL;
    }

    public com.facebook.imagepipeline.memory.q euc() {
        return this.plN;
    }

    public com.facebook.imagepipeline.decoder.d eud() {
        return this.plO;
    }

    public Set<com.facebook.imagepipeline.g.c> eue() {
        return Collections.unmodifiableSet(this.pdz);
    }

    public boolean euf() {
        return this.plP;
    }

    public com.facebook.cache.disk.b eug() {
        return this.plQ;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c euh() {
        return this.plR;
    }

    public i eui() {
        return this.plS;
    }

    public static a hJ(Context context) {
        return new a(context);
    }

    /* loaded from: classes15.dex */
    public static class b {
        private boolean plY;

        private b() {
            this.plY = false;
        }

        public boolean euk() {
            return this.plY;
        }
    }

    /* loaded from: classes15.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.g.c> pdz;
        private com.facebook.imagepipeline.a.f phJ;
        private e piv;
        private n pkh;
        private com.facebook.common.internal.j<q> plD;
        private h.a plE;
        private boolean plF;
        private f plG;
        private com.facebook.common.internal.j<q> plH;
        private com.facebook.imagepipeline.decoder.b plI;
        private com.facebook.cache.disk.b plJ;
        private com.facebook.common.memory.c plK;
        private af plL;
        private com.facebook.imagepipeline.memory.q plN;
        private com.facebook.imagepipeline.decoder.d plO;
        private boolean plP;
        private com.facebook.cache.disk.b plQ;
        private com.facebook.imagepipeline.decoder.c plR;
        private boolean plT;
        private int plW;
        private final i.a plX;
        private com.facebook.common.internal.j<Boolean> plq;
        private com.facebook.imagepipeline.b.f plv;

        private a(Context context) {
            this.plF = false;
            this.plP = true;
            this.plW = -1;
            this.plX = new i.a(this);
            this.plT = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h euj() {
            return new h(this);
        }
    }
}
