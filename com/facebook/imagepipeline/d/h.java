package com.facebook.imagepipeline.d;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.n;
import com.facebook.imagepipeline.c.t;
import com.facebook.imagepipeline.d.i;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.u;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class h {
    private static b lSK = new b();
    private final Set<com.facebook.imagepipeline.h.c> lKj;
    @Nullable
    private final com.facebook.imagepipeline.b.f lOv;
    private final e lPe;
    private final n lQX;
    private final com.facebook.common.memory.c lSA;
    private final af lSB;
    private final int lSC;
    private final q lSD;
    private final com.facebook.imagepipeline.decoder.d lSE;
    private final boolean lSF;
    private final com.facebook.cache.disk.b lSG;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c lSH;
    private final i lSI;
    private final boolean lSJ;
    private final com.facebook.common.internal.j<Boolean> lSg;
    private final com.facebook.imagepipeline.c.f lSl;
    private final com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> lSt;
    private final h.a lSu;
    private final boolean lSv;
    private final f lSw;
    private final com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> lSx;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b lSy;
    private final com.facebook.cache.disk.b lSz;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b dlf;
        this.lSI = aVar.lSN.dpw();
        this.lSt = aVar.lSt == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.lSt;
        this.lSu = aVar.lSu == null ? new com.facebook.imagepipeline.c.d() : aVar.lSu;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.lSl == null) {
            fVar = com.facebook.imagepipeline.c.j.doa();
        } else {
            fVar = aVar.lSl;
        }
        this.lSl = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.lSw = aVar.lSw == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.lSw;
        this.lSv = aVar.lSv;
        this.lSx = aVar.lSx == null ? new com.facebook.imagepipeline.c.k() : aVar.lSx;
        if (aVar.lQX == null) {
            nVar = t.doj();
        } else {
            nVar = aVar.lQX;
        }
        this.lQX = nVar;
        this.lSy = aVar.lSy;
        this.lSg = aVar.lSg == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dkL */
            public Boolean get() {
                return true;
            }
        } : aVar.lSg;
        this.lSz = aVar.lSz == null ? go(aVar.mContext) : aVar.lSz;
        if (aVar.lSA == null) {
            cVar = com.facebook.common.memory.d.dkN();
        } else {
            cVar = aVar.lSA;
        }
        this.lSA = cVar;
        this.lSC = aVar.lSM < 0 ? 30000 : aVar.lSM;
        this.lSB = aVar.lSB == null ? new u(this.lSC) : aVar.lSB;
        this.lOv = aVar.lOv;
        if (aVar.lSD == null) {
            qVar = new q(p.drm().drn());
        } else {
            qVar = aVar.lSD;
        }
        this.lSD = qVar;
        this.lSE = aVar.lSE == null ? new com.facebook.imagepipeline.decoder.f() : aVar.lSE;
        this.lKj = aVar.lKj == null ? new HashSet<>() : aVar.lKj;
        this.lSF = aVar.lSF;
        this.lSG = aVar.lSG == null ? this.lSz : aVar.lSG;
        this.lSH = aVar.lSH;
        this.lPe = aVar.lPe == null ? new com.facebook.imagepipeline.d.a(this.lSD.drq()) : aVar.lPe;
        this.lSJ = aVar.lSJ;
        com.facebook.common.g.b dpo = this.lSI.dpo();
        if (dpo != null) {
            a(dpo, this.lSI, new com.facebook.imagepipeline.b.d(dpb()));
        } else if (this.lSI.dpl() && com.facebook.common.g.c.lJp && (dlf = com.facebook.common.g.c.dlf()) != null) {
            a(dlf, this.lSI, new com.facebook.imagepipeline.b.d(dpb()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.lJr = bVar;
        b.a dpn = iVar.dpn();
        if (dpn != null) {
            bVar.a(dpn);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b go(Context context) {
        return com.facebook.cache.disk.b.gj(context).dkp();
    }

    public Bitmap.Config dov() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> doN() {
        return this.lSt;
    }

    public h.a doO() {
        return this.lSu;
    }

    public com.facebook.imagepipeline.c.f doM() {
        return this.lSl;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b doP() {
        return lSK;
    }

    public f doQ() {
        return this.lSw;
    }

    public boolean doR() {
        return this.lSv;
    }

    public boolean doS() {
        return this.lSJ;
    }

    public com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> doT() {
        return this.lSx;
    }

    public e doU() {
        return this.lPe;
    }

    public n doV() {
        return this.lQX;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b doW() {
        return this.lSy;
    }

    public com.facebook.common.internal.j<Boolean> doX() {
        return this.lSg;
    }

    public com.facebook.cache.disk.b doY() {
        return this.lSz;
    }

    public com.facebook.common.memory.c doZ() {
        return this.lSA;
    }

    public af dpa() {
        return this.lSB;
    }

    public q dpb() {
        return this.lSD;
    }

    public com.facebook.imagepipeline.decoder.d dpc() {
        return this.lSE;
    }

    public Set<com.facebook.imagepipeline.h.c> dpd() {
        return Collections.unmodifiableSet(this.lKj);
    }

    public boolean dpe() {
        return this.lSF;
    }

    public com.facebook.cache.disk.b dpf() {
        return this.lSG;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dpg() {
        return this.lSH;
    }

    public i dph() {
        return this.lSI;
    }

    public static a gn(Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class b {
        private boolean lSO;

        private b() {
            this.lSO = false;
        }

        public boolean dpj() {
            return this.lSO;
        }
    }

    /* loaded from: classes12.dex */
    public static class a {
        private Set<com.facebook.imagepipeline.h.c> lKj;
        private com.facebook.imagepipeline.b.f lOv;
        private e lPe;
        private n lQX;
        private com.facebook.common.memory.c lSA;
        private af lSB;
        private q lSD;
        private com.facebook.imagepipeline.decoder.d lSE;
        private boolean lSF;
        private com.facebook.cache.disk.b lSG;
        private com.facebook.imagepipeline.decoder.c lSH;
        private boolean lSJ;
        private int lSM;
        private final i.a lSN;
        private com.facebook.common.internal.j<Boolean> lSg;
        private com.facebook.imagepipeline.c.f lSl;
        private com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> lSt;
        private h.a lSu;
        private boolean lSv;
        private f lSw;
        private com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> lSx;
        private com.facebook.imagepipeline.decoder.b lSy;
        private com.facebook.cache.disk.b lSz;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;

        private a(Context context) {
            this.lSv = false;
            this.lSF = true;
            this.lSM = -1;
            this.lSN = new i.a(this);
            this.lSJ = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a c(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a b(com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> jVar) {
            this.lSt = (com.facebook.common.internal.j) com.facebook.common.internal.g.checkNotNull(jVar);
            return this;
        }

        public a vp(boolean z) {
            this.lSv = z;
            return this;
        }

        public a c(com.facebook.cache.disk.b bVar) {
            this.lSz = bVar;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.lSA = cVar;
            return this;
        }

        public a a(af afVar) {
            this.lSB = afVar;
            return this;
        }

        public a vq(boolean z) {
            this.lSF = z;
            return this;
        }

        public h dpi() {
            return new h(this);
        }
    }
}
