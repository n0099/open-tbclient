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
    private final com.facebook.common.memory.a kbk;
    private final com.facebook.common.memory.g kgu;
    private final com.facebook.imagepipeline.c.e khC;
    private final com.facebook.imagepipeline.c.e khD;
    private final com.facebook.imagepipeline.c.f khE;
    private final e kiA;
    private final com.facebook.imagepipeline.decoder.b kiB;
    private final com.facebook.imagepipeline.b.f kiF;
    private final com.facebook.imagepipeline.decoder.d kiH;
    private final boolean kiJ;
    @Nullable
    private final q kiU;
    private final boolean kiW;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kin;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> kio;
    private final boolean kix;
    private final r kjj;
    private final com.facebook.imagepipeline.c.l kjo;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.kbk = aVar;
        this.kiB = bVar;
        this.kiH = dVar;
        this.kix = z;
        this.kiJ = z2;
        this.kiW = z3;
        this.kiA = eVar;
        this.kgu = gVar;
        this.kin = tVar;
        this.kio = tVar2;
        this.khC = eVar2;
        this.khD = eVar3;
        this.kjj = rVar;
        this.kiU = qVar;
        this.khE = fVar;
        this.kiF = fVar2;
        if (i > 0) {
            this.kjo = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.kjo = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.kin, this.khE, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.khE, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.kin, this.khE, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cHg() {
        return new com.facebook.imagepipeline.producers.k(this.kgu);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.kbk, this.kiA.cGg(), this.kiB, this.kiH, this.kix, this.kiJ, this.kiW, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.kjo);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.kjo);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.khC, this.khD, this.khE, this.kjj, this.kiU, this.kjo, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.khE, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.kio, this.khE, aiVar);
    }

    public u cHh() {
        return new u(this.kiA.cGe(), this.kgu, this.mAssetManager);
    }

    public v cHi() {
        return new v(this.kiA.cGe(), this.kgu, this.mContentResolver);
    }

    public w cHj() {
        return new w(this.kiA.cGe(), this.kgu, this.mContentResolver);
    }

    public x cHk() {
        return new x(this.kiA.cGe(), this.kgu, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cHl() {
        return new com.facebook.imagepipeline.producers.z(this.kiA.cGe(), this.kgu);
    }

    public com.facebook.imagepipeline.producers.aa cHm() {
        return new com.facebook.imagepipeline.producers.aa(this.kiA.cGe(), this.kgu, this.mResources);
    }

    public ab cHn() {
        return new ab(this.kiA.cGe());
    }

    public ae a(af afVar) {
        return new ae(this.kgu, this.kbk, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.kin, this.khE, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.kiF, this.kiA.cGh());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.kiA.cGh(), this.kgu, z && !this.kix, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.kiA.cGi(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.kiA.cGh(), this.kgu, aiVar);
    }
}
