package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mSM;
    private final com.facebook.imagepipeline.c.f mSN;
    private final com.facebook.imagepipeline.c.e mTV;
    private final aj<com.facebook.imagepipeline.g.e> mVS;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mTV = eVar;
        this.mSM = eVar2;
        this.mSN = fVar;
        this.mVS = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dGc = akVar.dGc();
        if (!dGc.dDx()) {
            e(kVar, akVar);
            return;
        }
        akVar.dGd().fU(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.mSN.c(dGc, akVar.dAH());
        com.facebook.imagepipeline.c.e eVar = dGc.dGT() == ImageRequest.CacheChoice.SMALL ? this.mSM : this.mTV;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am dGd = akVar.dGd();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    dGd.b(id, "DiskCacheProducer", null);
                    kVar.dzh();
                } else if (gVar.gK()) {
                    dGd.a(id, "DiskCacheProducer", gVar.gL(), (Map<String, String>) null);
                    o.this.mVS.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dGd.a(id, "DiskCacheProducer", o.a(dGd, id, true, result.getSize()));
                        dGd.G(id, "DiskCacheProducer", true);
                        kVar.ay(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        dGd.a(id, "DiskCacheProducer", o.a(dGd, id, false, 0));
                        o.this.mVS.c(kVar, akVar);
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
        if (akVar.dGe().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.mVS.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.QQ(str)) {
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
            public void dCu() {
                atomicBoolean.set(true);
            }
        });
    }
}
