package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes25.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e nEY;
    private final com.facebook.imagepipeline.c.f nEZ;
    private final com.facebook.imagepipeline.c.e nGe;
    private final aj<com.facebook.imagepipeline.g.e> nIa;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nGe = eVar;
        this.nEY = eVar2;
        this.nEZ = fVar;
        this.nIa = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dZv = akVar.dZv();
        if (!dZv.dWQ()) {
            e(kVar, akVar);
            return;
        }
        akVar.dZw().gA(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.nEZ.c(dZv, akVar.dUb());
        com.facebook.imagepipeline.c.e eVar = dZv.eam() == ImageRequest.CacheChoice.SMALL ? this.nEY : this.nGe;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dZw = akVar.dZw();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dZw.b(id, "DiskCacheProducer", null);
                    kVar.dSB();
                } else if (gVar.ik()) {
                    dZw.a(id, "DiskCacheProducer", gVar.il(), (Map<String, String>) null);
                    o.this.nIa.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dZw.a(id, "DiskCacheProducer", o.a(dZw, id, true, result.getSize()));
                        dZw.F(id, "DiskCacheProducer", true);
                        kVar.aD(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        dZw.a(id, "DiskCacheProducer", o.a(dZw, id, false, 0));
                        o.this.nIa.c(kVar, akVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.ik() && (gVar.il() instanceof CancellationException));
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dZx().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.nIa.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Vh(str)) {
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
            public void dVN() {
                atomicBoolean.set(true);
            }
        });
    }
}
