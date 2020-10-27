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
/* loaded from: classes18.dex */
public class g {
    private static final CancellationException oLC = new CancellationException("Prefetching is not enabled");
    private final m oLD;
    private final com.facebook.imagepipeline.h.c oLE;
    private final com.facebook.common.internal.j<Boolean> oLF;
    private final p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oLG;
    private final p<com.facebook.cache.common.b, PooledByteBuffer> oLH;
    private final com.facebook.imagepipeline.c.e oLI;
    private final com.facebook.imagepipeline.c.e oLJ;
    private final com.facebook.imagepipeline.c.f oLK;
    private final at oLL;
    private final com.facebook.common.internal.j<Boolean> oLM;
    private AtomicLong oLN = new AtomicLong();
    private final com.facebook.common.internal.j<Boolean> oLO;

    public g(m mVar, Set<com.facebook.imagepipeline.h.c> set, com.facebook.common.internal.j<Boolean> jVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, at atVar, com.facebook.common.internal.j<Boolean> jVar2, com.facebook.common.internal.j<Boolean> jVar3) {
        this.oLD = mVar;
        this.oLE = new com.facebook.imagepipeline.h.b(set);
        this.oLF = jVar;
        this.oLG = pVar;
        this.oLH = pVar2;
        this.oLI = eVar;
        this.oLJ = eVar2;
        this.oLK = fVar;
        this.oLL = atVar;
        this.oLM = jVar2;
        this.oLO = jVar3;
    }

    private String ekr() {
        return String.valueOf(this.oLN.getAndIncrement());
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
            return a(this.oLD.d(imageRequest), imageRequest, requestLevel, obj, cVar);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public com.facebook.datasource.b<Void> f(ImageRequest imageRequest, Object obj) {
        aj<Void> e;
        if (!this.oLF.get().booleanValue()) {
            return com.facebook.datasource.c.z(oLC);
        }
        try {
            if (this.oLM.get().booleanValue()) {
                e = this.oLD.b(imageRequest);
            } else {
                e = this.oLD.e(imageRequest);
            }
            return a(e, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (Exception e2) {
            return com.facebook.datasource.c.z(e2);
        }
    }

    public com.facebook.datasource.b<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.oLF.get().booleanValue()) {
            return com.facebook.datasource.c.z(oLC);
        }
        try {
            return a(this.oLD.b(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    public boolean U(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.oLG.b(W(uri));
    }

    public p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> eks() {
        return this.oLG;
    }

    public com.facebook.datasource.b<Boolean> V(Uri uri) {
        return a(ImageRequest.ab(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.oLK.c(imageRequest, null);
        final com.facebook.datasource.g egY = com.facebook.datasource.g.egY();
        this.oLI.k(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: c */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.il() || !gVar.getResult().booleanValue()) {
                    return g.this.oLJ.k(c);
                }
                return bolts.g.l(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                egY.bf(Boolean.valueOf((gVar.isCancelled() || gVar.il() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return egY;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable com.facebook.imagepipeline.h.c cVar) {
        boolean z = false;
        com.facebook.imagepipeline.h.c a2 = a(imageRequest, cVar);
        try {
            return com.facebook.imagepipeline.e.c.a(ajVar, new ap(imageRequest, ekr(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.enh(), requestLevel), false, (imageRequest.eoc() || !com.facebook.common.util.d.K(imageRequest.enX())) ? true : true, imageRequest.enj()), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.datasource.b<Void> a(aj<Void> ajVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        com.facebook.imagepipeline.h.c a2 = a(imageRequest, null);
        try {
            return com.facebook.imagepipeline.e.d.a(ajVar, new ap(imageRequest, ekr(), a2, obj, ImageRequest.RequestLevel.getMax(imageRequest.enh(), requestLevel), true, false, priority), a2);
        } catch (Exception e) {
            return com.facebook.datasource.c.z(e);
        }
    }

    private com.facebook.imagepipeline.h.c a(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.h.c cVar) {
        if (cVar == null) {
            if (imageRequest.ehj() == null) {
                return this.oLE;
            }
            return new com.facebook.imagepipeline.h.b(this.oLE, imageRequest.ehj());
        } else if (imageRequest.ehj() == null) {
            return new com.facebook.imagepipeline.h.b(this.oLE, cVar);
        } else {
            return new com.facebook.imagepipeline.h.b(this.oLE, cVar, imageRequest.ehj());
        }
    }

    private com.facebook.common.internal.h<com.facebook.cache.common.b> W(final Uri uri) {
        return new com.facebook.common.internal.h<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.h
            /* renamed from: v */
            public boolean ba(com.facebook.cache.common.b bVar) {
                return bVar.I(uri);
            }
        };
    }

    public void pause() {
        this.oLL.enT();
    }

    public void resume() {
        this.oLL.enU();
    }

    public com.facebook.imagepipeline.c.f ekt() {
        return this.oLK;
    }
}
