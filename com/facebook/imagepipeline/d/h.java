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
    private static b kie = new b();
    private final Bitmap.Config Dx;
    private final com.facebook.imagepipeline.c.f kgV;
    private final o kgg;
    private final com.facebook.common.internal.i<Boolean> khC;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d khL;
    private final com.facebook.common.internal.i<u> khM;
    private final boolean khN;
    private final f khO;
    private final com.facebook.common.internal.i<u> khP;
    private final e khQ;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b khR;
    private final com.facebook.cache.disk.b khS;
    private final com.facebook.common.memory.c khT;
    private final af khU;
    @Nullable
    private final com.facebook.imagepipeline.b.f khV;
    private final q khW;
    private final com.facebook.imagepipeline.decoder.d khX;
    private final Set<com.facebook.imagepipeline.g.b> khY;
    private final boolean khZ;
    private final com.facebook.cache.disk.b kia;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c kib;
    private final i kic;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cFy;
        this.kic = aVar.kig.cJg();
        this.khL = aVar.khL;
        this.khM = aVar.khM == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.khM;
        this.Dx = aVar.Dx == null ? Bitmap.Config.ARGB_8888 : aVar.Dx;
        if (aVar.kgV == null) {
            fVar = com.facebook.imagepipeline.c.j.cHQ();
        } else {
            fVar = aVar.kgV;
        }
        this.kgV = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.khO = aVar.khO == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.khO;
        this.khN = aVar.khN;
        this.khP = aVar.khP == null ? new com.facebook.imagepipeline.c.k() : aVar.khP;
        if (aVar.kgg == null) {
            oVar = x.cIa();
        } else {
            oVar = aVar.kgg;
        }
        this.kgg = oVar;
        this.khR = aVar.khR;
        this.khC = aVar.khC == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cIU */
            public Boolean get() {
                return true;
            }
        } : aVar.khC;
        this.khS = aVar.khS == null ? eE(aVar.mContext) : aVar.khS;
        if (aVar.khT == null) {
            cVar = com.facebook.common.memory.d.cFb();
        } else {
            cVar = aVar.khT;
        }
        this.khT = cVar;
        this.khU = aVar.khU == null ? new t() : aVar.khU;
        this.khV = aVar.khV;
        if (aVar.khW == null) {
            qVar = new q(p.cKL().cKM());
        } else {
            qVar = aVar.khW;
        }
        this.khW = qVar;
        this.khX = aVar.khX == null ? new com.facebook.imagepipeline.decoder.f() : aVar.khX;
        this.khY = aVar.khY == null ? new HashSet<>() : aVar.khY;
        this.khZ = aVar.khZ;
        this.kia = aVar.kia == null ? this.khS : aVar.kia;
        this.kib = aVar.kib;
        this.khQ = aVar.khQ == null ? new com.facebook.imagepipeline.d.a(this.khW.cKP()) : aVar.khQ;
        com.facebook.common.g.b cJf = this.kic.cJf();
        if (cJf != null) {
            a(cJf, this.kic, new com.facebook.imagepipeline.b.d(cIN()));
        } else if (this.kic.cJc() && com.facebook.common.g.c.kbn && (cFy = com.facebook.common.g.c.cFy()) != null) {
            a(cFy, this.kic, new com.facebook.imagepipeline.b.d(cIN()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.kbq = bVar;
        b.a cJe = iVar.cJe();
        if (cJe != null) {
            bVar.a(cJe);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eE(Context context) {
        return com.facebook.cache.disk.b.eA(context).cEH();
    }

    public Bitmap.Config cIl() {
        return this.Dx;
    }

    public com.facebook.common.internal.i<u> cIB() {
        return this.khM;
    }

    public com.facebook.imagepipeline.c.f cIA() {
        return this.kgV;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cIC() {
        return kie;
    }

    public f cID() {
        return this.khO;
    }

    public boolean cIE() {
        return this.khN;
    }

    public com.facebook.common.internal.i<u> cIF() {
        return this.khP;
    }

    public e cIG() {
        return this.khQ;
    }

    public o cIH() {
        return this.kgg;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cII() {
        return this.khR;
    }

    public com.facebook.common.internal.i<Boolean> cIJ() {
        return this.khC;
    }

    public com.facebook.cache.disk.b cIK() {
        return this.khS;
    }

    public com.facebook.common.memory.c cIL() {
        return this.khT;
    }

    public af cIM() {
        return this.khU;
    }

    public q cIN() {
        return this.khW;
    }

    public com.facebook.imagepipeline.decoder.d cIO() {
        return this.khX;
    }

    public Set<com.facebook.imagepipeline.g.b> cIP() {
        return Collections.unmodifiableSet(this.khY);
    }

    public boolean cIQ() {
        return this.khZ;
    }

    public com.facebook.cache.disk.b cIR() {
        return this.kia;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cIS() {
        return this.kib;
    }

    public i cIT() {
        return this.kic;
    }

    public static a eF(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean kih;

        private b() {
            this.kih = false;
        }

        public boolean cIW() {
            return this.kih;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config Dx;
        private com.facebook.imagepipeline.c.f kgV;
        private o kgg;
        private com.facebook.common.internal.i<Boolean> khC;
        private com.facebook.imagepipeline.a.a.d khL;
        private com.facebook.common.internal.i<u> khM;
        private boolean khN;
        private f khO;
        private com.facebook.common.internal.i<u> khP;
        private e khQ;
        private com.facebook.imagepipeline.decoder.b khR;
        private com.facebook.cache.disk.b khS;
        private com.facebook.common.memory.c khT;
        private af khU;
        private com.facebook.imagepipeline.b.f khV;
        private q khW;
        private com.facebook.imagepipeline.decoder.d khX;
        private Set<com.facebook.imagepipeline.g.b> khY;
        private boolean khZ;
        private com.facebook.cache.disk.b kia;
        private com.facebook.imagepipeline.decoder.c kib;
        private final i.a kig;
        private final Context mContext;

        private a(Context context) {
            this.khN = false;
            this.khZ = true;
            this.kig = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cIV() {
            return new h(this);
        }
    }
}
