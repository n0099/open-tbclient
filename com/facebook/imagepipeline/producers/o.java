package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes18.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e oVc;
    private final com.facebook.imagepipeline.c.f oVd;
    private final com.facebook.imagepipeline.c.e oWg;
    private final aj<com.facebook.imagepipeline.g.e> oYc;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oWg = eVar;
        this.oVc = eVar2;
        this.oVd = fVar;
        this.oYc = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest eqV = akVar.eqV();
        if (!eqV.eoq()) {
            e(kVar, akVar);
            return;
        }
        akVar.eqW().gZ(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.oVd.c(eqV, akVar.elz());
        com.facebook.imagepipeline.c.e eVar = eqV.erM() == ImageRequest.CacheChoice.SMALL ? this.oVc : this.oWg;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am eqW = akVar.eqW();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    eqW.b(id, "DiskCacheProducer", null);
                    kVar.ejZ();
                } else if (gVar.il()) {
                    eqW.a(id, "DiskCacheProducer", gVar.im(), (Map<String, String>) null);
                    o.this.oYc.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        eqW.a(id, "DiskCacheProducer", o.a(eqW, id, true, result.getSize()));
                        eqW.H(id, "DiskCacheProducer", true);
                        kVar.aN(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        eqW.a(id, "DiskCacheProducer", o.a(eqW, id, false, 0));
                        o.this.oYc.c(kVar, akVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.il() && (gVar.im() instanceof CancellationException));
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.eqX().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.oYc.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Ym(str)) {
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
            public void enm() {
                atomicBoolean.set(true);
            }
        });
    }
}
