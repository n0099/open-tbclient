package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ikE;
    private final com.facebook.imagepipeline.c.f ipy;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isP;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.ikE = tVar;
        this.ipy = fVar;
        this.isP = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al bZI = ajVar.bZI();
        String id = ajVar.getId();
        ImageRequest bZH = ajVar.bZH();
        Object bVk = ajVar.bVk();
        com.facebook.imagepipeline.request.b caE = bZH.caE();
        if (caE == null || caE.caM() == null) {
            this.isP.a(jVar, ajVar);
            return;
        }
        bZI.db(id, bZS());
        com.facebook.cache.common.b b = this.ipy.b(bZH, bVk);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH = this.ikE.aH(b);
        if (aH != null) {
            bZI.a(id, bZS(), bZI.zo(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.az(1.0f);
            jVar.e(aH, true);
            aH.close();
            return;
        }
        a aVar = new a(jVar, b, caE instanceof com.facebook.imagepipeline.request.c, this.ikE);
        bZI.a(id, bZS(), bZI.zo(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.isP.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b iiG;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ikE;
        private final boolean iuh;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.iiG = bVar;
            this.iuh = z;
            this.ikE = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    bZU().e(null, true);
                }
            } else if (z || this.iuh) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.ikE.a(this.iiG, aVar);
                try {
                    bZU().az(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZU = bZU();
                    if (a != null) {
                        aVar = a;
                    }
                    bZU.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String bZS() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
