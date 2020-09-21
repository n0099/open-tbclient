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
/* loaded from: classes25.dex */
public class h {
    private static b nFy = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final e nBP;
    @Nullable
    private final com.facebook.imagepipeline.b.f nBg;
    private final n nDK;
    private final com.facebook.common.internal.j<Boolean> nEU;
    private final com.facebook.imagepipeline.c.f nEZ;
    private final com.facebook.common.internal.j<q> nFh;
    private final h.a nFi;
    private final boolean nFj;
    private final f nFk;
    private final com.facebook.common.internal.j<q> nFl;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b nFm;
    private final com.facebook.cache.disk.b nFn;
    private final com.facebook.common.memory.c nFo;
    private final af nFp;
    private final int nFq;
    private final com.facebook.imagepipeline.memory.q nFr;
    private final com.facebook.imagepipeline.decoder.d nFs;
    private final boolean nFt;
    private final com.facebook.cache.disk.b nFu;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c nFv;
    private final i nFw;
    private final boolean nFx;
    private final Set<com.facebook.imagepipeline.h.c> nwJ;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dTb;
        this.nFw = aVar.nFB.dXu();
        this.nFh = aVar.nFh == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.nFh;
        this.nFi = aVar.nFi == null ? new com.facebook.imagepipeline.c.d() : aVar.nFi;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.nEZ == null) {
            fVar = com.facebook.imagepipeline.c.j.dVZ();
        } else {
            fVar = aVar.nEZ;
        }
        this.nEZ = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.nFk = aVar.nFk == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.nFk;
        this.nFj = aVar.nFj;
        this.nFl = aVar.nFl == null ? new com.facebook.imagepipeline.c.k() : aVar.nFl;
        if (aVar.nDK == null) {
            nVar = t.dWi();
        } else {
            nVar = aVar.nDK;
        }
        this.nDK = nVar;
        this.nFm = aVar.nFm;
        this.nEU = aVar.nEU == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dSH */
            public Boolean get() {
                return true;
            }
        } : aVar.nEU;
        this.nFn = aVar.nFn == null ? gA(aVar.mContext) : aVar.nFn;
        if (aVar.nFo == null) {
            cVar = com.facebook.common.memory.d.dSJ();
        } else {
            cVar = aVar.nFo;
        }
        this.nFo = cVar;
        this.nFq = aVar.nFA < 0 ? 30000 : aVar.nFA;
        this.nFp = aVar.nFp == null ? new u(this.nFq) : aVar.nFp;
        this.nBg = aVar.nBg;
        if (aVar.nFr == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dZj().dZk());
        } else {
            qVar = aVar.nFr;
        }
        this.nFr = qVar;
        this.nFs = aVar.nFs == null ? new com.facebook.imagepipeline.decoder.f() : aVar.nFs;
        this.nwJ = aVar.nwJ == null ? new HashSet<>() : aVar.nwJ;
        this.nFt = aVar.nFt;
        this.nFu = aVar.nFu == null ? this.nFn : aVar.nFu;
        this.nFv = aVar.nFv;
        this.nBP = aVar.nBP == null ? new com.facebook.imagepipeline.d.a(this.nFr.dZn()) : aVar.nBP;
        this.nFx = aVar.nFx;
        com.facebook.common.g.b dXm = this.nFw.dXm();
        if (dXm != null) {
            a(dXm, this.nFw, new com.facebook.imagepipeline.b.d(dWZ()));
        } else if (this.nFw.dXj() && com.facebook.common.g.c.nvP && (dTb = com.facebook.common.g.c.dTb()) != null) {
            a(dTb, this.nFw, new com.facebook.imagepipeline.b.d(dWZ()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.nvS = bVar;
        b.a dXl = iVar.dXl();
        if (dXl != null) {
            bVar.a(dXl);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b gA(Context context) {
        return com.facebook.cache.disk.b.gv(context).dSl();
    }

    public Bitmap.Config dWu() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dWL() {
        return this.nFh;
    }

    public h.a dWM() {
        return this.nFi;
    }

    public com.facebook.imagepipeline.c.f dWK() {
        return this.nEZ;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dWN() {
        return nFy;
    }

    public f dWO() {
        return this.nFk;
    }

    public boolean dWP() {
        return this.nFj;
    }

    public boolean dWQ() {
        return this.nFx;
    }

    public com.facebook.common.internal.j<q> dWR() {
        return this.nFl;
    }

    public e dWS() {
        return this.nBP;
    }

    public n dWT() {
        return this.nDK;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dWU() {
        return this.nFm;
    }

    public com.facebook.common.internal.j<Boolean> dWV() {
        return this.nEU;
    }

    public com.facebook.cache.disk.b dWW() {
        return this.nFn;
    }

    public com.facebook.common.memory.c dWX() {
        return this.nFo;
    }

    public af dWY() {
        return this.nFp;
    }

    public com.facebook.imagepipeline.memory.q dWZ() {
        return this.nFr;
    }

    public com.facebook.imagepipeline.decoder.d dXa() {
        return this.nFs;
    }

    public Set<com.facebook.imagepipeline.h.c> dXb() {
        return Collections.unmodifiableSet(this.nwJ);
    }

    public boolean dXc() {
        return this.nFt;
    }

    public com.facebook.cache.disk.b dXd() {
        return this.nFu;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dXe() {
        return this.nFv;
    }

    public i dXf() {
        return this.nFw;
    }

    public static a gB(Context context) {
        return new a(context);
    }

    /* loaded from: classes25.dex */
    public static class b {
        private boolean nFC;

        private b() {
            this.nFC = false;
        }

        public boolean dXh() {
            return this.nFC;
        }
    }

    /* loaded from: classes25.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private e nBP;
        private com.facebook.imagepipeline.b.f nBg;
        private n nDK;
        private com.facebook.common.internal.j<Boolean> nEU;
        private com.facebook.imagepipeline.c.f nEZ;
        private int nFA;
        private final i.a nFB;
        private com.facebook.common.internal.j<q> nFh;
        private h.a nFi;
        private boolean nFj;
        private f nFk;
        private com.facebook.common.internal.j<q> nFl;
        private com.facebook.imagepipeline.decoder.b nFm;
        private com.facebook.cache.disk.b nFn;
        private com.facebook.common.memory.c nFo;
        private af nFp;
        private com.facebook.imagepipeline.memory.q nFr;
        private com.facebook.imagepipeline.decoder.d nFs;
        private boolean nFt;
        private com.facebook.cache.disk.b nFu;
        private com.facebook.imagepipeline.decoder.c nFv;
        private boolean nFx;
        private Set<com.facebook.imagepipeline.h.c> nwJ;

        private a(Context context) {
            this.nFj = false;
            this.nFt = true;
            this.nFA = -1;
            this.nFB = new i.a(this);
            this.nFx = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a ym(boolean z) {
            this.nFj = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.nFo = cVar;
            return this;
        }

        public a a(af afVar) {
            this.nFp = afVar;
            return this;
        }

        public a yn(boolean z) {
            this.nFt = z;
            return this;
        }

        public h dXg() {
            return new h(this);
        }
    }
}
