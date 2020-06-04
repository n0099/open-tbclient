package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mol;
    private final com.facebook.imagepipeline.c.f mwJ;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mzI;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mol = pVar;
        this.mwJ = fVar;
        this.mzI = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dBx = akVar.dBx();
        String id = akVar.getId();
        ImageRequest dBw = akVar.dBw();
        Object dwa = akVar.dwa();
        com.facebook.imagepipeline.request.b dCw = dBw.dCw();
        if (dCw == null || dCw.dBv() == null) {
            this.mzI.c(kVar, akVar);
            return;
        }
        dBx.fK(id, dBG());
        com.facebook.cache.common.b b = this.mwJ.b(dBw, dwa);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bi = this.mol.bi(b);
        if (bi != null) {
            dBx.a(id, dBG(), dBx.Qd(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dBx.F(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.at(1.0f);
            kVar.h(bi, 1);
            bi.close();
            return;
        }
        a aVar = new a(kVar, b, dCw instanceof com.facebook.imagepipeline.request.c, this.mol, akVar.dBw().dCv());
        dBx.a(id, dBG(), dBx.Qd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.mzI.c(aVar, akVar);
    }

    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final boolean mBb;
        private final boolean mBc;
        private final com.facebook.cache.common.b mml;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mol;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.mml = bVar;
            this.mBb = z;
            this.mol = pVar;
            this.mBc = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (If(i)) {
                    dBI().h(null, i);
                }
            } else if (!Ig(i) || this.mBb) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.mBc ? this.mol.a(this.mml, aVar) : null;
                try {
                    dBI().at(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dBI = dBI();
                    if (a != null) {
                        aVar = a;
                    }
                    dBI.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dBG() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
