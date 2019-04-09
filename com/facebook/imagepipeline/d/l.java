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
    private final com.facebook.common.memory.g jEK;
    private final com.facebook.imagepipeline.c.e jFQ;
    private final com.facebook.imagepipeline.c.e jFR;
    private final com.facebook.imagepipeline.c.f jFS;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jGA;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jGB;
    private final boolean jGK;
    private final e jGN;
    private final com.facebook.imagepipeline.decoder.b jGO;
    private final com.facebook.imagepipeline.b.f jGS;
    private final com.facebook.imagepipeline.decoder.d jGU;
    private final boolean jGW;
    private final com.facebook.imagepipeline.c.l jHB;
    @Nullable
    private final q jHh;
    private final boolean jHj;
    private final r jHw;
    private final com.facebook.common.memory.a jzA;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.jzA = aVar;
        this.jGO = bVar;
        this.jGU = dVar;
        this.jGK = z;
        this.jGW = z2;
        this.jHj = z3;
        this.jGN = eVar;
        this.jEK = gVar;
        this.jGA = tVar;
        this.jGB = tVar2;
        this.jFQ = eVar2;
        this.jFR = eVar3;
        this.jHw = rVar;
        this.jHh = qVar;
        this.jFS = fVar;
        this.jGS = fVar2;
        if (i > 0) {
            this.jHB = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.jHB = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.jGA, this.jFS, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.jFS, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.jGA, this.jFS, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cya() {
        return new com.facebook.imagepipeline.producers.k(this.jEK);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.jzA, this.jGN.cxa(), this.jGO, this.jGU, this.jGK, this.jGW, this.jHj, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.jHB);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.jHB);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.jFQ, this.jFR, this.jFS, this.jHw, this.jHh, this.jHB, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.jFS, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.jGB, this.jFS, aiVar);
    }

    public u cyb() {
        return new u(this.jGN.cwY(), this.jEK, this.mAssetManager);
    }

    public v cyc() {
        return new v(this.jGN.cwY(), this.jEK, this.mContentResolver);
    }

    public w cyd() {
        return new w(this.jGN.cwY(), this.jEK, this.mContentResolver);
    }

    public x cye() {
        return new x(this.jGN.cwY(), this.jEK, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cyf() {
        return new com.facebook.imagepipeline.producers.z(this.jGN.cwY(), this.jEK);
    }

    public com.facebook.imagepipeline.producers.aa cyg() {
        return new com.facebook.imagepipeline.producers.aa(this.jGN.cwY(), this.jEK, this.mResources);
    }

    public ab cyh() {
        return new ab(this.jGN.cwY());
    }

    public ae a(af afVar) {
        return new ae(this.jEK, this.jzA, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.jGA, this.jFS, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.jGS, this.jGN.cxb());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.jGN.cxb(), this.jEK, z && !this.jGK, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.jGN.cxc(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.jGN.cxb(), this.jEK, aiVar);
    }
}
