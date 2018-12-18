package com.facebook.imagepipeline.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.aa;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.c.r;
import com.facebook.imagepipeline.c.t;
import com.facebook.imagepipeline.c.z;
import com.facebook.imagepipeline.producers.ab;
import com.facebook.imagepipeline.producers.ac;
import com.facebook.imagepipeline.producers.ae;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.ag;
import com.facebook.imagepipeline.producers.ah;
import com.facebook.imagepipeline.producers.ai;
import com.facebook.imagepipeline.producers.am;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.aq;
import com.facebook.imagepipeline.producers.ar;
import com.facebook.imagepipeline.producers.as;
import com.facebook.imagepipeline.producers.at;
import com.facebook.imagepipeline.producers.av;
import com.facebook.imagepipeline.producers.n;
import com.facebook.imagepipeline.producers.o;
import com.facebook.imagepipeline.producers.u;
import com.facebook.imagepipeline.producers.v;
import com.facebook.imagepipeline.producers.w;
import com.facebook.imagepipeline.producers.x;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class l {
    private final com.facebook.common.memory.a iga;
    private final com.facebook.common.memory.g ile;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> imV;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> imW;
    private final com.facebook.imagepipeline.c.e iml;
    private final com.facebook.imagepipeline.c.e imm;
    private final com.facebook.imagepipeline.c.f imn;
    @Nullable
    private final q inD;
    private final boolean inF;
    private final r inS;
    private AssetManager inX;
    private final com.facebook.imagepipeline.c.l inY;
    private final boolean inf;
    private final e ini;
    private final com.facebook.imagepipeline.decoder.b inj;
    private final com.facebook.imagepipeline.b.f inn;
    private final com.facebook.imagepipeline.decoder.d inp;
    private final boolean inr;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.inX = context.getApplicationContext().getAssets();
        this.iga = aVar;
        this.inj = bVar;
        this.inp = dVar;
        this.inf = z;
        this.inr = z2;
        this.inF = z3;
        this.ini = eVar;
        this.ile = gVar;
        this.imV = tVar;
        this.imW = tVar2;
        this.iml = eVar2;
        this.imm = eVar3;
        this.inS = rVar;
        this.inD = qVar;
        this.imn = fVar;
        this.inn = fVar2;
        if (i > 0) {
            this.inY = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.inY = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.imV, this.imn, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.imn, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.imV, this.imn, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k bXu() {
        return new com.facebook.imagepipeline.producers.k(this.ile);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.iga, this.ini.bWu(), this.inj, this.inp, this.inf, this.inr, this.inF, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.inY);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.inY);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.iml, this.imm, this.imn, this.inS, this.inD, this.inY, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.imn, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.imW, this.imn, aiVar);
    }

    public u bXv() {
        return new u(this.ini.bWs(), this.ile, this.inX);
    }

    public v bXw() {
        return new v(this.ini.bWs(), this.ile, this.mContentResolver);
    }

    public w bXx() {
        return new w(this.ini.bWs(), this.ile, this.mContentResolver);
    }

    public x bXy() {
        return new x(this.ini.bWs(), this.ile, this.mContentResolver);
    }

    public as a(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return new as(atVarArr);
    }

    public com.facebook.imagepipeline.producers.z bXz() {
        return new com.facebook.imagepipeline.producers.z(this.ini.bWs(), this.ile);
    }

    public com.facebook.imagepipeline.producers.aa bXA() {
        return new com.facebook.imagepipeline.producers.aa(this.ini.bWs(), this.ile, this.mResources);
    }

    public ab bXB() {
        return new ab(this.ini.bWs());
    }

    public ae a(af afVar) {
        return new ae(this.ile, this.iga, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.imV, this.imn, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.inn, this.ini.bWv());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.ini.bWv(), this.ile, z && !this.inf, aiVar, z2);
    }

    public <T> ap<T> a(ai<T> aiVar, aq aqVar) {
        return new ap<>(aiVar, aqVar);
    }

    public <T> ar<T> m(ai<T> aiVar) {
        return new ar<>(5, this.ini.bWw(), aiVar);
    }

    public av n(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new av(this.ini.bWv(), this.ile, aiVar);
    }
}
