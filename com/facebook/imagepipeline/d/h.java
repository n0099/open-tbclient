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
    private static b jGZ = new b();
    private final Bitmap.Config FI;
    private final com.facebook.imagepipeline.c.f jFR;
    private final o jFd;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d jGH;
    private final com.facebook.common.internal.i<u> jGI;
    private final boolean jGJ;
    private final f jGK;
    private final com.facebook.common.internal.i<u> jGL;
    private final e jGM;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b jGN;
    private final com.facebook.cache.disk.b jGO;
    private final com.facebook.common.memory.c jGP;
    private final af jGQ;
    @Nullable
    private final com.facebook.imagepipeline.b.f jGR;
    private final q jGS;
    private final com.facebook.imagepipeline.decoder.d jGT;
    private final Set<com.facebook.imagepipeline.g.b> jGU;
    private final boolean jGV;
    private final com.facebook.cache.disk.b jGW;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c jGX;
    private final i jGY;
    private final com.facebook.common.internal.i<Boolean> jGy;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cuf;
        this.jGY = aVar.jHb.cxL();
        this.jGH = aVar.jGH;
        this.jGI = aVar.jGI == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.jGI;
        this.FI = aVar.FI == null ? Bitmap.Config.ARGB_8888 : aVar.FI;
        if (aVar.jFR == null) {
            fVar = com.facebook.imagepipeline.c.j.cwv();
        } else {
            fVar = aVar.jFR;
        }
        this.jFR = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.jGK = aVar.jGK == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.jGK;
        this.jGJ = aVar.jGJ;
        this.jGL = aVar.jGL == null ? new com.facebook.imagepipeline.c.k() : aVar.jGL;
        if (aVar.jFd == null) {
            oVar = x.cwF();
        } else {
            oVar = aVar.jFd;
        }
        this.jFd = oVar;
        this.jGN = aVar.jGN;
        this.jGy = aVar.jGy == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cxz */
            public Boolean get() {
                return true;
            }
        } : aVar.jGy;
        this.jGO = aVar.jGO == null ? eM(aVar.mContext) : aVar.jGO;
        if (aVar.jGP == null) {
            cVar = com.facebook.common.memory.d.ctH();
        } else {
            cVar = aVar.jGP;
        }
        this.jGP = cVar;
        this.jGQ = aVar.jGQ == null ? new t() : aVar.jGQ;
        this.jGR = aVar.jGR;
        if (aVar.jGS == null) {
            qVar = new q(p.czp().czq());
        } else {
            qVar = aVar.jGS;
        }
        this.jGS = qVar;
        this.jGT = aVar.jGT == null ? new com.facebook.imagepipeline.decoder.f() : aVar.jGT;
        this.jGU = aVar.jGU == null ? new HashSet<>() : aVar.jGU;
        this.jGV = aVar.jGV;
        this.jGW = aVar.jGW == null ? this.jGO : aVar.jGW;
        this.jGX = aVar.jGX;
        this.jGM = aVar.jGM == null ? new com.facebook.imagepipeline.d.a(this.jGS.czt()) : aVar.jGM;
        com.facebook.common.g.b cxK = this.jGY.cxK();
        if (cxK != null) {
            a(cxK, this.jGY, new com.facebook.imagepipeline.b.d(cxs()));
        } else if (this.jGY.cxH() && com.facebook.common.g.c.jAj && (cuf = com.facebook.common.g.c.cuf()) != null) {
            a(cuf, this.jGY, new com.facebook.imagepipeline.b.d(cxs()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.jAm = bVar;
        b.a cxJ = iVar.cxJ();
        if (cxJ != null) {
            bVar.a(cxJ);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eM(Context context) {
        return com.facebook.cache.disk.b.eI(context).ctn();
    }

    public Bitmap.Config cwQ() {
        return this.FI;
    }

    public com.facebook.common.internal.i<u> cxg() {
        return this.jGI;
    }

    public com.facebook.imagepipeline.c.f cxf() {
        return this.jFR;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cxh() {
        return jGZ;
    }

    public f cxi() {
        return this.jGK;
    }

    public boolean cxj() {
        return this.jGJ;
    }

    public com.facebook.common.internal.i<u> cxk() {
        return this.jGL;
    }

    public e cxl() {
        return this.jGM;
    }

    public o cxm() {
        return this.jFd;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cxn() {
        return this.jGN;
    }

    public com.facebook.common.internal.i<Boolean> cxo() {
        return this.jGy;
    }

    public com.facebook.cache.disk.b cxp() {
        return this.jGO;
    }

    public com.facebook.common.memory.c cxq() {
        return this.jGP;
    }

    public af cxr() {
        return this.jGQ;
    }

    public q cxs() {
        return this.jGS;
    }

    public com.facebook.imagepipeline.decoder.d cxt() {
        return this.jGT;
    }

    public Set<com.facebook.imagepipeline.g.b> cxu() {
        return Collections.unmodifiableSet(this.jGU);
    }

    public boolean cxv() {
        return this.jGV;
    }

    public com.facebook.cache.disk.b cxw() {
        return this.jGW;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cxx() {
        return this.jGX;
    }

    public i cxy() {
        return this.jGY;
    }

    public static a eN(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean jHc;

        private b() {
            this.jHc = false;
        }

        public boolean cxB() {
            return this.jHc;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FI;
        private com.facebook.imagepipeline.c.f jFR;
        private o jFd;
        private com.facebook.imagepipeline.a.a.d jGH;
        private com.facebook.common.internal.i<u> jGI;
        private boolean jGJ;
        private f jGK;
        private com.facebook.common.internal.i<u> jGL;
        private e jGM;
        private com.facebook.imagepipeline.decoder.b jGN;
        private com.facebook.cache.disk.b jGO;
        private com.facebook.common.memory.c jGP;
        private af jGQ;
        private com.facebook.imagepipeline.b.f jGR;
        private q jGS;
        private com.facebook.imagepipeline.decoder.d jGT;
        private Set<com.facebook.imagepipeline.g.b> jGU;
        private boolean jGV;
        private com.facebook.cache.disk.b jGW;
        private com.facebook.imagepipeline.decoder.c jGX;
        private com.facebook.common.internal.i<Boolean> jGy;
        private final i.a jHb;
        private final Context mContext;

        private a(Context context) {
            this.jGJ = false;
            this.jGV = true;
            this.jHb = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cxA() {
            return new h(this);
        }
    }
}
