package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e oWF;
    private final com.facebook.imagepipeline.c.f oWG;
    private final com.facebook.imagepipeline.c.e oXJ;
    private final aj<com.facebook.imagepipeline.g.e> oZF;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oXJ = eVar;
        this.oWF = eVar2;
        this.oWG = fVar;
        this.oZF = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest eqT = akVar.eqT();
        if (!eqT.eoo()) {
            e(kVar, akVar);
            return;
        }
        akVar.eqU().gZ(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.oWG.c(eqT, akVar.elx());
        com.facebook.imagepipeline.c.e eVar = eqT.erK() == ImageRequest.CacheChoice.SMALL ? this.oWF : this.oXJ;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am eqU = akVar.eqU();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    eqU.b(id, "DiskCacheProducer", null);
                    kVar.ejX();
                } else if (gVar.il()) {
                    eqU.a(id, "DiskCacheProducer", gVar.im(), (Map<String, String>) null);
                    o.this.oZF.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        eqU.a(id, "DiskCacheProducer", o.a(eqU, id, true, result.getSize()));
                        eqU.I(id, "DiskCacheProducer", true);
                        kVar.aU(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        eqU.a(id, "DiskCacheProducer", o.a(eqU, id, false, 0));
                        o.this.oZF.c(kVar, akVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.il() && (gVar.im() instanceof CancellationException));
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.eqV().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.oZF.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.XX(str)) {
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
            public void enk() {
                atomicBoolean.set(true);
            }
        });
    }
}
