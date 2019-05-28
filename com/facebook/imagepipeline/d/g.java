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
    private static final CancellationException jZk = new CancellationException("Prefetching is not enabled");
    private final com.facebook.imagepipeline.c.e jYF;
    private final com.facebook.imagepipeline.c.f jYG;
    private final m jZl;
    private final com.facebook.imagepipeline.g.b jZm;
    private final com.facebook.common.internal.i<Boolean> jZn;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jZo;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jZp;
    private final com.facebook.imagepipeline.c.e jZq;
    private final ar jZr;
    private final com.facebook.common.internal.i<Boolean> jZs;
    private AtomicLong jZt = new AtomicLong();

    public g(m mVar, Set<com.facebook.imagepipeline.g.b> set, com.facebook.common.internal.i<Boolean> iVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, ar arVar, com.facebook.common.internal.i<Boolean> iVar2) {
        this.jZl = mVar;
        this.jZm = new com.facebook.imagepipeline.g.a(set);
        this.jZn = iVar;
        this.jZo = tVar;
        this.jZp = tVar2;
        this.jZq = eVar;
        this.jYF = eVar2;
        this.jYG = fVar;
        this.jZr = arVar;
        this.jZs = iVar2;
    }

    private String cFb() {
        return String.valueOf(this.jZt.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        try {
            return a(this.jZl.e(imageRequest), imageRequest, requestLevel, obj);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        ai<Void> f;
        if (!this.jZn.get().booleanValue()) {
            return com.facebook.datasource.c.v(jZk);
        }
        try {
            if (this.jZs.get().booleanValue()) {
                f = this.jZl.c(imageRequest);
            } else {
                f = this.jZl.f(imageRequest);
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
        return this.jZo.b(N(uri));
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cFc() {
        return this.jZo;
    }

    public com.facebook.datasource.b<Boolean> M(Uri uri) {
        return a(ImageRequest.S(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.jYG.c(imageRequest, null);
        final com.facebook.datasource.g cCp = com.facebook.datasource.g.cCp();
        this.jZq.j(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) {
                    return g.this.jYF.j(c);
                }
                return bolts.g.g(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                cCp.aH(Boolean.valueOf((gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return cCp;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(ai<com.facebook.common.references.a<T>> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        boolean z = false;
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.c.a(aiVar, new an(imageRequest, cFb(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.cHA(), requestLevel), false, (!imageRequest.cIr() && imageRequest.cIn() == null && com.facebook.common.util.d.y(imageRequest.cIl())) ? true : true, imageRequest.cHC()), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    private com.facebook.datasource.b<Void> a(ai<Void> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.d.a(aiVar, new an(imageRequest, cFb(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.cHA(), requestLevel), true, false, priority), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    private com.facebook.imagepipeline.g.b b(ImageRequest imageRequest) {
        return imageRequest.cIw() == null ? this.jZm : new com.facebook.imagepipeline.g.a(this.jZm, imageRequest.cIw());
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

    public com.facebook.imagepipeline.c.f cFd() {
        return this.jYG;
    }
}
