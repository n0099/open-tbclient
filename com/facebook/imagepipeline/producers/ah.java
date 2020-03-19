package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lLL;
    private final com.facebook.imagepipeline.c.f lTR;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lWS;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lLL = pVar;
        this.lTR = fVar;
        this.lWS = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am drW = akVar.drW();
        String id = akVar.getId();
        ImageRequest drV = akVar.drV();
        Object dmD = akVar.dmD();
        com.facebook.imagepipeline.request.b dsX = drV.dsX();
        if (dsX == null || dsX.drU() == null) {
            this.lWS.c(kVar, akVar);
            return;
        }
        drW.fk(id, dsf());
        com.facebook.cache.common.b b = this.lTR.b(drV, dmD);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.lLL.bn(b);
        if (bn != null) {
            drW.a(id, dsf(), drW.Pe(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            drW.D(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aK(1.0f);
            kVar.g(bn, 1);
            bn.close();
            return;
        }
        a aVar = new a(kVar, b, dsX instanceof com.facebook.imagepipeline.request.c, this.lLL, akVar.drV().dsV());
        drW.a(id, dsf(), drW.Pe(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lWS.c(aVar, akVar);
    }

    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b lJK;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lLL;
        private final boolean lYl;
        private final boolean lYm;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.lJK = bVar;
            this.lYl = z;
            this.lLL = pVar;
            this.lYm = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (IP(i)) {
                    dsh().g(null, i);
                }
            } else if (!IQ(i) || this.lYl) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.lYm ? this.lLL.a(this.lJK, aVar) : null;
                try {
                    dsh().aK(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsh = dsh();
                    if (a != null) {
                        aVar = a;
                    }
                    dsh.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dsf() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
