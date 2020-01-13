package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lRl;
    private final com.facebook.imagepipeline.c.f lRm;
    private final com.facebook.imagepipeline.c.e lSr;
    private final aj<com.facebook.imagepipeline.g.e> lUn;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lSr = eVar;
        this.lRl = eVar2;
        this.lRm = fVar;
        this.lUn = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dqh = akVar.dqh();
        if (!dqh.dnB()) {
            e(kVar, akVar);
            return;
        }
        akVar.dqi().fe(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.lRm.c(dqh, akVar.dkO());
        com.facebook.imagepipeline.c.e eVar = dqh.dqZ() == ImageRequest.CacheChoice.SMALL ? this.lRl : this.lSr;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dqi = akVar.dqi();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dqi.b(id, "DiskCacheProducer", null);
                    kVar.djn();
                } else if (gVar.aX()) {
                    dqi.a(id, "DiskCacheProducer", gVar.aY(), (Map<String, String>) null);
                    o.this.lUn.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dqi.a(id, "DiskCacheProducer", o.a(dqi, id, true, result.getSize()));
                        dqi.C(id, "DiskCacheProducer", true);
                        kVar.aL(1.0f);
                        kVar.g(result, 1);
                        result.close();
                    } else {
                        dqi.a(id, "DiskCacheProducer", o.a(dqi, id, false, 0));
                        o.this.lUn.c(kVar, akVar);
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
        if (akVar.dqj().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lUn.c(kVar, akVar);
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
            public void dmy() {
                atomicBoolean.set(true);
            }
        });
    }
}
