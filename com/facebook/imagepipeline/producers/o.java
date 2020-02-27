package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lRX;
    private final com.facebook.imagepipeline.c.f lRY;
    private final com.facebook.imagepipeline.c.e lTd;
    private final aj<com.facebook.imagepipeline.g.e> lUZ;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lTd = eVar;
        this.lRX = eVar2;
        this.lRY = fVar;
        this.lUZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest drv = akVar.drv();
        if (!drv.doP()) {
            e(kVar, akVar);
            return;
        }
        akVar.drw().fm(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.lRY.c(drv, akVar.dmd());
        com.facebook.imagepipeline.c.e eVar = drv.dsn() == ImageRequest.CacheChoice.SMALL ? this.lRX : this.lTd;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am drw = akVar.drw();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    drw.b(id, "DiskCacheProducer", null);
                    kVar.dkC();
                } else if (gVar.aX()) {
                    drw.a(id, "DiskCacheProducer", gVar.aY(), (Map<String, String>) null);
                    o.this.lUZ.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        drw.a(id, "DiskCacheProducer", o.a(drw, id, true, result.getSize()));
                        drw.D(id, "DiskCacheProducer", true);
                        kVar.aK(1.0f);
                        kVar.g(result, 1);
                        result.close();
                    } else {
                        drw.a(id, "DiskCacheProducer", o.a(drw, id, false, 0));
                        o.this.lUZ.c(kVar, akVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.aX() && (gVar.aY() instanceof CancellationException));
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.drx().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lUZ.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Pd(str)) {
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
            public void dnN() {
                atomicBoolean.set(true);
            }
        });
    }
}
