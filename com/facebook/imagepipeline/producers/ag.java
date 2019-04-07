package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jAS;
    private final com.facebook.imagepipeline.c.f jFR;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jJk;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jAS = tVar;
        this.jFR = fVar;
        this.jJk = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al czB = ajVar.czB();
        String id = ajVar.getId();
        ImageRequest czA = ajVar.czA();
        Object cuW = ajVar.cuW();
        com.facebook.imagepipeline.request.b cAx = czA.cAx();
        if (cAx == null || cAx.cAF() == null) {
            this.jJk.a(jVar, ajVar);
            return;
        }
        czB.em(id, czL());
        com.facebook.cache.common.b b = this.jFR.b(czA, cuW);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aT = this.jAS.aT(b);
        if (aT != null) {
            czB.a(id, czL(), czB.Fy(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.aM(1.0f);
            jVar.e(aT, true);
            aT.close();
            return;
        }
        a aVar = new a(jVar, b, cAx instanceof com.facebook.imagepipeline.request.c, this.jAS);
        czB.a(id, czL(), czB.Fy(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.jJk.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jAS;
        private final boolean jKC;
        private final com.facebook.cache.common.b jyV;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.jyV = bVar;
            this.jKC = z;
            this.jAS = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    czN().e(null, true);
                }
            } else if (z || this.jKC) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.jAS.a(this.jyV, aVar);
                try {
                    czN().aM(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> czN = czN();
                    if (a != null) {
                        aVar = a;
                    }
                    czN.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String czL() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
