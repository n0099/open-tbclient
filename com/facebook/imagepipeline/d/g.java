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
    private static final CancellationException mSF = new CancellationException("Prefetching is not enabled");
    private final m mSG;
    private final com.facebook.imagepipeline.h.c mSH;
    private final com.facebook.common.internal.j<Boolean> mSI;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSJ;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mSK;
    private final com.facebook.imagepipeline.c.e mSL;
    private final com.facebook.imagepipeline.c.e mSM;
    private final com.facebook.imagepipeline.c.f mSN;
    private final at mSO;
    private final com.facebook.common.internal.j<Boolean> mSQ;
    private AtomicLong mSR = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> mSS;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.mSG = mVar;
        this.mSH = new com.facebook.imagepipeline.h.b(set);
        this.mSI = jVar;
        this.mSJ = pVar;
        this.mSK = pVar2;
        this.mSL = eVar;
        this.mSM = eVar2;
        this.mSN = fVar;
        this.mSO = atVar;
        this.mSQ = jVar2;
        this.mSS = jVar3;
    }

    private String dDp() {
        return String.valueOf(this.mSR.getAndIncrement());
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
            return a(this.mSG.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.mSI.get().booleanValue()) {
            return com.facebook.datasource.c.B(mSF);
        }
        try {
            if (this.mSQ.get().booleanValue()) {
                e = this.mSG.b(imageRequest);
            } else {
                e = this.mSG.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.B(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.mSI.get().booleanValue()) {
            return com.facebook.datasource.c.B(mSF);
        }
        try {
            return a(this.mSG.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    public boolean T(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.mSJ.b(V(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dDq() {
        return this.mSJ;
    }

    public com.facebook.datasource.b<Boolean> U(Uri uri) {
        return a(ImageRequest.aa(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.mSN.c(imageRequest, null);
        final com.facebook.datasource.g dzV = com.facebook.datasource.g.dzV();
        this.mSL.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.gK() || !gVar.getResult().booleanValue()) {
                    return g.this.mSM.k(c);
                }
                return bolts.g.k(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dzV.aU(Boolean.valueOf((gVar.isCancelled() || gVar.gK() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dzV;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dDp(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dGe(), requestLevel), false, (imageRequest.dGZ() || !com.facebook.common.util.d.J(imageRequest.dGU())) ? true : true, imageRequest.dGg()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dDp(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dGe(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dAg() == null) {
                return this.mSH;
            }
            return new com.facebook.imagepipeline.h.b(this.mSH, imageRequest.dAg());
        } else if (imageRequest.dAg() == null) {
            return new com.facebook.imagepipeline.h.b(this.mSH, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.mSH, cVar, imageRequest.dAg());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> V(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean aP(com.facebook.cache.common.b bVar) {
                return bVar.H(uri);
            }
        };
    }

    public void pause() {
        this.mSO.dGQ();
    }

    public void resume() {
        this.mSO.dGR();
    }

    public com.facebook.imagepipeline.c.f dDr() {
        return this.mSN;
    }
}
