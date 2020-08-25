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
    private static final CancellationException nuC = new CancellationException("Prefetching is not enabled");
    private final m nuD;
    private final com.facebook.imagepipeline.h.c nuE;
    private final com.facebook.common.internal.j<Boolean> nuF;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nuG;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> nuH;
    private final com.facebook.imagepipeline.c.e nuI;
    private final com.facebook.imagepipeline.c.e nuJ;
    private final com.facebook.imagepipeline.c.f nuK;
    private final at nuL;
    private final com.facebook.common.internal.j<Boolean> nuM;
    private AtomicLong nuN = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> nuO;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.nuD = mVar;
        this.nuE = new com.facebook.imagepipeline.h.b(set);
        this.nuF = jVar;
        this.nuG = pVar;
        this.nuH = pVar2;
        this.nuI = eVar;
        this.nuJ = eVar2;
        this.nuK = fVar;
        this.nuL = atVar;
        this.nuM = jVar2;
        this.nuO = jVar3;
    }

    private String dSB() {
        return String.valueOf(this.nuN.getAndIncrement());
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
            return a(this.nuD.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.nuF.get().booleanValue()) {
            return com.facebook.datasource.c.z(nuC);
        }
        try {
            if (this.nuM.get().booleanValue()) {
                e = this.nuD.b(imageRequest);
            } else {
                e = this.nuD.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.z(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.nuF.get().booleanValue()) {
            return com.facebook.datasource.c.z(nuC);
        }
        try {
            return a(this.nuD.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public boolean S(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.nuG.b(U(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dSC() {
        return this.nuG;
    }

    public com.facebook.datasource.b<Boolean> T(Uri uri) {
        return a(ImageRequest.Z(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.nuK.c(imageRequest, null);
        final com.facebook.datasource.g dPi = com.facebook.datasource.g.dPi();
        this.nuI.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.ik() || !gVar.getResult().booleanValue()) {
                    return g.this.nuJ.k(c);
                }
                return bolts.g.l(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dPi.aW(Boolean.valueOf((gVar.isCancelled() || gVar.ik() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dPi;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dSB(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dVq(), requestLevel), false, (imageRequest.dWl() || !com.facebook.common.util.d.I(imageRequest.dWg())) ? true : true, imageRequest.dVs()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dSB(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dVq(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dPt() == null) {
                return this.nuE;
            }
            return new com.facebook.imagepipeline.h.b(this.nuE, imageRequest.dPt());
        } else if (imageRequest.dPt() == null) {
            return new com.facebook.imagepipeline.h.b(this.nuE, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.nuE, cVar, imageRequest.dPt());
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
        this.nuL.dWc();
    }

    public void resume() {
        this.nuL.dWd();
    }

    public com.facebook.imagepipeline.c.f dSD() {
        return this.nuK;
    }
}
