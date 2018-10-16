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
    private static b iez = new b();
    private final Bitmap.Config FF;
    private final o icA;
    private final com.facebook.common.internal.i<Boolean> idY;
    private final com.facebook.imagepipeline.c.f idp;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d ieh;
    private final com.facebook.common.internal.i<u> iei;
    private final boolean iej;
    private final f iek;
    private final com.facebook.common.internal.i<u> iel;
    private final e iem;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b ien;
    private final com.facebook.cache.disk.b ieo;
    private final com.facebook.common.memory.c iep;
    private final af ieq;
    @Nullable
    private final com.facebook.imagepipeline.b.f ier;
    private final q ies;
    private final com.facebook.imagepipeline.decoder.d iet;
    private final Set<com.facebook.imagepipeline.g.b> ieu;
    private final boolean iev;
    private final com.facebook.cache.disk.b iew;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c iex;
    private final i iey;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b bSc;
        this.iey = aVar.ieB.bVF();
        this.ieh = aVar.ieh;
        this.iei = aVar.iei == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.iei;
        this.FF = aVar.FF == null ? Bitmap.Config.ARGB_8888 : aVar.FF;
        if (aVar.idp == null) {
            fVar = com.facebook.imagepipeline.c.j.bUp();
        } else {
            fVar = aVar.idp;
        }
        this.idp = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.iek = aVar.iek == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.iek;
        this.iej = aVar.iej;
        this.iel = aVar.iel == null ? new com.facebook.imagepipeline.c.k() : aVar.iel;
        if (aVar.icA == null) {
            oVar = x.bUz();
        } else {
            oVar = aVar.icA;
        }
        this.icA = oVar;
        this.ien = aVar.ien;
        this.idY = aVar.idY == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: bVt */
            public Boolean get() {
                return true;
            }
        } : aVar.idY;
        this.ieo = aVar.ieo == null ? du(aVar.mContext) : aVar.ieo;
        if (aVar.iep == null) {
            cVar = com.facebook.common.memory.d.bRE();
        } else {
            cVar = aVar.iep;
        }
        this.iep = cVar;
        this.ieq = aVar.ieq == null ? new t() : aVar.ieq;
        this.ier = aVar.ier;
        if (aVar.ies == null) {
            qVar = new q(p.bXf().bXg());
        } else {
            qVar = aVar.ies;
        }
        this.ies = qVar;
        this.iet = aVar.iet == null ? new com.facebook.imagepipeline.decoder.f() : aVar.iet;
        this.ieu = aVar.ieu == null ? new HashSet<>() : aVar.ieu;
        this.iev = aVar.iev;
        this.iew = aVar.iew == null ? this.ieo : aVar.iew;
        this.iex = aVar.iex;
        this.iem = aVar.iem == null ? new com.facebook.imagepipeline.d.a(this.ies.bXj()) : aVar.iem;
        com.facebook.common.g.b bVE = this.iey.bVE();
        if (bVE != null) {
            a(bVE, this.iey, new com.facebook.imagepipeline.b.d(bVm()));
        } else if (this.iey.bVB() && com.facebook.common.g.c.hXM && (bSc = com.facebook.common.g.c.bSc()) != null) {
            a(bSc, this.iey, new com.facebook.imagepipeline.b.d(bVm()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.hXP = bVar;
        b.a bVD = iVar.bVD();
        if (bVD != null) {
            bVar.a(bVD);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b du(Context context) {
        return com.facebook.cache.disk.b.dq(context).bRk();
    }

    public Bitmap.Config bUK() {
        return this.FF;
    }

    public com.facebook.common.internal.i<u> bVa() {
        return this.iei;
    }

    public com.facebook.imagepipeline.c.f bUZ() {
        return this.idp;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b bVb() {
        return iez;
    }

    public f bVc() {
        return this.iek;
    }

    public boolean bVd() {
        return this.iej;
    }

    public com.facebook.common.internal.i<u> bVe() {
        return this.iel;
    }

    public e bVf() {
        return this.iem;
    }

    public o bVg() {
        return this.icA;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bVh() {
        return this.ien;
    }

    public com.facebook.common.internal.i<Boolean> bVi() {
        return this.idY;
    }

    public com.facebook.cache.disk.b bVj() {
        return this.ieo;
    }

    public com.facebook.common.memory.c bVk() {
        return this.iep;
    }

    public af bVl() {
        return this.ieq;
    }

    public q bVm() {
        return this.ies;
    }

    public com.facebook.imagepipeline.decoder.d bVn() {
        return this.iet;
    }

    public Set<com.facebook.imagepipeline.g.b> bVo() {
        return Collections.unmodifiableSet(this.ieu);
    }

    public boolean bVp() {
        return this.iev;
    }

    public com.facebook.cache.disk.b bVq() {
        return this.iew;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c bVr() {
        return this.iex;
    }

    public i bVs() {
        return this.iey;
    }

    public static a dv(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean ieC;

        private b() {
            this.ieC = false;
        }

        public boolean bVv() {
            return this.ieC;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FF;
        private o icA;
        private com.facebook.common.internal.i<Boolean> idY;
        private com.facebook.imagepipeline.c.f idp;
        private final i.a ieB;
        private com.facebook.imagepipeline.a.a.d ieh;
        private com.facebook.common.internal.i<u> iei;
        private boolean iej;
        private f iek;
        private com.facebook.common.internal.i<u> iel;
        private e iem;
        private com.facebook.imagepipeline.decoder.b ien;
        private com.facebook.cache.disk.b ieo;
        private com.facebook.common.memory.c iep;
        private af ieq;
        private com.facebook.imagepipeline.b.f ier;
        private q ies;
        private com.facebook.imagepipeline.decoder.d iet;
        private Set<com.facebook.imagepipeline.g.b> ieu;
        private boolean iev;
        private com.facebook.cache.disk.b iew;
        private com.facebook.imagepipeline.decoder.c iex;
        private final Context mContext;

        private a(Context context) {
            this.iej = false;
            this.iev = true;
            this.ieB = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h bVu() {
            return new h(this);
        }
    }
}
