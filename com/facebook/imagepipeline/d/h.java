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
    private static b oMj = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> oDv;
    @Nullable
    private final com.facebook.imagepipeline.b.f oHR;
    private final e oIA;
    private final n oKv;
    private final com.facebook.common.internal.j<Boolean> oLF;
    private final com.facebook.imagepipeline.c.f oLK;
    private final com.facebook.common.internal.j<q> oLS;
    private final h.a oLT;
    private final boolean oLU;
    private final f oLV;
    private final com.facebook.common.internal.j<q> oLW;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b oLX;
    private final com.facebook.cache.disk.b oLY;
    private final com.facebook.common.memory.c oLZ;
    private final af oMa;
    private final int oMb;
    private final com.facebook.imagepipeline.memory.q oMc;
    private final com.facebook.imagepipeline.decoder.d oMd;
    private final boolean oMe;
    private final com.facebook.cache.disk.b oMf;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c oMg;
    private final i oMh;
    private final boolean oMi;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b egK;
        this.oMh = aVar.oMm.eld();
        this.oLS = aVar.oLS == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.oLS;
        this.oLT = aVar.oLT == null ? new com.facebook.imagepipeline.c.d() : aVar.oLT;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.oLK == null) {
            fVar = com.facebook.imagepipeline.c.j.ejI();
        } else {
            fVar = aVar.oLK;
        }
        this.oLK = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.oLV = aVar.oLV == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.oLV;
        this.oLU = aVar.oLU;
        this.oLW = aVar.oLW == null ? new com.facebook.imagepipeline.c.k() : aVar.oLW;
        if (aVar.oKv == null) {
            nVar = t.ejR();
        } else {
            nVar = aVar.oKv;
        }
        this.oKv = nVar;
        this.oLX = aVar.oLX;
        this.oLF = aVar.oLF == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: egq */
            public Boolean get() {
                return true;
            }
        } : aVar.oLF;
        this.oLY = aVar.oLY == null ? hb(aVar.mContext) : aVar.oLY;
        if (aVar.oLZ == null) {
            cVar = com.facebook.common.memory.d.egs();
        } else {
            cVar = aVar.oLZ;
        }
        this.oLZ = cVar;
        this.oMb = aVar.oMl < 0 ? 30000 : aVar.oMl;
        this.oMa = aVar.oMa == null ? new u(this.oMb) : aVar.oMa;
        this.oHR = aVar.oHR;
        if (aVar.oMc == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.emS().emT());
        } else {
            qVar = aVar.oMc;
        }
        this.oMc = qVar;
        this.oMd = aVar.oMd == null ? new com.facebook.imagepipeline.decoder.f() : aVar.oMd;
        this.oDv = aVar.oDv == null ? new HashSet<>() : aVar.oDv;
        this.oMe = aVar.oMe;
        this.oMf = aVar.oMf == null ? this.oLY : aVar.oMf;
        this.oMg = aVar.oMg;
        this.oIA = aVar.oIA == null ? new com.facebook.imagepipeline.d.a(this.oMc.emW()) : aVar.oIA;
        this.oMi = aVar.oMi;
        com.facebook.common.g.b ekV = this.oMh.ekV();
        if (ekV != null) {
            a(ekV, this.oMh, new com.facebook.imagepipeline.b.d(ekI()));
        } else if (this.oMh.ekS() && com.facebook.common.g.c.oCB && (egK = com.facebook.common.g.c.egK()) != null) {
            a(egK, this.oMh, new com.facebook.imagepipeline.b.d(ekI()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.oCE = bVar;
        b.a ekU = iVar.ekU();
        if (ekU != null) {
            bVar.a(ekU);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b hb(Context context) {
        return com.facebook.cache.disk.b.gX(context).efU();
    }

    public Bitmap.Config ekd() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> eku() {
        return this.oLS;
    }

    public h.a ekv() {
        return this.oLT;
    }

    public com.facebook.imagepipeline.c.f ekt() {
        return this.oLK;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b ekw() {
        return oMj;
    }

    public f ekx() {
        return this.oLV;
    }

    public boolean eky() {
        return this.oLU;
    }

    public boolean ekz() {
        return this.oMi;
    }

    public com.facebook.common.internal.j<q> ekA() {
        return this.oLW;
    }

    public e ekB() {
        return this.oIA;
    }

    public n ekC() {
        return this.oKv;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b ekD() {
        return this.oLX;
    }

    public com.facebook.common.internal.j<Boolean> ekE() {
        return this.oLF;
    }

    public com.facebook.cache.disk.b ekF() {
        return this.oLY;
    }

    public com.facebook.common.memory.c ekG() {
        return this.oLZ;
    }

    public af ekH() {
        return this.oMa;
    }

    public com.facebook.imagepipeline.memory.q ekI() {
        return this.oMc;
    }

    public com.facebook.imagepipeline.decoder.d ekJ() {
        return this.oMd;
    }

    public Set<com.facebook.imagepipeline.h.c> ekK() {
        return Collections.unmodifiableSet(this.oDv);
    }

    public boolean ekL() {
        return this.oMe;
    }

    public com.facebook.cache.disk.b ekM() {
        return this.oMf;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c ekN() {
        return this.oMg;
    }

    public i ekO() {
        return this.oMh;
    }

    public static a hc(Context context) {
        return new a(context);
    }

    /* loaded from: classes18.dex */
    public static class b {
        private boolean oMn;

        private b() {
            this.oMn = false;
        }

        public boolean ekQ() {
            return this.oMn;
        }
    }

    /* loaded from: classes18.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> oDv;
        private com.facebook.imagepipeline.b.f oHR;
        private e oIA;
        private n oKv;
        private com.facebook.common.internal.j<Boolean> oLF;
        private com.facebook.imagepipeline.c.f oLK;
        private com.facebook.common.internal.j<q> oLS;
        private h.a oLT;
        private boolean oLU;
        private f oLV;
        private com.facebook.common.internal.j<q> oLW;
        private com.facebook.imagepipeline.decoder.b oLX;
        private com.facebook.cache.disk.b oLY;
        private com.facebook.common.memory.c oLZ;
        private af oMa;
        private com.facebook.imagepipeline.memory.q oMc;
        private com.facebook.imagepipeline.decoder.d oMd;
        private boolean oMe;
        private com.facebook.cache.disk.b oMf;
        private com.facebook.imagepipeline.decoder.c oMg;
        private boolean oMi;
        private int oMl;
        private final i.a oMm;

        private a(Context context) {
            this.oLU = false;
            this.oMe = true;
            this.oMl = -1;
            this.oMm = new i.a(this);
            this.oMi = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a Ab(boolean z) {
            this.oLU = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.oLZ = cVar;
            return this;
        }

        public a a(af afVar) {
            this.oMa = afVar;
            return this;
        }

        public a Ac(boolean z) {
            this.oMe = z;
            return this;
        }

        public h ekP() {
            return new h(this);
        }
    }
}
