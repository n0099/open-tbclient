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
/* loaded from: classes18.dex */
public class h {
    private static b nUR = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> nMc;
    @Nullable
    private final com.facebook.imagepipeline.b.f nQz;
    private final e nRi;
    private final n nTd;
    private final com.facebook.common.internal.j<q> nUA;
    private final h.a nUB;
    private final boolean nUC;
    private final f nUD;
    private final com.facebook.common.internal.j<q> nUE;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b nUF;
    private final com.facebook.cache.disk.b nUG;
    private final com.facebook.common.memory.c nUH;
    private final af nUI;
    private final int nUJ;
    private final com.facebook.imagepipeline.memory.q nUK;
    private final com.facebook.imagepipeline.decoder.d nUL;
    private final boolean nUM;
    private final com.facebook.cache.disk.b nUN;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c nUO;
    private final i nUP;
    private final boolean nUQ;
    private final com.facebook.common.internal.j<Boolean> nUn;
    private final com.facebook.imagepipeline.c.f nUs;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dWM;
        this.nUP = aVar.nUU.ebf();
        this.nUA = aVar.nUA == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.nUA;
        this.nUB = aVar.nUB == null ? new com.facebook.imagepipeline.c.d() : aVar.nUB;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.nUs == null) {
            fVar = com.facebook.imagepipeline.c.j.dZK();
        } else {
            fVar = aVar.nUs;
        }
        this.nUs = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.nUD = aVar.nUD == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.nUD;
        this.nUC = aVar.nUC;
        this.nUE = aVar.nUE == null ? new com.facebook.imagepipeline.c.k() : aVar.nUE;
        if (aVar.nTd == null) {
            nVar = t.dZT();
        } else {
            nVar = aVar.nTd;
        }
        this.nTd = nVar;
        this.nUF = aVar.nUF;
        this.nUn = aVar.nUn == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dWs */
            public Boolean get() {
                return true;
            }
        } : aVar.nUn;
        this.nUG = aVar.nUG == null ? gH(aVar.mContext) : aVar.nUG;
        if (aVar.nUH == null) {
            cVar = com.facebook.common.memory.d.dWu();
        } else {
            cVar = aVar.nUH;
        }
        this.nUH = cVar;
        this.nUJ = aVar.nUT < 0 ? 30000 : aVar.nUT;
        this.nUI = aVar.nUI == null ? new u(this.nUJ) : aVar.nUI;
        this.nQz = aVar.nQz;
        if (aVar.nUK == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.ecU().ecV());
        } else {
            qVar = aVar.nUK;
        }
        this.nUK = qVar;
        this.nUL = aVar.nUL == null ? new com.facebook.imagepipeline.decoder.f() : aVar.nUL;
        this.nMc = aVar.nMc == null ? new HashSet<>() : aVar.nMc;
        this.nUM = aVar.nUM;
        this.nUN = aVar.nUN == null ? this.nUG : aVar.nUN;
        this.nUO = aVar.nUO;
        this.nRi = aVar.nRi == null ? new com.facebook.imagepipeline.d.a(this.nUK.ecY()) : aVar.nRi;
        this.nUQ = aVar.nUQ;
        com.facebook.common.g.b eaX = this.nUP.eaX();
        if (eaX != null) {
            a(eaX, this.nUP, new com.facebook.imagepipeline.b.d(eaK()));
        } else if (this.nUP.eaU() && com.facebook.common.g.c.nLi && (dWM = com.facebook.common.g.c.dWM()) != null) {
            a(dWM, this.nUP, new com.facebook.imagepipeline.b.d(eaK()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.nLl = bVar;
        b.a eaW = iVar.eaW();
        if (eaW != null) {
            bVar.a(eaW);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b gH(Context context) {
        return com.facebook.cache.disk.b.gD(context).dVW();
    }

    public Bitmap.Config eaf() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> eaw() {
        return this.nUA;
    }

    public h.a eax() {
        return this.nUB;
    }

    public com.facebook.imagepipeline.c.f eav() {
        return this.nUs;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b eay() {
        return nUR;
    }

    public f eaz() {
        return this.nUD;
    }

    public boolean eaA() {
        return this.nUC;
    }

    public boolean eaB() {
        return this.nUQ;
    }

    public com.facebook.common.internal.j<q> eaC() {
        return this.nUE;
    }

    public e eaD() {
        return this.nRi;
    }

    public n eaE() {
        return this.nTd;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b eaF() {
        return this.nUF;
    }

    public com.facebook.common.internal.j<Boolean> eaG() {
        return this.nUn;
    }

    public com.facebook.cache.disk.b eaH() {
        return this.nUG;
    }

    public com.facebook.common.memory.c eaI() {
        return this.nUH;
    }

    public af eaJ() {
        return this.nUI;
    }

    public com.facebook.imagepipeline.memory.q eaK() {
        return this.nUK;
    }

    public com.facebook.imagepipeline.decoder.d eaL() {
        return this.nUL;
    }

    public Set<com.facebook.imagepipeline.h.c> eaM() {
        return Collections.unmodifiableSet(this.nMc);
    }

    public boolean eaN() {
        return this.nUM;
    }

    public com.facebook.cache.disk.b eaO() {
        return this.nUN;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c eaP() {
        return this.nUO;
    }

    public i eaQ() {
        return this.nUP;
    }

    public static a gI(Context context) {
        return new a(context);
    }

    /* loaded from: classes18.dex */
    public static class b {
        private boolean nUV;

        private b() {
            this.nUV = false;
        }

        public boolean eaS() {
            return this.nUV;
        }
    }

    /* loaded from: classes18.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> nMc;
        private com.facebook.imagepipeline.b.f nQz;
        private e nRi;
        private n nTd;
        private com.facebook.common.internal.j<q> nUA;
        private h.a nUB;
        private boolean nUC;
        private f nUD;
        private com.facebook.common.internal.j<q> nUE;
        private com.facebook.imagepipeline.decoder.b nUF;
        private com.facebook.cache.disk.b nUG;
        private com.facebook.common.memory.c nUH;
        private af nUI;
        private com.facebook.imagepipeline.memory.q nUK;
        private com.facebook.imagepipeline.decoder.d nUL;
        private boolean nUM;
        private com.facebook.cache.disk.b nUN;
        private com.facebook.imagepipeline.decoder.c nUO;
        private boolean nUQ;
        private int nUT;
        private final i.a nUU;
        private com.facebook.common.internal.j<Boolean> nUn;
        private com.facebook.imagepipeline.c.f nUs;

        private a(Context context) {
            this.nUC = false;
            this.nUM = true;
            this.nUT = -1;
            this.nUU = new i.a(this);
            this.nUQ = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a yT(boolean z) {
            this.nUC = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.nUH = cVar;
            return this;
        }

        public a a(af afVar) {
            this.nUI = afVar;
            return this;
        }

        public a yU(boolean z) {
            this.nUM = z;
            return this;
        }

        public h eaR() {
            return new h(this);
        }
    }
}
