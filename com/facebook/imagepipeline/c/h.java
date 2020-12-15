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
    private static b plW = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.g.c> pdB;
    @Nullable
    private final com.facebook.imagepipeline.a.f phL;
    private final e pix;
    private final n pkj;
    private final com.facebook.common.internal.j<q> plF;
    private final h.a plG;
    private final boolean plH;
    private final f plI;
    private final com.facebook.common.internal.j<q> plJ;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b plK;
    private final com.facebook.cache.disk.b plL;
    private final com.facebook.common.memory.c plM;
    private final af plN;
    private final int plO;
    private final com.facebook.imagepipeline.memory.q plP;
    private final com.facebook.imagepipeline.decoder.d plQ;
    private final boolean plR;
    private final com.facebook.cache.disk.b plS;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c plT;
    private final i plU;
    private final boolean plV;
    private final com.facebook.common.internal.j<Boolean> pls;
    private final com.facebook.imagepipeline.b.f plx;

    private h(a aVar) {
        com.facebook.imagepipeline.b.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b eqn;
        this.plU = aVar.plZ.euy();
        this.plF = aVar.plF == null ? new com.facebook.imagepipeline.b.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.plF;
        this.plG = aVar.plG == null ? new com.facebook.imagepipeline.b.d() : aVar.plG;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.plx == null) {
            fVar = com.facebook.imagepipeline.b.j.etf();
        } else {
            fVar = aVar.plx;
        }
        this.plx = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.plI = aVar.plI == null ? new com.facebook.imagepipeline.c.b(new d()) : aVar.plI;
        this.plH = aVar.plH;
        this.plJ = aVar.plJ == null ? new com.facebook.imagepipeline.b.k() : aVar.plJ;
        if (aVar.pkj == null) {
            nVar = t.eto();
        } else {
            nVar = aVar.pkj;
        }
        this.pkj = nVar;
        this.plK = aVar.plK;
        this.pls = aVar.pls == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: epT */
            public Boolean get() {
                return true;
            }
        } : aVar.pls;
        this.plL = aVar.plL == null ? hI(aVar.mContext) : aVar.plL;
        if (aVar.plM == null) {
            cVar = com.facebook.common.memory.d.epV();
        } else {
            cVar = aVar.plM;
        }
        this.plM = cVar;
        this.plO = aVar.plY < 0 ? 30000 : aVar.plY;
        this.plN = aVar.plN == null ? new u(this.plO) : aVar.plN;
        this.phL = aVar.phL;
        if (aVar.plP == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.ewk().ewl());
        } else {
            qVar = aVar.plP;
        }
        this.plP = qVar;
        this.plQ = aVar.plQ == null ? new com.facebook.imagepipeline.decoder.f() : aVar.plQ;
        this.pdB = aVar.pdB == null ? new HashSet<>() : aVar.pdB;
        this.plR = aVar.plR;
        this.plS = aVar.plS == null ? this.plL : aVar.plS;
        this.plT = aVar.plT;
        this.pix = aVar.pix == null ? new com.facebook.imagepipeline.c.a(this.plP.ewo()) : aVar.pix;
        this.plV = aVar.plV;
        com.facebook.common.g.b euq = this.plU.euq();
        if (euq != null) {
            a(euq, this.plU, new com.facebook.imagepipeline.a.d(eud()));
        } else if (this.plU.eun() && com.facebook.common.g.c.pcI && (eqn = com.facebook.common.g.c.eqn()) != null) {
            a(eqn, this.plU, new com.facebook.imagepipeline.a.d(eud()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.pcL = bVar;
        b.a eup = iVar.eup();
        if (eup != null) {
            bVar.a(eup);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b hI(Context context) {
        return com.facebook.cache.disk.b.hE(context).epy();
    }

    public Bitmap.Config etz() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> etP() {
        return this.plF;
    }

    public h.a etQ() {
        return this.plG;
    }

    public com.facebook.imagepipeline.b.f etO() {
        return this.plx;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b etR() {
        return plW;
    }

    public f etS() {
        return this.plI;
    }

    public boolean etT() {
        return this.plH;
    }

    public boolean etU() {
        return this.plV;
    }

    public com.facebook.common.internal.j<q> etV() {
        return this.plJ;
    }

    public e etW() {
        return this.pix;
    }

    public n etX() {
        return this.pkj;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b etY() {
        return this.plK;
    }

    public com.facebook.common.internal.j<Boolean> etZ() {
        return this.pls;
    }

    public com.facebook.cache.disk.b eua() {
        return this.plL;
    }

    public com.facebook.common.memory.c eub() {
        return this.plM;
    }

    public af euc() {
        return this.plN;
    }

    public com.facebook.imagepipeline.memory.q eud() {
        return this.plP;
    }

    public com.facebook.imagepipeline.decoder.d eue() {
        return this.plQ;
    }

    public Set<com.facebook.imagepipeline.g.c> euf() {
        return Collections.unmodifiableSet(this.pdB);
    }

    public boolean eug() {
        return this.plR;
    }

    public com.facebook.cache.disk.b euh() {
        return this.plS;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c eui() {
        return this.plT;
    }

    public i euj() {
        return this.plU;
    }

    public static a hJ(Context context) {
        return new a(context);
    }

    /* loaded from: classes15.dex */
    public static class b {
        private boolean pma;

        private b() {
            this.pma = false;
        }

        public boolean eul() {
            return this.pma;
        }
    }

    /* loaded from: classes15.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.g.c> pdB;
        private com.facebook.imagepipeline.a.f phL;
        private e pix;
        private n pkj;
        private com.facebook.common.internal.j<q> plF;
        private h.a plG;
        private boolean plH;
        private f plI;
        private com.facebook.common.internal.j<q> plJ;
        private com.facebook.imagepipeline.decoder.b plK;
        private com.facebook.cache.disk.b plL;
        private com.facebook.common.memory.c plM;
        private af plN;
        private com.facebook.imagepipeline.memory.q plP;
        private com.facebook.imagepipeline.decoder.d plQ;
        private boolean plR;
        private com.facebook.cache.disk.b plS;
        private com.facebook.imagepipeline.decoder.c plT;
        private boolean plV;
        private int plY;
        private final i.a plZ;
        private com.facebook.common.internal.j<Boolean> pls;
        private com.facebook.imagepipeline.b.f plx;

        private a(Context context) {
            this.plH = false;
            this.plR = true;
            this.plY = -1;
            this.plZ = new i.a(this);
            this.plV = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h euk() {
            return new h(this);
        }
    }
}
