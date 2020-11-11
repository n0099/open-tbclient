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
/* loaded from: classes18.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final com.facebook.common.memory.a oLv;
    private final e oRT;
    private final com.facebook.imagepipeline.b.f oRk;
    private final com.facebook.common.memory.g oTv;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oUZ;
    private final boolean oVJ;
    private final int oVN;
    private final int oVO;
    private boolean oVP;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> oVa;
    private final com.facebook.imagepipeline.c.e oVc;
    private final com.facebook.imagepipeline.c.f oVd;
    private final boolean oVn;
    private final com.facebook.imagepipeline.decoder.b oVq;
    private final com.facebook.imagepipeline.decoder.d oVw;
    private final boolean oVx;
    private final com.facebook.imagepipeline.c.e oWg;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.oLv = aVar;
        this.oVq = bVar;
        this.oVw = dVar;
        this.oVn = z;
        this.oVx = z2;
        this.oVJ = z3;
        this.oRT = eVar;
        this.oTv = gVar;
        this.oUZ = pVar;
        this.oVa = pVar2;
        this.oWg = eVar2;
        this.oVc = eVar3;
        this.oVd = fVar;
        this.oRk = fVar2;
        this.oVN = i;
        this.oVO = i2;
        this.oVP = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.oUZ, this.oVd, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.oVd, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.oUZ, this.oVd, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l epj() {
        return new com.facebook.imagepipeline.producers.l(this.oTv);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.oLv, this.oRT.eoe(), this.oVq, this.oVw, this.oVn, this.oVx, this.oVJ, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.oWg, this.oVc, this.oVd, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.oWg, this.oVc, this.oVd, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.oWg, this.oVd, this.oTv, this.oLv, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.oVd, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.oVa, this.oVd, ajVar);
    }

    public v epk() {
        return new v(this.oRT.eoc(), this.oTv, this.mAssetManager);
    }

    public w epl() {
        return new w(this.oRT.eoc(), this.oTv, this.mContentResolver);
    }

    public x epm() {
        return new x(this.oRT.eoc(), this.oTv, this.mContentResolver);
    }

    public y epn() {
        return new y(this.oRT.eoc(), this.oTv, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa epo() {
        return new aa(this.oRT.eoc(), this.oTv);
    }

    public an epp() {
        return new an(this.oRT.eoc(), this.oTv, this.mContentResolver);
    }

    public ab epq() {
        return new ab(this.oRT.eoc(), this.oTv, this.mResources);
    }

    public ac epr() {
        return new ac(this.oRT.eoc(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.oTv, this.oLv, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.oUZ, this.oVd, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.oRk, this.oRT.eog());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.oRT.eog(), this.oTv, z && !this.oVn, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.oRT.eoh(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.oRT.eog(), this.oTv, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.oVN, this.oVO, this.oVP);
    }
}
