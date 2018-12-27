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
    private static b iqG = new b();
    private final Bitmap.Config FJ;
    private final o ioK;
    private final com.facebook.imagepipeline.c.f ipy;
    private final com.facebook.imagepipeline.decoder.d iqA;
    private final Set<com.facebook.imagepipeline.g.b> iqB;
    private final boolean iqC;
    private final com.facebook.cache.disk.b iqD;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c iqE;
    private final i iqF;
    private final com.facebook.common.internal.i<Boolean> iqf;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d iqo;
    private final com.facebook.common.internal.i<u> iqp;
    private final boolean iqq;
    private final f iqr;
    private final com.facebook.common.internal.i<u> iqs;
    private final e iqt;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b iqu;
    private final com.facebook.cache.disk.b iqv;
    private final com.facebook.common.memory.c iqw;
    private final af iqx;
    @Nullable
    private final com.facebook.imagepipeline.b.f iqy;
    private final q iqz;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b bUt;
        this.iqF = aVar.iqI.bXW();
        this.iqo = aVar.iqo;
        this.iqp = aVar.iqp == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.iqp;
        this.FJ = aVar.FJ == null ? Bitmap.Config.ARGB_8888 : aVar.FJ;
        if (aVar.ipy == null) {
            fVar = com.facebook.imagepipeline.c.j.bWG();
        } else {
            fVar = aVar.ipy;
        }
        this.ipy = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.iqr = aVar.iqr == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.iqr;
        this.iqq = aVar.iqq;
        this.iqs = aVar.iqs == null ? new com.facebook.imagepipeline.c.k() : aVar.iqs;
        if (aVar.ioK == null) {
            oVar = x.bWQ();
        } else {
            oVar = aVar.ioK;
        }
        this.ioK = oVar;
        this.iqu = aVar.iqu;
        this.iqf = aVar.iqf == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: bXK */
            public Boolean get() {
                return true;
            }
        } : aVar.iqf;
        this.iqv = aVar.iqv == null ? dt(aVar.mContext) : aVar.iqv;
        if (aVar.iqw == null) {
            cVar = com.facebook.common.memory.d.bTV();
        } else {
            cVar = aVar.iqw;
        }
        this.iqw = cVar;
        this.iqx = aVar.iqx == null ? new t() : aVar.iqx;
        this.iqy = aVar.iqy;
        if (aVar.iqz == null) {
            qVar = new q(p.bZw().bZx());
        } else {
            qVar = aVar.iqz;
        }
        this.iqz = qVar;
        this.iqA = aVar.iqA == null ? new com.facebook.imagepipeline.decoder.f() : aVar.iqA;
        this.iqB = aVar.iqB == null ? new HashSet<>() : aVar.iqB;
        this.iqC = aVar.iqC;
        this.iqD = aVar.iqD == null ? this.iqv : aVar.iqD;
        this.iqE = aVar.iqE;
        this.iqt = aVar.iqt == null ? new com.facebook.imagepipeline.d.a(this.iqz.bZA()) : aVar.iqt;
        com.facebook.common.g.b bXV = this.iqF.bXV();
        if (bXV != null) {
            a(bXV, this.iqF, new com.facebook.imagepipeline.b.d(bXD()));
        } else if (this.iqF.bXS() && com.facebook.common.g.c.ijU && (bUt = com.facebook.common.g.c.bUt()) != null) {
            a(bUt, this.iqF, new com.facebook.imagepipeline.b.d(bXD()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.ijX = bVar;
        b.a bXU = iVar.bXU();
        if (bXU != null) {
            bVar.a(bXU);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b dt(Context context) {
        return com.facebook.cache.disk.b.dp(context).bTB();
    }

    public Bitmap.Config bXb() {
        return this.FJ;
    }

    public com.facebook.common.internal.i<u> bXr() {
        return this.iqp;
    }

    public com.facebook.imagepipeline.c.f bXq() {
        return this.ipy;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b bXs() {
        return iqG;
    }

    public f bXt() {
        return this.iqr;
    }

    public boolean bXu() {
        return this.iqq;
    }

    public com.facebook.common.internal.i<u> bXv() {
        return this.iqs;
    }

    public e bXw() {
        return this.iqt;
    }

    public o bXx() {
        return this.ioK;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bXy() {
        return this.iqu;
    }

    public com.facebook.common.internal.i<Boolean> bXz() {
        return this.iqf;
    }

    public com.facebook.cache.disk.b bXA() {
        return this.iqv;
    }

    public com.facebook.common.memory.c bXB() {
        return this.iqw;
    }

    public af bXC() {
        return this.iqx;
    }

    public q bXD() {
        return this.iqz;
    }

    public com.facebook.imagepipeline.decoder.d bXE() {
        return this.iqA;
    }

    public Set<com.facebook.imagepipeline.g.b> bXF() {
        return Collections.unmodifiableSet(this.iqB);
    }

    public boolean bXG() {
        return this.iqC;
    }

    public com.facebook.cache.disk.b bXH() {
        return this.iqD;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c bXI() {
        return this.iqE;
    }

    public i bXJ() {
        return this.iqF;
    }

    public static a du(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean iqJ;

        private b() {
            this.iqJ = false;
        }

        public boolean bXM() {
            return this.iqJ;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FJ;
        private o ioK;
        private com.facebook.imagepipeline.c.f ipy;
        private com.facebook.imagepipeline.decoder.d iqA;
        private Set<com.facebook.imagepipeline.g.b> iqB;
        private boolean iqC;
        private com.facebook.cache.disk.b iqD;
        private com.facebook.imagepipeline.decoder.c iqE;
        private final i.a iqI;
        private com.facebook.common.internal.i<Boolean> iqf;
        private com.facebook.imagepipeline.a.a.d iqo;
        private com.facebook.common.internal.i<u> iqp;
        private boolean iqq;
        private f iqr;
        private com.facebook.common.internal.i<u> iqs;
        private e iqt;
        private com.facebook.imagepipeline.decoder.b iqu;
        private com.facebook.cache.disk.b iqv;
        private com.facebook.common.memory.c iqw;
        private af iqx;
        private com.facebook.imagepipeline.b.f iqy;
        private q iqz;
        private final Context mContext;

        private a(Context context) {
            this.iqq = false;
            this.iqC = true;
            this.iqI = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h bXL() {
            return new h(this);
        }
    }
}
