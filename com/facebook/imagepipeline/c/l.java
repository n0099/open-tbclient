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
/* loaded from: classes15.dex */
public class l {
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final com.facebook.common.memory.a pcj;
    private final com.facebook.imagepipeline.a.f phL;
    private final e pix;
    private final com.facebook.common.memory.g pjQ;
    private final boolean plH;
    private final com.facebook.imagepipeline.decoder.b plK;
    private final com.facebook.imagepipeline.decoder.d plQ;
    private final boolean plR;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> plt;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> plu;
    private final com.facebook.imagepipeline.b.e plw;
    private final com.facebook.imagepipeline.b.f plx;
    private final com.facebook.imagepipeline.b.e pmA;
    private final boolean pmd;
    private final int pmh;
    private final int pmi;
    private boolean pmj;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.pcj = aVar;
        this.plK = bVar;
        this.plQ = dVar;
        this.plH = z;
        this.plR = z2;
        this.pmd = z3;
        this.pix = eVar;
        this.pjQ = gVar;
        this.plt = pVar;
        this.plu = pVar2;
        this.pmA = eVar2;
        this.plw = eVar3;
        this.plx = fVar;
        this.phL = fVar2;
        this.pmh = i;
        this.pmi = i2;
        this.pmj = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.plt, this.plx, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.plx, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.plt, this.plx, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l euN() {
        return new com.facebook.imagepipeline.producers.l(this.pjQ);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.pcj, this.pix.etJ(), this.plK, this.plQ, this.plH, this.plR, this.pmd, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new o(this.pmA, this.plw, this.plx, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.pmA, this.plw, this.plx, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ag(this.pmA, this.plx, this.pjQ, this.pcj, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new r(this.plx, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new s(this.plu, this.plx, ajVar);
    }

    public v euO() {
        return new v(this.pix.etH(), this.pjQ, this.mAssetManager);
    }

    public w euP() {
        return new w(this.pix.etH(), this.pjQ, this.mContentResolver);
    }

    public x euQ() {
        return new x(this.pix.etH(), this.pjQ, this.mContentResolver);
    }

    public y euR() {
        return new y(this.pix.etH(), this.pjQ, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa euS() {
        return new aa(this.pix.etH(), this.pjQ);
    }

    public an euT() {
        return new an(this.pix.etH(), this.pjQ, this.mContentResolver);
    }

    public ab euU() {
        return new ab(this.pix.etH(), this.pjQ, this.mResources);
    }

    public ac euV() {
        return new ac(this.pix.etH(), this.mContentResolver);
    }

    public ae a(af afVar) {
        return new ae(this.pjQ, this.pcj, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ah(this.plt, this.plx, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ai(ajVar, this.phL, this.pix.etK());
    }

    public ao a(aj<com.facebook.imagepipeline.f.e> ajVar, boolean z, boolean z2) {
        return new ao(this.pix.etK(), this.pjQ, z && !this.plH, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.pix.etL(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ay(this.pix.etK(), this.pjQ, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.pmh, this.pmi, this.pmj);
    }
}
