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
    private final com.facebook.common.memory.a lHR;
    private final com.facebook.imagepipeline.b.f lNw;
    private final e lOf;
    private final com.facebook.common.memory.g lPE;
    private final com.facebook.imagepipeline.decoder.d lRF;
    private final boolean lRG;
    private final boolean lRS;
    private final int lRW;
    private final int lRX;
    private boolean lRY;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lRi;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lRj;
    private final com.facebook.imagepipeline.c.e lRl;
    private final com.facebook.imagepipeline.c.f lRm;
    private final boolean lRw;
    private final com.facebook.imagepipeline.decoder.b lRz;
    private final com.facebook.imagepipeline.c.e lSr;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.lHR = aVar;
        this.lRz = bVar;
        this.lRF = dVar;
        this.lRw = z;
        this.lRG = z2;
        this.lRS = z3;
        this.lOf = eVar;
        this.lPE = gVar;
        this.lRi = pVar;
        this.lRj = pVar2;
        this.lSr = eVar2;
        this.lRl = eVar3;
        this.lRm = fVar;
        this.lNw = fVar2;
        this.lRW = i;
        this.lRX = i2;
        this.lRY = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.lRi, this.lRm, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.lRm, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.lRi, this.lRm, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dou() {
        return new com.facebook.imagepipeline.producers.l(this.lPE);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.lHR, this.lOf.dno(), this.lRz, this.lRF, this.lRw, this.lRG, this.lRS, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.lSr, this.lRl, this.lRm, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.lSr, this.lRl, this.lRm, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.lSr, this.lRm, this.lPE, this.lHR, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.lRm, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.lRj, this.lRm, ajVar);
    }

    public v dov() {
        return new v(this.lOf.dnm(), this.lPE, this.mAssetManager);
    }

    public w dow() {
        return new w(this.lOf.dnm(), this.lPE, this.mContentResolver);
    }

    public x dox() {
        return new x(this.lOf.dnm(), this.lPE, this.mContentResolver);
    }

    public y doy() {
        return new y(this.lOf.dnm(), this.lPE, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa doz() {
        return new aa(this.lOf.dnm(), this.lPE);
    }

    public an doA() {
        return new an(this.lOf.dnm(), this.lPE, this.mContentResolver);
    }

    public ab doB() {
        return new ab(this.lOf.dnm(), this.lPE, this.mResources);
    }

    public ac doC() {
        return new ac(this.lOf.dnm(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.lPE, this.lHR, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.lRi, this.lRm, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.lNw, this.lOf.dnp());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.lOf.dnp(), this.lPE, z && !this.lRw, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.lOf.dnq(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.lOf.dnp(), this.lPE, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.lRW, this.lRX, this.lRY);
    }
}
