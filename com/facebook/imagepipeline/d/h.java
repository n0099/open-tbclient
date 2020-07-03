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
    private static b mTl = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> mKp;
    @Nullable
    private final com.facebook.imagepipeline.b.f mOM;
    private final e mPx;
    private final n mRt;
    private final com.facebook.common.internal.j<Boolean> mSF;
    private final com.facebook.imagepipeline.c.f mSK;
    private final com.facebook.common.internal.j<q> mST;
    private final h.a mSU;
    private final boolean mSV;
    private final f mSW;
    private final com.facebook.common.internal.j<q> mSX;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b mSY;
    private final com.facebook.cache.disk.b mSZ;
    private final com.facebook.common.memory.c mTa;
    private final af mTb;
    private final int mTc;
    private final com.facebook.imagepipeline.memory.q mTd;
    private final com.facebook.imagepipeline.decoder.d mTe;
    private final boolean mTf;
    private final com.facebook.cache.disk.b mTg;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c mTh;
    private final i mTi;
    private final boolean mTk;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dzD;
        this.mTi = aVar.mTp.dDX();
        this.mST = aVar.mST == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.mST;
        this.mSU = aVar.mSU == null ? new com.facebook.imagepipeline.c.d() : aVar.mSU;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.mSK == null) {
            fVar = com.facebook.imagepipeline.c.j.dCC();
        } else {
            fVar = aVar.mSK;
        }
        this.mSK = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.mSW = aVar.mSW == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.mSW;
        this.mSV = aVar.mSV;
        this.mSX = aVar.mSX == null ? new com.facebook.imagepipeline.c.k() : aVar.mSX;
        if (aVar.mRt == null) {
            nVar = t.dCL();
        } else {
            nVar = aVar.mRt;
        }
        this.mRt = nVar;
        this.mSY = aVar.mSY;
        this.mSF = aVar.mSF == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dzj */
            public Boolean get() {
                return true;
            }
        } : aVar.mSF;
        this.mSZ = aVar.mSZ == null ? fX(aVar.mContext) : aVar.mSZ;
        if (aVar.mTa == null) {
            cVar = com.facebook.common.memory.d.dzl();
        } else {
            cVar = aVar.mTa;
        }
        this.mTa = cVar;
        this.mTc = aVar.mTn < 0 ? 30000 : aVar.mTn;
        this.mTb = aVar.mTb == null ? new u(this.mTc) : aVar.mTb;
        this.mOM = aVar.mOM;
        if (aVar.mTd == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dFM().dFN());
        } else {
            qVar = aVar.mTd;
        }
        this.mTd = qVar;
        this.mTe = aVar.mTe == null ? new com.facebook.imagepipeline.decoder.f() : aVar.mTe;
        this.mKp = aVar.mKp == null ? new HashSet<>() : aVar.mKp;
        this.mTf = aVar.mTf;
        this.mTg = aVar.mTg == null ? this.mSZ : aVar.mTg;
        this.mTh = aVar.mTh;
        this.mPx = aVar.mPx == null ? new com.facebook.imagepipeline.d.a(this.mTd.dFQ()) : aVar.mPx;
        this.mTk = aVar.mTk;
        com.facebook.common.g.b dDP = this.mTi.dDP();
        if (dDP != null) {
            a(dDP, this.mTi, new com.facebook.imagepipeline.b.d(dDC()));
        } else if (this.mTi.dDM() && com.facebook.common.g.c.mJv && (dzD = com.facebook.common.g.c.dzD()) != null) {
            a(dzD, this.mTi, new com.facebook.imagepipeline.b.d(dDC()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.mJy = bVar;
        b.a dDO = iVar.dDO();
        if (dDO != null) {
            bVar.a(dDO);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b fX(Context context) {
        return com.facebook.cache.disk.b.fT(context).dyN();
    }

    public Bitmap.Config dCX() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dDo() {
        return this.mST;
    }

    public h.a dDp() {
        return this.mSU;
    }

    public com.facebook.imagepipeline.c.f dDn() {
        return this.mSK;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dDq() {
        return mTl;
    }

    public f dDr() {
        return this.mSW;
    }

    public boolean dDs() {
        return this.mSV;
    }

    public boolean dDt() {
        return this.mTk;
    }

    public com.facebook.common.internal.j<q> dDu() {
        return this.mSX;
    }

    public e dDv() {
        return this.mPx;
    }

    public n dDw() {
        return this.mRt;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dDx() {
        return this.mSY;
    }

    public com.facebook.common.internal.j<Boolean> dDy() {
        return this.mSF;
    }

    public com.facebook.cache.disk.b dDz() {
        return this.mSZ;
    }

    public com.facebook.common.memory.c dDA() {
        return this.mTa;
    }

    public af dDB() {
        return this.mTb;
    }

    public com.facebook.imagepipeline.memory.q dDC() {
        return this.mTd;
    }

    public com.facebook.imagepipeline.decoder.d dDD() {
        return this.mTe;
    }

    public Set<com.facebook.imagepipeline.h.c> dDE() {
        return Collections.unmodifiableSet(this.mKp);
    }

    public boolean dDF() {
        return this.mTf;
    }

    public com.facebook.cache.disk.b dDG() {
        return this.mTg;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dDH() {
        return this.mTh;
    }

    public i dDI() {
        return this.mTi;
    }

    public static a fY(Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class b {
        private boolean mTq;

        private b() {
            this.mTq = false;
        }

        public boolean dDK() {
            return this.mTq;
        }
    }

    /* loaded from: classes12.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> mKp;
        private com.facebook.imagepipeline.b.f mOM;
        private e mPx;
        private n mRt;
        private com.facebook.common.internal.j<Boolean> mSF;
        private com.facebook.imagepipeline.c.f mSK;
        private com.facebook.common.internal.j<q> mST;
        private h.a mSU;
        private boolean mSV;
        private f mSW;
        private com.facebook.common.internal.j<q> mSX;
        private com.facebook.imagepipeline.decoder.b mSY;
        private com.facebook.cache.disk.b mSZ;
        private com.facebook.common.memory.c mTa;
        private af mTb;
        private com.facebook.imagepipeline.memory.q mTd;
        private com.facebook.imagepipeline.decoder.d mTe;
        private boolean mTf;
        private com.facebook.cache.disk.b mTg;
        private com.facebook.imagepipeline.decoder.c mTh;
        private boolean mTk;
        private int mTn;
        private final i.a mTp;

        private a(Context context) {
            this.mSV = false;
            this.mTf = true;
            this.mTn = -1;
            this.mTp = new i.a(this);
            this.mTk = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a wF(boolean z) {
            this.mSV = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.mTa = cVar;
            return this;
        }

        public a a(af afVar) {
            this.mTb = afVar;
            return this;
        }

        public a wG(boolean z) {
            this.mTf = z;
            return this;
        }

        public h dDJ() {
            return new h(this);
        }
    }
}
