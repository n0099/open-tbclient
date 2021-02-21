package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class o implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e pIO;
    private final com.facebook.imagepipeline.b.f pIP;
    private final com.facebook.imagepipeline.b.e pJS;
    private final aj<com.facebook.imagepipeline.f.e> pLO;

    public o(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pJS = eVar;
        this.pIO = eVar2;
        this.pIP = fVar;
        this.pLO = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest ezp = akVar.ezp();
        if (!ezp.ewO()) {
            c(kVar, akVar);
            return;
        }
        akVar.ezq().hv(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.pIP.c(ezp, akVar.eud());
        com.facebook.imagepipeline.b.e eVar = ezp.eAe() == ImageRequest.CacheChoice.SMALL ? this.pIO : this.pJS;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(b(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> b(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am ezq = akVar.ezq();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    ezq.c(id, "DiskCacheProducer", null);
                    kVar.esD();
                } else if (gVar.hC()) {
                    ezq.a(id, "DiskCacheProducer", gVar.hD(), (Map<String, String>) null);
                    o.this.pLO.a(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        ezq.b(id, "DiskCacheProducer", o.a(ezq, id, true, result.getSize()));
                        ezq.M(id, "DiskCacheProducer", true);
                        kVar.ba(1.0f);
                        kVar.g(result, 1);
                        result.close();
                    } else {
                        ezq.b(id, "DiskCacheProducer", o.a(ezq, id, false, 0));
                        o.this.pLO.a(kVar, akVar);
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
        if (akVar.ezr().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pLO.a(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.ZG(str)) {
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
            public void ezw() {
                atomicBoolean.set(true);
            }
        });
    }
}
