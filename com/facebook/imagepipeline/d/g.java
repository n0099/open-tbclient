package com.facebook.imagepipeline.d;

import android.net.Uri;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import com.facebook.imagepipeline.producers.at;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public class g {
    private static final CancellationException oWy = new CancellationException("Prefetching is not enabled");
    private final com.facebook.imagepipeline.h.c oWA;
    private final com.facebook.common.internal.j<Boolean> oWB;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oWC;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> oWD;
    private final com.facebook.imagepipeline.c.e oWE;
    private final com.facebook.imagepipeline.c.e oWF;
    private final com.facebook.imagepipeline.c.f oWG;
    private final at oWH;
    private final com.facebook.common.internal.j<Boolean> oWI;
    private AtomicLong oWJ = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> oWK;
    private final m oWz;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.oWz = mVar;
        this.oWA = new com.facebook.imagepipeline.h.b(set);
        this.oWB = jVar;
        this.oWC = pVar;
        this.oWD = pVar2;
        this.oWE = eVar;
        this.oWF = eVar2;
        this.oWG = fVar;
        this.oWH = atVar;
        this.oWI = jVar2;
        this.oWK = jVar3;
    }

    private String eog() {
        return String.valueOf(this.oWJ.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        return a(imageRequest, obj, requestLevel, null);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable com.facebook.imagepipeline.h.c cVar) {
        try {
            return a(this.oWz.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.oWB.get().booleanValue()) {
            return com.facebook.datasource.c.z(oWy);
        }
        try {
            if (this.oWI.get().booleanValue()) {
                e = this.oWz.b(imageRequest);
            } else {
                e = this.oWz.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.z(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.oWB.get().booleanValue()) {
            return com.facebook.datasource.c.z(oWy);
        }
        try {
            return a(this.oWz.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public boolean V(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.oWC.b(X(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> eoh() {
        return this.oWC;
    }

    public com.facebook.datasource.b<Boolean> W(Uri uri) {
        return a(ImageRequest.ac(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.oWG.c(imageRequest, null);
        final com.facebook.datasource.g ekL = com.facebook.datasource.g.ekL();
        this.oWE.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.il() || !gVar.getResult().booleanValue()) {
                    return g.this.oWF.k(c);
                }
                return bolts.g.l(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                ekL.bg(Boolean.valueOf((gVar.isCancelled() || gVar.il() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return ekL;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a2 = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, eog(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.eqV(), requestLevel), false, (imageRequest.erQ() || !com.facebook.common.util.d.L(imageRequest.erL())) ? true : true, imageRequest.eqX()), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a2 = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, eog(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.eqV(), requestLevel), true, false, priority), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.ekW() == null) {
                return this.oWA;
            }
            return new com.facebook.imagepipeline.h.b(this.oWA, imageRequest.ekW());
        } else if (imageRequest.ekW() == null) {
            return new com.facebook.imagepipeline.h.b(this.oWA, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.oWA, cVar, imageRequest.ekW());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> X(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean bb(com.facebook.cache.common.b bVar) {
                return bVar.J(uri);
            }
        };
    }

    public void pause() {
        this.oWH.erH();
    }

    public void resume() {
        this.oWH.erI();
    }

    public com.facebook.imagepipeline.c.f eoi() {
        return this.oWG;
    }
}
