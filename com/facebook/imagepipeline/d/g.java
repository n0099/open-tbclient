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
    private static final CancellationException lRQ = new CancellationException("Prefetching is not enabled");
    private final m lRR;
    private final com.facebook.imagepipeline.h.c lRS;
    private final com.facebook.common.internal.j<Boolean> lRT;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lRU;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> lRV;
    private final com.facebook.imagepipeline.c.e lRW;
    private final com.facebook.imagepipeline.c.e lRX;
    private final com.facebook.imagepipeline.c.f lRY;
    private final at lRZ;
    private final com.facebook.common.internal.j<Boolean> lSa;
    private AtomicLong lSb = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> lSc;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.lRR = mVar;
        this.lRS = new com.facebook.imagepipeline.h.b(set);
        this.lRT = jVar;
        this.lRU = pVar;
        this.lRV = pVar2;
        this.lRW = eVar;
        this.lRX = eVar2;
        this.lRY = fVar;
        this.lRZ = atVar;
        this.lSa = jVar2;
        this.lSc = jVar3;
    }

    private String doG() {
        return String.valueOf(this.lSb.getAndIncrement());
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
            return a(this.lRR.e(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> f;
        if (!this.lRT.get().booleanValue()) {
            return com.facebook.datasource.c.x(lRQ);
        }
        try {
            if (this.lSa.get().booleanValue()) {
                f = this.lRR.c(imageRequest);
            } else {
                f = this.lRR.f(imageRequest);
            }
            return a(f, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.lRT.get().booleanValue()) {
            return com.facebook.datasource.c.x(lRQ);
        }
        try {
            return a(this.lRR.c(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public void M(Uri uri) {
        com.facebook.common.internal.h<com.facebook.cache.common.b> R = R(uri);
        this.lRU.c(R);
        this.lRV.c(R);
    }

    public void N(Uri uri) {
        a(ImageRequest.W(uri));
    }

    public void a(ImageRequest imageRequest) {
        com.facebook.cache.common.b c = this.lRY.c(imageRequest, null);
        this.lRW.n(c);
        this.lRX.n(c);
    }

    public void O(Uri uri) {
        M(uri);
        N(uri);
    }

    public void doH() {
        com.facebook.common.internal.h<com.facebook.cache.common.b> hVar = new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aT(com.facebook.cache.common.b bVar) {
                return true;
            }
        };
        this.lRU.c(hVar);
        this.lRV.c(hVar);
    }

    public boolean P(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.lRU.d(R(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> doI() {
        return this.lRU;
    }

    public com.facebook.datasource.b<Boolean> Q(Uri uri) {
        return b(ImageRequest.W(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> b(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.lRY.c(imageRequest, null);
        final com.facebook.datasource.g dlp = com.facebook.datasource.g.dlp();
        this.lRW.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) {
                    return g.this.lRX.k(c);
                }
                return bolts.g.j(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dlp.aY(Boolean.valueOf((gVar.isCancelled() || gVar.aX() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dlp;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, doG(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.drx(), requestLevel), false, (imageRequest.dst() || !com.facebook.common.util.d.C(imageRequest.dso())) ? true : true, imageRequest.drz()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, doG(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.drx(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dlC() == null) {
                return this.lRS;
            }
            return new com.facebook.imagepipeline.h.b(this.lRS, imageRequest.dlC());
        } else if (imageRequest.dlC() == null) {
            return new com.facebook.imagepipeline.h.b(this.lRS, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.lRS, cVar, imageRequest.dlC());
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
        this.lRZ.dsj();
    }

    public void resume() {
        this.lRZ.dsk();
    }

    public com.facebook.imagepipeline.c.f doJ() {
        return this.lRY;
    }
}
