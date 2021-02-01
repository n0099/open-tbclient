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
    private final com.facebook.imagepipeline.a.f pEI;
    private final e pFr;
    private final com.facebook.common.memory.g pGK;
    private final com.facebook.imagepipeline.decoder.b pIC;
    private final com.facebook.imagepipeline.decoder.d pII;
    private final boolean pIJ;
    private final boolean pIV;
    private final int pIZ;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pIl;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pIm;
    private final com.facebook.imagepipeline.b.e pIo;
    private final com.facebook.imagepipeline.b.f pIp;
    private final boolean pIz;
    private final int pJa;
    private boolean pJb;
    private final com.facebook.imagepipeline.b.e pJs;
    private final com.facebook.common.memory.a pze;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.pze = aVar;
        this.pIC = bVar;
        this.pII = dVar;
        this.pIz = z;
        this.pIJ = z2;
        this.pIV = z3;
        this.pFr = eVar;
        this.pGK = gVar;
        this.pIl = pVar;
        this.pIm = pVar2;
        this.pJs = eVar2;
        this.pIo = eVar3;
        this.pIp = fVar;
        this.pEI = fVar2;
        this.pIZ = i;
        this.pJa = i2;
        this.pJb = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.pIl, this.pIp, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.pIp, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.pIl, this.pIp, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l exz() {
        return new com.facebook.imagepipeline.producers.l(this.pGK);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.pze, this.pFr.ewu(), this.pIC, this.pII, this.pIz, this.pIJ, this.pIV, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new o(this.pJs, this.pIo, this.pIp, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.pJs, this.pIo, this.pIp, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ag(this.pJs, this.pIp, this.pGK, this.pze, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new r(this.pIp, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new s(this.pIm, this.pIp, ajVar);
    }

    public v exA() {
        return new v(this.pFr.ews(), this.pGK, this.mAssetManager);
    }

    public w exB() {
        return new w(this.pFr.ews(), this.pGK, this.mContentResolver);
    }

    public x exC() {
        return new x(this.pFr.ews(), this.pGK, this.mContentResolver);
    }

    public y exD() {
        return new y(this.pFr.ews(), this.pGK, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa exE() {
        return new aa(this.pFr.ews(), this.pGK);
    }

    public an exF() {
        return new an(this.pFr.ews(), this.pGK, this.mContentResolver);
    }

    public ab exG() {
        return new ab(this.pFr.ews(), this.pGK, this.mResources);
    }

    public ac exH() {
        return new ac(this.pFr.ews(), this.mContentResolver);
    }

    public ae a(af afVar) {
        return new ae(this.pGK, this.pze, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ah(this.pIl, this.pIp, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ai(ajVar, this.pEI, this.pFr.ewv());
    }

    public ao a(aj<com.facebook.imagepipeline.f.e> ajVar, boolean z, boolean z2) {
        return new ao(this.pFr.ewv(), this.pGK, z && !this.pIz, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.pFr.eww(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ay(this.pFr.ewv(), this.pGK, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.pIZ, this.pJa, this.pJb);
    }
}
