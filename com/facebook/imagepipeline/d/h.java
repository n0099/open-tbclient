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
    private static b jZN = new b();
    private final Bitmap.Config Ds;
    private final o jXR;
    private final com.facebook.imagepipeline.c.f jYF;
    private final e jZA;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b jZB;
    private final com.facebook.cache.disk.b jZC;
    private final com.facebook.common.memory.c jZD;
    private final af jZE;
    @Nullable
    private final com.facebook.imagepipeline.b.f jZF;
    private final q jZG;
    private final com.facebook.imagepipeline.decoder.d jZH;
    private final Set<com.facebook.imagepipeline.g.b> jZI;
    private final boolean jZJ;
    private final com.facebook.cache.disk.b jZK;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c jZL;
    private final i jZM;
    private final com.facebook.common.internal.i<Boolean> jZm;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d jZv;
    private final com.facebook.common.internal.i<u> jZw;
    private final boolean jZx;
    private final f jZy;
    private final com.facebook.common.internal.i<u> jZz;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cCb;
        this.jZM = aVar.jZP.cFH();
        this.jZv = aVar.jZv;
        this.jZw = aVar.jZw == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.jZw;
        this.Ds = aVar.Ds == null ? Bitmap.Config.ARGB_8888 : aVar.Ds;
        if (aVar.jYF == null) {
            fVar = com.facebook.imagepipeline.c.j.cEr();
        } else {
            fVar = aVar.jYF;
        }
        this.jYF = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.jZy = aVar.jZy == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.jZy;
        this.jZx = aVar.jZx;
        this.jZz = aVar.jZz == null ? new com.facebook.imagepipeline.c.k() : aVar.jZz;
        if (aVar.jXR == null) {
            oVar = x.cEB();
        } else {
            oVar = aVar.jXR;
        }
        this.jXR = oVar;
        this.jZB = aVar.jZB;
        this.jZm = aVar.jZm == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cFv */
            public Boolean get() {
                return true;
            }
        } : aVar.jZm;
        this.jZC = aVar.jZC == null ? eC(aVar.mContext) : aVar.jZC;
        if (aVar.jZD == null) {
            cVar = com.facebook.common.memory.d.cBE();
        } else {
            cVar = aVar.jZD;
        }
        this.jZD = cVar;
        this.jZE = aVar.jZE == null ? new t() : aVar.jZE;
        this.jZF = aVar.jZF;
        if (aVar.jZG == null) {
            qVar = new q(p.cHl().cHm());
        } else {
            qVar = aVar.jZG;
        }
        this.jZG = qVar;
        this.jZH = aVar.jZH == null ? new com.facebook.imagepipeline.decoder.f() : aVar.jZH;
        this.jZI = aVar.jZI == null ? new HashSet<>() : aVar.jZI;
        this.jZJ = aVar.jZJ;
        this.jZK = aVar.jZK == null ? this.jZC : aVar.jZK;
        this.jZL = aVar.jZL;
        this.jZA = aVar.jZA == null ? new com.facebook.imagepipeline.d.a(this.jZG.cHp()) : aVar.jZA;
        com.facebook.common.g.b cFG = this.jZM.cFG();
        if (cFG != null) {
            a(cFG, this.jZM, new com.facebook.imagepipeline.b.d(cFo()));
        } else if (this.jZM.cFD() && com.facebook.common.g.c.jSZ && (cCb = com.facebook.common.g.c.cCb()) != null) {
            a(cCb, this.jZM, new com.facebook.imagepipeline.b.d(cFo()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.jTc = bVar;
        b.a cFF = iVar.cFF();
        if (cFF != null) {
            bVar.a(cFF);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eC(Context context) {
        return com.facebook.cache.disk.b.ey(context).cBk();
    }

    public Bitmap.Config cEM() {
        return this.Ds;
    }

    public com.facebook.common.internal.i<u> cFc() {
        return this.jZw;
    }

    public com.facebook.imagepipeline.c.f cFb() {
        return this.jYF;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cFd() {
        return jZN;
    }

    public f cFe() {
        return this.jZy;
    }

    public boolean cFf() {
        return this.jZx;
    }

    public com.facebook.common.internal.i<u> cFg() {
        return this.jZz;
    }

    public e cFh() {
        return this.jZA;
    }

    public o cFi() {
        return this.jXR;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cFj() {
        return this.jZB;
    }

    public com.facebook.common.internal.i<Boolean> cFk() {
        return this.jZm;
    }

    public com.facebook.cache.disk.b cFl() {
        return this.jZC;
    }

    public com.facebook.common.memory.c cFm() {
        return this.jZD;
    }

    public af cFn() {
        return this.jZE;
    }

    public q cFo() {
        return this.jZG;
    }

    public com.facebook.imagepipeline.decoder.d cFp() {
        return this.jZH;
    }

    public Set<com.facebook.imagepipeline.g.b> cFq() {
        return Collections.unmodifiableSet(this.jZI);
    }

    public boolean cFr() {
        return this.jZJ;
    }

    public com.facebook.cache.disk.b cFs() {
        return this.jZK;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cFt() {
        return this.jZL;
    }

    public i cFu() {
        return this.jZM;
    }

    public static a eD(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean jZQ;

        private b() {
            this.jZQ = false;
        }

        public boolean cFx() {
            return this.jZQ;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config Ds;
        private o jXR;
        private com.facebook.imagepipeline.c.f jYF;
        private e jZA;
        private com.facebook.imagepipeline.decoder.b jZB;
        private com.facebook.cache.disk.b jZC;
        private com.facebook.common.memory.c jZD;
        private af jZE;
        private com.facebook.imagepipeline.b.f jZF;
        private q jZG;
        private com.facebook.imagepipeline.decoder.d jZH;
        private Set<com.facebook.imagepipeline.g.b> jZI;
        private boolean jZJ;
        private com.facebook.cache.disk.b jZK;
        private com.facebook.imagepipeline.decoder.c jZL;
        private final i.a jZP;
        private com.facebook.common.internal.i<Boolean> jZm;
        private com.facebook.imagepipeline.a.a.d jZv;
        private com.facebook.common.internal.i<u> jZw;
        private boolean jZx;
        private f jZy;
        private com.facebook.common.internal.i<u> jZz;
        private final Context mContext;

        private a(Context context) {
            this.jZx = false;
            this.jZJ = true;
            this.jZP = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cFw() {
            return new h(this);
        }
    }
}
