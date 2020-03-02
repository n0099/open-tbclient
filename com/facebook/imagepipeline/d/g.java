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
/* loaded from: classes12.dex */
public class g {
    private static final CancellationException lRS = new CancellationException("Prefetching is not enabled");
    private final m lRT;
    private final com.facebook.imagepipeline.h.c lRU;
    private final com.facebook.common.internal.j<Boolean> lRV;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lRW;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lRX;
    private final com.facebook.imagepipeline.c.e lRY;
    private final com.facebook.imagepipeline.c.e lRZ;
    private final com.facebook.imagepipeline.c.f lSa;
    private final at lSb;
    private final com.facebook.common.internal.j<Boolean> lSc;
    private AtomicLong lSd = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> lSe;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.lRT = mVar;
        this.lRU = new com.facebook.imagepipeline.h.b(set);
        this.lRV = jVar;
        this.lRW = pVar;
        this.lRX = pVar2;
        this.lRY = eVar;
        this.lRZ = eVar2;
        this.lSa = fVar;
        this.lSb = atVar;
        this.lSc = jVar2;
        this.lSe = jVar3;
    }

    private String doI() {
        return String.valueOf(this.lSd.getAndIncrement());
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
            return a(this.lRT.e(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> f;
        if (!this.lRV.get().booleanValue()) {
            return com.facebook.datasource.c.x(lRS);
        }
        try {
            if (this.lSc.get().booleanValue()) {
                f = this.lRT.c(imageRequest);
            } else {
                f = this.lRT.f(imageRequest);
            }
            return a(f, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.lRV.get().booleanValue()) {
            return com.facebook.datasource.c.x(lRS);
        }
        try {
            return a(this.lRT.c(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public void M(Uri uri) {
        com.facebook.common.internal.h<com.facebook.cache.common.b> R = R(uri);
        this.lRW.c(R);
        this.lRX.c(R);
    }

    public void N(Uri uri) {
        a(ImageRequest.W(uri));
    }

    public void a(ImageRequest imageRequest) {
        com.facebook.cache.common.b c = this.lSa.c(imageRequest, null);
        this.lRY.n(c);
        this.lRZ.n(c);
    }

    public void O(Uri uri) {
        M(uri);
        N(uri);
    }

    public void doJ() {
        com.facebook.common.internal.h<com.facebook.cache.common.b> hVar = new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aT(com.facebook.cache.common.b bVar) {
                return true;
            }
        };
        this.lRW.c(hVar);
        this.lRX.c(hVar);
    }

    public boolean P(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.lRW.d(R(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> doK() {
        return this.lRW;
    }

    public com.facebook.datasource.b<Boolean> Q(Uri uri) {
        return b(ImageRequest.W(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> b(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.lSa.c(imageRequest, null);
        final com.facebook.datasource.g dlr = com.facebook.datasource.g.dlr();
        this.lRY.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) {
                    return g.this.lRZ.k(c);
                }
                return bolts.g.j(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dlr.aY(Boolean.valueOf((gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dlr;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, doI(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.drz(), requestLevel), false, (imageRequest.dsv() || !com.facebook.common.util.d.C(imageRequest.dsq())) ? true : true, imageRequest.drB()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, doI(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.drz(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dlE() == null) {
                return this.lRU;
            }
            return new com.facebook.imagepipeline.h.b(this.lRU, imageRequest.dlE());
        } else if (imageRequest.dlE() == null) {
            return new com.facebook.imagepipeline.h.b(this.lRU, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.lRU, cVar, imageRequest.dlE());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> R(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aT(com.facebook.cache.common.b bVar) {
                return bVar.A(uri);
            }
        };
    }

    public void pause() {
        this.lSb.dsl();
    }

    public void resume() {
        this.lSb.dsm();
    }

    public com.facebook.imagepipeline.c.f doL() {
        return this.lSa;
    }
}
