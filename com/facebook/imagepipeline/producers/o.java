package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class o implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e pCG;
    private final com.facebook.imagepipeline.b.f pCH;
    private final com.facebook.imagepipeline.b.e pDK;
    private final aj<com.facebook.imagepipeline.f.e> pFG;

    public o(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pDK = eVar;
        this.pCG = eVar2;
        this.pCH = fVar;
        this.pFG = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest eAH = akVar.eAH();
        if (!eAH.eyf()) {
            c(kVar, akVar);
            return;
        }
        akVar.eAI().hn(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.pCH.c(eAH, akVar.evw());
        com.facebook.imagepipeline.b.e eVar = eAH.eBw() == ImageRequest.CacheChoice.SMALL ? this.pCG : this.pDK;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(b(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> b(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am eAI = akVar.eAI();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    eAI.c(id, "DiskCacheProducer", null);
                    kVar.etW();
                } else if (gVar.hC()) {
                    eAI.a(id, "DiskCacheProducer", gVar.hD(), (Map<String, String>) null);
                    o.this.pFG.a(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        eAI.b(id, "DiskCacheProducer", o.a(eAI, id, true, result.getSize()));
                        eAI.M(id, "DiskCacheProducer", true);
                        kVar.aX(1.0f);
                        kVar.g(result, 1);
                        result.close();
                    } else {
                        eAI.b(id, "DiskCacheProducer", o.a(eAI, id, false, 0));
                        o.this.pFG.a(kVar, akVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.hC() && (gVar.hD() instanceof CancellationException));
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.eAJ().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pFG.a(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.ZA(str)) {
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
            public void eAO() {
                atomicBoolean.set(true);
            }
        });
    }
}
