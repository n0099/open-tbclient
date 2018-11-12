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
    private final com.facebook.common.memory.a hYN;
    private final com.facebook.common.memory.g idU;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ifK;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> ifL;
    private final boolean ifU;
    private final e ifX;
    private final com.facebook.imagepipeline.decoder.b ifY;
    private final com.facebook.imagepipeline.c.e ifa;
    private final com.facebook.imagepipeline.c.e ifb;
    private final com.facebook.imagepipeline.c.f ifc;
    private final r igG;
    private AssetManager igL;
    private final com.facebook.imagepipeline.c.l igM;
    private final com.facebook.imagepipeline.b.f igc;
    private final com.facebook.imagepipeline.decoder.d ige;
    private final boolean igg;
    @Nullable
    private final q igr;
    private final boolean igt;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.igL = context.getApplicationContext().getAssets();
        this.hYN = aVar;
        this.ifY = bVar;
        this.ige = dVar;
        this.ifU = z;
        this.igg = z2;
        this.igt = z3;
        this.ifX = eVar;
        this.idU = gVar;
        this.ifK = tVar;
        this.ifL = tVar2;
        this.ifa = eVar2;
        this.ifb = eVar3;
        this.igG = rVar;
        this.igr = qVar;
        this.ifc = fVar;
        this.igc = fVar2;
        if (i > 0) {
            this.igM = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.igM = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.ifK, this.ifc, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.ifc, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.ifK, this.ifc, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k bVp() {
        return new com.facebook.imagepipeline.producers.k(this.idU);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.hYN, this.ifX.bUp(), this.ifY, this.ige, this.ifU, this.igg, this.igt, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.igM);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.igM);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.ifa, this.ifb, this.ifc, this.igG, this.igr, this.igM, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.ifc, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.ifL, this.ifc, aiVar);
    }

    public u bVq() {
        return new u(this.ifX.bUn(), this.idU, this.igL);
    }

    public v bVr() {
        return new v(this.ifX.bUn(), this.idU, this.mContentResolver);
    }

    public w bVs() {
        return new w(this.ifX.bUn(), this.idU, this.mContentResolver);
    }

    public x bVt() {
        return new x(this.ifX.bUn(), this.idU, this.mContentResolver);
    }

    public as a(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return new as(atVarArr);
    }

    public com.facebook.imagepipeline.producers.z bVu() {
        return new com.facebook.imagepipeline.producers.z(this.ifX.bUn(), this.idU);
    }

    public com.facebook.imagepipeline.producers.aa bVv() {
        return new com.facebook.imagepipeline.producers.aa(this.ifX.bUn(), this.idU, this.mResources);
    }

    public ab bVw() {
        return new ab(this.ifX.bUn());
    }

    public ae a(af afVar) {
        return new ae(this.idU, this.hYN, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.ifK, this.ifc, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.igc, this.ifX.bUq());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.ifX.bUq(), this.idU, z && !this.ifU, aiVar, z2);
    }

    public <T> ap<T> a(ai<T> aiVar, aq aqVar) {
        return new ap<>(aiVar, aqVar);
    }

    public <T> ar<T> m(ai<T> aiVar) {
        return new ar<>(5, this.ifX.bUr(), aiVar);
    }

    public av n(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new av(this.ifX.bUq(), this.idU, aiVar);
    }
}
