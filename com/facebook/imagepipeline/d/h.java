package com.facebook.imagepipeline.d;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.o;
import com.facebook.imagepipeline.c.u;
import com.facebook.imagepipeline.c.x;
import com.facebook.imagepipeline.d.i;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.t;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class h {
    private static b kiN = new b();
    private final o kgO;
    private final com.facebook.imagepipeline.c.f khE;
    private final e kiA;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b kiB;
    private final com.facebook.cache.disk.b kiC;
    private final com.facebook.common.memory.c kiD;
    private final af kiE;
    @Nullable
    private final com.facebook.imagepipeline.b.f kiF;
    private final q kiG;
    private final com.facebook.imagepipeline.decoder.d kiH;
    private final Set<com.facebook.imagepipeline.g.b> kiI;
    private final boolean kiJ;
    private final com.facebook.cache.disk.b kiK;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c kiL;
    private final i kiM;
    private final com.facebook.common.internal.i<Boolean> kim;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d kiv;
    private final com.facebook.common.internal.i<u> kiw;
    private final boolean kix;
    private final f kiy;
    private final com.facebook.common.internal.i<u> kiz;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cDk;
        this.kiM = aVar.kiP.cGR();
        this.kiv = aVar.kiv;
        this.kiw = aVar.kiw == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.kiw;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.khE == null) {
            fVar = com.facebook.imagepipeline.c.j.cFB();
        } else {
            fVar = aVar.khE;
        }
        this.khE = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.kiy = aVar.kiy == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.kiy;
        this.kix = aVar.kix;
        this.kiz = aVar.kiz == null ? new com.facebook.imagepipeline.c.k() : aVar.kiz;
        if (aVar.kgO == null) {
            oVar = x.cFL();
        } else {
            oVar = aVar.kgO;
        }
        this.kgO = oVar;
        this.kiB = aVar.kiB;
        this.kim = aVar.kim == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cGF */
            public Boolean get() {
                return true;
            }
        } : aVar.kim;
        this.kiC = aVar.kiC == null ? eu(aVar.mContext) : aVar.kiC;
        if (aVar.kiD == null) {
            cVar = com.facebook.common.memory.d.cCN();
        } else {
            cVar = aVar.kiD;
        }
        this.kiD = cVar;
        this.kiE = aVar.kiE == null ? new t() : aVar.kiE;
        this.kiF = aVar.kiF;
        if (aVar.kiG == null) {
            qVar = new q(p.cIw().cIx());
        } else {
            qVar = aVar.kiG;
        }
        this.kiG = qVar;
        this.kiH = aVar.kiH == null ? new com.facebook.imagepipeline.decoder.f() : aVar.kiH;
        this.kiI = aVar.kiI == null ? new HashSet<>() : aVar.kiI;
        this.kiJ = aVar.kiJ;
        this.kiK = aVar.kiK == null ? this.kiC : aVar.kiK;
        this.kiL = aVar.kiL;
        this.kiA = aVar.kiA == null ? new com.facebook.imagepipeline.d.a(this.kiG.cIA()) : aVar.kiA;
        com.facebook.common.g.b cGQ = this.kiM.cGQ();
        if (cGQ != null) {
            a(cGQ, this.kiM, new com.facebook.imagepipeline.b.d(cGy()));
        } else if (this.kiM.cGN() && com.facebook.common.g.c.kbT && (cDk = com.facebook.common.g.c.cDk()) != null) {
            a(cDk, this.kiM, new com.facebook.imagepipeline.b.d(cGy()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.kbW = bVar;
        b.a cGP = iVar.cGP();
        if (cGP != null) {
            bVar.a(cGP);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eu(Context context) {
        return com.facebook.cache.disk.b.eq(context).cCt();
    }

    public Bitmap.Config cFW() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.i<u> cGm() {
        return this.kiw;
    }

    public com.facebook.imagepipeline.c.f cGl() {
        return this.khE;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cGn() {
        return kiN;
    }

    public f cGo() {
        return this.kiy;
    }

    public boolean cGp() {
        return this.kix;
    }

    public com.facebook.common.internal.i<u> cGq() {
        return this.kiz;
    }

    public e cGr() {
        return this.kiA;
    }

    public o cGs() {
        return this.kgO;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cGt() {
        return this.kiB;
    }

    public com.facebook.common.internal.i<Boolean> cGu() {
        return this.kim;
    }

    public com.facebook.cache.disk.b cGv() {
        return this.kiC;
    }

    public com.facebook.common.memory.c cGw() {
        return this.kiD;
    }

    public af cGx() {
        return this.kiE;
    }

    public q cGy() {
        return this.kiG;
    }

    public com.facebook.imagepipeline.decoder.d cGz() {
        return this.kiH;
    }

    public Set<com.facebook.imagepipeline.g.b> cGA() {
        return Collections.unmodifiableSet(this.kiI);
    }

    public boolean cGB() {
        return this.kiJ;
    }

    public com.facebook.cache.disk.b cGC() {
        return this.kiK;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cGD() {
        return this.kiL;
    }

    public i cGE() {
        return this.kiM;
    }

    public static a ev(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean kiQ;

        private b() {
            this.kiQ = false;
        }

        public boolean cGH() {
            return this.kiQ;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private o kgO;
        private com.facebook.imagepipeline.c.f khE;
        private e kiA;
        private com.facebook.imagepipeline.decoder.b kiB;
        private com.facebook.cache.disk.b kiC;
        private com.facebook.common.memory.c kiD;
        private af kiE;
        private com.facebook.imagepipeline.b.f kiF;
        private q kiG;
        private com.facebook.imagepipeline.decoder.d kiH;
        private Set<com.facebook.imagepipeline.g.b> kiI;
        private boolean kiJ;
        private com.facebook.cache.disk.b kiK;
        private com.facebook.imagepipeline.decoder.c kiL;
        private final i.a kiP;
        private com.facebook.common.internal.i<Boolean> kim;
        private com.facebook.imagepipeline.a.a.d kiv;
        private com.facebook.common.internal.i<u> kiw;
        private boolean kix;
        private f kiy;
        private com.facebook.common.internal.i<u> kiz;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;

        private a(Context context) {
            this.kix = false;
            this.kiJ = true;
            this.kiP = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cGG() {
            return new h(this);
        }
    }
}
