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
/* loaded from: classes10.dex */
public class g {
    private static final CancellationException lRe = new CancellationException("Prefetching is not enabled");
    private final m lRf;
    private final com.facebook.imagepipeline.h.c lRg;
    private final com.facebook.common.internal.j<Boolean> lRh;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lRi;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lRj;
    private final com.facebook.imagepipeline.c.e lRk;
    private final com.facebook.imagepipeline.c.e lRl;
    private final com.facebook.imagepipeline.c.f lRm;
    private final at lRn;
    private final com.facebook.common.internal.j<Boolean> lRo;
    private AtomicLong lRp = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> lRq;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.lRf = mVar;
        this.lRg = new com.facebook.imagepipeline.h.b(set);
        this.lRh = jVar;
        this.lRi = pVar;
        this.lRj = pVar2;
        this.lRk = eVar;
        this.lRl = eVar2;
        this.lRm = fVar;
        this.lRn = atVar;
        this.lRo = jVar2;
        this.lRq = jVar3;
    }

    private String dnr() {
        return String.valueOf(this.lRp.getAndIncrement());
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
            return a(this.lRf.e(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> f;
        if (!this.lRh.get().booleanValue()) {
            return com.facebook.datasource.c.y(lRe);
        }
        try {
            if (this.lRo.get().booleanValue()) {
                f = this.lRf.c(imageRequest);
            } else {
                f = this.lRf.f(imageRequest);
            }
            return a(f, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.lRh.get().booleanValue()) {
            return com.facebook.datasource.c.y(lRe);
        }
        try {
            return a(this.lRf.c(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    public void L(Uri uri) {
        com.facebook.common.internal.h<com.facebook.cache.common.b> Q = Q(uri);
        this.lRi.c(Q);
        this.lRj.c(Q);
    }

    public void M(Uri uri) {
        a(ImageRequest.V(uri));
    }

    public void a(ImageRequest imageRequest) {
        com.facebook.cache.common.b c = this.lRm.c(imageRequest, null);
        this.lRk.n(c);
        this.lRl.n(c);
    }

    public void N(Uri uri) {
        L(uri);
        M(uri);
    }

    public void dnt() {
        com.facebook.common.internal.h<com.facebook.cache.common.b> hVar = new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aR(com.facebook.cache.common.b bVar) {
                return true;
            }
        };
        this.lRi.c(hVar);
        this.lRj.c(hVar);
    }

    public boolean O(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.lRi.d(Q(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dnu() {
        return this.lRi;
    }

    public com.facebook.datasource.b<Boolean> P(Uri uri) {
        return b(ImageRequest.V(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> b(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.lRm.c(imageRequest, null);
        final com.facebook.datasource.g dka = com.facebook.datasource.g.dka();
        this.lRk.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) {
                    return g.this.lRl.k(c);
                }
                return bolts.g.j(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dka.aW(Boolean.valueOf((gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dka;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dnr(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dqj(), requestLevel), false, (imageRequest.drf() || !com.facebook.common.util.d.B(imageRequest.dra())) ? true : true, imageRequest.dql()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dnr(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dqj(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dkn() == null) {
                return this.lRg;
            }
            return new com.facebook.imagepipeline.h.b(this.lRg, imageRequest.dkn());
        } else if (imageRequest.dkn() == null) {
            return new com.facebook.imagepipeline.h.b(this.lRg, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.lRg, cVar, imageRequest.dkn());
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

    public void pause() {
        this.lRn.dqV();
    }

    public void resume() {
        this.lRn.dqW();
    }

    public com.facebook.imagepipeline.c.f dnv() {
        return this.lRm;
    }
}
