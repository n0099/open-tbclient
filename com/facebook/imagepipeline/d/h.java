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
    private static b irN = new b();
    private final Bitmap.Config FJ;
    private final o ipR;
    private final com.facebook.imagepipeline.c.f iqF;
    private final e irA;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b irB;
    private final com.facebook.cache.disk.b irC;
    private final com.facebook.common.memory.c irD;
    private final af irE;
    @Nullable
    private final com.facebook.imagepipeline.b.f irF;
    private final q irG;
    private final com.facebook.imagepipeline.decoder.d irH;
    private final Set<com.facebook.imagepipeline.g.b> irI;
    private final boolean irJ;
    private final com.facebook.cache.disk.b irK;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c irL;
    private final i irM;
    private final com.facebook.common.internal.i<Boolean> irm;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d irv;
    private final com.facebook.common.internal.i<u> irw;
    private final boolean irx;
    private final f iry;
    private final com.facebook.common.internal.i<u> irz;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b bVb;
        this.irM = aVar.irP.bYE();
        this.irv = aVar.irv;
        this.irw = aVar.irw == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.irw;
        this.FJ = aVar.FJ == null ? Bitmap.Config.ARGB_8888 : aVar.FJ;
        if (aVar.iqF == null) {
            fVar = com.facebook.imagepipeline.c.j.bXo();
        } else {
            fVar = aVar.iqF;
        }
        this.iqF = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.iry = aVar.iry == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.iry;
        this.irx = aVar.irx;
        this.irz = aVar.irz == null ? new com.facebook.imagepipeline.c.k() : aVar.irz;
        if (aVar.ipR == null) {
            oVar = x.bXy();
        } else {
            oVar = aVar.ipR;
        }
        this.ipR = oVar;
        this.irB = aVar.irB;
        this.irm = aVar.irm == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: bYs */
            public Boolean get() {
                return true;
            }
        } : aVar.irm;
        this.irC = aVar.irC == null ? dt(aVar.mContext) : aVar.irC;
        if (aVar.irD == null) {
            cVar = com.facebook.common.memory.d.bUD();
        } else {
            cVar = aVar.irD;
        }
        this.irD = cVar;
        this.irE = aVar.irE == null ? new t() : aVar.irE;
        this.irF = aVar.irF;
        if (aVar.irG == null) {
            qVar = new q(p.cae().caf());
        } else {
            qVar = aVar.irG;
        }
        this.irG = qVar;
        this.irH = aVar.irH == null ? new com.facebook.imagepipeline.decoder.f() : aVar.irH;
        this.irI = aVar.irI == null ? new HashSet<>() : aVar.irI;
        this.irJ = aVar.irJ;
        this.irK = aVar.irK == null ? this.irC : aVar.irK;
        this.irL = aVar.irL;
        this.irA = aVar.irA == null ? new com.facebook.imagepipeline.d.a(this.irG.cai()) : aVar.irA;
        com.facebook.common.g.b bYD = this.irM.bYD();
        if (bYD != null) {
            a(bYD, this.irM, new com.facebook.imagepipeline.b.d(bYl()));
        } else if (this.irM.bYA() && com.facebook.common.g.c.ilb && (bVb = com.facebook.common.g.c.bVb()) != null) {
            a(bVb, this.irM, new com.facebook.imagepipeline.b.d(bYl()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.ile = bVar;
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
        return this.irw;
    }

    public com.facebook.imagepipeline.c.f bXY() {
        return this.iqF;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b bYa() {
        return irN;
    }

    public f bYb() {
        return this.iry;
    }

    public boolean bYc() {
        return this.irx;
    }

    public com.facebook.common.internal.i<u> bYd() {
        return this.irz;
    }

    public e bYe() {
        return this.irA;
    }

    public o bYf() {
        return this.ipR;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bYg() {
        return this.irB;
    }

    public com.facebook.common.internal.i<Boolean> bYh() {
        return this.irm;
    }

    public com.facebook.cache.disk.b bYi() {
        return this.irC;
    }

    public com.facebook.common.memory.c bYj() {
        return this.irD;
    }

    public af bYk() {
        return this.irE;
    }

    public q bYl() {
        return this.irG;
    }

    public com.facebook.imagepipeline.decoder.d bYm() {
        return this.irH;
    }

    public Set<com.facebook.imagepipeline.g.b> bYn() {
        return Collections.unmodifiableSet(this.irI);
    }

    public boolean bYo() {
        return this.irJ;
    }

    public com.facebook.cache.disk.b bYp() {
        return this.irK;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c bYq() {
        return this.irL;
    }

    public i bYr() {
        return this.irM;
    }

    public static a du(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean irQ;

        private b() {
            this.irQ = false;
        }

        public boolean bYu() {
            return this.irQ;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FJ;
        private o ipR;
        private com.facebook.imagepipeline.c.f iqF;
        private e irA;
        private com.facebook.imagepipeline.decoder.b irB;
        private com.facebook.cache.disk.b irC;
        private com.facebook.common.memory.c irD;
        private af irE;
        private com.facebook.imagepipeline.b.f irF;
        private q irG;
        private com.facebook.imagepipeline.decoder.d irH;
        private Set<com.facebook.imagepipeline.g.b> irI;
        private boolean irJ;
        private com.facebook.cache.disk.b irK;
        private com.facebook.imagepipeline.decoder.c irL;
        private final i.a irP;
        private com.facebook.common.internal.i<Boolean> irm;
        private com.facebook.imagepipeline.a.a.d irv;
        private com.facebook.common.internal.i<u> irw;
        private boolean irx;
        private f iry;
        private com.facebook.common.internal.i<u> irz;
        private final Context mContext;

        private a(Context context) {
            this.irx = false;
            this.irJ = true;
            this.irP = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h bYt() {
            return new h(this);
        }
    }
}
