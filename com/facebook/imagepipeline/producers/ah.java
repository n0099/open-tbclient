package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pCX;
    private final com.facebook.imagepipeline.b.f pKU;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pNT;

    public ah(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pCX = pVar;
        this.pKU = fVar;
        this.pNT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am ezz = akVar.ezz();
        String id = akVar.getId();
        ImageRequest ezy = akVar.ezy();
        Object eum = akVar.eum();
        com.facebook.imagepipeline.request.b eAw = ezy.eAw();
        if (eAw == null || eAw.ezx() == null) {
            this.pNT.a(kVar, akVar);
            return;
        }
        ezz.hv(id, ezJ());
        com.facebook.cache.common.b b = this.pKU.b(ezy, eum);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bw = this.pCX.bw(b);
        if (bw != null) {
            ezz.b(id, ezJ(), ezz.ZM(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            ezz.M(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.be(1.0f);
            kVar.f(bw, 1);
            bw.close();
            return;
        }
        a aVar = new a(kVar, b, eAw instanceof com.facebook.imagepipeline.request.c, this.pCX, akVar.ezy().eAv());
        ezz.b(id, ezJ(), ezz.ZM(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pNT.a(aVar, akVar);
    }

    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final com.facebook.cache.common.b pBa;
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pCX;
        private final boolean pPn;
        private final boolean pPo;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, boolean z2) {
            super(kVar);
            this.pBa = bVar;
            this.pPn = z;
            this.pCX = pVar;
            this.pPo = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (aVar == null) {
                if (Qo(i)) {
                    ezL().f(null, i);
                }
            } else if (!Qp(i) || this.pPn) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = this.pPo ? this.pCX.a(this.pBa, aVar) : null;
                try {
                    ezL().be(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezL = ezL();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    ezL.f(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String ezJ() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
