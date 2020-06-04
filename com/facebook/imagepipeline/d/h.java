package com.facebook.imagepipeline.d;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.c.n;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.c.t;
import com.facebook.imagepipeline.d.i;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.u;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class h {
    private static b mxi = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> moq;
    @Nullable
    private final com.facebook.imagepipeline.b.f msP;
    private final e mty;
    private final n mvu;
    private final com.facebook.common.internal.j<Boolean> mwE;
    private final com.facebook.imagepipeline.c.f mwJ;
    private final com.facebook.common.internal.j<q> mwR;
    private final h.a mwS;
    private final boolean mwT;
    private final f mwU;
    private final com.facebook.common.internal.j<q> mwV;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b mwW;
    private final com.facebook.cache.disk.b mwX;
    private final com.facebook.common.memory.c mwY;
    private final af mwZ;
    private final int mxa;
    private final com.facebook.imagepipeline.memory.q mxb;
    private final com.facebook.imagepipeline.decoder.d mxc;
    private final boolean mxd;
    private final com.facebook.cache.disk.b mxe;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c mxf;
    private final i mxg;
    private final boolean mxh;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b dva;
        this.mxg = aVar.mxl.dzv();
        this.mwR = aVar.mwR == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.mwR;
        this.mwS = aVar.mwS == null ? new com.facebook.imagepipeline.c.d() : aVar.mwS;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.mwJ == null) {
            fVar = com.facebook.imagepipeline.c.j.dya();
        } else {
            fVar = aVar.mwJ;
        }
        this.mwJ = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.mwU = aVar.mwU == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.mwU;
        this.mwT = aVar.mwT;
        this.mwV = aVar.mwV == null ? new com.facebook.imagepipeline.c.k() : aVar.mwV;
        if (aVar.mvu == null) {
            nVar = t.dyj();
        } else {
            nVar = aVar.mvu;
        }
        this.mvu = nVar;
        this.mwW = aVar.mwW;
        this.mwE = aVar.mwE == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: duG */
            public Boolean get() {
                return true;
            }
        } : aVar.mwE;
        this.mwX = aVar.mwX == null ? fW(aVar.mContext) : aVar.mwX;
        if (aVar.mwY == null) {
            cVar = com.facebook.common.memory.d.duI();
        } else {
            cVar = aVar.mwY;
        }
        this.mwY = cVar;
        this.mxa = aVar.mxk < 0 ? 30000 : aVar.mxk;
        this.mwZ = aVar.mwZ == null ? new u(this.mxa) : aVar.mwZ;
        this.msP = aVar.msP;
        if (aVar.mxb == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dBk().dBl());
        } else {
            qVar = aVar.mxb;
        }
        this.mxb = qVar;
        this.mxc = aVar.mxc == null ? new com.facebook.imagepipeline.decoder.f() : aVar.mxc;
        this.moq = aVar.moq == null ? new HashSet<>() : aVar.moq;
        this.mxd = aVar.mxd;
        this.mxe = aVar.mxe == null ? this.mwX : aVar.mxe;
        this.mxf = aVar.mxf;
        this.mty = aVar.mty == null ? new com.facebook.imagepipeline.d.a(this.mxb.dBo()) : aVar.mty;
        this.mxh = aVar.mxh;
        com.facebook.common.g.b dzn = this.mxg.dzn();
        if (dzn != null) {
            a(dzn, this.mxg, new com.facebook.imagepipeline.b.d(dza()));
        } else if (this.mxg.dzk() && com.facebook.common.g.c.mnv && (dva = com.facebook.common.g.c.dva()) != null) {
            a(dva, this.mxg, new com.facebook.imagepipeline.b.d(dza()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.mny = bVar;
        b.a dzm = iVar.dzm();
        if (dzm != null) {
            bVar.a(dzm);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b fW(Context context) {
        return com.facebook.cache.disk.b.fS(context).duk();
    }

    public Bitmap.Config dyv() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dyM() {
        return this.mwR;
    }

    public h.a dyN() {
        return this.mwS;
    }

    public com.facebook.imagepipeline.c.f dyL() {
        return this.mwJ;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dyO() {
        return mxi;
    }

    public f dyP() {
        return this.mwU;
    }

    public boolean dyQ() {
        return this.mwT;
    }

    public boolean dyR() {
        return this.mxh;
    }

    public com.facebook.common.internal.j<q> dyS() {
        return this.mwV;
    }

    public e dyT() {
        return this.mty;
    }

    public n dyU() {
        return this.mvu;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dyV() {
        return this.mwW;
    }

    public com.facebook.common.internal.j<Boolean> dyW() {
        return this.mwE;
    }

    public com.facebook.cache.disk.b dyX() {
        return this.mwX;
    }

    public com.facebook.common.memory.c dyY() {
        return this.mwY;
    }

    public af dyZ() {
        return this.mwZ;
    }

    public com.facebook.imagepipeline.memory.q dza() {
        return this.mxb;
    }

    public com.facebook.imagepipeline.decoder.d dzb() {
        return this.mxc;
    }

    public Set<com.facebook.imagepipeline.h.c> dzc() {
        return Collections.unmodifiableSet(this.moq);
    }

    public boolean dzd() {
        return this.mxd;
    }

    public com.facebook.cache.disk.b dze() {
        return this.mxe;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dzf() {
        return this.mxf;
    }

    public i dzg() {
        return this.mxg;
    }

    public static a fX(Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class b {
        private boolean mxm;

        private b() {
            this.mxm = false;
        }

        public boolean dzi() {
            return this.mxm;
        }
    }

    /* loaded from: classes12.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> moq;
        private com.facebook.imagepipeline.b.f msP;
        private e mty;
        private n mvu;
        private com.facebook.common.internal.j<Boolean> mwE;
        private com.facebook.imagepipeline.c.f mwJ;
        private com.facebook.common.internal.j<q> mwR;
        private h.a mwS;
        private boolean mwT;
        private f mwU;
        private com.facebook.common.internal.j<q> mwV;
        private com.facebook.imagepipeline.decoder.b mwW;
        private com.facebook.cache.disk.b mwX;
        private com.facebook.common.memory.c mwY;
        private af mwZ;
        private com.facebook.imagepipeline.memory.q mxb;
        private com.facebook.imagepipeline.decoder.d mxc;
        private boolean mxd;
        private com.facebook.cache.disk.b mxe;
        private com.facebook.imagepipeline.decoder.c mxf;
        private boolean mxh;
        private int mxk;
        private final i.a mxl;

        private a(Context context) {
            this.mwT = false;
            this.mxd = true;
            this.mxk = -1;
            this.mxl = new i.a(this);
            this.mxh = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a wj(boolean z) {
            this.mwT = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.mwY = cVar;
            return this;
        }

        public a a(af afVar) {
            this.mwZ = afVar;
            return this;
        }

        public a wk(boolean z) {
            this.mxd = z;
            return this;
        }

        public h dzh() {
            return new h(this);
        }
    }
}
