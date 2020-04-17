package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mbD;
    private final com.facebook.imagepipeline.c.f mbE;
    private final com.facebook.imagepipeline.c.e mcH;
    private final aj<com.facebook.imagepipeline.g.e> meD;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mcH = eVar;
        this.mbD = eVar2;
        this.mbE = fVar;
        this.meD = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dtT = akVar.dtT();
        if (!dtT.drn()) {
            e(kVar, akVar);
            return;
        }
        akVar.dtU().fi(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.mbE.c(dtT, akVar.dow());
        com.facebook.imagepipeline.c.e eVar = dtT.duK() == ImageRequest.CacheChoice.SMALL ? this.mbD : this.mcH;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dtU = akVar.dtU();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dtU.b(id, "DiskCacheProducer", null);
                    kVar.dmV();
                } else if (gVar.gu()) {
                    dtU.a(id, "DiskCacheProducer", gVar.gv(), (Map<String, String>) null);
                    o.this.meD.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dtU.a(id, "DiskCacheProducer", o.a(dtU, id, true, result.getSize()));
                        dtU.D(id, "DiskCacheProducer", true);
                        kVar.au(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        dtU.a(id, "DiskCacheProducer", o.a(dtU, id, false, 0));
                        o.this.meD.c(kVar, akVar);
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
        if (akVar.dtV().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.meD.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Ol(str)) {
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
            public void dqk() {
                atomicBoolean.set(true);
            }
        });
    }
}
