package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lSk;
    private final com.facebook.imagepipeline.c.f lSl;
    private final com.facebook.imagepipeline.c.e lTq;
    private final aj<com.facebook.imagepipeline.g.e> lVm;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lTq = eVar;
        this.lSk = eVar2;
        this.lSl = fVar;
        this.lVm = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dry = akVar.dry();
        if (!dry.doS()) {
            e(kVar, akVar);
            return;
        }
        akVar.drz().fm(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.lSl.c(dry, akVar.dmg());
        com.facebook.imagepipeline.c.e eVar = dry.dsq() == ImageRequest.CacheChoice.SMALL ? this.lSk : this.lTq;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am drz = akVar.drz();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    drz.b(id, "DiskCacheProducer", null);
                    kVar.dkF();
                } else if (gVar.aX()) {
                    drz.a(id, "DiskCacheProducer", gVar.aY(), (Map<String, String>) null);
                    o.this.lVm.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        drz.a(id, "DiskCacheProducer", o.a(drz, id, true, result.getSize()));
                        drz.D(id, "DiskCacheProducer", true);
                        kVar.aK(1.0f);
                        kVar.g(result, 1);
                        result.close();
                    } else {
                        drz.a(id, "DiskCacheProducer", o.a(drz, id, false, 0));
                        o.this.lVm.c(kVar, akVar);
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
        if (akVar.drA().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lVm.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Pe(str)) {
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
            public void dnQ() {
                atomicBoolean.set(true);
            }
        });
    }
}
