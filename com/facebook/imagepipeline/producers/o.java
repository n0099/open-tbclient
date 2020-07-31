package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e naR;
    private final com.facebook.imagepipeline.c.f naS;
    private final com.facebook.imagepipeline.c.e nbX;
    private final aj<com.facebook.imagepipeline.g.e> ndT;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nbX = eVar;
        this.naR = eVar2;
        this.naS = fVar;
        this.ndT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dJo = akVar.dJo();
        if (!dJo.dGJ()) {
            e(kVar, akVar);
            return;
        }
        akVar.dJp().fW(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.naS.c(dJo, akVar.dDT());
        com.facebook.imagepipeline.c.e eVar = dJo.dKf() == ImageRequest.CacheChoice.SMALL ? this.naR : this.nbX;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dJp = akVar.dJp();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dJp.b(id, "DiskCacheProducer", null);
                    kVar.dCt();
                } else if (gVar.gK()) {
                    dJp.a(id, "DiskCacheProducer", gVar.gL(), (Map<String, String>) null);
                    o.this.ndT.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dJp.a(id, "DiskCacheProducer", o.a(dJp, id, true, result.getSize()));
                        dJp.G(id, "DiskCacheProducer", true);
                        kVar.ax(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        dJp.a(id, "DiskCacheProducer", o.a(dJp, id, false, 0));
                        o.this.ndT.c(kVar, akVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.gK() && (gVar.gL() instanceof CancellationException));
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dJq().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.ndT.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.RB(str)) {
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
            public void dFG() {
                atomicBoolean.set(true);
            }
        });
    }
}
