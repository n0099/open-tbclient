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
    private final com.facebook.common.memory.a hXc;
    private final com.facebook.common.memory.g icg;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> idZ;
    private final com.facebook.imagepipeline.c.e idn;
    private final com.facebook.imagepipeline.c.e ido;
    private final com.facebook.imagepipeline.c.f idp;
    @Nullable
    private final q ieG;
    private final boolean ieI;
    private final r ieV;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> iea;
    private final boolean iej;
    private final e iem;
    private final com.facebook.imagepipeline.decoder.b ien;
    private final com.facebook.imagepipeline.b.f ier;
    private final com.facebook.imagepipeline.decoder.d iet;
    private final boolean iev;
    private AssetManager ifa;
    private final com.facebook.imagepipeline.c.l ifb;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.ifa = context.getApplicationContext().getAssets();
        this.hXc = aVar;
        this.ien = bVar;
        this.iet = dVar;
        this.iej = z;
        this.iev = z2;
        this.ieI = z3;
        this.iem = eVar;
        this.icg = gVar;
        this.idZ = tVar;
        this.iea = tVar2;
        this.idn = eVar2;
        this.ido = eVar3;
        this.ieV = rVar;
        this.ieG = qVar;
        this.idp = fVar;
        this.ier = fVar2;
        if (i > 0) {
            this.ifb = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.ifb = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.idZ, this.idp, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.idp, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.idZ, this.idp, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k bVU() {
        return new com.facebook.imagepipeline.producers.k(this.icg);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.hXc, this.iem.bUU(), this.ien, this.iet, this.iej, this.iev, this.ieI, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.ifb);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.ifb);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.idn, this.ido, this.idp, this.ieV, this.ieG, this.ifb, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.idp, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.iea, this.idp, aiVar);
    }

    public u bVV() {
        return new u(this.iem.bUS(), this.icg, this.ifa);
    }

    public v bVW() {
        return new v(this.iem.bUS(), this.icg, this.mContentResolver);
    }

    public w bVX() {
        return new w(this.iem.bUS(), this.icg, this.mContentResolver);
    }

    public x bVY() {
        return new x(this.iem.bUS(), this.icg, this.mContentResolver);
    }

    public as a(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return new as(atVarArr);
    }

    public com.facebook.imagepipeline.producers.z bVZ() {
        return new com.facebook.imagepipeline.producers.z(this.iem.bUS(), this.icg);
    }

    public com.facebook.imagepipeline.producers.aa bWa() {
        return new com.facebook.imagepipeline.producers.aa(this.iem.bUS(), this.icg, this.mResources);
    }

    public ab bWb() {
        return new ab(this.iem.bUS());
    }

    public ae a(af afVar) {
        return new ae(this.icg, this.hXc, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.idZ, this.idp, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.ier, this.iem.bUV());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.iem.bUV(), this.icg, z && !this.iej, aiVar, z2);
    }

    public <T> ap<T> a(ai<T> aiVar, aq aqVar) {
        return new ap<>(aiVar, aqVar);
    }

    public <T> ar<T> m(ai<T> aiVar) {
        return new ar<>(5, this.iem.bUW(), aiVar);
    }

    public av n(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new av(this.iem.bUV(), this.icg, aiVar);
    }
}
