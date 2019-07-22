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
    private final com.facebook.common.memory.a jZy;
    private final com.facebook.common.memory.g keG;
    private final com.facebook.imagepipeline.c.e kfN;
    private final com.facebook.imagepipeline.c.e kfO;
    private final com.facebook.imagepipeline.c.f kfP;
    private final boolean kgH;
    private final e kgK;
    private final com.facebook.imagepipeline.decoder.b kgL;
    private final com.facebook.imagepipeline.b.f kgP;
    private final com.facebook.imagepipeline.decoder.d kgR;
    private final boolean kgT;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kgx;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> kgy;
    @Nullable
    private final q khe;
    private final boolean khg;
    private final r kht;
    private final com.facebook.imagepipeline.c.l khy;
    private AssetManager mAssetManager;
    private ContentResolver mContentResolver;
    private Resources mResources;

    public l(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, r rVar, @Nullable q qVar, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.jZy = aVar;
        this.kgL = bVar;
        this.kgR = dVar;
        this.kgH = z;
        this.kgT = z2;
        this.khg = z3;
        this.kgK = eVar;
        this.keG = gVar;
        this.kgx = tVar;
        this.kgy = tVar2;
        this.kfN = eVar2;
        this.kfO = eVar3;
        this.kht = rVar;
        this.khe = qVar;
        this.kfP = fVar;
        this.kgP = fVar2;
        if (i > 0) {
            this.khy = new aa(eVar2, eVar3, fVar, i);
        } else {
            this.khy = new z(eVar2, eVar3, fVar);
        }
    }

    public static com.facebook.imagepipeline.producers.a a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.a(aiVar);
    }

    public com.facebook.imagepipeline.producers.f b(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.f(this.kgx, this.kfP, aiVar);
    }

    public com.facebook.imagepipeline.producers.g c(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.g(this.kfP, aiVar);
    }

    public com.facebook.imagepipeline.producers.h d(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new com.facebook.imagepipeline.producers.h(this.kgx, this.kfP, aiVar);
    }

    public static com.facebook.imagepipeline.producers.i a(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        return new com.facebook.imagepipeline.producers.i(aiVar, aiVar2);
    }

    public com.facebook.imagepipeline.producers.k cJa() {
        return new com.facebook.imagepipeline.producers.k(this.keG);
    }

    public com.facebook.imagepipeline.producers.l e(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.l(this.jZy, this.kgK.cIa(), this.kgL, this.kgR, this.kgH, this.kgT, this.khg, aiVar);
    }

    public n f(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new n(aiVar, this.khy);
    }

    public o g(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new o(aiVar, this.khy);
    }

    public ac h(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new ac(this.kfN, this.kfO, this.kfP, this.kht, this.khe, this.khy, aiVar);
    }

    public com.facebook.imagepipeline.producers.q i(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.q(this.kfP, aiVar);
    }

    public com.facebook.imagepipeline.producers.r j(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new com.facebook.imagepipeline.producers.r(this.kgy, this.kfP, aiVar);
    }

    public u cJb() {
        return new u(this.kgK.cHY(), this.keG, this.mAssetManager);
    }

    public v cJc() {
        return new v(this.kgK.cHY(), this.keG, this.mContentResolver);
    }

    public w cJd() {
        return new w(this.kgK.cHY(), this.keG, this.mContentResolver);
    }

    public x cJe() {
        return new x(this.kgK.cHY(), this.keG, this.mContentResolver);
    }

    public at a(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return new at(auVarArr);
    }

    public com.facebook.imagepipeline.producers.z cJf() {
        return new com.facebook.imagepipeline.producers.z(this.kgK.cHY(), this.keG);
    }

    public com.facebook.imagepipeline.producers.aa cJg() {
        return new com.facebook.imagepipeline.producers.aa(this.kgK.cHY(), this.keG, this.mResources);
    }

    public ab cJh() {
        return new ab(this.kgK.cHY());
    }

    public ae a(af afVar) {
        return new ae(this.keG, this.jZy, afVar);
    }

    public ag k(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ag(this.kgx, this.kfP, aiVar);
    }

    public ah l(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return new ah(aiVar, this.kgP, this.kgK.cIb());
    }

    public am a(ai<com.facebook.imagepipeline.f.d> aiVar, boolean z, boolean z2) {
        return new am(this.kgK.cIb(), this.keG, z && !this.kgH, aiVar, z2);
    }

    public static <T> ap<T> m(ai<T> aiVar) {
        return new ap<>(aiVar);
    }

    public <T> aq<T> a(ai<T> aiVar, ar arVar) {
        return new aq<>(aiVar, arVar);
    }

    public <T> as<T> n(ai<T> aiVar) {
        return new as<>(5, this.kgK.cIc(), aiVar);
    }

    public aw o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return new aw(this.kgK.cIb(), this.keG, aiVar);
    }
}
