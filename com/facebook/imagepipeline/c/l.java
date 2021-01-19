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
    private final com.facebook.common.memory.a poU;
    private final com.facebook.imagepipeline.a.f puA;
    private final e pvj;
    private final com.facebook.common.memory.g pwC;
    private final com.facebook.imagepipeline.decoder.d pyA;
    private final boolean pyB;
    private final boolean pyN;
    private final int pyR;
    private final int pyS;
    private boolean pyT;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pyd;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pye;
    private final com.facebook.imagepipeline.b.e pyg;
    private final com.facebook.imagepipeline.b.f pyh;
    private final boolean pyr;
    private final com.facebook.imagepipeline.decoder.b pyu;
    private final com.facebook.imagepipeline.b.e pzk;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.poU = aVar;
        this.pyu = bVar;
        this.pyA = dVar;
        this.pyr = z;
        this.pyB = z2;
        this.pyN = z3;
        this.pvj = eVar;
        this.pwC = gVar;
        this.pyd = pVar;
        this.pye = pVar2;
        this.pzk = eVar2;
        this.pyg = eVar3;
        this.pyh = fVar;
        this.puA = fVar2;
        this.pyR = i;
        this.pyS = i2;
        this.pyT = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.pyd, this.pyh, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.pyh, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.pyd, this.pyh, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l evg() {
        return new com.facebook.imagepipeline.producers.l(this.pwC);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.poU, this.pvj.euc(), this.pyu, this.pyA, this.pyr, this.pyB, this.pyN, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new o(this.pzk, this.pyg, this.pyh, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.pzk, this.pyg, this.pyh, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ag(this.pzk, this.pyh, this.pwC, this.poU, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new r(this.pyh, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new s(this.pye, this.pyh, ajVar);
    }

    public v evh() {
        return new v(this.pvj.eua(), this.pwC, this.mAssetManager);
    }

    public w evi() {
        return new w(this.pvj.eua(), this.pwC, this.mContentResolver);
    }

    public x evj() {
        return new x(this.pvj.eua(), this.pwC, this.mContentResolver);
    }

    public y evk() {
        return new y(this.pvj.eua(), this.pwC, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa evl() {
        return new aa(this.pvj.eua(), this.pwC);
    }

    public an evm() {
        return new an(this.pvj.eua(), this.pwC, this.mContentResolver);
    }

    public ab evn() {
        return new ab(this.pvj.eua(), this.pwC, this.mResources);
    }

    public ac evo() {
        return new ac(this.pvj.eua(), this.mContentResolver);
    }

    public ae a(af afVar) {
        return new ae(this.pwC, this.poU, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ah(this.pyd, this.pyh, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ai(ajVar, this.puA, this.pvj.eud());
    }

    public ao a(aj<com.facebook.imagepipeline.f.e> ajVar, boolean z, boolean z2) {
        return new ao(this.pvj.eud(), this.pwC, z && !this.pyr, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.pvj.eue(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ay(this.pvj.eud(), this.pwC, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.pyR, this.pyS, this.pyT);
    }
}
