package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes18.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e nUr;
    private final com.facebook.imagepipeline.c.f nUs;
    private final com.facebook.imagepipeline.c.e nVv;
    private final aj<com.facebook.imagepipeline.g.e> nXr;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nVv = eVar;
        this.nUr = eVar2;
        this.nUs = fVar;
        this.nXr = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest edg = akVar.edg();
        if (!edg.eaB()) {
            e(kVar, akVar);
            return;
        }
        akVar.edh().gH(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.nUs.c(edg, akVar.dXM());
        com.facebook.imagepipeline.c.e eVar = edg.edX() == ImageRequest.CacheChoice.SMALL ? this.nUr : this.nVv;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am edh = akVar.edh();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    edh.b(id, "DiskCacheProducer", null);
                    kVar.dWm();
                } else if (gVar.il()) {
                    edh.a(id, "DiskCacheProducer", gVar.im(), (Map<String, String>) null);
                    o.this.nXr.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        edh.a(id, "DiskCacheProducer", o.a(edh, id, true, result.getSize()));
                        edh.F(id, "DiskCacheProducer", true);
                        kVar.aJ(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        edh.a(id, "DiskCacheProducer", o.a(edh, id, false, 0));
                        o.this.nXr.c(kVar, akVar);
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
        if (akVar.edi().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.nXr.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.VV(str)) {
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
            public void dZy() {
                atomicBoolean.set(true);
            }
        });
    }
}
