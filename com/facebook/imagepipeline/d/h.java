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
    private static b igk = new b();
    private final Bitmap.Config FJ;
    private final o ieo;
    private final com.facebook.common.internal.i<Boolean> ifJ;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d ifS;
    private final com.facebook.common.internal.i<u> ifT;
    private final boolean ifU;
    private final f ifV;
    private final com.facebook.common.internal.i<u> ifW;
    private final e ifX;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b ifY;
    private final com.facebook.cache.disk.b ifZ;
    private final com.facebook.imagepipeline.c.f ifc;
    private final com.facebook.common.memory.c iga;
    private final af igb;
    @Nullable
    private final com.facebook.imagepipeline.b.f igc;
    private final q igd;
    private final com.facebook.imagepipeline.decoder.d ige;
    private final Set<com.facebook.imagepipeline.g.b> igf;
    private final boolean igg;
    private final com.facebook.cache.disk.b igh;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c igi;
    private final i igj;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b bRx;
        this.igj = aVar.igm.bVa();
        this.ifS = aVar.ifS;
        this.ifT = aVar.ifT == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.ifT;
        this.FJ = aVar.FJ == null ? Bitmap.Config.ARGB_8888 : aVar.FJ;
        if (aVar.ifc == null) {
            fVar = com.facebook.imagepipeline.c.j.bTK();
        } else {
            fVar = aVar.ifc;
        }
        this.ifc = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.ifV = aVar.ifV == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.ifV;
        this.ifU = aVar.ifU;
        this.ifW = aVar.ifW == null ? new com.facebook.imagepipeline.c.k() : aVar.ifW;
        if (aVar.ieo == null) {
            oVar = x.bTU();
        } else {
            oVar = aVar.ieo;
        }
        this.ieo = oVar;
        this.ifY = aVar.ifY;
        this.ifJ = aVar.ifJ == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: bUO */
            public Boolean get() {
                return true;
            }
        } : aVar.ifJ;
        this.ifZ = aVar.ifZ == null ? dp(aVar.mContext) : aVar.ifZ;
        if (aVar.iga == null) {
            cVar = com.facebook.common.memory.d.bQZ();
        } else {
            cVar = aVar.iga;
        }
        this.iga = cVar;
        this.igb = aVar.igb == null ? new t() : aVar.igb;
        this.igc = aVar.igc;
        if (aVar.igd == null) {
            qVar = new q(p.bWA().bWB());
        } else {
            qVar = aVar.igd;
        }
        this.igd = qVar;
        this.ige = aVar.ige == null ? new com.facebook.imagepipeline.decoder.f() : aVar.ige;
        this.igf = aVar.igf == null ? new HashSet<>() : aVar.igf;
        this.igg = aVar.igg;
        this.igh = aVar.igh == null ? this.ifZ : aVar.igh;
        this.igi = aVar.igi;
        this.ifX = aVar.ifX == null ? new com.facebook.imagepipeline.d.a(this.igd.bWE()) : aVar.ifX;
        com.facebook.common.g.b bUZ = this.igj.bUZ();
        if (bUZ != null) {
            a(bUZ, this.igj, new com.facebook.imagepipeline.b.d(bUH()));
        } else if (this.igj.bUW() && com.facebook.common.g.c.hZx && (bRx = com.facebook.common.g.c.bRx()) != null) {
            a(bRx, this.igj, new com.facebook.imagepipeline.b.d(bUH()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.hZA = bVar;
        b.a bUY = iVar.bUY();
        if (bUY != null) {
            bVar.a(bUY);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b dp(Context context) {
        return com.facebook.cache.disk.b.dl(context).bQF();
    }

    public Bitmap.Config bUf() {
        return this.FJ;
    }

    public com.facebook.common.internal.i<u> bUv() {
        return this.ifT;
    }

    public com.facebook.imagepipeline.c.f bUu() {
        return this.ifc;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b bUw() {
        return igk;
    }

    public f bUx() {
        return this.ifV;
    }

    public boolean bUy() {
        return this.ifU;
    }

    public com.facebook.common.internal.i<u> bUz() {
        return this.ifW;
    }

    public e bUA() {
        return this.ifX;
    }

    public o bUB() {
        return this.ieo;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bUC() {
        return this.ifY;
    }

    public com.facebook.common.internal.i<Boolean> bUD() {
        return this.ifJ;
    }

    public com.facebook.cache.disk.b bUE() {
        return this.ifZ;
    }

    public com.facebook.common.memory.c bUF() {
        return this.iga;
    }

    public af bUG() {
        return this.igb;
    }

    public q bUH() {
        return this.igd;
    }

    public com.facebook.imagepipeline.decoder.d bUI() {
        return this.ige;
    }

    public Set<com.facebook.imagepipeline.g.b> bUJ() {
        return Collections.unmodifiableSet(this.igf);
    }

    public boolean bUK() {
        return this.igg;
    }

    public com.facebook.cache.disk.b bUL() {
        return this.igh;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c bUM() {
        return this.igi;
    }

    public i bUN() {
        return this.igj;
    }

    public static a dq(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean ign;

        private b() {
            this.ign = false;
        }

        public boolean bUQ() {
            return this.ign;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FJ;
        private o ieo;
        private com.facebook.common.internal.i<Boolean> ifJ;
        private com.facebook.imagepipeline.a.a.d ifS;
        private com.facebook.common.internal.i<u> ifT;
        private boolean ifU;
        private f ifV;
        private com.facebook.common.internal.i<u> ifW;
        private e ifX;
        private com.facebook.imagepipeline.decoder.b ifY;
        private com.facebook.cache.disk.b ifZ;
        private com.facebook.imagepipeline.c.f ifc;
        private com.facebook.common.memory.c iga;
        private af igb;
        private com.facebook.imagepipeline.b.f igc;
        private q igd;
        private com.facebook.imagepipeline.decoder.d ige;
        private Set<com.facebook.imagepipeline.g.b> igf;
        private boolean igg;
        private com.facebook.cache.disk.b igh;
        private com.facebook.imagepipeline.decoder.c igi;
        private final i.a igm;
        private final Context mContext;

        private a(Context context) {
            this.ifU = false;
            this.igg = true;
            this.igm = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h bUP() {
            return new h(this);
        }
    }
}
