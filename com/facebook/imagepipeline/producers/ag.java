package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jBG;
    private final com.facebook.imagepipeline.c.f jGF;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jJY;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jBG = tVar;
        this.jGF = fVar;
        this.jJY = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al czF = ajVar.czF();
        String id = ajVar.getId();
        ImageRequest czE = ajVar.czE();
        Object cva = ajVar.cva();
        com.facebook.imagepipeline.request.b cAB = czE.cAB();
        if (cAB == null || cAB.cAJ() == null) {
            this.jJY.a(jVar, ajVar);
            return;
        }
        czF.em(id, czP());
        com.facebook.cache.common.b b = this.jGF.b(czE, cva);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aX = this.jBG.aX(b);
        if (aX != null) {
            czF.a(id, czP(), czF.FK(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.aM(1.0f);
            jVar.e(aX, true);
            aX.close();
            return;
        }
        a aVar = new a(jVar, b, cAB instanceof com.facebook.imagepipeline.request.c, this.jBG);
        czF.a(id, czP(), czF.FK(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.jJY.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jBG;
        private final boolean jLq;
        private final com.facebook.cache.common.b jzJ;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.jzJ = bVar;
            this.jLq = z;
            this.jBG = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    czR().e(null, true);
                }
            } else if (z || this.jLq) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.jBG.a(this.jzJ, aVar);
                try {
                    czR().aM(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> czR = czR();
                    if (a != null) {
                        aVar = a;
                    }
                    czR.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String czP() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
