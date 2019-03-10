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
    private final com.facebook.common.memory.a jAn;
    private final com.facebook.common.memory.g jFx;
    private final com.facebook.imagepipeline.c.e jGD;
    private final com.facebook.imagepipeline.c.e jGE;
    private final com.facebook.imagepipeline.c.f jGF;
    private final e jHA;
    private final com.facebook.imagepipeline.decoder.b jHB;
    private final com.facebook.imagepipeline.b.f jHF;
    private final com.facebook.imagepipeline.decoder.d jHH;
    private final boolean jHJ;
    @Nullable
    private final q jHU;
    private final boolean jHW;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jHn;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jHo;
    private final boolean jHx;
    private final r jIj;
    private final com.facebook.imagepipeline.c.l jIo;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.jAn = aVar;
        this.jHB = bVar;
        this.jHH = dVar;
        this.jHx = z;
        this.jHJ = z2;
        this.jHW = z3;
        this.jHA = eVar;
        this.jFx = gVar;
        this.jHn = tVar;
        this.jHo = tVar2;
        this.jGD = eVar2;
        this.jGE = eVar3;
        this.jIj = rVar;
        this.jHU = qVar;
        this.jGF = fVar;
        this.jHF = fVar2;
        if (i > 0) {
            this.jIo = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.jIo = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.jHn, this.jGF, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.jGF, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.jHn, this.jGF, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cye() {
        return new com.facebook.imagepipeline.producers.k(this.jFx);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.jAn, this.jHA.cxe(), this.jHB, this.jHH, this.jHx, this.jHJ, this.jHW, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.jIo);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.jIo);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.jGD, this.jGE, this.jGF, this.jIj, this.jHU, this.jIo, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.jGF, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.jHo, this.jGF, aiVar);
    }

    public u cyf() {
        return new u(this.jHA.cxc(), this.jFx, this.mAssetManager);
    }

    public v cyg() {
        return new v(this.jHA.cxc(), this.jFx, this.mContentResolver);
    }

    public w cyh() {
        return new w(this.jHA.cxc(), this.jFx, this.mContentResolver);
    }

    public x cyi() {
        return new x(this.jHA.cxc(), this.jFx, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cyj() {
        return new com.facebook.imagepipeline.producers.z(this.jHA.cxc(), this.jFx);
    }

    public com.facebook.imagepipeline.producers.aa cyk() {
        return new com.facebook.imagepipeline.producers.aa(this.jHA.cxc(), this.jFx, this.mResources);
    }

    public ab cyl() {
        return new ab(this.jHA.cxc());
    }

    public ae a(af afVar) {
        return new ae(this.jFx, this.jAn, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.jHn, this.jGF, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.jHF, this.jHA.cxf());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.jHA.cxf(), this.jFx, z && !this.jHx, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.jHA.cxg(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.jHA.cxf(), this.jFx, aiVar);
    }
}
