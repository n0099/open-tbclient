package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ket;
    private final com.facebook.imagepipeline.c.f kjt;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kmM;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.ket = tVar;
        this.kjt = fVar;
        this.kmM = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cLL = ajVar.cLL();
        String id = ajVar.getId();
        ImageRequest cLK = ajVar.cLK();
        Object cHd = ajVar.cHd();
        com.facebook.imagepipeline.request.b cMH = cLK.cMH();
        if (cMH == null || cMH.cMP() == null) {
            this.kmM.a(jVar, ajVar);
            return;
        }
        cLL.eB(id, cLV());
        com.facebook.cache.common.b b = this.kjt.b(cLK, cHd);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.ket.aV(b);
        if (aV != null) {
            cLL.a(id, cLV(), cLL.Iq(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.aS(1.0f);
            jVar.e(aV, true);
            aV.close();
            return;
        }
        a aVar = new a(jVar, b, cMH instanceof com.facebook.imagepipeline.request.c, this.ket);
        cLL.a(id, cLV(), cLL.Iq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kmM.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b kcx;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ket;
        private final boolean koe;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.kcx = bVar;
            this.koe = z;
            this.ket = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    cLX().e(null, true);
                }
            } else if (z || this.koe) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.ket.a(this.kcx, aVar);
                try {
                    cLX().aS(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cLX = cLX();
                    if (a != null) {
                        aVar = a;
                    }
                    cLX.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String cLV() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
