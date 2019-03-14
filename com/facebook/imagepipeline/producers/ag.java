package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jBy;
    private final com.facebook.imagepipeline.c.f jGx;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jJQ;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jBy = tVar;
        this.jGx = fVar;
        this.jJQ = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al czI = ajVar.czI();
        String id = ajVar.getId();
        ImageRequest czH = ajVar.czH();
        Object cvd = ajVar.cvd();
        com.facebook.imagepipeline.request.b cAE = czH.cAE();
        if (cAE == null || cAE.cAM() == null) {
            this.jJQ.a(jVar, ajVar);
            return;
        }
        czI.el(id, czS());
        com.facebook.cache.common.b b = this.jGx.b(czH, cvd);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aX = this.jBy.aX(b);
        if (aX != null) {
            czI.a(id, czS(), czI.FI(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.aM(1.0f);
            jVar.e(aX, true);
            aX.close();
            return;
        }
        a aVar = new a(jVar, b, cAE instanceof com.facebook.imagepipeline.request.c, this.jBy);
        czI.a(id, czS(), czI.FI(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.jJQ.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jBy;
        private final boolean jLi;
        private final com.facebook.cache.common.b jzB;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.jzB = bVar;
            this.jLi = z;
            this.jBy = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    czU().e(null, true);
                }
            } else if (z || this.jLi) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.jBy.a(this.jzB, aVar);
                try {
                    czU().aM(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> czU = czU();
                    if (a != null) {
                        aVar = a;
                    }
                    czU.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String czS() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
