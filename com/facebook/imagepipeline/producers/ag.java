package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jTJ;
    private final com.facebook.imagepipeline.c.f jYG;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kbZ;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jTJ = tVar;
        this.jYG = fVar;
        this.kbZ = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cHz = ajVar.cHz();
        String id = ajVar.getId();
        ImageRequest cHy = ajVar.cHy();
        Object cCU = ajVar.cCU();
        com.facebook.imagepipeline.request.b cIv = cHy.cIv();
        if (cIv == null || cIv.cID() == null) {
            this.kbZ.a(jVar, ajVar);
            return;
        }
        cHz.ez(id, cHJ());
        com.facebook.cache.common.b b = this.jYG.b(cHy, cCU);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.jTJ.aV(b);
        if (aV != null) {
            cHz.a(id, cHJ(), cHz.GT(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.aQ(1.0f);
            jVar.e(aV, true);
            aV.close();
            return;
        }
        a aVar = new a(jVar, b, cIv instanceof com.facebook.imagepipeline.request.c, this.jTJ);
        cHz.a(id, cHJ(), cHz.GT(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kbZ.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b jRN;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jTJ;
        private final boolean kdr;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.jRN = bVar;
            this.kdr = z;
            this.jTJ = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    cHL().e(null, true);
                }
            } else if (z || this.kdr) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.jTJ.a(this.jRN, aVar);
                try {
                    cHL().aQ(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHL = cHL();
                    if (a != null) {
                        aVar = a;
                    }
                    cHL.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String cHJ() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
