package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lRq;
    private final com.facebook.imagepipeline.c.f lRr;
    private final com.facebook.imagepipeline.c.e lSw;
    private final aj<com.facebook.imagepipeline.g.e> lUs;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lSw = eVar;
        this.lRq = eVar2;
        this.lRr = fVar;
        this.lUs = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dqj = akVar.dqj();
        if (!dqj.dnD()) {
            e(kVar, akVar);
            return;
        }
        akVar.dqk().fe(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.lRr.c(dqj, akVar.dkQ());
        com.facebook.imagepipeline.c.e eVar = dqj.drb() == ImageRequest.CacheChoice.SMALL ? this.lRq : this.lSw;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dqk = akVar.dqk();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dqk.b(id, "DiskCacheProducer", null);
                    kVar.djp();
                } else if (gVar.aX()) {
                    dqk.a(id, "DiskCacheProducer", gVar.aY(), (Map<String, String>) null);
                    o.this.lUs.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dqk.a(id, "DiskCacheProducer", o.a(dqk, id, true, result.getSize()));
                        dqk.C(id, "DiskCacheProducer", true);
                        kVar.aL(1.0f);
                        kVar.g(result, 1);
                        result.close();
                    } else {
                        dqk.a(id, "DiskCacheProducer", o.a(dqk, id, false, 0));
                        o.this.lUs.c(kVar, akVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.aX() && (gVar.aY() instanceof CancellationException));
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dql().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lUs.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.OQ(str)) {
            return null;
        }
        if (z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z));
    }

    private void a(final AtomicBoolean atomicBoolean, ak akVar) {
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.o.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dmA() {
                atomicBoolean.set(true);
            }
        });
    }
}
