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
    private final com.facebook.common.memory.a ikr;
    private final com.facebook.common.memory.g ipx;
    private final com.facebook.imagepipeline.c.e iqD;
    private final com.facebook.imagepipeline.c.e iqE;
    private final com.facebook.imagepipeline.c.f iqF;
    private final e irA;
    private final com.facebook.imagepipeline.decoder.b irB;
    private final com.facebook.imagepipeline.b.f irF;
    private final com.facebook.imagepipeline.decoder.d irH;
    private final boolean irJ;
    @Nullable
    private final q irU;
    private final boolean irW;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> irn;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> iro;
    private final boolean irx;
    private final r isj;
    private AssetManager iso;
    private final com.facebook.imagepipeline.c.l isp;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.iso = context.getApplicationContext().getAssets();
        this.ikr = aVar;
        this.irB = bVar;
        this.irH = dVar;
        this.irx = z;
        this.irJ = z2;
        this.irW = z3;
        this.irA = eVar;
        this.ipx = gVar;
        this.irn = tVar;
        this.iro = tVar2;
        this.iqD = eVar2;
        this.iqE = eVar3;
        this.isj = rVar;
        this.irU = qVar;
        this.iqF = fVar;
        this.irF = fVar2;
        if (i > 0) {
            this.isp = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.isp = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.irn, this.iqF, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.iqF, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.irn, this.iqF, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k bYT() {
        return new com.facebook.imagepipeline.producers.k(this.ipx);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.ikr, this.irA.bXT(), this.irB, this.irH, this.irx, this.irJ, this.irW, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.isp);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.isp);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.iqD, this.iqE, this.iqF, this.isj, this.irU, this.isp, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.iqF, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.iro, this.iqF, aiVar);
    }

    public u bYU() {
        return new u(this.irA.bXR(), this.ipx, this.iso);
    }

    public v bYV() {
        return new v(this.irA.bXR(), this.ipx, this.mContentResolver);
    }

    public w bYW() {
        return new w(this.irA.bXR(), this.ipx, this.mContentResolver);
    }

    public x bYX() {
        return new x(this.irA.bXR(), this.ipx, this.mContentResolver);
    }

    public as a(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return new as(atVarArr);
    }

    public com.facebook.imagepipeline.producers.z bYY() {
        return new com.facebook.imagepipeline.producers.z(this.irA.bXR(), this.ipx);
    }

    public com.facebook.imagepipeline.producers.aa bYZ() {
        return new com.facebook.imagepipeline.producers.aa(this.irA.bXR(), this.ipx, this.mResources);
    }

    public ab bZa() {
        return new ab(this.irA.bXR());
    }

    public ae a(af afVar) {
        return new ae(this.ipx, this.ikr, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.irn, this.iqF, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.irF, this.irA.bXU());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.irA.bXU(), this.ipx, z && !this.irx, aiVar, z2);
    }

    public <T> ap<T> a(ai<T> aiVar, aq aqVar) {
        return new ap<>(aiVar, aqVar);
    }

    public <T> ar<T> m(ai<T> aiVar) {
        return new ar<>(5, this.irA.bXV(), aiVar);
    }

    public av n(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new av(this.irA.bXU(), this.ipx, aiVar);
    }
}
