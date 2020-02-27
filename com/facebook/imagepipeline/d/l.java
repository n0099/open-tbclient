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
    private final com.facebook.common.memory.a lID;
    private final e lOR;
    private final com.facebook.imagepipeline.b.f lOi;
    private final com.facebook.common.memory.g lQq;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lRU;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lRV;
    private final com.facebook.imagepipeline.c.e lRX;
    private final com.facebook.imagepipeline.c.f lRY;
    private final boolean lSE;
    private final int lSI;
    private final int lSJ;
    private boolean lSK;
    private final boolean lSi;
    private final com.facebook.imagepipeline.decoder.b lSl;
    private final com.facebook.imagepipeline.decoder.d lSr;
    private final boolean lSs;
    private final com.facebook.imagepipeline.c.e lTd;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.lID = aVar;
        this.lSl = bVar;
        this.lSr = dVar;
        this.lSi = z;
        this.lSs = z2;
        this.lSE = z3;
        this.lOR = eVar;
        this.lQq = gVar;
        this.lRU = pVar;
        this.lRV = pVar2;
        this.lTd = eVar2;
        this.lRX = eVar3;
        this.lRY = fVar;
        this.lOi = fVar2;
        this.lSI = i;
        this.lSJ = i2;
        this.lSK = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.lRU, this.lRY, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.lRY, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.lRU, this.lRY, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dpI() {
        return new com.facebook.imagepipeline.producers.l(this.lQq);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.lID, this.lOR.doD(), this.lSl, this.lSr, this.lSi, this.lSs, this.lSE, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.lTd, this.lRX, this.lRY, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.lTd, this.lRX, this.lRY, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.lTd, this.lRY, this.lQq, this.lID, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.lRY, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.lRV, this.lRY, ajVar);
    }

    public v dpJ() {
        return new v(this.lOR.doB(), this.lQq, this.mAssetManager);
    }

    public w dpK() {
        return new w(this.lOR.doB(), this.lQq, this.mContentResolver);
    }

    public x dpL() {
        return new x(this.lOR.doB(), this.lQq, this.mContentResolver);
    }

    public y dpM() {
        return new y(this.lOR.doB(), this.lQq, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dpN() {
        return new aa(this.lOR.doB(), this.lQq);
    }

    public an dpO() {
        return new an(this.lOR.doB(), this.lQq, this.mContentResolver);
    }

    public ab dpP() {
        return new ab(this.lOR.doB(), this.lQq, this.mResources);
    }

    public ac dpQ() {
        return new ac(this.lOR.doB(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.lQq, this.lID, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.lRU, this.lRY, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.lOi, this.lOR.doE());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.lOR.doE(), this.lQq, z && !this.lSi, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.lOR.doF(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.lOR.doE(), this.lQq, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.lSI, this.lSJ, this.lSK);
    }
}
