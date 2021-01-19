package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pBg;
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pqj;
    private final com.facebook.imagepipeline.b.f pyh;

    public h(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pqj = pVar;
        this.pyh = fVar;
        this.pBg = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am ewQ = akVar.ewQ();
        String id = akVar.getId();
        ewQ.hm(id, exa());
        com.facebook.cache.common.b a2 = this.pyh.a(akVar.ewP(), akVar.erD());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pqj.bu(a2);
        if (bu != null) {
            boolean ewc = bu.get().evO().ewc();
            if (ewc) {
                ewQ.b(id, exa(), ewQ.Yt(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                ewQ.M(id, exa(), true);
                kVar.aX(1.0f);
            }
            kVar.g(bu, b.Ba(ewc));
            bu.close();
            if (ewc) {
                return;
            }
        }
        if (akVar.ewR().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            ewQ.b(id, exa(), ewQ.Yt(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            ewQ.M(id, exa(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a3 = a(kVar, a2, akVar.ewP().exM());
        ewQ.b(id, exa(), ewQ.Yt(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pBg.a(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu;
                boolean PO = PO(i);
                if (aVar == null) {
                    if (PO) {
                        exc().g(null, i);
                    }
                } else if (aVar.get().isStateful() || ef(i, 8)) {
                    exc().g(aVar, i);
                } else {
                    if (!PO && (bu = h.this.pqj.bu(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.h evO = aVar.get().evO();
                            com.facebook.imagepipeline.f.h evO2 = bu.get().evO();
                            if (evO2.ewc() || evO2.ewa() >= evO.ewa()) {
                                exc().g(bu, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bu);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = z ? h.this.pqj.a(bVar, aVar) : null;
                    if (PO) {
                        try {
                            exc().aX(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exc = exc();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    exc.g(aVar, i);
                }
            }
        };
    }

    protected String exa() {
        return "BitmapMemoryCacheProducer";
    }
}
