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
    private static final CancellationException pIh = new CancellationException("Prefetching is not enabled");
    private final m pIi;
    private final com.facebook.imagepipeline.g.c pIj;
    private final com.facebook.common.internal.j<Boolean> pIk;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pIl;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pIm;
    private final com.facebook.imagepipeline.b.e pIn;
    private final com.facebook.imagepipeline.b.e pIo;
    private final com.facebook.imagepipeline.b.f pIp;
    private final at pIq;
    private final com.facebook.common.internal.j<Boolean> pIr;
    private AtomicLong pIs = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> pIt;

    public g(m mVar, Set<com.facebook.imagepipeline.g.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.pIi = mVar;
        this.pIj = new com.facebook.imagepipeline.g.b(set);
        this.pIk = jVar;
        this.pIl = pVar;
        this.pIm = pVar2;
        this.pIn = eVar;
        this.pIo = eVar2;
        this.pIp = fVar;
        this.pIq = atVar;
        this.pIr = jVar2;
        this.pIt = jVar3;
    }

    private String ewx() {
        return String.valueOf(this.pIs.getAndIncrement());
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
            return a(this.pIi.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.pIk.get().booleanValue()) {
            return com.facebook.datasource.c.x(pIh);
        }
        try {
            if (this.pIr.get().booleanValue()) {
                e = this.pIi.b(imageRequest);
            } else {
                e = this.pIi.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.x(e2);
        }
    }

    public void ewy() {
        com.facebook.common.internal.h<com.facebook.cache.common.b> hVar = new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.c.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean apply(com.facebook.cache.common.b bVar) {
                return true;
            }
        };
        this.pIl.c(hVar);
        this.pIm.c(hVar);
    }

    public boolean X(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.pIl.d(Z(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> ewz() {
        return this.pIl;
    }

    public com.facebook.datasource.b<Boolean> Y(Uri uri) {
        return a(ImageRequest.ae(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.pIp.c(imageRequest, null);
        final com.facebook.datasource.g etj = com.facebook.datasource.g.etj();
        this.pIn.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.c.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.hC() || !gVar.getResult().booleanValue()) {
                    return g.this.pIo.k(c);
                }
                return bolts.g.i(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.c.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                etj.bg(Boolean.valueOf((gVar.isCancelled() || gVar.hC() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return etj;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.g.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.g.c a2 = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.d.c.a(ajVar, new ap(imageRequest, ewx(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.ezj(), requestLevel), false, (imageRequest.eAc() || !com.facebook.common.util.d.K(imageRequest.ezX())) ? true : true, imageRequest.ezl()), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.g.c a2 = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.d.d.a(ajVar, new ap(imageRequest, ewx(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.ezj(), requestLevel), true, false, priority), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.imagepipeline.g.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.g.c cVar) {
        if (cVar == null) {
            if (imageRequest.etu() == null) {
                return this.pIj;
            }
            return new com.facebook.imagepipeline.g.b(this.pIj, imageRequest.etu());
        } else if (imageRequest.etu() == null) {
            return new com.facebook.imagepipeline.g.b(this.pIj, cVar);
        } else {
            return new com.facebook.imagepipeline.g.b(this.pIj, cVar, imageRequest.etu());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> Z(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.c.g.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean apply(com.facebook.cache.common.b bVar) {
                return bVar.I(uri);
            }
        };
    }

    public com.facebook.imagepipeline.b.f ewA() {
        return this.pIp;
    }
}
