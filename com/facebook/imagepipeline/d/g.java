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
    private static final CancellationException mbA = new CancellationException("Prefetching is not enabled");
    private final m mbB;
    private final com.facebook.imagepipeline.h.c mbC;
    private final com.facebook.common.internal.j<Boolean> mbD;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mbE;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mbF;
    private final com.facebook.imagepipeline.c.e mbG;
    private final com.facebook.imagepipeline.c.e mbH;
    private final com.facebook.imagepipeline.c.f mbI;
    private final at mbJ;
    private final com.facebook.common.internal.j<Boolean> mbK;
    private AtomicLong mbL = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> mbM;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.mbB = mVar;
        this.mbC = new com.facebook.imagepipeline.h.b(set);
        this.mbD = jVar;
        this.mbE = pVar;
        this.mbF = pVar2;
        this.mbG = eVar;
        this.mbH = eVar2;
        this.mbI = fVar;
        this.mbJ = atVar;
        this.mbK = jVar2;
        this.mbM = jVar3;
    }

    private String drd() {
        return String.valueOf(this.mbL.getAndIncrement());
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
            return a(this.mbB.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.mbD.get().booleanValue()) {
            return com.facebook.datasource.c.B(mbA);
        }
        try {
            if (this.mbK.get().booleanValue()) {
                e = this.mbB.b(imageRequest);
            } else {
                e = this.mbB.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.B(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.mbD.get().booleanValue()) {
            return com.facebook.datasource.c.B(mbA);
        }
        try {
            return a(this.mbB.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    public boolean Q(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.mbE.b(S(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dre() {
        return this.mbE;
    }

    public com.facebook.datasource.b<Boolean> R(Uri uri) {
        return a(ImageRequest.X(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.mbI.c(imageRequest, null);
        final com.facebook.datasource.g dnI = com.facebook.datasource.g.dnI();
        this.mbG.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.gu() || !gVar.getResult().booleanValue()) {
                    return g.this.mbH.k(c);
                }
                return bolts.g.k(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dnI.aP(Boolean.valueOf((gVar.isCancelled() || gVar.gu() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dnI;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, drd(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dtT(), requestLevel), false, (imageRequest.duO() || !com.facebook.common.util.d.G(imageRequest.duJ())) ? true : true, imageRequest.dtV()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, drd(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dtT(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dnT() == null) {
                return this.mbC;
            }
            return new com.facebook.imagepipeline.h.b(this.mbC, imageRequest.dnT());
        } else if (imageRequest.dnT() == null) {
            return new com.facebook.imagepipeline.h.b(this.mbC, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.mbC, cVar, imageRequest.dnT());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> S(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aK(com.facebook.cache.common.b bVar) {
                return bVar.E(uri);
            }
        };
    }

    public void pause() {
        this.mbJ.duF();
    }

    public void resume() {
        this.mbJ.duG();
    }

    public com.facebook.imagepipeline.c.f drf() {
        return this.mbI;
    }
}
