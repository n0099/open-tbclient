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
    private static b pJo = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.g.c> pAW;
    private final e pFR;
    @Nullable
    private final com.facebook.imagepipeline.a.f pFi;
    private final n pHC;
    private final com.facebook.common.internal.j<Boolean> pIK;
    private final com.facebook.imagepipeline.b.f pIP;
    private final com.facebook.common.internal.j<q> pIX;
    private final h.a pIY;
    private final boolean pIZ;
    private final f pJa;
    private final com.facebook.common.internal.j<q> pJb;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b pJc;
    private final com.facebook.cache.disk.b pJd;
    private final com.facebook.common.memory.c pJe;
    private final af pJf;
    private final int pJg;
    private final com.facebook.imagepipeline.memory.q pJh;
    private final com.facebook.imagepipeline.decoder.d pJi;
    private final boolean pJj;
    private final com.facebook.cache.disk.b pJk;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c pJl;
    private final i pJm;
    private final boolean pJn;

    private h(a aVar) {
        com.facebook.imagepipeline.b.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b etd;
        this.pJm = aVar.pJr.exs();
        this.pIX = aVar.pIX == null ? new com.facebook.imagepipeline.b.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.pIX;
        this.pIY = aVar.pIY == null ? new com.facebook.imagepipeline.b.d() : aVar.pIY;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.pIP == null) {
            fVar = com.facebook.imagepipeline.b.j.evY();
        } else {
            fVar = aVar.pIP;
        }
        this.pIP = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.pJa = aVar.pJa == null ? new com.facebook.imagepipeline.c.b(new d()) : aVar.pJa;
        this.pIZ = aVar.pIZ;
        this.pJb = aVar.pJb == null ? new com.facebook.imagepipeline.b.k() : aVar.pJb;
        if (aVar.pHC == null) {
            nVar = t.ewh();
        } else {
            nVar = aVar.pHC;
        }
        this.pHC = nVar;
        this.pJc = aVar.pJc;
        this.pIK = aVar.pIK == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: esJ */
            public Boolean get() {
                return true;
            }
        } : aVar.pIK;
        this.pJd = aVar.pJd == null ? il(aVar.mContext) : aVar.pJd;
        if (aVar.pJe == null) {
            cVar = com.facebook.common.memory.d.esL();
        } else {
            cVar = aVar.pJe;
        }
        this.pJe = cVar;
        this.pJg = aVar.pJq < 0 ? 30000 : aVar.pJq;
        this.pJf = aVar.pJf == null ? new u(this.pJg) : aVar.pJf;
        this.pFi = aVar.pFi;
        if (aVar.pJh == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.ezd().eze());
        } else {
            qVar = aVar.pJh;
        }
        this.pJh = qVar;
        this.pJi = aVar.pJi == null ? new com.facebook.imagepipeline.decoder.f() : aVar.pJi;
        this.pAW = aVar.pAW == null ? new HashSet<>() : aVar.pAW;
        this.pJj = aVar.pJj;
        this.pJk = aVar.pJk == null ? this.pJd : aVar.pJk;
        this.pJl = aVar.pJl;
        this.pFR = aVar.pFR == null ? new com.facebook.imagepipeline.c.a(this.pJh.ezh()) : aVar.pFR;
        this.pJn = aVar.pJn;
        com.facebook.common.g.b exk = this.pJm.exk();
        if (exk != null) {
            a(exk, this.pJm, new com.facebook.imagepipeline.a.d(ewX()));
        } else if (this.pJm.exh() && com.facebook.common.g.c.pAd && (etd = com.facebook.common.g.c.etd()) != null) {
            a(etd, this.pJm, new com.facebook.imagepipeline.a.d(ewX()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.pAg = bVar;
        b.a exj = iVar.exj();
        if (exj != null) {
            bVar.a(exj);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b il(Context context) {
        return com.facebook.cache.disk.b.ih(context).eso();
    }

    public Bitmap.Config ews() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> ewJ() {
        return this.pIX;
    }

    public h.a ewK() {
        return this.pIY;
    }

    public com.facebook.imagepipeline.b.f ewI() {
        return this.pIP;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b ewL() {
        return pJo;
    }

    public f ewM() {
        return this.pJa;
    }

    public boolean ewN() {
        return this.pIZ;
    }

    public boolean ewO() {
        return this.pJn;
    }

    public com.facebook.common.internal.j<q> ewP() {
        return this.pJb;
    }

    public e ewQ() {
        return this.pFR;
    }

    public n ewR() {
        return this.pHC;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b ewS() {
        return this.pJc;
    }

    public com.facebook.common.internal.j<Boolean> ewT() {
        return this.pIK;
    }

    public com.facebook.cache.disk.b ewU() {
        return this.pJd;
    }

    public com.facebook.common.memory.c ewV() {
        return this.pJe;
    }

    public af ewW() {
        return this.pJf;
    }

    public com.facebook.imagepipeline.memory.q ewX() {
        return this.pJh;
    }

    public com.facebook.imagepipeline.decoder.d ewY() {
        return this.pJi;
    }

    public Set<com.facebook.imagepipeline.g.c> ewZ() {
        return Collections.unmodifiableSet(this.pAW);
    }

    public boolean exa() {
        return this.pJj;
    }

    public com.facebook.cache.disk.b exb() {
        return this.pJk;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c exc() {
        return this.pJl;
    }

    public i exd() {
        return this.pJm;
    }

    public static a im(Context context) {
        return new a(context);
    }

    /* loaded from: classes5.dex */
    public static class b {
        private boolean pJs;

        private b() {
            this.pJs = false;
        }

        public boolean exf() {
            return this.pJs;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.g.c> pAW;
        private e pFR;
        private com.facebook.imagepipeline.a.f pFi;
        private n pHC;
        private com.facebook.common.internal.j<Boolean> pIK;
        private com.facebook.imagepipeline.b.f pIP;
        private com.facebook.common.internal.j<q> pIX;
        private h.a pIY;
        private boolean pIZ;
        private f pJa;
        private com.facebook.common.internal.j<q> pJb;
        private com.facebook.imagepipeline.decoder.b pJc;
        private com.facebook.cache.disk.b pJd;
        private com.facebook.common.memory.c pJe;
        private af pJf;
        private com.facebook.imagepipeline.memory.q pJh;
        private com.facebook.imagepipeline.decoder.d pJi;
        private boolean pJj;
        private com.facebook.cache.disk.b pJk;
        private com.facebook.imagepipeline.decoder.c pJl;
        private boolean pJn;
        private int pJq;
        private final i.a pJr;

        private a(Context context) {
            this.pIZ = false;
            this.pJj = true;
            this.pJq = -1;
            this.pJr = new i.a(this);
            this.pJn = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h exe() {
            return new h(this);
        }
    }
}
