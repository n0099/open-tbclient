package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nLY;
    private final com.facebook.imagepipeline.c.f nUs;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nXr;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.nLY = pVar;
        this.nUs = fVar;
        this.nXr = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am edh = akVar.edh();
        String id = akVar.getId();
        ImageRequest edg = akVar.edg();
        Object dXM = akVar.dXM();
        com.facebook.imagepipeline.request.b eeg = edg.eeg();
        if (eeg == null || eeg.edf() == null) {
            this.nXr.c(kVar, akVar);
            return;
        }
        edh.gH(id, edq());
        com.facebook.cache.common.b b = this.nUs.b(edg, dXM);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bq = this.nLY.bq(b);
        if (bq != null) {
            edh.a(id, edq(), edh.VV(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            edh.F(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aJ(1.0f);
            kVar.h(bq, 1);
            bq.close();
            return;
        }
        a aVar = new a(kVar, b, eeg instanceof com.facebook.imagepipeline.request.c, this.nLY, akVar.edg().eef());
        edh.a(id, edq(), edh.VV(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.nXr.c(aVar, akVar);
    }

    /* loaded from: classes18.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b nJY;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nLY;
        private final boolean nYK;
        private final boolean nYL;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.nJY = bVar;
            this.nYK = z;
            this.nLY = pVar;
            this.nYL = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Nw(i)) {
                    eds().h(null, i);
                }
            } else if (!Nx(i) || this.nYK) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a2 = this.nYL ? this.nLY.a(this.nJY, aVar) : null;
                try {
                    eds().aJ(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> eds = eds();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    eds.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String edq() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
