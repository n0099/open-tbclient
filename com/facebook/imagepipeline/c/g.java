package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
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
/* loaded from: classes5.dex */
public class g {
    private static final CancellationException pAS = new CancellationException("Prefetching is not enabled");
    private final m pAT;
    private final com.facebook.imagepipeline.g.c pAU;
    private final com.facebook.common.internal.j<Boolean> pAV;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pAW;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pAX;
    private final com.facebook.imagepipeline.b.e pAY;
    private final com.facebook.imagepipeline.b.e pAZ;
    private final com.facebook.imagepipeline.b.f pBa;
    private final at pBb;
    private final com.facebook.common.internal.j<Boolean> pBc;
    private AtomicLong pBd = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> pBe;

    public g(m mVar, Set<com.facebook.imagepipeline.g.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.pAT = mVar;
        this.pAU = new com.facebook.imagepipeline.g.b(set);
        this.pAV = jVar;
        this.pAW = pVar;
        this.pAX = pVar2;
        this.pAY = eVar;
        this.pAZ = eVar2;
        this.pBa = fVar;
        this.pBb = atVar;
        this.pBc = jVar2;
        this.pBe = jVar3;
    }

    private String exv() {
        return String.valueOf(this.pBd.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        return a(imageRequest, obj, requestLevel, null);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable com.facebook.imagepipeline.g.c cVar) {
        try {
            return a(this.pAT.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.pAV.get().booleanValue()) {
            return com.facebook.datasource.c.y(pAS);
        }
        try {
            if (this.pBc.get().booleanValue()) {
                e = this.pAT.b(imageRequest);
            } else {
                e = this.pAT.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.y(e2);
        }
    }

    public boolean aa(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.pAW.b(ac(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> exw() {
        return this.pAW;
    }

    public com.facebook.datasource.b<Boolean> ab(Uri uri) {
        return a(ImageRequest.ah(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.pBa.c(imageRequest, null);
        final com.facebook.datasource.g euD = com.facebook.datasource.g.euD();
        this.pAY.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.c.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.hC() || !gVar.getResult().booleanValue()) {
                    return g.this.pAZ.k(c);
                }
                return bolts.g.i(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.c.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                euD.bg(Boolean.valueOf((gVar.isCancelled() || gVar.hC() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return euD;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.g.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.g.c a2 = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.d.c.a(ajVar, new ap(imageRequest, exv(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.eAf(), requestLevel), false, (imageRequest.eAY() || !com.facebook.common.util.d.N(imageRequest.eAT())) ? true : true, imageRequest.eAh()), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.g.c a2 = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.d.d.a(ajVar, new ap(imageRequest, exv(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.eAf(), requestLevel), true, false, priority), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.y(e);
        }
    }

    private com.facebook.imagepipeline.g.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.g.c cVar) {
        if (cVar == null) {
            if (imageRequest.euO() == null) {
                return this.pAU;
            }
            return new com.facebook.imagepipeline.g.b(this.pAU, imageRequest.euO());
        } else if (imageRequest.euO() == null) {
            return new com.facebook.imagepipeline.g.b(this.pAU, cVar);
        } else {
            return new com.facebook.imagepipeline.g.b(this.pAU, cVar, imageRequest.euO());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> ac(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.c.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean apply(com.facebook.cache.common.b bVar) {
                return bVar.L(uri);
            }
        };
    }

    public com.facebook.imagepipeline.b.f exx() {
        return this.pBa;
    }
}
