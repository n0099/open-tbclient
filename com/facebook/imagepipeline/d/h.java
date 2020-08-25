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
/* loaded from: classes8.dex */
public class h {
    private static b nvj = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> nmr;
    @Nullable
    private final com.facebook.imagepipeline.b.f nqQ;
    private final e nrz;
    private final n ntu;
    private final com.facebook.common.internal.j<Boolean> nuF;
    private final com.facebook.imagepipeline.c.f nuK;
    private final com.facebook.common.internal.j<q> nuS;
    private final h.a nuT;
    private final boolean nuU;
    private final f nuV;
    private final com.facebook.common.internal.j<q> nuW;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b nuX;
    private final com.facebook.cache.disk.b nuY;
    private final com.facebook.common.memory.c nuZ;
    private final af nva;
    private final int nvb;
    private final com.facebook.imagepipeline.memory.q nvc;
    private final com.facebook.imagepipeline.decoder.d nvd;
    private final boolean nve;
    private final com.facebook.cache.disk.b nvf;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c nvg;
    private final i nvh;
    private final boolean nvi;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dOU;
        this.nvh = aVar.nvm.dTn();
        this.nuS = aVar.nuS == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.nuS;
        this.nuT = aVar.nuT == null ? new com.facebook.imagepipeline.c.d() : aVar.nuT;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.nuK == null) {
            fVar = com.facebook.imagepipeline.c.j.dRS();
        } else {
            fVar = aVar.nuK;
        }
        this.nuK = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.nuV = aVar.nuV == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.nuV;
        this.nuU = aVar.nuU;
        this.nuW = aVar.nuW == null ? new com.facebook.imagepipeline.c.k() : aVar.nuW;
        if (aVar.ntu == null) {
            nVar = t.dSb();
        } else {
            nVar = aVar.ntu;
        }
        this.ntu = nVar;
        this.nuX = aVar.nuX;
        this.nuF = aVar.nuF == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dOA */
            public Boolean get() {
                return true;
            }
        } : aVar.nuF;
        this.nuY = aVar.nuY == null ? gt(aVar.mContext) : aVar.nuY;
        if (aVar.nuZ == null) {
            cVar = com.facebook.common.memory.d.dOC();
        } else {
            cVar = aVar.nuZ;
        }
        this.nuZ = cVar;
        this.nvb = aVar.nvl < 0 ? 30000 : aVar.nvl;
        this.nva = aVar.nva == null ? new u(this.nvb) : aVar.nva;
        this.nqQ = aVar.nqQ;
        if (aVar.nvc == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dVc().dVd());
        } else {
            qVar = aVar.nvc;
        }
        this.nvc = qVar;
        this.nvd = aVar.nvd == null ? new com.facebook.imagepipeline.decoder.f() : aVar.nvd;
        this.nmr = aVar.nmr == null ? new HashSet<>() : aVar.nmr;
        this.nve = aVar.nve;
        this.nvf = aVar.nvf == null ? this.nuY : aVar.nvf;
        this.nvg = aVar.nvg;
        this.nrz = aVar.nrz == null ? new com.facebook.imagepipeline.d.a(this.nvc.dVg()) : aVar.nrz;
        this.nvi = aVar.nvi;
        com.facebook.common.g.b dTf = this.nvh.dTf();
        if (dTf != null) {
            a(dTf, this.nvh, new com.facebook.imagepipeline.b.d(dSS()));
        } else if (this.nvh.dTc() && com.facebook.common.g.c.nlx && (dOU = com.facebook.common.g.c.dOU()) != null) {
            a(dOU, this.nvh, new com.facebook.imagepipeline.b.d(dSS()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.nlA = bVar;
        b.a dTe = iVar.dTe();
        if (dTe != null) {
            bVar.a(dTe);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b gt(Context context) {
        return com.facebook.cache.disk.b.gp(context).dOe();
    }

    public Bitmap.Config dSn() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dSE() {
        return this.nuS;
    }

    public h.a dSF() {
        return this.nuT;
    }

    public com.facebook.imagepipeline.c.f dSD() {
        return this.nuK;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dSG() {
        return nvj;
    }

    public f dSH() {
        return this.nuV;
    }

    public boolean dSI() {
        return this.nuU;
    }

    public boolean dSJ() {
        return this.nvi;
    }

    public com.facebook.common.internal.j<q> dSK() {
        return this.nuW;
    }

    public e dSL() {
        return this.nrz;
    }

    public n dSM() {
        return this.ntu;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dSN() {
        return this.nuX;
    }

    public com.facebook.common.internal.j<Boolean> dSO() {
        return this.nuF;
    }

    public com.facebook.cache.disk.b dSP() {
        return this.nuY;
    }

    public com.facebook.common.memory.c dSQ() {
        return this.nuZ;
    }

    public af dSR() {
        return this.nva;
    }

    public com.facebook.imagepipeline.memory.q dSS() {
        return this.nvc;
    }

    public com.facebook.imagepipeline.decoder.d dST() {
        return this.nvd;
    }

    public Set<com.facebook.imagepipeline.h.c> dSU() {
        return Collections.unmodifiableSet(this.nmr);
    }

    public boolean dSV() {
        return this.nve;
    }

    public com.facebook.cache.disk.b dSW() {
        return this.nvf;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dSX() {
        return this.nvg;
    }

    public i dSY() {
        return this.nvh;
    }

    public static a gu(Context context) {
        return new a(context);
    }

    /* loaded from: classes8.dex */
    public static class b {
        private boolean nvn;

        private b() {
            this.nvn = false;
        }

        public boolean dTa() {
            return this.nvn;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> nmr;
        private com.facebook.imagepipeline.b.f nqQ;
        private e nrz;
        private n ntu;
        private com.facebook.common.internal.j<Boolean> nuF;
        private com.facebook.imagepipeline.c.f nuK;
        private com.facebook.common.internal.j<q> nuS;
        private h.a nuT;
        private boolean nuU;
        private f nuV;
        private com.facebook.common.internal.j<q> nuW;
        private com.facebook.imagepipeline.decoder.b nuX;
        private com.facebook.cache.disk.b nuY;
        private com.facebook.common.memory.c nuZ;
        private af nva;
        private com.facebook.imagepipeline.memory.q nvc;
        private com.facebook.imagepipeline.decoder.d nvd;
        private boolean nve;
        private com.facebook.cache.disk.b nvf;
        private com.facebook.imagepipeline.decoder.c nvg;
        private boolean nvi;
        private int nvl;
        private final i.a nvm;

        private a(Context context) {
            this.nuU = false;
            this.nve = true;
            this.nvl = -1;
            this.nvm = new i.a(this);
            this.nvi = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a yb(boolean z) {
            this.nuU = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.nuZ = cVar;
            return this;
        }

        public a a(af afVar) {
            this.nva = afVar;
            return this;
        }

        public a yc(boolean z) {
            this.nve = z;
            return this;
        }

        public h dSZ() {
            return new h(this);
        }
    }
}
