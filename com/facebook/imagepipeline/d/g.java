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
    private static final CancellationException iqc = new CancellationException("Prefetching is not enabled");
    private final com.facebook.imagepipeline.c.e ipx;
    private final com.facebook.imagepipeline.c.f ipy;
    private final m iqd;
    private final com.facebook.imagepipeline.g.b iqe;
    private final com.facebook.common.internal.i<Boolean> iqf;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iqg;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> iqh;
    private final com.facebook.imagepipeline.c.e iqi;
    private final aq iqj;
    private final com.facebook.common.internal.i<Boolean> iqk;
    private AtomicLong iql = new AtomicLong();

    public g(m mVar, Set<com.facebook.imagepipeline.g.b> set, com.facebook.common.internal.i<Boolean> iVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aq aqVar, com.facebook.common.internal.i<Boolean> iVar2) {
        this.iqd = mVar;
        this.iqe = new com.facebook.imagepipeline.g.a(set);
        this.iqf = iVar;
        this.iqg = tVar;
        this.iqh = tVar2;
        this.iqi = eVar;
        this.ipx = eVar2;
        this.ipy = fVar;
        this.iqj = aqVar;
        this.iqk = iVar2;
    }

    private String bXo() {
        return String.valueOf(this.iql.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        try {
            return a(this.iqd.c(imageRequest), imageRequest, requestLevel, obj);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    public boolean x(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.iqg.b(z(uri));
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bXp() {
        return this.iqg;
    }

    public com.facebook.datasource.b<Boolean> y(Uri uri) {
        return a(ImageRequest.E(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.ipy.c(imageRequest, null);
        final com.facebook.datasource.g bUG = com.facebook.datasource.g.bUG();
        this.iqi.j(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) {
                    return g.this.ipx.j(c);
                }
                return bolts.g.f(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                bUG.at(Boolean.valueOf((gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return bUG;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(ai<com.facebook.common.references.a<T>> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        boolean z = false;
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.c.a(aiVar, new an(imageRequest, bXo(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.bZJ(), requestLevel), false, (!imageRequest.caA() && imageRequest.caw() == null && com.facebook.common.util.d.k(imageRequest.cau())) ? true : true, imageRequest.bZL()), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    private com.facebook.imagepipeline.g.b b(ImageRequest imageRequest) {
        return imageRequest.caF() == null ? this.iqe : new com.facebook.imagepipeline.g.a(this.iqe, imageRequest.caF());
    }

    private Predicate<com.facebook.cache.common.b> z(final Uri uri) {
        return new Predicate<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.d.g.3
            /* JADX DEBUG: Method merged with bridge method */
            /* renamed from: s */
            public boolean apply(com.facebook.cache.common.b bVar) {
                return bVar.j(uri);
            }
        };
    }

    public com.facebook.imagepipeline.c.f bXq() {
        return this.ipy;
    }
}
