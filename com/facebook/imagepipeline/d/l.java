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
    private final com.facebook.common.memory.a iks;
    private final com.facebook.common.memory.g ipy;
    private final com.facebook.imagepipeline.c.e iqE;
    private final com.facebook.imagepipeline.c.e iqF;
    private final com.facebook.imagepipeline.c.f iqG;
    private final e irB;
    private final com.facebook.imagepipeline.decoder.b irC;
    private final com.facebook.imagepipeline.b.f irG;
    private final com.facebook.imagepipeline.decoder.d irI;
    private final boolean irK;
    @Nullable
    private final q irV;
    private final boolean irX;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iro;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> irp;
    private final boolean iry;
    private final r isk;
    private AssetManager isp;
    private final com.facebook.imagepipeline.c.l isq;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.isp = context.getApplicationContext().getAssets();
        this.iks = aVar;
        this.irC = bVar;
        this.irI = dVar;
        this.iry = z;
        this.irK = z2;
        this.irX = z3;
        this.irB = eVar;
        this.ipy = gVar;
        this.iro = tVar;
        this.irp = tVar2;
        this.iqE = eVar2;
        this.iqF = eVar3;
        this.isk = rVar;
        this.irV = qVar;
        this.iqG = fVar;
        this.irG = fVar2;
        if (i > 0) {
            this.isq = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.isq = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.iro, this.iqG, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.iqG, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.iro, this.iqG, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k bYT() {
        return new com.facebook.imagepipeline.producers.k(this.ipy);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.iks, this.irB.bXT(), this.irC, this.irI, this.iry, this.irK, this.irX, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.isq);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.isq);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.iqE, this.iqF, this.iqG, this.isk, this.irV, this.isq, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.iqG, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.irp, this.iqG, aiVar);
    }

    public u bYU() {
        return new u(this.irB.bXR(), this.ipy, this.isp);
    }

    public v bYV() {
        return new v(this.irB.bXR(), this.ipy, this.mContentResolver);
    }

    public w bYW() {
        return new w(this.irB.bXR(), this.ipy, this.mContentResolver);
    }

    public x bYX() {
        return new x(this.irB.bXR(), this.ipy, this.mContentResolver);
    }

    public as a(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return new as(atVarArr);
    }

    public com.facebook.imagepipeline.producers.z bYY() {
        return new com.facebook.imagepipeline.producers.z(this.irB.bXR(), this.ipy);
    }

    public com.facebook.imagepipeline.producers.aa bYZ() {
        return new com.facebook.imagepipeline.producers.aa(this.irB.bXR(), this.ipy, this.mResources);
    }

    public ab bZa() {
        return new ab(this.irB.bXR());
    }

    public ae a(af afVar) {
        return new ae(this.ipy, this.iks, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.iro, this.iqG, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.irG, this.irB.bXU());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.irB.bXU(), this.ipy, z && !this.iry, aiVar, z2);
    }

    public <T> ap<T> a(ai<T> aiVar, aq aqVar) {
        return new ap<>(aiVar, aqVar);
    }

    public <T> ar<T> m(ai<T> aiVar) {
        return new ar<>(5, this.irB.bXV(), aiVar);
    }

    public av n(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new av(this.irB.bXU(), this.ipy, aiVar);
    }
}
