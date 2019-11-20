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
    private final com.facebook.common.memory.a kat;
    private final com.facebook.common.memory.g kfD;
    private final com.facebook.imagepipeline.c.e kgL;
    private final com.facebook.imagepipeline.c.e kgM;
    private final com.facebook.imagepipeline.c.f kgN;
    private final boolean khF;
    private final e khI;
    private final com.facebook.imagepipeline.decoder.b khJ;
    private final com.facebook.imagepipeline.b.f khN;
    private final com.facebook.imagepipeline.decoder.d khP;
    private final boolean khR;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> khv;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> khw;
    @Nullable
    private final q kic;
    private final boolean kif;
    private final r kis;
    private final com.facebook.imagepipeline.c.l kix;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.kat = aVar;
        this.khJ = bVar;
        this.khP = dVar;
        this.khF = z;
        this.khR = z2;
        this.kif = z3;
        this.khI = eVar;
        this.kfD = gVar;
        this.khv = tVar;
        this.khw = tVar2;
        this.kgL = eVar2;
        this.kgM = eVar3;
        this.kis = rVar;
        this.kic = qVar;
        this.kgN = fVar;
        this.khN = fVar2;
        if (i > 0) {
            this.kix = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.kix = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.khv, this.kgN, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.kgN, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.khv, this.kgN, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cHe() {
        return new com.facebook.imagepipeline.producers.k(this.kfD);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.kat, this.khI.cGe(), this.khJ, this.khP, this.khF, this.khR, this.kif, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.kix);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.kix);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.kgL, this.kgM, this.kgN, this.kis, this.kic, this.kix, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.kgN, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.khw, this.kgN, aiVar);
    }

    public u cHf() {
        return new u(this.khI.cGc(), this.kfD, this.mAssetManager);
    }

    public v cHg() {
        return new v(this.khI.cGc(), this.kfD, this.mContentResolver);
    }

    public w cHh() {
        return new w(this.khI.cGc(), this.kfD, this.mContentResolver);
    }

    public x cHi() {
        return new x(this.khI.cGc(), this.kfD, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cHj() {
        return new com.facebook.imagepipeline.producers.z(this.khI.cGc(), this.kfD);
    }

    public com.facebook.imagepipeline.producers.aa cHk() {
        return new com.facebook.imagepipeline.producers.aa(this.khI.cGc(), this.kfD, this.mResources);
    }

    public ab cHl() {
        return new ab(this.khI.cGc());
    }

    public ae a(af afVar) {
        return new ae(this.kfD, this.kat, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.khv, this.kgN, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.khN, this.khI.cGf());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.khI.cGf(), this.kfD, z && !this.khF, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.khI.cGg(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.khI.cGf(), this.kfD, aiVar);
    }
}
