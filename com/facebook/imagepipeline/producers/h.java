package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pdx;
    private final com.facebook.imagepipeline.b.f plx;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> poz;

    public h(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pdx = pVar;
        this.plx = fVar;
        this.poz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am ewx = akVar.ewx();
        String id = akVar.getId();
        ewx.hh(id, ewH());
        com.facebook.cache.common.b a2 = this.plx.a(akVar.eww(), akVar.ern());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pdx.bu(a2);
        if (bu != null) {
            boolean evJ = bu.get().evv().evJ();
            if (evJ) {
                ewx.a(id, ewH(), ewx.Zq(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                ewx.J(id, ewH(), true);
                kVar.aV(1.0f);
            }
            kVar.h(bu, b.AW(evJ));
            bu.close();
            if (evJ) {
                return;
            }
        }
        if (akVar.ewy().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            ewx.a(id, ewH(), ewx.Zq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            ewx.J(id, ewH(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a3 = a(kVar, a2, akVar.eww().ext());
        ewx.a(id, ewH(), ewx.Zq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.poz.a(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu;
                boolean Rh = Rh(i);
                if (aVar == null) {
                    if (Rh) {
                        ewJ().h(null, i);
                    }
                } else if (aVar.get().isStateful() || ef(i, 8)) {
                    ewJ().h(aVar, i);
                } else {
                    if (!Rh && (bu = h.this.pdx.bu(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.h evv = aVar.get().evv();
                            com.facebook.imagepipeline.f.h evv2 = bu.get().evv();
                            if (evv2.evJ() || evv2.evH() >= evv.evH()) {
                                ewJ().h(bu, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bu);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = z ? h.this.pdx.a(bVar, aVar) : null;
                    if (Rh) {
                        try {
                            ewJ().aV(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ewJ = ewJ();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    ewJ.h(aVar, i);
                }
            }
        };
    }

    protected String ewH() {
        return "BitmapMemoryCacheProducer";
    }
}
