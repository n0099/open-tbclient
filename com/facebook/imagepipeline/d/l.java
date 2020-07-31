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
    private final com.facebook.common.memory.a mRb;
    private Resources mResources;
    private final com.facebook.imagepipeline.b.f mWZ;
    private final e mXI;
    private final com.facebook.common.memory.g mZk;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> naO;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> naP;
    private final com.facebook.imagepipeline.c.e naR;
    private final com.facebook.imagepipeline.c.f naS;
    private final int nbC;
    private final int nbD;
    private boolean nbE;
    private final com.facebook.imagepipeline.c.e nbX;
    private final boolean nbc;
    private final com.facebook.imagepipeline.decoder.b nbf;
    private final com.facebook.imagepipeline.decoder.d nbl;
    private final boolean nbm;
    private final boolean nby;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.mRb = aVar;
        this.nbf = bVar;
        this.nbl = dVar;
        this.nbc = z;
        this.nbm = z2;
        this.nby = z3;
        this.mXI = eVar;
        this.mZk = gVar;
        this.naO = pVar;
        this.naP = pVar2;
        this.nbX = eVar2;
        this.naR = eVar3;
        this.naS = fVar;
        this.mWZ = fVar2;
        this.nbC = i;
        this.nbD = i2;
        this.nbE = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.naO, this.naS, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.naS, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.naO, this.naS, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dHC() {
        return new com.facebook.imagepipeline.producers.l(this.mZk);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.mRb, this.mXI.dGy(), this.nbf, this.nbl, this.nbc, this.nbm, this.nby, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.nbX, this.naR, this.naS, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.nbX, this.naR, this.naS, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.nbX, this.naS, this.mZk, this.mRb, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.naS, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.naP, this.naS, ajVar);
    }

    public v dHD() {
        return new v(this.mXI.dGw(), this.mZk, this.mAssetManager);
    }

    public w dHE() {
        return new w(this.mXI.dGw(), this.mZk, this.mContentResolver);
    }

    public x dHF() {
        return new x(this.mXI.dGw(), this.mZk, this.mContentResolver);
    }

    public y dHG() {
        return new y(this.mXI.dGw(), this.mZk, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dHH() {
        return new aa(this.mXI.dGw(), this.mZk);
    }

    public an dHI() {
        return new an(this.mXI.dGw(), this.mZk, this.mContentResolver);
    }

    public ab dHJ() {
        return new ab(this.mXI.dGw(), this.mZk, this.mResources);
    }

    public ac dHK() {
        return new ac(this.mXI.dGw(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.mZk, this.mRb, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.naO, this.naS, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.mWZ, this.mXI.dGz());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.mXI.dGz(), this.mZk, z && !this.nbc, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.mXI.dGA(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.mXI.dGz(), this.mZk, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.nbC, this.nbD, this.nbE);
    }
}
