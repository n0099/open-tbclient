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
/* loaded from: classes12.dex */
public class g {
    private static final CancellationException mvr = new CancellationException("Prefetching is not enabled");
    private final at mvA;
    private final com.facebook.common.internal.j<Boolean> mvB;
    private AtomicLong mvC = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> mvD;
    private final m mvs;
    private final com.facebook.imagepipeline.h.c mvt;
    private final com.facebook.common.internal.j<Boolean> mvu;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mvv;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mvw;
    private final com.facebook.imagepipeline.c.e mvx;
    private final com.facebook.imagepipeline.c.e mvy;
    private final com.facebook.imagepipeline.c.f mvz;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.mvs = mVar;
        this.mvt = new com.facebook.imagepipeline.h.b(set);
        this.mvu = jVar;
        this.mvv = pVar;
        this.mvw = pVar2;
        this.mvx = eVar;
        this.mvy = eVar2;
        this.mvz = fVar;
        this.mvA = atVar;
        this.mvB = jVar2;
        this.mvD = jVar3;
    }

    private String dyv() {
        return String.valueOf(this.mvC.getAndIncrement());
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
            return a(this.mvs.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.mvu.get().booleanValue()) {
            return com.facebook.datasource.c.B(mvr);
        }
        try {
            if (this.mvB.get().booleanValue()) {
                e = this.mvs.b(imageRequest);
            } else {
                e = this.mvs.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.B(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.mvu.get().booleanValue()) {
            return com.facebook.datasource.c.B(mvr);
        }
        try {
            return a(this.mvs.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    public boolean S(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.mvv.b(U(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dyw() {
        return this.mvv;
    }

    public com.facebook.datasource.b<Boolean> T(Uri uri) {
        return a(ImageRequest.Z(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.mvz.c(imageRequest, null);
        final com.facebook.datasource.g dva = com.facebook.datasource.g.dva();
        this.mvx.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.gu() || !gVar.getResult().booleanValue()) {
                    return g.this.mvy.k(c);
                }
                return bolts.g.k(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dva.aT(Boolean.valueOf((gVar.isCancelled() || gVar.gu() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dva;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dyv(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dBk(), requestLevel), false, (imageRequest.dCf() || !com.facebook.common.util.d.I(imageRequest.dCa())) ? true : true, imageRequest.dBm()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dyv(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dBk(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dvl() == null) {
                return this.mvt;
            }
            return new com.facebook.imagepipeline.h.b(this.mvt, imageRequest.dvl());
        } else if (imageRequest.dvl() == null) {
            return new com.facebook.imagepipeline.h.b(this.mvt, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.mvt, cVar, imageRequest.dvl());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> U(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aO(com.facebook.cache.common.b bVar) {
                return bVar.G(uri);
            }
        };
    }

    public void pause() {
        this.mvA.dBW();
    }

    public void resume() {
        this.mvA.dBX();
    }

    public com.facebook.imagepipeline.c.f dyx() {
        return this.mvz;
    }
}
