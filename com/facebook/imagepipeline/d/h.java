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
    private static b jHu = new b();
    private final Bitmap.Config FI;
    private final o jFy;
    private final com.facebook.common.internal.i<Boolean> jGT;
    private final com.facebook.imagepipeline.c.f jGm;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d jHc;
    private final com.facebook.common.internal.i<u> jHd;
    private final boolean jHe;
    private final f jHf;
    private final com.facebook.common.internal.i<u> jHg;
    private final e jHh;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b jHi;
    private final com.facebook.cache.disk.b jHj;
    private final com.facebook.common.memory.c jHk;
    private final af jHl;
    @Nullable
    private final com.facebook.imagepipeline.b.f jHm;
    private final q jHn;
    private final com.facebook.imagepipeline.decoder.d jHo;
    private final Set<com.facebook.imagepipeline.g.b> jHp;
    private final boolean jHq;
    private final com.facebook.cache.disk.b jHr;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c jHs;
    private final i jHt;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b ctZ;
        this.jHt = aVar.jHw.cxF();
        this.jHc = aVar.jHc;
        this.jHd = aVar.jHd == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.jHd;
        this.FI = aVar.FI == null ? Bitmap.Config.ARGB_8888 : aVar.FI;
        if (aVar.jGm == null) {
            fVar = com.facebook.imagepipeline.c.j.cwp();
        } else {
            fVar = aVar.jGm;
        }
        this.jGm = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.jHf = aVar.jHf == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.jHf;
        this.jHe = aVar.jHe;
        this.jHg = aVar.jHg == null ? new com.facebook.imagepipeline.c.k() : aVar.jHg;
        if (aVar.jFy == null) {
            oVar = x.cwz();
        } else {
            oVar = aVar.jFy;
        }
        this.jFy = oVar;
        this.jHi = aVar.jHi;
        this.jGT = aVar.jGT == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cxt */
            public Boolean get() {
                return true;
            }
        } : aVar.jGT;
        this.jHj = aVar.jHj == null ? eO(aVar.mContext) : aVar.jHj;
        if (aVar.jHk == null) {
            cVar = com.facebook.common.memory.d.ctB();
        } else {
            cVar = aVar.jHk;
        }
        this.jHk = cVar;
        this.jHl = aVar.jHl == null ? new t() : aVar.jHl;
        this.jHm = aVar.jHm;
        if (aVar.jHn == null) {
            qVar = new q(p.czj().czk());
        } else {
            qVar = aVar.jHn;
        }
        this.jHn = qVar;
        this.jHo = aVar.jHo == null ? new com.facebook.imagepipeline.decoder.f() : aVar.jHo;
        this.jHp = aVar.jHp == null ? new HashSet<>() : aVar.jHp;
        this.jHq = aVar.jHq;
        this.jHr = aVar.jHr == null ? this.jHj : aVar.jHr;
        this.jHs = aVar.jHs;
        this.jHh = aVar.jHh == null ? new com.facebook.imagepipeline.d.a(this.jHn.czn()) : aVar.jHh;
        com.facebook.common.g.b cxE = this.jHt.cxE();
        if (cxE != null) {
            a(cxE, this.jHt, new com.facebook.imagepipeline.b.d(cxm()));
        } else if (this.jHt.cxB() && com.facebook.common.g.c.jAE && (ctZ = com.facebook.common.g.c.ctZ()) != null) {
            a(ctZ, this.jHt, new com.facebook.imagepipeline.b.d(cxm()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.jAH = bVar;
        b.a cxD = iVar.cxD();
        if (cxD != null) {
            bVar.a(cxD);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eO(Context context) {
        return com.facebook.cache.disk.b.eK(context).cth();
    }

    public Bitmap.Config cwK() {
        return this.FI;
    }

    public com.facebook.common.internal.i<u> cxa() {
        return this.jHd;
    }

    public com.facebook.imagepipeline.c.f cwZ() {
        return this.jGm;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cxb() {
        return jHu;
    }

    public f cxc() {
        return this.jHf;
    }

    public boolean cxd() {
        return this.jHe;
    }

    public com.facebook.common.internal.i<u> cxe() {
        return this.jHg;
    }

    public e cxf() {
        return this.jHh;
    }

    public o cxg() {
        return this.jFy;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cxh() {
        return this.jHi;
    }

    public com.facebook.common.internal.i<Boolean> cxi() {
        return this.jGT;
    }

    public com.facebook.cache.disk.b cxj() {
        return this.jHj;
    }

    public com.facebook.common.memory.c cxk() {
        return this.jHk;
    }

    public af cxl() {
        return this.jHl;
    }

    public q cxm() {
        return this.jHn;
    }

    public com.facebook.imagepipeline.decoder.d cxn() {
        return this.jHo;
    }

    public Set<com.facebook.imagepipeline.g.b> cxo() {
        return Collections.unmodifiableSet(this.jHp);
    }

    public boolean cxp() {
        return this.jHq;
    }

    public com.facebook.cache.disk.b cxq() {
        return this.jHr;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cxr() {
        return this.jHs;
    }

    public i cxs() {
        return this.jHt;
    }

    public static a eP(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean jHx;

        private b() {
            this.jHx = false;
        }

        public boolean cxv() {
            return this.jHx;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FI;
        private o jFy;
        private com.facebook.common.internal.i<Boolean> jGT;
        private com.facebook.imagepipeline.c.f jGm;
        private com.facebook.imagepipeline.a.a.d jHc;
        private com.facebook.common.internal.i<u> jHd;
        private boolean jHe;
        private f jHf;
        private com.facebook.common.internal.i<u> jHg;
        private e jHh;
        private com.facebook.imagepipeline.decoder.b jHi;
        private com.facebook.cache.disk.b jHj;
        private com.facebook.common.memory.c jHk;
        private af jHl;
        private com.facebook.imagepipeline.b.f jHm;
        private q jHn;
        private com.facebook.imagepipeline.decoder.d jHo;
        private Set<com.facebook.imagepipeline.g.b> jHp;
        private boolean jHq;
        private com.facebook.cache.disk.b jHr;
        private com.facebook.imagepipeline.decoder.c jHs;
        private final i.a jHw;
        private final Context mContext;

        private a(Context context) {
            this.jHe = false;
            this.jHq = true;
            this.jHw = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cxu() {
            return new h(this);
        }
    }
}
