package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jTM;
    private final com.facebook.imagepipeline.c.f jYJ;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kcc;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jTM = tVar;
        this.jYJ = fVar;
        this.kcc = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cHy = ajVar.cHy();
        String id = ajVar.getId();
        cHy.ez(id, cHI());
        com.facebook.cache.common.b a = this.jYJ.a(ajVar.cHx(), ajVar.cCT());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.jTM.aV(a);
        if (aV != null) {
            boolean cGM = aV.get().cGB().cGM();
            if (cGM) {
                cHy.a(id, cHI(), cHy.GV(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aQ(1.0f);
            }
            jVar.e(aV, cGM);
            aV.close();
            if (cGM) {
                return;
            }
        }
        if (ajVar.cHz().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            cHy.a(id, cHI(), cHy.GV(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        cHy.a(id, cHI(), cHy.GV(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kcc.a(a2, ajVar);
    }

    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final com.facebook.cache.common.b bVar) {
        return new m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV;
                if (aVar == null) {
                    if (z) {
                        cHK().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    cHK().e(aVar, z);
                } else {
                    if (!z && (aV = h.this.jTM.aV(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cGB = aVar.get().cGB();
                            com.facebook.imagepipeline.f.g cGB2 = aV.get().cGB();
                            if (cGB2.cGM() || cGB2.getQuality() >= cGB.getQuality()) {
                                cHK().e(aV, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(aV);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.jTM.a(bVar, aVar);
                    if (z) {
                        try {
                            cHK().aQ(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHK = cHK();
                    if (a != null) {
                        aVar = a;
                    }
                    cHK.e(aVar, z);
                }
            }
        };
    }

    protected String cHI() {
        return "BitmapMemoryCacheProducer";
    }
}
