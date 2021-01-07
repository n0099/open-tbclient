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
/* loaded from: classes3.dex */
public class h {
    private static b pDg = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final n pBu;
    private final com.facebook.common.internal.j<Boolean> pCC;
    private final com.facebook.imagepipeline.b.f pCH;
    private final com.facebook.common.internal.j<q> pCP;
    private final h.a pCQ;
    private final boolean pCR;
    private final f pCS;
    private final com.facebook.common.internal.j<q> pCT;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b pCU;
    private final com.facebook.cache.disk.b pCV;
    private final com.facebook.common.memory.c pCW;
    private final af pCX;
    private final int pCY;
    private final com.facebook.imagepipeline.memory.q pCZ;
    private final com.facebook.imagepipeline.decoder.d pDa;
    private final boolean pDb;
    private final com.facebook.cache.disk.b pDc;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c pDd;
    private final i pDe;
    private final boolean pDf;
    private final Set<com.facebook.imagepipeline.g.c> puO;
    private final e pzJ;
    @Nullable
    private final com.facebook.imagepipeline.a.f pza;

    private h(a aVar) {
        com.facebook.imagepipeline.b.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b euw;
        this.pDe = aVar.pDj.eyJ();
        this.pCP = aVar.pCP == null ? new com.facebook.imagepipeline.b.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.pCP;
        this.pCQ = aVar.pCQ == null ? new com.facebook.imagepipeline.b.d() : aVar.pCQ;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.pCH == null) {
            fVar = com.facebook.imagepipeline.b.j.exq();
        } else {
            fVar = aVar.pCH;
        }
        this.pCH = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.pCS = aVar.pCS == null ? new com.facebook.imagepipeline.c.b(new d()) : aVar.pCS;
        this.pCR = aVar.pCR;
        this.pCT = aVar.pCT == null ? new com.facebook.imagepipeline.b.k() : aVar.pCT;
        if (aVar.pBu == null) {
            nVar = t.exz();
        } else {
            nVar = aVar.pBu;
        }
        this.pBu = nVar;
        this.pCU = aVar.pCU;
        this.pCC = aVar.pCC == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: euc */
            public Boolean get() {
                return true;
            }
        } : aVar.pCC;
        this.pCV = aVar.pCV == null ? ik(aVar.mContext) : aVar.pCV;
        if (aVar.pCW == null) {
            cVar = com.facebook.common.memory.d.eue();
        } else {
            cVar = aVar.pCW;
        }
        this.pCW = cVar;
        this.pCY = aVar.pDi < 0 ? 30000 : aVar.pDi;
        this.pCX = aVar.pCX == null ? new u(this.pCY) : aVar.pCX;
        this.pza = aVar.pza;
        if (aVar.pCZ == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.eAv().eAw());
        } else {
            qVar = aVar.pCZ;
        }
        this.pCZ = qVar;
        this.pDa = aVar.pDa == null ? new com.facebook.imagepipeline.decoder.f() : aVar.pDa;
        this.puO = aVar.puO == null ? new HashSet<>() : aVar.puO;
        this.pDb = aVar.pDb;
        this.pDc = aVar.pDc == null ? this.pCV : aVar.pDc;
        this.pDd = aVar.pDd;
        this.pzJ = aVar.pzJ == null ? new com.facebook.imagepipeline.c.a(this.pCZ.eAz()) : aVar.pzJ;
        this.pDf = aVar.pDf;
        com.facebook.common.g.b eyB = this.pDe.eyB();
        if (eyB != null) {
            a(eyB, this.pDe, new com.facebook.imagepipeline.a.d(eyo()));
        } else if (this.pDe.eyy() && com.facebook.common.g.c.ptV && (euw = com.facebook.common.g.c.euw()) != null) {
            a(euw, this.pDe, new com.facebook.imagepipeline.a.d(eyo()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.ptY = bVar;
        b.a eyA = iVar.eyA();
        if (eyA != null) {
            bVar.a(eyA);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b ik(Context context) {
        return com.facebook.cache.disk.b.ig(context).etH();
    }

    public Bitmap.Config exK() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> eya() {
        return this.pCP;
    }

    public h.a eyb() {
        return this.pCQ;
    }

    public com.facebook.imagepipeline.b.f exZ() {
        return this.pCH;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b eyc() {
        return pDg;
    }

    public f eyd() {
        return this.pCS;
    }

    public boolean eye() {
        return this.pCR;
    }

    public boolean eyf() {
        return this.pDf;
    }

    public com.facebook.common.internal.j<q> eyg() {
        return this.pCT;
    }

    public e eyh() {
        return this.pzJ;
    }

    public n eyi() {
        return this.pBu;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b eyj() {
        return this.pCU;
    }

    public com.facebook.common.internal.j<Boolean> eyk() {
        return this.pCC;
    }

    public com.facebook.cache.disk.b eyl() {
        return this.pCV;
    }

    public com.facebook.common.memory.c eym() {
        return this.pCW;
    }

    public af eyn() {
        return this.pCX;
    }

    public com.facebook.imagepipeline.memory.q eyo() {
        return this.pCZ;
    }

    public com.facebook.imagepipeline.decoder.d eyp() {
        return this.pDa;
    }

    public Set<com.facebook.imagepipeline.g.c> eyq() {
        return Collections.unmodifiableSet(this.puO);
    }

    public boolean eyr() {
        return this.pDb;
    }

    public com.facebook.cache.disk.b eys() {
        return this.pDc;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c eyt() {
        return this.pDd;
    }

    public i eyu() {
        return this.pDe;
    }

    public static a il(Context context) {
        return new a(context);
    }

    /* loaded from: classes3.dex */
    public static class b {
        private boolean pDk;

        private b() {
            this.pDk = false;
        }

        public boolean eyw() {
            return this.pDk;
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private n pBu;
        private com.facebook.common.internal.j<Boolean> pCC;
        private com.facebook.imagepipeline.b.f pCH;
        private com.facebook.common.internal.j<q> pCP;
        private h.a pCQ;
        private boolean pCR;
        private f pCS;
        private com.facebook.common.internal.j<q> pCT;
        private com.facebook.imagepipeline.decoder.b pCU;
        private com.facebook.cache.disk.b pCV;
        private com.facebook.common.memory.c pCW;
        private af pCX;
        private com.facebook.imagepipeline.memory.q pCZ;
        private com.facebook.imagepipeline.decoder.d pDa;
        private boolean pDb;
        private com.facebook.cache.disk.b pDc;
        private com.facebook.imagepipeline.decoder.c pDd;
        private boolean pDf;
        private int pDi;
        private final i.a pDj;
        private Set<com.facebook.imagepipeline.g.c> puO;
        private e pzJ;
        private com.facebook.imagepipeline.a.f pza;

        private a(Context context) {
            this.pCR = false;
            this.pDb = true;
            this.pDi = -1;
            this.pDj = new i.a(this);
            this.pDf = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h eyv() {
            return new h(this);
        }
    }
}
