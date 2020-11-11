package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oMK;
    private final com.facebook.imagepipeline.c.f oVd;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oYc;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.oMK = pVar;
        this.oVd = fVar;
        this.oYc = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am eqW = akVar.eqW();
        String id = akVar.getId();
        ImageRequest eqV = akVar.eqV();
        Object elz = akVar.elz();
        com.facebook.imagepipeline.request.b erV = eqV.erV();
        if (erV == null || erV.eqU() == null) {
            this.oYc.c(kVar, akVar);
            return;
        }
        eqW.gZ(id, erf());
        com.facebook.cache.common.b b = this.oVd.b(eqV, elz);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bu = this.oMK.bu(b);
        if (bu != null) {
            eqW.a(id, erf(), eqW.Ym(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            eqW.H(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aN(1.0f);
            kVar.h(bu, 1);
            bu.close();
            return;
        }
        a aVar = new a(kVar, b, erV instanceof com.facebook.imagepipeline.request.c, this.oMK, akVar.eqV().erU());
        eqW.a(id, erf(), eqW.Ym(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.oYc.c(aVar, akVar);
    }

    /* loaded from: classes18.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b oKK;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oMK;
        private final boolean oZv;
        private final boolean oZw;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.oKK = bVar;
            this.oZv = z;
            this.oMK = pVar;
            this.oZw = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (PI(i)) {
                    erh().h(null, i);
                }
            } else if (!PJ(i) || this.oZv) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a2 = this.oZw ? this.oMK.a(this.oKK, aVar) : null;
                try {
                    erh().aN(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> erh = erh();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    erh.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String erf() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
