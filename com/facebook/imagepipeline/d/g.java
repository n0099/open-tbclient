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
/* loaded from: classes18.dex */
public class g {
    private static final CancellationException oUV = new CancellationException("Prefetching is not enabled");
    private final m oUW;
    private final com.facebook.imagepipeline.h.c oUX;
    private final com.facebook.common.internal.j<Boolean> oUY;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oUZ;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> oVa;
    private final com.facebook.imagepipeline.c.e oVb;
    private final com.facebook.imagepipeline.c.e oVc;
    private final com.facebook.imagepipeline.c.f oVd;
    private final at oVe;
    private final com.facebook.common.internal.j<Boolean> oVf;
    private AtomicLong oVg = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> oVh;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.oUW = mVar;
        this.oUX = new com.facebook.imagepipeline.h.b(set);
        this.oUY = jVar;
        this.oUZ = pVar;
        this.oVa = pVar2;
        this.oVb = eVar;
        this.oVc = eVar2;
        this.oVd = fVar;
        this.oVe = atVar;
        this.oVf = jVar2;
        this.oVh = jVar3;
    }

    private String eoi() {
        return String.valueOf(this.oVg.getAndIncrement());
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
            return a(this.oUW.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.oUY.get().booleanValue()) {
            return com.facebook.datasource.c.z(oUV);
        }
        try {
            if (this.oVf.get().booleanValue()) {
                e = this.oUW.b(imageRequest);
            } else {
                e = this.oUW.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.z(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.oUY.get().booleanValue()) {
            return com.facebook.datasource.c.z(oUV);
        }
        try {
            return a(this.oUW.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public boolean U(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.oUZ.b(W(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> eoj() {
        return this.oUZ;
    }

    public com.facebook.datasource.b<Boolean> V(Uri uri) {
        return a(ImageRequest.ab(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.oVd.c(imageRequest, null);
        final com.facebook.datasource.g ekN = com.facebook.datasource.g.ekN();
        this.oVb.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.il() || !gVar.getResult().booleanValue()) {
                    return g.this.oVc.k(c);
                }
                return bolts.g.l(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                ekN.bf(Boolean.valueOf((gVar.isCancelled() || gVar.il() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return ekN;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a2 = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, eoi(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.eqX(), requestLevel), false, (imageRequest.erS() || !com.facebook.common.util.d.K(imageRequest.erN())) ? true : true, imageRequest.eqZ()), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a2 = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, eoi(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.eqX(), requestLevel), true, false, priority), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.ekY() == null) {
                return this.oUX;
            }
            return new com.facebook.imagepipeline.h.b(this.oUX, imageRequest.ekY());
        } else if (imageRequest.ekY() == null) {
            return new com.facebook.imagepipeline.h.b(this.oUX, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.oUX, cVar, imageRequest.ekY());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> W(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean ba(com.facebook.cache.common.b bVar) {
                return bVar.I(uri);
            }
        };
    }

    public void pause() {
        this.oVe.erJ();
    }

    public void resume() {
        this.oVe.erK();
    }

    public com.facebook.imagepipeline.c.f eok() {
        return this.oVd;
    }
}
