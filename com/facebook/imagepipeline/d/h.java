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
    private static b lUq = new b();
    private final Set<com.facebook.imagepipeline.h.c> lLP;
    private final e lQK;
    @Nullable
    private final com.facebook.imagepipeline.b.f lQb;
    private final n lSD;
    private final com.facebook.common.internal.j<Boolean> lTM;
    private final com.facebook.imagepipeline.c.f lTR;
    private final com.facebook.common.internal.j<q> lTZ;
    private final h.a lUa;
    private final boolean lUb;
    private final f lUc;
    private final com.facebook.common.internal.j<q> lUd;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b lUe;
    private final com.facebook.cache.disk.b lUf;
    private final com.facebook.common.memory.c lUg;
    private final af lUh;
    private final int lUi;
    private final com.facebook.imagepipeline.memory.q lUj;
    private final com.facebook.imagepipeline.decoder.d lUk;
    private final boolean lUl;
    private final com.facebook.cache.disk.b lUm;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c lUn;
    private final i lUo;
    private final boolean lUp;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dlC;
        this.lUo = aVar.lUt.dpT();
        this.lTZ = aVar.lTZ == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.lTZ;
        this.lUa = aVar.lUa == null ? new com.facebook.imagepipeline.c.d() : aVar.lUa;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.lTR == null) {
            fVar = com.facebook.imagepipeline.c.j.dox();
        } else {
            fVar = aVar.lTR;
        }
        this.lTR = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.lUc = aVar.lUc == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.lUc;
        this.lUb = aVar.lUb;
        this.lUd = aVar.lUd == null ? new com.facebook.imagepipeline.c.k() : aVar.lUd;
        if (aVar.lSD == null) {
            nVar = t.doG();
        } else {
            nVar = aVar.lSD;
        }
        this.lSD = nVar;
        this.lUe = aVar.lUe;
        this.lTM = aVar.lTM == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dli */
            public Boolean get() {
                return true;
            }
        } : aVar.lTM;
        this.lUf = aVar.lUf == null ? gn(aVar.mContext) : aVar.lUf;
        if (aVar.lUg == null) {
            cVar = com.facebook.common.memory.d.dlk();
        } else {
            cVar = aVar.lUg;
        }
        this.lUg = cVar;
        this.lUi = aVar.lUs < 0 ? 30000 : aVar.lUs;
        this.lUh = aVar.lUh == null ? new u(this.lUi) : aVar.lUh;
        this.lQb = aVar.lQb;
        if (aVar.lUj == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.drJ().drK());
        } else {
            qVar = aVar.lUj;
        }
        this.lUj = qVar;
        this.lUk = aVar.lUk == null ? new com.facebook.imagepipeline.decoder.f() : aVar.lUk;
        this.lLP = aVar.lLP == null ? new HashSet<>() : aVar.lLP;
        this.lUl = aVar.lUl;
        this.lUm = aVar.lUm == null ? this.lUf : aVar.lUm;
        this.lUn = aVar.lUn;
        this.lQK = aVar.lQK == null ? new com.facebook.imagepipeline.d.a(this.lUj.drN()) : aVar.lQK;
        this.lUp = aVar.lUp;
        com.facebook.common.g.b dpL = this.lUo.dpL();
        if (dpL != null) {
            a(dpL, this.lUo, new com.facebook.imagepipeline.b.d(dpy()));
        } else if (this.lUo.dpI() && com.facebook.common.g.c.lKV && (dlC = com.facebook.common.g.c.dlC()) != null) {
            a(dlC, this.lUo, new com.facebook.imagepipeline.b.d(dpy()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.lKX = bVar;
        b.a dpK = iVar.dpK();
        if (dpK != null) {
            bVar.a(dpK);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b gn(Context context) {
        return com.facebook.cache.disk.b.gi(context).dkM();
    }

    public Bitmap.Config doS() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dpk() {
        return this.lTZ;
    }

    public h.a dpl() {
        return this.lUa;
    }

    public com.facebook.imagepipeline.c.f dpj() {
        return this.lTR;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dpm() {
        return lUq;
    }

    public f dpn() {
        return this.lUc;
    }

    public boolean dpo() {
        return this.lUb;
    }

    public boolean dpp() {
        return this.lUp;
    }

    public com.facebook.common.internal.j<q> dpq() {
        return this.lUd;
    }

    public e dpr() {
        return this.lQK;
    }

    public n dps() {
        return this.lSD;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dpt() {
        return this.lUe;
    }

    public com.facebook.common.internal.j<Boolean> dpu() {
        return this.lTM;
    }

    public com.facebook.cache.disk.b dpv() {
        return this.lUf;
    }

    public com.facebook.common.memory.c dpw() {
        return this.lUg;
    }

    public af dpx() {
        return this.lUh;
    }

    public com.facebook.imagepipeline.memory.q dpy() {
        return this.lUj;
    }

    public com.facebook.imagepipeline.decoder.d dpz() {
        return this.lUk;
    }

    public Set<com.facebook.imagepipeline.h.c> dpA() {
        return Collections.unmodifiableSet(this.lLP);
    }

    public boolean dpB() {
        return this.lUl;
    }

    public com.facebook.cache.disk.b dpC() {
        return this.lUm;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dpD() {
        return this.lUn;
    }

    public i dpE() {
        return this.lUo;
    }

    public static a gm(Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class b {
        private boolean lUu;

        private b() {
            this.lUu = false;
        }

        public boolean dpG() {
            return this.lUu;
        }
    }

    /* loaded from: classes12.dex */
    public static class a {
        private Set<com.facebook.imagepipeline.h.c> lLP;
        private e lQK;
        private com.facebook.imagepipeline.b.f lQb;
        private n lSD;
        private com.facebook.common.internal.j<Boolean> lTM;
        private com.facebook.imagepipeline.c.f lTR;
        private com.facebook.common.internal.j<q> lTZ;
        private h.a lUa;
        private boolean lUb;
        private f lUc;
        private com.facebook.common.internal.j<q> lUd;
        private com.facebook.imagepipeline.decoder.b lUe;
        private com.facebook.cache.disk.b lUf;
        private com.facebook.common.memory.c lUg;
        private af lUh;
        private com.facebook.imagepipeline.memory.q lUj;
        private com.facebook.imagepipeline.decoder.d lUk;
        private boolean lUl;
        private com.facebook.cache.disk.b lUm;
        private com.facebook.imagepipeline.decoder.c lUn;
        private boolean lUp;
        private int lUs;
        private final i.a lUt;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;

        private a(Context context) {
            this.lUb = false;
            this.lUl = true;
            this.lUs = -1;
            this.lUt = new i.a(this);
            this.lUp = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a c(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a b(com.facebook.common.internal.j<q> jVar) {
            this.lTZ = (com.facebook.common.internal.j) com.facebook.common.internal.g.checkNotNull(jVar);
            return this;
        }

        public a vw(boolean z) {
            this.lUb = z;
            return this;
        }

        public a c(com.facebook.cache.disk.b bVar) {
            this.lUf = bVar;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.lUg = cVar;
            return this;
        }

        public a a(af afVar) {
            this.lUh = afVar;
            return this;
        }

        public a vx(boolean z) {
            this.lUl = z;
            return this;
        }

        public h dpF() {
            return new h(this);
        }
    }
}
