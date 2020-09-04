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
/* loaded from: classes8.dex */
public class g {
    private static final CancellationException nuU = new CancellationException("Prefetching is not enabled");
    private final m nuV;
    private final com.facebook.imagepipeline.h.c nuW;
    private final com.facebook.common.internal.j<Boolean> nuX;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nuY;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> nuZ;
    private final com.facebook.imagepipeline.c.e nva;
    private final com.facebook.imagepipeline.c.e nvb;
    private final com.facebook.imagepipeline.c.f nvc;
    private final at nvd;
    private final com.facebook.common.internal.j<Boolean> nve;
    private AtomicLong nvf = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> nvg;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.nuV = mVar;
        this.nuW = new com.facebook.imagepipeline.h.b(set);
        this.nuX = jVar;
        this.nuY = pVar;
        this.nuZ = pVar2;
        this.nva = eVar;
        this.nvb = eVar2;
        this.nvc = fVar;
        this.nvd = atVar;
        this.nve = jVar2;
        this.nvg = jVar3;
    }

    private String dSK() {
        return String.valueOf(this.nvf.getAndIncrement());
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
            return a(this.nuV.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.nuX.get().booleanValue()) {
            return com.facebook.datasource.c.z(nuU);
        }
        try {
            if (this.nve.get().booleanValue()) {
                e = this.nuV.b(imageRequest);
            } else {
                e = this.nuV.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.z(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.nuX.get().booleanValue()) {
            return com.facebook.datasource.c.z(nuU);
        }
        try {
            return a(this.nuV.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public boolean S(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.nuY.b(U(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dSL() {
        return this.nuY;
    }

    public com.facebook.datasource.b<Boolean> T(Uri uri) {
        return a(ImageRequest.Z(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.nvc.c(imageRequest, null);
        final com.facebook.datasource.g dPr = com.facebook.datasource.g.dPr();
        this.nva.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.ik() || !gVar.getResult().booleanValue()) {
                    return g.this.nvb.k(c);
                }
                return bolts.g.l(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dPr.aW(Boolean.valueOf((gVar.isCancelled() || gVar.ik() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dPr;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dSK(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dVz(), requestLevel), false, (imageRequest.dWu() || !com.facebook.common.util.d.I(imageRequest.dWp())) ? true : true, imageRequest.dVB()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dSK(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dVz(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dPC() == null) {
                return this.nuW;
            }
            return new com.facebook.imagepipeline.h.b(this.nuW, imageRequest.dPC());
        } else if (imageRequest.dPC() == null) {
            return new com.facebook.imagepipeline.h.b(this.nuW, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.nuW, cVar, imageRequest.dPC());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> U(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aR(com.facebook.cache.common.b bVar) {
                return bVar.G(uri);
            }
        };
    }

    public void pause() {
        this.nvd.dWl();
    }

    public void resume() {
        this.nvd.dWm();
    }

    public com.facebook.imagepipeline.c.f dSM() {
        return this.nvc;
    }
}
