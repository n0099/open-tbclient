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
    private final com.facebook.common.memory.a kdb;
    private final com.facebook.common.memory.g kik;
    private final com.facebook.imagepipeline.c.e kjr;
    private final com.facebook.imagepipeline.c.e kjs;
    private final com.facebook.imagepipeline.c.f kjt;
    @Nullable
    private final q kkI;
    private final boolean kkK;
    private final r kkX;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kkb;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> kkc;
    private final boolean kkl;
    private final e kko;
    private final com.facebook.imagepipeline.decoder.b kkp;
    private final com.facebook.imagepipeline.b.f kkt;
    private final com.facebook.imagepipeline.decoder.d kkv;
    private final boolean kkx;
    private final com.facebook.imagepipeline.c.l klc;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.kdb = aVar;
        this.kkp = bVar;
        this.kkv = dVar;
        this.kkl = z;
        this.kkx = z2;
        this.kkK = z3;
        this.kko = eVar;
        this.kik = gVar;
        this.kkb = tVar;
        this.kkc = tVar2;
        this.kjr = eVar2;
        this.kjs = eVar3;
        this.kkX = rVar;
        this.kkI = qVar;
        this.kjt = fVar;
        this.kkt = fVar2;
        if (i > 0) {
            this.klc = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.klc = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.kkb, this.kjt, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.kjt, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.kkb, this.kjt, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cKj() {
        return new com.facebook.imagepipeline.producers.k(this.kik);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.kdb, this.kko.cJj(), this.kkp, this.kkv, this.kkl, this.kkx, this.kkK, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.klc);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.klc);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.kjr, this.kjs, this.kjt, this.kkX, this.kkI, this.klc, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.kjt, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.kkc, this.kjt, aiVar);
    }

    public u cKk() {
        return new u(this.kko.cJh(), this.kik, this.mAssetManager);
    }

    public v cKl() {
        return new v(this.kko.cJh(), this.kik, this.mContentResolver);
    }

    public w cKm() {
        return new w(this.kko.cJh(), this.kik, this.mContentResolver);
    }

    public x cKn() {
        return new x(this.kko.cJh(), this.kik, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cKo() {
        return new com.facebook.imagepipeline.producers.z(this.kko.cJh(), this.kik);
    }

    public com.facebook.imagepipeline.producers.aa cKp() {
        return new com.facebook.imagepipeline.producers.aa(this.kko.cJh(), this.kik, this.mResources);
    }

    public ab cKq() {
        return new ab(this.kko.cJh());
    }

    public ae a(af afVar) {
        return new ae(this.kik, this.kdb, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.kkb, this.kjt, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.kkt, this.kko.cJk());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.kko.cJk(), this.kik, z && !this.kkl, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.kko.cJl(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.kko.cJk(), this.kik, aiVar);
    }
}
