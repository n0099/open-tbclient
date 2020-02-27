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
    private static b lSx = new b();
    private final Set<com.facebook.imagepipeline.h.c> lJW;
    private final e lOR;
    @Nullable
    private final com.facebook.imagepipeline.b.f lOi;
    private final n lQK;
    private final com.facebook.common.internal.j<Boolean> lRT;
    private final com.facebook.imagepipeline.c.f lRY;
    private final com.facebook.common.internal.j<q> lSg;
    private final h.a lSh;
    private final boolean lSi;
    private final f lSj;
    private final com.facebook.common.internal.j<q> lSk;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b lSl;
    private final com.facebook.cache.disk.b lSm;
    private final com.facebook.common.memory.c lSn;
    private final af lSo;
    private final int lSp;
    private final com.facebook.imagepipeline.memory.q lSq;
    private final com.facebook.imagepipeline.decoder.d lSr;
    private final boolean lSs;
    private final com.facebook.cache.disk.b lSt;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c lSu;
    private final i lSv;
    private final boolean lSw;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dlc;
        this.lSv = aVar.lSA.dpt();
        this.lSg = aVar.lSg == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.lSg;
        this.lSh = aVar.lSh == null ? new com.facebook.imagepipeline.c.d() : aVar.lSh;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.lRY == null) {
            fVar = com.facebook.imagepipeline.c.j.dnX();
        } else {
            fVar = aVar.lRY;
        }
        this.lRY = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.lSj = aVar.lSj == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.lSj;
        this.lSi = aVar.lSi;
        this.lSk = aVar.lSk == null ? new com.facebook.imagepipeline.c.k() : aVar.lSk;
        if (aVar.lQK == null) {
            nVar = t.dog();
        } else {
            nVar = aVar.lQK;
        }
        this.lQK = nVar;
        this.lSl = aVar.lSl;
        this.lRT = aVar.lRT == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dkI */
            public Boolean get() {
                return true;
            }
        } : aVar.lRT;
        this.lSm = aVar.lSm == null ? go(aVar.mContext) : aVar.lSm;
        if (aVar.lSn == null) {
            cVar = com.facebook.common.memory.d.dkK();
        } else {
            cVar = aVar.lSn;
        }
        this.lSn = cVar;
        this.lSp = aVar.lSz < 0 ? 30000 : aVar.lSz;
        this.lSo = aVar.lSo == null ? new u(this.lSp) : aVar.lSo;
        this.lOi = aVar.lOi;
        if (aVar.lSq == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.drj().drk());
        } else {
            qVar = aVar.lSq;
        }
        this.lSq = qVar;
        this.lSr = aVar.lSr == null ? new com.facebook.imagepipeline.decoder.f() : aVar.lSr;
        this.lJW = aVar.lJW == null ? new HashSet<>() : aVar.lJW;
        this.lSs = aVar.lSs;
        this.lSt = aVar.lSt == null ? this.lSm : aVar.lSt;
        this.lSu = aVar.lSu;
        this.lOR = aVar.lOR == null ? new com.facebook.imagepipeline.d.a(this.lSq.drn()) : aVar.lOR;
        this.lSw = aVar.lSw;
        com.facebook.common.g.b dpl = this.lSv.dpl();
        if (dpl != null) {
            a(dpl, this.lSv, new com.facebook.imagepipeline.b.d(doY()));
        } else if (this.lSv.dpi() && com.facebook.common.g.c.lJc && (dlc = com.facebook.common.g.c.dlc()) != null) {
            a(dlc, this.lSv, new com.facebook.imagepipeline.b.d(doY()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.lJe = bVar;
        b.a dpk = iVar.dpk();
        if (dpk != null) {
            bVar.a(dpk);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b go(Context context) {
        return com.facebook.cache.disk.b.gj(context).dkm();
    }

    public Bitmap.Config dos() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> doK() {
        return this.lSg;
    }

    public h.a doL() {
        return this.lSh;
    }

    public com.facebook.imagepipeline.c.f doJ() {
        return this.lRY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b doM() {
        return lSx;
    }

    public f doN() {
        return this.lSj;
    }

    public boolean doO() {
        return this.lSi;
    }

    public boolean doP() {
        return this.lSw;
    }

    public com.facebook.common.internal.j<q> doQ() {
        return this.lSk;
    }

    public e doR() {
        return this.lOR;
    }

    public n doS() {
        return this.lQK;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b doT() {
        return this.lSl;
    }

    public com.facebook.common.internal.j<Boolean> doU() {
        return this.lRT;
    }

    public com.facebook.cache.disk.b doV() {
        return this.lSm;
    }

    public com.facebook.common.memory.c doW() {
        return this.lSn;
    }

    public af doX() {
        return this.lSo;
    }

    public com.facebook.imagepipeline.memory.q doY() {
        return this.lSq;
    }

    public com.facebook.imagepipeline.decoder.d doZ() {
        return this.lSr;
    }

    public Set<com.facebook.imagepipeline.h.c> dpa() {
        return Collections.unmodifiableSet(this.lJW);
    }

    public boolean dpb() {
        return this.lSs;
    }

    public com.facebook.cache.disk.b dpc() {
        return this.lSt;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dpd() {
        return this.lSu;
    }

    public i dpe() {
        return this.lSv;
    }

    public static a gn(Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class b {
        private boolean lSB;

        private b() {
            this.lSB = false;
        }

        public boolean dpg() {
            return this.lSB;
        }
    }

    /* loaded from: classes12.dex */
    public static class a {
        private Set<com.facebook.imagepipeline.h.c> lJW;
        private e lOR;
        private com.facebook.imagepipeline.b.f lOi;
        private n lQK;
        private com.facebook.common.internal.j<Boolean> lRT;
        private com.facebook.imagepipeline.c.f lRY;
        private final i.a lSA;
        private com.facebook.common.internal.j<q> lSg;
        private h.a lSh;
        private boolean lSi;
        private f lSj;
        private com.facebook.common.internal.j<q> lSk;
        private com.facebook.imagepipeline.decoder.b lSl;
        private com.facebook.cache.disk.b lSm;
        private com.facebook.common.memory.c lSn;
        private af lSo;
        private com.facebook.imagepipeline.memory.q lSq;
        private com.facebook.imagepipeline.decoder.d lSr;
        private boolean lSs;
        private com.facebook.cache.disk.b lSt;
        private com.facebook.imagepipeline.decoder.c lSu;
        private boolean lSw;
        private int lSz;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;

        private a(Context context) {
            this.lSi = false;
            this.lSs = true;
            this.lSz = -1;
            this.lSA = new i.a(this);
            this.lSw = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a c(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a b(com.facebook.common.internal.j<q> jVar) {
            this.lSg = (com.facebook.common.internal.j) com.facebook.common.internal.g.checkNotNull(jVar);
            return this;
        }

        public a vp(boolean z) {
            this.lSi = z;
            return this;
        }

        public a c(com.facebook.cache.disk.b bVar) {
            this.lSm = bVar;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.lSn = cVar;
            return this;
        }

        public a a(af afVar) {
            this.lSo = afVar;
            return this;
        }

        public a vq(boolean z) {
            this.lSs = z;
            return this;
        }

        public h dpf() {
            return new h(this);
        }
    }
}
