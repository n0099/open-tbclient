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
    private static b oVC = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> oMO;
    private final e oRT;
    @Nullable
    private final com.facebook.imagepipeline.b.f oRk;
    private final n oTO;
    private final com.facebook.common.internal.j<Boolean> oUY;
    private final i oVA;
    private final boolean oVB;
    private final com.facebook.imagepipeline.c.f oVd;
    private final com.facebook.common.internal.j<q> oVl;
    private final h.a oVm;
    private final boolean oVn;
    private final f oVo;
    private final com.facebook.common.internal.j<q> oVp;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b oVq;
    private final com.facebook.cache.disk.b oVr;
    private final com.facebook.common.memory.c oVs;
    private final af oVt;
    private final int oVu;
    private final com.facebook.imagepipeline.memory.q oVv;
    private final com.facebook.imagepipeline.decoder.d oVw;
    private final boolean oVx;
    private final com.facebook.cache.disk.b oVy;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c oVz;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b ekz;
        this.oVA = aVar.oVF.eoU();
        this.oVl = aVar.oVl == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.oVl;
        this.oVm = aVar.oVm == null ? new com.facebook.imagepipeline.c.d() : aVar.oVm;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.oVd == null) {
            fVar = com.facebook.imagepipeline.c.j.eny();
        } else {
            fVar = aVar.oVd;
        }
        this.oVd = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.oVo = aVar.oVo == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.oVo;
        this.oVn = aVar.oVn;
        this.oVp = aVar.oVp == null ? new com.facebook.imagepipeline.c.k() : aVar.oVp;
        if (aVar.oTO == null) {
            nVar = t.enH();
        } else {
            nVar = aVar.oTO;
        }
        this.oTO = nVar;
        this.oVq = aVar.oVq;
        this.oUY = aVar.oUY == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: ekf */
            public Boolean get() {
                return true;
            }
        } : aVar.oUY;
        this.oVr = aVar.oVr == null ? hb(aVar.mContext) : aVar.oVr;
        if (aVar.oVs == null) {
            cVar = com.facebook.common.memory.d.ekh();
        } else {
            cVar = aVar.oVs;
        }
        this.oVs = cVar;
        this.oVu = aVar.oVE < 0 ? 30000 : aVar.oVE;
        this.oVt = aVar.oVt == null ? new u(this.oVu) : aVar.oVt;
        this.oRk = aVar.oRk;
        if (aVar.oVv == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.eqJ().eqK());
        } else {
            qVar = aVar.oVv;
        }
        this.oVv = qVar;
        this.oVw = aVar.oVw == null ? new com.facebook.imagepipeline.decoder.f() : aVar.oVw;
        this.oMO = aVar.oMO == null ? new HashSet<>() : aVar.oMO;
        this.oVx = aVar.oVx;
        this.oVy = aVar.oVy == null ? this.oVr : aVar.oVy;
        this.oVz = aVar.oVz;
        this.oRT = aVar.oRT == null ? new com.facebook.imagepipeline.d.a(this.oVv.eqN()) : aVar.oRT;
        this.oVB = aVar.oVB;
        com.facebook.common.g.b eoM = this.oVA.eoM();
        if (eoM != null) {
            a(eoM, this.oVA, new com.facebook.imagepipeline.b.d(eoz()));
        } else if (this.oVA.eoJ() && com.facebook.common.g.c.oLU && (ekz = com.facebook.common.g.c.ekz()) != null) {
            a(ekz, this.oVA, new com.facebook.imagepipeline.b.d(eoz()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.oLX = bVar;
        b.a eoL = iVar.eoL();
        if (eoL != null) {
            bVar.a(eoL);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b hb(Context context) {
        return com.facebook.cache.disk.b.gX(context).ejJ();
    }

    public Bitmap.Config enT() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> eol() {
        return this.oVl;
    }

    public h.a eom() {
        return this.oVm;
    }

    public com.facebook.imagepipeline.c.f eok() {
        return this.oVd;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b eon() {
        return oVC;
    }

    public f eoo() {
        return this.oVo;
    }

    public boolean eop() {
        return this.oVn;
    }

    public boolean eoq() {
        return this.oVB;
    }

    public com.facebook.common.internal.j<q> eor() {
        return this.oVp;
    }

    public e eos() {
        return this.oRT;
    }

    public n eot() {
        return this.oTO;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b eou() {
        return this.oVq;
    }

    public com.facebook.common.internal.j<Boolean> eov() {
        return this.oUY;
    }

    public com.facebook.cache.disk.b eow() {
        return this.oVr;
    }

    public com.facebook.common.memory.c eox() {
        return this.oVs;
    }

    public af eoy() {
        return this.oVt;
    }

    public com.facebook.imagepipeline.memory.q eoz() {
        return this.oVv;
    }

    public com.facebook.imagepipeline.decoder.d eoA() {
        return this.oVw;
    }

    public Set<com.facebook.imagepipeline.h.c> eoB() {
        return Collections.unmodifiableSet(this.oMO);
    }

    public boolean eoC() {
        return this.oVx;
    }

    public com.facebook.cache.disk.b eoD() {
        return this.oVy;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c eoE() {
        return this.oVz;
    }

    public i eoF() {
        return this.oVA;
    }

    public static a hc(Context context) {
        return new a(context);
    }

    /* loaded from: classes18.dex */
    public static class b {
        private boolean oVG;

        private b() {
            this.oVG = false;
        }

        public boolean eoH() {
            return this.oVG;
        }
    }

    /* loaded from: classes18.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> oMO;
        private e oRT;
        private com.facebook.imagepipeline.b.f oRk;
        private n oTO;
        private com.facebook.common.internal.j<Boolean> oUY;
        private boolean oVB;
        private int oVE;
        private final i.a oVF;
        private com.facebook.imagepipeline.c.f oVd;
        private com.facebook.common.internal.j<q> oVl;
        private h.a oVm;
        private boolean oVn;
        private f oVo;
        private com.facebook.common.internal.j<q> oVp;
        private com.facebook.imagepipeline.decoder.b oVq;
        private com.facebook.cache.disk.b oVr;
        private com.facebook.common.memory.c oVs;
        private af oVt;
        private com.facebook.imagepipeline.memory.q oVv;
        private com.facebook.imagepipeline.decoder.d oVw;
        private boolean oVx;
        private com.facebook.cache.disk.b oVy;
        private com.facebook.imagepipeline.decoder.c oVz;

        private a(Context context) {
            this.oVn = false;
            this.oVx = true;
            this.oVE = -1;
            this.oVF = new i.a(this);
            this.oVB = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a Am(boolean z) {
            this.oVn = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.oVs = cVar;
            return this;
        }

        public a a(af afVar) {
            this.oVt = afVar;
            return this;
        }

        public a An(boolean z) {
            this.oVx = z;
            return this;
        }

        public h eoG() {
            return new h(this);
        }
    }
}
