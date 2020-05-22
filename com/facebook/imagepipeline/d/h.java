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
    private static b mvY = new b();
    private final Bitmap.Config mBitmapConfig;
    private final Context mContext;
    private final Set<com.facebook.imagepipeline.h.c> mnf;
    @Nullable
    private final com.facebook.imagepipeline.b.f mrE;
    private final e mso;
    private final n muk;
    private final com.facebook.common.internal.j<q> mvH;
    private final h.a mvI;
    private final boolean mvJ;
    private final f mvK;
    private final com.facebook.common.internal.j<q> mvL;
    @Nullable
    private final com.facebook.imagepipeline.decoder.b mvM;
    private final com.facebook.cache.disk.b mvN;
    private final com.facebook.common.memory.c mvO;
    private final af mvP;
    private final int mvQ;
    private final com.facebook.imagepipeline.memory.q mvR;
    private final com.facebook.imagepipeline.decoder.d mvS;
    private final boolean mvT;
    private final com.facebook.cache.disk.b mvU;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c mvV;
    private final i mvW;
    private final boolean mvX;
    private final com.facebook.common.internal.j<Boolean> mvu;
    private final com.facebook.imagepipeline.c.f mvz;

    private h(a aVar) {
        com.facebook.imagepipeline.c.f fVar;
        n nVar;
        com.facebook.common.memory.c cVar;
        com.facebook.imagepipeline.memory.q qVar;
        com.facebook.common.g.b duM;
        this.mvW = aVar.mwb.dzh();
        this.mvH = aVar.mvH == null ? new com.facebook.imagepipeline.c.i((ActivityManager) aVar.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) : aVar.mvH;
        this.mvI = aVar.mvI == null ? new com.facebook.imagepipeline.c.d() : aVar.mvI;
        this.mBitmapConfig = aVar.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : aVar.mBitmapConfig;
        if (aVar.mvz == null) {
            fVar = com.facebook.imagepipeline.c.j.dxM();
        } else {
            fVar = aVar.mvz;
        }
        this.mvz = fVar;
        this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(aVar.mContext);
        this.mvK = aVar.mvK == null ? new com.facebook.imagepipeline.d.b(new d()) : aVar.mvK;
        this.mvJ = aVar.mvJ;
        this.mvL = aVar.mvL == null ? new com.facebook.imagepipeline.c.k() : aVar.mvL;
        if (aVar.muk == null) {
            nVar = t.dxV();
        } else {
            nVar = aVar.muk;
        }
        this.muk = nVar;
        this.mvM = aVar.mvM;
        this.mvu = aVar.mvu == null ? new com.facebook.common.internal.j<Boolean>() { // from class: com.facebook.imagepipeline.d.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dus */
            public Boolean get() {
                return true;
            }
        } : aVar.mvu;
        this.mvN = aVar.mvN == null ? fW(aVar.mContext) : aVar.mvN;
        if (aVar.mvO == null) {
            cVar = com.facebook.common.memory.d.duu();
        } else {
            cVar = aVar.mvO;
        }
        this.mvO = cVar;
        this.mvQ = aVar.mwa < 0 ? 30000 : aVar.mwa;
        this.mvP = aVar.mvP == null ? new u(this.mvQ) : aVar.mvP;
        this.mrE = aVar.mrE;
        if (aVar.mvR == null) {
            qVar = new com.facebook.imagepipeline.memory.q(p.dAW().dAX());
        } else {
            qVar = aVar.mvR;
        }
        this.mvR = qVar;
        this.mvS = aVar.mvS == null ? new com.facebook.imagepipeline.decoder.f() : aVar.mvS;
        this.mnf = aVar.mnf == null ? new HashSet<>() : aVar.mnf;
        this.mvT = aVar.mvT;
        this.mvU = aVar.mvU == null ? this.mvN : aVar.mvU;
        this.mvV = aVar.mvV;
        this.mso = aVar.mso == null ? new com.facebook.imagepipeline.d.a(this.mvR.dBa()) : aVar.mso;
        this.mvX = aVar.mvX;
        com.facebook.common.g.b dyZ = this.mvW.dyZ();
        if (dyZ != null) {
            a(dyZ, this.mvW, new com.facebook.imagepipeline.b.d(dyM()));
        } else if (this.mvW.dyW() && com.facebook.common.g.c.mml && (duM = com.facebook.common.g.c.duM()) != null) {
            a(duM, this.mvW, new com.facebook.imagepipeline.b.d(dyM()));
        }
    }

    private static void a(com.facebook.common.g.b bVar, i iVar, com.facebook.common.g.a aVar) {
        com.facebook.common.g.c.mmo = bVar;
        b.a dyY = iVar.dyY();
        if (dyY != null) {
            bVar.a(dyY);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    private static com.facebook.cache.disk.b fW(Context context) {
        return com.facebook.cache.disk.b.fS(context).dtW();
    }

    public Bitmap.Config dyh() {
        return this.mBitmapConfig;
    }

    public com.facebook.common.internal.j<q> dyy() {
        return this.mvH;
    }

    public h.a dyz() {
        return this.mvI;
    }

    public com.facebook.imagepipeline.c.f dyx() {
        return this.mvz;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static b dyA() {
        return mvY;
    }

    public f dyB() {
        return this.mvK;
    }

    public boolean dyC() {
        return this.mvJ;
    }

    public boolean dyD() {
        return this.mvX;
    }

    public com.facebook.common.internal.j<q> dyE() {
        return this.mvL;
    }

    public e dyF() {
        return this.mso;
    }

    public n dyG() {
        return this.muk;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.b dyH() {
        return this.mvM;
    }

    public com.facebook.common.internal.j<Boolean> dyI() {
        return this.mvu;
    }

    public com.facebook.cache.disk.b dyJ() {
        return this.mvN;
    }

    public com.facebook.common.memory.c dyK() {
        return this.mvO;
    }

    public af dyL() {
        return this.mvP;
    }

    public com.facebook.imagepipeline.memory.q dyM() {
        return this.mvR;
    }

    public com.facebook.imagepipeline.decoder.d dyN() {
        return this.mvS;
    }

    public Set<com.facebook.imagepipeline.h.c> dyO() {
        return Collections.unmodifiableSet(this.mnf);
    }

    public boolean dyP() {
        return this.mvT;
    }

    public com.facebook.cache.disk.b dyQ() {
        return this.mvU;
    }

    @Nullable
    public com.facebook.imagepipeline.decoder.c dyR() {
        return this.mvV;
    }

    public i dyS() {
        return this.mvW;
    }

    public static a fX(Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class b {
        private boolean mwc;

        private b() {
            this.mwc = false;
        }

        public boolean dyU() {
            return this.mwc;
        }
    }

    /* loaded from: classes12.dex */
    public static class a {
        private Bitmap.Config mBitmapConfig;
        private final Context mContext;
        private Set<com.facebook.imagepipeline.h.c> mnf;
        private com.facebook.imagepipeline.b.f mrE;
        private e mso;
        private n muk;
        private com.facebook.common.internal.j<q> mvH;
        private h.a mvI;
        private boolean mvJ;
        private f mvK;
        private com.facebook.common.internal.j<q> mvL;
        private com.facebook.imagepipeline.decoder.b mvM;
        private com.facebook.cache.disk.b mvN;
        private com.facebook.common.memory.c mvO;
        private af mvP;
        private com.facebook.imagepipeline.memory.q mvR;
        private com.facebook.imagepipeline.decoder.d mvS;
        private boolean mvT;
        private com.facebook.cache.disk.b mvU;
        private com.facebook.imagepipeline.decoder.c mvV;
        private boolean mvX;
        private com.facebook.common.internal.j<Boolean> mvu;
        private com.facebook.imagepipeline.c.f mvz;
        private int mwa;
        private final i.a mwb;

        private a(Context context) {
            this.mvJ = false;
            this.mvT = true;
            this.mwa = -1;
            this.mwb = new i.a(this);
            this.mvX = true;
            this.mContext = (Context) com.facebook.common.internal.g.checkNotNull(context);
        }

        public a d(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public a wh(boolean z) {
            this.mvJ = z;
            return this;
        }

        public a a(com.facebook.common.memory.c cVar) {
            this.mvO = cVar;
            return this;
        }

        public a a(af afVar) {
            this.mvP = afVar;
            return this;
        }

        public a wi(boolean z) {
            this.mvT = z;
            return this;
        }

        public h dyT() {
            return new h(this);
        }
    }
}
