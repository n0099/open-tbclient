package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iah;
    private final com.facebook.imagepipeline.c.f ifc;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> iit;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.iah = tVar;
        this.ifc = fVar;
        this.iit = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al bWM = ajVar.bWM();
        String id = ajVar.getId();
        ImageRequest bWL = ajVar.bWL();
        Object bSo = ajVar.bSo();
        com.facebook.imagepipeline.request.b bXI = bWL.bXI();
        if (bXI == null || bXI.bXQ() == null) {
            this.iit.a(jVar, ajVar);
            return;
        }
        bWM.cW(id, bWW());
        com.facebook.cache.common.b b = this.ifc.b(bWL, bSo);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aG = this.iah.aG(b);
        if (aG != null) {
            bWM.a(id, bWW(), bWM.yI(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.az(1.0f);
            jVar.e(aG, true);
            aG.close();
            return;
        }
        a aVar = new a(jVar, b, bXI instanceof com.facebook.imagepipeline.request.c, this.iah);
        bWM.a(id, bWW(), bWM.yI(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.iit.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b hYj;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iah;
        private final boolean ijL;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.hYj = bVar;
            this.ijL = z;
            this.iah = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    bWY().e(null, true);
                }
            } else if (z || this.ijL) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.iah.a(this.hYj, aVar);
                try {
                    bWY().az(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWY = bWY();
                    if (a != null) {
                        aVar = a;
                    }
                    bWY.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String bWW() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
