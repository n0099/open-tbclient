package com.facebook.imagepipeline.d;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.n;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.c.t;
import com.facebook.imagepipeline.d.i;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.u;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class h {
    private static b lNZ = new b();
    private final Set<com.facebook.imagepipeline.h.c> lFM;
    @Nullable
    private final com.facebook.imagepipeline.b.f lJL;
    private final e lKu;
    private final n lMm;
    private final com.facebook.imagepipeline.c.f lNA;
    private final com.facebook.common.internal.j<q> lNI;
    private final h.a lNJ;
    private final boolean lNK;
    private final f lNL;
    private final com.facebook.common.internal.j<q> lNM;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b lNN;
    private final com.facebook.cache.disk.b lNO;
    private final com.facebook.common.memory.c lNP;
    private final af lNQ;
    private final int lNR;
    private final com.facebook.imagepipeline.memory.q lNS;
    private final com.facebook.imagepipeline.decoder.d lNT;
    private final boolean lNU;
    private final com.facebook.cache.disk.b lNV;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c lNW;
    private final i lNX;
    private final boolean lNY;
    private final com.facebook.common.internal.j<Boolean> lNv;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b diM;
        this.lNX = aVar.lOc.dmY();
        this.lNI = aVar.lNI == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.lNI;
        this.lNJ = aVar.lNJ == null ? new com.facebook.imagepipeline.c.d() : aVar.lNJ;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.lNA == null) {
            fVar = com.facebook.imagepipeline.c.j.dlD();
        } else {
            fVar = aVar.lNA;
        }
        this.lNA = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.lNL = aVar.lNL == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.lNL;
        this.lNK = aVar.lNK;
        this.lNM = aVar.lNM == null ? new com.facebook.imagepipeline.c.k() : aVar.lNM;
        if (aVar.lMm == null) {
            nVar = t.dlM();
        } else {
            nVar = aVar.lMm;
        }
        this.lMm = nVar;
        this.lNN = aVar.lNN;
        this.lNv = aVar.lNv == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dis */
            public Boolean get() {
                return true;
            }
        } : aVar.lNv;
        this.lNO = aVar.lNO == null ? go(aVar.mContext) : aVar.lNO;
        if (aVar.lNP == null) {
            cVar = com.facebook.common.memory.d.diu();
        } else {
            cVar = aVar.lNP;
        }
        this.lNP = cVar;
        this.lNR = aVar.lOb < 0 ? 30000 : aVar.lOb;
        this.lNQ = aVar.lNQ == null ? new u(this.lNR) : aVar.lNQ;
        this.lJL = aVar.lJL;
        if (aVar.lNS == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.doM().doN());
        } else {
            qVar = aVar.lNS;
        }
        this.lNS = qVar;
        this.lNT = aVar.lNT == null ? new com.facebook.imagepipeline.decoder.f() : aVar.lNT;
        this.lFM = aVar.lFM == null ? new HashSet<>() : aVar.lFM;
        this.lNU = aVar.lNU;
        this.lNV = aVar.lNV == null ? this.lNO : aVar.lNV;
        this.lNW = aVar.lNW;
        this.lKu = aVar.lKu == null ? new com.facebook.imagepipeline.d.a(this.lNS.doQ()) : aVar.lKu;
        this.lNY = aVar.lNY;
        com.facebook.common.g.b dmQ = this.lNX.dmQ();
        if (dmQ != null) {
            a(dmQ, this.lNX, new com.facebook.imagepipeline.b.d(dmD()));
        } else if (this.lNX.dmN() && com.facebook.common.g.c.lES && (diM = com.facebook.common.g.c.diM()) != null) {
            a(diM, this.lNX, new com.facebook.imagepipeline.b.d(dmD()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.lEU = bVar;
        b.a dmP = iVar.dmP();
        if (dmP != null) {
            bVar.a(dmP);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b go(Context context) {
        return com.facebook.cache.disk.b.gj(context).dhW();
    }

    public Bitmap.Config dlY() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dmp() {
        return this.lNI;
    }

    public h.a dmq() {
        return this.lNJ;
    }

    public com.facebook.imagepipeline.c.f dmo() {
        return this.lNA;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dmr() {
        return lNZ;
    }

    public f dms() {
        return this.lNL;
    }

    public boolean dmt() {
        return this.lNK;
    }

    public boolean dmu() {
        return this.lNY;
    }

    public com.facebook.common.internal.j<q> dmv() {
        return this.lNM;
    }

    public e dmw() {
        return this.lKu;
    }

    public n dmx() {
        return this.lMm;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dmy() {
        return this.lNN;
    }

    public com.facebook.common.internal.j<Boolean> dmz() {
        return this.lNv;
    }

    public com.facebook.cache.disk.b dmA() {
        return this.lNO;
    }

    public com.facebook.common.memory.c dmB() {
        return this.lNP;
    }

    public af dmC() {
        return this.lNQ;
    }

    public com.facebook.imagepipeline.memory.q dmD() {
        return this.lNS;
    }

    public com.facebook.imagepipeline.decoder.d dmE() {
        return this.lNT;
    }

    public Set<com.facebook.imagepipeline.h.c> dmF() {
        return Collections.unmodifiableSet(this.lFM);
    }

    public boolean dmG() {
        return this.lNU;
    }

    public com.facebook.cache.disk.b dmH() {
        return this.lNV;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dmI() {
        return this.lNW;
    }

    public i dmJ() {
        return this.lNX;
    }

    public static a gn(Context context) {
        return new a(context);
    }

    /* loaded from: classes9.dex */
    public static class b {
        private boolean lOd;

        private b() {
            this.lOd = false;
        }

        public boolean dmL() {
            return this.lOd;
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        private Set<com.facebook.imagepipeline.h.c> lFM;
        private com.facebook.imagepipeline.b.f lJL;
        private e lKu;
        private n lMm;
        private com.facebook.imagepipeline.c.f lNA;
        private com.facebook.common.internal.j<q> lNI;
        private h.a lNJ;
        private boolean lNK;
        private f lNL;
        private com.facebook.common.internal.j<q> lNM;
        private com.facebook.imagepipeline.decoder.b lNN;
        private com.facebook.cache.disk.b lNO;
        private com.facebook.common.memory.c lNP;
        private af lNQ;
        private com.facebook.imagepipeline.memory.q lNS;
        private com.facebook.imagepipeline.decoder.d lNT;
        private boolean lNU;
        private com.facebook.cache.disk.b lNV;
        private com.facebook.imagepipeline.decoder.c lNW;
        private boolean lNY;
        private com.facebook.common.internal.j<Boolean> lNv;
        private int lOb;
        private final i.a lOc;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;

        private a(Context context) {
            this.lNK = false;
            this.lNU = true;
            this.lOb = -1;
            this.lOc = new i.a(this);
            this.lNY = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a c(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a b(com.facebook.common.internal.j<q> jVar) {
            this.lNI = (com.facebook.common.internal.j) com.facebook.common.internal.g.checkNotNull(jVar);
            return this;
        }

        public a uZ(boolean z) {
            this.lNK = z;
            return this;
        }

        public a c(com.facebook.cache.disk.b bVar) {
            this.lNO = bVar;
            return this;
        }

        public a a(af afVar) {
            this.lNQ = afVar;
            return this;
        }

        public a va(boolean z) {
            this.lNU = z;
            return this;
        }

        public h dmK() {
            return new h(this);
        }
    }
}
