package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ket;
    private final com.facebook.imagepipeline.c.f kjt;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kmM;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.ket = tVar;
        this.kjt = fVar;
        this.kmM = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cLL = ajVar.cLL();
        String id = ajVar.getId();
        cLL.eB(id, cLV());
        com.facebook.cache.common.b a = this.kjt.a(ajVar.cLK(), ajVar.cHd());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.ket.aV(a);
        if (aV != null) {
            boolean cKZ = aV.get().cKN().cKZ();
            if (cKZ) {
                cLL.a(id, cLV(), cLL.Iq(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aS(1.0f);
            }
            jVar.e(aV, cKZ);
            aV.close();
            if (cKZ) {
                return;
            }
        }
        if (ajVar.cLM().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            cLL.a(id, cLV(), cLL.Iq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        cLL.a(id, cLV(), cLL.Iq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kmM.a(a2, ajVar);
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
                        cLX().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    cLX().e(aVar, z);
                } else {
                    if (!z && (aV = h.this.ket.aV(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cKN = aVar.get().cKN();
                            com.facebook.imagepipeline.f.g cKN2 = aV.get().cKN();
                            if (cKN2.cKZ() || cKN2.cKX() >= cKN.cKX()) {
                                cLX().e(aV, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(aV);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.ket.a(bVar, aVar);
                    if (z) {
                        try {
                            cLX().aS(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cLX = cLX();
                    if (a != null) {
                        aVar = a;
                    }
                    cLX.e(aVar, z);
                }
            }
        };
    }

    protected String cLV() {
        return "BitmapMemoryCacheProducer";
    }
}
