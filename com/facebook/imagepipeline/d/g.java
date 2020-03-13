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
    private static final CancellationException lSd = new CancellationException("Prefetching is not enabled");
    private final m lSe;
    private final com.facebook.imagepipeline.h.c lSf;
    private final com.facebook.common.internal.j<Boolean> lSg;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lSh;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lSi;
    private final com.facebook.imagepipeline.c.e lSj;
    private final com.facebook.imagepipeline.c.e lSk;
    private final com.facebook.imagepipeline.c.f lSl;
    private final at lSm;
    private final com.facebook.common.internal.j<Boolean> lSn;
    private AtomicLong lSo = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> lSp;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.lSe = mVar;
        this.lSf = new com.facebook.imagepipeline.h.b(set);
        this.lSg = jVar;
        this.lSh = pVar;
        this.lSi = pVar2;
        this.lSj = eVar;
        this.lSk = eVar2;
        this.lSl = fVar;
        this.lSm = atVar;
        this.lSn = jVar2;
        this.lSp = jVar3;
    }

    private String doJ() {
        return String.valueOf(this.lSo.getAndIncrement());
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
            return a(this.lSe.e(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> f;
        if (!this.lSg.get().booleanValue()) {
            return com.facebook.datasource.c.x(lSd);
        }
        try {
            if (this.lSn.get().booleanValue()) {
                f = this.lSe.c(imageRequest);
            } else {
                f = this.lSe.f(imageRequest);
            }
            return a(f, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.lSg.get().booleanValue()) {
            return com.facebook.datasource.c.x(lSd);
        }
        try {
            return a(this.lSe.c(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public void M(Uri uri) {
        com.facebook.common.internal.h<com.facebook.cache.common.b> R = R(uri);
        this.lSh.c(R);
        this.lSi.c(R);
    }

    public void N(Uri uri) {
        a(ImageRequest.W(uri));
    }

    public void a(ImageRequest imageRequest) {
        com.facebook.cache.common.b c = this.lSl.c(imageRequest, null);
        this.lSj.n(c);
        this.lSk.n(c);
    }

    public void O(Uri uri) {
        M(uri);
        N(uri);
    }

    public void doK() {
        com.facebook.common.internal.h<com.facebook.cache.common.b> hVar = new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aT(com.facebook.cache.common.b bVar) {
                return true;
            }
        };
        this.lSh.c(hVar);
        this.lSi.c(hVar);
    }

    public boolean P(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.lSh.d(R(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> doL() {
        return this.lSh;
    }

    public com.facebook.datasource.b<Boolean> Q(Uri uri) {
        return b(ImageRequest.W(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> b(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.lSl.c(imageRequest, null);
        final com.facebook.datasource.g dls = com.facebook.datasource.g.dls();
        this.lSj.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) {
                    return g.this.lSk.k(c);
                }
                return bolts.g.j(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dls.aY(Boolean.valueOf((gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dls;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, doJ(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.drA(), requestLevel), false, (imageRequest.dsw() || !com.facebook.common.util.d.C(imageRequest.dsr())) ? true : true, imageRequest.drC()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, doJ(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.drA(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dlF() == null) {
                return this.lSf;
            }
            return new com.facebook.imagepipeline.h.b(this.lSf, imageRequest.dlF());
        } else if (imageRequest.dlF() == null) {
            return new com.facebook.imagepipeline.h.b(this.lSf, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.lSf, cVar, imageRequest.dlF());
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
        this.lSm.dsm();
    }

    public void resume() {
        this.lSm.dsn();
    }

    public com.facebook.imagepipeline.c.f doM() {
        return this.lSl;
    }
}
