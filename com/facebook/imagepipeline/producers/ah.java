package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oDr;
    private final com.facebook.imagepipeline.c.f oLK;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oOJ;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.oDr = pVar;
        this.oLK = fVar;
        this.oOJ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am eng = akVar.eng();
        String id = akVar.getId();
        ImageRequest enf = akVar.enf();
        Object ehK = akVar.ehK();
        com.facebook.imagepipeline.request.b eog = enf.eog();
        if (eog == null || eog.ene() == null) {
            this.oOJ.c(kVar, akVar);
            return;
        }
        eng.gX(id, enp());
        com.facebook.cache.common.b b = this.oLK.b(enf, ehK);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bu = this.oDr.bu(b);
        if (bu != null) {
            eng.a(id, enp(), eng.XI(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            eng.G(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aL(1.0f);
            kVar.h(bu, 1);
            bu.close();
            return;
        }
        a aVar = new a(kVar, b, eog instanceof com.facebook.imagepipeline.request.c, this.oDr, akVar.enf().eoe());
        eng.a(id, enp(), eng.XI(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.oOJ.c(aVar, akVar);
    }

    /* loaded from: classes18.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b oBr;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oDr;
        private final boolean oQc;
        private final boolean oQd;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.oBr = bVar;
            this.oQc = z;
            this.oDr = pVar;
            this.oQd = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Pn(i)) {
                    enr().h(null, i);
                }
            } else if (!Po(i) || this.oQc) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a2 = this.oQd ? this.oDr.a(this.oBr, aVar) : null;
                try {
                    enr().aL(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> enr = enr();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    enr.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String enp() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
