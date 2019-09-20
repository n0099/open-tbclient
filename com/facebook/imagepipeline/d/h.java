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
    private static b kkB = new b();
    private final Bitmap.Config Dx;
    private final o kiE;
    private final com.facebook.imagepipeline.c.f kjt;
    private final i kkA;
    private final com.facebook.common.internal.i<Boolean> kka;
    @Nullable
    private final com.facebook.imagepipeline.a.a.d kkj;
    private final com.facebook.common.internal.i<u> kkk;
    private final boolean kkl;
    private final f kkm;
    private final com.facebook.common.internal.i<u> kkn;
    private final e kko;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b kkp;
    private final com.facebook.cache.disk.b kkq;
    private final com.facebook.common.memory.c kkr;
    private final af kks;
    @Nullable
    private final com.facebook.imagepipeline.b.f kkt;
    private final q kku;
    private final com.facebook.imagepipeline.decoder.d kkv;
    private final Set<com.facebook.imagepipeline.g.b> kkw;
    private final boolean kkx;
    private final com.facebook.cache.disk.b kky;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c kkz;
    private final Context mContext;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        o oVar;
        com.facebook.common.memory.c cVar;
        q qVar;
        com.facebook.common.g.b cGm;
        this.kkA = aVar.kkD.cJU();
        this.kkj = aVar.kkj;
        this.kkk = aVar.kkk == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.kkk;
        this.Dx = aVar.Dx == null ? Bitmap.Config.ARGB_8888 : aVar.Dx;
        if (aVar.kjt == null) {
            fVar = com.facebook.imagepipeline.c.j.cIE();
        } else {
            fVar = aVar.kjt;
        }
        this.kjt = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.kkm = aVar.kkm == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.kkm;
        this.kkl = aVar.kkl;
        this.kkn = aVar.kkn == null ? new com.facebook.imagepipeline.c.k() : aVar.kkn;
        if (aVar.kiE == null) {
            oVar = x.cIO();
        } else {
            oVar = aVar.kiE;
        }
        this.kiE = oVar;
        this.kkp = aVar.kkp;
        this.kka = aVar.kka == null ? new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cJI */
            public Boolean get() {
                return true;
            }
        } : aVar.kka;
        this.kkq = aVar.kkq == null ? eF(aVar.mContext) : aVar.kkq;
        if (aVar.kkr == null) {
            cVar = com.facebook.common.memory.d.cFP();
        } else {
            cVar = aVar.kkr;
        }
        this.kkr = cVar;
        this.kks = aVar.kks == null ? new t() : aVar.kks;
        this.kkt = aVar.kkt;
        if (aVar.kku == null) {
            qVar = new q(p.cLz().cLA());
        } else {
            qVar = aVar.kku;
        }
        this.kku = qVar;
        this.kkv = aVar.kkv == null ? new com.facebook.imagepipeline.decoder.f() : aVar.kkv;
        this.kkw = aVar.kkw == null ? new HashSet<>() : aVar.kkw;
        this.kkx = aVar.kkx;
        this.kky = aVar.kky == null ? this.kkq : aVar.kky;
        this.kkz = aVar.kkz;
        this.kko = aVar.kko == null ? new com.facebook.imagepipeline.d.a(this.kku.cLD()) : aVar.kko;
        com.facebook.common.g.b cJT = this.kkA.cJT();
        if (cJT != null) {
            a(cJT, this.kkA, new com.facebook.imagepipeline.b.d(cJB()));
        } else if (this.kkA.cJQ() && com.facebook.common.g.c.kdK && (cGm = com.facebook.common.g.c.cGm()) != null) {
            a(cGm, this.kkA, new com.facebook.imagepipeline.b.d(cJB()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.kdN = bVar;
        b.a cJS = iVar.cJS();
        if (cJS != null) {
            bVar.a(cJS);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b eF(Context context) {
        return com.facebook.cache.disk.b.eB(context).cFv();
    }

    public Bitmap.Config cIZ() {
        return this.Dx;
    }

    public com.facebook.common.internal.i<u> cJp() {
        return this.kkk;
    }

    public com.facebook.imagepipeline.c.f cJo() {
        return this.kjt;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b cJq() {
        return kkB;
    }

    public f cJr() {
        return this.kkm;
    }

    public boolean cJs() {
        return this.kkl;
    }

    public com.facebook.common.internal.i<u> cJt() {
        return this.kkn;
    }

    public e cJu() {
        return this.kko;
    }

    public o cJv() {
        return this.kiE;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b cJw() {
        return this.kkp;
    }

    public com.facebook.common.internal.i<Boolean> cJx() {
        return this.kka;
    }

    public com.facebook.cache.disk.b cJy() {
        return this.kkq;
    }

    public com.facebook.common.memory.c cJz() {
        return this.kkr;
    }

    public af cJA() {
        return this.kks;
    }

    public q cJB() {
        return this.kku;
    }

    public com.facebook.imagepipeline.decoder.d cJC() {
        return this.kkv;
    }

    public Set<com.facebook.imagepipeline.g.b> cJD() {
        return Collections.unmodifiableSet(this.kkw);
    }

    public boolean cJE() {
        return this.kkx;
    }

    public com.facebook.cache.disk.b cJF() {
        return this.kky;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c cJG() {
        return this.kkz;
    }

    public i cJH() {
        return this.kkA;
    }

    public static a eG(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private boolean kkE;

        private b() {
            this.kkE = false;
        }

        public boolean cJK() {
            return this.kkE;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Bitmap.Config Dx;
        private o kiE;
        private com.facebook.imagepipeline.c.f kjt;
        private final i.a kkD;
        private com.facebook.common.internal.i<Boolean> kka;
        private com.facebook.imagepipeline.a.a.d kkj;
        private com.facebook.common.internal.i<u> kkk;
        private boolean kkl;
        private f kkm;
        private com.facebook.common.internal.i<u> kkn;
        private e kko;
        private com.facebook.imagepipeline.decoder.b kkp;
        private com.facebook.cache.disk.b kkq;
        private com.facebook.common.memory.c kkr;
        private af kks;
        private com.facebook.imagepipeline.b.f kkt;
        private q kku;
        private com.facebook.imagepipeline.decoder.d kkv;
        private Set<com.facebook.imagepipeline.g.b> kkw;
        private boolean kkx;
        private com.facebook.cache.disk.b kky;
        private com.facebook.imagepipeline.decoder.c kkz;
        private final Context mContext;

        private a(Context context) {
            this.kkl = false;
            this.kkx = true;
            this.kkD = new i.a(this);
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h cJJ() {
            return new h(this);
        }
    }
}
