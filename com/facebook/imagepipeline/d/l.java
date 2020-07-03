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
    private final com.facebook.common.memory.a mIW;
    private final com.facebook.imagepipeline.b.f mOM;
    private final e mPx;
    private final com.facebook.common.memory.g mQZ;
    private Resources mResources;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSG;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mSH;
    private final com.facebook.imagepipeline.c.e mSJ;
    private final com.facebook.imagepipeline.c.f mSK;
    private final boolean mSV;
    private final com.facebook.imagepipeline.decoder.b mSY;
    private final com.facebook.imagepipeline.c.e mTS;
    private final com.facebook.imagepipeline.decoder.d mTe;
    private final boolean mTf;
    private final boolean mTt;
    private final int mTx;
    private final int mTy;
    private boolean mTz;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.mIW = aVar;
        this.mSY = bVar;
        this.mTe = dVar;
        this.mSV = z;
        this.mTf = z2;
        this.mTt = z3;
        this.mPx = eVar;
        this.mQZ = gVar;
        this.mSG = pVar;
        this.mSH = pVar2;
        this.mTS = eVar2;
        this.mSJ = eVar3;
        this.mSK = fVar;
        this.mOM = fVar2;
        this.mTx = i;
        this.mTy = i2;
        this.mTz = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.mSG, this.mSK, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.mSK, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.mSG, this.mSK, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dEm() {
        return new com.facebook.imagepipeline.producers.l(this.mQZ);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.mIW, this.mPx.dDi(), this.mSY, this.mTe, this.mSV, this.mTf, this.mTt, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.mTS, this.mSJ, this.mSK, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.mTS, this.mSJ, this.mSK, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.mTS, this.mSK, this.mQZ, this.mIW, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.mSK, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.mSH, this.mSK, ajVar);
    }

    public v dEn() {
        return new v(this.mPx.dDg(), this.mQZ, this.mAssetManager);
    }

    public w dEo() {
        return new w(this.mPx.dDg(), this.mQZ, this.mContentResolver);
    }

    public x dEp() {
        return new x(this.mPx.dDg(), this.mQZ, this.mContentResolver);
    }

    public y dEq() {
        return new y(this.mPx.dDg(), this.mQZ, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dEr() {
        return new aa(this.mPx.dDg(), this.mQZ);
    }

    public an dEs() {
        return new an(this.mPx.dDg(), this.mQZ, this.mContentResolver);
    }

    public ab dEt() {
        return new ab(this.mPx.dDg(), this.mQZ, this.mResources);
    }

    public ac dEu() {
        return new ac(this.mPx.dDg(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.mQZ, this.mIW, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.mSG, this.mSK, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.mOM, this.mPx.dDj());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.mPx.dDj(), this.mQZ, z && !this.mSV, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.mPx.dDk(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.mPx.dDj(), this.mQZ, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.mTx, this.mTy, this.mTz);
    }
}
