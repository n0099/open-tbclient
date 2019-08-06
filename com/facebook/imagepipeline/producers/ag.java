package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kbW;
    private final com.facebook.imagepipeline.c.f kgV;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kkp;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.kbW = tVar;
        this.kgV = fVar;
        this.kkp = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cKX = ajVar.cKX();
        String id = ajVar.getId();
        ImageRequest cKW = ajVar.cKW();
        Object cGp = ajVar.cGp();
        com.facebook.imagepipeline.request.b cLT = cKW.cLT();
        if (cLT == null || cLT.cMb() == null) {
            this.kkp.a(jVar, ajVar);
            return;
        }
        cKX.eA(id, cLh());
        com.facebook.cache.common.b b = this.kgV.b(cKW, cGp);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.kbW.aV(b);
        if (aV != null) {
            cKX.a(id, cLh(), cKX.HQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.aR(1.0f);
            jVar.e(aV, true);
            aV.close();
            return;
        }
        a aVar = new a(jVar, b, cLT instanceof com.facebook.imagepipeline.request.c, this.kbW);
        cKX.a(id, cLh(), cKX.HQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kkp.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b kaa;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kbW;
        private final boolean klH;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.kaa = bVar;
            this.klH = z;
            this.kbW = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    cLj().e(null, true);
                }
            } else if (z || this.klH) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.kbW.a(this.kaa, aVar);
                try {
                    cLj().aR(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cLj = cLj();
                    if (a != null) {
                        aVar = a;
                    }
                    cLj.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String cLh() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
