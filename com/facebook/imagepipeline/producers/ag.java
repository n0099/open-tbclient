package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ilM;
    private final com.facebook.imagepipeline.c.f iqG;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> itX;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.ilM = tVar;
        this.iqG = fVar;
        this.itX = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al caq = ajVar.caq();
        String id = ajVar.getId();
        ImageRequest cap = ajVar.cap();
        Object bVS = ajVar.bVS();
        com.facebook.imagepipeline.request.b cbm = cap.cbm();
        if (cbm == null || cbm.cbu() == null) {
            this.itX.a(jVar, ajVar);
            return;
        }
        caq.de(id, caA());
        com.facebook.cache.common.b b = this.iqG.b(cap, bVS);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH = this.ilM.aH(b);
        if (aH != null) {
            caq.a(id, caA(), caq.zE(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.az(1.0f);
            jVar.e(aH, true);
            aH.close();
            return;
        }
        a aVar = new a(jVar, b, cbm instanceof com.facebook.imagepipeline.request.c, this.ilM);
        caq.a(id, caA(), caq.zE(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.itX.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b ijO;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ilM;
        private final boolean ivp;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.ijO = bVar;
            this.ivp = z;
            this.ilM = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    caC().e(null, true);
                }
            } else if (z || this.ivp) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.ilM.a(this.ijO, aVar);
                try {
                    caC().az(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> caC = caC();
                    if (a != null) {
                        aVar = a;
                    }
                    caC.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String caA() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
