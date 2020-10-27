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
/* loaded from: classes18.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final com.facebook.common.memory.a oCc;
    private final com.facebook.imagepipeline.b.f oHR;
    private final e oIA;
    private final com.facebook.common.memory.g oKc;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oLG;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> oLH;
    private final com.facebook.imagepipeline.c.e oLJ;
    private final com.facebook.imagepipeline.c.f oLK;
    private final boolean oLU;
    private final com.facebook.imagepipeline.decoder.b oLX;
    private final com.facebook.imagepipeline.c.e oMN;
    private final com.facebook.imagepipeline.decoder.d oMd;
    private final boolean oMe;
    private final boolean oMq;
    private final int oMu;
    private final int oMv;
    private boolean oMw;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.oCc = aVar;
        this.oLX = bVar;
        this.oMd = dVar;
        this.oLU = z;
        this.oMe = z2;
        this.oMq = z3;
        this.oIA = eVar;
        this.oKc = gVar;
        this.oLG = pVar;
        this.oLH = pVar2;
        this.oMN = eVar2;
        this.oLJ = eVar3;
        this.oLK = fVar;
        this.oHR = fVar2;
        this.oMu = i;
        this.oMv = i2;
        this.oMw = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.oLG, this.oLK, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.oLK, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.oLG, this.oLK, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l els() {
        return new com.facebook.imagepipeline.producers.l(this.oKc);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.oCc, this.oIA.eko(), this.oLX, this.oMd, this.oLU, this.oMe, this.oMq, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.oMN, this.oLJ, this.oLK, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.oMN, this.oLJ, this.oLK, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.oMN, this.oLK, this.oKc, this.oCc, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.oLK, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.oLH, this.oLK, ajVar);
    }

    public v elt() {
        return new v(this.oIA.ekm(), this.oKc, this.mAssetManager);
    }

    public w elu() {
        return new w(this.oIA.ekm(), this.oKc, this.mContentResolver);
    }

    public x elv() {
        return new x(this.oIA.ekm(), this.oKc, this.mContentResolver);
    }

    public y elw() {
        return new y(this.oIA.ekm(), this.oKc, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa elx() {
        return new aa(this.oIA.ekm(), this.oKc);
    }

    public an ely() {
        return new an(this.oIA.ekm(), this.oKc, this.mContentResolver);
    }

    public ab elz() {
        return new ab(this.oIA.ekm(), this.oKc, this.mResources);
    }

    public ac elA() {
        return new ac(this.oIA.ekm(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.oKc, this.oCc, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.oLG, this.oLK, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.oHR, this.oIA.ekp());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.oIA.ekp(), this.oKc, z && !this.oLU, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.oIA.ekq(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.oIA.ekp(), this.oKc, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.oMu, this.oMv, this.oMw);
    }
}
