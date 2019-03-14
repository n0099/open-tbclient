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
    private static final CancellationException jHb = new CancellationException("Prefetching is not enabled");
    private final com.facebook.imagepipeline.c.e jGw;
    private final com.facebook.imagepipeline.c.f jGx;
    private final m jHc;
    private final com.facebook.imagepipeline.g.b jHd;
    private final com.facebook.common.internal.i<Boolean> jHe;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jHf;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jHg;
    private final com.facebook.imagepipeline.c.e jHh;
    private final ar jHi;
    private final com.facebook.common.internal.i<Boolean> jHj;
    private AtomicLong jHk = new AtomicLong();

    public g(m mVar, Set<com.facebook.imagepipeline.g.b> set, com.facebook.common.internal.i<Boolean> iVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, ar arVar, com.facebook.common.internal.i<Boolean> iVar2) {
        this.jHc = mVar;
        this.jHd = new com.facebook.imagepipeline.g.a(set);
        this.jHe = iVar;
        this.jHf = tVar;
        this.jHg = tVar2;
        this.jHh = eVar;
        this.jGw = eVar2;
        this.jGx = fVar;
        this.jHi = arVar;
        this.jHj = iVar2;
    }

    private String cxk() {
        return String.valueOf(this.jHk.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        try {
            return a(this.jHc.e(imageRequest), imageRequest, requestLevel, obj);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        ai<Void> f;
        if (!this.jHe.get().booleanValue()) {
            return com.facebook.datasource.c.x(jHb);
        }
        try {
            if (this.jHj.get().booleanValue()) {
                f = this.jHc.c(imageRequest);
            } else {
                f = this.jHc.f(imageRequest);
            }
            return a(f, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public boolean F(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.jHf.b(H(uri));
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxl() {
        return this.jHf;
    }

    public com.facebook.datasource.b<Boolean> G(Uri uri) {
        return a(ImageRequest.M(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.jGx.c(imageRequest, null);
        final com.facebook.datasource.g cuy = com.facebook.datasource.g.cuy();
        this.jHh.j(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) {
                    return g.this.jGw.j(c);
                }
                return bolts.g.f(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                cuy.aJ(Boolean.valueOf((gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return cuy;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(ai<com.facebook.common.references.a<T>> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        boolean z = false;
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.c.a(aiVar, new an(imageRequest, cxk(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.czJ(), requestLevel), false, (!imageRequest.cAA() && imageRequest.cAw() == null && com.facebook.common.util.d.s(imageRequest.cAu())) ? true : true, imageRequest.czL()), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.datasource.b<Void> a(ai<Void> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.d.a(aiVar, new an(imageRequest, cxk(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.czJ(), requestLevel), true, false, priority), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.imagepipeline.g.b b(ImageRequest imageRequest) {
        return imageRequest.cAF() == null ? this.jHd : new com.facebook.imagepipeline.g.a(this.jHd, imageRequest.cAF());
    }

    private Predicate<com.facebook.cache.common.b> H(final Uri uri) {
        return new Predicate<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            /* renamed from: s */
            public boolean apply(com.facebook.cache.common.b bVar) {
                return bVar.r(uri);
            }
        };
    }

    public com.facebook.imagepipeline.c.f cxm() {
        return this.jGx;
    }
}
