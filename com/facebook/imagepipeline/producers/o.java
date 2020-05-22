package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mvy;
    private final com.facebook.imagepipeline.c.f mvz;
    private final com.facebook.imagepipeline.c.e mwC;
    private final aj<com.facebook.imagepipeline.g.e> myy;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mwC = eVar;
        this.mvy = eVar2;
        this.mvz = fVar;
        this.myy = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dBi = akVar.dBi();
        if (!dBi.dyD()) {
            e(kVar, akVar);
            return;
        }
        akVar.dBj().fK(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.mvz.c(dBi, akVar.dvM());
        com.facebook.imagepipeline.c.e eVar = dBi.dBZ() == ImageRequest.CacheChoice.SMALL ? this.mvy : this.mwC;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dBj = akVar.dBj();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dBj.b(id, "DiskCacheProducer", null);
                    kVar.dum();
                } else if (gVar.gu()) {
                    dBj.a(id, "DiskCacheProducer", gVar.gv(), (Map<String, String>) null);
                    o.this.myy.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dBj.a(id, "DiskCacheProducer", o.a(dBj, id, true, result.getSize()));
                        dBj.F(id, "DiskCacheProducer", true);
                        kVar.at(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        dBj.a(id, "DiskCacheProducer", o.a(dBj, id, false, 0));
                        o.this.myy.c(kVar, akVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.gu() && (gVar.gv() instanceof CancellationException));
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dBk().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.myy.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Qc(str)) {
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
            public void dxA() {
                atomicBoolean.set(true);
            }
        });
    }
}
