package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lRZ;
    private final com.facebook.imagepipeline.c.f lSa;
    private final com.facebook.imagepipeline.c.e lTf;
    private final aj<com.facebook.imagepipeline.g.e> lVb;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lTf = eVar;
        this.lRZ = eVar2;
        this.lSa = fVar;
        this.lVb = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest drx = akVar.drx();
        if (!drx.doR()) {
            e(kVar, akVar);
            return;
        }
        akVar.dry().fm(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.lSa.c(drx, akVar.dmf());
        com.facebook.imagepipeline.c.e eVar = drx.dsp() == ImageRequest.CacheChoice.SMALL ? this.lRZ : this.lTf;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dry = akVar.dry();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dry.b(id, "DiskCacheProducer", null);
                    kVar.dkE();
                } else if (gVar.aX()) {
                    dry.a(id, "DiskCacheProducer", gVar.aY(), (Map<String, String>) null);
                    o.this.lVb.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dry.a(id, "DiskCacheProducer", o.a(dry, id, true, result.getSize()));
                        dry.D(id, "DiskCacheProducer", true);
                        kVar.aK(1.0f);
                        kVar.g(result, 1);
                        result.close();
                    } else {
                        dry.a(id, "DiskCacheProducer", o.a(dry, id, false, 0));
                        o.this.lVb.c(kVar, akVar);
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
        if (akVar.drz().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lVb.c(kVar, akVar);
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
            public void dnP() {
                atomicBoolean.set(true);
            }
        });
    }
}
