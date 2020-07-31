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
    private static final CancellationException naK = new CancellationException("Prefetching is not enabled");
    private final m naL;
    private final com.facebook.imagepipeline.h.c naM;
    private final com.facebook.common.internal.j<Boolean> naN;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> naO;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> naP;
    private final com.facebook.imagepipeline.c.e naQ;
    private final com.facebook.imagepipeline.c.e naR;
    private final com.facebook.imagepipeline.c.f naS;
    private final at naT;
    private final com.facebook.common.internal.j<Boolean> naU;
    private AtomicLong naV = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> naW;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.naL = mVar;
        this.naM = new com.facebook.imagepipeline.h.b(set);
        this.naN = jVar;
        this.naO = pVar;
        this.naP = pVar2;
        this.naQ = eVar;
        this.naR = eVar2;
        this.naS = fVar;
        this.naT = atVar;
        this.naU = jVar2;
        this.naW = jVar3;
    }

    private String dGB() {
        return String.valueOf(this.naV.getAndIncrement());
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
            return a(this.naL.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.A(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.naN.get().booleanValue()) {
            return com.facebook.datasource.c.A(naK);
        }
        try {
            if (this.naU.get().booleanValue()) {
                e = this.naL.b(imageRequest);
            } else {
                e = this.naL.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.A(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.naN.get().booleanValue()) {
            return com.facebook.datasource.c.A(naK);
        }
        try {
            return a(this.naL.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.A(e);
        }
    }

    public boolean S(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.naO.b(U(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dGC() {
        return this.naO;
    }

    public com.facebook.datasource.b<Boolean> T(Uri uri) {
        return a(ImageRequest.Z(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.naS.c(imageRequest, null);
        final com.facebook.datasource.g dDh = com.facebook.datasource.g.dDh();
        this.naQ.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.gK() || !gVar.getResult().booleanValue()) {
                    return g.this.naR.k(c);
                }
                return bolts.g.k(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dDh.aU(Boolean.valueOf((gVar.isCancelled() || gVar.gK() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dDh;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dGB(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dJq(), requestLevel), false, (imageRequest.dKl() || !com.facebook.common.util.d.I(imageRequest.dKg())) ? true : true, imageRequest.dJs()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.A(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dGB(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dJq(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.A(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dDs() == null) {
                return this.naM;
            }
            return new com.facebook.imagepipeline.h.b(this.naM, imageRequest.dDs());
        } else if (imageRequest.dDs() == null) {
            return new com.facebook.imagepipeline.h.b(this.naM, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.naM, cVar, imageRequest.dDs());
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
        this.naT.dKc();
    }

    public void resume() {
        this.naT.dKd();
    }

    public com.facebook.imagepipeline.c.f dGD() {
        return this.naS;
    }
}
