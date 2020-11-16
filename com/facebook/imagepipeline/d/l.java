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
/* loaded from: classes15.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final com.facebook.common.memory.a oMZ;
    private final com.facebook.imagepipeline.b.f oSN;
    private final e oTw;
    private final com.facebook.common.memory.g oUY;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oWC;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> oWD;
    private final com.facebook.imagepipeline.c.e oWF;
    private final com.facebook.imagepipeline.c.f oWG;
    private final boolean oWQ;
    private final com.facebook.imagepipeline.decoder.b oWT;
    private final com.facebook.imagepipeline.decoder.d oWZ;
    private final com.facebook.imagepipeline.c.e oXJ;
    private final boolean oXa;
    private final boolean oXm;
    private final int oXq;
    private final int oXr;
    private boolean oXs;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.oMZ = aVar;
        this.oWT = bVar;
        this.oWZ = dVar;
        this.oWQ = z;
        this.oXa = z2;
        this.oXm = z3;
        this.oTw = eVar;
        this.oUY = gVar;
        this.oWC = pVar;
        this.oWD = pVar2;
        this.oXJ = eVar2;
        this.oWF = eVar3;
        this.oWG = fVar;
        this.oSN = fVar2;
        this.oXq = i;
        this.oXr = i2;
        this.oXs = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.oWC, this.oWG, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.oWG, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.oWC, this.oWG, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l eph() {
        return new com.facebook.imagepipeline.producers.l(this.oUY);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.oMZ, this.oTw.eoc(), this.oWT, this.oWZ, this.oWQ, this.oXa, this.oXm, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.oXJ, this.oWF, this.oWG, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.oXJ, this.oWF, this.oWG, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.oXJ, this.oWG, this.oUY, this.oMZ, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.oWG, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.oWD, this.oWG, ajVar);
    }

    public v epi() {
        return new v(this.oTw.eoa(), this.oUY, this.mAssetManager);
    }

    public w epj() {
        return new w(this.oTw.eoa(), this.oUY, this.mContentResolver);
    }

    public x epk() {
        return new x(this.oTw.eoa(), this.oUY, this.mContentResolver);
    }

    public y epl() {
        return new y(this.oTw.eoa(), this.oUY, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa epm() {
        return new aa(this.oTw.eoa(), this.oUY);
    }

    public an epn() {
        return new an(this.oTw.eoa(), this.oUY, this.mContentResolver);
    }

    public ab epo() {
        return new ab(this.oTw.eoa(), this.oUY, this.mResources);
    }

    public ac epp() {
        return new ac(this.oTw.eoa(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.oUY, this.oMZ, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.oWC, this.oWG, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.oSN, this.oTw.eod());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.oTw.eod(), this.oUY, z && !this.oWQ, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.oTw.eoe(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.oTw.eod(), this.oUY, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.oXq, this.oXr, this.oXs);
    }
}
