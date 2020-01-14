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
/* loaded from: classes10.dex */
public class l {
    private final com.facebook.common.memory.a lHW;
    private final com.facebook.imagepipeline.b.f lNB;
    private final e lOk;
    private final com.facebook.common.memory.g lPJ;
    private final boolean lRB;
    private final com.facebook.imagepipeline.decoder.b lRE;
    private final com.facebook.imagepipeline.decoder.d lRK;
    private final boolean lRL;
    private final boolean lRX;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lRn;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lRo;
    private final com.facebook.imagepipeline.c.e lRq;
    private final com.facebook.imagepipeline.c.f lRr;
    private final int lSb;
    private final int lSc;
    private boolean lSd;
    private final com.facebook.imagepipeline.c.e lSw;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.lHW = aVar;
        this.lRE = bVar;
        this.lRK = dVar;
        this.lRB = z;
        this.lRL = z2;
        this.lRX = z3;
        this.lOk = eVar;
        this.lPJ = gVar;
        this.lRn = pVar;
        this.lRo = pVar2;
        this.lSw = eVar2;
        this.lRq = eVar3;
        this.lRr = fVar;
        this.lNB = fVar2;
        this.lSb = i;
        this.lSc = i2;
        this.lSd = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.lRn, this.lRr, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.lRr, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.lRn, this.lRr, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dow() {
        return new com.facebook.imagepipeline.producers.l(this.lPJ);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.lHW, this.lOk.dnq(), this.lRE, this.lRK, this.lRB, this.lRL, this.lRX, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.lSw, this.lRq, this.lRr, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.lSw, this.lRq, this.lRr, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.lSw, this.lRr, this.lPJ, this.lHW, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.lRr, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.lRo, this.lRr, ajVar);
    }

    public v dox() {
        return new v(this.lOk.dno(), this.lPJ, this.mAssetManager);
    }

    public w doy() {
        return new w(this.lOk.dno(), this.lPJ, this.mContentResolver);
    }

    public x doz() {
        return new x(this.lOk.dno(), this.lPJ, this.mContentResolver);
    }

    public y doA() {
        return new y(this.lOk.dno(), this.lPJ, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa doB() {
        return new aa(this.lOk.dno(), this.lPJ);
    }

    public an doC() {
        return new an(this.lOk.dno(), this.lPJ, this.mContentResolver);
    }

    public ab doD() {
        return new ab(this.lOk.dno(), this.lPJ, this.mResources);
    }

    public ac doE() {
        return new ac(this.lOk.dno(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.lPJ, this.lHW, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.lRn, this.lRr, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.lNB, this.lOk.dnr());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.lOk.dnr(), this.lPJ, z && !this.lRB, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.lOk.dnt(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.lOk.dnr(), this.lPJ, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.lSb, this.lSc, this.lSd);
    }
}
