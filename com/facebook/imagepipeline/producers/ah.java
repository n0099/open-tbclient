package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJg;
    private final com.facebook.imagepipeline.c.f lRm;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUn;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lJg = pVar;
        this.lRm = fVar;
        this.lUn = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dqi = akVar.dqi();
        String id = akVar.getId();
        ImageRequest dqh = akVar.dqh();
        Object dkO = akVar.dkO();
        com.facebook.imagepipeline.request.b drj = dqh.drj();
        if (drj == null || drj.dqg() == null) {
            this.lUn.c(kVar, akVar);
            return;
        }
        dqi.fe(id, dqr());
        com.facebook.cache.common.b b = this.lRm.b(dqh, dkO);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl = this.lJg.bl(b);
        if (bl != null) {
            dqi.a(id, dqr(), dqi.OQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dqi.C(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aL(1.0f);
            kVar.g(bl, 1);
            bl.close();
            return;
        }
        a aVar = new a(kVar, b, drj instanceof com.facebook.imagepipeline.request.c, this.lJg, akVar.dqh().drh());
        dqi.a(id, dqr(), dqi.OQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lUn.c(aVar, akVar);
    }

    /* loaded from: classes10.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b lHf;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJg;
        private final boolean lVG;
        private final boolean lVH;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.lHf = bVar;
            this.lVG = z;
            this.lJg = pVar;
            this.lVH = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (IE(i)) {
                    dqt().g(null, i);
                }
            } else if (!IF(i) || this.lVG) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.lVH ? this.lJg.a(this.lHf, aVar) : null;
                try {
                    dqt().aL(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqt = dqt();
                    if (a != null) {
                        aVar = a;
                    }
                    dqt.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dqr() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
