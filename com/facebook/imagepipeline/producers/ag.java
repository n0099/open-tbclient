package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kaQ;
    private final com.facebook.imagepipeline.c.f kfP;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kjj;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.kaQ = tVar;
        this.kfP = fVar;
        this.kjj = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cKC = ajVar.cKC();
        String id = ajVar.getId();
        ImageRequest cKB = ajVar.cKB();
        Object cFU = ajVar.cFU();
        com.facebook.imagepipeline.request.b cLy = cKB.cLy();
        if (cLy == null || cLy.cLG() == null) {
            this.kjj.a(jVar, ajVar);
            return;
        }
        cKC.eA(id, cKM());
        com.facebook.cache.common.b b = this.kfP.b(cKB, cFU);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.kaQ.aV(b);
        if (aV != null) {
            cKC.a(id, cKM(), cKC.HP(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.aR(1.0f);
            jVar.e(aV, true);
            aV.close();
            return;
        }
        a aVar = new a(jVar, b, cLy instanceof com.facebook.imagepipeline.request.c, this.kaQ);
        cKC.a(id, cKM(), cKC.HP(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kjj.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b jYU;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kaQ;
        private final boolean kkB;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.jYU = bVar;
            this.kkB = z;
            this.kaQ = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    cKO().e(null, true);
                }
            } else if (z || this.kkB) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.kaQ.a(this.jYU, aVar);
                try {
                    cKO().aR(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cKO = cKO();
                    if (a != null) {
                        aVar = a;
                    }
                    cKO.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String cKM() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
