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
    private static b kgX = new b();
    private final Bitmap.Config Dx;
    private final com.facebook.imagepipeline.c.f kfP;
    private final o kfa;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d kgF;
    private final com.facebook.common.internal.i<u> kgG;
    private final boolean kgH;
    private final f kgI;
    private final com.facebook.common.internal.i<u> kgJ;
    private final e kgK;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b kgL;
    private final com.facebook.cache.disk.b kgM;
    private final com.facebook.common.memory.c kgN;
    private final af kgO;
    @Nullable
    private final com.facebook.imagepipeline.b.f kgP;
    private final q kgQ;
    private final com.facebook.imagepipeline.decoder.d kgR;
    private final Set<com.facebook.imagepipeline.g.b> kgS;
    private final boolean kgT;
    private final com.facebook.cache.disk.b kgU;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c kgV;
    private final i kgW;
    private final com.facebook.common.internal.i<Boolean> kgw;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cFd;
        this.kgW = aVar.kgZ.cIL();
        this.kgF = aVar.kgF;
        this.kgG = aVar.kgG == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.kgG;
        this.Dx = aVar.Dx == null ? Bitmap.Config.ARGB_8888 : aVar.Dx;
        if (aVar.kfP == null) {
            fVar = com.facebook.imagepipeline.c.j.cHv();
        } else {
            fVar = aVar.kfP;
        }
        this.kfP = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.kgI = aVar.kgI == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.kgI;
        this.kgH = aVar.kgH;
        this.kgJ = aVar.kgJ == null ? new com.facebook.imagepipeline.c.k() : aVar.kgJ;
        if (aVar.kfa == null) {
            oVar = x.cHF();
        } else {
            oVar = aVar.kfa;
        }
        this.kfa = oVar;
        this.kgL = aVar.kgL;
        this.kgw = aVar.kgw == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cIz */
            public Boolean get() {
                return true;
            }
        } : aVar.kgw;
        this.kgM = aVar.kgM == null ? eD(aVar.mContext) : aVar.kgM;
        if (aVar.kgN == null) {
            cVar = com.facebook.common.memory.d.cEG();
        } else {
            cVar = aVar.kgN;
        }
        this.kgN = cVar;
        this.kgO = aVar.kgO == null ? new t() : aVar.kgO;
        this.kgP = aVar.kgP;
        if (aVar.kgQ == null) {
            qVar = new q(p.cKq().cKr());
        } else {
            qVar = aVar.kgQ;
        }
        this.kgQ = qVar;
        this.kgR = aVar.kgR == null ? new com.facebook.imagepipeline.decoder.f() : aVar.kgR;
        this.kgS = aVar.kgS == null ? new HashSet<>() : aVar.kgS;
        this.kgT = aVar.kgT;
        this.kgU = aVar.kgU == null ? this.kgM : aVar.kgU;
        this.kgV = aVar.kgV;
        this.kgK = aVar.kgK == null ? new com.facebook.imagepipeline.d.a(this.kgQ.cKu()) : aVar.kgK;
        com.facebook.common.g.b cIK = this.kgW.cIK();
        if (cIK != null) {
            a(cIK, this.kgW, new com.facebook.imagepipeline.b.d(cIs()));
        } else if (this.kgW.cIH() && com.facebook.common.g.c.kah && (cFd = com.facebook.common.g.c.cFd()) != null) {
            a(cFd, this.kgW, new com.facebook.imagepipeline.b.d(cIs()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.kak = bVar;
        b.a cIJ = iVar.cIJ();
        if (cIJ != null) {
            bVar.a(cIJ);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eD(Context context) {
        return com.facebook.cache.disk.b.ez(context).cEm();
    }

    public Bitmap.Config cHQ() {
        return this.Dx;
    }

    public com.facebook.common.internal.i<u> cIg() {
        return this.kgG;
    }

    public com.facebook.imagepipeline.c.f cIf() {
        return this.kfP;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cIh() {
        return kgX;
    }

    public f cIi() {
        return this.kgI;
    }

    public boolean cIj() {
        return this.kgH;
    }

    public com.facebook.common.internal.i<u> cIk() {
        return this.kgJ;
    }

    public e cIl() {
        return this.kgK;
    }

    public o cIm() {
        return this.kfa;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cIn() {
        return this.kgL;
    }

    public com.facebook.common.internal.i<Boolean> cIo() {
        return this.kgw;
    }

    public com.facebook.cache.disk.b cIp() {
        return this.kgM;
    }

    public com.facebook.common.memory.c cIq() {
        return this.kgN;
    }

    public af cIr() {
        return this.kgO;
    }

    public q cIs() {
        return this.kgQ;
    }

    public com.facebook.imagepipeline.decoder.d cIt() {
        return this.kgR;
    }

    public Set<com.facebook.imagepipeline.g.b> cIu() {
        return Collections.unmodifiableSet(this.kgS);
    }

    public boolean cIv() {
        return this.kgT;
    }

    public com.facebook.cache.disk.b cIw() {
        return this.kgU;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cIx() {
        return this.kgV;
    }

    public i cIy() {
        return this.kgW;
    }

    public static a eE(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean kha;

        private b() {
            this.kha = false;
        }

        public boolean cIB() {
            return this.kha;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config Dx;
        private com.facebook.imagepipeline.c.f kfP;
        private o kfa;
        private com.facebook.imagepipeline.a.a.d kgF;
        private com.facebook.common.internal.i<u> kgG;
        private boolean kgH;
        private f kgI;
        private com.facebook.common.internal.i<u> kgJ;
        private e kgK;
        private com.facebook.imagepipeline.decoder.b kgL;
        private com.facebook.cache.disk.b kgM;
        private com.facebook.common.memory.c kgN;
        private af kgO;
        private com.facebook.imagepipeline.b.f kgP;
        private q kgQ;
        private com.facebook.imagepipeline.decoder.d kgR;
        private Set<com.facebook.imagepipeline.g.b> kgS;
        private boolean kgT;
        private com.facebook.cache.disk.b kgU;
        private com.facebook.imagepipeline.decoder.c kgV;
        private final i.a kgZ;
        private com.facebook.common.internal.i<Boolean> kgw;
        private final Context mContext;

        private a(Context context) {
            this.kgH = false;
            this.kgT = true;
            this.kgZ = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cIA() {
            return new h(this);
        }
    }
}
