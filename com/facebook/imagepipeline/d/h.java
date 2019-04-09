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
    private static b jHa = new b();
    private final Bitmap.Config FI;
    private final com.facebook.imagepipeline.c.f jFS;
    private final o jFe;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d jGI;
    private final com.facebook.common.internal.i<u> jGJ;
    private final boolean jGK;
    private final f jGL;
    private final com.facebook.common.internal.i<u> jGM;
    private final e jGN;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b jGO;
    private final com.facebook.cache.disk.b jGP;
    private final com.facebook.common.memory.c jGQ;
    private final af jGR;
    @Nullable
    private final com.facebook.imagepipeline.b.f jGS;
    private final q jGT;
    private final com.facebook.imagepipeline.decoder.d jGU;
    private final Set<com.facebook.imagepipeline.g.b> jGV;
    private final boolean jGW;
    private final com.facebook.cache.disk.b jGX;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c jGY;
    private final i jGZ;
    private final com.facebook.common.internal.i<Boolean> jGz;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cuf;
        this.jGZ = aVar.jHc.cxL();
        this.jGI = aVar.jGI;
        this.jGJ = aVar.jGJ == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.jGJ;
        this.FI = aVar.FI == null ? Bitmap.Config.ARGB_8888 : aVar.FI;
        if (aVar.jFS == null) {
            fVar = com.facebook.imagepipeline.c.j.cwv();
        } else {
            fVar = aVar.jFS;
        }
        this.jFS = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.jGL = aVar.jGL == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.jGL;
        this.jGK = aVar.jGK;
        this.jGM = aVar.jGM == null ? new com.facebook.imagepipeline.c.k() : aVar.jGM;
        if (aVar.jFe == null) {
            oVar = x.cwF();
        } else {
            oVar = aVar.jFe;
        }
        this.jFe = oVar;
        this.jGO = aVar.jGO;
        this.jGz = aVar.jGz == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cxz */
            public Boolean get() {
                return true;
            }
        } : aVar.jGz;
        this.jGP = aVar.jGP == null ? eM(aVar.mContext) : aVar.jGP;
        if (aVar.jGQ == null) {
            cVar = com.facebook.common.memory.d.ctH();
        } else {
            cVar = aVar.jGQ;
        }
        this.jGQ = cVar;
        this.jGR = aVar.jGR == null ? new t() : aVar.jGR;
        this.jGS = aVar.jGS;
        if (aVar.jGT == null) {
            qVar = new q(p.czp().czq());
        } else {
            qVar = aVar.jGT;
        }
        this.jGT = qVar;
        this.jGU = aVar.jGU == null ? new com.facebook.imagepipeline.decoder.f() : aVar.jGU;
        this.jGV = aVar.jGV == null ? new HashSet<>() : aVar.jGV;
        this.jGW = aVar.jGW;
        this.jGX = aVar.jGX == null ? this.jGP : aVar.jGX;
        this.jGY = aVar.jGY;
        this.jGN = aVar.jGN == null ? new com.facebook.imagepipeline.d.a(this.jGT.czt()) : aVar.jGN;
        com.facebook.common.g.b cxK = this.jGZ.cxK();
        if (cxK != null) {
            a(cxK, this.jGZ, new com.facebook.imagepipeline.b.d(cxs()));
        } else if (this.jGZ.cxH() && com.facebook.common.g.c.jAk && (cuf = com.facebook.common.g.c.cuf()) != null) {
            a(cuf, this.jGZ, new com.facebook.imagepipeline.b.d(cxs()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.jAn = bVar;
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
        return this.jGJ;
    }

    public com.facebook.imagepipeline.c.f cxf() {
        return this.jFS;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cxh() {
        return jHa;
    }

    public f cxi() {
        return this.jGL;
    }

    public boolean cxj() {
        return this.jGK;
    }

    public com.facebook.common.internal.i<u> cxk() {
        return this.jGM;
    }

    public e cxl() {
        return this.jGN;
    }

    public o cxm() {
        return this.jFe;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cxn() {
        return this.jGO;
    }

    public com.facebook.common.internal.i<Boolean> cxo() {
        return this.jGz;
    }

    public com.facebook.cache.disk.b cxp() {
        return this.jGP;
    }

    public com.facebook.common.memory.c cxq() {
        return this.jGQ;
    }

    public af cxr() {
        return this.jGR;
    }

    public q cxs() {
        return this.jGT;
    }

    public com.facebook.imagepipeline.decoder.d cxt() {
        return this.jGU;
    }

    public Set<com.facebook.imagepipeline.g.b> cxu() {
        return Collections.unmodifiableSet(this.jGV);
    }

    public boolean cxv() {
        return this.jGW;
    }

    public com.facebook.cache.disk.b cxw() {
        return this.jGX;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cxx() {
        return this.jGY;
    }

    public i cxy() {
        return this.jGZ;
    }

    public static a eN(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean jHd;

        private b() {
            this.jHd = false;
        }

        public boolean cxB() {
            return this.jHd;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FI;
        private com.facebook.imagepipeline.c.f jFS;
        private o jFe;
        private com.facebook.imagepipeline.a.a.d jGI;
        private com.facebook.common.internal.i<u> jGJ;
        private boolean jGK;
        private f jGL;
        private com.facebook.common.internal.i<u> jGM;
        private e jGN;
        private com.facebook.imagepipeline.decoder.b jGO;
        private com.facebook.cache.disk.b jGP;
        private com.facebook.common.memory.c jGQ;
        private af jGR;
        private com.facebook.imagepipeline.b.f jGS;
        private q jGT;
        private com.facebook.imagepipeline.decoder.d jGU;
        private Set<com.facebook.imagepipeline.g.b> jGV;
        private boolean jGW;
        private com.facebook.cache.disk.b jGX;
        private com.facebook.imagepipeline.decoder.c jGY;
        private com.facebook.common.internal.i<Boolean> jGz;
        private final i.a jHc;
        private final Context mContext;

        private a(Context context) {
            this.jGK = false;
            this.jGW = true;
            this.jHc = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cxA() {
            return new h(this);
        }
    }
}
