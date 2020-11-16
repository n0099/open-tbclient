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
/* loaded from: classes15.dex */
public class h {
    private static b oXf = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> oOs;
    @Nullable
    private final com.facebook.imagepipeline.b.f oSN;
    private final e oTw;
    private final n oVr;
    private final com.facebook.common.internal.j<Boolean> oWB;
    private final com.facebook.imagepipeline.c.f oWG;
    private final com.facebook.common.internal.j<q> oWO;
    private final h.a oWP;
    private final boolean oWQ;
    private final f oWR;
    private final com.facebook.common.internal.j<q> oWS;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b oWT;
    private final com.facebook.cache.disk.b oWU;
    private final com.facebook.common.memory.c oWV;
    private final af oWW;
    private final int oWX;
    private final com.facebook.imagepipeline.memory.q oWY;
    private final com.facebook.imagepipeline.decoder.d oWZ;
    private final boolean oXa;
    private final com.facebook.cache.disk.b oXb;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c oXc;
    private final i oXd;
    private final boolean oXe;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b ekx;
        this.oXd = aVar.oXi.eoS();
        this.oWO = aVar.oWO == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.oWO;
        this.oWP = aVar.oWP == null ? new com.facebook.imagepipeline.c.d() : aVar.oWP;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.oWG == null) {
            fVar = com.facebook.imagepipeline.c.j.enw();
        } else {
            fVar = aVar.oWG;
        }
        this.oWG = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.oWR = aVar.oWR == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.oWR;
        this.oWQ = aVar.oWQ;
        this.oWS = aVar.oWS == null ? new com.facebook.imagepipeline.c.k() : aVar.oWS;
        if (aVar.oVr == null) {
            nVar = t.enF();
        } else {
            nVar = aVar.oVr;
        }
        this.oVr = nVar;
        this.oWT = aVar.oWT;
        this.oWB = aVar.oWB == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: ekd */
            public Boolean get() {
                return true;
            }
        } : aVar.oWB;
        this.oWU = aVar.oWU == null ? gZ(aVar.mContext) : aVar.oWU;
        if (aVar.oWV == null) {
            cVar = com.facebook.common.memory.d.ekf();
        } else {
            cVar = aVar.oWV;
        }
        this.oWV = cVar;
        this.oWX = aVar.oXh < 0 ? 30000 : aVar.oXh;
        this.oWW = aVar.oWW == null ? new u(this.oWX) : aVar.oWW;
        this.oSN = aVar.oSN;
        if (aVar.oWY == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.eqH().eqI());
        } else {
            qVar = aVar.oWY;
        }
        this.oWY = qVar;
        this.oWZ = aVar.oWZ == null ? new com.facebook.imagepipeline.decoder.f() : aVar.oWZ;
        this.oOs = aVar.oOs == null ? new HashSet<>() : aVar.oOs;
        this.oXa = aVar.oXa;
        this.oXb = aVar.oXb == null ? this.oWU : aVar.oXb;
        this.oXc = aVar.oXc;
        this.oTw = aVar.oTw == null ? new com.facebook.imagepipeline.d.a(this.oWY.eqL()) : aVar.oTw;
        this.oXe = aVar.oXe;
        com.facebook.common.g.b eoK = this.oXd.eoK();
        if (eoK != null) {
            a(eoK, this.oXd, new com.facebook.imagepipeline.b.d(eox()));
        } else if (this.oXd.eoH() && com.facebook.common.g.c.oNy && (ekx = com.facebook.common.g.c.ekx()) != null) {
            a(ekx, this.oXd, new com.facebook.imagepipeline.b.d(eox()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.oNB = bVar;
        b.a eoJ = iVar.eoJ();
        if (eoJ != null) {
            bVar.a(eoJ);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b gZ(Context context) {
        return com.facebook.cache.disk.b.gV(context).ejH();
    }

    public Bitmap.Config enR() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> eoj() {
        return this.oWO;
    }

    public h.a eok() {
        return this.oWP;
    }

    public com.facebook.imagepipeline.c.f eoi() {
        return this.oWG;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b eol() {
        return oXf;
    }

    public f eom() {
        return this.oWR;
    }

    public boolean eon() {
        return this.oWQ;
    }

    public boolean eoo() {
        return this.oXe;
    }

    public com.facebook.common.internal.j<q> eop() {
        return this.oWS;
    }

    public e eoq() {
        return this.oTw;
    }

    public n eor() {
        return this.oVr;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b eos() {
        return this.oWT;
    }

    public com.facebook.common.internal.j<Boolean> eot() {
        return this.oWB;
    }

    public com.facebook.cache.disk.b eou() {
        return this.oWU;
    }

    public com.facebook.common.memory.c eov() {
        return this.oWV;
    }

    public af eow() {
        return this.oWW;
    }

    public com.facebook.imagepipeline.memory.q eox() {
        return this.oWY;
    }

    public com.facebook.imagepipeline.decoder.d eoy() {
        return this.oWZ;
    }

    public Set<com.facebook.imagepipeline.h.c> eoz() {
        return Collections.unmodifiableSet(this.oOs);
    }

    public boolean eoA() {
        return this.oXa;
    }

    public com.facebook.cache.disk.b eoB() {
        return this.oXb;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c eoC() {
        return this.oXc;
    }

    public i eoD() {
        return this.oXd;
    }

    public static a ha(Context context) {
        return new a(context);
    }

    /* loaded from: classes15.dex */
    public static class b {
        private boolean oXj;

        private b() {
            this.oXj = false;
        }

        public boolean eoF() {
            return this.oXj;
        }
    }

    /* loaded from: classes15.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> oOs;
        private com.facebook.imagepipeline.b.f oSN;
        private e oTw;
        private n oVr;
        private com.facebook.common.internal.j<Boolean> oWB;
        private com.facebook.imagepipeline.c.f oWG;
        private com.facebook.common.internal.j<q> oWO;
        private h.a oWP;
        private boolean oWQ;
        private f oWR;
        private com.facebook.common.internal.j<q> oWS;
        private com.facebook.imagepipeline.decoder.b oWT;
        private com.facebook.cache.disk.b oWU;
        private com.facebook.common.memory.c oWV;
        private af oWW;
        private com.facebook.imagepipeline.memory.q oWY;
        private com.facebook.imagepipeline.decoder.d oWZ;
        private boolean oXa;
        private com.facebook.cache.disk.b oXb;
        private com.facebook.imagepipeline.decoder.c oXc;
        private boolean oXe;
        private int oXh;
        private final i.a oXi;

        private a(Context context) {
            this.oWQ = false;
            this.oXa = true;
            this.oXh = -1;
            this.oXi = new i.a(this);
            this.oXe = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a At(boolean z) {
            this.oWQ = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.oWV = cVar;
            return this;
        }

        public a a(af afVar) {
            this.oWW = afVar;
            return this;
        }

        public a Au(boolean z) {
            this.oXa = z;
            return this;
        }

        public h eoE() {
            return new h(this);
        }
    }
}
