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
    private final com.facebook.common.memory.a pch;
    private final com.facebook.imagepipeline.a.f phJ;
    private final e piv;
    private final com.facebook.common.memory.g pjO;
    private final boolean plF;
    private final com.facebook.imagepipeline.decoder.b plI;
    private final com.facebook.imagepipeline.decoder.d plO;
    private final boolean plP;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> plr;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pls;
    private final com.facebook.imagepipeline.b.e plu;
    private final com.facebook.imagepipeline.b.f plv;
    private final boolean pmb;
    private final int pmf;
    private final int pmg;
    private boolean pmh;
    private final com.facebook.imagepipeline.b.e pmy;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.pch = aVar;
        this.plI = bVar;
        this.plO = dVar;
        this.plF = z;
        this.plP = z2;
        this.pmb = z3;
        this.piv = eVar;
        this.pjO = gVar;
        this.plr = pVar;
        this.pls = pVar2;
        this.pmy = eVar2;
        this.plu = eVar3;
        this.plv = fVar;
        this.phJ = fVar2;
        this.pmf = i;
        this.pmg = i2;
        this.pmh = z4;
    }

    public static com.facebook.imagepipeline.producers.a a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.a(ajVar);
    }

    public com.facebook.imagepipeline.producers.f b(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.f(this.plr, this.plv, ajVar);
    }

    public com.facebook.imagepipeline.producers.g c(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.g(this.plv, ajVar);
    }

    public com.facebook.imagepipeline.producers.h d(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.h(this.plr, this.plv, ajVar);
    }

    public static com.facebook.imagepipeline.producers.j a(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        return new com.facebook.imagepipeline.producers.j(ajVar, ajVar2);
    }

    public com.facebook.imagepipeline.producers.l euM() {
        return new com.facebook.imagepipeline.producers.l(this.pjO);
    }

    public com.facebook.imagepipeline.producers.m e(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.m(this.pch, this.piv.etI(), this.plI, this.plO, this.plF, this.plP, this.pmb, ajVar);
    }

    public o f(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new o(this.pmy, this.plu, this.plv, ajVar);
    }

    public com.facebook.imagepipeline.producers.p g(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new com.facebook.imagepipeline.producers.p(this.pmy, this.plu, this.plv, ajVar);
    }

    public ag h(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ag(this.pmy, this.plv, this.pjO, this.pch, ajVar);
    }

    public r i(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new r(this.plv, ajVar);
    }

    public s j(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new s(this.pls, this.plv, ajVar);
    }

    public v euN() {
        return new v(this.piv.etG(), this.pjO, this.mAssetManager);
    }

    public w euO() {
        return new w(this.piv.etG(), this.pjO, this.mContentResolver);
    }

    public x euP() {
        return new x(this.piv.etG(), this.pjO, this.mContentResolver);
    }

    public y euQ() {
        return new y(this.piv.etG(), this.pjO, this.mContentResolver);
    }

    public av a(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return new av(awVarArr);
    }

    public aa euR() {
        return new aa(this.piv.etG(), this.pjO);
    }

    public an euS() {
        return new an(this.piv.etG(), this.pjO, this.mContentResolver);
    }

    public ab euT() {
        return new ab(this.piv.etG(), this.pjO, this.mResources);
    }

    public ac euU() {
        return new ac(this.piv.etG(), this.mContentResolver);
    }

    public ae a(af afVar) {
        return new ae(this.pjO, this.pch, afVar);
    }

    public ah k(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ah(this.plr, this.plv, ajVar);
    }

    public ai l(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new ai(ajVar, this.phJ, this.piv.etJ());
    }

    public ao a(aj<com.facebook.imagepipeline.f.e> ajVar, boolean z, boolean z2) {
        return new ao(this.piv.etJ(), this.pjO, z && !this.plF, ajVar, z2);
    }

    public static <T> ar<T> m(aj<T> ajVar) {
        return new ar<>(ajVar);
    }

    public <T> as<T> a(aj<T> ajVar, at atVar) {
        return new as<>(ajVar, atVar);
    }

    public <T> au<T> n(aj<T> ajVar) {
        return new au<>(5, this.piv.etK(), ajVar);
    }

    public ay o(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return new ay(this.piv.etJ(), this.pjO, ajVar);
    }

    public com.facebook.imagepipeline.producers.i p(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return new com.facebook.imagepipeline.producers.i(ajVar, this.pmf, this.pmg, this.pmh);
    }
}
