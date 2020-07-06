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
/* loaded from: classes12.dex */
public class h {
    private static b mTp = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> mKs;
    @Nullable
    private final com.facebook.imagepipeline.b.f mOP;
    private final e mPA;
    private final n mRw;
    private final com.facebook.common.internal.j<Boolean> mSI;
    private final com.facebook.imagepipeline.c.f mSN;
    private final com.facebook.common.internal.j<q> mSW;
    private final h.a mSX;
    private final boolean mSY;
    private final f mSZ;
    private final com.facebook.common.internal.j<q> mTa;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b mTb;
    private final com.facebook.cache.disk.b mTc;
    private final com.facebook.common.memory.c mTd;
    private final af mTe;
    private final int mTf;
    private final com.facebook.imagepipeline.memory.q mTg;
    private final com.facebook.imagepipeline.decoder.d mTh;
    private final boolean mTi;
    private final com.facebook.cache.disk.b mTk;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c mTl;
    private final i mTm;
    private final boolean mTn;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dzH;
        this.mTm = aVar.mTs.dEb();
        this.mSW = aVar.mSW == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.mSW;
        this.mSX = aVar.mSX == null ? new com.facebook.imagepipeline.c.d() : aVar.mSX;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.mSN == null) {
            fVar = com.facebook.imagepipeline.c.j.dCG();
        } else {
            fVar = aVar.mSN;
        }
        this.mSN = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.mSZ = aVar.mSZ == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.mSZ;
        this.mSY = aVar.mSY;
        this.mTa = aVar.mTa == null ? new com.facebook.imagepipeline.c.k() : aVar.mTa;
        if (aVar.mRw == null) {
            nVar = t.dCP();
        } else {
            nVar = aVar.mRw;
        }
        this.mRw = nVar;
        this.mTb = aVar.mTb;
        this.mSI = aVar.mSI == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dzn */
            public Boolean get() {
                return true;
            }
        } : aVar.mSI;
        this.mTc = aVar.mTc == null ? fX(aVar.mContext) : aVar.mTc;
        if (aVar.mTd == null) {
            cVar = com.facebook.common.memory.d.dzp();
        } else {
            cVar = aVar.mTd;
        }
        this.mTd = cVar;
        this.mTf = aVar.mTr < 0 ? 30000 : aVar.mTr;
        this.mTe = aVar.mTe == null ? new u(this.mTf) : aVar.mTe;
        this.mOP = aVar.mOP;
        if (aVar.mTg == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dFQ().dFR());
        } else {
            qVar = aVar.mTg;
        }
        this.mTg = qVar;
        this.mTh = aVar.mTh == null ? new com.facebook.imagepipeline.decoder.f() : aVar.mTh;
        this.mKs = aVar.mKs == null ? new HashSet<>() : aVar.mKs;
        this.mTi = aVar.mTi;
        this.mTk = aVar.mTk == null ? this.mTc : aVar.mTk;
        this.mTl = aVar.mTl;
        this.mPA = aVar.mPA == null ? new com.facebook.imagepipeline.d.a(this.mTg.dFU()) : aVar.mPA;
        this.mTn = aVar.mTn;
        com.facebook.common.g.b dDT = this.mTm.dDT();
        if (dDT != null) {
            a(dDT, this.mTm, new com.facebook.imagepipeline.b.d(dDG()));
        } else if (this.mTm.dDQ() && com.facebook.common.g.c.mJy && (dzH = com.facebook.common.g.c.dzH()) != null) {
            a(dzH, this.mTm, new com.facebook.imagepipeline.b.d(dDG()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.mJB = bVar;
        b.a dDS = iVar.dDS();
        if (dDS != null) {
            bVar.a(dDS);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b fX(Context context) {
        return com.facebook.cache.disk.b.fT(context).dyR();
    }

    public Bitmap.Config dDb() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dDs() {
        return this.mSW;
    }

    public h.a dDt() {
        return this.mSX;
    }

    public com.facebook.imagepipeline.c.f dDr() {
        return this.mSN;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dDu() {
        return mTp;
    }

    public f dDv() {
        return this.mSZ;
    }

    public boolean dDw() {
        return this.mSY;
    }

    public boolean dDx() {
        return this.mTn;
    }

    public com.facebook.common.internal.j<q> dDy() {
        return this.mTa;
    }

    public e dDz() {
        return this.mPA;
    }

    public n dDA() {
        return this.mRw;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dDB() {
        return this.mTb;
    }

    public com.facebook.common.internal.j<Boolean> dDC() {
        return this.mSI;
    }

    public com.facebook.cache.disk.b dDD() {
        return this.mTc;
    }

    public com.facebook.common.memory.c dDE() {
        return this.mTd;
    }

    public af dDF() {
        return this.mTe;
    }

    public com.facebook.imagepipeline.memory.q dDG() {
        return this.mTg;
    }

    public com.facebook.imagepipeline.decoder.d dDH() {
        return this.mTh;
    }

    public Set<com.facebook.imagepipeline.h.c> dDI() {
        return Collections.unmodifiableSet(this.mKs);
    }

    public boolean dDJ() {
        return this.mTi;
    }

    public com.facebook.cache.disk.b dDK() {
        return this.mTk;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dDL() {
        return this.mTl;
    }

    public i dDM() {
        return this.mTm;
    }

    public static a fY(Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class b {
        private boolean mTt;

        private b() {
            this.mTt = false;
        }

        public boolean dDO() {
            return this.mTt;
        }
    }

    /* loaded from: classes12.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> mKs;
        private com.facebook.imagepipeline.b.f mOP;
        private e mPA;
        private n mRw;
        private com.facebook.common.internal.j<Boolean> mSI;
        private com.facebook.imagepipeline.c.f mSN;
        private com.facebook.common.internal.j<q> mSW;
        private h.a mSX;
        private boolean mSY;
        private f mSZ;
        private com.facebook.common.internal.j<q> mTa;
        private com.facebook.imagepipeline.decoder.b mTb;
        private com.facebook.cache.disk.b mTc;
        private com.facebook.common.memory.c mTd;
        private af mTe;
        private com.facebook.imagepipeline.memory.q mTg;
        private com.facebook.imagepipeline.decoder.d mTh;
        private boolean mTi;
        private com.facebook.cache.disk.b mTk;
        private com.facebook.imagepipeline.decoder.c mTl;
        private boolean mTn;
        private int mTr;
        private final i.a mTs;

        private a(Context context) {
            this.mSY = false;
            this.mTi = true;
            this.mTr = -1;
            this.mTs = new i.a(this);
            this.mTn = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a wF(boolean z) {
            this.mSY = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.mTd = cVar;
            return this;
        }

        public a a(af afVar) {
            this.mTe = afVar;
            return this;
        }

        public a wG(boolean z) {
            this.mTi = z;
            return this;
        }

        public h dDN() {
            return new h(this);
        }
    }
}
