package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jTI;
    private final com.facebook.imagepipeline.c.f jYF;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kbY;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jTI = tVar;
        this.jYF = fVar;
        this.kbY = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cHx = ajVar.cHx();
        String id = ajVar.getId();
        ImageRequest cHw = ajVar.cHw();
        Object cCS = ajVar.cCS();
        com.facebook.imagepipeline.request.b cIt = cHw.cIt();
        if (cIt == null || cIt.cIB() == null) {
            this.kbY.a(jVar, ajVar);
            return;
        }
        cHx.ez(id, cHH());
        com.facebook.cache.common.b b = this.jYF.b(cHw, cCS);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.jTI.aV(b);
        if (aV != null) {
            cHx.a(id, cHH(), cHx.GT(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.aQ(1.0f);
            jVar.e(aV, true);
            aV.close();
            return;
        }
        a aVar = new a(jVar, b, cIt instanceof com.facebook.imagepipeline.request.c, this.jTI);
        cHx.a(id, cHH(), cHx.GT(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kbY.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b jRM;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jTI;
        private final boolean kdq;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.jRM = bVar;
            this.kdq = z;
            this.jTI = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    cHJ().e(null, true);
                }
            } else if (z || this.kdq) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.jTI.a(this.jRM, aVar);
                try {
                    cHJ().aQ(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHJ = cHJ();
                    if (a != null) {
                        aVar = a;
                    }
                    cHJ.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String cHH() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
