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
/* loaded from: classes4.dex */
public class g {
    private static final CancellationException naM = new CancellationException("Prefetching is not enabled");
    private final m naN;
    private final com.facebook.imagepipeline.h.c naO;
    private final com.facebook.common.internal.j<Boolean> naP;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> naQ;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> naR;
    private final com.facebook.imagepipeline.c.e naS;
    private final com.facebook.imagepipeline.c.e naT;
    private final com.facebook.imagepipeline.c.f naU;
    private final at naV;
    private final com.facebook.common.internal.j<Boolean> naW;
    private AtomicLong naX = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> naY;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.naN = mVar;
        this.naO = new com.facebook.imagepipeline.h.b(set);
        this.naP = jVar;
        this.naQ = pVar;
        this.naR = pVar2;
        this.naS = eVar;
        this.naT = eVar2;
        this.naU = fVar;
        this.naV = atVar;
        this.naW = jVar2;
        this.naY = jVar3;
    }

    private String dGC() {
        return String.valueOf(this.naX.getAndIncrement());
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
            return a(this.naN.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.A(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.naP.get().booleanValue()) {
            return com.facebook.datasource.c.A(naM);
        }
        try {
            if (this.naW.get().booleanValue()) {
                e = this.naN.b(imageRequest);
            } else {
                e = this.naN.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.A(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.naP.get().booleanValue()) {
            return com.facebook.datasource.c.A(naM);
        }
        try {
            return a(this.naN.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.A(e);
        }
    }

    public boolean S(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.naQ.b(U(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dGD() {
        return this.naQ;
    }

    public com.facebook.datasource.b<Boolean> T(Uri uri) {
        return a(ImageRequest.Z(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.naU.c(imageRequest, null);
        final com.facebook.datasource.g dDi = com.facebook.datasource.g.dDi();
        this.naS.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.gK() || !gVar.getResult().booleanValue()) {
                    return g.this.naT.k(c);
                }
                return bolts.g.k(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dDi.aU(Boolean.valueOf((gVar.isCancelled() || gVar.gK() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dDi;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dGC(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dJr(), requestLevel), false, (imageRequest.dKm() || !com.facebook.common.util.d.I(imageRequest.dKh())) ? true : true, imageRequest.dJt()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.A(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dGC(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dJr(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.A(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dDt() == null) {
                return this.naO;
            }
            return new com.facebook.imagepipeline.h.b(this.naO, imageRequest.dDt());
        } else if (imageRequest.dDt() == null) {
            return new com.facebook.imagepipeline.h.b(this.naO, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.naO, cVar, imageRequest.dDt());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> U(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aP(com.facebook.cache.common.b bVar) {
                return bVar.G(uri);
            }
        };
    }

    public void pause() {
        this.naV.dKd();
    }

    public void resume() {
        this.naV.dKe();
    }

    public com.facebook.imagepipeline.c.f dGE() {
        return this.naU;
    }
}
