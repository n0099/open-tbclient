package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTf;
    private final com.facebook.imagepipeline.c.f mbE;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> meD;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lTf = pVar;
        this.mbE = fVar;
        this.meD = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dtU = akVar.dtU();
        String id = akVar.getId();
        ImageRequest dtT = akVar.dtT();
        Object dow = akVar.dow();
        com.facebook.imagepipeline.request.b duT = dtT.duT();
        if (duT == null || duT.dtS() == null) {
            this.meD.c(kVar, akVar);
            return;
        }
        dtU.fi(id, dud());
        com.facebook.cache.common.b b = this.mbE.b(dtT, dow);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bd = this.lTf.bd(b);
        if (bd != null) {
            dtU.a(id, dud(), dtU.Ol(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dtU.D(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.au(1.0f);
            kVar.h(bd, 1);
            bd.close();
            return;
        }
        a aVar = new a(kVar, b, duT instanceof com.facebook.imagepipeline.request.c, this.lTf, akVar.dtT().duS());
        dtU.a(id, dud(), dtU.Ol(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.meD.c(aVar, akVar);
    }

    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b lRf;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTf;
        private final boolean mfW;
        private final boolean mfX;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.lRf = bVar;
            this.mfW = z;
            this.lTf = pVar;
            this.mfX = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Hr(i)) {
                    duf().h(null, i);
                }
            } else if (!Hs(i) || this.mfW) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.mfX ? this.lTf.a(this.lRf, aVar) : null;
                try {
                    duf().au(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> duf = duf();
                    if (a != null) {
                        aVar = a;
                    }
                    duf.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String dud() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
