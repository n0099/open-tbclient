package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mSJ;
    private final com.facebook.imagepipeline.c.f mSK;
    private final com.facebook.imagepipeline.c.e mTS;
    private final aj<com.facebook.imagepipeline.g.e> mVP;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mTS = eVar;
        this.mSJ = eVar2;
        this.mSK = fVar;
        this.mVP = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dFY = akVar.dFY();
        if (!dFY.dDt()) {
            e(kVar, akVar);
            return;
        }
        akVar.dFZ().fU(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.mSK.c(dFY, akVar.dAD());
        com.facebook.imagepipeline.c.e eVar = dFY.dGP() == ImageRequest.CacheChoice.SMALL ? this.mSJ : this.mTS;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dFZ = akVar.dFZ();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dFZ.b(id, "DiskCacheProducer", null);
                    kVar.dzd();
                } else if (gVar.gK()) {
                    dFZ.a(id, "DiskCacheProducer", gVar.gL(), (Map<String, String>) null);
                    o.this.mVP.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dFZ.a(id, "DiskCacheProducer", o.a(dFZ, id, true, result.getSize()));
                        dFZ.G(id, "DiskCacheProducer", true);
                        kVar.ay(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        dFZ.a(id, "DiskCacheProducer", o.a(dFZ, id, false, 0));
                        o.this.mVP.c(kVar, akVar);
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
        if (akVar.dGa().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.mVP.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.QP(str)) {
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
            public void dCq() {
                atomicBoolean.set(true);
            }
        });
    }
}
