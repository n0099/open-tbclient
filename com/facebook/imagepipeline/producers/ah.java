package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTj;
    private final com.facebook.imagepipeline.c.f mbI;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> meH;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lTj = pVar;
        this.mbI = fVar;
        this.meH = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dtS = akVar.dtS();
        String id = akVar.getId();
        ImageRequest dtR = akVar.dtR();
        Object dou = akVar.dou();
        com.facebook.imagepipeline.request.b duR = dtR.duR();
        if (duR == null || duR.dtQ() == null) {
            this.meH.c(kVar, akVar);
            return;
        }
        dtS.fi(id, dub());
        com.facebook.cache.common.b b = this.mbI.b(dtR, dou);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> be = this.lTj.be(b);
        if (be != null) {
            dtS.a(id, dub(), dtS.Oo(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dtS.D(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.au(1.0f);
            kVar.h(be, 1);
            be.close();
            return;
        }
        a aVar = new a(kVar, b, duR instanceof com.facebook.imagepipeline.request.c, this.lTj, akVar.dtR().duQ());
        dtS.a(id, dub(), dtS.Oo(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.meH.c(aVar, akVar);
    }

    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b lRj;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTj;
        private final boolean mga;
        private final boolean mgb;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.lRj = bVar;
            this.mga = z;
            this.lTj = pVar;
            this.mgb = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Hr(i)) {
                    dud().h(null, i);
                }
            } else if (!Hs(i) || this.mga) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.mgb ? this.lTj.a(this.lRj, aVar) : null;
                try {
                    dud().au(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dud = dud();
                    if (a != null) {
                        aVar = a;
                    }
                    dud.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String dub() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
