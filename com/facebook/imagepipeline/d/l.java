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
    private final com.facebook.common.memory.a hXd;
    private final com.facebook.common.memory.g ich;
    private final com.facebook.imagepipeline.c.e ido;
    private final com.facebook.imagepipeline.c.e idp;
    private final com.facebook.imagepipeline.c.f idq;
    @Nullable
    private final q ieH;
    private final boolean ieJ;
    private final r ieW;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iea;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> ieb;
    private final boolean iek;
    private final e ien;
    private final com.facebook.imagepipeline.decoder.b ieo;
    private final com.facebook.imagepipeline.b.f ies;
    private final com.facebook.imagepipeline.decoder.d ieu;
    private final boolean iew;
    private AssetManager ifb;
    private final com.facebook.imagepipeline.c.l ifc;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.ifb = context.getApplicationContext().getAssets();
        this.hXd = aVar;
        this.ieo = bVar;
        this.ieu = dVar;
        this.iek = z;
        this.iew = z2;
        this.ieJ = z3;
        this.ien = eVar;
        this.ich = gVar;
        this.iea = tVar;
        this.ieb = tVar2;
        this.ido = eVar2;
        this.idp = eVar3;
        this.ieW = rVar;
        this.ieH = qVar;
        this.idq = fVar;
        this.ies = fVar2;
        if (i > 0) {
            this.ifc = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.ifc = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.iea, this.idq, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.idq, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.iea, this.idq, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k bVU() {
        return new com.facebook.imagepipeline.producers.k(this.ich);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.hXd, this.ien.bUU(), this.ieo, this.ieu, this.iek, this.iew, this.ieJ, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.ifc);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.ifc);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.ido, this.idp, this.idq, this.ieW, this.ieH, this.ifc, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.idq, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.ieb, this.idq, aiVar);
    }

    public u bVV() {
        return new u(this.ien.bUS(), this.ich, this.ifb);
    }

    public v bVW() {
        return new v(this.ien.bUS(), this.ich, this.mContentResolver);
    }

    public w bVX() {
        return new w(this.ien.bUS(), this.ich, this.mContentResolver);
    }

    public x bVY() {
        return new x(this.ien.bUS(), this.ich, this.mContentResolver);
    }

    public as a(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return new as(atVarArr);
    }

    public com.facebook.imagepipeline.producers.z bVZ() {
        return new com.facebook.imagepipeline.producers.z(this.ien.bUS(), this.ich);
    }

    public com.facebook.imagepipeline.producers.aa bWa() {
        return new com.facebook.imagepipeline.producers.aa(this.ien.bUS(), this.ich, this.mResources);
    }

    public ab bWb() {
        return new ab(this.ien.bUS());
    }

    public ae a(af afVar) {
        return new ae(this.ich, this.hXd, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.iea, this.idq, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.ies, this.ien.bUV());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.ien.bUV(), this.ich, z && !this.iek, aiVar, z2);
    }

    public <T> ap<T> a(ai<T> aiVar, aq aqVar) {
        return new ap<>(aiVar, aqVar);
    }

    public <T> ar<T> m(ai<T> aiVar) {
        return new ar<>(5, this.ien.bUW(), aiVar);
    }

    public av n(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new av(this.ien.bUV(), this.ich, aiVar);
    }
}
