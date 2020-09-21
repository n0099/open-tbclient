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
/* loaded from: classes25.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final e nBP;
    private final com.facebook.imagepipeline.b.f nBg;
    private final com.facebook.common.memory.g nDr;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nEV;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> nEW;
    private final com.facebook.imagepipeline.c.e nEY;
    private final com.facebook.imagepipeline.c.f nEZ;
    private final boolean nFF;
    private final int nFJ;
    private final int nFK;
    private boolean nFL;
    private final boolean nFj;
    private final com.facebook.imagepipeline.decoder.b nFm;
    private final com.facebook.imagepipeline.decoder.d nFs;
    private final boolean nFt;
    private final com.facebook.imagepipeline.c.e nGe;
    private final com.facebook.common.memory.a nvq;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.nvq = aVar;
        this.nFm = bVar;
        this.nFs = dVar;
        this.nFj = z;
        this.nFt = z2;
        this.nFF = z3;
        this.nBP = eVar;
        this.nDr = gVar;
        this.nEV = pVar;
        this.nEW = pVar2;
        this.nGe = eVar2;
        this.nEY = eVar3;
        this.nEZ = fVar;
        this.nBg = fVar2;
        this.nFJ = i;
        this.nFK = i2;
        this.nFL = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.nEV, this.nEZ, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.nEZ, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.nEV, this.nEZ, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dXJ() {
        return new com.facebook.imagepipeline.producers.l(this.nDr);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.nvq, this.nBP.dWF(), this.nFm, this.nFs, this.nFj, this.nFt, this.nFF, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.nGe, this.nEY, this.nEZ, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.nGe, this.nEY, this.nEZ, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.nGe, this.nEZ, this.nDr, this.nvq, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.nEZ, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.nEW, this.nEZ, ajVar);
    }

    public v dXK() {
        return new v(this.nBP.dWD(), this.nDr, this.mAssetManager);
    }

    public w dXL() {
        return new w(this.nBP.dWD(), this.nDr, this.mContentResolver);
    }

    public x dXM() {
        return new x(this.nBP.dWD(), this.nDr, this.mContentResolver);
    }

    public y dXN() {
        return new y(this.nBP.dWD(), this.nDr, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dXO() {
        return new aa(this.nBP.dWD(), this.nDr);
    }

    public an dXP() {
        return new an(this.nBP.dWD(), this.nDr, this.mContentResolver);
    }

    public ab dXQ() {
        return new ab(this.nBP.dWD(), this.nDr, this.mResources);
    }

    public ac dXR() {
        return new ac(this.nBP.dWD(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.nDr, this.nvq, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.nEV, this.nEZ, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.nBg, this.nBP.dWG());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.nBP.dWG(), this.nDr, z && !this.nFj, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.nBP.dWH(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.nBP.dWG(), this.nDr, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.nFJ, this.nFK, this.nFL);
    }
}
