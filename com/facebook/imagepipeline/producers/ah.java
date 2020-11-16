package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oOo;
    private final com.facebook.imagepipeline.c.f oWG;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oZF;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.oOo = pVar;
        this.oWG = fVar;
        this.oZF = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am eqU = akVar.eqU();
        String id = akVar.getId();
        ImageRequest eqT = akVar.eqT();
        Object elx = akVar.elx();
        com.facebook.imagepipeline.request.b erT = eqT.erT();
        if (erT == null || erT.eqS() == null) {
            this.oZF.c(kVar, akVar);
            return;
        }
        eqU.gZ(id, erd());
        com.facebook.cache.common.b b = this.oWG.b(eqT, elx);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bv = this.oOo.bv(b);
        if (bv != null) {
            eqU.a(id, erd(), eqU.XX(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            eqU.I(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aU(1.0f);
            kVar.h(bv, 1);
            bv.close();
            return;
        }
        a aVar = new a(kVar, b, erT instanceof com.facebook.imagepipeline.request.c, this.oOo, akVar.eqT().erS());
        eqU.a(id, erd(), eqU.XX(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.oZF.c(aVar, akVar);
    }

    /* loaded from: classes15.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b oMo;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oOo;
        private final boolean pba;
        private final boolean pbb;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.oMo = bVar;
            this.pba = z;
            this.oOo = pVar;
            this.pbb = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Ql(i)) {
                    erf().h(null, i);
                }
            } else if (!Qm(i) || this.pba) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a2 = this.pbb ? this.oOo.a(this.oMo, aVar) : null;
                try {
                    erf().aU(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> erf = erf();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    erf.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String erd() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
