package com.facebook.imagepipeline.d;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.o;
import com.facebook.imagepipeline.c.u;
import com.facebook.imagepipeline.c.x;
import com.facebook.imagepipeline.d.i;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.memory.q;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.t;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class h {
    private static b jZR = new b();
    private final Bitmap.Config Dr;
    private final o jXV;
    private final com.facebook.imagepipeline.c.f jYJ;
    private final com.facebook.common.internal.i<u> jZA;
    private final boolean jZB;
    private final f jZC;
    private final com.facebook.common.internal.i<u> jZD;
    private final e jZE;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b jZF;
    private final com.facebook.cache.disk.b jZG;
    private final com.facebook.common.memory.c jZH;
    private final af jZI;
    @Nullable
    private final com.facebook.imagepipeline.b.f jZJ;
    private final q jZK;
    private final com.facebook.imagepipeline.decoder.d jZL;
    private final Set<com.facebook.imagepipeline.g.b> jZM;
    private final boolean jZN;
    private final com.facebook.cache.disk.b jZO;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c jZP;
    private final i jZQ;
    private final com.facebook.common.internal.i<Boolean> jZq;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d jZz;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cCc;
        this.jZQ = aVar.jZT.cFI();
        this.jZz = aVar.jZz;
        this.jZA = aVar.jZA == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.jZA;
        this.Dr = aVar.Dr == null ? Bitmap.Config.ARGB_8888 : aVar.Dr;
        if (aVar.jYJ == null) {
            fVar = com.facebook.imagepipeline.c.j.cEs();
        } else {
            fVar = aVar.jYJ;
        }
        this.jYJ = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.jZC = aVar.jZC == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.jZC;
        this.jZB = aVar.jZB;
        this.jZD = aVar.jZD == null ? new com.facebook.imagepipeline.c.k() : aVar.jZD;
        if (aVar.jXV == null) {
            oVar = x.cEC();
        } else {
            oVar = aVar.jXV;
        }
        this.jXV = oVar;
        this.jZF = aVar.jZF;
        this.jZq = aVar.jZq == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cFw */
            public Boolean get() {
                return true;
            }
        } : aVar.jZq;
        this.jZG = aVar.jZG == null ? eC(aVar.mContext) : aVar.jZG;
        if (aVar.jZH == null) {
            cVar = com.facebook.common.memory.d.cBF();
        } else {
            cVar = aVar.jZH;
        }
        this.jZH = cVar;
        this.jZI = aVar.jZI == null ? new t() : aVar.jZI;
        this.jZJ = aVar.jZJ;
        if (aVar.jZK == null) {
            qVar = new q(p.cHm().cHn());
        } else {
            qVar = aVar.jZK;
        }
        this.jZK = qVar;
        this.jZL = aVar.jZL == null ? new com.facebook.imagepipeline.decoder.f() : aVar.jZL;
        this.jZM = aVar.jZM == null ? new HashSet<>() : aVar.jZM;
        this.jZN = aVar.jZN;
        this.jZO = aVar.jZO == null ? this.jZG : aVar.jZO;
        this.jZP = aVar.jZP;
        this.jZE = aVar.jZE == null ? new com.facebook.imagepipeline.d.a(this.jZK.cHq()) : aVar.jZE;
        com.facebook.common.g.b cFH = this.jZQ.cFH();
        if (cFH != null) {
            a(cFH, this.jZQ, new com.facebook.imagepipeline.b.d(cFp()));
        } else if (this.jZQ.cFE() && com.facebook.common.g.c.jTd && (cCc = com.facebook.common.g.c.cCc()) != null) {
            a(cCc, this.jZQ, new com.facebook.imagepipeline.b.d(cFp()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.jTg = bVar;
        b.a cFG = iVar.cFG();
        if (cFG != null) {
            bVar.a(cFG);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eC(Context context) {
        return com.facebook.cache.disk.b.ey(context).cBl();
    }

    public Bitmap.Config cEN() {
        return this.Dr;
    }

    public com.facebook.common.internal.i<u> cFd() {
        return this.jZA;
    }

    public com.facebook.imagepipeline.c.f cFc() {
        return this.jYJ;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cFe() {
        return jZR;
    }

    public f cFf() {
        return this.jZC;
    }

    public boolean cFg() {
        return this.jZB;
    }

    public com.facebook.common.internal.i<u> cFh() {
        return this.jZD;
    }

    public e cFi() {
        return this.jZE;
    }

    public o cFj() {
        return this.jXV;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cFk() {
        return this.jZF;
    }

    public com.facebook.common.internal.i<Boolean> cFl() {
        return this.jZq;
    }

    public com.facebook.cache.disk.b cFm() {
        return this.jZG;
    }

    public com.facebook.common.memory.c cFn() {
        return this.jZH;
    }

    public af cFo() {
        return this.jZI;
    }

    public q cFp() {
        return this.jZK;
    }

    public com.facebook.imagepipeline.decoder.d cFq() {
        return this.jZL;
    }

    public Set<com.facebook.imagepipeline.g.b> cFr() {
        return Collections.unmodifiableSet(this.jZM);
    }

    public boolean cFs() {
        return this.jZN;
    }

    public com.facebook.cache.disk.b cFt() {
        return this.jZO;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cFu() {
        return this.jZP;
    }

    public i cFv() {
        return this.jZQ;
    }

    public static a eD(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean jZU;

        private b() {
            this.jZU = false;
        }

        public boolean cFy() {
            return this.jZU;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config Dr;
        private o jXV;
        private com.facebook.imagepipeline.c.f jYJ;
        private com.facebook.common.internal.i<u> jZA;
        private boolean jZB;
        private f jZC;
        private com.facebook.common.internal.i<u> jZD;
        private e jZE;
        private com.facebook.imagepipeline.decoder.b jZF;
        private com.facebook.cache.disk.b jZG;
        private com.facebook.common.memory.c jZH;
        private af jZI;
        private com.facebook.imagepipeline.b.f jZJ;
        private q jZK;
        private com.facebook.imagepipeline.decoder.d jZL;
        private Set<com.facebook.imagepipeline.g.b> jZM;
        private boolean jZN;
        private com.facebook.cache.disk.b jZO;
        private com.facebook.imagepipeline.decoder.c jZP;
        private final i.a jZT;
        private com.facebook.common.internal.i<Boolean> jZq;
        private com.facebook.imagepipeline.a.a.d jZz;
        private final Context mContext;

        private a(Context context) {
            this.jZB = false;
            this.jZN = true;
            this.jZT = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cFx() {
            return new h(this);
        }
    }
}
