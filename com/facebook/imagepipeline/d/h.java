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
    private static b irO = new b();
    private final Bitmap.Config FJ;
    private final o ipS;
    private final com.facebook.imagepipeline.c.f iqG;
    private final com.facebook.common.internal.i<u> irA;
    private final e irB;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b irC;
    private final com.facebook.cache.disk.b irD;
    private final com.facebook.common.memory.c irE;
    private final af irF;
    @Nullable
    private final com.facebook.imagepipeline.b.f irG;
    private final q irH;
    private final com.facebook.imagepipeline.decoder.d irI;
    private final Set<com.facebook.imagepipeline.g.b> irJ;
    private final boolean irK;
    private final com.facebook.cache.disk.b irL;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c irM;
    private final i irN;
    private final com.facebook.common.internal.i<Boolean> irn;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d irw;
    private final com.facebook.common.internal.i<u> irx;
    private final boolean iry;
    private final f irz;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b bVb;
        this.irN = aVar.irQ.bYE();
        this.irw = aVar.irw;
        this.irx = aVar.irx == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.irx;
        this.FJ = aVar.FJ == null ? Bitmap.Config.ARGB_8888 : aVar.FJ;
        if (aVar.iqG == null) {
            fVar = com.facebook.imagepipeline.c.j.bXo();
        } else {
            fVar = aVar.iqG;
        }
        this.iqG = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.irz = aVar.irz == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.irz;
        this.iry = aVar.iry;
        this.irA = aVar.irA == null ? new com.facebook.imagepipeline.c.k() : aVar.irA;
        if (aVar.ipS == null) {
            oVar = x.bXy();
        } else {
            oVar = aVar.ipS;
        }
        this.ipS = oVar;
        this.irC = aVar.irC;
        this.irn = aVar.irn == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: bYs */
            public Boolean get() {
                return true;
            }
        } : aVar.irn;
        this.irD = aVar.irD == null ? dt(aVar.mContext) : aVar.irD;
        if (aVar.irE == null) {
            cVar = com.facebook.common.memory.d.bUD();
        } else {
            cVar = aVar.irE;
        }
        this.irE = cVar;
        this.irF = aVar.irF == null ? new t() : aVar.irF;
        this.irG = aVar.irG;
        if (aVar.irH == null) {
            qVar = new q(p.cae().caf());
        } else {
            qVar = aVar.irH;
        }
        this.irH = qVar;
        this.irI = aVar.irI == null ? new com.facebook.imagepipeline.decoder.f() : aVar.irI;
        this.irJ = aVar.irJ == null ? new HashSet<>() : aVar.irJ;
        this.irK = aVar.irK;
        this.irL = aVar.irL == null ? this.irD : aVar.irL;
        this.irM = aVar.irM;
        this.irB = aVar.irB == null ? new com.facebook.imagepipeline.d.a(this.irH.cai()) : aVar.irB;
        com.facebook.common.g.b bYD = this.irN.bYD();
        if (bYD != null) {
            a(bYD, this.irN, new com.facebook.imagepipeline.b.d(bYl()));
        } else if (this.irN.bYA() && com.facebook.common.g.c.ilc && (bVb = com.facebook.common.g.c.bVb()) != null) {
            a(bVb, this.irN, new com.facebook.imagepipeline.b.d(bYl()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.ilf = bVar;
        b.a bYC = iVar.bYC();
        if (bYC != null) {
            bVar.a(bYC);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b dt(Context context) {
        return com.facebook.cache.disk.b.dp(context).bUj();
    }

    public Bitmap.Config bXJ() {
        return this.FJ;
    }

    public com.facebook.common.internal.i<u> bXZ() {
        return this.irx;
    }

    public com.facebook.imagepipeline.c.f bXY() {
        return this.iqG;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b bYa() {
        return irO;
    }

    public f bYb() {
        return this.irz;
    }

    public boolean bYc() {
        return this.iry;
    }

    public com.facebook.common.internal.i<u> bYd() {
        return this.irA;
    }

    public e bYe() {
        return this.irB;
    }

    public o bYf() {
        return this.ipS;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bYg() {
        return this.irC;
    }

    public com.facebook.common.internal.i<Boolean> bYh() {
        return this.irn;
    }

    public com.facebook.cache.disk.b bYi() {
        return this.irD;
    }

    public com.facebook.common.memory.c bYj() {
        return this.irE;
    }

    public af bYk() {
        return this.irF;
    }

    public q bYl() {
        return this.irH;
    }

    public com.facebook.imagepipeline.decoder.d bYm() {
        return this.irI;
    }

    public Set<com.facebook.imagepipeline.g.b> bYn() {
        return Collections.unmodifiableSet(this.irJ);
    }

    public boolean bYo() {
        return this.irK;
    }

    public com.facebook.cache.disk.b bYp() {
        return this.irL;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c bYq() {
        return this.irM;
    }

    public i bYr() {
        return this.irN;
    }

    public static a du(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean irR;

        private b() {
            this.irR = false;
        }

        public boolean bYu() {
            return this.irR;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FJ;
        private o ipS;
        private com.facebook.imagepipeline.c.f iqG;
        private com.facebook.common.internal.i<u> irA;
        private e irB;
        private com.facebook.imagepipeline.decoder.b irC;
        private com.facebook.cache.disk.b irD;
        private com.facebook.common.memory.c irE;
        private af irF;
        private com.facebook.imagepipeline.b.f irG;
        private q irH;
        private com.facebook.imagepipeline.decoder.d irI;
        private Set<com.facebook.imagepipeline.g.b> irJ;
        private boolean irK;
        private com.facebook.cache.disk.b irL;
        private com.facebook.imagepipeline.decoder.c irM;
        private final i.a irQ;
        private com.facebook.common.internal.i<Boolean> irn;
        private com.facebook.imagepipeline.a.a.d irw;
        private com.facebook.common.internal.i<u> irx;
        private boolean iry;
        private f irz;
        private final Context mContext;

        private a(Context context) {
            this.iry = false;
            this.irK = true;
            this.irQ = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h bYt() {
            return new h(this);
        }
    }
}
