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
    private static final CancellationException irk = new CancellationException("Prefetching is not enabled");
    private final com.facebook.imagepipeline.c.e iqF;
    private final com.facebook.imagepipeline.c.f iqG;
    private final m irl;
    private final com.facebook.imagepipeline.g.b irm;
    private final com.facebook.common.internal.i<Boolean> irn;
    private final t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iro;
    private final t<com.facebook.cache.common.b, PooledByteBuffer> irp;
    private final com.facebook.imagepipeline.c.e irq;
    private final aq irr;
    private final com.facebook.common.internal.i<Boolean> irs;
    private AtomicLong irt = new AtomicLong();

    public g(m mVar, Set<com.facebook.imagepipeline.g.b> set, com.facebook.common.internal.i<Boolean> iVar, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, t<com.facebook.cache.common.b, PooledByteBuffer> tVar2, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aq aqVar, com.facebook.common.internal.i<Boolean> iVar2) {
        this.irl = mVar;
        this.irm = new com.facebook.imagepipeline.g.a(set);
        this.irn = iVar;
        this.iro = tVar;
        this.irp = tVar2;
        this.irq = eVar;
        this.iqF = eVar2;
        this.iqG = fVar;
        this.irr = aqVar;
        this.irs = iVar2;
    }

    private String bXW() {
        return String.valueOf(this.irt.getAndIncrement());
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        try {
            return a(this.irl.c(imageRequest), imageRequest, requestLevel, obj);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    public boolean x(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.iro.b(z(uri));
    }

    public t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> bXX() {
        return this.iro;
    }

    public com.facebook.datasource.b<Boolean> y(Uri uri) {
        return a(ImageRequest.E(uri));
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<java.lang.Boolean, bolts.g<java.lang.Boolean>>, bolts.f<java.lang.Boolean, bolts.g<TContinuationResult>> */
    public com.facebook.datasource.b<Boolean> a(ImageRequest imageRequest) {
        final com.facebook.cache.common.b c = this.iqG.c(imageRequest, null);
        final com.facebook.datasource.g bVo = com.facebook.datasource.g.bVo();
        this.irq.j(c).b(new bolts.f<Boolean, bolts.g<Boolean>>() { // from class: com.facebook.imagepipeline.d.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<Boolean> a(bolts.g<Boolean> gVar) throws Exception {
                if (gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) {
                    return g.this.iqF.j(c);
                }
                return bolts.g.f(true);
            }
        }).a(new bolts.f<Boolean, Void>() { // from class: com.facebook.imagepipeline.d.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<Boolean> gVar) throws Exception {
                bVo.at(Boolean.valueOf((gVar.isCancelled() || gVar.bf() || !gVar.getResult().booleanValue()) ? false : true));
                return null;
            }
        });
        return bVo;
    }

    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(ai<com.facebook.common.references.a<T>> aiVar, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        boolean z = false;
        com.facebook.imagepipeline.g.b b = b(imageRequest);
        try {
            return com.facebook.imagepipeline.e.c.a(aiVar, new an(imageRequest, bXW(), b, obj, ImageRequest.RequestLevel.getMax(imageRequest.car(), requestLevel), false, (!imageRequest.cbi() && imageRequest.cbe() == null && com.facebook.common.util.d.k(imageRequest.cbc())) ? true : true, imageRequest.cat()), b);
        } catch (Exception e) {
            return com.facebook.datasource.c.v(e);
        }
    }

    private com.facebook.imagepipeline.g.b b(ImageRequest imageRequest) {
        return imageRequest.cbn() == null ? this.irm : new com.facebook.imagepipeline.g.a(this.irm, imageRequest.cbn());
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

    public com.facebook.imagepipeline.c.f bXY() {
        return this.iqG;
    }
}
