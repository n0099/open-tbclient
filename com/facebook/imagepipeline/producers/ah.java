package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJl;
    private final com.facebook.imagepipeline.c.f lRr;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUs;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lJl = pVar;
        this.lRr = fVar;
        this.lUs = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dqk = akVar.dqk();
        String id = akVar.getId();
        ImageRequest dqj = akVar.dqj();
        Object dkQ = akVar.dkQ();
        com.facebook.imagepipeline.request.b drl = dqj.drl();
        if (drl == null || drl.dqi() == null) {
            this.lUs.c(kVar, akVar);
            return;
        }
        dqk.fe(id, dqt());
        com.facebook.cache.common.b b = this.lRr.b(dqj, dkQ);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl = this.lJl.bl(b);
        if (bl != null) {
            dqk.a(id, dqt(), dqk.OQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dqk.C(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aL(1.0f);
            kVar.g(bl, 1);
            bl.close();
            return;
        }
        a aVar = new a(kVar, b, drl instanceof com.facebook.imagepipeline.request.c, this.lJl, akVar.dqj().drj());
        dqk.a(id, dqt(), dqk.OQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lUs.c(aVar, akVar);
    }

    /* loaded from: classes10.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b lHk;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJl;
        private final boolean lVL;
        private final boolean lVM;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.lHk = bVar;
            this.lVL = z;
            this.lJl = pVar;
            this.lVM = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (IE(i)) {
                    dqv().g(null, i);
                }
            } else if (!IF(i) || this.lVL) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.lVM ? this.lJl.a(this.lHk, aVar) : null;
                try {
                    dqv().aL(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqv = dqv();
                    if (a != null) {
                        aVar = a;
                    }
                    dqv.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dqt() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
