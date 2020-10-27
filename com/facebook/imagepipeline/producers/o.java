package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes18.dex */
public class o implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e oLJ;
    private final com.facebook.imagepipeline.c.f oLK;
    private final com.facebook.imagepipeline.c.e oMN;
    private final aj<com.facebook.imagepipeline.g.e> oOJ;

    public o(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oMN = eVar;
        this.oLJ = eVar2;
        this.oLK = fVar;
        this.oOJ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest enf = akVar.enf();
        if (!enf.ekz()) {
            e(kVar, akVar);
            return;
        }
        akVar.eng().gX(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.oLK.c(enf, akVar.ehK());
        com.facebook.imagepipeline.c.e eVar = enf.enW() == ImageRequest.CacheChoice.SMALL ? this.oLJ : this.oMN;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(d(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> d(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am eng = akVar.eng();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    eng.b(id, "DiskCacheProducer", null);
                    kVar.egk();
                } else if (gVar.il()) {
                    eng.a(id, "DiskCacheProducer", gVar.im(), (Map<String, String>) null);
                    o.this.oOJ.c(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        eng.a(id, "DiskCacheProducer", o.a(eng, id, true, result.getSize()));
                        eng.G(id, "DiskCacheProducer", true);
                        kVar.aL(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        eng.a(id, "DiskCacheProducer", o.a(eng, id, false, 0));
                        o.this.oOJ.c(kVar, akVar);
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
        if (akVar.enh().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.oOJ.c(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.XI(str)) {
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
            public void ejw() {
                atomicBoolean.set(true);
            }
        });
    }
}
