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
    private final com.facebook.common.memory.a jAf;
    private final com.facebook.common.memory.g jFp;
    private final com.facebook.imagepipeline.c.e jGv;
    private final com.facebook.imagepipeline.c.e jGw;
    private final com.facebook.imagepipeline.c.f jGx;
    private final boolean jHB;
    @Nullable
    private final q jHM;
    private final boolean jHO;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jHf;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jHg;
    private final boolean jHp;
    private final e jHs;
    private final com.facebook.imagepipeline.decoder.b jHt;
    private final com.facebook.imagepipeline.b.f jHx;
    private final com.facebook.imagepipeline.decoder.d jHz;
    private final r jIb;
    private final com.facebook.imagepipeline.c.l jIg;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.jAf = aVar;
        this.jHt = bVar;
        this.jHz = dVar;
        this.jHp = z;
        this.jHB = z2;
        this.jHO = z3;
        this.jHs = eVar;
        this.jFp = gVar;
        this.jHf = tVar;
        this.jHg = tVar2;
        this.jGv = eVar2;
        this.jGw = eVar3;
        this.jIb = rVar;
        this.jHM = qVar;
        this.jGx = fVar;
        this.jHx = fVar2;
        if (i > 0) {
            this.jIg = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.jIg = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.jHf, this.jGx, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.jGx, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.jHf, this.jGx, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cyh() {
        return new com.facebook.imagepipeline.producers.k(this.jFp);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.jAf, this.jHs.cxh(), this.jHt, this.jHz, this.jHp, this.jHB, this.jHO, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.jIg);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.jIg);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.jGv, this.jGw, this.jGx, this.jIb, this.jHM, this.jIg, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.jGx, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.jHg, this.jGx, aiVar);
    }

    public u cyi() {
        return new u(this.jHs.cxf(), this.jFp, this.mAssetManager);
    }

    public v cyj() {
        return new v(this.jHs.cxf(), this.jFp, this.mContentResolver);
    }

    public w cyk() {
        return new w(this.jHs.cxf(), this.jFp, this.mContentResolver);
    }

    public x cyl() {
        return new x(this.jHs.cxf(), this.jFp, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cym() {
        return new com.facebook.imagepipeline.producers.z(this.jHs.cxf(), this.jFp);
    }

    public com.facebook.imagepipeline.producers.aa cyn() {
        return new com.facebook.imagepipeline.producers.aa(this.jHs.cxf(), this.jFp, this.mResources);
    }

    public ab cyo() {
        return new ab(this.jHs.cxf());
    }

    public ae a(af afVar) {
        return new ae(this.jFp, this.jAf, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.jHf, this.jGx, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.jHx, this.jHs.cxi());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.jHs.cxi(), this.jFp, z && !this.jHp, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.jHs.cxj(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.jHs.cxi(), this.jFp, aiVar);
    }
}
