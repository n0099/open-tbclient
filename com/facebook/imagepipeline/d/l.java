package com.facebook.imagepipeline.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.producers.aa;
import com.facebook.imagepipeline.producers.ab;
import com.facebook.imagepipeline.producers.ac;
import com.facebook.imagepipeline.producers.ae;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.ag;
import com.facebook.imagepipeline.producers.ah;
import com.facebook.imagepipeline.producers.ai;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.an;
import com.facebook.imagepipeline.producers.ao;
import com.facebook.imagepipeline.producers.ar;
import com.facebook.imagepipeline.producers.as;
import com.facebook.imagepipeline.producers.at;
import com.facebook.imagepipeline.producers.au;
import com.facebook.imagepipeline.producers.av;
import com.facebook.imagepipeline.producers.aw;
import com.facebook.imagepipeline.producers.ay;
import com.facebook.imagepipeline.producers.o;
import com.facebook.imagepipeline.producers.r;
import com.facebook.imagepipeline.producers.s;
import com.facebook.imagepipeline.producers.v;
import com.facebook.imagepipeline.producers.w;
import com.facebook.imagepipeline.producers.x;
import com.facebook.imagepipeline.producers.y;
/* loaded from: classes4.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private final com.facebook.common.memory.a mRe;
    private Resources mResources;
    private final e mXK;
    private final com.facebook.imagepipeline.b.f mXb;
    private final com.facebook.common.memory.g mZm;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> naQ;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> naR;
    private final com.facebook.imagepipeline.c.e naT;
    private final com.facebook.imagepipeline.c.f naU;
    private final boolean nbA;
    private final int nbE;
    private final int nbF;
    private boolean nbG;
    private final com.facebook.imagepipeline.c.e nbZ;
    private final boolean nbe;
    private final com.facebook.imagepipeline.decoder.b nbh;
    private final com.facebook.imagepipeline.decoder.d nbn;
    private final boolean nbo;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.mRe = aVar;
        this.nbh = bVar;
        this.nbn = dVar;
        this.nbe = z;
        this.nbo = z2;
        this.nbA = z3;
        this.mXK = eVar;
        this.mZm = gVar;
        this.naQ = pVar;
        this.naR = pVar2;
        this.nbZ = eVar2;
        this.naT = eVar3;
        this.naU = fVar;
        this.mXb = fVar2;
        this.nbE = i;
        this.nbF = i2;
        this.nbG = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.naQ, this.naU, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.naU, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.naQ, this.naU, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dHD() {
        return new com.facebook.imagepipeline.producers.l(this.mZm);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.mRe, this.mXK.dGz(), this.nbh, this.nbn, this.nbe, this.nbo, this.nbA, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.nbZ, this.naT, this.naU, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.nbZ, this.naT, this.naU, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.nbZ, this.naU, this.mZm, this.mRe, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.naU, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.naR, this.naU, ajVar);
    }

    public v dHE() {
        return new v(this.mXK.dGx(), this.mZm, this.mAssetManager);
    }

    public w dHF() {
        return new w(this.mXK.dGx(), this.mZm, this.mContentResolver);
    }

    public x dHG() {
        return new x(this.mXK.dGx(), this.mZm, this.mContentResolver);
    }

    public y dHH() {
        return new y(this.mXK.dGx(), this.mZm, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dHI() {
        return new aa(this.mXK.dGx(), this.mZm);
    }

    public an dHJ() {
        return new an(this.mXK.dGx(), this.mZm, this.mContentResolver);
    }

    public ab dHK() {
        return new ab(this.mXK.dGx(), this.mZm, this.mResources);
    }

    public ac dHL() {
        return new ac(this.mXK.dGx(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.mZm, this.mRe, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.naQ, this.naU, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.mXb, this.mXK.dGA());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.mXK.dGA(), this.mZm, z && !this.nbe, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.mXK.dGB(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.mXK.dGA(), this.mZm, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.nbE, this.nbF, this.nbG);
    }
}
