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
    private static b jZO = new b();
    private final Bitmap.Config Ds;
    private final o jXS;
    private final com.facebook.imagepipeline.c.f jYG;
    private final com.facebook.common.internal.i<u> jZA;
    private final e jZB;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b jZC;
    private final com.facebook.cache.disk.b jZD;
    private final com.facebook.common.memory.c jZE;
    private final af jZF;
    @Nullable
    private final com.facebook.imagepipeline.b.f jZG;
    private final q jZH;
    private final com.facebook.imagepipeline.decoder.d jZI;
    private final Set<com.facebook.imagepipeline.g.b> jZJ;
    private final boolean jZK;
    private final com.facebook.cache.disk.b jZL;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c jZM;
    private final i jZN;
    private final com.facebook.common.internal.i<Boolean> jZn;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d jZw;
    private final com.facebook.common.internal.i<u> jZx;
    private final boolean jZy;
    private final f jZz;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cCd;
        this.jZN = aVar.jZQ.cFJ();
        this.jZw = aVar.jZw;
        this.jZx = aVar.jZx == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.jZx;
        this.Ds = aVar.Ds == null ? Bitmap.Config.ARGB_8888 : aVar.Ds;
        if (aVar.jYG == null) {
            fVar = com.facebook.imagepipeline.c.j.cEt();
        } else {
            fVar = aVar.jYG;
        }
        this.jYG = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.jZz = aVar.jZz == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.jZz;
        this.jZy = aVar.jZy;
        this.jZA = aVar.jZA == null ? new com.facebook.imagepipeline.c.k() : aVar.jZA;
        if (aVar.jXS == null) {
            oVar = x.cED();
        } else {
            oVar = aVar.jXS;
        }
        this.jXS = oVar;
        this.jZC = aVar.jZC;
        this.jZn = aVar.jZn == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cFx */
            public Boolean get() {
                return true;
            }
        } : aVar.jZn;
        this.jZD = aVar.jZD == null ? eC(aVar.mContext) : aVar.jZD;
        if (aVar.jZE == null) {
            cVar = com.facebook.common.memory.d.cBG();
        } else {
            cVar = aVar.jZE;
        }
        this.jZE = cVar;
        this.jZF = aVar.jZF == null ? new t() : aVar.jZF;
        this.jZG = aVar.jZG;
        if (aVar.jZH == null) {
            qVar = new q(p.cHn().cHo());
        } else {
            qVar = aVar.jZH;
        }
        this.jZH = qVar;
        this.jZI = aVar.jZI == null ? new com.facebook.imagepipeline.decoder.f() : aVar.jZI;
        this.jZJ = aVar.jZJ == null ? new HashSet<>() : aVar.jZJ;
        this.jZK = aVar.jZK;
        this.jZL = aVar.jZL == null ? this.jZD : aVar.jZL;
        this.jZM = aVar.jZM;
        this.jZB = aVar.jZB == null ? new com.facebook.imagepipeline.d.a(this.jZH.cHr()) : aVar.jZB;
        com.facebook.common.g.b cFI = this.jZN.cFI();
        if (cFI != null) {
            a(cFI, this.jZN, new com.facebook.imagepipeline.b.d(cFq()));
        } else if (this.jZN.cFF() && com.facebook.common.g.c.jTa && (cCd = com.facebook.common.g.c.cCd()) != null) {
            a(cCd, this.jZN, new com.facebook.imagepipeline.b.d(cFq()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.jTd = bVar;
        b.a cFH = iVar.cFH();
        if (cFH != null) {
            bVar.a(cFH);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eC(Context context) {
        return com.facebook.cache.disk.b.ey(context).cBm();
    }

    public Bitmap.Config cEO() {
        return this.Ds;
    }

    public com.facebook.common.internal.i<u> cFe() {
        return this.jZx;
    }

    public com.facebook.imagepipeline.c.f cFd() {
        return this.jYG;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cFf() {
        return jZO;
    }

    public f cFg() {
        return this.jZz;
    }

    public boolean cFh() {
        return this.jZy;
    }

    public com.facebook.common.internal.i<u> cFi() {
        return this.jZA;
    }

    public e cFj() {
        return this.jZB;
    }

    public o cFk() {
        return this.jXS;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cFl() {
        return this.jZC;
    }

    public com.facebook.common.internal.i<Boolean> cFm() {
        return this.jZn;
    }

    public com.facebook.cache.disk.b cFn() {
        return this.jZD;
    }

    public com.facebook.common.memory.c cFo() {
        return this.jZE;
    }

    public af cFp() {
        return this.jZF;
    }

    public q cFq() {
        return this.jZH;
    }

    public com.facebook.imagepipeline.decoder.d cFr() {
        return this.jZI;
    }

    public Set<com.facebook.imagepipeline.g.b> cFs() {
        return Collections.unmodifiableSet(this.jZJ);
    }

    public boolean cFt() {
        return this.jZK;
    }

    public com.facebook.cache.disk.b cFu() {
        return this.jZL;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cFv() {
        return this.jZM;
    }

    public i cFw() {
        return this.jZN;
    }

    public static a eD(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean jZR;

        private b() {
            this.jZR = false;
        }

        public boolean cFz() {
            return this.jZR;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config Ds;
        private o jXS;
        private com.facebook.imagepipeline.c.f jYG;
        private com.facebook.common.internal.i<u> jZA;
        private e jZB;
        private com.facebook.imagepipeline.decoder.b jZC;
        private com.facebook.cache.disk.b jZD;
        private com.facebook.common.memory.c jZE;
        private af jZF;
        private com.facebook.imagepipeline.b.f jZG;
        private q jZH;
        private com.facebook.imagepipeline.decoder.d jZI;
        private Set<com.facebook.imagepipeline.g.b> jZJ;
        private boolean jZK;
        private com.facebook.cache.disk.b jZL;
        private com.facebook.imagepipeline.decoder.c jZM;
        private final i.a jZQ;
        private com.facebook.common.internal.i<Boolean> jZn;
        private com.facebook.imagepipeline.a.a.d jZw;
        private com.facebook.common.internal.i<u> jZx;
        private boolean jZy;
        private f jZz;
        private final Context mContext;

        private a(Context context) {
            this.jZy = false;
            this.jZK = true;
            this.jZQ = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cFy() {
            return new h(this);
        }
    }
}
