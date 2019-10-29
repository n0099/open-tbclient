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
    private static final CancellationException kij = new CancellationException("Prefetching is not enabled");
    private final com.facebook.imagepipeline.c.e khD;
    private final com.facebook.imagepipeline.c.f khE;
    private final m kik;
    private final com.facebook.imagepipeline.g.b kil;
    private final com.facebook.common.internal.i<Boolean> kim;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kin;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> kio;
    private final com.facebook.imagepipeline.c.e kip;
    private final ar kiq;
    private final com.facebook.common.internal.i<Boolean> kir;
    private AtomicLong kis = new AtomicLong();

    public g(m mVar, Set<com.facebook.imagepipeline.g.b> set, com.facebook.common.internal.i<Boolean> iVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, ar arVar, com.facebook.common.internal.i<Boolean> iVar2) {
        this.kik = mVar;
        this.kil = new com.facebook.imagepipeline.g.a(set);
        this.kim = iVar;
        this.kin = tVar;
        this.kio = tVar2;
        this.kip = eVar;
        this.khD = eVar2;
        this.khE = fVar;
        this.kiq = arVar;
        this.kir = iVar2;
    }

    private String cGj() {
        return String.valueOf(this.kis.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        try {
            return a(this.kik.e(imageRequest), imageRequest, requestLevel, obj);
        } catch (Exception e) {
            return com.facebook.datasource.c.u(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        ai<Void> f;
        if (!this.kim.get().booleanValue()) {
            return com.facebook.datasource.c.u(kij);
        }
        try {
            if (this.kir.get().booleanValue()) {
                f = this.kik.c(imageRequest);
            } else {
                f = this.kik.f(imageRequest);
            }
            return a(f, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e) {
            return com.facebook.datasource.c.u(e);
        }
    }

    public boolean I(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.kin.b(K(uri));
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> cGk() {
        return this.kin;
    }

    public com.facebook.datasource.b<Boolean> J(Uri uri) {
        return a(ImageRequest.P(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.khE.c(imageRequest, null);
        final com.facebook.datasource.g cDw = com.facebook.datasource.g.cDw();
        this.kip.j(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.aL() || !gVar.getResult().booleanValue()) {
                    return g.this.khD.j(c);
                }
                return bolts.g.g(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                cDw.aC((com.facebook.datasource.g) Boolean.valueOf((gVar.isCancelled() || gVar.aL() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return cDw;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(ai<com.facebook.common.references.a<T>> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        boolean z = false;
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.c.a(aiVar, new an(imageRequest, cGj(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.cIJ(), requestLevel), false, (!imageRequest.cJA() && imageRequest.cJw() == null && com.facebook.common.util.d.v(imageRequest.cJu())) ? true : true, imageRequest.cIL()), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.u(e);
        }
    }

    private com.facebook.datasource.b<Void> a(ai<Void> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.d.a(aiVar, new an(imageRequest, cGj(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.cIJ(), requestLevel), true, false, priority), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.u(e);
        }
    }

    private com.facebook.imagepipeline.g.b b(ImageRequest imageRequest) {
        return imageRequest.cJF() == null ? this.kil : new com.facebook.imagepipeline.g.a(this.kil, imageRequest.cJF());
    }

    private Predicate<com.facebook.cache.common.b> K(final Uri uri) {
        return new Predicate<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            /* renamed from: s */
            public boolean apply(com.facebook.cache.common.b bVar) {
                return bVar.u(uri);
            }
        };
    }

    public com.facebook.imagepipeline.c.f cGl() {
        return this.khE;
    }
}
