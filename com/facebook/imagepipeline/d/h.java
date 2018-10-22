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
    private static b ieA = new b();
    private final Bitmap.Config FF;
    private final o icB;
    private final com.facebook.common.internal.i<Boolean> idZ;
    private final com.facebook.imagepipeline.c.f idq;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d iei;
    private final com.facebook.common.internal.i<u> iej;
    private final boolean iek;
    private final f iel;
    private final com.facebook.common.internal.i<u> iem;
    private final e ien;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b ieo;
    private final com.facebook.cache.disk.b iep;
    private final com.facebook.common.memory.c ieq;
    private final af ier;
    @Nullable
    private final com.facebook.imagepipeline.b.f ies;
    private final q iet;
    private final com.facebook.imagepipeline.decoder.d ieu;
    private final Set<com.facebook.imagepipeline.g.b> iev;
    private final boolean iew;
    private final com.facebook.cache.disk.b iex;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c iey;
    private final i iez;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b bSc;
        this.iez = aVar.ieC.bVF();
        this.iei = aVar.iei;
        this.iej = aVar.iej == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.iej;
        this.FF = aVar.FF == null ? Bitmap.Config.ARGB_8888 : aVar.FF;
        if (aVar.idq == null) {
            fVar = com.facebook.imagepipeline.c.j.bUp();
        } else {
            fVar = aVar.idq;
        }
        this.idq = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.iel = aVar.iel == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.iel;
        this.iek = aVar.iek;
        this.iem = aVar.iem == null ? new com.facebook.imagepipeline.c.k() : aVar.iem;
        if (aVar.icB == null) {
            oVar = x.bUz();
        } else {
            oVar = aVar.icB;
        }
        this.icB = oVar;
        this.ieo = aVar.ieo;
        this.idZ = aVar.idZ == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: bVt */
            public Boolean get() {
                return true;
            }
        } : aVar.idZ;
        this.iep = aVar.iep == null ? du(aVar.mContext) : aVar.iep;
        if (aVar.ieq == null) {
            cVar = com.facebook.common.memory.d.bRE();
        } else {
            cVar = aVar.ieq;
        }
        this.ieq = cVar;
        this.ier = aVar.ier == null ? new t() : aVar.ier;
        this.ies = aVar.ies;
        if (aVar.iet == null) {
            qVar = new q(p.bXf().bXg());
        } else {
            qVar = aVar.iet;
        }
        this.iet = qVar;
        this.ieu = aVar.ieu == null ? new com.facebook.imagepipeline.decoder.f() : aVar.ieu;
        this.iev = aVar.iev == null ? new HashSet<>() : aVar.iev;
        this.iew = aVar.iew;
        this.iex = aVar.iex == null ? this.iep : aVar.iex;
        this.iey = aVar.iey;
        this.ien = aVar.ien == null ? new com.facebook.imagepipeline.d.a(this.iet.bXj()) : aVar.ien;
        com.facebook.common.g.b bVE = this.iez.bVE();
        if (bVE != null) {
            a(bVE, this.iez, new com.facebook.imagepipeline.b.d(bVm()));
        } else if (this.iez.bVB() && com.facebook.common.g.c.hXN && (bSc = com.facebook.common.g.c.bSc()) != null) {
            a(bSc, this.iez, new com.facebook.imagepipeline.b.d(bVm()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.hXQ = bVar;
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
        return this.iej;
    }

    public com.facebook.imagepipeline.c.f bUZ() {
        return this.idq;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b bVb() {
        return ieA;
    }

    public f bVc() {
        return this.iel;
    }

    public boolean bVd() {
        return this.iek;
    }

    public com.facebook.common.internal.i<u> bVe() {
        return this.iem;
    }

    public e bVf() {
        return this.ien;
    }

    public o bVg() {
        return this.icB;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bVh() {
        return this.ieo;
    }

    public com.facebook.common.internal.i<Boolean> bVi() {
        return this.idZ;
    }

    public com.facebook.cache.disk.b bVj() {
        return this.iep;
    }

    public com.facebook.common.memory.c bVk() {
        return this.ieq;
    }

    public af bVl() {
        return this.ier;
    }

    public q bVm() {
        return this.iet;
    }

    public com.facebook.imagepipeline.decoder.d bVn() {
        return this.ieu;
    }

    public Set<com.facebook.imagepipeline.g.b> bVo() {
        return Collections.unmodifiableSet(this.iev);
    }

    public boolean bVp() {
        return this.iew;
    }

    public com.facebook.cache.disk.b bVq() {
        return this.iex;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c bVr() {
        return this.iey;
    }

    public i bVs() {
        return this.iez;
    }

    public static a dv(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean ieD;

        private b() {
            this.ieD = false;
        }

        public boolean bVv() {
            return this.ieD;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FF;
        private o icB;
        private com.facebook.common.internal.i<Boolean> idZ;
        private com.facebook.imagepipeline.c.f idq;
        private final i.a ieC;
        private com.facebook.imagepipeline.a.a.d iei;
        private com.facebook.common.internal.i<u> iej;
        private boolean iek;
        private f iel;
        private com.facebook.common.internal.i<u> iem;
        private e ien;
        private com.facebook.imagepipeline.decoder.b ieo;
        private com.facebook.cache.disk.b iep;
        private com.facebook.common.memory.c ieq;
        private af ier;
        private com.facebook.imagepipeline.b.f ies;
        private q iet;
        private com.facebook.imagepipeline.decoder.d ieu;
        private Set<com.facebook.imagepipeline.g.b> iev;
        private boolean iew;
        private com.facebook.cache.disk.b iex;
        private com.facebook.imagepipeline.decoder.c iey;
        private final Context mContext;

        private a(Context context) {
            this.iek = false;
            this.iew = true;
            this.ieC = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h bVu() {
            return new h(this);
        }
    }
}
