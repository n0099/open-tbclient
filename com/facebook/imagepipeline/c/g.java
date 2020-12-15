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
/* loaded from: classes15.dex */
public class g {
    private static final CancellationException plp = new CancellationException("Prefetching is not enabled");
    private AtomicLong plA = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> plB;
    private final m plq;
    private final com.facebook.imagepipeline.g.c plr;
    private final com.facebook.common.internal.j<Boolean> pls;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> plt;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> plu;
    private final com.facebook.imagepipeline.b.e plv;
    private final com.facebook.imagepipeline.b.e plw;
    private final com.facebook.imagepipeline.b.f plx;
    private final at ply;
    private final com.facebook.common.internal.j<Boolean> plz;

    public g(m mVar, Set<com.facebook.imagepipeline.g.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.plq = mVar;
        this.plr = new com.facebook.imagepipeline.g.b(set);
        this.pls = jVar;
        this.plt = pVar;
        this.plu = pVar2;
        this.plv = eVar;
        this.plw = eVar2;
        this.plx = fVar;
        this.ply = atVar;
        this.plz = jVar2;
        this.plB = jVar3;
    }

    private String etM() {
        return String.valueOf(this.plA.getAndIncrement());
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
            return a(this.plq.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.pls.get().booleanValue()) {
            return com.facebook.datasource.c.z(plp);
        }
        try {
            if (this.plz.get().booleanValue()) {
                e = this.plq.b(imageRequest);
            } else {
                e = this.plq.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.z(e2);
        }
    }

    public boolean W(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.plt.b(Y(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> etN() {
        return this.plt;
    }

    public com.facebook.datasource.b<Boolean> X(Uri uri) {
        return a(ImageRequest.ad(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.plx.c(imageRequest, null);
        final com.facebook.datasource.g eqB = com.facebook.datasource.g.eqB();
        this.plv.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.c.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.il() || !gVar.getResult().booleanValue()) {
                    return g.this.plw.k(c);
                }
                return bolts.g.l(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.c.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                eqB.bg(Boolean.valueOf((gVar.isCancelled() || gVar.il() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return eqB;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.g.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.g.c a2 = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.d.c.a(ajVar, new ap(imageRequest, etM(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.ewy(), requestLevel), false, (imageRequest.exr() || !com.facebook.common.util.d.M(imageRequest.exm())) ? true : true, imageRequest.ewA()), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.g.c a2 = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.d.d.a(ajVar, new ap(imageRequest, etM(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.ewy(), requestLevel), true, false, priority), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.imagepipeline.g.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.g.c cVar) {
        if (cVar == null) {
            if (imageRequest.eqM() == null) {
                return this.plr;
            }
            return new com.facebook.imagepipeline.g.b(this.plr, imageRequest.eqM());
        } else if (imageRequest.eqM() == null) {
            return new com.facebook.imagepipeline.g.b(this.plr, cVar);
        } else {
            return new com.facebook.imagepipeline.g.b(this.plr, cVar, imageRequest.eqM());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> Y(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.c.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean bb(com.facebook.cache.common.b bVar) {
                return bVar.K(uri);
            }
        };
    }

    public com.facebook.imagepipeline.b.f etO() {
        return this.plx;
    }
}
