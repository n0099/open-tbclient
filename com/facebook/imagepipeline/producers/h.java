package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kcC;
    private final com.facebook.imagepipeline.c.f khE;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kkY;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.kcC = tVar;
        this.khE = fVar;
        this.kkY = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cII = ajVar.cII();
        String id = ajVar.getId();
        cII.en(id, cIS());
        com.facebook.cache.common.b a = this.khE.a(ajVar.cIH(), ajVar.cEb());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aQ = this.kcC.aQ(a);
        if (aQ != null) {
            boolean cHW = aQ.get().cHK().cHW();
            if (cHW) {
                cII.a(id, cIS(), cII.GH(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.av(1.0f);
            }
            jVar.f(aQ, cHW);
            aQ.close();
            if (cHW) {
                return;
            }
        }
        if (ajVar.cIJ().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            cII.a(id, cIS(), cII.GH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.f(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        cII.a(id, cIS(), cII.GH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kkY.a(a2, ajVar);
    }

    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final com.facebook.cache.common.b bVar) {
        return new m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aQ;
                if (aVar == null) {
                    if (z) {
                        cIU().f(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    cIU().f(aVar, z);
                } else {
                    if (!z && (aQ = h.this.kcC.aQ(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cHK = aVar.get().cHK();
                            com.facebook.imagepipeline.f.g cHK2 = aQ.get().cHK();
                            if (cHK2.cHW() || cHK2.cHU() >= cHK.cHU()) {
                                cIU().f(aQ, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aQ);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.kcC.a(bVar, aVar);
                    if (z) {
                        try {
                            cIU().av(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cIU = cIU();
                    if (a != null) {
                        aVar = a;
                    }
                    cIU.f(aVar, z);
                }
            }
        };
    }

    protected String cIS() {
        return "BitmapMemoryCacheProducer";
    }
}
