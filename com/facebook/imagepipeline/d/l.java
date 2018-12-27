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
    private final com.facebook.common.memory.a ijk;
    private final com.facebook.common.memory.g ioq;
    private final com.facebook.imagepipeline.c.e ipw;
    private final com.facebook.imagepipeline.c.e ipx;
    private final com.facebook.imagepipeline.c.f ipy;
    private final com.facebook.imagepipeline.decoder.d iqA;
    private final boolean iqC;
    @Nullable
    private final q iqN;
    private final boolean iqP;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iqg;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> iqh;
    private final boolean iqq;
    private final e iqt;
    private final com.facebook.imagepipeline.decoder.b iqu;
    private final com.facebook.imagepipeline.b.f iqy;
    private final r irc;
    private AssetManager irh;
    private final com.facebook.imagepipeline.c.l iri;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.irh = context.getApplicationContext().getAssets();
        this.ijk = aVar;
        this.iqu = bVar;
        this.iqA = dVar;
        this.iqq = z;
        this.iqC = z2;
        this.iqP = z3;
        this.iqt = eVar;
        this.ioq = gVar;
        this.iqg = tVar;
        this.iqh = tVar2;
        this.ipw = eVar2;
        this.ipx = eVar3;
        this.irc = rVar;
        this.iqN = qVar;
        this.ipy = fVar;
        this.iqy = fVar2;
        if (i > 0) {
            this.iri = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.iri = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.iqg, this.ipy, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.ipy, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.iqg, this.ipy, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k bYl() {
        return new com.facebook.imagepipeline.producers.k(this.ioq);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.ijk, this.iqt.bXl(), this.iqu, this.iqA, this.iqq, this.iqC, this.iqP, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.iri);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.iri);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.ipw, this.ipx, this.ipy, this.irc, this.iqN, this.iri, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.ipy, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.iqh, this.ipy, aiVar);
    }

    public u bYm() {
        return new u(this.iqt.bXj(), this.ioq, this.irh);
    }

    public v bYn() {
        return new v(this.iqt.bXj(), this.ioq, this.mContentResolver);
    }

    public w bYo() {
        return new w(this.iqt.bXj(), this.ioq, this.mContentResolver);
    }

    public x bYp() {
        return new x(this.iqt.bXj(), this.ioq, this.mContentResolver);
    }

    public as a(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return new as(atVarArr);
    }

    public com.facebook.imagepipeline.producers.z bYq() {
        return new com.facebook.imagepipeline.producers.z(this.iqt.bXj(), this.ioq);
    }

    public com.facebook.imagepipeline.producers.aa bYr() {
        return new com.facebook.imagepipeline.producers.aa(this.iqt.bXj(), this.ioq, this.mResources);
    }

    public ab bYs() {
        return new ab(this.iqt.bXj());
    }

    public ae a(af afVar) {
        return new ae(this.ioq, this.ijk, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.iqg, this.ipy, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.iqy, this.iqt.bXm());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.iqt.bXm(), this.ioq, z && !this.iqq, aiVar, z2);
    }

    public <T> ap<T> a(ai<T> aiVar, aq aqVar) {
        return new ap<>(aiVar, aqVar);
    }

    public <T> ar<T> m(ai<T> aiVar) {
        return new ar<>(5, this.iqt.bXn(), aiVar);
    }

    public av n(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new av(this.iqt.bXm(), this.ioq, aiVar);
    }
}
