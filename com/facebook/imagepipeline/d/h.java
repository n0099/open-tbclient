package com.facebook.imagepipeline.d;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.o;
import com.facebook.imagepipeline.c.u;
import com.facebook.imagepipeline.c.x;
import com.facebook.imagepipeline.d.i;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.t;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class h {
    private static b jHN = new b();
    private final Bitmap.Config FI;
    private final o jFR;
    private final com.facebook.imagepipeline.c.f jGF;
    private final e jHA;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b jHB;
    private final com.facebook.cache.disk.b jHC;
    private final com.facebook.common.memory.c jHD;
    private final af jHE;
    @Nullable
    private final com.facebook.imagepipeline.b.f jHF;
    private final q jHG;
    private final com.facebook.imagepipeline.decoder.d jHH;
    private final Set<com.facebook.imagepipeline.g.b> jHI;
    private final boolean jHJ;
    private final com.facebook.cache.disk.b jHK;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c jHL;
    private final i jHM;
    private final com.facebook.common.internal.i<Boolean> jHm;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d jHv;
    private final com.facebook.common.internal.i<u> jHw;
    private final boolean jHx;
    private final f jHy;
    private final com.facebook.common.internal.i<u> jHz;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cuj;
        this.jHM = aVar.jHP.cxP();
        this.jHv = aVar.jHv;
        this.jHw = aVar.jHw == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.jHw;
        this.FI = aVar.FI == null ? Bitmap.Config.ARGB_8888 : aVar.FI;
        if (aVar.jGF == null) {
            fVar = com.facebook.imagepipeline.c.j.cwz();
        } else {
            fVar = aVar.jGF;
        }
        this.jGF = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.jHy = aVar.jHy == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.jHy;
        this.jHx = aVar.jHx;
        this.jHz = aVar.jHz == null ? new com.facebook.imagepipeline.c.k() : aVar.jHz;
        if (aVar.jFR == null) {
            oVar = x.cwJ();
        } else {
            oVar = aVar.jFR;
        }
        this.jFR = oVar;
        this.jHB = aVar.jHB;
        this.jHm = aVar.jHm == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cxD */
            public Boolean get() {
                return true;
            }
        } : aVar.jHm;
        this.jHC = aVar.jHC == null ? eO(aVar.mContext) : aVar.jHC;
        if (aVar.jHD == null) {
            cVar = com.facebook.common.memory.d.ctL();
        } else {
            cVar = aVar.jHD;
        }
        this.jHD = cVar;
        this.jHE = aVar.jHE == null ? new t() : aVar.jHE;
        this.jHF = aVar.jHF;
        if (aVar.jHG == null) {
            qVar = new q(p.czt().czu());
        } else {
            qVar = aVar.jHG;
        }
        this.jHG = qVar;
        this.jHH = aVar.jHH == null ? new com.facebook.imagepipeline.decoder.f() : aVar.jHH;
        this.jHI = aVar.jHI == null ? new HashSet<>() : aVar.jHI;
        this.jHJ = aVar.jHJ;
        this.jHK = aVar.jHK == null ? this.jHC : aVar.jHK;
        this.jHL = aVar.jHL;
        this.jHA = aVar.jHA == null ? new com.facebook.imagepipeline.d.a(this.jHG.czx()) : aVar.jHA;
        com.facebook.common.g.b cxO = this.jHM.cxO();
        if (cxO != null) {
            a(cxO, this.jHM, new com.facebook.imagepipeline.b.d(cxw()));
        } else if (this.jHM.cxL() && com.facebook.common.g.c.jAX && (cuj = com.facebook.common.g.c.cuj()) != null) {
            a(cuj, this.jHM, new com.facebook.imagepipeline.b.d(cxw()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.jBa = bVar;
        b.a cxN = iVar.cxN();
        if (cxN != null) {
            bVar.a(cxN);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eO(Context context) {
        return com.facebook.cache.disk.b.eK(context).ctr();
    }

    public Bitmap.Config cwU() {
        return this.FI;
    }

    public com.facebook.common.internal.i<u> cxk() {
        return this.jHw;
    }

    public com.facebook.imagepipeline.c.f cxj() {
        return this.jGF;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cxl() {
        return jHN;
    }

    public f cxm() {
        return this.jHy;
    }

    public boolean cxn() {
        return this.jHx;
    }

    public com.facebook.common.internal.i<u> cxo() {
        return this.jHz;
    }

    public e cxp() {
        return this.jHA;
    }

    public o cxq() {
        return this.jFR;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cxr() {
        return this.jHB;
    }

    public com.facebook.common.internal.i<Boolean> cxs() {
        return this.jHm;
    }

    public com.facebook.cache.disk.b cxt() {
        return this.jHC;
    }

    public com.facebook.common.memory.c cxu() {
        return this.jHD;
    }

    public af cxv() {
        return this.jHE;
    }

    public q cxw() {
        return this.jHG;
    }

    public com.facebook.imagepipeline.decoder.d cxx() {
        return this.jHH;
    }

    public Set<com.facebook.imagepipeline.g.b> cxy() {
        return Collections.unmodifiableSet(this.jHI);
    }

    public boolean cxz() {
        return this.jHJ;
    }

    public com.facebook.cache.disk.b cxA() {
        return this.jHK;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cxB() {
        return this.jHL;
    }

    public i cxC() {
        return this.jHM;
    }

    public static a eP(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean jHQ;

        private b() {
            this.jHQ = false;
        }

        public boolean cxF() {
            return this.jHQ;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FI;
        private o jFR;
        private com.facebook.imagepipeline.c.f jGF;
        private e jHA;
        private com.facebook.imagepipeline.decoder.b jHB;
        private com.facebook.cache.disk.b jHC;
        private com.facebook.common.memory.c jHD;
        private af jHE;
        private com.facebook.imagepipeline.b.f jHF;
        private q jHG;
        private com.facebook.imagepipeline.decoder.d jHH;
        private Set<com.facebook.imagepipeline.g.b> jHI;
        private boolean jHJ;
        private com.facebook.cache.disk.b jHK;
        private com.facebook.imagepipeline.decoder.c jHL;
        private final i.a jHP;
        private com.facebook.common.internal.i<Boolean> jHm;
        private com.facebook.imagepipeline.a.a.d jHv;
        private com.facebook.common.internal.i<u> jHw;
        private boolean jHx;
        private f jHy;
        private com.facebook.common.internal.i<u> jHz;
        private final Context mContext;

        private a(Context context) {
            this.jHx = false;
            this.jHJ = true;
            this.jHP = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cxE() {
            return new h(this);
        }
    }
}
