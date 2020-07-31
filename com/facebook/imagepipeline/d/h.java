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
    private static b nbr = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> mSw;
    @Nullable
    private final com.facebook.imagepipeline.b.f mWZ;
    private final e mXI;
    private final n mZD;
    private final com.facebook.common.internal.j<Boolean> naN;
    private final com.facebook.imagepipeline.c.f naS;
    private final com.facebook.common.internal.j<q> nba;
    private final h.a nbb;
    private final boolean nbc;
    private final f nbd;
    private final com.facebook.common.internal.j<q> nbe;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b nbf;
    private final com.facebook.cache.disk.b nbg;
    private final com.facebook.common.memory.c nbh;
    private final af nbi;
    private final int nbj;
    private final com.facebook.imagepipeline.memory.q nbk;
    private final com.facebook.imagepipeline.decoder.d nbl;
    private final boolean nbm;
    private final com.facebook.cache.disk.b nbn;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c nbo;
    private final i nbp;
    private final boolean nbq;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dCT;
        this.nbp = aVar.nbu.dHn();
        this.nba = aVar.nba == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.nba;
        this.nbb = aVar.nbb == null ? new com.facebook.imagepipeline.c.d() : aVar.nbb;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.naS == null) {
            fVar = com.facebook.imagepipeline.c.j.dFS();
        } else {
            fVar = aVar.naS;
        }
        this.naS = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.nbd = aVar.nbd == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.nbd;
        this.nbc = aVar.nbc;
        this.nbe = aVar.nbe == null ? new com.facebook.imagepipeline.c.k() : aVar.nbe;
        if (aVar.mZD == null) {
            nVar = t.dGb();
        } else {
            nVar = aVar.mZD;
        }
        this.mZD = nVar;
        this.nbf = aVar.nbf;
        this.naN = aVar.naN == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dCz */
            public Boolean get() {
                return true;
            }
        } : aVar.naN;
        this.nbg = aVar.nbg == null ? ga(aVar.mContext) : aVar.nbg;
        if (aVar.nbh == null) {
            cVar = com.facebook.common.memory.d.dCB();
        } else {
            cVar = aVar.nbh;
        }
        this.nbh = cVar;
        this.nbj = aVar.nbt < 0 ? 30000 : aVar.nbt;
        this.nbi = aVar.nbi == null ? new u(this.nbj) : aVar.nbi;
        this.mWZ = aVar.mWZ;
        if (aVar.nbk == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dJc().dJd());
        } else {
            qVar = aVar.nbk;
        }
        this.nbk = qVar;
        this.nbl = aVar.nbl == null ? new com.facebook.imagepipeline.decoder.f() : aVar.nbl;
        this.mSw = aVar.mSw == null ? new HashSet<>() : aVar.mSw;
        this.nbm = aVar.nbm;
        this.nbn = aVar.nbn == null ? this.nbg : aVar.nbn;
        this.nbo = aVar.nbo;
        this.mXI = aVar.mXI == null ? new com.facebook.imagepipeline.d.a(this.nbk.dJg()) : aVar.mXI;
        this.nbq = aVar.nbq;
        com.facebook.common.g.b dHf = this.nbp.dHf();
        if (dHf != null) {
            a(dHf, this.nbp, new com.facebook.imagepipeline.b.d(dGS()));
        } else if (this.nbp.dHc() && com.facebook.common.g.c.mRB && (dCT = com.facebook.common.g.c.dCT()) != null) {
            a(dCT, this.nbp, new com.facebook.imagepipeline.b.d(dGS()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.mRE = bVar;
        b.a dHe = iVar.dHe();
        if (dHe != null) {
            bVar.a(dHe);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b ga(Context context) {
        return com.facebook.cache.disk.b.fW(context).dCd();
    }

    public Bitmap.Config dGn() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dGE() {
        return this.nba;
    }

    public h.a dGF() {
        return this.nbb;
    }

    public com.facebook.imagepipeline.c.f dGD() {
        return this.naS;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dGG() {
        return nbr;
    }

    public f dGH() {
        return this.nbd;
    }

    public boolean dGI() {
        return this.nbc;
    }

    public boolean dGJ() {
        return this.nbq;
    }

    public com.facebook.common.internal.j<q> dGK() {
        return this.nbe;
    }

    public e dGL() {
        return this.mXI;
    }

    public n dGM() {
        return this.mZD;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dGN() {
        return this.nbf;
    }

    public com.facebook.common.internal.j<Boolean> dGO() {
        return this.naN;
    }

    public com.facebook.cache.disk.b dGP() {
        return this.nbg;
    }

    public com.facebook.common.memory.c dGQ() {
        return this.nbh;
    }

    public af dGR() {
        return this.nbi;
    }

    public com.facebook.imagepipeline.memory.q dGS() {
        return this.nbk;
    }

    public com.facebook.imagepipeline.decoder.d dGT() {
        return this.nbl;
    }

    public Set<com.facebook.imagepipeline.h.c> dGU() {
        return Collections.unmodifiableSet(this.mSw);
    }

    public boolean dGV() {
        return this.nbm;
    }

    public com.facebook.cache.disk.b dGW() {
        return this.nbn;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dGX() {
        return this.nbo;
    }

    public i dGY() {
        return this.nbp;
    }

    public static a gb(Context context) {
        return new a(context);
    }

    /* loaded from: classes4.dex */
    public static class b {
        private boolean nbv;

        private b() {
            this.nbv = false;
        }

        public boolean dHa() {
            return this.nbv;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> mSw;
        private com.facebook.imagepipeline.b.f mWZ;
        private e mXI;
        private n mZD;
        private com.facebook.common.internal.j<Boolean> naN;
        private com.facebook.imagepipeline.c.f naS;
        private com.facebook.common.internal.j<q> nba;
        private h.a nbb;
        private boolean nbc;
        private f nbd;
        private com.facebook.common.internal.j<q> nbe;
        private com.facebook.imagepipeline.decoder.b nbf;
        private com.facebook.cache.disk.b nbg;
        private com.facebook.common.memory.c nbh;
        private af nbi;
        private com.facebook.imagepipeline.memory.q nbk;
        private com.facebook.imagepipeline.decoder.d nbl;
        private boolean nbm;
        private com.facebook.cache.disk.b nbn;
        private com.facebook.imagepipeline.decoder.c nbo;
        private boolean nbq;
        private int nbt;
        private final i.a nbu;

        private a(Context context) {
            this.nbc = false;
            this.nbm = true;
            this.nbt = -1;
            this.nbu = new i.a(this);
            this.nbq = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a xk(boolean z) {
            this.nbc = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.nbh = cVar;
            return this;
        }

        public a a(af afVar) {
            this.nbi = afVar;
            return this;
        }

        public a xl(boolean z) {
            this.nbm = z;
            return this;
        }

        public h dGZ() {
            return new h(this);
        }
    }
}
