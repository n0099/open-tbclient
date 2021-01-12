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
    private final com.facebook.common.memory.a poT;
    private final com.facebook.imagepipeline.a.f puz;
    private final e pvi;
    private final com.facebook.common.memory.g pwB;
    private final boolean pyA;
    private final boolean pyM;
    private final int pyQ;
    private final int pyR;
    private boolean pyS;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pyc;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pyd;
    private final com.facebook.imagepipeline.b.e pyf;
    private final com.facebook.imagepipeline.b.f pyg;
    private final boolean pyq;
    private final com.facebook.imagepipeline.decoder.b pyt;
    private final com.facebook.imagepipeline.decoder.d pyz;
    private final com.facebook.imagepipeline.b.e pzj;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.poT = aVar;
        this.pyt = bVar;
        this.pyz = dVar;
        this.pyq = z;
        this.pyA = z2;
        this.pyM = z3;
        this.pvi = eVar;
        this.pwB = gVar;
        this.pyc = pVar;
        this.pyd = pVar2;
        this.pzj = eVar2;
        this.pyf = eVar3;
        this.pyg = fVar;
        this.puz = fVar2;
        this.pyQ = i;
        this.pyR = i2;
        this.pyS = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.pyc, this.pyg, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.pyg, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.pyc, this.pyg, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l evg() {
        return new com.facebook.imagepipeline.producers.l(this.pwB);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.poT, this.pvi.euc(), this.pyt, this.pyz, this.pyq, this.pyA, this.pyM, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new o(this.pzj, this.pyf, this.pyg, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.pzj, this.pyf, this.pyg, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ag(this.pzj, this.pyg, this.pwB, this.poT, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new r(this.pyg, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new s(this.pyd, this.pyg, ajVar);
    }

    public v evh() {
        return new v(this.pvi.eua(), this.pwB, this.mAssetManager);
    }

    public w evi() {
        return new w(this.pvi.eua(), this.pwB, this.mContentResolver);
    }

    public x evj() {
        return new x(this.pvi.eua(), this.pwB, this.mContentResolver);
    }

    public y evk() {
        return new y(this.pvi.eua(), this.pwB, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa evl() {
        return new aa(this.pvi.eua(), this.pwB);
    }

    public an evm() {
        return new an(this.pvi.eua(), this.pwB, this.mContentResolver);
    }

    public ab evn() {
        return new ab(this.pvi.eua(), this.pwB, this.mResources);
    }

    public ac evo() {
        return new ac(this.pvi.eua(), this.mContentResolver);
    }

    public ae a(af afVar) {
        return new ae(this.pwB, this.poT, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ah(this.pyc, this.pyg, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ai(ajVar, this.puz, this.pvi.eud());
    }

    public ao a(aj<com.facebook.imagepipeline.f.e> ajVar, boolean z, boolean z2) {
        return new ao(this.pvi.eud(), this.pwB, z && !this.pyq, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.pvi.eue(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ay(this.pvi.eud(), this.pwB, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.pyQ, this.pyR, this.pyS);
    }
}
