package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e nuJ;
    private final com.facebook.imagepipeline.c.f nuK;
    private final com.facebook.imagepipeline.c.e nvP;
    private final aj<com.facebook.imagepipeline.g.e> nxL;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nvP = eVar;
        this.nuJ = eVar2;
        this.nuK = fVar;
        this.nxL = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dVo = akVar.dVo();
        if (!dVo.dSJ()) {
            e(kVar, akVar);
            return;
        }
        akVar.dVp().gn(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.nuK.c(dVo, akVar.dPU());
        com.facebook.imagepipeline.c.e eVar = dVo.dWf() == ImageRequest.CacheChoice.SMALL ? this.nuJ : this.nvP;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dVp = akVar.dVp();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dVp.b(id, "DiskCacheProducer", null);
                    kVar.dOu();
                } else if (gVar.ik()) {
                    dVp.a(id, "DiskCacheProducer", gVar.il(), (Map<String, String>) null);
                    o.this.nxL.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dVp.a(id, "DiskCacheProducer", o.a(dVp, id, true, result.getSize()));
                        dVp.F(id, "DiskCacheProducer", true);
                        kVar.aD(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        dVp.a(id, "DiskCacheProducer", o.a(dVp, id, false, 0));
                        o.this.nxL.c(kVar, akVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.ik() && (gVar.il() instanceof CancellationException));
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dVq().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.nxL.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.UF(str)) {
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
            public void dRG() {
                atomicBoolean.set(true);
            }
        });
    }
}
