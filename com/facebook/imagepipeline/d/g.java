package com.facebook.imagepipeline.d;

import android.net.Uri;
import com.android.internal.util.Predicate;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.t;
import com.facebook.imagepipeline.producers.ai;
import com.facebook.imagepipeline.producers.an;
import com.facebook.imagepipeline.producers.aq;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class g {
    private static final CancellationException ifG = new CancellationException("Prefetching is not enabled");
    private final m ifH;
    private final com.facebook.imagepipeline.g.b ifI;
    private final com.facebook.common.internal.i<Boolean> ifJ;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ifK;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> ifL;
    private final com.facebook.imagepipeline.c.e ifM;
    private final aq ifN;
    private final com.facebook.common.internal.i<Boolean> ifO;
    private AtomicLong ifP = new AtomicLong();
    private final com.facebook.imagepipeline.c.e ifb;
    private final com.facebook.imagepipeline.c.f ifc;

    public g(m mVar, Set<com.facebook.imagepipeline.g.b> set, com.facebook.common.internal.i<Boolean> iVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aq aqVar, com.facebook.common.internal.i<Boolean> iVar2) {
        this.ifH = mVar;
        this.ifI = new com.facebook.imagepipeline.g.a(set);
        this.ifJ = iVar;
        this.ifK = tVar;
        this.ifL = tVar2;
        this.ifM = eVar;
        this.ifb = eVar2;
        this.ifc = fVar;
        this.ifN = aqVar;
        this.ifO = iVar2;
    }

    private String bUs() {
        return String.valueOf(this.ifP.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        try {
            return a(this.ifH.c(imageRequest), imageRequest, requestLevel, obj);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    public boolean w(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.ifK.b(y(uri));
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bUt() {
        return this.ifK;
    }

    public com.facebook.datasource.b<Boolean> x(Uri uri) {
        return a(ImageRequest.D(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.ifc.c(imageRequest, null);
        final com.facebook.datasource.g bRK = com.facebook.datasource.g.bRK();
        this.ifM.j(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) {
                    return g.this.ifb.j(c);
                }
                return bolts.g.f(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                bRK.as(Boolean.valueOf((gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return bRK;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(ai<com.facebook.common.references.a<T>> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        boolean z = false;
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.c.a(aiVar, new an(imageRequest, bUs(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.bWN(), requestLevel), false, (!imageRequest.bXE() && imageRequest.bXA() == null && com.facebook.common.util.d.j(imageRequest.bXy())) ? true : true, imageRequest.bWP()), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    private com.facebook.imagepipeline.g.b b(ImageRequest imageRequest) {
        return imageRequest.bXJ() == null ? this.ifI : new com.facebook.imagepipeline.g.a(this.ifI, imageRequest.bXJ());
    }

    private Predicate<com.facebook.cache.common.b> y(final Uri uri) {
        return new Predicate<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            /* renamed from: s */
            public boolean apply(com.facebook.cache.common.b bVar) {
                return bVar.i(uri);
            }
        };
    }

    public com.facebook.imagepipeline.c.f bUu() {
        return this.ifc;
    }
}
