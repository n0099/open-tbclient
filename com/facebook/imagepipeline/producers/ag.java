package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kbL;
    private final com.facebook.imagepipeline.c.f kgN;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kkh;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.kbL = tVar;
        this.kgN = fVar;
        this.kkh = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cIG = ajVar.cIG();
        String id = ajVar.getId();
        ImageRequest cIF = ajVar.cIF();
        Object cDZ = ajVar.cDZ();
        com.facebook.imagepipeline.request.b cJC = cIF.cJC();
        if (cJC == null || cJC.cJK() == null) {
            this.kkh.a(jVar, ajVar);
            return;
        }
        cIG.en(id, cIQ());
        com.facebook.cache.common.b b = this.kgN.b(cIF, cDZ);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aQ = this.kbL.aQ(b);
        if (aQ != null) {
            cIG.a(id, cIQ(), cIG.GH(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.av(1.0f);
            jVar.f(aQ, true);
            aQ.close();
            return;
        }
        a aVar = new a(jVar, b, cJC instanceof com.facebook.imagepipeline.request.c, this.kbL);
        cIG.a(id, cIQ(), cIG.GH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kkh.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b jZP;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kbL;
        private final boolean klz;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.jZP = bVar;
            this.klz = z;
            this.kbL = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    cIS().f(null, true);
                }
            } else if (z || this.klz) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.kbL.a(this.jZP, aVar);
                try {
                    cIS().av(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cIS = cIS();
                    if (a != null) {
                        aVar = a;
                    }
                    cIS.f(aVar, z);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String cIQ() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
