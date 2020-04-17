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
    private static final CancellationException mbw = new CancellationException("Prefetching is not enabled");
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mbA;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mbB;
    private final com.facebook.imagepipeline.c.e mbC;
    private final com.facebook.imagepipeline.c.e mbD;
    private final com.facebook.imagepipeline.c.f mbE;
    private final at mbF;
    private final com.facebook.common.internal.j<Boolean> mbG;
    private AtomicLong mbH = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> mbI;
    private final m mbx;
    private final com.facebook.imagepipeline.h.c mby;
    private final com.facebook.common.internal.j<Boolean> mbz;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.mbx = mVar;
        this.mby = new com.facebook.imagepipeline.h.b(set);
        this.mbz = jVar;
        this.mbA = pVar;
        this.mbB = pVar2;
        this.mbC = eVar;
        this.mbD = eVar2;
        this.mbE = fVar;
        this.mbF = atVar;
        this.mbG = jVar2;
        this.mbI = jVar3;
    }

    private String drf() {
        return String.valueOf(this.mbH.getAndIncrement());
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
            return a(this.mbx.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.mbz.get().booleanValue()) {
            return com.facebook.datasource.c.B(mbw);
        }
        try {
            if (this.mbG.get().booleanValue()) {
                e = this.mbx.b(imageRequest);
            } else {
                e = this.mbx.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.B(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.mbz.get().booleanValue()) {
            return com.facebook.datasource.c.B(mbw);
        }
        try {
            return a(this.mbx.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    public boolean Q(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.mbA.b(S(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> drg() {
        return this.mbA;
    }

    public com.facebook.datasource.b<Boolean> R(Uri uri) {
        return a(ImageRequest.X(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.mbE.c(imageRequest, null);
        final com.facebook.datasource.g dnK = com.facebook.datasource.g.dnK();
        this.mbC.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.gu() || !gVar.getResult().booleanValue()) {
                    return g.this.mbD.k(c);
                }
                return bolts.g.j(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dnK.aO(Boolean.valueOf((gVar.isCancelled() || gVar.gu() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dnK;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, drf(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dtV(), requestLevel), false, (imageRequest.duQ() || !com.facebook.common.util.d.G(imageRequest.duL())) ? true : true, imageRequest.dtX()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, drf(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dtV(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dnV() == null) {
                return this.mby;
            }
            return new com.facebook.imagepipeline.h.b(this.mby, imageRequest.dnV());
        } else if (imageRequest.dnV() == null) {
            return new com.facebook.imagepipeline.h.b(this.mby, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.mby, cVar, imageRequest.dnV());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> S(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aJ(com.facebook.cache.common.b bVar) {
                return bVar.E(uri);
            }
        };
    }

    public void pause() {
        this.mbF.duH();
    }

    public void resume() {
        this.mbF.duI();
    }

    public com.facebook.imagepipeline.c.f drh() {
        return this.mbE;
    }
}
