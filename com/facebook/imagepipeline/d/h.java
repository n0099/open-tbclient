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
/* loaded from: classes12.dex */
public class h {
    private static b lSz = new b();
    private final Set<com.facebook.imagepipeline.h.c> lJY;
    private final e lOT;
    @Nullable
    private final com.facebook.imagepipeline.b.f lOk;
    private final n lQM;
    private final com.facebook.common.internal.j<Boolean> lRV;
    private final com.facebook.imagepipeline.c.f lSa;
    private final com.facebook.common.internal.j<q> lSi;
    private final h.a lSj;
    private final boolean lSk;
    private final f lSl;
    private final com.facebook.common.internal.j<q> lSm;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b lSn;
    private final com.facebook.cache.disk.b lSo;
    private final com.facebook.common.memory.c lSp;
    private final af lSq;
    private final int lSr;
    private final com.facebook.imagepipeline.memory.q lSs;
    private final com.facebook.imagepipeline.decoder.d lSt;
    private final boolean lSu;
    private final com.facebook.cache.disk.b lSv;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c lSw;
    private final i lSx;
    private final boolean lSy;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dle;
        this.lSx = aVar.lSC.dpv();
        this.lSi = aVar.lSi == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.lSi;
        this.lSj = aVar.lSj == null ? new com.facebook.imagepipeline.c.d() : aVar.lSj;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.lSa == null) {
            fVar = com.facebook.imagepipeline.c.j.dnZ();
        } else {
            fVar = aVar.lSa;
        }
        this.lSa = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.lSl = aVar.lSl == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.lSl;
        this.lSk = aVar.lSk;
        this.lSm = aVar.lSm == null ? new com.facebook.imagepipeline.c.k() : aVar.lSm;
        if (aVar.lQM == null) {
            nVar = t.doi();
        } else {
            nVar = aVar.lQM;
        }
        this.lQM = nVar;
        this.lSn = aVar.lSn;
        this.lRV = aVar.lRV == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dkK */
            public Boolean get() {
                return true;
            }
        } : aVar.lRV;
        this.lSo = aVar.lSo == null ? go(aVar.mContext) : aVar.lSo;
        if (aVar.lSp == null) {
            cVar = com.facebook.common.memory.d.dkM();
        } else {
            cVar = aVar.lSp;
        }
        this.lSp = cVar;
        this.lSr = aVar.lSB < 0 ? 30000 : aVar.lSB;
        this.lSq = aVar.lSq == null ? new u(this.lSr) : aVar.lSq;
        this.lOk = aVar.lOk;
        if (aVar.lSs == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.drl().drm());
        } else {
            qVar = aVar.lSs;
        }
        this.lSs = qVar;
        this.lSt = aVar.lSt == null ? new com.facebook.imagepipeline.decoder.f() : aVar.lSt;
        this.lJY = aVar.lJY == null ? new HashSet<>() : aVar.lJY;
        this.lSu = aVar.lSu;
        this.lSv = aVar.lSv == null ? this.lSo : aVar.lSv;
        this.lSw = aVar.lSw;
        this.lOT = aVar.lOT == null ? new com.facebook.imagepipeline.d.a(this.lSs.drp()) : aVar.lOT;
        this.lSy = aVar.lSy;
        com.facebook.common.g.b dpn = this.lSx.dpn();
        if (dpn != null) {
            a(dpn, this.lSx, new com.facebook.imagepipeline.b.d(dpa()));
        } else if (this.lSx.dpk() && com.facebook.common.g.c.lJe && (dle = com.facebook.common.g.c.dle()) != null) {
            a(dle, this.lSx, new com.facebook.imagepipeline.b.d(dpa()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.lJg = bVar;
        b.a dpm = iVar.dpm();
        if (dpm != null) {
            bVar.a(dpm);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b go(Context context) {
        return com.facebook.cache.disk.b.gj(context).dko();
    }

    public Bitmap.Config dou() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> doM() {
        return this.lSi;
    }

    public h.a doN() {
        return this.lSj;
    }

    public com.facebook.imagepipeline.c.f doL() {
        return this.lSa;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b doO() {
        return lSz;
    }

    public f doP() {
        return this.lSl;
    }

    public boolean doQ() {
        return this.lSk;
    }

    public boolean doR() {
        return this.lSy;
    }

    public com.facebook.common.internal.j<q> doS() {
        return this.lSm;
    }

    public e doT() {
        return this.lOT;
    }

    public n doU() {
        return this.lQM;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b doV() {
        return this.lSn;
    }

    public com.facebook.common.internal.j<Boolean> doW() {
        return this.lRV;
    }

    public com.facebook.cache.disk.b doX() {
        return this.lSo;
    }

    public com.facebook.common.memory.c doY() {
        return this.lSp;
    }

    public af doZ() {
        return this.lSq;
    }

    public com.facebook.imagepipeline.memory.q dpa() {
        return this.lSs;
    }

    public com.facebook.imagepipeline.decoder.d dpb() {
        return this.lSt;
    }

    public Set<com.facebook.imagepipeline.h.c> dpc() {
        return Collections.unmodifiableSet(this.lJY);
    }

    public boolean dpd() {
        return this.lSu;
    }

    public com.facebook.cache.disk.b dpe() {
        return this.lSv;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dpf() {
        return this.lSw;
    }

    public i dpg() {
        return this.lSx;
    }

    public static a gn(Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class b {
        private boolean lSD;

        private b() {
            this.lSD = false;
        }

        public boolean dpi() {
            return this.lSD;
        }
    }

    /* loaded from: classes12.dex */
    public static class a {
        private Set<com.facebook.imagepipeline.h.c> lJY;
        private e lOT;
        private com.facebook.imagepipeline.b.f lOk;
        private n lQM;
        private com.facebook.common.internal.j<Boolean> lRV;
        private int lSB;
        private final i.a lSC;
        private com.facebook.imagepipeline.c.f lSa;
        private com.facebook.common.internal.j<q> lSi;
        private h.a lSj;
        private boolean lSk;
        private f lSl;
        private com.facebook.common.internal.j<q> lSm;
        private com.facebook.imagepipeline.decoder.b lSn;
        private com.facebook.cache.disk.b lSo;
        private com.facebook.common.memory.c lSp;
        private af lSq;
        private com.facebook.imagepipeline.memory.q lSs;
        private com.facebook.imagepipeline.decoder.d lSt;
        private boolean lSu;
        private com.facebook.cache.disk.b lSv;
        private com.facebook.imagepipeline.decoder.c lSw;
        private boolean lSy;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;

        private a(Context context) {
            this.lSk = false;
            this.lSu = true;
            this.lSB = -1;
            this.lSC = new i.a(this);
            this.lSy = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a c(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a b(com.facebook.common.internal.j<q> jVar) {
            this.lSi = (com.facebook.common.internal.j) com.facebook.common.internal.g.checkNotNull(jVar);
            return this;
        }

        public a vp(boolean z) {
            this.lSk = z;
            return this;
        }

        public a c(com.facebook.cache.disk.b bVar) {
            this.lSo = bVar;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.lSp = cVar;
            return this;
        }

        public a a(af afVar) {
            this.lSq = afVar;
            return this;
        }

        public a vq(boolean z) {
            this.lSu = z;
            return this;
        }

        public h dph() {
            return new h(this);
        }
    }
}
