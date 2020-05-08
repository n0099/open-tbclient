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
        am dtR = akVar.dtR();
        String id = akVar.getId();
        ImageRequest dtQ = akVar.dtQ();
        Object dot = akVar.dot();
        com.facebook.imagepipeline.request.b duQ = dtQ.duQ();
        if (duQ == null || duQ.dtP() == null) {
            this.meH.c(kVar, akVar);
            return;
        }
        dtR.fi(id, dua());
        com.facebook.cache.common.b b = this.mbI.b(dtQ, dot);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> be = this.lTj.be(b);
        if (be != null) {
            dtR.a(id, dua(), dtR.Oo(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dtR.D(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.au(1.0f);
            kVar.h(be, 1);
            be.close();
            return;
        }
        a aVar = new a(kVar, b, duQ instanceof com.facebook.imagepipeline.request.c, this.lTj, akVar.dtQ().duP());
        dtR.a(id, dua(), dtR.Oo(id) ? ImmutableMap.of("cached_value_found", "false") : null);
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
                    duc().h(null, i);
                }
            } else if (!Hs(i) || this.mga) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.mgb ? this.lTj.a(this.lRj, aVar) : null;
                try {
                    duc().au(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> duc = duc();
                    if (a != null) {
                        aVar = a;
                    }
                    duc.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String dua() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
