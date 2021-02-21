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
/* loaded from: classes5.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final e pFR;
    private final com.facebook.imagepipeline.a.f pFi;
    private final com.facebook.common.memory.g pHk;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pIL;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pIM;
    private final com.facebook.imagepipeline.b.e pIO;
    private final com.facebook.imagepipeline.b.f pIP;
    private final boolean pIZ;
    private final int pJA;
    private boolean pJB;
    private final com.facebook.imagepipeline.b.e pJS;
    private final com.facebook.imagepipeline.decoder.b pJc;
    private final com.facebook.imagepipeline.decoder.d pJi;
    private final boolean pJj;
    private final boolean pJv;
    private final int pJz;
    private final com.facebook.common.memory.a pzE;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.pzE = aVar;
        this.pJc = bVar;
        this.pJi = dVar;
        this.pIZ = z;
        this.pJj = z2;
        this.pJv = z3;
        this.pFR = eVar;
        this.pHk = gVar;
        this.pIL = pVar;
        this.pIM = pVar2;
        this.pJS = eVar2;
        this.pIO = eVar3;
        this.pIP = fVar;
        this.pFi = fVar2;
        this.pJz = i;
        this.pJA = i2;
        this.pJB = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.pIL, this.pIP, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.pIP, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.pIL, this.pIP, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l exH() {
        return new com.facebook.imagepipeline.producers.l(this.pHk);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.pzE, this.pFR.ewC(), this.pJc, this.pJi, this.pIZ, this.pJj, this.pJv, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new o(this.pJS, this.pIO, this.pIP, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.pJS, this.pIO, this.pIP, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ag(this.pJS, this.pIP, this.pHk, this.pzE, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new r(this.pIP, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new s(this.pIM, this.pIP, ajVar);
    }

    public v exI() {
        return new v(this.pFR.ewA(), this.pHk, this.mAssetManager);
    }

    public w exJ() {
        return new w(this.pFR.ewA(), this.pHk, this.mContentResolver);
    }

    public x exK() {
        return new x(this.pFR.ewA(), this.pHk, this.mContentResolver);
    }

    public y exL() {
        return new y(this.pFR.ewA(), this.pHk, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa exM() {
        return new aa(this.pFR.ewA(), this.pHk);
    }

    public an exN() {
        return new an(this.pFR.ewA(), this.pHk, this.mContentResolver);
    }

    public ab exO() {
        return new ab(this.pFR.ewA(), this.pHk, this.mResources);
    }

    public ac exP() {
        return new ac(this.pFR.ewA(), this.mContentResolver);
    }

    public ae a(af afVar) {
        return new ae(this.pHk, this.pzE, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ah(this.pIL, this.pIP, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ai(ajVar, this.pFi, this.pFR.ewD());
    }

    public ao a(aj<com.facebook.imagepipeline.f.e> ajVar, boolean z, boolean z2) {
        return new ao(this.pFR.ewD(), this.pHk, z && !this.pIZ, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.pFR.ewE(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ay(this.pFR.ewD(), this.pHk, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.pJz, this.pJA, this.pJB);
    }
}
