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
    private final com.facebook.common.memory.a lKw;
    private final e lQK;
    private final com.facebook.imagepipeline.b.f lQb;
    private final com.facebook.common.memory.g lSj;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTN;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lTO;
    private final com.facebook.imagepipeline.c.e lTQ;
    private final com.facebook.imagepipeline.c.f lTR;
    private final int lUB;
    private final int lUC;
    private boolean lUD;
    private final com.facebook.imagepipeline.c.e lUW;
    private final boolean lUb;
    private final com.facebook.imagepipeline.decoder.b lUe;
    private final com.facebook.imagepipeline.decoder.d lUk;
    private final boolean lUl;
    private final boolean lUx;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.lKw = aVar;
        this.lUe = bVar;
        this.lUk = dVar;
        this.lUb = z;
        this.lUl = z2;
        this.lUx = z3;
        this.lQK = eVar;
        this.lSj = gVar;
        this.lTN = pVar;
        this.lTO = pVar2;
        this.lUW = eVar2;
        this.lTQ = eVar3;
        this.lTR = fVar;
        this.lQb = fVar2;
        this.lUB = i;
        this.lUC = i2;
        this.lUD = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.lTN, this.lTR, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.lTR, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.lTN, this.lTR, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dqi() {
        return new com.facebook.imagepipeline.producers.l(this.lSj);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.lKw, this.lQK.dpd(), this.lUe, this.lUk, this.lUb, this.lUl, this.lUx, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.lUW, this.lTQ, this.lTR, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.lUW, this.lTQ, this.lTR, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.lUW, this.lTR, this.lSj, this.lKw, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.lTR, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.lTO, this.lTR, ajVar);
    }

    public v dqj() {
        return new v(this.lQK.dpb(), this.lSj, this.mAssetManager);
    }

    public w dqk() {
        return new w(this.lQK.dpb(), this.lSj, this.mContentResolver);
    }

    public x dql() {
        return new x(this.lQK.dpb(), this.lSj, this.mContentResolver);
    }

    public y dqm() {
        return new y(this.lQK.dpb(), this.lSj, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dqn() {
        return new aa(this.lQK.dpb(), this.lSj);
    }

    public an dqo() {
        return new an(this.lQK.dpb(), this.lSj, this.mContentResolver);
    }

    public ab dqp() {
        return new ab(this.lQK.dpb(), this.lSj, this.mResources);
    }

    public ac dqq() {
        return new ac(this.lQK.dpb(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.lSj, this.lKw, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.lTN, this.lTR, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.lQb, this.lQK.dpe());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.lQK.dpe(), this.lSj, z && !this.lUb, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.lQK.dpf(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.lQK.dpe(), this.lSj, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.lUB, this.lUC, this.lUD);
    }
}
