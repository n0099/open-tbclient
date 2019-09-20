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
    private static final CancellationException kjX = new CancellationException("Prefetching is not enabled");
    private final m kjY;
    private final com.facebook.imagepipeline.g.b kjZ;
    private final com.facebook.imagepipeline.c.e kjs;
    private final com.facebook.imagepipeline.c.f kjt;
    private final com.facebook.common.internal.i<Boolean> kka;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kkb;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> kkc;
    private final com.facebook.imagepipeline.c.e kkd;
    private final ar kke;
    private final com.facebook.common.internal.i<Boolean> kkf;
    private AtomicLong kkg = new AtomicLong();

    public g(m mVar, Set<com.facebook.imagepipeline.g.b> set, com.facebook.common.internal.i<Boolean> iVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, ar arVar, com.facebook.common.internal.i<Boolean> iVar2) {
        this.kjY = mVar;
        this.kjZ = new com.facebook.imagepipeline.g.a(set);
        this.kka = iVar;
        this.kkb = tVar;
        this.kkc = tVar2;
        this.kkd = eVar;
        this.kjs = eVar2;
        this.kjt = fVar;
        this.kke = arVar;
        this.kkf = iVar2;
    }

    private String cJm() {
        return String.valueOf(this.kkg.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        try {
            return a(this.kjY.e(imageRequest), imageRequest, requestLevel, obj);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        ai<Void> f;
        if (!this.kka.get().booleanValue()) {
            return com.facebook.datasource.c.v(kjX);
        }
        try {
            if (this.kkf.get().booleanValue()) {
                f = this.kjY.c(imageRequest);
            } else {
                f = this.kjY.f(imageRequest);
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
        return this.kkb.b(N(uri));
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cJn() {
        return this.kkb;
    }

    public com.facebook.datasource.b<Boolean> M(Uri uri) {
        return a(ImageRequest.S(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.kjt.c(imageRequest, null);
        final com.facebook.datasource.g cGy = com.facebook.datasource.g.cGy();
        this.kkd.j(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.bi() || !gVar.getResult().booleanValue()) {
                    return g.this.kjs.j(c);
                }
                return bolts.g.g(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                cGy.aH(Boolean.valueOf((gVar.isCancelled() || gVar.bi() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return cGy;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(ai<com.facebook.common.references.a<T>> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        boolean z = false;
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.c.a(aiVar, new an(imageRequest, cJm(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.cLM(), requestLevel), false, (!imageRequest.cMD() && imageRequest.cMz() == null && com.facebook.common.util.d.y(imageRequest.cMx())) ? true : true, imageRequest.cLO()), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    private com.facebook.datasource.b<Void> a(ai<Void> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.d.a(aiVar, new an(imageRequest, cJm(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.cLM(), requestLevel), true, false, priority), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    private com.facebook.imagepipeline.g.b b(ImageRequest imageRequest) {
        return imageRequest.cMI() == null ? this.kjZ : new com.facebook.imagepipeline.g.a(this.kjZ, imageRequest.cMI());
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

    public com.facebook.imagepipeline.c.f cJo() {
        return this.kjt;
    }
}
