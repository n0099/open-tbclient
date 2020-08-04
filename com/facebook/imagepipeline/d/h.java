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
/* loaded from: classes4.dex */
public class h {
    private static b nbt = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> mSy;
    private final e mXK;
    @Nullable
    private final com.facebook.imagepipeline.b.f mXb;
    private final n mZF;
    private final com.facebook.common.internal.j<Boolean> naP;
    private final com.facebook.imagepipeline.c.f naU;
    private final com.facebook.common.internal.j<q> nbc;
    private final h.a nbd;
    private final boolean nbe;
    private final f nbf;
    private final com.facebook.common.internal.j<q> nbg;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b nbh;
    private final com.facebook.cache.disk.b nbi;
    private final com.facebook.common.memory.c nbj;
    private final af nbk;
    private final int nbl;
    private final com.facebook.imagepipeline.memory.q nbm;
    private final com.facebook.imagepipeline.decoder.d nbn;
    private final boolean nbo;
    private final com.facebook.cache.disk.b nbp;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c nbq;
    private final i nbr;
    private final boolean nbs;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dCU;
        this.nbr = aVar.nbw.dHo();
        this.nbc = aVar.nbc == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.nbc;
        this.nbd = aVar.nbd == null ? new com.facebook.imagepipeline.c.d() : aVar.nbd;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.naU == null) {
            fVar = com.facebook.imagepipeline.c.j.dFT();
        } else {
            fVar = aVar.naU;
        }
        this.naU = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.nbf = aVar.nbf == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.nbf;
        this.nbe = aVar.nbe;
        this.nbg = aVar.nbg == null ? new com.facebook.imagepipeline.c.k() : aVar.nbg;
        if (aVar.mZF == null) {
            nVar = t.dGc();
        } else {
            nVar = aVar.mZF;
        }
        this.mZF = nVar;
        this.nbh = aVar.nbh;
        this.naP = aVar.naP == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dCA */
            public Boolean get() {
                return true;
            }
        } : aVar.naP;
        this.nbi = aVar.nbi == null ? ga(aVar.mContext) : aVar.nbi;
        if (aVar.nbj == null) {
            cVar = com.facebook.common.memory.d.dCC();
        } else {
            cVar = aVar.nbj;
        }
        this.nbj = cVar;
        this.nbl = aVar.nbv < 0 ? 30000 : aVar.nbv;
        this.nbk = aVar.nbk == null ? new u(this.nbl) : aVar.nbk;
        this.mXb = aVar.mXb;
        if (aVar.nbm == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dJd().dJe());
        } else {
            qVar = aVar.nbm;
        }
        this.nbm = qVar;
        this.nbn = aVar.nbn == null ? new com.facebook.imagepipeline.decoder.f() : aVar.nbn;
        this.mSy = aVar.mSy == null ? new HashSet<>() : aVar.mSy;
        this.nbo = aVar.nbo;
        this.nbp = aVar.nbp == null ? this.nbi : aVar.nbp;
        this.nbq = aVar.nbq;
        this.mXK = aVar.mXK == null ? new com.facebook.imagepipeline.d.a(this.nbm.dJh()) : aVar.mXK;
        this.nbs = aVar.nbs;
        com.facebook.common.g.b dHg = this.nbr.dHg();
        if (dHg != null) {
            a(dHg, this.nbr, new com.facebook.imagepipeline.b.d(dGT()));
        } else if (this.nbr.dHd() && com.facebook.common.g.c.mRD && (dCU = com.facebook.common.g.c.dCU()) != null) {
            a(dCU, this.nbr, new com.facebook.imagepipeline.b.d(dGT()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.mRG = bVar;
        b.a dHf = iVar.dHf();
        if (dHf != null) {
            bVar.a(dHf);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b ga(Context context) {
        return com.facebook.cache.disk.b.fW(context).dCe();
    }

    public Bitmap.Config dGo() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dGF() {
        return this.nbc;
    }

    public h.a dGG() {
        return this.nbd;
    }

    public com.facebook.imagepipeline.c.f dGE() {
        return this.naU;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dGH() {
        return nbt;
    }

    public f dGI() {
        return this.nbf;
    }

    public boolean dGJ() {
        return this.nbe;
    }

    public boolean dGK() {
        return this.nbs;
    }

    public com.facebook.common.internal.j<q> dGL() {
        return this.nbg;
    }

    public e dGM() {
        return this.mXK;
    }

    public n dGN() {
        return this.mZF;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dGO() {
        return this.nbh;
    }

    public com.facebook.common.internal.j<Boolean> dGP() {
        return this.naP;
    }

    public com.facebook.cache.disk.b dGQ() {
        return this.nbi;
    }

    public com.facebook.common.memory.c dGR() {
        return this.nbj;
    }

    public af dGS() {
        return this.nbk;
    }

    public com.facebook.imagepipeline.memory.q dGT() {
        return this.nbm;
    }

    public com.facebook.imagepipeline.decoder.d dGU() {
        return this.nbn;
    }

    public Set<com.facebook.imagepipeline.h.c> dGV() {
        return Collections.unmodifiableSet(this.mSy);
    }

    public boolean dGW() {
        return this.nbo;
    }

    public com.facebook.cache.disk.b dGX() {
        return this.nbp;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dGY() {
        return this.nbq;
    }

    public i dGZ() {
        return this.nbr;
    }

    public static a gb(Context context) {
        return new a(context);
    }

    /* loaded from: classes4.dex */
    public static class b {
        private boolean nbx;

        private b() {
            this.nbx = false;
        }

        public boolean dHb() {
            return this.nbx;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> mSy;
        private e mXK;
        private com.facebook.imagepipeline.b.f mXb;
        private n mZF;
        private com.facebook.common.internal.j<Boolean> naP;
        private com.facebook.imagepipeline.c.f naU;
        private com.facebook.common.internal.j<q> nbc;
        private h.a nbd;
        private boolean nbe;
        private f nbf;
        private com.facebook.common.internal.j<q> nbg;
        private com.facebook.imagepipeline.decoder.b nbh;
        private com.facebook.cache.disk.b nbi;
        private com.facebook.common.memory.c nbj;
        private af nbk;
        private com.facebook.imagepipeline.memory.q nbm;
        private com.facebook.imagepipeline.decoder.d nbn;
        private boolean nbo;
        private com.facebook.cache.disk.b nbp;
        private com.facebook.imagepipeline.decoder.c nbq;
        private boolean nbs;
        private int nbv;
        private final i.a nbw;

        private a(Context context) {
            this.nbe = false;
            this.nbo = true;
            this.nbv = -1;
            this.nbw = new i.a(this);
            this.nbs = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a xk(boolean z) {
            this.nbe = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.nbj = cVar;
            return this;
        }

        public a a(af afVar) {
            this.nbk = afVar;
            return this;
        }

        public a xl(boolean z) {
            this.nbo = z;
            return this;
        }

        public h dHa() {
            return new h(this);
        }
    }
}
