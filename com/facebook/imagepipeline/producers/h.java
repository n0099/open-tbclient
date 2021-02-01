package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pAs;
    private final com.facebook.imagepipeline.b.f pIp;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pLo;

    public h(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pAs = pVar;
        this.pIp = fVar;
        this.pLo = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am ezi = akVar.ezi();
        String id = akVar.getId();
        ezi.ht(id, ezs());
        com.facebook.cache.common.b a2 = this.pIp.a(akVar.ezh(), akVar.etV());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pAs.bu(a2);
        if (bu != null) {
            boolean eyu = bu.get().eyh().eyu();
            if (eyu) {
                ezi.b(id, ezs(), ezi.Zu(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                ezi.M(id, ezs(), true);
                kVar.ba(1.0f);
            }
            kVar.g(bu, b.Bt(eyu));
            bu.close();
            if (eyu) {
                return;
            }
        }
        if (akVar.ezj().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            ezi.b(id, ezs(), ezi.Zu(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            ezi.M(id, ezs(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a3 = a(kVar, a2, akVar.ezh().eAe());
        ezi.b(id, ezs(), ezi.Zu(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pLo.a(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu;
                boolean Qj = Qj(i);
                if (aVar == null) {
                    if (Qj) {
                        ezu().g(null, i);
                    }
                } else if (aVar.get().isStateful() || ec(i, 8)) {
                    ezu().g(aVar, i);
                } else {
                    if (!Qj && (bu = h.this.pAs.bu(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.h eyh = aVar.get().eyh();
                            com.facebook.imagepipeline.f.h eyh2 = bu.get().eyh();
                            if (eyh2.eyu() || eyh2.getQuality() >= eyh.getQuality()) {
                                ezu().g(bu, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bu);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = z ? h.this.pAs.a(bVar, aVar) : null;
                    if (Qj) {
                        try {
                            ezu().ba(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezu = ezu();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    ezu.g(aVar, i);
                }
            }
        };
    }

    protected String ezs() {
        return "BitmapMemoryCacheProducer";
    }
}
