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
    private final com.facebook.common.memory.a mIZ;
    private final com.facebook.imagepipeline.b.f mOP;
    private final e mPA;
    private final com.facebook.common.memory.g mRd;
    private Resources mResources;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSJ;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mSK;
    private final com.facebook.imagepipeline.c.e mSM;
    private final com.facebook.imagepipeline.c.f mSN;
    private final boolean mSY;
    private final int mTA;
    private final int mTB;
    private boolean mTC;
    private final com.facebook.imagepipeline.c.e mTV;
    private final com.facebook.imagepipeline.decoder.b mTb;
    private final com.facebook.imagepipeline.decoder.d mTh;
    private final boolean mTi;
    private final boolean mTw;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.mIZ = aVar;
        this.mTb = bVar;
        this.mTh = dVar;
        this.mSY = z;
        this.mTi = z2;
        this.mTw = z3;
        this.mPA = eVar;
        this.mRd = gVar;
        this.mSJ = pVar;
        this.mSK = pVar2;
        this.mTV = eVar2;
        this.mSM = eVar3;
        this.mSN = fVar;
        this.mOP = fVar2;
        this.mTA = i;
        this.mTB = i2;
        this.mTC = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.mSJ, this.mSN, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.mSN, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.mSJ, this.mSN, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dEq() {
        return new com.facebook.imagepipeline.producers.l(this.mRd);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.mIZ, this.mPA.dDm(), this.mTb, this.mTh, this.mSY, this.mTi, this.mTw, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.mTV, this.mSM, this.mSN, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.mTV, this.mSM, this.mSN, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.mTV, this.mSN, this.mRd, this.mIZ, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.mSN, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.mSK, this.mSN, ajVar);
    }

    public v dEr() {
        return new v(this.mPA.dDk(), this.mRd, this.mAssetManager);
    }

    public w dEs() {
        return new w(this.mPA.dDk(), this.mRd, this.mContentResolver);
    }

    public x dEt() {
        return new x(this.mPA.dDk(), this.mRd, this.mContentResolver);
    }

    public y dEu() {
        return new y(this.mPA.dDk(), this.mRd, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dEv() {
        return new aa(this.mPA.dDk(), this.mRd);
    }

    public an dEw() {
        return new an(this.mPA.dDk(), this.mRd, this.mContentResolver);
    }

    public ab dEx() {
        return new ab(this.mPA.dDk(), this.mRd, this.mResources);
    }

    public ac dEy() {
        return new ac(this.mPA.dDk(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.mRd, this.mIZ, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.mSJ, this.mSN, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.mOP, this.mPA.dDn());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.mPA.dDn(), this.mRd, z && !this.mSY, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.mPA.dDo(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.mPA.dDn(), this.mRd, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.mTA, this.mTB, this.mTC);
    }
}
