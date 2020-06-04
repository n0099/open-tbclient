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
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;
    private final com.facebook.common.memory.a mmW;
    private final com.facebook.imagepipeline.b.f msP;
    private final e mty;
    private final com.facebook.common.memory.g mvb;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mwF;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mwG;
    private final com.facebook.imagepipeline.c.e mwI;
    private final com.facebook.imagepipeline.c.f mwJ;
    private final boolean mwT;
    private final com.facebook.imagepipeline.decoder.b mwW;
    private final com.facebook.imagepipeline.c.e mxM;
    private final com.facebook.imagepipeline.decoder.d mxc;
    private final boolean mxd;
    private final boolean mxp;
    private final int mxt;
    private final int mxu;
    private boolean mxv;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.mmW = aVar;
        this.mwW = bVar;
        this.mxc = dVar;
        this.mwT = z;
        this.mxd = z2;
        this.mxp = z3;
        this.mty = eVar;
        this.mvb = gVar;
        this.mwF = pVar;
        this.mwG = pVar2;
        this.mxM = eVar2;
        this.mwI = eVar3;
        this.mwJ = fVar;
        this.msP = fVar2;
        this.mxt = i;
        this.mxu = i2;
        this.mxv = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.mwF, this.mwJ, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.mwJ, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.mwF, this.mwJ, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l dzK() {
        return new com.facebook.imagepipeline.producers.l(this.mvb);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.mmW, this.mty.dyG(), this.mwW, this.mxc, this.mwT, this.mxd, this.mxp, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new o(this.mxM, this.mwI, this.mwJ, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.mxM, this.mwI, this.mwJ, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ag(this.mxM, this.mwJ, this.mvb, this.mmW, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new r(this.mwJ, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new s(this.mwG, this.mwJ, ajVar);
    }

    public v dzL() {
        return new v(this.mty.dyE(), this.mvb, this.mAssetManager);
    }

    public w dzM() {
        return new w(this.mty.dyE(), this.mvb, this.mContentResolver);
    }

    public x dzN() {
        return new x(this.mty.dyE(), this.mvb, this.mContentResolver);
    }

    public y dzO() {
        return new y(this.mty.dyE(), this.mvb, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa dzP() {
        return new aa(this.mty.dyE(), this.mvb);
    }

    public an dzQ() {
        return new an(this.mty.dyE(), this.mvb, this.mContentResolver);
    }

    public ab dzR() {
        return new ab(this.mty.dyE(), this.mvb, this.mResources);
    }

    public ac dzS() {
        return new ac(this.mty.dyE(), this.mContentResolver);
    }

    public ae b(af afVar) {
        return new ae(this.mvb, this.mmW, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ah(this.mwF, this.mwJ, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new ai(ajVar, this.msP, this.mty.dyH());
    }

    public ao a(aj<com.facebook.imagepipeline.g.e> ajVar, boolean z, boolean z2) {
        return new ao(this.mty.dyH(), this.mvb, z && !this.mwT, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.mty.dyI(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return new ay(this.mty.dyH(), this.mvb, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.mxt, this.mxu, this.mxv);
    }
}
