package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kcC;
    private final com.facebook.imagepipeline.c.f khE;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kkY;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.kcC = tVar;
        this.khE = fVar;
        this.kkY = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cII = ajVar.cII();
        String id = ajVar.getId();
        ImageRequest cIH = ajVar.cIH();
        Object cEb = ajVar.cEb();
        com.facebook.imagepipeline.request.b cJE = cIH.cJE();
        if (cJE == null || cJE.cJM() == null) {
            this.kkY.a(jVar, ajVar);
            return;
        }
        cII.en(id, cIS());
        com.facebook.cache.common.b b = this.khE.b(cIH, cEb);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aQ = this.kcC.aQ(b);
        if (aQ != null) {
            cII.a(id, cIS(), cII.GH(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.av(1.0f);
            jVar.f(aQ, true);
            aQ.close();
            return;
        }
        a aVar = new a(jVar, b, cJE instanceof com.facebook.imagepipeline.request.c, this.kcC);
        cII.a(id, cIS(), cII.GH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kkY.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b kaG;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kcC;
        private final boolean kmq;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.kaG = bVar;
            this.kmq = z;
            this.kcC = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    cIU().f(null, true);
                }
            } else if (z || this.kmq) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.kcC.a(this.kaG, aVar);
                try {
                    cIU().av(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cIU = cIU();
                    if (a != null) {
                        aVar = a;
                    }
                    cIU.f(aVar, z);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String cIS() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
