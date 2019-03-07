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
import com.facebook.imagepipeline.producers.au;
import com.facebook.imagepipeline.producers.aw;
import com.facebook.imagepipeline.producers.n;
import com.facebook.imagepipeline.producers.o;
import com.facebook.imagepipeline.producers.u;
import com.facebook.imagepipeline.producers.v;
import com.facebook.imagepipeline.producers.w;
import com.facebook.imagepipeline.producers.x;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class l {
    private final com.facebook.common.memory.g jFe;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jGU;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jGV;
    private final com.facebook.imagepipeline.c.e jGk;
    private final com.facebook.imagepipeline.c.e jGl;
    private final com.facebook.imagepipeline.c.f jGm;
    @Nullable
    private final q jHB;
    private final boolean jHD;
    private final r jHQ;
    private final com.facebook.imagepipeline.c.l jHV;
    private final boolean jHe;
    private final e jHh;
    private final com.facebook.imagepipeline.decoder.b jHi;
    private final com.facebook.imagepipeline.b.f jHm;
    private final com.facebook.imagepipeline.decoder.d jHo;
    private final boolean jHq;
    private final com.facebook.common.memory.a jzU;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.jzU = aVar;
        this.jHi = bVar;
        this.jHo = dVar;
        this.jHe = z;
        this.jHq = z2;
        this.jHD = z3;
        this.jHh = eVar;
        this.jFe = gVar;
        this.jGU = tVar;
        this.jGV = tVar2;
        this.jGk = eVar2;
        this.jGl = eVar3;
        this.jHQ = rVar;
        this.jHB = qVar;
        this.jGm = fVar;
        this.jHm = fVar2;
        if (i > 0) {
            this.jHV = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.jHV = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.jGU, this.jGm, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.jGm, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.jGU, this.jGm, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cxU() {
        return new com.facebook.imagepipeline.producers.k(this.jFe);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.jzU, this.jHh.cwU(), this.jHi, this.jHo, this.jHe, this.jHq, this.jHD, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.jHV);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.jHV);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.jGk, this.jGl, this.jGm, this.jHQ, this.jHB, this.jHV, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.jGm, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.jGV, this.jGm, aiVar);
    }

    public u cxV() {
        return new u(this.jHh.cwS(), this.jFe, this.mAssetManager);
    }

    public v cxW() {
        return new v(this.jHh.cwS(), this.jFe, this.mContentResolver);
    }

    public w cxX() {
        return new w(this.jHh.cwS(), this.jFe, this.mContentResolver);
    }

    public x cxY() {
        return new x(this.jHh.cwS(), this.jFe, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cxZ() {
        return new com.facebook.imagepipeline.producers.z(this.jHh.cwS(), this.jFe);
    }

    public com.facebook.imagepipeline.producers.aa cya() {
        return new com.facebook.imagepipeline.producers.aa(this.jHh.cwS(), this.jFe, this.mResources);
    }

    public ab cyb() {
        return new ab(this.jHh.cwS());
    }

    public ae a(af afVar) {
        return new ae(this.jFe, this.jzU, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.jGU, this.jGm, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.jHm, this.jHh.cwV());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.jHh.cwV(), this.jFe, z && !this.jHe, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.jHh.cwW(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.jHh.cwV(), this.jFe, aiVar);
    }
}
