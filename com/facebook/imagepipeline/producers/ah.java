package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nmn;
    private final com.facebook.imagepipeline.c.f nuK;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nxL;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.nmn = pVar;
        this.nuK = fVar;
        this.nxL = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dVp = akVar.dVp();
        String id = akVar.getId();
        ImageRequest dVo = akVar.dVo();
        Object dPU = akVar.dPU();
        com.facebook.imagepipeline.request.b dWo = dVo.dWo();
        if (dWo == null || dWo.dVn() == null) {
            this.nxL.c(kVar, akVar);
            return;
        }
        dVp.gn(id, dVy());
        com.facebook.cache.common.b b = this.nuK.b(dVo, dPU);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl = this.nmn.bl(b);
        if (bl != null) {
            dVp.a(id, dVy(), dVp.UF(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dVp.F(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aD(1.0f);
            kVar.h(bl, 1);
            bl.close();
            return;
        }
        a aVar = new a(kVar, b, dWo instanceof com.facebook.imagepipeline.request.c, this.nmn, akVar.dVo().dWn());
        dVp.a(id, dVy(), dVp.UF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.nxL.c(aVar, akVar);
    }

    /* loaded from: classes8.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b nkn;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nmn;
        private final boolean nze;
        private final boolean nzf;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.nkn = bVar;
            this.nze = z;
            this.nmn = pVar;
            this.nzf = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Ml(i)) {
                    dVA().h(null, i);
                }
            } else if (!Mm(i) || this.nze) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.nzf ? this.nmn.a(this.nkn, aVar) : null;
                try {
                    dVA().aD(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dVA = dVA();
                    if (a != null) {
                        aVar = a;
                    }
                    dVA.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dVy() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
