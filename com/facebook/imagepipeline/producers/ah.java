package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nmF;
    private final com.facebook.imagepipeline.c.f nvc;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nyd;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.nmF = pVar;
        this.nvc = fVar;
        this.nyd = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dVy = akVar.dVy();
        String id = akVar.getId();
        ImageRequest dVx = akVar.dVx();
        Object dQd = akVar.dQd();
        com.facebook.imagepipeline.request.b dWx = dVx.dWx();
        if (dWx == null || dWx.dVw() == null) {
            this.nyd.c(kVar, akVar);
            return;
        }
        dVy.go(id, dVH());
        com.facebook.cache.common.b b = this.nvc.b(dVx, dQd);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl = this.nmF.bl(b);
        if (bl != null) {
            dVy.a(id, dVH(), dVy.UF(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dVy.F(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aD(1.0f);
            kVar.h(bl, 1);
            bl.close();
            return;
        }
        a aVar = new a(kVar, b, dWx instanceof com.facebook.imagepipeline.request.c, this.nmF, akVar.dVx().dWw());
        dVy.a(id, dVH(), dVy.UF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.nyd.c(aVar, akVar);
    }

    /* loaded from: classes8.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b nkF;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nmF;
        private final boolean nzw;
        private final boolean nzx;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.nkF = bVar;
            this.nzw = z;
            this.nmF = pVar;
            this.nzx = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Ml(i)) {
                    dVJ().h(null, i);
                }
            } else if (!Mm(i) || this.nzw) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.nzx ? this.nmF.a(this.nkF, aVar) : null;
                try {
                    dVJ().aD(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dVJ = dVJ();
                    if (a != null) {
                        aVar = a;
                    }
                    dVJ.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dVH() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
