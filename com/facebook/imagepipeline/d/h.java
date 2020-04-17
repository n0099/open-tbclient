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
    private static b mcd = new b();
    private final Set<com.facebook.imagepipeline.h.c> lTj;
    @Nullable
    private final com.facebook.imagepipeline.b.f lXG;
    private final e lYp;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final n man;
    private final com.facebook.imagepipeline.c.f mbE;
    private final com.facebook.common.internal.j<q> mbM;
    private final h.a mbN;
    private final boolean mbO;
    private final f mbP;
    private final com.facebook.common.internal.j<q> mbQ;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b mbR;
    private final com.facebook.cache.disk.b mbS;
    private final com.facebook.common.memory.c mbT;
    private final af mbU;
    private final int mbV;
    private final com.facebook.imagepipeline.memory.q mbW;
    private final com.facebook.imagepipeline.decoder.d mbX;
    private final boolean mbY;
    private final com.facebook.cache.disk.b mbZ;
    private final com.facebook.common.internal.j<Boolean> mbz;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c mca;
    private final i mcb;
    private final boolean mcc;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dnw;
        this.mcb = aVar.mcg.drR();
        this.mbM = aVar.mbM == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.mbM;
        this.mbN = aVar.mbN == null ? new com.facebook.imagepipeline.c.d() : aVar.mbN;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.mbE == null) {
            fVar = com.facebook.imagepipeline.c.j.dqw();
        } else {
            fVar = aVar.mbE;
        }
        this.mbE = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.mbP = aVar.mbP == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.mbP;
        this.mbO = aVar.mbO;
        this.mbQ = aVar.mbQ == null ? new com.facebook.imagepipeline.c.k() : aVar.mbQ;
        if (aVar.man == null) {
            nVar = t.dqF();
        } else {
            nVar = aVar.man;
        }
        this.man = nVar;
        this.mbR = aVar.mbR;
        this.mbz = aVar.mbz == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dnb */
            public Boolean get() {
                return true;
            }
        } : aVar.mbz;
        this.mbS = aVar.mbS == null ? fQ(aVar.mContext) : aVar.mbS;
        if (aVar.mbT == null) {
            cVar = com.facebook.common.memory.d.dnd();
        } else {
            cVar = aVar.mbT;
        }
        this.mbT = cVar;
        this.mbV = aVar.mcf < 0 ? 30000 : aVar.mcf;
        this.mbU = aVar.mbU == null ? new u(this.mbV) : aVar.mbU;
        this.lXG = aVar.lXG;
        if (aVar.mbW == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dtH().dtI());
        } else {
            qVar = aVar.mbW;
        }
        this.mbW = qVar;
        this.mbX = aVar.mbX == null ? new com.facebook.imagepipeline.decoder.f() : aVar.mbX;
        this.lTj = aVar.lTj == null ? new HashSet<>() : aVar.lTj;
        this.mbY = aVar.mbY;
        this.mbZ = aVar.mbZ == null ? this.mbS : aVar.mbZ;
        this.mca = aVar.mca;
        this.lYp = aVar.lYp == null ? new com.facebook.imagepipeline.d.a(this.mbW.dtL()) : aVar.lYp;
        this.mcc = aVar.mcc;
        com.facebook.common.g.b drJ = this.mcb.drJ();
        if (drJ != null) {
            a(drJ, this.mcb, new com.facebook.imagepipeline.b.d(drw()));
        } else if (this.mcb.drG() && com.facebook.common.g.c.lSp && (dnw = com.facebook.common.g.c.dnw()) != null) {
            a(dnw, this.mcb, new com.facebook.imagepipeline.b.d(drw()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.lSs = bVar;
        b.a drI = iVar.drI();
        if (drI != null) {
            bVar.a(drI);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b fQ(Context context) {
        return com.facebook.cache.disk.b.fM(context).dmF();
    }

    public Bitmap.Config dqR() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dri() {
        return this.mbM;
    }

    public h.a drj() {
        return this.mbN;
    }

    public com.facebook.imagepipeline.c.f drh() {
        return this.mbE;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b drk() {
        return mcd;
    }

    public f drl() {
        return this.mbP;
    }

    public boolean drm() {
        return this.mbO;
    }

    public boolean drn() {
        return this.mcc;
    }

    public com.facebook.common.internal.j<q> dro() {
        return this.mbQ;
    }

    public e drp() {
        return this.lYp;
    }

    public n drq() {
        return this.man;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b drr() {
        return this.mbR;
    }

    public com.facebook.common.internal.j<Boolean> drs() {
        return this.mbz;
    }

    public com.facebook.cache.disk.b drt() {
        return this.mbS;
    }

    public com.facebook.common.memory.c dru() {
        return this.mbT;
    }

    public af drv() {
        return this.mbU;
    }

    public com.facebook.imagepipeline.memory.q drw() {
        return this.mbW;
    }

    public com.facebook.imagepipeline.decoder.d drx() {
        return this.mbX;
    }

    public Set<com.facebook.imagepipeline.h.c> dry() {
        return Collections.unmodifiableSet(this.lTj);
    }

    public boolean drz() {
        return this.mbY;
    }

    public com.facebook.cache.disk.b drA() {
        return this.mbZ;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c drB() {
        return this.mca;
    }

    public i drC() {
        return this.mcb;
    }

    public static a fR(Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class b {
        private boolean mch;

        private b() {
            this.mch = false;
        }

        public boolean drE() {
            return this.mch;
        }
    }

    /* loaded from: classes12.dex */
    public static class a {
        private Set<com.facebook.imagepipeline.h.c> lTj;
        private com.facebook.imagepipeline.b.f lXG;
        private e lYp;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private n man;
        private com.facebook.imagepipeline.c.f mbE;
        private com.facebook.common.internal.j<q> mbM;
        private h.a mbN;
        private boolean mbO;
        private f mbP;
        private com.facebook.common.internal.j<q> mbQ;
        private com.facebook.imagepipeline.decoder.b mbR;
        private com.facebook.cache.disk.b mbS;
        private com.facebook.common.memory.c mbT;
        private af mbU;
        private com.facebook.imagepipeline.memory.q mbW;
        private com.facebook.imagepipeline.decoder.d mbX;
        private boolean mbY;
        private com.facebook.cache.disk.b mbZ;
        private com.facebook.common.internal.j<Boolean> mbz;
        private com.facebook.imagepipeline.decoder.c mca;
        private boolean mcc;
        private int mcf;
        private final i.a mcg;

        private a(Context context) {
            this.mbO = false;
            this.mbY = true;
            this.mcf = -1;
            this.mcg = new i.a(this);
            this.mcc = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a vJ(boolean z) {
            this.mbO = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.mbT = cVar;
            return this;
        }

        public a a(af afVar) {
            this.mbU = afVar;
            return this;
        }

        public a vK(boolean z) {
            this.mbY = z;
            return this;
        }

        public h drD() {
            return new h(this);
        }
    }
}
