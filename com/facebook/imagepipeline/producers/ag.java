package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jBn;
    private final com.facebook.imagepipeline.c.f jGm;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jJF;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jBn = tVar;
        this.jGm = fVar;
        this.jJF = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al czv = ajVar.czv();
        String id = ajVar.getId();
        ImageRequest czu = ajVar.czu();
        Object cuQ = ajVar.cuQ();
        com.facebook.imagepipeline.request.b cAr = czu.cAr();
        if (cAr == null || cAr.cAz() == null) {
            this.jJF.a(jVar, ajVar);
            return;
        }
        czv.em(id, czF());
        com.facebook.cache.common.b b = this.jGm.b(czu, cuQ);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aW = this.jBn.aW(b);
        if (aW != null) {
            czv.a(id, czF(), czv.FH(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.aM(1.0f);
            jVar.e(aW, true);
            aW.close();
            return;
        }
        a aVar = new a(jVar, b, cAr instanceof com.facebook.imagepipeline.request.c, this.jBn);
        czv.a(id, czF(), czv.FH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.jJF.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jBn;
        private final boolean jKX;
        private final com.facebook.cache.common.b jzq;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.jzq = bVar;
            this.jKX = z;
            this.jBn = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    czH().e(null, true);
                }
            } else if (z || this.jKX) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.jBn.a(this.jzq, aVar);
                try {
                    czH().aM(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> czH = czH();
                    if (a != null) {
                        aVar = a;
                    }
                    czH.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String czF() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
