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
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pAW;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pAX;
    private final com.facebook.imagepipeline.b.e pAZ;
    private final boolean pBG;
    private final int pBK;
    private final int pBL;
    private boolean pBM;
    private final com.facebook.imagepipeline.b.f pBa;
    private final boolean pBk;
    private final com.facebook.imagepipeline.decoder.b pBn;
    private final com.facebook.imagepipeline.decoder.d pBt;
    private final boolean pBu;
    private final com.facebook.imagepipeline.b.e pCd;
    private final com.facebook.common.memory.a pto;
    private final e pzo;
    private final com.facebook.imagepipeline.a.f pzp;
    private final com.facebook.common.memory.g pzv;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.pto = aVar;
        this.pBn = bVar;
        this.pBt = dVar;
        this.pBk = z;
        this.pBu = z2;
        this.pBG = z3;
        this.pzo = eVar;
        this.pzv = gVar;
        this.pAW = pVar;
        this.pAX = pVar2;
        this.pCd = eVar2;
        this.pAZ = eVar3;
        this.pBa = fVar;
        this.pzp = fVar2;
        this.pBK = i;
        this.pBL = i2;
        this.pBM = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.pAW, this.pBa, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.pBa, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.pAW, this.pBa, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l eyw() {
        return new com.facebook.imagepipeline.producers.l(this.pzv);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.pto, this.pzo.exs(), this.pBn, this.pBt, this.pBk, this.pBu, this.pBG, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new o(this.pCd, this.pAZ, this.pBa, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.pCd, this.pAZ, this.pBa, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ag(this.pCd, this.pBa, this.pzv, this.pto, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new r(this.pBa, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new s(this.pAX, this.pBa, ajVar);
    }

    public v eyx() {
        return new v(this.pzo.exq(), this.pzv, this.mAssetManager);
    }

    public w eyy() {
        return new w(this.pzo.exq(), this.pzv, this.mContentResolver);
    }

    public x eyz() {
        return new x(this.pzo.exq(), this.pzv, this.mContentResolver);
    }

    public y eyA() {
        return new y(this.pzo.exq(), this.pzv, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa eyB() {
        return new aa(this.pzo.exq(), this.pzv);
    }

    public an eyC() {
        return new an(this.pzo.exq(), this.pzv, this.mContentResolver);
    }

    public ab eyD() {
        return new ab(this.pzo.exq(), this.pzv, this.mResources);
    }

    public ac eyE() {
        return new ac(this.pzo.exq(), this.mContentResolver);
    }

    public ae a(af afVar) {
        return new ae(this.pzv, this.pto, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ah(this.pAW, this.pBa, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ai(ajVar, this.pzp, this.pzo.ext());
    }

    public ao a(aj<com.facebook.imagepipeline.f.e> ajVar, boolean z, boolean z2) {
        return new ao(this.pzo.ext(), this.pzv, z && !this.pBk, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.pzo.exu(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ay(this.pzo.ext(), this.pzv, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.pBK, this.pBL, this.pBM);
    }
}
