package com.facebook.imagepipeline.c;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.common.g.b;
import com.facebook.imagepipeline.b.h;
import com.facebook.imagepipeline.b.n;
import com.facebook.imagepipeline.b.q;
import com.facebook.imagepipeline.b.t;
import com.facebook.imagepipeline.c.i;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.u;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class h {
    private static b pIO = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.g.c> pAw;
    @Nullable
    private final com.facebook.imagepipeline.a.f pEI;
    private final e pFr;
    private final n pHc;
    private final f pIA;
    private final com.facebook.common.internal.j<q> pIB;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b pIC;
    private final com.facebook.cache.disk.b pID;
    private final com.facebook.common.memory.c pIE;
    private final af pIF;
    private final int pIG;
    private final com.facebook.imagepipeline.memory.q pIH;
    private final com.facebook.imagepipeline.decoder.d pII;
    private final boolean pIJ;
    private final com.facebook.cache.disk.b pIK;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c pIL;
    private final i pIM;
    private final boolean pIN;
    private final com.facebook.common.internal.j<Boolean> pIk;
    private final com.facebook.imagepipeline.b.f pIp;
    private final com.facebook.common.internal.j<q> pIx;
    private final h.a pIy;
    private final boolean pIz;

    private h(a aVar) {
        com.facebook.imagepipeline.b.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b esV;
        this.pIM = aVar.pIR.exk();
        this.pIx = aVar.pIx == null ? new com.facebook.imagepipeline.b.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.pIx;
        this.pIy = aVar.pIy == null ? new com.facebook.imagepipeline.b.d() : aVar.pIy;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.pIp == null) {
            fVar = com.facebook.imagepipeline.b.j.evQ();
        } else {
            fVar = aVar.pIp;
        }
        this.pIp = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.pIA = aVar.pIA == null ? new com.facebook.imagepipeline.c.b(new d()) : aVar.pIA;
        this.pIz = aVar.pIz;
        this.pIB = aVar.pIB == null ? new com.facebook.imagepipeline.b.k() : aVar.pIB;
        if (aVar.pHc == null) {
            nVar = t.evZ();
        } else {
            nVar = aVar.pHc;
        }
        this.pHc = nVar;
        this.pIC = aVar.pIC;
        this.pIk = aVar.pIk == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: esB */
            public Boolean get() {
                return true;
            }
        } : aVar.pIk;
        this.pID = aVar.pID == null ? il(aVar.mContext) : aVar.pID;
        if (aVar.pIE == null) {
            cVar = com.facebook.common.memory.d.esD();
        } else {
            cVar = aVar.pIE;
        }
        this.pIE = cVar;
        this.pIG = aVar.pIQ < 0 ? 30000 : aVar.pIQ;
        this.pIF = aVar.pIF == null ? new u(this.pIG) : aVar.pIF;
        this.pEI = aVar.pEI;
        if (aVar.pIH == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.eyV().eyW());
        } else {
            qVar = aVar.pIH;
        }
        this.pIH = qVar;
        this.pII = aVar.pII == null ? new com.facebook.imagepipeline.decoder.f() : aVar.pII;
        this.pAw = aVar.pAw == null ? new HashSet<>() : aVar.pAw;
        this.pIJ = aVar.pIJ;
        this.pIK = aVar.pIK == null ? this.pID : aVar.pIK;
        this.pIL = aVar.pIL;
        this.pFr = aVar.pFr == null ? new com.facebook.imagepipeline.c.a(this.pIH.eyZ()) : aVar.pFr;
        this.pIN = aVar.pIN;
        com.facebook.common.g.b exc = this.pIM.exc();
        if (exc != null) {
            a(exc, this.pIM, new com.facebook.imagepipeline.a.d(ewP()));
        } else if (this.pIM.ewZ() && com.facebook.common.g.c.pzD && (esV = com.facebook.common.g.c.esV()) != null) {
            a(esV, this.pIM, new com.facebook.imagepipeline.a.d(ewP()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.pzG = bVar;
        b.a exb = iVar.exb();
        if (exb != null) {
            bVar.a(exb);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b il(Context context) {
        return com.facebook.cache.disk.b.ih(context).esg();
    }

    public Bitmap.Config ewk() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> ewB() {
        return this.pIx;
    }

    public h.a ewC() {
        return this.pIy;
    }

    public com.facebook.imagepipeline.b.f ewA() {
        return this.pIp;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b ewD() {
        return pIO;
    }

    public f ewE() {
        return this.pIA;
    }

    public boolean ewF() {
        return this.pIz;
    }

    public boolean ewG() {
        return this.pIN;
    }

    public com.facebook.common.internal.j<q> ewH() {
        return this.pIB;
    }

    public e ewI() {
        return this.pFr;
    }

    public n ewJ() {
        return this.pHc;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b ewK() {
        return this.pIC;
    }

    public com.facebook.common.internal.j<Boolean> ewL() {
        return this.pIk;
    }

    public com.facebook.cache.disk.b ewM() {
        return this.pID;
    }

    public com.facebook.common.memory.c ewN() {
        return this.pIE;
    }

    public af ewO() {
        return this.pIF;
    }

    public com.facebook.imagepipeline.memory.q ewP() {
        return this.pIH;
    }

    public com.facebook.imagepipeline.decoder.d ewQ() {
        return this.pII;
    }

    public Set<com.facebook.imagepipeline.g.c> ewR() {
        return Collections.unmodifiableSet(this.pAw);
    }

    public boolean ewS() {
        return this.pIJ;
    }

    public com.facebook.cache.disk.b ewT() {
        return this.pIK;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c ewU() {
        return this.pIL;
    }

    public i ewV() {
        return this.pIM;
    }

    public static a im(Context context) {
        return new a(context);
    }

    /* loaded from: classes5.dex */
    public static class b {
        private boolean pIS;

        private b() {
            this.pIS = false;
        }

        public boolean ewX() {
            return this.pIS;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.g.c> pAw;
        private com.facebook.imagepipeline.a.f pEI;
        private e pFr;
        private n pHc;
        private f pIA;
        private com.facebook.common.internal.j<q> pIB;
        private com.facebook.imagepipeline.decoder.b pIC;
        private com.facebook.cache.disk.b pID;
        private com.facebook.common.memory.c pIE;
        private af pIF;
        private com.facebook.imagepipeline.memory.q pIH;
        private com.facebook.imagepipeline.decoder.d pII;
        private boolean pIJ;
        private com.facebook.cache.disk.b pIK;
        private com.facebook.imagepipeline.decoder.c pIL;
        private boolean pIN;
        private int pIQ;
        private final i.a pIR;
        private com.facebook.common.internal.j<Boolean> pIk;
        private com.facebook.imagepipeline.b.f pIp;
        private com.facebook.common.internal.j<q> pIx;
        private h.a pIy;
        private boolean pIz;

        private a(Context context) {
            this.pIz = false;
            this.pIJ = true;
            this.pIQ = -1;
            this.pIR = new i.a(this);
            this.pIN = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h ewW() {
            return new h(this);
        }
    }
}
