package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class o implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e pIo;
    private final com.facebook.imagepipeline.b.f pIp;
    private final com.facebook.imagepipeline.b.e pJs;
    private final aj<com.facebook.imagepipeline.f.e> pLo;

    public o(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pJs = eVar;
        this.pIo = eVar2;
        this.pIp = fVar;
        this.pLo = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest ezh = akVar.ezh();
        if (!ezh.ewG()) {
            c(kVar, akVar);
            return;
        }
        akVar.ezi().ht(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.pIp.c(ezh, akVar.etV());
        com.facebook.imagepipeline.b.e eVar = ezh.ezW() == ImageRequest.CacheChoice.SMALL ? this.pIo : this.pJs;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(b(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> b(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am ezi = akVar.ezi();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    ezi.c(id, "DiskCacheProducer", null);
                    kVar.esv();
                } else if (gVar.hC()) {
                    ezi.a(id, "DiskCacheProducer", gVar.hD(), (Map<String, String>) null);
                    o.this.pLo.a(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        ezi.b(id, "DiskCacheProducer", o.a(ezi, id, true, result.getSize()));
                        ezi.M(id, "DiskCacheProducer", true);
                        kVar.ba(1.0f);
                        kVar.g(result, 1);
                        result.close();
                    } else {
                        ezi.b(id, "DiskCacheProducer", o.a(ezi, id, false, 0));
                        o.this.pLo.a(kVar, akVar);
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
        if (akVar.ezj().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pLo.a(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Zu(str)) {
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
            public void ezo() {
                atomicBoolean.set(true);
            }
        });
    }
}
