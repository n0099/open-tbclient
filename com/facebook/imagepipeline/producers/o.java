package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class o implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e pAZ;
    private final com.facebook.imagepipeline.b.f pBa;
    private final com.facebook.imagepipeline.b.e pCd;
    private final aj<com.facebook.imagepipeline.f.e> pDZ;

    public o(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pCd = eVar;
        this.pAZ = eVar2;
        this.pBa = fVar;
        this.pDZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest eAd = akVar.eAd();
        if (!eAd.exD()) {
            c(kVar, akVar);
            return;
        }
        akVar.eAe().hm(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.pBa.c(eAd, akVar.evp());
        com.facebook.imagepipeline.b.e eVar = eAd.eAS() == ImageRequest.CacheChoice.SMALL ? this.pAZ : this.pCd;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(b(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> b(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am eAe = akVar.eAe();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    eAe.c(id, "DiskCacheProducer", null);
                    kVar.etQ();
                } else if (gVar.hC()) {
                    eAe.a(id, "DiskCacheProducer", gVar.hD(), (Map<String, String>) null);
                    o.this.pDZ.a(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        eAe.b(id, "DiskCacheProducer", o.a(eAe, id, true, result.getSize()));
                        eAe.M(id, "DiskCacheProducer", true);
                        kVar.aX(1.0f);
                        kVar.g(result, 1);
                        result.close();
                    } else {
                        eAe.b(id, "DiskCacheProducer", o.a(eAe, id, false, 0));
                        o.this.pDZ.a(kVar, akVar);
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
        if (akVar.eAf().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pDZ.a(kVar, akVar);
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
            public void eAk() {
                atomicBoolean.set(true);
            }
        });
    }
}
