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
    private final com.facebook.common.memory.a lRU;
    private final com.facebook.imagepipeline.b.f lXK;
    private final e lYt;
    private final com.facebook.common.memory.g lZW;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mbE;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mbF;
    private final com.facebook.imagepipeline.c.e mbH;
    private final com.facebook.imagepipeline.c.f mbI;
    private final boolean mbS;
    private final com.facebook.imagepipeline.decoder.b mbV;
    private final com.facebook.imagepipeline.c.e mcL;
    private final com.facebook.imagepipeline.decoder.d mcb;
    private final boolean mcc;
    private final boolean mco;
    private final int mcs;
    private final int mct;
    private boolean mcu;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.lRU = aVar;
        this.mbV = bVar;
        this.mcb = dVar;
        this.mbS = z;
        this.mcc = z2;
        this.mco = z3;
        this.lYt = eVar;
        this.lZW = gVar;
        this.mbE = pVar;
        this.mbF = pVar2;
        this.mcL = eVar2;
        this.mbH = eVar3;
        this.mbI = fVar;
        this.lXK = fVar2;
        this.mcs = i;
        this.mct = i2;
        this.mcu = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.mbE, this.mbI, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.mbI, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.mbE, this.mbI, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dse() {
        return new com.facebook.imagepipeline.producers.l(this.lZW);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.lRU, this.lYt.dra(), this.mbV, this.mcb, this.mbS, this.mcc, this.mco, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.mcL, this.mbH, this.mbI, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.mcL, this.mbH, this.mbI, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.mcL, this.mbI, this.lZW, this.lRU, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.mbI, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.mbF, this.mbI, ajVar);
    }

    public v dsf() {
        return new v(this.lYt.dqY(), this.lZW, this.mAssetManager);
    }

    public w dsg() {
        return new w(this.lYt.dqY(), this.lZW, this.mContentResolver);
    }

    public x dsh() {
        return new x(this.lYt.dqY(), this.lZW, this.mContentResolver);
    }

    public y dsi() {
        return new y(this.lYt.dqY(), this.lZW, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dsj() {
        return new aa(this.lYt.dqY(), this.lZW);
    }

    public an dsk() {
        return new an(this.lYt.dqY(), this.lZW, this.mContentResolver);
    }

    public ab dsl() {
        return new ab(this.lYt.dqY(), this.lZW, this.mResources);
    }

    public ac dsm() {
        return new ac(this.lYt.dqY(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.lZW, this.lRU, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.mbE, this.mbI, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.lXK, this.lYt.drb());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.lYt.drb(), this.lZW, z && !this.mbS, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.lYt.drc(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.lYt.drb(), this.lZW, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.mcs, this.mct, this.mcu);
    }
}
