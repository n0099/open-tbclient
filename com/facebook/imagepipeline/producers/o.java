package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class o implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e plw;
    private final com.facebook.imagepipeline.b.f plx;
    private final com.facebook.imagepipeline.b.e pmA;
    private final aj<com.facebook.imagepipeline.f.e> poz;

    public o(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pmA = eVar;
        this.plw = eVar2;
        this.plx = fVar;
        this.poz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest eww = akVar.eww();
        if (!eww.etU()) {
            c(kVar, akVar);
            return;
        }
        akVar.ewx().hh(akVar.getId(), "DiskCacheProducer");
        com.facebook.cache.common.b c = this.plx.c(eww, akVar.ern());
        com.facebook.imagepipeline.b.e eVar = eww.exl() == ImageRequest.CacheChoice.SMALL ? this.plw : this.pmA;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.a(c, atomicBoolean).a(b(kVar, akVar));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> b(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar) {
        final String id = akVar.getId();
        final am ewx = akVar.ewx();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (o.d(gVar)) {
                    ewx.b(id, "DiskCacheProducer", null);
                    kVar.epN();
                } else if (gVar.il()) {
                    ewx.a(id, "DiskCacheProducer", gVar.im(), (Map<String, String>) null);
                    o.this.poz.a(kVar, akVar);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        ewx.a(id, "DiskCacheProducer", o.a(ewx, id, true, result.getSize()));
                        ewx.J(id, "DiskCacheProducer", true);
                        kVar.aV(1.0f);
                        kVar.h(result, 1);
                        result.close();
                    } else {
                        ewx.a(id, "DiskCacheProducer", o.a(ewx, id, false, 0));
                        o.this.poz.a(kVar, akVar);
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

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ewy().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.poz.a(kVar, akVar);
        }
    }

    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Zq(str)) {
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
            public void ewD() {
                atomicBoolean.set(true);
            }
        });
    }
}
