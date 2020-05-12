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
    private static b mch = new b();
    private final Set<com.facebook.imagepipeline.h.c> lTn;
    @Nullable
    private final com.facebook.imagepipeline.b.f lXK;
    private final e lYt;
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final n mas;
    private final com.facebook.common.internal.j<Boolean> mbD;
    private final com.facebook.imagepipeline.c.f mbI;
    private final com.facebook.common.internal.j<q> mbQ;
    private final h.a mbR;
    private final boolean mbS;
    private final f mbT;
    private final com.facebook.common.internal.j<q> mbU;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b mbV;
    private final com.facebook.cache.disk.b mbW;
    private final com.facebook.common.memory.c mbX;
    private final af mbY;
    private final int mbZ;
    private final com.facebook.imagepipeline.memory.q mca;
    private final com.facebook.imagepipeline.decoder.d mcb;
    private final boolean mcc;
    private final com.facebook.cache.disk.b mcd;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c mce;
    private final i mcf;
    private final boolean mcg;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dnu;
        this.mcf = aVar.mck.drP();
        this.mbQ = aVar.mbQ == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.mbQ;
        this.mbR = aVar.mbR == null ? new com.facebook.imagepipeline.c.d() : aVar.mbR;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.mbI == null) {
            fVar = com.facebook.imagepipeline.c.j.dqu();
        } else {
            fVar = aVar.mbI;
        }
        this.mbI = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.mbT = aVar.mbT == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.mbT;
        this.mbS = aVar.mbS;
        this.mbU = aVar.mbU == null ? new com.facebook.imagepipeline.c.k() : aVar.mbU;
        if (aVar.mas == null) {
            nVar = t.dqD();
        } else {
            nVar = aVar.mas;
        }
        this.mas = nVar;
        this.mbV = aVar.mbV;
        this.mbD = aVar.mbD == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dmZ */
            public Boolean get() {
                return true;
            }
        } : aVar.mbD;
        this.mbW = aVar.mbW == null ? fE(aVar.mContext) : aVar.mbW;
        if (aVar.mbX == null) {
            cVar = com.facebook.common.memory.d.dnb();
        } else {
            cVar = aVar.mbX;
        }
        this.mbX = cVar;
        this.mbZ = aVar.mcj < 0 ? 30000 : aVar.mcj;
        this.mbY = aVar.mbY == null ? new u(this.mbZ) : aVar.mbY;
        this.lXK = aVar.lXK;
        if (aVar.mca == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dtF().dtG());
        } else {
            qVar = aVar.mca;
        }
        this.mca = qVar;
        this.mcb = aVar.mcb == null ? new com.facebook.imagepipeline.decoder.f() : aVar.mcb;
        this.lTn = aVar.lTn == null ? new HashSet<>() : aVar.lTn;
        this.mcc = aVar.mcc;
        this.mcd = aVar.mcd == null ? this.mbW : aVar.mcd;
        this.mce = aVar.mce;
        this.lYt = aVar.lYt == null ? new com.facebook.imagepipeline.d.a(this.mca.dtJ()) : aVar.lYt;
        this.mcg = aVar.mcg;
        com.facebook.common.g.b drH = this.mcf.drH();
        if (drH != null) {
            a(drH, this.mcf, new com.facebook.imagepipeline.b.d(dru()));
        } else if (this.mcf.drE() && com.facebook.common.g.c.lSt && (dnu = com.facebook.common.g.c.dnu()) != null) {
            a(dnu, this.mcf, new com.facebook.imagepipeline.b.d(dru()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.lSw = bVar;
        b.a drG = iVar.drG();
        if (drG != null) {
            bVar.a(drG);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b fE(Context context) {
        return com.facebook.cache.disk.b.fA(context).dmD();
    }

    public Bitmap.Config dqP() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> drg() {
        return this.mbQ;
    }

    public h.a drh() {
        return this.mbR;
    }

    public com.facebook.imagepipeline.c.f drf() {
        return this.mbI;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dri() {
        return mch;
    }

    public f drj() {
        return this.mbT;
    }

    public boolean drk() {
        return this.mbS;
    }

    public boolean drl() {
        return this.mcg;
    }

    public com.facebook.common.internal.j<q> drm() {
        return this.mbU;
    }

    public e drn() {
        return this.lYt;
    }

    public n dro() {
        return this.mas;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b drp() {
        return this.mbV;
    }

    public com.facebook.common.internal.j<Boolean> drq() {
        return this.mbD;
    }

    public com.facebook.cache.disk.b drr() {
        return this.mbW;
    }

    public com.facebook.common.memory.c drs() {
        return this.mbX;
    }

    public af drt() {
        return this.mbY;
    }

    public com.facebook.imagepipeline.memory.q dru() {
        return this.mca;
    }

    public com.facebook.imagepipeline.decoder.d drv() {
        return this.mcb;
    }

    public Set<com.facebook.imagepipeline.h.c> drw() {
        return Collections.unmodifiableSet(this.lTn);
    }

    public boolean drx() {
        return this.mcc;
    }

    public com.facebook.cache.disk.b dry() {
        return this.mcd;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c drz() {
        return this.mce;
    }

    public i drA() {
        return this.mcf;
    }

    public static a fF(Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class b {
        private boolean mcl;

        private b() {
            this.mcl = false;
        }

        public boolean drC() {
            return this.mcl;
        }
    }

    /* loaded from: classes12.dex */
    public static class a {
        private Set<com.facebook.imagepipeline.h.c> lTn;
        private com.facebook.imagepipeline.b.f lXK;
        private e lYt;
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private n mas;
        private com.facebook.common.internal.j<Boolean> mbD;
        private com.facebook.imagepipeline.c.f mbI;
        private com.facebook.common.internal.j<q> mbQ;
        private h.a mbR;
        private boolean mbS;
        private f mbT;
        private com.facebook.common.internal.j<q> mbU;
        private com.facebook.imagepipeline.decoder.b mbV;
        private com.facebook.cache.disk.b mbW;
        private com.facebook.common.memory.c mbX;
        private af mbY;
        private com.facebook.imagepipeline.memory.q mca;
        private com.facebook.imagepipeline.decoder.d mcb;
        private boolean mcc;
        private com.facebook.cache.disk.b mcd;
        private com.facebook.imagepipeline.decoder.c mce;
        private boolean mcg;
        private int mcj;
        private final i.a mck;

        private a(Context context) {
            this.mbS = false;
            this.mcc = true;
            this.mcj = -1;
            this.mck = new i.a(this);
            this.mcg = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a vJ(boolean z) {
            this.mbS = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.mbX = cVar;
            return this;
        }

        public a a(af afVar) {
            this.mbY = afVar;
            return this;
        }

        public a vK(boolean z) {
            this.mcc = z;
            return this;
        }

        public h drB() {
            return new h(this);
        }
    }
}
