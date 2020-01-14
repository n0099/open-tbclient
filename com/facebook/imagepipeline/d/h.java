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
/* loaded from: classes10.dex */
public class h {
    private static b lRQ = new b();
    private final Set<com.facebook.imagepipeline.h.c> lJp;
    @Nullable
    private final com.facebook.imagepipeline.b.f lNB;
    private final e lOk;
    private final n lQd;
    private final h.a lRA;
    private final boolean lRB;
    private final f lRC;
    private final com.facebook.common.internal.j<q> lRD;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b lRE;
    private final com.facebook.cache.disk.b lRF;
    private final com.facebook.common.memory.c lRG;
    private final af lRH;
    private final int lRI;
    private final com.facebook.imagepipeline.memory.q lRJ;
    private final com.facebook.imagepipeline.decoder.d lRK;
    private final boolean lRL;
    private final com.facebook.cache.disk.b lRM;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c lRN;
    private final i lRO;
    private final boolean lRP;
    private final com.facebook.common.internal.j<Boolean> lRm;
    private final com.facebook.imagepipeline.c.f lRr;
    private final com.facebook.common.internal.j<q> lRz;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b djP;
        this.lRO = aVar.lRT.doh();
        this.lRz = aVar.lRz == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.lRz;
        this.lRA = aVar.lRA == null ? new com.facebook.imagepipeline.c.d() : aVar.lRA;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.lRr == null) {
            fVar = com.facebook.imagepipeline.c.j.dmK();
        } else {
            fVar = aVar.lRr;
        }
        this.lRr = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.lRC = aVar.lRC == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.lRC;
        this.lRB = aVar.lRB;
        this.lRD = aVar.lRD == null ? new com.facebook.imagepipeline.c.k() : aVar.lRD;
        if (aVar.lQd == null) {
            nVar = t.dmT();
        } else {
            nVar = aVar.lQd;
        }
        this.lQd = nVar;
        this.lRE = aVar.lRE;
        this.lRm = aVar.lRm == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: djv */
            public Boolean get() {
                return true;
            }
        } : aVar.lRm;
        this.lRF = aVar.lRF == null ? gp(aVar.mContext) : aVar.lRF;
        if (aVar.lRG == null) {
            cVar = com.facebook.common.memory.d.djx();
        } else {
            cVar = aVar.lRG;
        }
        this.lRG = cVar;
        this.lRI = aVar.lRS < 0 ? 30000 : aVar.lRS;
        this.lRH = aVar.lRH == null ? new u(this.lRI) : aVar.lRH;
        this.lNB = aVar.lNB;
        if (aVar.lRJ == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dpX().dpY());
        } else {
            qVar = aVar.lRJ;
        }
        this.lRJ = qVar;
        this.lRK = aVar.lRK == null ? new com.facebook.imagepipeline.decoder.f() : aVar.lRK;
        this.lJp = aVar.lJp == null ? new HashSet<>() : aVar.lJp;
        this.lRL = aVar.lRL;
        this.lRM = aVar.lRM == null ? this.lRF : aVar.lRM;
        this.lRN = aVar.lRN;
        this.lOk = aVar.lOk == null ? new com.facebook.imagepipeline.d.a(this.lRJ.dqb()) : aVar.lOk;
        this.lRP = aVar.lRP;
        com.facebook.common.g.b dnZ = this.lRO.dnZ();
        if (dnZ != null) {
            a(dnZ, this.lRO, new com.facebook.imagepipeline.b.d(dnM()));
        } else if (this.lRO.dnW() && com.facebook.common.g.c.lIv && (djP = com.facebook.common.g.c.djP()) != null) {
            a(djP, this.lRO, new com.facebook.imagepipeline.b.d(dnM()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.lIx = bVar;
        b.a dnY = iVar.dnY();
        if (dnY != null) {
            bVar.a(dnY);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b gp(Context context) {
        return com.facebook.cache.disk.b.gk(context).diZ();
    }

    public Bitmap.Config dnf() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dny() {
        return this.lRz;
    }

    public h.a dnz() {
        return this.lRA;
    }

    public com.facebook.imagepipeline.c.f dnx() {
        return this.lRr;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dnA() {
        return lRQ;
    }

    public f dnB() {
        return this.lRC;
    }

    public boolean dnC() {
        return this.lRB;
    }

    public boolean dnD() {
        return this.lRP;
    }

    public com.facebook.common.internal.j<q> dnE() {
        return this.lRD;
    }

    public e dnF() {
        return this.lOk;
    }

    public n dnG() {
        return this.lQd;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dnH() {
        return this.lRE;
    }

    public com.facebook.common.internal.j<Boolean> dnI() {
        return this.lRm;
    }

    public com.facebook.cache.disk.b dnJ() {
        return this.lRF;
    }

    public com.facebook.common.memory.c dnK() {
        return this.lRG;
    }

    public af dnL() {
        return this.lRH;
    }

    public com.facebook.imagepipeline.memory.q dnM() {
        return this.lRJ;
    }

    public com.facebook.imagepipeline.decoder.d dnN() {
        return this.lRK;
    }

    public Set<com.facebook.imagepipeline.h.c> dnO() {
        return Collections.unmodifiableSet(this.lJp);
    }

    public boolean dnP() {
        return this.lRL;
    }

    public com.facebook.cache.disk.b dnQ() {
        return this.lRM;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dnR() {
        return this.lRN;
    }

    public i dnS() {
        return this.lRO;
    }

    public static a go(Context context) {
        return new a(context);
    }

    /* loaded from: classes10.dex */
    public static class b {
        private boolean lRU;

        private b() {
            this.lRU = false;
        }

        public boolean dnU() {
            return this.lRU;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private Set<com.facebook.imagepipeline.h.c> lJp;
        private com.facebook.imagepipeline.b.f lNB;
        private e lOk;
        private n lQd;
        private h.a lRA;
        private boolean lRB;
        private f lRC;
        private com.facebook.common.internal.j<q> lRD;
        private com.facebook.imagepipeline.decoder.b lRE;
        private com.facebook.cache.disk.b lRF;
        private com.facebook.common.memory.c lRG;
        private af lRH;
        private com.facebook.imagepipeline.memory.q lRJ;
        private com.facebook.imagepipeline.decoder.d lRK;
        private boolean lRL;
        private com.facebook.cache.disk.b lRM;
        private com.facebook.imagepipeline.decoder.c lRN;
        private boolean lRP;
        private int lRS;
        private final i.a lRT;
        private com.facebook.common.internal.j<Boolean> lRm;
        private com.facebook.imagepipeline.c.f lRr;
        private com.facebook.common.internal.j<q> lRz;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;

        private a(Context context) {
            this.lRB = false;
            this.lRL = true;
            this.lRS = -1;
            this.lRT = new i.a(this);
            this.lRP = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a c(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a b(com.facebook.common.internal.j<q> jVar) {
            this.lRz = (com.facebook.common.internal.j) com.facebook.common.internal.g.checkNotNull(jVar);
            return this;
        }

        public a vl(boolean z) {
            this.lRB = z;
            return this;
        }

        public a c(com.facebook.cache.disk.b bVar) {
            this.lRF = bVar;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.lRG = cVar;
            return this;
        }

        public a a(af afVar) {
            this.lRH = afVar;
            return this;
        }

        public a vm(boolean z) {
            this.lRL = z;
            return this;
        }

        public h dnT() {
            return new h(this);
        }
    }
}
