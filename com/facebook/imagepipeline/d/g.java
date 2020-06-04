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
    private static final CancellationException mwB = new CancellationException("Prefetching is not enabled");
    private final m mwC;
    private final com.facebook.imagepipeline.h.c mwD;
    private final com.facebook.common.internal.j<Boolean> mwE;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mwF;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> mwG;
    private final com.facebook.imagepipeline.c.e mwH;
    private final com.facebook.imagepipeline.c.e mwI;
    private final com.facebook.imagepipeline.c.f mwJ;
    private final at mwK;
    private final com.facebook.common.internal.j<Boolean> mwL;
    private AtomicLong mwM = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> mwN;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.mwC = mVar;
        this.mwD = new com.facebook.imagepipeline.h.b(set);
        this.mwE = jVar;
        this.mwF = pVar;
        this.mwG = pVar2;
        this.mwH = eVar;
        this.mwI = eVar2;
        this.mwJ = fVar;
        this.mwK = atVar;
        this.mwL = jVar2;
        this.mwN = jVar3;
    }

    private String dyJ() {
        return String.valueOf(this.mwM.getAndIncrement());
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
            return a(this.mwC.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.mwE.get().booleanValue()) {
            return com.facebook.datasource.c.B(mwB);
        }
        try {
            if (this.mwL.get().booleanValue()) {
                e = this.mwC.b(imageRequest);
            } else {
                e = this.mwC.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.B(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.mwE.get().booleanValue()) {
            return com.facebook.datasource.c.B(mwB);
        }
        try {
            return a(this.mwC.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    public boolean S(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.mwF.b(U(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> dyK() {
        return this.mwF;
    }

    public com.facebook.datasource.b<Boolean> T(Uri uri) {
        return a(ImageRequest.Z(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.mwJ.c(imageRequest, null);
        final com.facebook.datasource.g dvo = com.facebook.datasource.g.dvo();
        this.mwH.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.gu() || !gVar.getResult().booleanValue()) {
                    return g.this.mwI.k(c);
                }
                return bolts.g.k(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                dvo.aT(Boolean.valueOf((gVar.isCancelled() || gVar.gu() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return dvo;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, dyJ(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dBy(), requestLevel), false, (imageRequest.dCt() || !com.facebook.common.util.d.I(imageRequest.dCo())) ? true : true, imageRequest.dBA()), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, dyJ(), a, obj, ImageRequest.RequestLevel.getMax(imageRequest.dBy(), requestLevel), true, false, priority), a);
        } catch (Exception e) {
            return com.facebook.datasource.c.B(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.dvz() == null) {
                return this.mwD;
            }
            return new com.facebook.imagepipeline.h.b(this.mwD, imageRequest.dvz());
        } else if (imageRequest.dvz() == null) {
            return new com.facebook.imagepipeline.h.b(this.mwD, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.mwD, cVar, imageRequest.dvz());
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
        this.mwK.dCk();
    }

    public void resume() {
        this.mwK.dCl();
    }

    public com.facebook.imagepipeline.c.f dyL() {
        return this.mwJ;
    }
}
