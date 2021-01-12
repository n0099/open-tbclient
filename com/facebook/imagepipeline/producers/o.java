package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class o implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pBf;
    private final com.facebook.imagepipeline.b.e pyf;
    private final com.facebook.imagepipeline.b.f pyg;
    private final com.facebook.imagepipeline.b.e pzj;

    public o(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pzj = eVar;
        this.pyf = eVar2;
        this.pyg = fVar;
        this.pBf = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest ewP = akVar.ewP();
        if (!ewP.eun()) {
            c(kVar, akVar);
            return;
        }
        akVar.ewQ().hm(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.pyg.c(ewP, akVar.erD());
        com.facebook.imagepipeline.b.e eVar = ewP.exE() == ImageRequest.CacheChoice.SMALL ? this.pyf : this.pzj;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(b(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> b(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am ewQ = akVar.ewQ();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    ewQ.c(id, "DiskCacheProducer", null);
                    kVar.eqc();
                } else if (gVar.hC()) {
                    ewQ.a(id, "DiskCacheProducer", gVar.hD(), (Map<String, String>) null);
                    o.this.pBf.a(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        ewQ.b(id, "DiskCacheProducer", o.a(ewQ, id, true, result.getSize()));
                        ewQ.M(id, "DiskCacheProducer", true);
                        kVar.aX(1.0f);
                        kVar.g(result, 1);
                        result.close();
                    } else {
                        ewQ.b(id, "DiskCacheProducer", o.a(ewQ, id, false, 0));
                        o.this.pBf.a(kVar, akVar);
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
        if (akVar.ewR().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pBf.a(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Ys(str)) {
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
            public void ewW() {
                atomicBoolean.set(true);
            }
        });
    }
}
