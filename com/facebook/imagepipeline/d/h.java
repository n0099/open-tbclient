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
    private static b khV = new b();
    private final o kfX;
    private final com.facebook.imagepipeline.c.f kgN;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d khD;
    private final com.facebook.common.internal.i<u> khE;
    private final boolean khF;
    private final f khG;
    private final com.facebook.common.internal.i<u> khH;
    private final e khI;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b khJ;
    private final com.facebook.cache.disk.b khK;
    private final com.facebook.common.memory.c khL;
    private final af khM;
    @Nullable
    private final com.facebook.imagepipeline.b.f khN;
    private final q khO;
    private final com.facebook.imagepipeline.decoder.d khP;
    private final Set<com.facebook.imagepipeline.g.b> khQ;
    private final boolean khR;
    private final com.facebook.cache.disk.b khS;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c khT;
    private final i khU;
    private final com.facebook.common.internal.i<Boolean> khu;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cDi;
        this.khU = aVar.khX.cGP();
        this.khD = aVar.khD;
        this.khE = aVar.khE == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.khE;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.kgN == null) {
            fVar = com.facebook.imagepipeline.c.j.cFz();
        } else {
            fVar = aVar.kgN;
        }
        this.kgN = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.khG = aVar.khG == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.khG;
        this.khF = aVar.khF;
        this.khH = aVar.khH == null ? new com.facebook.imagepipeline.c.k() : aVar.khH;
        if (aVar.kfX == null) {
            oVar = x.cFJ();
        } else {
            oVar = aVar.kfX;
        }
        this.kfX = oVar;
        this.khJ = aVar.khJ;
        this.khu = aVar.khu == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cGD */
            public Boolean get() {
                return true;
            }
        } : aVar.khu;
        this.khK = aVar.khK == null ? eu(aVar.mContext) : aVar.khK;
        if (aVar.khL == null) {
            cVar = com.facebook.common.memory.d.cCL();
        } else {
            cVar = aVar.khL;
        }
        this.khL = cVar;
        this.khM = aVar.khM == null ? new t() : aVar.khM;
        this.khN = aVar.khN;
        if (aVar.khO == null) {
            qVar = new q(p.cIu().cIv());
        } else {
            qVar = aVar.khO;
        }
        this.khO = qVar;
        this.khP = aVar.khP == null ? new com.facebook.imagepipeline.decoder.f() : aVar.khP;
        this.khQ = aVar.khQ == null ? new HashSet<>() : aVar.khQ;
        this.khR = aVar.khR;
        this.khS = aVar.khS == null ? this.khK : aVar.khS;
        this.khT = aVar.khT;
        this.khI = aVar.khI == null ? new com.facebook.imagepipeline.d.a(this.khO.cIy()) : aVar.khI;
        com.facebook.common.g.b cGO = this.khU.cGO();
        if (cGO != null) {
            a(cGO, this.khU, new com.facebook.imagepipeline.b.d(cGw()));
        } else if (this.khU.cGL() && com.facebook.common.g.c.kbc && (cDi = com.facebook.common.g.c.cDi()) != null) {
            a(cDi, this.khU, new com.facebook.imagepipeline.b.d(cGw()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.kbf = bVar;
        b.a cGN = iVar.cGN();
        if (cGN != null) {
            bVar.a(cGN);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eu(Context context) {
        return com.facebook.cache.disk.b.eq(context).cCr();
    }

    public Bitmap.Config cFU() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.i<u> cGk() {
        return this.khE;
    }

    public com.facebook.imagepipeline.c.f cGj() {
        return this.kgN;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cGl() {
        return khV;
    }

    public f cGm() {
        return this.khG;
    }

    public boolean cGn() {
        return this.khF;
    }

    public com.facebook.common.internal.i<u> cGo() {
        return this.khH;
    }

    public e cGp() {
        return this.khI;
    }

    public o cGq() {
        return this.kfX;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cGr() {
        return this.khJ;
    }

    public com.facebook.common.internal.i<Boolean> cGs() {
        return this.khu;
    }

    public com.facebook.cache.disk.b cGt() {
        return this.khK;
    }

    public com.facebook.common.memory.c cGu() {
        return this.khL;
    }

    public af cGv() {
        return this.khM;
    }

    public q cGw() {
        return this.khO;
    }

    public com.facebook.imagepipeline.decoder.d cGx() {
        return this.khP;
    }

    public Set<com.facebook.imagepipeline.g.b> cGy() {
        return Collections.unmodifiableSet(this.khQ);
    }

    public boolean cGz() {
        return this.khR;
    }

    public com.facebook.cache.disk.b cGA() {
        return this.khS;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cGB() {
        return this.khT;
    }

    public i cGC() {
        return this.khU;
    }

    public static a ev(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean khY;

        private b() {
            this.khY = false;
        }

        public boolean cGF() {
            return this.khY;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private o kfX;
        private com.facebook.imagepipeline.c.f kgN;
        private com.facebook.imagepipeline.a.a.d khD;
        private com.facebook.common.internal.i<u> khE;
        private boolean khF;
        private f khG;
        private com.facebook.common.internal.i<u> khH;
        private e khI;
        private com.facebook.imagepipeline.decoder.b khJ;
        private com.facebook.cache.disk.b khK;
        private com.facebook.common.memory.c khL;
        private af khM;
        private com.facebook.imagepipeline.b.f khN;
        private q khO;
        private com.facebook.imagepipeline.decoder.d khP;
        private Set<com.facebook.imagepipeline.g.b> khQ;
        private boolean khR;
        private com.facebook.cache.disk.b khS;
        private com.facebook.imagepipeline.decoder.c khT;
        private final i.a khX;
        private com.facebook.common.internal.i<Boolean> khu;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;

        private a(Context context) {
            this.khF = false;
            this.khR = true;
            this.khX = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cGE() {
            return new h(this);
        }
    }
}
