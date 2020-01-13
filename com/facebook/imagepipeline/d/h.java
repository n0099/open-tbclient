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
/* loaded from: classes10.dex */
public class h {
    private static b lRL = new b();
    private final Set<com.facebook.imagepipeline.h.c> lJk;
    @Nullable
    private final com.facebook.imagepipeline.b.f lNw;
    private final e lOf;
    private final n lPY;
    private final com.facebook.cache.disk.b lRA;
    private final com.facebook.common.memory.c lRB;
    private final af lRC;
    private final int lRD;
    private final q lRE;
    private final com.facebook.imagepipeline.decoder.d lRF;
    private final boolean lRG;
    private final com.facebook.cache.disk.b lRH;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c lRI;
    private final i lRJ;
    private final boolean lRK;
    private final com.facebook.common.internal.j<Boolean> lRh;
    private final com.facebook.imagepipeline.c.f lRm;
    private final com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> lRu;
    private final h.a lRv;
    private final boolean lRw;
    private final f lRx;
    private final com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> lRy;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b lRz;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b djN;
        this.lRJ = aVar.lRO.dof();
        this.lRu = aVar.lRu == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.lRu;
        this.lRv = aVar.lRv == null ? new com.facebook.imagepipeline.c.d() : aVar.lRv;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.lRm == null) {
            fVar = com.facebook.imagepipeline.c.j.dmI();
        } else {
            fVar = aVar.lRm;
        }
        this.lRm = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.lRx = aVar.lRx == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.lRx;
        this.lRw = aVar.lRw;
        this.lRy = aVar.lRy == null ? new com.facebook.imagepipeline.c.k() : aVar.lRy;
        if (aVar.lPY == null) {
            nVar = t.dmR();
        } else {
            nVar = aVar.lPY;
        }
        this.lPY = nVar;
        this.lRz = aVar.lRz;
        this.lRh = aVar.lRh == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: djt */
            public Boolean get() {
                return true;
            }
        } : aVar.lRh;
        this.lRA = aVar.lRA == null ? gp(aVar.mContext) : aVar.lRA;
        if (aVar.lRB == null) {
            cVar = com.facebook.common.memory.d.djv();
        } else {
            cVar = aVar.lRB;
        }
        this.lRB = cVar;
        this.lRD = aVar.lRN < 0 ? 30000 : aVar.lRN;
        this.lRC = aVar.lRC == null ? new u(this.lRD) : aVar.lRC;
        this.lNw = aVar.lNw;
        if (aVar.lRE == null) {
            qVar = new q(p.dpV().dpW());
        } else {
            qVar = aVar.lRE;
        }
        this.lRE = qVar;
        this.lRF = aVar.lRF == null ? new com.facebook.imagepipeline.decoder.f() : aVar.lRF;
        this.lJk = aVar.lJk == null ? new HashSet<>() : aVar.lJk;
        this.lRG = aVar.lRG;
        this.lRH = aVar.lRH == null ? this.lRA : aVar.lRH;
        this.lRI = aVar.lRI;
        this.lOf = aVar.lOf == null ? new com.facebook.imagepipeline.d.a(this.lRE.dpZ()) : aVar.lOf;
        this.lRK = aVar.lRK;
        com.facebook.common.g.b dnX = this.lRJ.dnX();
        if (dnX != null) {
            a(dnX, this.lRJ, new com.facebook.imagepipeline.b.d(dnK()));
        } else if (this.lRJ.dnU() && com.facebook.common.g.c.lIq && (djN = com.facebook.common.g.c.djN()) != null) {
            a(djN, this.lRJ, new com.facebook.imagepipeline.b.d(dnK()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.lIs = bVar;
        b.a dnW = iVar.dnW();
        if (dnW != null) {
            bVar.a(dnW);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b gp(Context context) {
        return com.facebook.cache.disk.b.gk(context).diX();
    }

    public Bitmap.Config dnd() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> dnw() {
        return this.lRu;
    }

    public h.a dnx() {
        return this.lRv;
    }

    public com.facebook.imagepipeline.c.f dnv() {
        return this.lRm;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dny() {
        return lRL;
    }

    public f dnz() {
        return this.lRx;
    }

    public boolean dnA() {
        return this.lRw;
    }

    public boolean dnB() {
        return this.lRK;
    }

    public com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> dnC() {
        return this.lRy;
    }

    public e dnD() {
        return this.lOf;
    }

    public n dnE() {
        return this.lPY;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dnF() {
        return this.lRz;
    }

    public com.facebook.common.internal.j<Boolean> dnG() {
        return this.lRh;
    }

    public com.facebook.cache.disk.b dnH() {
        return this.lRA;
    }

    public com.facebook.common.memory.c dnI() {
        return this.lRB;
    }

    public af dnJ() {
        return this.lRC;
    }

    public q dnK() {
        return this.lRE;
    }

    public com.facebook.imagepipeline.decoder.d dnL() {
        return this.lRF;
    }

    public Set<com.facebook.imagepipeline.h.c> dnM() {
        return Collections.unmodifiableSet(this.lJk);
    }

    public boolean dnN() {
        return this.lRG;
    }

    public com.facebook.cache.disk.b dnO() {
        return this.lRH;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dnP() {
        return this.lRI;
    }

    public i dnQ() {
        return this.lRJ;
    }

    public static a go(Context context) {
        return new a(context);
    }

    /* loaded from: classes10.dex */
    public static class b {
        private boolean lRP;

        private b() {
            this.lRP = false;
        }

        public boolean dnS() {
            return this.lRP;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private Set<com.facebook.imagepipeline.h.c> lJk;
        private com.facebook.imagepipeline.b.f lNw;
        private e lOf;
        private n lPY;
        private com.facebook.cache.disk.b lRA;
        private com.facebook.common.memory.c lRB;
        private af lRC;
        private q lRE;
        private com.facebook.imagepipeline.decoder.d lRF;
        private boolean lRG;
        private com.facebook.cache.disk.b lRH;
        private com.facebook.imagepipeline.decoder.c lRI;
        private boolean lRK;
        private int lRN;
        private final i.a lRO;
        private com.facebook.common.internal.j<Boolean> lRh;
        private com.facebook.imagepipeline.c.f lRm;
        private com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> lRu;
        private h.a lRv;
        private boolean lRw;
        private f lRx;
        private com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> lRy;
        private com.facebook.imagepipeline.decoder.b lRz;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;

        private a(Context context) {
            this.lRw = false;
            this.lRG = true;
            this.lRN = -1;
            this.lRO = new i.a(this);
            this.lRK = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a c(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a b(com.facebook.common.internal.j<com.facebook.imagepipeline.c.q> jVar) {
            this.lRu = (com.facebook.common.internal.j) com.facebook.common.internal.g.checkNotNull(jVar);
            return this;
        }

        public a vl(boolean z) {
            this.lRw = z;
            return this;
        }

        public a c(com.facebook.cache.disk.b bVar) {
            this.lRA = bVar;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.lRB = cVar;
            return this;
        }

        public a a(af afVar) {
            this.lRC = afVar;
            return this;
        }

        public a vm(boolean z) {
            this.lRG = z;
            return this;
        }

        public h dnR() {
            return new h(this);
        }
    }
}
