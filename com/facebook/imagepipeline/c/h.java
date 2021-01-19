package com.facebook.imagepipeline.c;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.common.g.b;
import com.facebook.imagepipeline.b.h;
import com.facebook.imagepipeline.b.n;
import com.facebook.imagepipeline.b.q;
import com.facebook.imagepipeline.b.t;
import com.facebook.imagepipeline.c.i;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.u;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class h {
    private static b pyG = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.g.c> pqn;
    @Nullable
    private final com.facebook.imagepipeline.a.f puA;
    private final e pvj;
    private final n pwU;
    private final com.facebook.imagepipeline.decoder.d pyA;
    private final boolean pyB;
    private final com.facebook.cache.disk.b pyC;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c pyD;
    private final i pyE;
    private final boolean pyF;
    private final com.facebook.common.internal.j<Boolean> pyc;
    private final com.facebook.imagepipeline.b.f pyh;
    private final com.facebook.common.internal.j<q> pyp;
    private final h.a pyq;
    private final boolean pyr;
    private final f pys;
    private final com.facebook.common.internal.j<q> pyt;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b pyu;
    private final com.facebook.cache.disk.b pyv;
    private final com.facebook.common.memory.c pyw;
    private final af pyx;
    private final int pyy;
    private final com.facebook.imagepipeline.memory.q pyz;

    private h(a aVar) {
        com.facebook.imagepipeline.b.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b eqC;
        this.pyE = aVar.pyJ.euR();
        this.pyp = aVar.pyp == null ? new com.facebook.imagepipeline.b.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.pyp;
        this.pyq = aVar.pyq == null ? new com.facebook.imagepipeline.b.d() : aVar.pyq;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.pyh == null) {
            fVar = com.facebook.imagepipeline.b.j.ety();
        } else {
            fVar = aVar.pyh;
        }
        this.pyh = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.pys = aVar.pys == null ? new com.facebook.imagepipeline.c.b(new d()) : aVar.pys;
        this.pyr = aVar.pyr;
        this.pyt = aVar.pyt == null ? new com.facebook.imagepipeline.b.k() : aVar.pyt;
        if (aVar.pwU == null) {
            nVar = t.etH();
        } else {
            nVar = aVar.pwU;
        }
        this.pwU = nVar;
        this.pyu = aVar.pyu;
        this.pyc = aVar.pyc == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: eqi */
            public Boolean get() {
                return true;
            }
        } : aVar.pyc;
        this.pyv = aVar.pyv == null ? ii(aVar.mContext) : aVar.pyv;
        if (aVar.pyw == null) {
            cVar = com.facebook.common.memory.d.eqk();
        } else {
            cVar = aVar.pyw;
        }
        this.pyw = cVar;
        this.pyy = aVar.pyI < 0 ? 30000 : aVar.pyI;
        this.pyx = aVar.pyx == null ? new u(this.pyy) : aVar.pyx;
        this.puA = aVar.puA;
        if (aVar.pyz == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.ewD().ewE());
        } else {
            qVar = aVar.pyz;
        }
        this.pyz = qVar;
        this.pyA = aVar.pyA == null ? new com.facebook.imagepipeline.decoder.f() : aVar.pyA;
        this.pqn = aVar.pqn == null ? new HashSet<>() : aVar.pqn;
        this.pyB = aVar.pyB;
        this.pyC = aVar.pyC == null ? this.pyv : aVar.pyC;
        this.pyD = aVar.pyD;
        this.pvj = aVar.pvj == null ? new com.facebook.imagepipeline.c.a(this.pyz.ewH()) : aVar.pvj;
        this.pyF = aVar.pyF;
        com.facebook.common.g.b euJ = this.pyE.euJ();
        if (euJ != null) {
            a(euJ, this.pyE, new com.facebook.imagepipeline.a.d(euw()));
        } else if (this.pyE.euG() && com.facebook.common.g.c.ppu && (eqC = com.facebook.common.g.c.eqC()) != null) {
            a(eqC, this.pyE, new com.facebook.imagepipeline.a.d(euw()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.ppx = bVar;
        b.a euI = iVar.euI();
        if (euI != null) {
            bVar.a(euI);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b ii(Context context) {
        return com.facebook.cache.disk.b.ie(context).epN();
    }

    public Bitmap.Config etS() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> eui() {
        return this.pyp;
    }

    public h.a euj() {
        return this.pyq;
    }

    public com.facebook.imagepipeline.b.f euh() {
        return this.pyh;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b euk() {
        return pyG;
    }

    public f eul() {
        return this.pys;
    }

    public boolean eum() {
        return this.pyr;
    }

    public boolean eun() {
        return this.pyF;
    }

    public com.facebook.common.internal.j<q> euo() {
        return this.pyt;
    }

    public e eup() {
        return this.pvj;
    }

    public n euq() {
        return this.pwU;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b eur() {
        return this.pyu;
    }

    public com.facebook.common.internal.j<Boolean> eus() {
        return this.pyc;
    }

    public com.facebook.cache.disk.b eut() {
        return this.pyv;
    }

    public com.facebook.common.memory.c euu() {
        return this.pyw;
    }

    public af euv() {
        return this.pyx;
    }

    public com.facebook.imagepipeline.memory.q euw() {
        return this.pyz;
    }

    public com.facebook.imagepipeline.decoder.d eux() {
        return this.pyA;
    }

    public Set<com.facebook.imagepipeline.g.c> euy() {
        return Collections.unmodifiableSet(this.pqn);
    }

    public boolean euz() {
        return this.pyB;
    }

    public com.facebook.cache.disk.b euA() {
        return this.pyC;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c euB() {
        return this.pyD;
    }

    public i euC() {
        return this.pyE;
    }

    public static a ij(Context context) {
        return new a(context);
    }

    /* loaded from: classes3.dex */
    public static class b {
        private boolean pyK;

        private b() {
            this.pyK = false;
        }

        public boolean euE() {
            return this.pyK;
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.g.c> pqn;
        private com.facebook.imagepipeline.a.f puA;
        private e pvj;
        private n pwU;
        private com.facebook.imagepipeline.decoder.d pyA;
        private boolean pyB;
        private com.facebook.cache.disk.b pyC;
        private com.facebook.imagepipeline.decoder.c pyD;
        private boolean pyF;
        private int pyI;
        private final i.a pyJ;
        private com.facebook.common.internal.j<Boolean> pyc;
        private com.facebook.imagepipeline.b.f pyh;
        private com.facebook.common.internal.j<q> pyp;
        private h.a pyq;
        private boolean pyr;
        private f pys;
        private com.facebook.common.internal.j<q> pyt;
        private com.facebook.imagepipeline.decoder.b pyu;
        private com.facebook.cache.disk.b pyv;
        private com.facebook.common.memory.c pyw;
        private af pyx;
        private com.facebook.imagepipeline.memory.q pyz;

        private a(Context context) {
            this.pyr = false;
            this.pyB = true;
            this.pyI = -1;
            this.pyJ = new i.a(this);
            this.pyF = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h euD() {
            return new h(this);
        }
    }
}
