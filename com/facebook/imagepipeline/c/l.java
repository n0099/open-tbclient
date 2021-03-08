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
/* loaded from: classes5.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final com.facebook.common.memory.a pBJ;
    private final e pHW;
    private final com.facebook.imagepipeline.a.f pHn;
    private final com.facebook.common.memory.g pJp;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pKQ;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pKR;
    private final com.facebook.imagepipeline.b.e pKT;
    private final com.facebook.imagepipeline.b.f pKU;
    private final boolean pLA;
    private final int pLE;
    private final int pLF;
    private boolean pLG;
    private final com.facebook.imagepipeline.b.e pLX;
    private final boolean pLe;
    private final com.facebook.imagepipeline.decoder.b pLh;
    private final com.facebook.imagepipeline.decoder.d pLn;
    private final boolean pLo;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.pBJ = aVar;
        this.pLh = bVar;
        this.pLn = dVar;
        this.pLe = z;
        this.pLo = z2;
        this.pLA = z3;
        this.pHW = eVar;
        this.pJp = gVar;
        this.pKQ = pVar;
        this.pKR = pVar2;
        this.pLX = eVar2;
        this.pKT = eVar3;
        this.pKU = fVar;
        this.pHn = fVar2;
        this.pLE = i;
        this.pLF = i2;
        this.pLG = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.pKQ, this.pKU, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.pKU, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.pKQ, this.pKU, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l exQ() {
        return new com.facebook.imagepipeline.producers.l(this.pJp);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.pBJ, this.pHW.ewL(), this.pLh, this.pLn, this.pLe, this.pLo, this.pLA, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new o(this.pLX, this.pKT, this.pKU, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.pLX, this.pKT, this.pKU, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ag(this.pLX, this.pKU, this.pJp, this.pBJ, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new r(this.pKU, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new s(this.pKR, this.pKU, ajVar);
    }

    public v exR() {
        return new v(this.pHW.ewJ(), this.pJp, this.mAssetManager);
    }

    public w exS() {
        return new w(this.pHW.ewJ(), this.pJp, this.mContentResolver);
    }

    public x exT() {
        return new x(this.pHW.ewJ(), this.pJp, this.mContentResolver);
    }

    public y exU() {
        return new y(this.pHW.ewJ(), this.pJp, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa exV() {
        return new aa(this.pHW.ewJ(), this.pJp);
    }

    public an exW() {
        return new an(this.pHW.ewJ(), this.pJp, this.mContentResolver);
    }

    public ab exX() {
        return new ab(this.pHW.ewJ(), this.pJp, this.mResources);
    }

    public ac exY() {
        return new ac(this.pHW.ewJ(), this.mContentResolver);
    }

    public ae a(af afVar) {
        return new ae(this.pJp, this.pBJ, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ah(this.pKQ, this.pKU, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ai(ajVar, this.pHn, this.pHW.ewM());
    }

    public ao a(aj<com.facebook.imagepipeline.f.e> ajVar, boolean z, boolean z2) {
        return new ao(this.pHW.ewM(), this.pJp, z && !this.pLe, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.pHW.ewN(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ay(this.pHW.ewM(), this.pJp, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.pLE, this.pLF, this.pLG);
    }
}
