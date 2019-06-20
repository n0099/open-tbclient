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
    private final com.facebook.common.memory.a jSu;
    private final com.facebook.common.memory.g jXB;
    private final com.facebook.imagepipeline.c.e jYH;
    private final com.facebook.imagepipeline.c.e jYI;
    private final com.facebook.imagepipeline.c.f jYJ;
    private final boolean jZB;
    private final e jZE;
    private final com.facebook.imagepipeline.decoder.b jZF;
    private final com.facebook.imagepipeline.b.f jZJ;
    private final com.facebook.imagepipeline.decoder.d jZL;
    private final boolean jZN;
    @Nullable
    private final q jZY;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jZr;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jZs;
    private final boolean kaa;
    private final r kan;
    private final com.facebook.imagepipeline.c.l kas;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.jSu = aVar;
        this.jZF = bVar;
        this.jZL = dVar;
        this.jZB = z;
        this.jZN = z2;
        this.kaa = z3;
        this.jZE = eVar;
        this.jXB = gVar;
        this.jZr = tVar;
        this.jZs = tVar2;
        this.jYH = eVar2;
        this.jYI = eVar3;
        this.kan = rVar;
        this.jZY = qVar;
        this.jYJ = fVar;
        this.jZJ = fVar2;
        if (i > 0) {
            this.kas = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.kas = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.jZr, this.jYJ, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.jYJ, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.jZr, this.jYJ, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cFX() {
        return new com.facebook.imagepipeline.producers.k(this.jXB);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.jSu, this.jZE.cEX(), this.jZF, this.jZL, this.jZB, this.jZN, this.kaa, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.kas);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.kas);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.jYH, this.jYI, this.jYJ, this.kan, this.jZY, this.kas, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.jYJ, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.jZs, this.jYJ, aiVar);
    }

    public u cFY() {
        return new u(this.jZE.cEV(), this.jXB, this.mAssetManager);
    }

    public v cFZ() {
        return new v(this.jZE.cEV(), this.jXB, this.mContentResolver);
    }

    public w cGa() {
        return new w(this.jZE.cEV(), this.jXB, this.mContentResolver);
    }

    public x cGb() {
        return new x(this.jZE.cEV(), this.jXB, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cGc() {
        return new com.facebook.imagepipeline.producers.z(this.jZE.cEV(), this.jXB);
    }

    public com.facebook.imagepipeline.producers.aa cGd() {
        return new com.facebook.imagepipeline.producers.aa(this.jZE.cEV(), this.jXB, this.mResources);
    }

    public ab cGe() {
        return new ab(this.jZE.cEV());
    }

    public ae a(af afVar) {
        return new ae(this.jXB, this.jSu, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.jZr, this.jYJ, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.jZJ, this.jZE.cEY());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.jZE.cEY(), this.jXB, z && !this.jZB, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.jZE.cEZ(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.jZE.cEY(), this.jXB, aiVar);
    }
}
