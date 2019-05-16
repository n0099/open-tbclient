package com.facebook.imagepipeline.d;

import android.net.Uri;
import com.android.internal.util.Predicate;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.t;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.ai;
import com.facebook.imagepipeline.producers.an;
import com.facebook.imagepipeline.producers.ar;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class g {
    private static final CancellationException jZj = new CancellationException("Prefetching is not enabled");
    private final com.facebook.imagepipeline.c.e jYE;
    private final com.facebook.imagepipeline.c.f jYF;
    private final m jZk;
    private final com.facebook.imagepipeline.g.b jZl;
    private final com.facebook.common.internal.i<Boolean> jZm;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jZn;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jZo;
    private final com.facebook.imagepipeline.c.e jZp;
    private final ar jZq;
    private final com.facebook.common.internal.i<Boolean> jZr;
    private AtomicLong jZs = new AtomicLong();

    public g(m mVar, Set<com.facebook.imagepipeline.g.b> set, com.facebook.common.internal.i<Boolean> iVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, ar arVar, com.facebook.common.internal.i<Boolean> iVar2) {
        this.jZk = mVar;
        this.jZl = new com.facebook.imagepipeline.g.a(set);
        this.jZm = iVar;
        this.jZn = tVar;
        this.jZo = tVar2;
        this.jZp = eVar;
        this.jYE = eVar2;
        this.jYF = fVar;
        this.jZq = arVar;
        this.jZr = iVar2;
    }

    private String cEZ() {
        return String.valueOf(this.jZs.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        try {
            return a(this.jZk.e(imageRequest), imageRequest, requestLevel, obj);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        ai<Void> f;
        if (!this.jZm.get().booleanValue()) {
            return com.facebook.datasource.c.v(jZj);
        }
        try {
            if (this.jZr.get().booleanValue()) {
                f = this.jZk.c(imageRequest);
            } else {
                f = this.jZk.f(imageRequest);
            }
            return a(f, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    public boolean L(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.jZn.b(N(uri));
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cFa() {
        return this.jZn;
    }

    public com.facebook.datasource.b<Boolean> M(Uri uri) {
        return a(ImageRequest.S(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.jYF.c(imageRequest, null);
        final com.facebook.datasource.g cCn = com.facebook.datasource.g.cCn();
        this.jZp.j(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) {
                    return g.this.jYE.j(c);
                }
                return bolts.g.g(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                cCn.aH(Boolean.valueOf((gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return cCn;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(ai<com.facebook.common.references.a<T>> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        boolean z = false;
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.c.a(aiVar, new an(imageRequest, cEZ(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.cHy(), requestLevel), false, (!imageRequest.cIp() && imageRequest.cIl() == null && com.facebook.common.util.d.y(imageRequest.cIj())) ? true : true, imageRequest.cHA()), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    private com.facebook.datasource.b<Void> a(ai<Void> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.d.a(aiVar, new an(imageRequest, cEZ(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.cHy(), requestLevel), true, false, priority), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    private com.facebook.imagepipeline.g.b b(ImageRequest imageRequest) {
        return imageRequest.cIu() == null ? this.jZl : new com.facebook.imagepipeline.g.a(this.jZl, imageRequest.cIu());
    }

    private Predicate<com.facebook.cache.common.b> N(final Uri uri) {
        return new Predicate<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            /* renamed from: s */
            public boolean apply(com.facebook.cache.common.b bVar) {
                return bVar.x(uri);
            }
        };
    }

    public com.facebook.imagepipeline.c.f cFb() {
        return this.jYF;
    }
}
