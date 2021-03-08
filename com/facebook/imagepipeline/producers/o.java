package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class o implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e pKT;
    private final com.facebook.imagepipeline.b.f pKU;
    private final com.facebook.imagepipeline.b.e pLX;
    private final aj<com.facebook.imagepipeline.f.e> pNT;

    public o(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pLX = eVar;
        this.pKT = eVar2;
        this.pKU = fVar;
        this.pNT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest ezy = akVar.ezy();
        if (!ezy.ewX()) {
            c(kVar, akVar);
            return;
        }
        akVar.ezz().hv(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.pKU.c(ezy, akVar.eum());
        com.facebook.imagepipeline.b.e eVar = ezy.eAn() == ImageRequest.CacheChoice.SMALL ? this.pKT : this.pLX;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(b(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> b(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am ezz = akVar.ezz();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    ezz.c(id, "DiskCacheProducer", null);
                    kVar.esM();
                } else if (gVar.hJ()) {
                    ezz.a(id, "DiskCacheProducer", gVar.hK(), (Map<String, String>) null);
                    o.this.pNT.a(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        ezz.b(id, "DiskCacheProducer", o.a(ezz, id, true, result.getSize()));
                        ezz.M(id, "DiskCacheProducer", true);
                        kVar.be(1.0f);
                        kVar.f(result, 1);
                        result.close();
                    } else {
                        ezz.b(id, "DiskCacheProducer", o.a(ezz, id, false, 0));
                        o.this.pNT.a(kVar, akVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.hJ() && (gVar.hK() instanceof CancellationException));
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ezA().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.f(null, 1);
        } else {
            this.pNT.a(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.ZM(str)) {
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
            public void ezF() {
                atomicBoolean.set(true);
            }
        });
    }
}
