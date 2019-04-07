package com.facebook.imagepipeline.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.aa;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.c.r;
import com.facebook.imagepipeline.c.t;
import com.facebook.imagepipeline.c.z;
import com.facebook.imagepipeline.producers.ab;
import com.facebook.imagepipeline.producers.ac;
import com.facebook.imagepipeline.producers.ae;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.ag;
import com.facebook.imagepipeline.producers.ah;
import com.facebook.imagepipeline.producers.ai;
import com.facebook.imagepipeline.producers.am;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.aq;
import com.facebook.imagepipeline.producers.ar;
import com.facebook.imagepipeline.producers.as;
import com.facebook.imagepipeline.producers.at;
import com.facebook.imagepipeline.producers.au;
import com.facebook.imagepipeline.producers.aw;
import com.facebook.imagepipeline.producers.n;
import com.facebook.imagepipeline.producers.o;
import com.facebook.imagepipeline.producers.u;
import com.facebook.imagepipeline.producers.v;
import com.facebook.imagepipeline.producers.w;
import com.facebook.imagepipeline.producers.x;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class l {
    private final com.facebook.common.memory.g jEJ;
    private final com.facebook.imagepipeline.c.e jFP;
    private final com.facebook.imagepipeline.c.e jFQ;
    private final com.facebook.imagepipeline.c.f jFR;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jGA;
    private final boolean jGJ;
    private final e jGM;
    private final com.facebook.imagepipeline.decoder.b jGN;
    private final com.facebook.imagepipeline.b.f jGR;
    private final com.facebook.imagepipeline.decoder.d jGT;
    private final boolean jGV;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jGz;
    private final com.facebook.imagepipeline.c.l jHA;
    @Nullable
    private final q jHg;
    private final boolean jHi;
    private final r jHv;
    private final com.facebook.common.memory.a jzz;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.jzz = aVar;
        this.jGN = bVar;
        this.jGT = dVar;
        this.jGJ = z;
        this.jGV = z2;
        this.jHi = z3;
        this.jGM = eVar;
        this.jEJ = gVar;
        this.jGz = tVar;
        this.jGA = tVar2;
        this.jFP = eVar2;
        this.jFQ = eVar3;
        this.jHv = rVar;
        this.jHg = qVar;
        this.jFR = fVar;
        this.jGR = fVar2;
        if (i > 0) {
            this.jHA = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.jHA = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.jGz, this.jFR, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.jFR, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.jGz, this.jFR, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cya() {
        return new com.facebook.imagepipeline.producers.k(this.jEJ);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.jzz, this.jGM.cxa(), this.jGN, this.jGT, this.jGJ, this.jGV, this.jHi, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.jHA);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.jHA);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.jFP, this.jFQ, this.jFR, this.jHv, this.jHg, this.jHA, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.jFR, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.jGA, this.jFR, aiVar);
    }

    public u cyb() {
        return new u(this.jGM.cwY(), this.jEJ, this.mAssetManager);
    }

    public v cyc() {
        return new v(this.jGM.cwY(), this.jEJ, this.mContentResolver);
    }

    public w cyd() {
        return new w(this.jGM.cwY(), this.jEJ, this.mContentResolver);
    }

    public x cye() {
        return new x(this.jGM.cwY(), this.jEJ, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cyf() {
        return new com.facebook.imagepipeline.producers.z(this.jGM.cwY(), this.jEJ);
    }

    public com.facebook.imagepipeline.producers.aa cyg() {
        return new com.facebook.imagepipeline.producers.aa(this.jGM.cwY(), this.jEJ, this.mResources);
    }

    public ab cyh() {
        return new ab(this.jGM.cwY());
    }

    public ae a(af afVar) {
        return new ae(this.jEJ, this.jzz, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.jGz, this.jFR, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.jGR, this.jGM.cxb());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.jGM.cxb(), this.jEJ, z && !this.jGJ, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.jGM.cxc(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.jGM.cxb(), this.jEJ, aiVar);
    }
}
