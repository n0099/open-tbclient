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
    private static b jHF = new b();
    private final Bitmap.Config FI;
    private final o jFJ;
    private final com.facebook.imagepipeline.c.f jGx;
    private final Set<com.facebook.imagepipeline.g.b> jHA;
    private final boolean jHB;
    private final com.facebook.cache.disk.b jHC;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c jHD;
    private final i jHE;
    private final com.facebook.common.internal.i<Boolean> jHe;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d jHn;
    private final com.facebook.common.internal.i<u> jHo;
    private final boolean jHp;
    private final f jHq;
    private final com.facebook.common.internal.i<u> jHr;
    private final e jHs;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b jHt;
    private final com.facebook.cache.disk.b jHu;
    private final com.facebook.common.memory.c jHv;
    private final af jHw;
    @Nullable
    private final com.facebook.imagepipeline.b.f jHx;
    private final q jHy;
    private final com.facebook.imagepipeline.decoder.d jHz;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cum;
        this.jHE = aVar.jHH.cxS();
        this.jHn = aVar.jHn;
        this.jHo = aVar.jHo == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.jHo;
        this.FI = aVar.FI == null ? Bitmap.Config.ARGB_8888 : aVar.FI;
        if (aVar.jGx == null) {
            fVar = com.facebook.imagepipeline.c.j.cwC();
        } else {
            fVar = aVar.jGx;
        }
        this.jGx = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.jHq = aVar.jHq == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.jHq;
        this.jHp = aVar.jHp;
        this.jHr = aVar.jHr == null ? new com.facebook.imagepipeline.c.k() : aVar.jHr;
        if (aVar.jFJ == null) {
            oVar = x.cwM();
        } else {
            oVar = aVar.jFJ;
        }
        this.jFJ = oVar;
        this.jHt = aVar.jHt;
        this.jHe = aVar.jHe == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cxG */
            public Boolean get() {
                return true;
            }
        } : aVar.jHe;
        this.jHu = aVar.jHu == null ? eN(aVar.mContext) : aVar.jHu;
        if (aVar.jHv == null) {
            cVar = com.facebook.common.memory.d.ctO();
        } else {
            cVar = aVar.jHv;
        }
        this.jHv = cVar;
        this.jHw = aVar.jHw == null ? new t() : aVar.jHw;
        this.jHx = aVar.jHx;
        if (aVar.jHy == null) {
            qVar = new q(p.czw().czx());
        } else {
            qVar = aVar.jHy;
        }
        this.jHy = qVar;
        this.jHz = aVar.jHz == null ? new com.facebook.imagepipeline.decoder.f() : aVar.jHz;
        this.jHA = aVar.jHA == null ? new HashSet<>() : aVar.jHA;
        this.jHB = aVar.jHB;
        this.jHC = aVar.jHC == null ? this.jHu : aVar.jHC;
        this.jHD = aVar.jHD;
        this.jHs = aVar.jHs == null ? new com.facebook.imagepipeline.d.a(this.jHy.czA()) : aVar.jHs;
        com.facebook.common.g.b cxR = this.jHE.cxR();
        if (cxR != null) {
            a(cxR, this.jHE, new com.facebook.imagepipeline.b.d(cxz()));
        } else if (this.jHE.cxO() && com.facebook.common.g.c.jAP && (cum = com.facebook.common.g.c.cum()) != null) {
            a(cum, this.jHE, new com.facebook.imagepipeline.b.d(cxz()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.jAS = bVar;
        b.a cxQ = iVar.cxQ();
        if (cxQ != null) {
            bVar.a(cxQ);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eN(Context context) {
        return com.facebook.cache.disk.b.eJ(context).ctu();
    }

    public Bitmap.Config cwX() {
        return this.FI;
    }

    public com.facebook.common.internal.i<u> cxn() {
        return this.jHo;
    }

    public com.facebook.imagepipeline.c.f cxm() {
        return this.jGx;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cxo() {
        return jHF;
    }

    public f cxp() {
        return this.jHq;
    }

    public boolean cxq() {
        return this.jHp;
    }

    public com.facebook.common.internal.i<u> cxr() {
        return this.jHr;
    }

    public e cxs() {
        return this.jHs;
    }

    public o cxt() {
        return this.jFJ;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cxu() {
        return this.jHt;
    }

    public com.facebook.common.internal.i<Boolean> cxv() {
        return this.jHe;
    }

    public com.facebook.cache.disk.b cxw() {
        return this.jHu;
    }

    public com.facebook.common.memory.c cxx() {
        return this.jHv;
    }

    public af cxy() {
        return this.jHw;
    }

    public q cxz() {
        return this.jHy;
    }

    public com.facebook.imagepipeline.decoder.d cxA() {
        return this.jHz;
    }

    public Set<com.facebook.imagepipeline.g.b> cxB() {
        return Collections.unmodifiableSet(this.jHA);
    }

    public boolean cxC() {
        return this.jHB;
    }

    public com.facebook.cache.disk.b cxD() {
        return this.jHC;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cxE() {
        return this.jHD;
    }

    public i cxF() {
        return this.jHE;
    }

    public static a eO(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean jHI;

        private b() {
            this.jHI = false;
        }

        public boolean cxI() {
            return this.jHI;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FI;
        private o jFJ;
        private com.facebook.imagepipeline.c.f jGx;
        private Set<com.facebook.imagepipeline.g.b> jHA;
        private boolean jHB;
        private com.facebook.cache.disk.b jHC;
        private com.facebook.imagepipeline.decoder.c jHD;
        private final i.a jHH;
        private com.facebook.common.internal.i<Boolean> jHe;
        private com.facebook.imagepipeline.a.a.d jHn;
        private com.facebook.common.internal.i<u> jHo;
        private boolean jHp;
        private f jHq;
        private com.facebook.common.internal.i<u> jHr;
        private e jHs;
        private com.facebook.imagepipeline.decoder.b jHt;
        private com.facebook.cache.disk.b jHu;
        private com.facebook.common.memory.c jHv;
        private af jHw;
        private com.facebook.imagepipeline.b.f jHx;
        private q jHy;
        private com.facebook.imagepipeline.decoder.d jHz;
        private final Context mContext;

        private a(Context context) {
            this.jHp = false;
            this.jHB = true;
            this.jHH = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cxH() {
            return new h(this);
        }
    }
}
