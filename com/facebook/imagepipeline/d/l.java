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
/* loaded from: classes12.dex */
public class l {
    private final com.facebook.common.memory.a lIQ;
    private final com.facebook.imagepipeline.b.f lOv;
    private final e lPe;
    private final com.facebook.common.memory.g lQD;
    private final com.facebook.imagepipeline.decoder.d lSE;
    private final boolean lSF;
    private final boolean lSR;
    private final int lSV;
    private final int lSW;
    private boolean lSX;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lSh;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lSi;
    private final com.facebook.imagepipeline.c.e lSk;
    private final com.facebook.imagepipeline.c.f lSl;
    private final boolean lSv;
    private final com.facebook.imagepipeline.decoder.b lSy;
    private final com.facebook.imagepipeline.c.e lTq;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.lIQ = aVar;
        this.lSy = bVar;
        this.lSE = dVar;
        this.lSv = z;
        this.lSF = z2;
        this.lSR = z3;
        this.lPe = eVar;
        this.lQD = gVar;
        this.lSh = pVar;
        this.lSi = pVar2;
        this.lTq = eVar2;
        this.lSk = eVar3;
        this.lSl = fVar;
        this.lOv = fVar2;
        this.lSV = i;
        this.lSW = i2;
        this.lSX = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.lSh, this.lSl, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.lSl, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.lSh, this.lSl, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dpL() {
        return new com.facebook.imagepipeline.producers.l(this.lQD);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.lIQ, this.lPe.doG(), this.lSy, this.lSE, this.lSv, this.lSF, this.lSR, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.lTq, this.lSk, this.lSl, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.lTq, this.lSk, this.lSl, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.lTq, this.lSl, this.lQD, this.lIQ, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.lSl, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.lSi, this.lSl, ajVar);
    }

    public v dpM() {
        return new v(this.lPe.doE(), this.lQD, this.mAssetManager);
    }

    public w dpN() {
        return new w(this.lPe.doE(), this.lQD, this.mContentResolver);
    }

    public x dpO() {
        return new x(this.lPe.doE(), this.lQD, this.mContentResolver);
    }

    public y dpP() {
        return new y(this.lPe.doE(), this.lQD, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dpQ() {
        return new aa(this.lPe.doE(), this.lQD);
    }

    public an dpR() {
        return new an(this.lPe.doE(), this.lQD, this.mContentResolver);
    }

    public ab dpS() {
        return new ab(this.lPe.doE(), this.lQD, this.mResources);
    }

    public ac dpT() {
        return new ac(this.lPe.doE(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.lQD, this.lIQ, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.lSh, this.lSl, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.lOv, this.lPe.doH());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.lPe.doH(), this.lQD, z && !this.lSv, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.lPe.doI(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.lPe.doH(), this.lQD, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.lSV, this.lSW, this.lSX);
    }
}
