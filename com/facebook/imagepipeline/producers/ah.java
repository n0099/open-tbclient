package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSs;
    private final com.facebook.imagepipeline.c.f naS;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ndT;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mSs = pVar;
        this.naS = fVar;
        this.ndT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dJp = akVar.dJp();
        String id = akVar.getId();
        ImageRequest dJo = akVar.dJo();
        Object dDT = akVar.dDT();
        com.facebook.imagepipeline.request.b dKo = dJo.dKo();
        if (dKo == null || dKo.dJn() == null) {
            this.ndT.c(kVar, akVar);
            return;
        }
        dJp.fW(id, dJy());
        com.facebook.cache.common.b b = this.naS.b(dJo, dDT);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj = this.mSs.bj(b);
        if (bj != null) {
            dJp.a(id, dJy(), dJp.RB(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dJp.G(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.ax(1.0f);
            kVar.h(bj, 1);
            bj.close();
            return;
        }
        a aVar = new a(kVar, b, dKo instanceof com.facebook.imagepipeline.request.c, this.mSs, akVar.dJo().dKn());
        dJp.a(id, dJy(), dJp.RB(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.ndT.c(aVar, akVar);
    }

    /* loaded from: classes4.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b mQq;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSs;
        private final boolean nfn;
        private final boolean nfo;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.mQq = bVar;
            this.nfn = z;
            this.mSs = pVar;
            this.nfo = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (JH(i)) {
                    dJA().h(null, i);
                }
            } else if (!JI(i) || this.nfn) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.nfo ? this.mSs.a(this.mQq, aVar) : null;
                try {
                    dJA().ax(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dJA = dJA();
                    if (a != null) {
                        aVar = a;
                    }
                    dJA.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dJy() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
