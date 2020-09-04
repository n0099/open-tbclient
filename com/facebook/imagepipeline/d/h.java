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
/* loaded from: classes8.dex */
public class h {
    private static b nvB = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> nmJ;
    private final e nrR;
    @Nullable
    private final com.facebook.imagepipeline.b.f nri;
    private final n ntM;
    private final com.facebook.common.internal.j<Boolean> nuX;
    private final boolean nvA;
    private final com.facebook.imagepipeline.c.f nvc;
    private final com.facebook.common.internal.j<q> nvk;
    private final h.a nvl;
    private final boolean nvm;
    private final f nvn;
    private final com.facebook.common.internal.j<q> nvo;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b nvp;
    private final com.facebook.cache.disk.b nvq;
    private final com.facebook.common.memory.c nvr;
    private final af nvs;
    private final int nvt;
    private final com.facebook.imagepipeline.memory.q nvu;
    private final com.facebook.imagepipeline.decoder.d nvv;
    private final boolean nvw;
    private final com.facebook.cache.disk.b nvx;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c nvy;
    private final i nvz;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dPd;
        this.nvz = aVar.nvE.dTw();
        this.nvk = aVar.nvk == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.nvk;
        this.nvl = aVar.nvl == null ? new com.facebook.imagepipeline.c.d() : aVar.nvl;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.nvc == null) {
            fVar = com.facebook.imagepipeline.c.j.dSb();
        } else {
            fVar = aVar.nvc;
        }
        this.nvc = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.nvn = aVar.nvn == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.nvn;
        this.nvm = aVar.nvm;
        this.nvo = aVar.nvo == null ? new com.facebook.imagepipeline.c.k() : aVar.nvo;
        if (aVar.ntM == null) {
            nVar = t.dSk();
        } else {
            nVar = aVar.ntM;
        }
        this.ntM = nVar;
        this.nvp = aVar.nvp;
        this.nuX = aVar.nuX == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dOJ */
            public Boolean get() {
                return true;
            }
        } : aVar.nuX;
        this.nvq = aVar.nvq == null ? gt(aVar.mContext) : aVar.nvq;
        if (aVar.nvr == null) {
            cVar = com.facebook.common.memory.d.dOL();
        } else {
            cVar = aVar.nvr;
        }
        this.nvr = cVar;
        this.nvt = aVar.nvD < 0 ? 30000 : aVar.nvD;
        this.nvs = aVar.nvs == null ? new u(this.nvt) : aVar.nvs;
        this.nri = aVar.nri;
        if (aVar.nvu == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dVl().dVm());
        } else {
            qVar = aVar.nvu;
        }
        this.nvu = qVar;
        this.nvv = aVar.nvv == null ? new com.facebook.imagepipeline.decoder.f() : aVar.nvv;
        this.nmJ = aVar.nmJ == null ? new HashSet<>() : aVar.nmJ;
        this.nvw = aVar.nvw;
        this.nvx = aVar.nvx == null ? this.nvq : aVar.nvx;
        this.nvy = aVar.nvy;
        this.nrR = aVar.nrR == null ? new com.facebook.imagepipeline.d.a(this.nvu.dVp()) : aVar.nrR;
        this.nvA = aVar.nvA;
        com.facebook.common.g.b dTo = this.nvz.dTo();
        if (dTo != null) {
            a(dTo, this.nvz, new com.facebook.imagepipeline.b.d(dTb()));
        } else if (this.nvz.dTl() && com.facebook.common.g.c.nlP && (dPd = com.facebook.common.g.c.dPd()) != null) {
            a(dPd, this.nvz, new com.facebook.imagepipeline.b.d(dTb()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.nlS = bVar;
        b.a dTn = iVar.dTn();
        if (dTn != null) {
            bVar.a(dTn);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b gt(Context context) {
        return com.facebook.cache.disk.b.gp(context).dOn();
    }

    public Bitmap.Config dSw() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dSN() {
        return this.nvk;
    }

    public h.a dSO() {
        return this.nvl;
    }

    public com.facebook.imagepipeline.c.f dSM() {
        return this.nvc;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dSP() {
        return nvB;
    }

    public f dSQ() {
        return this.nvn;
    }

    public boolean dSR() {
        return this.nvm;
    }

    public boolean dSS() {
        return this.nvA;
    }

    public com.facebook.common.internal.j<q> dST() {
        return this.nvo;
    }

    public e dSU() {
        return this.nrR;
    }

    public n dSV() {
        return this.ntM;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dSW() {
        return this.nvp;
    }

    public com.facebook.common.internal.j<Boolean> dSX() {
        return this.nuX;
    }

    public com.facebook.cache.disk.b dSY() {
        return this.nvq;
    }

    public com.facebook.common.memory.c dSZ() {
        return this.nvr;
    }

    public af dTa() {
        return this.nvs;
    }

    public com.facebook.imagepipeline.memory.q dTb() {
        return this.nvu;
    }

    public com.facebook.imagepipeline.decoder.d dTc() {
        return this.nvv;
    }

    public Set<com.facebook.imagepipeline.h.c> dTd() {
        return Collections.unmodifiableSet(this.nmJ);
    }

    public boolean dTe() {
        return this.nvw;
    }

    public com.facebook.cache.disk.b dTf() {
        return this.nvx;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dTg() {
        return this.nvy;
    }

    public i dTh() {
        return this.nvz;
    }

    public static a gu(Context context) {
        return new a(context);
    }

    /* loaded from: classes8.dex */
    public static class b {
        private boolean nvF;

        private b() {
            this.nvF = false;
        }

        public boolean dTj() {
            return this.nvF;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> nmJ;
        private e nrR;
        private com.facebook.imagepipeline.b.f nri;
        private n ntM;
        private com.facebook.common.internal.j<Boolean> nuX;
        private boolean nvA;
        private int nvD;
        private final i.a nvE;
        private com.facebook.imagepipeline.c.f nvc;
        private com.facebook.common.internal.j<q> nvk;
        private h.a nvl;
        private boolean nvm;
        private f nvn;
        private com.facebook.common.internal.j<q> nvo;
        private com.facebook.imagepipeline.decoder.b nvp;
        private com.facebook.cache.disk.b nvq;
        private com.facebook.common.memory.c nvr;
        private af nvs;
        private com.facebook.imagepipeline.memory.q nvu;
        private com.facebook.imagepipeline.decoder.d nvv;
        private boolean nvw;
        private com.facebook.cache.disk.b nvx;
        private com.facebook.imagepipeline.decoder.c nvy;

        private a(Context context) {
            this.nvm = false;
            this.nvw = true;
            this.nvD = -1;
            this.nvE = new i.a(this);
            this.nvA = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a yd(boolean z) {
            this.nvm = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.nvr = cVar;
            return this;
        }

        public a a(af afVar) {
            this.nvs = afVar;
            return this;
        }

        public a ye(boolean z) {
            this.nvw = z;
            return this;
        }

        public h dTi() {
            return new h(this);
        }
    }
}
