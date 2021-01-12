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
    private static b pyF = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.g.c> pqm;
    @Nullable
    private final com.facebook.imagepipeline.a.f puz;
    private final e pvi;
    private final n pwT;
    private final boolean pyA;
    private final com.facebook.cache.disk.b pyB;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c pyC;
    private final i pyD;
    private final boolean pyE;
    private final com.facebook.common.internal.j<Boolean> pyb;
    private final com.facebook.imagepipeline.b.f pyg;
    private final com.facebook.common.internal.j<q> pyo;
    private final h.a pyp;
    private final boolean pyq;
    private final f pyr;
    private final com.facebook.common.internal.j<q> pys;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b pyt;
    private final com.facebook.cache.disk.b pyu;
    private final com.facebook.common.memory.c pyv;
    private final af pyw;
    private final int pyx;
    private final com.facebook.imagepipeline.memory.q pyy;
    private final com.facebook.imagepipeline.decoder.d pyz;

    private h(a aVar) {
        com.facebook.imagepipeline.b.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b eqC;
        this.pyD = aVar.pyI.euR();
        this.pyo = aVar.pyo == null ? new com.facebook.imagepipeline.b.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.pyo;
        this.pyp = aVar.pyp == null ? new com.facebook.imagepipeline.b.d() : aVar.pyp;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.pyg == null) {
            fVar = com.facebook.imagepipeline.b.j.ety();
        } else {
            fVar = aVar.pyg;
        }
        this.pyg = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.pyr = aVar.pyr == null ? new com.facebook.imagepipeline.c.b(new d()) : aVar.pyr;
        this.pyq = aVar.pyq;
        this.pys = aVar.pys == null ? new com.facebook.imagepipeline.b.k() : aVar.pys;
        if (aVar.pwT == null) {
            nVar = t.etH();
        } else {
            nVar = aVar.pwT;
        }
        this.pwT = nVar;
        this.pyt = aVar.pyt;
        this.pyb = aVar.pyb == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: eqi */
            public Boolean get() {
                return true;
            }
        } : aVar.pyb;
        this.pyu = aVar.pyu == null ? ii(aVar.mContext) : aVar.pyu;
        if (aVar.pyv == null) {
            cVar = com.facebook.common.memory.d.eqk();
        } else {
            cVar = aVar.pyv;
        }
        this.pyv = cVar;
        this.pyx = aVar.pyH < 0 ? 30000 : aVar.pyH;
        this.pyw = aVar.pyw == null ? new u(this.pyx) : aVar.pyw;
        this.puz = aVar.puz;
        if (aVar.pyy == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.ewD().ewE());
        } else {
            qVar = aVar.pyy;
        }
        this.pyy = qVar;
        this.pyz = aVar.pyz == null ? new com.facebook.imagepipeline.decoder.f() : aVar.pyz;
        this.pqm = aVar.pqm == null ? new HashSet<>() : aVar.pqm;
        this.pyA = aVar.pyA;
        this.pyB = aVar.pyB == null ? this.pyu : aVar.pyB;
        this.pyC = aVar.pyC;
        this.pvi = aVar.pvi == null ? new com.facebook.imagepipeline.c.a(this.pyy.ewH()) : aVar.pvi;
        this.pyE = aVar.pyE;
        com.facebook.common.g.b euJ = this.pyD.euJ();
        if (euJ != null) {
            a(euJ, this.pyD, new com.facebook.imagepipeline.a.d(euw()));
        } else if (this.pyD.euG() && com.facebook.common.g.c.ppt && (eqC = com.facebook.common.g.c.eqC()) != null) {
            a(eqC, this.pyD, new com.facebook.imagepipeline.a.d(euw()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.ppw = bVar;
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
        return this.pyo;
    }

    public h.a euj() {
        return this.pyp;
    }

    public com.facebook.imagepipeline.b.f euh() {
        return this.pyg;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b euk() {
        return pyF;
    }

    public f eul() {
        return this.pyr;
    }

    public boolean eum() {
        return this.pyq;
    }

    public boolean eun() {
        return this.pyE;
    }

    public com.facebook.common.internal.j<q> euo() {
        return this.pys;
    }

    public e eup() {
        return this.pvi;
    }

    public n euq() {
        return this.pwT;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b eur() {
        return this.pyt;
    }

    public com.facebook.common.internal.j<Boolean> eus() {
        return this.pyb;
    }

    public com.facebook.cache.disk.b eut() {
        return this.pyu;
    }

    public com.facebook.common.memory.c euu() {
        return this.pyv;
    }

    public af euv() {
        return this.pyw;
    }

    public com.facebook.imagepipeline.memory.q euw() {
        return this.pyy;
    }

    public com.facebook.imagepipeline.decoder.d eux() {
        return this.pyz;
    }

    public Set<com.facebook.imagepipeline.g.c> euy() {
        return Collections.unmodifiableSet(this.pqm);
    }

    public boolean euz() {
        return this.pyA;
    }

    public com.facebook.cache.disk.b euA() {
        return this.pyB;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c euB() {
        return this.pyC;
    }

    public i euC() {
        return this.pyD;
    }

    public static a ij(Context context) {
        return new a(context);
    }

    /* loaded from: classes3.dex */
    public static class b {
        private boolean pyJ;

        private b() {
            this.pyJ = false;
        }

        public boolean euE() {
            return this.pyJ;
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.g.c> pqm;
        private com.facebook.imagepipeline.a.f puz;
        private e pvi;
        private n pwT;
        private boolean pyA;
        private com.facebook.cache.disk.b pyB;
        private com.facebook.imagepipeline.decoder.c pyC;
        private boolean pyE;
        private int pyH;
        private final i.a pyI;
        private com.facebook.common.internal.j<Boolean> pyb;
        private com.facebook.imagepipeline.b.f pyg;
        private com.facebook.common.internal.j<q> pyo;
        private h.a pyp;
        private boolean pyq;
        private f pyr;
        private com.facebook.common.internal.j<q> pys;
        private com.facebook.imagepipeline.decoder.b pyt;
        private com.facebook.cache.disk.b pyu;
        private com.facebook.common.memory.c pyv;
        private af pyw;
        private com.facebook.imagepipeline.memory.q pyy;
        private com.facebook.imagepipeline.decoder.d pyz;

        private a(Context context) {
            this.pyq = false;
            this.pyA = true;
            this.pyH = -1;
            this.pyI = new i.a(this);
            this.pyE = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public h euD() {
            return new h(this);
        }
    }
}
