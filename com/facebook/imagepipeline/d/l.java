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
    private final com.facebook.common.memory.a lRQ;
    private final com.facebook.imagepipeline.b.f lXG;
    private final e lYp;
    private final com.facebook.common.memory.g lZS;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mbA;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mbB;
    private final com.facebook.imagepipeline.c.e mbD;
    private final com.facebook.imagepipeline.c.f mbE;
    private final boolean mbO;
    private final com.facebook.imagepipeline.decoder.b mbR;
    private final com.facebook.imagepipeline.decoder.d mbX;
    private final boolean mbY;
    private final com.facebook.imagepipeline.c.e mcH;
    private final boolean mck;
    private final int mco;
    private final int mcp;
    private boolean mcq;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.lRQ = aVar;
        this.mbR = bVar;
        this.mbX = dVar;
        this.mbO = z;
        this.mbY = z2;
        this.mck = z3;
        this.lYp = eVar;
        this.lZS = gVar;
        this.mbA = pVar;
        this.mbB = pVar2;
        this.mcH = eVar2;
        this.mbD = eVar3;
        this.mbE = fVar;
        this.lXG = fVar2;
        this.mco = i;
        this.mcp = i2;
        this.mcq = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.mbA, this.mbE, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.mbE, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.mbA, this.mbE, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dsg() {
        return new com.facebook.imagepipeline.producers.l(this.lZS);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.lRQ, this.lYp.drc(), this.mbR, this.mbX, this.mbO, this.mbY, this.mck, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.mcH, this.mbD, this.mbE, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.mcH, this.mbD, this.mbE, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.mcH, this.mbE, this.lZS, this.lRQ, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.mbE, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.mbB, this.mbE, ajVar);
    }

    public v dsh() {
        return new v(this.lYp.dra(), this.lZS, this.mAssetManager);
    }

    public w dsi() {
        return new w(this.lYp.dra(), this.lZS, this.mContentResolver);
    }

    public x dsj() {
        return new x(this.lYp.dra(), this.lZS, this.mContentResolver);
    }

    public y dsk() {
        return new y(this.lYp.dra(), this.lZS, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dsl() {
        return new aa(this.lYp.dra(), this.lZS);
    }

    public an dsm() {
        return new an(this.lYp.dra(), this.lZS, this.mContentResolver);
    }

    public ab dsn() {
        return new ab(this.lYp.dra(), this.lZS, this.mResources);
    }

    public ac dso() {
        return new ac(this.lYp.dra(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.lZS, this.lRQ, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.mbA, this.mbE, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.lXG, this.lYp.drd());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.lYp.drd(), this.lZS, z && !this.mbO, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.lYp.dre(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.lYp.drd(), this.lZS, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.mco, this.mcp, this.mcq);
    }
}
