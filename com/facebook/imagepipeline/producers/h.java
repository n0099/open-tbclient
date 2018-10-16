package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> hYw;
    private final com.facebook.imagepipeline.c.f idp;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> igI;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.hYw = tVar;
        this.idp = fVar;
        this.igI = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al bXr = ajVar.bXr();
        String id = ajVar.getId();
        bXr.cX(id, bXB());
        com.facebook.cache.common.b a = this.idp.a(ajVar.bXq(), ajVar.bST());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH = this.hYw.aH(a);
        if (aH != null) {
            boolean bWF = aH.get().bWu().bWF();
            if (bWF) {
                bXr.a(id, bXB(), bXr.yD(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.ax(1.0f);
            }
            jVar.e(aH, bWF);
            aH.close();
            if (bWF) {
                return;
            }
        }
        if (ajVar.bXs().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            bXr.a(id, bXB(), bXr.yD(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        bXr.a(id, bXB(), bXr.yD(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.igI.a(a2, ajVar);
    }

    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final com.facebook.cache.common.b bVar) {
        return new m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH;
                if (aVar == null) {
                    if (z) {
                        bXD().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    bXD().e(aVar, z);
                } else {
                    if (!z && (aH = h.this.hYw.aH(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g bWu = aVar.get().bWu();
                            com.facebook.imagepipeline.f.g bWu2 = aH.get().bWu();
                            if (bWu2.bWF() || bWu2.getQuality() >= bWu.getQuality()) {
                                bXD().e(aH, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aH);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.hYw.a(bVar, aVar);
                    if (z) {
                        try {
                            bXD().ax(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bXD = bXD();
                    if (a != null) {
                        aVar = a;
                    }
                    bXD.e(aVar, z);
                }
            }
        };
    }

    protected String bXB() {
        return "BitmapMemoryCacheProducer";
    }
}
