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
/* loaded from: classes25.dex */
public class g {
    private static final CancellationException nER = new CancellationException("Prefetching is not enabled");
    private final m nES;
    private final com.facebook.imagepipeline.h.c nET;
    private final com.facebook.common.internal.j<Boolean> nEU;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nEV;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> nEW;
    private final com.facebook.imagepipeline.c.e nEX;
    private final com.facebook.imagepipeline.c.e nEY;
    private final com.facebook.imagepipeline.c.f nEZ;
    private final at nFa;
    private final com.facebook.common.internal.j<Boolean> nFb;
    private AtomicLong nFc = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> nFd;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.nES = mVar;
        this.nET = new com.facebook.imagepipeline.h.b(set);
        this.nEU = jVar;
        this.nEV = pVar;
        this.nEW = pVar2;
        this.nEX = eVar;
        this.nEY = eVar2;
        this.nEZ = fVar;
        this.nFa = atVar;
        this.nFb = jVar2;
        this.nFd = jVar3;
    }

    private String dWI() {
        return String.valueOf(this.nFc.getAndIncrement());
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
            return a(this.nES.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.nEU.get().booleanValue()) {
            return com.facebook.datasource.c.z(nER);
        }
        try {
            if (this.nFb.get().booleanValue()) {
                e = this.nES.b(imageRequest);
            } else {
                e = this.nES.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.z(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.nEU.get().booleanValue()) {
            return com.facebook.datasource.c.z(nER);
        }
        try {
            return a(this.nES.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public boolean U(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.nEV.b(W(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dWJ() {
        return this.nEV;
    }

    public com.facebook.datasource.b<Boolean> V(Uri uri) {
        return a(ImageRequest.ab(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.nEZ.c(imageRequest, null);
        final com.facebook.datasource.g dTp = com.facebook.datasource.g.dTp();
        this.nEX.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.ik() || !gVar.getResult().booleanValue()) {
                    return g.this.nEY.k(c);
                }
                return bolts.g.l(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dTp.aY(Boolean.valueOf((gVar.isCancelled() || gVar.ik() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dTp;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dWI(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dZx(), requestLevel), false, (imageRequest.eas() || !com.facebook.common.util.d.K(imageRequest.ean())) ? true : true, imageRequest.dZz()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dWI(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dZx(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dTA() == null) {
                return this.nET;
            }
            return new com.facebook.imagepipeline.h.b(this.nET, imageRequest.dTA());
        } else if (imageRequest.dTA() == null) {
            return new com.facebook.imagepipeline.h.b(this.nET, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.nET, cVar, imageRequest.dTA());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> W(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aT(com.facebook.cache.common.b bVar) {
                return bVar.I(uri);
            }
        };
    }

    public void pause() {
        this.nFa.eaj();
    }

    public void resume() {
        this.nFa.eak();
    }

    public com.facebook.imagepipeline.c.f dWK() {
        return this.nEZ;
    }
}
