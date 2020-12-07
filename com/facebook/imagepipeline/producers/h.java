package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pdv;
    private final com.facebook.imagepipeline.b.f plv;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pox;

    public h(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pdv = pVar;
        this.plv = fVar;
        this.pox = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am eww = akVar.eww();
        String id = akVar.getId();
        eww.hh(id, ewG());
        com.facebook.cache.common.b a2 = this.plv.a(akVar.ewv(), akVar.erm());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pdv.bu(a2);
        if (bu != null) {
            boolean evI = bu.get().evu().evI();
            if (evI) {
                eww.a(id, ewG(), eww.Zq(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eww.J(id, ewG(), true);
                kVar.aV(1.0f);
            }
            kVar.h(bu, b.AW(evI));
            bu.close();
            if (evI) {
                return;
            }
        }
        if (akVar.ewx().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            eww.a(id, ewG(), eww.Zq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            eww.J(id, ewG(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a3 = a(kVar, a2, akVar.ewv().exs());
        eww.a(id, ewG(), eww.Zq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pox.a(a3, akVar);
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
                        ewI().h(null, i);
                    }
                } else if (aVar.get().isStateful() || ef(i, 8)) {
                    ewI().h(aVar, i);
                } else {
                    if (!Rh && (bu = h.this.pdv.bu(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.h evu = aVar.get().evu();
                            com.facebook.imagepipeline.f.h evu2 = bu.get().evu();
                            if (evu2.evI() || evu2.evG() >= evu.evG()) {
                                ewI().h(bu, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bu);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = z ? h.this.pdv.a(bVar, aVar) : null;
                    if (Rh) {
                        try {
                            ewI().aV(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ewI = ewI();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    ewI.h(aVar, i);
                }
            }
        };
    }

    protected String ewG() {
        return "BitmapMemoryCacheProducer";
    }
}
