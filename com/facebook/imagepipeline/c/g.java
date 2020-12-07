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
    private static final CancellationException pln = new CancellationException("Prefetching is not enabled");
    private final m plo;
    private final com.facebook.imagepipeline.g.c plp;
    private final com.facebook.common.internal.j<Boolean> plq;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> plr;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> pls;
    private final com.facebook.imagepipeline.b.e plt;
    private final com.facebook.imagepipeline.b.e plu;
    private final com.facebook.imagepipeline.b.f plv;
    private final at plw;
    private final com.facebook.common.internal.j<Boolean> plx;
    private AtomicLong ply = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> plz;

    public g(m mVar, Set<com.facebook.imagepipeline.g.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.plo = mVar;
        this.plp = new com.facebook.imagepipeline.g.b(set);
        this.plq = jVar;
        this.plr = pVar;
        this.pls = pVar2;
        this.plt = eVar;
        this.plu = eVar2;
        this.plv = fVar;
        this.plw = atVar;
        this.plx = jVar2;
        this.plz = jVar3;
    }

    private String etL() {
        return String.valueOf(this.ply.getAndIncrement());
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
            return a(this.plo.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.plq.get().booleanValue()) {
            return com.facebook.datasource.c.z(pln);
        }
        try {
            if (this.plx.get().booleanValue()) {
                e = this.plo.b(imageRequest);
            } else {
                e = this.plo.e(imageRequest);
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
        return this.plr.b(Y(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> etM() {
        return this.plr;
    }

    public com.facebook.datasource.b<Boolean> X(Uri uri) {
        return a(ImageRequest.ad(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.plv.c(imageRequest, null);
        final com.facebook.datasource.g eqA = com.facebook.datasource.g.eqA();
        this.plt.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.c.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.il() || !gVar.getResult().booleanValue()) {
                    return g.this.plu.k(c);
                }
                return bolts.g.l(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.c.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                eqA.bg(Boolean.valueOf((gVar.isCancelled() || gVar.il() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return eqA;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.g.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.g.c a2 = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.d.c.a(ajVar, new ap(imageRequest, etL(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.ewx(), requestLevel), false, (imageRequest.exq() || !com.facebook.common.util.d.M(imageRequest.exl())) ? true : true, imageRequest.ewz()), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.g.c a2 = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.d.d.a(ajVar, new ap(imageRequest, etL(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.ewx(), requestLevel), true, false, priority), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.imagepipeline.g.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.g.c cVar) {
        if (cVar == null) {
            if (imageRequest.eqL() == null) {
                return this.plp;
            }
            return new com.facebook.imagepipeline.g.b(this.plp, imageRequest.eqL());
        } else if (imageRequest.eqL() == null) {
            return new com.facebook.imagepipeline.g.b(this.plp, cVar);
        } else {
            return new com.facebook.imagepipeline.g.b(this.plp, cVar, imageRequest.eqL());
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

    public com.facebook.imagepipeline.b.f etN() {
        return this.plv;
    }
}
