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
/* loaded from: classes8.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final com.facebook.common.memory.a nlq;
    private final e nrR;
    private final com.facebook.imagepipeline.b.f nri;
    private final com.facebook.common.memory.g ntt;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nuY;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> nuZ;
    private final boolean nvI;
    private final int nvM;
    private final int nvN;
    private boolean nvO;
    private final com.facebook.imagepipeline.c.e nvb;
    private final com.facebook.imagepipeline.c.f nvc;
    private final boolean nvm;
    private final com.facebook.imagepipeline.decoder.b nvp;
    private final com.facebook.imagepipeline.decoder.d nvv;
    private final boolean nvw;
    private final com.facebook.imagepipeline.c.e nwh;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.nlq = aVar;
        this.nvp = bVar;
        this.nvv = dVar;
        this.nvm = z;
        this.nvw = z2;
        this.nvI = z3;
        this.nrR = eVar;
        this.ntt = gVar;
        this.nuY = pVar;
        this.nuZ = pVar2;
        this.nwh = eVar2;
        this.nvb = eVar3;
        this.nvc = fVar;
        this.nri = fVar2;
        this.nvM = i;
        this.nvN = i2;
        this.nvO = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.nuY, this.nvc, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.nvc, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.nuY, this.nvc, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dTL() {
        return new com.facebook.imagepipeline.producers.l(this.ntt);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.nlq, this.nrR.dSH(), this.nvp, this.nvv, this.nvm, this.nvw, this.nvI, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.nwh, this.nvb, this.nvc, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.nwh, this.nvb, this.nvc, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.nwh, this.nvc, this.ntt, this.nlq, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.nvc, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.nuZ, this.nvc, ajVar);
    }

    public v dTM() {
        return new v(this.nrR.dSF(), this.ntt, this.mAssetManager);
    }

    public w dTN() {
        return new w(this.nrR.dSF(), this.ntt, this.mContentResolver);
    }

    public x dTO() {
        return new x(this.nrR.dSF(), this.ntt, this.mContentResolver);
    }

    public y dTP() {
        return new y(this.nrR.dSF(), this.ntt, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dTQ() {
        return new aa(this.nrR.dSF(), this.ntt);
    }

    public an dTR() {
        return new an(this.nrR.dSF(), this.ntt, this.mContentResolver);
    }

    public ab dTS() {
        return new ab(this.nrR.dSF(), this.ntt, this.mResources);
    }

    public ac dTT() {
        return new ac(this.nrR.dSF(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.ntt, this.nlq, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.nuY, this.nvc, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.nri, this.nrR.dSI());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.nrR.dSI(), this.ntt, z && !this.nvm, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.nrR.dSJ(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.nrR.dSI(), this.ntt, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.nvM, this.nvN, this.nvO);
    }
}
