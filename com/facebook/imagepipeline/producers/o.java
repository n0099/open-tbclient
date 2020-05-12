package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mbH;
    private final com.facebook.imagepipeline.c.f mbI;
    private final com.facebook.imagepipeline.c.e mcL;
    private final aj<com.facebook.imagepipeline.g.e> meH;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mcL = eVar;
        this.mbH = eVar2;
        this.mbI = fVar;
        this.meH = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dtR = akVar.dtR();
        if (!dtR.drl()) {
            e(kVar, akVar);
            return;
        }
        akVar.dtS().fi(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.mbI.c(dtR, akVar.dou());
        com.facebook.imagepipeline.c.e eVar = dtR.duI() == ImageRequest.CacheChoice.SMALL ? this.mbH : this.mcL;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dtS = akVar.dtS();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dtS.b(id, "DiskCacheProducer", null);
                    kVar.dmT();
                } else if (gVar.gu()) {
                    dtS.a(id, "DiskCacheProducer", gVar.gv(), (Map<String, String>) null);
                    o.this.meH.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dtS.a(id, "DiskCacheProducer", o.a(dtS, id, true, result.getSize()));
                        dtS.D(id, "DiskCacheProducer", true);
                        kVar.au(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        dtS.a(id, "DiskCacheProducer", o.a(dtS, id, false, 0));
                        o.this.meH.c(kVar, akVar);
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
        if (akVar.dtT().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.meH.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Oo(str)) {
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
            public void dqi() {
                atomicBoolean.set(true);
            }
        });
    }
}
