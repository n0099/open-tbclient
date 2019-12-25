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
/* loaded from: classes9.dex */
public class g {
    private static final CancellationException lNs = new CancellationException("Prefetching is not enabled");
    private final com.facebook.imagepipeline.c.f lNA;
    private final at lNB;
    private final com.facebook.common.internal.j<Boolean> lNC;
    private AtomicLong lND = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> lNE;
    private final m lNt;
    private final com.facebook.imagepipeline.h.c lNu;
    private final com.facebook.common.internal.j<Boolean> lNv;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lNw;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lNx;
    private final com.facebook.imagepipeline.c.e lNy;
    private final com.facebook.imagepipeline.c.e lNz;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.lNt = mVar;
        this.lNu = new com.facebook.imagepipeline.h.b(set);
        this.lNv = jVar;
        this.lNw = pVar;
        this.lNx = pVar2;
        this.lNy = eVar;
        this.lNz = eVar2;
        this.lNA = fVar;
        this.lNB = atVar;
        this.lNC = jVar2;
        this.lNE = jVar3;
    }

    private String dml() {
        return String.valueOf(this.lND.getAndIncrement());
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
            return a(this.lNt.e(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> f;
        if (!this.lNv.get().booleanValue()) {
            return com.facebook.datasource.c.y(lNs);
        }
        try {
            if (this.lNC.get().booleanValue()) {
                f = this.lNt.c(imageRequest);
            } else {
                f = this.lNt.f(imageRequest);
            }
            return a(f, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    public void L(Uri uri) {
        com.facebook.common.internal.h<com.facebook.cache.common.b> Q = Q(uri);
        this.lNw.c(Q);
        this.lNx.c(Q);
    }

    public void M(Uri uri) {
        a(ImageRequest.V(uri));
    }

    public void a(ImageRequest imageRequest) {
        com.facebook.cache.common.b c = this.lNA.c(imageRequest, null);
        this.lNy.n(c);
        this.lNz.n(c);
    }

    public void N(Uri uri) {
        L(uri);
        M(uri);
    }

    public void dmm() {
        com.facebook.common.internal.h<com.facebook.cache.common.b> hVar = new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aR(com.facebook.cache.common.b bVar) {
                return true;
            }
        };
        this.lNw.c(hVar);
        this.lNx.c(hVar);
    }

    public boolean O(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.lNw.d(Q(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dmn() {
        return this.lNw;
    }

    public com.facebook.datasource.b<Boolean> P(Uri uri) {
        return b(ImageRequest.V(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> b(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.lNA.c(imageRequest, null);
        final com.facebook.datasource.g diZ = com.facebook.datasource.g.diZ();
        this.lNy.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) {
                    return g.this.lNz.k(c);
                }
                return bolts.g.j(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                diZ.aW(Boolean.valueOf((gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return diZ;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dml(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.doZ(), requestLevel), false, (imageRequest.dpS() || !com.facebook.common.util.d.B(imageRequest.dpN())) ? true : true, imageRequest.dpb()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dml(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.doZ(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.djm() == null) {
                return this.lNu;
            }
            return new com.facebook.imagepipeline.h.b(this.lNu, imageRequest.djm());
        } else if (imageRequest.djm() == null) {
            return new com.facebook.imagepipeline.h.b(this.lNu, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.lNu, cVar, imageRequest.djm());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> Q(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aR(com.facebook.cache.common.b bVar) {
                return bVar.z(uri);
            }
        };
    }

    public com.facebook.imagepipeline.c.f dmo() {
        return this.lNA;
    }
}
