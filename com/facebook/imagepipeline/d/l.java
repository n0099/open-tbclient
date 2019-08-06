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
    private final com.facebook.common.memory.a kaE;
    private final com.facebook.common.memory.g kfM;
    private final com.facebook.imagepipeline.c.e kgT;
    private final com.facebook.imagepipeline.c.e kgU;
    private final com.facebook.imagepipeline.c.f kgV;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> khD;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> khE;
    private final boolean khN;
    private final e khQ;
    private final com.facebook.imagepipeline.decoder.b khR;
    private final com.facebook.imagepipeline.b.f khV;
    private final com.facebook.imagepipeline.decoder.d khX;
    private final boolean khZ;
    private final r kiA;
    private final com.facebook.imagepipeline.c.l kiF;
    @Nullable
    private final q kil;
    private final boolean kin;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.kaE = aVar;
        this.khR = bVar;
        this.khX = dVar;
        this.khN = z;
        this.khZ = z2;
        this.kin = z3;
        this.khQ = eVar;
        this.kfM = gVar;
        this.khD = tVar;
        this.khE = tVar2;
        this.kgT = eVar2;
        this.kgU = eVar3;
        this.kiA = rVar;
        this.kil = qVar;
        this.kgV = fVar;
        this.khV = fVar2;
        if (i > 0) {
            this.kiF = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.kiF = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.khD, this.kgV, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.kgV, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.khD, this.kgV, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cJv() {
        return new com.facebook.imagepipeline.producers.k(this.kfM);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.kaE, this.khQ.cIv(), this.khR, this.khX, this.khN, this.khZ, this.kin, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.kiF);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.kiF);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.kgT, this.kgU, this.kgV, this.kiA, this.kil, this.kiF, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.kgV, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.khE, this.kgV, aiVar);
    }

    public u cJw() {
        return new u(this.khQ.cIt(), this.kfM, this.mAssetManager);
    }

    public v cJx() {
        return new v(this.khQ.cIt(), this.kfM, this.mContentResolver);
    }

    public w cJy() {
        return new w(this.khQ.cIt(), this.kfM, this.mContentResolver);
    }

    public x cJz() {
        return new x(this.khQ.cIt(), this.kfM, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cJA() {
        return new com.facebook.imagepipeline.producers.z(this.khQ.cIt(), this.kfM);
    }

    public com.facebook.imagepipeline.producers.aa cJB() {
        return new com.facebook.imagepipeline.producers.aa(this.khQ.cIt(), this.kfM, this.mResources);
    }

    public ab cJC() {
        return new ab(this.khQ.cIt());
    }

    public ae a(af afVar) {
        return new ae(this.kfM, this.kaE, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.khD, this.kgV, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.khV, this.khQ.cIw());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.khQ.cIw(), this.kfM, z && !this.khN, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.khQ.cIx(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.khQ.cIw(), this.kfM, aiVar);
    }
}
