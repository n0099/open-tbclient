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
    private final com.facebook.common.memory.a jSq;
    private final com.facebook.common.memory.g jXx;
    private final com.facebook.imagepipeline.c.e jYD;
    private final com.facebook.imagepipeline.c.e jYE;
    private final com.facebook.imagepipeline.c.f jYF;
    private final e jZA;
    private final com.facebook.imagepipeline.decoder.b jZB;
    private final com.facebook.imagepipeline.b.f jZF;
    private final com.facebook.imagepipeline.decoder.d jZH;
    private final boolean jZJ;
    @Nullable
    private final q jZU;
    private final boolean jZW;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jZn;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jZo;
    private final boolean jZx;
    private final r kaj;
    private final com.facebook.imagepipeline.c.l kao;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.jSq = aVar;
        this.jZB = bVar;
        this.jZH = dVar;
        this.jZx = z;
        this.jZJ = z2;
        this.jZW = z3;
        this.jZA = eVar;
        this.jXx = gVar;
        this.jZn = tVar;
        this.jZo = tVar2;
        this.jYD = eVar2;
        this.jYE = eVar3;
        this.kaj = rVar;
        this.jZU = qVar;
        this.jYF = fVar;
        this.jZF = fVar2;
        if (i > 0) {
            this.kao = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.kao = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.jZn, this.jYF, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.jYF, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.jZn, this.jYF, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cFW() {
        return new com.facebook.imagepipeline.producers.k(this.jXx);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.jSq, this.jZA.cEW(), this.jZB, this.jZH, this.jZx, this.jZJ, this.jZW, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.kao);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.kao);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.jYD, this.jYE, this.jYF, this.kaj, this.jZU, this.kao, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.jYF, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.jZo, this.jYF, aiVar);
    }

    public u cFX() {
        return new u(this.jZA.cEU(), this.jXx, this.mAssetManager);
    }

    public v cFY() {
        return new v(this.jZA.cEU(), this.jXx, this.mContentResolver);
    }

    public w cFZ() {
        return new w(this.jZA.cEU(), this.jXx, this.mContentResolver);
    }

    public x cGa() {
        return new x(this.jZA.cEU(), this.jXx, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cGb() {
        return new com.facebook.imagepipeline.producers.z(this.jZA.cEU(), this.jXx);
    }

    public com.facebook.imagepipeline.producers.aa cGc() {
        return new com.facebook.imagepipeline.producers.aa(this.jZA.cEU(), this.jXx, this.mResources);
    }

    public ab cGd() {
        return new ab(this.jZA.cEU());
    }

    public ae a(af afVar) {
        return new ae(this.jXx, this.jSq, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.jZn, this.jYF, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.jZF, this.jZA.cEX());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.jZA.cEX(), this.jXx, z && !this.jZx, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.jZA.cEY(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.jZA.cEX(), this.jXx, aiVar);
    }
}
