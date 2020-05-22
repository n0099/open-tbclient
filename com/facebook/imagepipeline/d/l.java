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
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final com.facebook.common.memory.a mlM;
    private final com.facebook.imagepipeline.b.f mrE;
    private final e mso;
    private final com.facebook.common.memory.g mtR;
    private final boolean mvJ;
    private final com.facebook.imagepipeline.decoder.b mvM;
    private final com.facebook.imagepipeline.decoder.d mvS;
    private final boolean mvT;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mvv;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mvw;
    private final com.facebook.imagepipeline.c.e mvy;
    private final com.facebook.imagepipeline.c.f mvz;
    private final com.facebook.imagepipeline.c.e mwC;
    private final boolean mwf;
    private final int mwj;
    private final int mwk;
    private boolean mwl;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.mlM = aVar;
        this.mvM = bVar;
        this.mvS = dVar;
        this.mvJ = z;
        this.mvT = z2;
        this.mwf = z3;
        this.mso = eVar;
        this.mtR = gVar;
        this.mvv = pVar;
        this.mvw = pVar2;
        this.mwC = eVar2;
        this.mvy = eVar3;
        this.mvz = fVar;
        this.mrE = fVar2;
        this.mwj = i;
        this.mwk = i2;
        this.mwl = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.mvv, this.mvz, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.mvz, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.mvv, this.mvz, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dzw() {
        return new com.facebook.imagepipeline.producers.l(this.mtR);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.mlM, this.mso.dys(), this.mvM, this.mvS, this.mvJ, this.mvT, this.mwf, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.mwC, this.mvy, this.mvz, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.mwC, this.mvy, this.mvz, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.mwC, this.mvz, this.mtR, this.mlM, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.mvz, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.mvw, this.mvz, ajVar);
    }

    public v dzx() {
        return new v(this.mso.dyq(), this.mtR, this.mAssetManager);
    }

    public w dzy() {
        return new w(this.mso.dyq(), this.mtR, this.mContentResolver);
    }

    public x dzz() {
        return new x(this.mso.dyq(), this.mtR, this.mContentResolver);
    }

    public y dzA() {
        return new y(this.mso.dyq(), this.mtR, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dzB() {
        return new aa(this.mso.dyq(), this.mtR);
    }

    public an dzC() {
        return new an(this.mso.dyq(), this.mtR, this.mContentResolver);
    }

    public ab dzD() {
        return new ab(this.mso.dyq(), this.mtR, this.mResources);
    }

    public ac dzE() {
        return new ac(this.mso.dyq(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.mtR, this.mlM, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.mvv, this.mvz, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.mrE, this.mso.dyt());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.mso.dyt(), this.mtR, z && !this.mvJ, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.mso.dyu(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.mso.dyt(), this.mtR, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.mwj, this.mwk, this.mwl);
    }
}
