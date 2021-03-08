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
    private static b pLt = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.g.c> pDb;
    private final e pHW;
    @Nullable
    private final com.facebook.imagepipeline.a.f pHn;
    private final n pJH;
    private final com.facebook.common.internal.j<Boolean> pKP;
    private final com.facebook.imagepipeline.b.f pKU;
    private final com.facebook.common.internal.j<q> pLc;
    private final h.a pLd;
    private final boolean pLe;
    private final f pLf;
    private final com.facebook.common.internal.j<q> pLg;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b pLh;
    private final com.facebook.cache.disk.b pLi;
    private final com.facebook.common.memory.c pLj;
    private final af pLk;
    private final int pLl;
    private final com.facebook.imagepipeline.memory.q pLm;
    private final com.facebook.imagepipeline.decoder.d pLn;
    private final boolean pLo;
    private final com.facebook.cache.disk.b pLp;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c pLq;
    private final i pLr;
    private final boolean pLs;

    private h(a aVar) {
        com.facebook.imagepipeline.b.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b etm;
        this.pLr = aVar.pLw.exB();
        this.pLc = aVar.pLc == null ? new com.facebook.imagepipeline.b.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.pLc;
        this.pLd = aVar.pLd == null ? new com.facebook.imagepipeline.b.d() : aVar.pLd;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.pKU == null) {
            fVar = com.facebook.imagepipeline.b.j.ewh();
        } else {
            fVar = aVar.pKU;
        }
        this.pKU = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.pLf = aVar.pLf == null ? new com.facebook.imagepipeline.c.b(new d()) : aVar.pLf;
        this.pLe = aVar.pLe;
        this.pLg = aVar.pLg == null ? new com.facebook.imagepipeline.b.k() : aVar.pLg;
        if (aVar.pJH == null) {
            nVar = t.ewq();
        } else {
            nVar = aVar.pJH;
        }
        this.pJH = nVar;
        this.pLh = aVar.pLh;
        this.pKP = aVar.pKP == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: esS */
            public Boolean get() {
                return true;
            }
        } : aVar.pKP;
        this.pLi = aVar.pLi == null ? ik(aVar.mContext) : aVar.pLi;
        if (aVar.pLj == null) {
            cVar = com.facebook.common.memory.d.esU();
        } else {
            cVar = aVar.pLj;
        }
        this.pLj = cVar;
        this.pLl = aVar.pLv < 0 ? 30000 : aVar.pLv;
        this.pLk = aVar.pLk == null ? new u(this.pLl) : aVar.pLk;
        this.pHn = aVar.pHn;
        if (aVar.pLm == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.ezm().ezn());
        } else {
            qVar = aVar.pLm;
        }
        this.pLm = qVar;
        this.pLn = aVar.pLn == null ? new com.facebook.imagepipeline.decoder.f() : aVar.pLn;
        this.pDb = aVar.pDb == null ? new HashSet<>() : aVar.pDb;
        this.pLo = aVar.pLo;
        this.pLp = aVar.pLp == null ? this.pLi : aVar.pLp;
        this.pLq = aVar.pLq;
        this.pHW = aVar.pHW == null ? new com.facebook.imagepipeline.c.a(this.pLm.ezq()) : aVar.pHW;
        this.pLs = aVar.pLs;
        com.facebook.common.g.b ext = this.pLr.ext();
        if (ext != null) {
            a(ext, this.pLr, new com.facebook.imagepipeline.a.d(exg()));
        } else if (this.pLr.exq() && com.facebook.common.g.c.pCi && (etm = com.facebook.common.g.c.etm()) != null) {
            a(etm, this.pLr, new com.facebook.imagepipeline.a.d(exg()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.pCl = bVar;
        b.a exs = iVar.exs();
        if (exs != null) {
            bVar.a(exs);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b ik(Context context) {
        return com.facebook.cache.disk.b.ig(context).esx();
    }

    public Bitmap.Config ewB() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> ewS() {
        return this.pLc;
    }

    public h.a ewT() {
        return this.pLd;
    }

    public com.facebook.imagepipeline.b.f ewR() {
        return this.pKU;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b ewU() {
        return pLt;
    }

    public f ewV() {
        return this.pLf;
    }

    public boolean ewW() {
        return this.pLe;
    }

    public boolean ewX() {
        return this.pLs;
    }

    public com.facebook.common.internal.j<q> ewY() {
        return this.pLg;
    }

    public e ewZ() {
        return this.pHW;
    }

    public n exa() {
        return this.pJH;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b exb() {
        return this.pLh;
    }

    public com.facebook.common.internal.j<Boolean> exc() {
        return this.pKP;
    }

    public com.facebook.cache.disk.b exd() {
        return this.pLi;
    }

    public com.facebook.common.memory.c exe() {
        return this.pLj;
    }

    public af exf() {
        return this.pLk;
    }

    public com.facebook.imagepipeline.memory.q exg() {
        return this.pLm;
    }

    public com.facebook.imagepipeline.decoder.d exh() {
        return this.pLn;
    }

    public Set<com.facebook.imagepipeline.g.c> exi() {
        return Collections.unmodifiableSet(this.pDb);
    }

    public boolean exj() {
        return this.pLo;
    }

    public com.facebook.cache.disk.b exk() {
        return this.pLp;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c exl() {
        return this.pLq;
    }

    public i exm() {
        return this.pLr;
    }

    public static a il(Context context) {
        return new a(context);
    }

    /* loaded from: classes5.dex */
    public static class b {
        private boolean pLx;

        private b() {
            this.pLx = false;
        }

        public boolean exo() {
            return this.pLx;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.g.c> pDb;
        private e pHW;
        private com.facebook.imagepipeline.a.f pHn;
        private n pJH;
        private com.facebook.common.internal.j<Boolean> pKP;
        private com.facebook.imagepipeline.b.f pKU;
        private com.facebook.common.internal.j<q> pLc;
        private h.a pLd;
        private boolean pLe;
        private f pLf;
        private com.facebook.common.internal.j<q> pLg;
        private com.facebook.imagepipeline.decoder.b pLh;
        private com.facebook.cache.disk.b pLi;
        private com.facebook.common.memory.c pLj;
        private af pLk;
        private com.facebook.imagepipeline.memory.q pLm;
        private com.facebook.imagepipeline.decoder.d pLn;
        private boolean pLo;
        private com.facebook.cache.disk.b pLp;
        private com.facebook.imagepipeline.decoder.c pLq;
        private boolean pLs;
        private int pLv;
        private final i.a pLw;

        private a(Context context) {
            this.pLe = false;
            this.pLo = true;
            this.pLv = -1;
            this.pLw = new i.a(this);
            this.pLs = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h exn() {
            return new h(this);
        }
    }
}
