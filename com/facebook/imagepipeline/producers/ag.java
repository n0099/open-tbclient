package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ihu;
    private final com.facebook.imagepipeline.c.f imn;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ipF;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.ihu = tVar;
        this.imn = fVar;
        this.ipF = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al bYR = ajVar.bYR();
        String id = ajVar.getId();
        ImageRequest bYQ = ajVar.bYQ();
        Object bUt = ajVar.bUt();
        com.facebook.imagepipeline.request.b bZN = bYQ.bZN();
        if (bZN == null || bZN.bZV() == null) {
            this.ipF.a(jVar, ajVar);
            return;
        }
        bYR.db(id, bZb());
        com.facebook.cache.common.b b = this.imn.b(bYQ, bUt);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH = this.ihu.aH(b);
        if (aH != null) {
            bYR.a(id, bZb(), bYR.zl(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.az(1.0f);
            jVar.e(aH, true);
            aH.close();
            return;
        }
        a aVar = new a(jVar, b, bZN instanceof com.facebook.imagepipeline.request.c, this.ihu);
        bYR.a(id, bZb(), bYR.zl(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.ipF.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b ifw;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ihu;
        private final boolean iqX;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.ifw = bVar;
            this.iqX = z;
            this.ihu = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    bZd().e(null, true);
                }
            } else if (z || this.iqX) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.ihu.a(this.ifw, aVar);
                try {
                    bZd().az(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZd = bZd();
                    if (a != null) {
                        aVar = a;
                    }
                    bZd.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String bZb() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
