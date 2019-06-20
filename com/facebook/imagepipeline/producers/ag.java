package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jTM;
    private final com.facebook.imagepipeline.c.f jYJ;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kcc;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jTM = tVar;
        this.jYJ = fVar;
        this.kcc = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cHy = ajVar.cHy();
        String id = ajVar.getId();
        ImageRequest cHx = ajVar.cHx();
        Object cCT = ajVar.cCT();
        com.facebook.imagepipeline.request.b cIu = cHx.cIu();
        if (cIu == null || cIu.cIC() == null) {
            this.kcc.a(jVar, ajVar);
            return;
        }
        cHy.ez(id, cHI());
        com.facebook.cache.common.b b = this.jYJ.b(cHx, cCT);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.jTM.aV(b);
        if (aV != null) {
            cHy.a(id, cHI(), cHy.GV(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.aQ(1.0f);
            jVar.e(aV, true);
            aV.close();
            return;
        }
        a aVar = new a(jVar, b, cIu instanceof com.facebook.imagepipeline.request.c, this.jTM);
        cHy.a(id, cHI(), cHy.GV(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kcc.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b jRQ;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jTM;
        private final boolean kdu;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.jRQ = bVar;
            this.kdu = z;
            this.jTM = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    cHK().e(null, true);
                }
            } else if (z || this.kdu) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.jTM.a(this.jRQ, aVar);
                try {
                    cHK().aQ(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHK = cHK();
                    if (a != null) {
                        aVar = a;
                    }
                    cHK.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String cHI() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
