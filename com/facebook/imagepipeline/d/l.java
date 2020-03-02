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
    private final com.facebook.common.memory.a lIF;
    private final e lOT;
    private final com.facebook.imagepipeline.b.f lOk;
    private final com.facebook.common.memory.g lQs;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lRW;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lRX;
    private final com.facebook.imagepipeline.c.e lRZ;
    private final boolean lSG;
    private final int lSK;
    private final int lSL;
    private boolean lSM;
    private final com.facebook.imagepipeline.c.f lSa;
    private final boolean lSk;
    private final com.facebook.imagepipeline.decoder.b lSn;
    private final com.facebook.imagepipeline.decoder.d lSt;
    private final boolean lSu;
    private final com.facebook.imagepipeline.c.e lTf;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.lIF = aVar;
        this.lSn = bVar;
        this.lSt = dVar;
        this.lSk = z;
        this.lSu = z2;
        this.lSG = z3;
        this.lOT = eVar;
        this.lQs = gVar;
        this.lRW = pVar;
        this.lRX = pVar2;
        this.lTf = eVar2;
        this.lRZ = eVar3;
        this.lSa = fVar;
        this.lOk = fVar2;
        this.lSK = i;
        this.lSL = i2;
        this.lSM = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.lRW, this.lSa, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.lSa, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.lRW, this.lSa, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dpK() {
        return new com.facebook.imagepipeline.producers.l(this.lQs);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.lIF, this.lOT.doF(), this.lSn, this.lSt, this.lSk, this.lSu, this.lSG, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.lTf, this.lRZ, this.lSa, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.lTf, this.lRZ, this.lSa, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.lTf, this.lSa, this.lQs, this.lIF, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.lSa, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.lRX, this.lSa, ajVar);
    }

    public v dpL() {
        return new v(this.lOT.doD(), this.lQs, this.mAssetManager);
    }

    public w dpM() {
        return new w(this.lOT.doD(), this.lQs, this.mContentResolver);
    }

    public x dpN() {
        return new x(this.lOT.doD(), this.lQs, this.mContentResolver);
    }

    public y dpO() {
        return new y(this.lOT.doD(), this.lQs, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dpP() {
        return new aa(this.lOT.doD(), this.lQs);
    }

    public an dpQ() {
        return new an(this.lOT.doD(), this.lQs, this.mContentResolver);
    }

    public ab dpR() {
        return new ab(this.lOT.doD(), this.lQs, this.mResources);
    }

    public ac dpS() {
        return new ac(this.lOT.doD(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.lQs, this.lIF, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.lRW, this.lSa, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.lOk, this.lOT.doG());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.lOT.doG(), this.lQs, z && !this.lSk, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.lOT.doH(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.lOT.doG(), this.lQs, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.lSK, this.lSL, this.lSM);
    }
}
