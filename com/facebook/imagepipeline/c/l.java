package com.facebook.imagepipeline.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
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
/* loaded from: classes3.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final com.facebook.common.memory.g pBc;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pCD;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pCE;
    private final com.facebook.imagepipeline.b.e pCG;
    private final com.facebook.imagepipeline.b.f pCH;
    private final boolean pCR;
    private final com.facebook.imagepipeline.decoder.b pCU;
    private final com.facebook.imagepipeline.b.e pDK;
    private final com.facebook.imagepipeline.decoder.d pDa;
    private final boolean pDb;
    private final boolean pDn;
    private final int pDr;
    private final int pDs;
    private boolean pDt;
    private final com.facebook.common.memory.a ptw;
    private final e pzJ;
    private final com.facebook.imagepipeline.a.f pza;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.ptw = aVar;
        this.pCU = bVar;
        this.pDa = dVar;
        this.pCR = z;
        this.pDb = z2;
        this.pDn = z3;
        this.pzJ = eVar;
        this.pBc = gVar;
        this.pCD = pVar;
        this.pCE = pVar2;
        this.pDK = eVar2;
        this.pCG = eVar3;
        this.pCH = fVar;
        this.pza = fVar2;
        this.pDr = i;
        this.pDs = i2;
        this.pDt = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.pCD, this.pCH, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.pCH, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.pCD, this.pCH, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l eyY() {
        return new com.facebook.imagepipeline.producers.l(this.pBc);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.ptw, this.pzJ.exU(), this.pCU, this.pDa, this.pCR, this.pDb, this.pDn, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new o(this.pDK, this.pCG, this.pCH, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.pDK, this.pCG, this.pCH, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ag(this.pDK, this.pCH, this.pBc, this.ptw, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new r(this.pCH, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new s(this.pCE, this.pCH, ajVar);
    }

    public v eyZ() {
        return new v(this.pzJ.exS(), this.pBc, this.mAssetManager);
    }

    public w eza() {
        return new w(this.pzJ.exS(), this.pBc, this.mContentResolver);
    }

    public x ezb() {
        return new x(this.pzJ.exS(), this.pBc, this.mContentResolver);
    }

    public y ezc() {
        return new y(this.pzJ.exS(), this.pBc, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa ezd() {
        return new aa(this.pzJ.exS(), this.pBc);
    }

    public an eze() {
        return new an(this.pzJ.exS(), this.pBc, this.mContentResolver);
    }

    public ab ezf() {
        return new ab(this.pzJ.exS(), this.pBc, this.mResources);
    }

    public ac ezg() {
        return new ac(this.pzJ.exS(), this.mContentResolver);
    }

    public ae a(af afVar) {
        return new ae(this.pBc, this.ptw, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ah(this.pCD, this.pCH, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ai(ajVar, this.pza, this.pzJ.exV());
    }

    public ao a(aj<com.facebook.imagepipeline.f.e> ajVar, boolean z, boolean z2) {
        return new ao(this.pzJ.exV(), this.pBc, z && !this.pCR, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.pzJ.exW(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ay(this.pzJ.exV(), this.pBc, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.pDr, this.pDs, this.pDt);
    }
}
