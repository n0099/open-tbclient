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
    private final com.facebook.common.memory.a jSr;
    private final com.facebook.common.memory.g jXy;
    private final com.facebook.imagepipeline.c.e jYE;
    private final com.facebook.imagepipeline.c.e jYF;
    private final com.facebook.imagepipeline.c.f jYG;
    private final e jZB;
    private final com.facebook.imagepipeline.decoder.b jZC;
    private final com.facebook.imagepipeline.b.f jZG;
    private final com.facebook.imagepipeline.decoder.d jZI;
    private final boolean jZK;
    @Nullable
    private final q jZV;
    private final boolean jZX;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jZo;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jZp;
    private final boolean jZy;
    private final r kak;
    private final com.facebook.imagepipeline.c.l kap;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.jSr = aVar;
        this.jZC = bVar;
        this.jZI = dVar;
        this.jZy = z;
        this.jZK = z2;
        this.jZX = z3;
        this.jZB = eVar;
        this.jXy = gVar;
        this.jZo = tVar;
        this.jZp = tVar2;
        this.jYE = eVar2;
        this.jYF = eVar3;
        this.kak = rVar;
        this.jZV = qVar;
        this.jYG = fVar;
        this.jZG = fVar2;
        if (i > 0) {
            this.kap = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.kap = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.jZo, this.jYG, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.jYG, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.jZo, this.jYG, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cFY() {
        return new com.facebook.imagepipeline.producers.k(this.jXy);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.jSr, this.jZB.cEY(), this.jZC, this.jZI, this.jZy, this.jZK, this.jZX, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.kap);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.kap);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.jYE, this.jYF, this.jYG, this.kak, this.jZV, this.kap, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.jYG, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.jZp, this.jYG, aiVar);
    }

    public u cFZ() {
        return new u(this.jZB.cEW(), this.jXy, this.mAssetManager);
    }

    public v cGa() {
        return new v(this.jZB.cEW(), this.jXy, this.mContentResolver);
    }

    public w cGb() {
        return new w(this.jZB.cEW(), this.jXy, this.mContentResolver);
    }

    public x cGc() {
        return new x(this.jZB.cEW(), this.jXy, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cGd() {
        return new com.facebook.imagepipeline.producers.z(this.jZB.cEW(), this.jXy);
    }

    public com.facebook.imagepipeline.producers.aa cGe() {
        return new com.facebook.imagepipeline.producers.aa(this.jZB.cEW(), this.jXy, this.mResources);
    }

    public ab cGf() {
        return new ab(this.jZB.cEW());
    }

    public ae a(af afVar) {
        return new ae(this.jXy, this.jSr, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.jZo, this.jYG, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.jZG, this.jZB.cEZ());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.jZB.cEZ(), this.jXy, z && !this.jZy, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.jZB.cFa(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.jZB.cEZ(), this.jXy, aiVar);
    }
}
