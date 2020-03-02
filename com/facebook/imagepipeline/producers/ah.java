package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJU;
    private final com.facebook.imagepipeline.c.f lSa;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVb;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lJU = pVar;
        this.lSa = fVar;
        this.lVb = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dry = akVar.dry();
        String id = akVar.getId();
        ImageRequest drx = akVar.drx();
        Object dmf = akVar.dmf();
        com.facebook.imagepipeline.request.b dsz = drx.dsz();
        if (dsz == null || dsz.drw() == null) {
            this.lVb.c(kVar, akVar);
            return;
        }
        dry.fm(id, drH());
        com.facebook.cache.common.b b = this.lSa.b(drx, dmf);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.lJU.bn(b);
        if (bn != null) {
            dry.a(id, drH(), dry.Pd(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dry.D(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aK(1.0f);
            kVar.g(bn, 1);
            bn.close();
            return;
        }
        a aVar = new a(kVar, b, dsz instanceof com.facebook.imagepipeline.request.c, this.lJU, akVar.drx().dsx());
        dry.a(id, drH(), dry.Pd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lVb.c(aVar, akVar);
    }

    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b lHT;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJU;
        private final boolean lWu;
        private final boolean lWv;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.lHT = bVar;
            this.lWu = z;
            this.lJU = pVar;
            this.lWv = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (IJ(i)) {
                    drJ().g(null, i);
                }
            } else if (!IK(i) || this.lWu) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.lWv ? this.lJU.a(this.lHT, aVar) : null;
                try {
                    drJ().aK(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> drJ = drJ();
                    if (a != null) {
                        aVar = a;
                    }
                    drJ.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String drH() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
