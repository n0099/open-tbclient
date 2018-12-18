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
    private static b inw = new b();
    private final Bitmap.Config FJ;
    private final o ily;
    private final com.facebook.common.internal.i<Boolean> imU;
    private final com.facebook.imagepipeline.c.f imn;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d ind;
    private final com.facebook.common.internal.i<u> ine;
    private final boolean inf;
    private final f ing;
    private final com.facebook.common.internal.i<u> inh;
    private final e ini;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b inj;
    private final com.facebook.cache.disk.b ink;
    private final com.facebook.common.memory.c inl;
    private final af inm;
    @Nullable
    private final com.facebook.imagepipeline.b.f inn;
    private final q ino;
    private final com.facebook.imagepipeline.decoder.d inp;
    private final Set<com.facebook.imagepipeline.g.b> inq;
    private final boolean inr;

    /* renamed from: int  reason: not valid java name */
    private final com.facebook.cache.disk.b f1int;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c inu;
    private final i inv;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b bTC;
        this.inv = aVar.iny.bXf();
        this.ind = aVar.ind;
        this.ine = aVar.ine == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.ine;
        this.FJ = aVar.FJ == null ? Bitmap.Config.ARGB_8888 : aVar.FJ;
        if (aVar.imn == null) {
            fVar = com.facebook.imagepipeline.c.j.bVP();
        } else {
            fVar = aVar.imn;
        }
        this.imn = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.ing = aVar.ing == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.ing;
        this.inf = aVar.inf;
        this.inh = aVar.inh == null ? new com.facebook.imagepipeline.c.k() : aVar.inh;
        if (aVar.ily == null) {
            oVar = x.bVZ();
        } else {
            oVar = aVar.ily;
        }
        this.ily = oVar;
        this.inj = aVar.inj;
        this.imU = aVar.imU == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: bWT */
            public Boolean get() {
                return true;
            }
        } : aVar.imU;
        this.ink = aVar.ink == null ? dt(aVar.mContext) : aVar.ink;
        if (aVar.inl == null) {
            cVar = com.facebook.common.memory.d.bTe();
        } else {
            cVar = aVar.inl;
        }
        this.inl = cVar;
        this.inm = aVar.inm == null ? new t() : aVar.inm;
        this.inn = aVar.inn;
        if (aVar.ino == null) {
            qVar = new q(p.bYF().bYG());
        } else {
            qVar = aVar.ino;
        }
        this.ino = qVar;
        this.inp = aVar.inp == null ? new com.facebook.imagepipeline.decoder.f() : aVar.inp;
        this.inq = aVar.inq == null ? new HashSet<>() : aVar.inq;
        this.inr = aVar.inr;
        this.f1int = aVar.f2int == null ? this.ink : aVar.f2int;
        this.inu = aVar.inu;
        this.ini = aVar.ini == null ? new com.facebook.imagepipeline.d.a(this.ino.bYJ()) : aVar.ini;
        com.facebook.common.g.b bXe = this.inv.bXe();
        if (bXe != null) {
            a(bXe, this.inv, new com.facebook.imagepipeline.b.d(bWM()));
        } else if (this.inv.bXb() && com.facebook.common.g.c.igK && (bTC = com.facebook.common.g.c.bTC()) != null) {
            a(bTC, this.inv, new com.facebook.imagepipeline.b.d(bWM()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.igN = bVar;
        b.a bXd = iVar.bXd();
        if (bXd != null) {
            bVar.a(bXd);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b dt(Context context) {
        return com.facebook.cache.disk.b.dp(context).bSK();
    }

    public Bitmap.Config bWk() {
        return this.FJ;
    }

    public com.facebook.common.internal.i<u> bWA() {
        return this.ine;
    }

    public com.facebook.imagepipeline.c.f bWz() {
        return this.imn;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b bWB() {
        return inw;
    }

    public f bWC() {
        return this.ing;
    }

    public boolean bWD() {
        return this.inf;
    }

    public com.facebook.common.internal.i<u> bWE() {
        return this.inh;
    }

    public e bWF() {
        return this.ini;
    }

    public o bWG() {
        return this.ily;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b bWH() {
        return this.inj;
    }

    public com.facebook.common.internal.i<Boolean> bWI() {
        return this.imU;
    }

    public com.facebook.cache.disk.b bWJ() {
        return this.ink;
    }

    public com.facebook.common.memory.c bWK() {
        return this.inl;
    }

    public af bWL() {
        return this.inm;
    }

    public q bWM() {
        return this.ino;
    }

    public com.facebook.imagepipeline.decoder.d bWN() {
        return this.inp;
    }

    public Set<com.facebook.imagepipeline.g.b> bWO() {
        return Collections.unmodifiableSet(this.inq);
    }

    public boolean bWP() {
        return this.inr;
    }

    public com.facebook.cache.disk.b bWQ() {
        return this.f1int;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c bWR() {
        return this.inu;
    }

    public i bWS() {
        return this.inv;
    }

    public static a du(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean inz;

        private b() {
            this.inz = false;
        }

        public boolean bWV() {
            return this.inz;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config FJ;
        private o ily;
        private com.facebook.common.internal.i<Boolean> imU;
        private com.facebook.imagepipeline.c.f imn;
        private com.facebook.imagepipeline.a.a.d ind;
        private com.facebook.common.internal.i<u> ine;
        private boolean inf;
        private f ing;
        private com.facebook.common.internal.i<u> inh;
        private e ini;
        private com.facebook.imagepipeline.decoder.b inj;
        private com.facebook.cache.disk.b ink;
        private com.facebook.common.memory.c inl;
        private af inm;
        private com.facebook.imagepipeline.b.f inn;
        private q ino;
        private com.facebook.imagepipeline.decoder.d inp;
        private Set<com.facebook.imagepipeline.g.b> inq;
        private boolean inr;

        /* renamed from: int  reason: not valid java name */
        private com.facebook.cache.disk.b f2int;
        private com.facebook.imagepipeline.decoder.c inu;
        private final i.a iny;
        private final Context mContext;

        private a(Context context) {
            this.inf = false;
            this.inr = true;
            this.iny = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h bWU() {
            return new h(this);
        }
    }
}
