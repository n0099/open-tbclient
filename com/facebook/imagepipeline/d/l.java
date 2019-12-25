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
/* loaded from: classes9.dex */
public class l {
    private final com.facebook.common.memory.a lEt;
    private final com.facebook.imagepipeline.b.f lJL;
    private final e lKu;
    private final com.facebook.common.memory.g lLT;
    private final com.facebook.imagepipeline.c.f lNA;
    private final boolean lNK;
    private final com.facebook.imagepipeline.decoder.b lNN;
    private final com.facebook.imagepipeline.decoder.d lNT;
    private final boolean lNU;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lNw;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lNx;
    private final com.facebook.imagepipeline.c.e lNz;
    private final com.facebook.imagepipeline.c.e lOF;
    private final boolean lOg;
    private final int lOk;
    private final int lOl;
    private boolean lOm;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.lEt = aVar;
        this.lNN = bVar;
        this.lNT = dVar;
        this.lNK = z;
        this.lNU = z2;
        this.lOg = z3;
        this.lKu = eVar;
        this.lLT = gVar;
        this.lNw = pVar;
        this.lNx = pVar2;
        this.lOF = eVar2;
        this.lNz = eVar3;
        this.lNA = fVar;
        this.lJL = fVar2;
        this.lOk = i;
        this.lOl = i2;
        this.lOm = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.lNw, this.lNA, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.lNA, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.lNw, this.lNA, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dnn() {
        return new com.facebook.imagepipeline.producers.l(this.lLT);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.lEt, this.lKu.dmi(), this.lNN, this.lNT, this.lNK, this.lNU, this.lOg, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.lOF, this.lNz, this.lNA, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.lOF, this.lNz, this.lNA, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.lOF, this.lNA, this.lLT, this.lEt, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.lNA, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.lNx, this.lNA, ajVar);
    }

    public v dno() {
        return new v(this.lKu.dmg(), this.lLT, this.mAssetManager);
    }

    public w dnp() {
        return new w(this.lKu.dmg(), this.lLT, this.mContentResolver);
    }

    public x dnq() {
        return new x(this.lKu.dmg(), this.lLT, this.mContentResolver);
    }

    public y dnr() {
        return new y(this.lKu.dmg(), this.lLT, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dnt() {
        return new aa(this.lKu.dmg(), this.lLT);
    }

    public an dnu() {
        return new an(this.lKu.dmg(), this.lLT, this.mContentResolver);
    }

    public ab dnv() {
        return new ab(this.lKu.dmg(), this.lLT, this.mResources);
    }

    public ac dnw() {
        return new ac(this.lKu.dmg(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.lLT, this.lEt, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.lNw, this.lNA, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.lJL, this.lKu.dmj());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.lKu.dmj(), this.lLT, z && !this.lNK, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.lKu.dmk(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.lKu.dmj(), this.lLT, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.lOk, this.lOl, this.lOm);
    }
}
