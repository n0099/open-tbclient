package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mnb;
    private final com.facebook.imagepipeline.c.f mvz;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> myy;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mnb = pVar;
        this.mvz = fVar;
        this.myy = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dBj = akVar.dBj();
        String id = akVar.getId();
        ImageRequest dBi = akVar.dBi();
        Object dvM = akVar.dvM();
        com.facebook.imagepipeline.request.b dCi = dBi.dCi();
        if (dCi == null || dCi.dBh() == null) {
            this.myy.c(kVar, akVar);
            return;
        }
        dBj.fK(id, dBs());
        com.facebook.cache.common.b b = this.mvz.b(dBi, dvM);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bi = this.mnb.bi(b);
        if (bi != null) {
            dBj.a(id, dBs(), dBj.Qc(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dBj.F(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.at(1.0f);
            kVar.h(bi, 1);
            bi.close();
            return;
        }
        a aVar = new a(kVar, b, dCi instanceof com.facebook.imagepipeline.request.c, this.mnb, akVar.dBi().dCh());
        dBj.a(id, dBs(), dBj.Qc(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.myy.c(aVar, akVar);
    }

    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b mlb;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mnb;
        private final boolean mzR;
        private final boolean mzS;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.mlb = bVar;
            this.mzR = z;
            this.mnb = pVar;
            this.mzS = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Id(i)) {
                    dBu().h(null, i);
                }
            } else if (!Ie(i) || this.mzR) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.mzS ? this.mnb.a(this.mlb, aVar) : null;
                try {
                    dBu().at(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dBu = dBu();
                    if (a != null) {
                        aVar = a;
                    }
                    dBu.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dBs() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
