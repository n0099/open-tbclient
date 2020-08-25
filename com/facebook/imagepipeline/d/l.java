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
/* loaded from: classes8.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final com.facebook.common.memory.a nkY;
    private final com.facebook.imagepipeline.b.f nqQ;
    private final e nrz;
    private final com.facebook.common.memory.g ntb;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nuG;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> nuH;
    private final com.facebook.imagepipeline.c.e nuJ;
    private final com.facebook.imagepipeline.c.f nuK;
    private final boolean nuU;
    private final com.facebook.imagepipeline.decoder.b nuX;
    private final com.facebook.imagepipeline.c.e nvP;
    private final com.facebook.imagepipeline.decoder.d nvd;
    private final boolean nve;
    private final boolean nvq;
    private final int nvu;
    private final int nvv;
    private boolean nvw;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.nkY = aVar;
        this.nuX = bVar;
        this.nvd = dVar;
        this.nuU = z;
        this.nve = z2;
        this.nvq = z3;
        this.nrz = eVar;
        this.ntb = gVar;
        this.nuG = pVar;
        this.nuH = pVar2;
        this.nvP = eVar2;
        this.nuJ = eVar3;
        this.nuK = fVar;
        this.nqQ = fVar2;
        this.nvu = i;
        this.nvv = i2;
        this.nvw = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.nuG, this.nuK, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.nuK, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.nuG, this.nuK, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dTC() {
        return new com.facebook.imagepipeline.producers.l(this.ntb);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.nkY, this.nrz.dSy(), this.nuX, this.nvd, this.nuU, this.nve, this.nvq, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.nvP, this.nuJ, this.nuK, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.nvP, this.nuJ, this.nuK, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.nvP, this.nuK, this.ntb, this.nkY, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.nuK, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.nuH, this.nuK, ajVar);
    }

    public v dTD() {
        return new v(this.nrz.dSw(), this.ntb, this.mAssetManager);
    }

    public w dTE() {
        return new w(this.nrz.dSw(), this.ntb, this.mContentResolver);
    }

    public x dTF() {
        return new x(this.nrz.dSw(), this.ntb, this.mContentResolver);
    }

    public y dTG() {
        return new y(this.nrz.dSw(), this.ntb, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dTH() {
        return new aa(this.nrz.dSw(), this.ntb);
    }

    public an dTI() {
        return new an(this.nrz.dSw(), this.ntb, this.mContentResolver);
    }

    public ab dTJ() {
        return new ab(this.nrz.dSw(), this.ntb, this.mResources);
    }

    public ac dTK() {
        return new ac(this.nrz.dSw(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.ntb, this.nkY, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.nuG, this.nuK, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.nqQ, this.nrz.dSz());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.nrz.dSz(), this.ntb, z && !this.nuU, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.nrz.dSA(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.nrz.dSz(), this.ntb, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.nvu, this.nvv, this.nvw);
    }
}
