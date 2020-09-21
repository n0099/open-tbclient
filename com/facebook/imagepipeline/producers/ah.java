package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes25.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.f nEZ;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nIa;
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nwF;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.nwF = pVar;
        this.nEZ = fVar;
        this.nIa = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dZw = akVar.dZw();
        String id = akVar.getId();
        ImageRequest dZv = akVar.dZv();
        Object dUb = akVar.dUb();
        com.facebook.imagepipeline.request.b eav = dZv.eav();
        if (eav == null || eav.dZu() == null) {
            this.nIa.c(kVar, akVar);
            return;
        }
        dZw.gA(id, dZF());
        com.facebook.cache.common.b b = this.nEZ.b(dZv, dUb);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.nwF.bn(b);
        if (bn != null) {
            dZw.a(id, dZF(), dZw.Vh(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dZw.F(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aD(1.0f);
            kVar.h(bn, 1);
            bn.close();
            return;
        }
        a aVar = new a(kVar, b, eav instanceof com.facebook.imagepipeline.request.c, this.nwF, akVar.dZv().eau());
        dZw.a(id, dZF(), dZw.Vh(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.nIa.c(aVar, akVar);
    }

    /* loaded from: classes25.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final boolean nJt;
        private final boolean nJu;
        private final com.facebook.cache.common.b nuF;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nwF;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.nuF = bVar;
            this.nJt = z;
            this.nwF = pVar;
            this.nJu = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (MQ(i)) {
                    dZH().h(null, i);
                }
            } else if (!MR(i) || this.nJt) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.nJu ? this.nwF.a(this.nuF, aVar) : null;
                try {
                    dZH().aD(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dZH = dZH();
                    if (a != null) {
                        aVar = a;
                    }
                    dZH.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dZF() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
