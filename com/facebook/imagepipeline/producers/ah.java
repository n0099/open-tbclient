package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pAS;
    private final com.facebook.imagepipeline.b.f pIP;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pLO;

    public ah(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pAS = pVar;
        this.pIP = fVar;
        this.pLO = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am ezq = akVar.ezq();
        String id = akVar.getId();
        ImageRequest ezp = akVar.ezp();
        Object eud = akVar.eud();
        com.facebook.imagepipeline.request.b eAn = ezp.eAn();
        if (eAn == null || eAn.ezo() == null) {
            this.pLO.a(kVar, akVar);
            return;
        }
        ezq.hv(id, ezA());
        com.facebook.cache.common.b b2 = this.pIP.b(ezp, eud);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pAS.bu(b2);
        if (bu != null) {
            ezq.b(id, ezA(), ezq.ZG(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            ezq.M(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.ba(1.0f);
            kVar.g(bu, 1);
            bu.close();
            return;
        }
        a aVar = new a(kVar, b2, eAn instanceof com.facebook.imagepipeline.request.c, this.pAS, akVar.ezp().eAm());
        ezq.b(id, ezA(), ezq.ZG(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pLO.a(aVar, akVar);
    }

    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pAS;
        private final boolean pNi;
        private final boolean pNj;
        private final com.facebook.cache.common.b pyV;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, boolean z2) {
            super(kVar);
            this.pyV = bVar;
            this.pNi = z;
            this.pAS = pVar;
            this.pNj = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (aVar == null) {
                if (Qk(i)) {
                    ezC().g(null, i);
                }
            } else if (!Ql(i) || this.pNi) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = this.pNj ? this.pAS.a(this.pyV, aVar) : null;
                try {
                    ezC().ba(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezC = ezC();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    ezC.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String ezA() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
