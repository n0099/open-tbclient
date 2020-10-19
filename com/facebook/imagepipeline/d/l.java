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
    private final com.facebook.common.memory.a nKJ;
    private final com.facebook.imagepipeline.b.f nQz;
    private final e nRi;
    private final com.facebook.common.memory.g nSK;
    private final boolean nUC;
    private final com.facebook.imagepipeline.decoder.b nUF;
    private final com.facebook.imagepipeline.decoder.d nUL;
    private final boolean nUM;
    private final boolean nUY;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nUo;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> nUp;
    private final com.facebook.imagepipeline.c.e nUr;
    private final com.facebook.imagepipeline.c.f nUs;
    private final int nVc;
    private final int nVd;
    private boolean nVe;
    private final com.facebook.imagepipeline.c.e nVv;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.nKJ = aVar;
        this.nUF = bVar;
        this.nUL = dVar;
        this.nUC = z;
        this.nUM = z2;
        this.nUY = z3;
        this.nRi = eVar;
        this.nSK = gVar;
        this.nUo = pVar;
        this.nUp = pVar2;
        this.nVv = eVar2;
        this.nUr = eVar3;
        this.nUs = fVar;
        this.nQz = fVar2;
        this.nVc = i;
        this.nVd = i2;
        this.nVe = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.nUo, this.nUs, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.nUs, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.nUo, this.nUs, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l ebu() {
        return new com.facebook.imagepipeline.producers.l(this.nSK);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.nKJ, this.nRi.eaq(), this.nUF, this.nUL, this.nUC, this.nUM, this.nUY, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.nVv, this.nUr, this.nUs, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.nVv, this.nUr, this.nUs, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.nVv, this.nUs, this.nSK, this.nKJ, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.nUs, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.nUp, this.nUs, ajVar);
    }

    public v ebv() {
        return new v(this.nRi.eao(), this.nSK, this.mAssetManager);
    }

    public w ebw() {
        return new w(this.nRi.eao(), this.nSK, this.mContentResolver);
    }

    public x ebx() {
        return new x(this.nRi.eao(), this.nSK, this.mContentResolver);
    }

    public y eby() {
        return new y(this.nRi.eao(), this.nSK, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa ebz() {
        return new aa(this.nRi.eao(), this.nSK);
    }

    public an ebA() {
        return new an(this.nRi.eao(), this.nSK, this.mContentResolver);
    }

    public ab ebB() {
        return new ab(this.nRi.eao(), this.nSK, this.mResources);
    }

    public ac ebC() {
        return new ac(this.nRi.eao(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.nSK, this.nKJ, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.nUo, this.nUs, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.nQz, this.nRi.ear());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.nRi.ear(), this.nSK, z && !this.nUC, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.nRi.eas(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.nRi.ear(), this.nSK, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.nVc, this.nVd, this.nVe);
    }
}
