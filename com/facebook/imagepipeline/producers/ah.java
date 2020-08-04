package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSu;
    private final com.facebook.imagepipeline.c.f naU;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ndV;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mSu = pVar;
        this.naU = fVar;
        this.ndV = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dJq = akVar.dJq();
        String id = akVar.getId();
        ImageRequest dJp = akVar.dJp();
        Object dDU = akVar.dDU();
        com.facebook.imagepipeline.request.b dKp = dJp.dKp();
        if (dKp == null || dKp.dJo() == null) {
            this.ndV.c(kVar, akVar);
            return;
        }
        dJq.fW(id, dJz());
        com.facebook.cache.common.b b = this.naU.b(dJp, dDU);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj = this.mSu.bj(b);
        if (bj != null) {
            dJq.a(id, dJz(), dJq.RB(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dJq.G(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.ax(1.0f);
            kVar.h(bj, 1);
            bj.close();
            return;
        }
        a aVar = new a(kVar, b, dKp instanceof com.facebook.imagepipeline.request.c, this.mSu, akVar.dJp().dKo());
        dJq.a(id, dJz(), dJq.RB(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.ndV.c(aVar, akVar);
    }

    /* loaded from: classes4.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b mQs;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSu;
        private final boolean nfp;
        private final boolean nfq;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.mQs = bVar;
            this.nfp = z;
            this.mSu = pVar;
            this.nfq = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (JH(i)) {
                    dJB().h(null, i);
                }
            } else if (!JI(i) || this.nfp) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.nfq ? this.mSu.a(this.mQs, aVar) : null;
                try {
                    dJB().ax(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dJB = dJB();
                    if (a != null) {
                        aVar = a;
                    }
                    dJB.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dJz() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
