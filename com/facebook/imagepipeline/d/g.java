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
    private static final CancellationException jHj = new CancellationException("Prefetching is not enabled");
    private final com.facebook.imagepipeline.c.e jGE;
    private final com.facebook.imagepipeline.c.f jGF;
    private final m jHk;
    private final com.facebook.imagepipeline.g.b jHl;
    private final com.facebook.common.internal.i<Boolean> jHm;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jHn;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> jHo;
    private final com.facebook.imagepipeline.c.e jHp;
    private final ar jHq;
    private final com.facebook.common.internal.i<Boolean> jHr;
    private AtomicLong jHs = new AtomicLong();

    public g(m mVar, Set<com.facebook.imagepipeline.g.b> set, com.facebook.common.internal.i<Boolean> iVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, ar arVar, com.facebook.common.internal.i<Boolean> iVar2) {
        this.jHk = mVar;
        this.jHl = new com.facebook.imagepipeline.g.a(set);
        this.jHm = iVar;
        this.jHn = tVar;
        this.jHo = tVar2;
        this.jHp = eVar;
        this.jGE = eVar2;
        this.jGF = fVar;
        this.jHq = arVar;
        this.jHr = iVar2;
    }

    private String cxh() {
        return String.valueOf(this.jHs.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        try {
            return a(this.jHk.e(imageRequest), imageRequest, requestLevel, obj);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        ai<Void> f;
        if (!this.jHm.get().booleanValue()) {
            return com.facebook.datasource.c.x(jHj);
        }
        try {
            if (this.jHr.get().booleanValue()) {
                f = this.jHk.c(imageRequest);
            } else {
                f = this.jHk.f(imageRequest);
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
        return this.jHn.b(H(uri));
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cxi() {
        return this.jHn;
    }

    public com.facebook.datasource.b<Boolean> G(Uri uri) {
        return a(ImageRequest.M(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.jGF.c(imageRequest, null);
        final com.facebook.datasource.g cuv = com.facebook.datasource.g.cuv();
        this.jHp.j(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) {
                    return g.this.jGE.j(c);
                }
                return bolts.g.f(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                cuv.aJ(Boolean.valueOf((gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return cuv;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(ai<com.facebook.common.references.a<T>> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        boolean z = false;
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.c.a(aiVar, new an(imageRequest, cxh(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.czG(), requestLevel), false, (!imageRequest.cAx() && imageRequest.cAt() == null && com.facebook.common.util.d.s(imageRequest.cAr())) ? true : true, imageRequest.czI()), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.datasource.b<Void> a(ai<Void> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.d.a(aiVar, new an(imageRequest, cxh(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.czG(), requestLevel), true, false, priority), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.x(e);
        }
    }

    private com.facebook.imagepipeline.g.b b(ImageRequest imageRequest) {
        return imageRequest.cAC() == null ? this.jHl : new com.facebook.imagepipeline.g.a(this.jHl, imageRequest.cAC());
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

    public com.facebook.imagepipeline.c.f cxj() {
        return this.jGF;
    }
}
