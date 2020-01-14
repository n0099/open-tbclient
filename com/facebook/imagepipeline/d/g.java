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
    private static final CancellationException lRj = new CancellationException("Prefetching is not enabled");
    private final m lRk;
    private final com.facebook.imagepipeline.h.c lRl;
    private final com.facebook.common.internal.j<Boolean> lRm;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lRn;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lRo;
    private final com.facebook.imagepipeline.c.e lRp;
    private final com.facebook.imagepipeline.c.e lRq;
    private final com.facebook.imagepipeline.c.f lRr;
    private final at lRs;
    private final com.facebook.common.internal.j<Boolean> lRt;
    private AtomicLong lRu = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> lRv;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.lRk = mVar;
        this.lRl = new com.facebook.imagepipeline.h.b(set);
        this.lRm = jVar;
        this.lRn = pVar;
        this.lRo = pVar2;
        this.lRp = eVar;
        this.lRq = eVar2;
        this.lRr = fVar;
        this.lRs = atVar;
        this.lRt = jVar2;
        this.lRv = jVar3;
    }

    private String dnu() {
        return String.valueOf(this.lRu.getAndIncrement());
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
            return a(this.lRk.e(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> f;
        if (!this.lRm.get().booleanValue()) {
            return com.facebook.datasource.c.y(lRj);
        }
        try {
            if (this.lRt.get().booleanValue()) {
                f = this.lRk.c(imageRequest);
            } else {
                f = this.lRk.f(imageRequest);
            }
            return a(f, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.lRm.get().booleanValue()) {
            return com.facebook.datasource.c.y(lRj);
        }
        try {
            return a(this.lRk.c(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    public void L(Uri uri) {
        com.facebook.common.internal.h<com.facebook.cache.common.b> Q = Q(uri);
        this.lRn.c(Q);
        this.lRo.c(Q);
    }

    public void M(Uri uri) {
        a(ImageRequest.V(uri));
    }

    public void a(ImageRequest imageRequest) {
        com.facebook.cache.common.b c = this.lRr.c(imageRequest, null);
        this.lRp.n(c);
        this.lRq.n(c);
    }

    public void N(Uri uri) {
        L(uri);
        M(uri);
    }

    public void dnv() {
        com.facebook.common.internal.h<com.facebook.cache.common.b> hVar = new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aR(com.facebook.cache.common.b bVar) {
                return true;
            }
        };
        this.lRn.c(hVar);
        this.lRo.c(hVar);
    }

    public boolean O(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.lRn.d(Q(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dnw() {
        return this.lRn;
    }

    public com.facebook.datasource.b<Boolean> P(Uri uri) {
        return b(ImageRequest.V(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> b(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.lRr.c(imageRequest, null);
        final com.facebook.datasource.g dkc = com.facebook.datasource.g.dkc();
        this.lRp.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) {
                    return g.this.lRq.k(c);
                }
                return bolts.g.j(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dkc.aW(Boolean.valueOf((gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dkc;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dnu(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dql(), requestLevel), false, (imageRequest.drh() || !com.facebook.common.util.d.B(imageRequest.drc())) ? true : true, imageRequest.dqn()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dnu(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dql(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dkp() == null) {
                return this.lRl;
            }
            return new com.facebook.imagepipeline.h.b(this.lRl, imageRequest.dkp());
        } else if (imageRequest.dkp() == null) {
            return new com.facebook.imagepipeline.h.b(this.lRl, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.lRl, cVar, imageRequest.dkp());
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
        this.lRs.dqX();
    }

    public void resume() {
        this.lRs.dqY();
    }

    public com.facebook.imagepipeline.c.f dnx() {
        return this.lRr;
    }
}
