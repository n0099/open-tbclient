package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lJg;
    private final com.facebook.imagepipeline.c.f lRm;
    private final aj<com.facebook.imagepipeline.g.e> lUn;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lJg = pVar;
        this.lRm = fVar;
        this.lUn = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dqi = akVar.dqi();
        dqi.fe(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.lRm.c(akVar.dqh(), akVar.dkO());
        com.facebook.common.references.a<PooledByteBuffer> bl = this.lJg.bl(c);
        try {
            if (bl != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bl);
                dqi.a(id, "EncodedMemoryCacheProducer", dqi.OQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dqi.C(id, "EncodedMemoryCacheProducer", true);
                kVar.aL(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dqj().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dqi.a(id, "EncodedMemoryCacheProducer", dqi.OQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dqi.C(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.lJg, c, akVar.dqh().drh());
                dqi.a(id, "EncodedMemoryCacheProducer", dqi.OQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.lUn.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bl);
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lJg;
        private final com.facebook.cache.common.b lUQ;
        private final boolean lUR;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.lJg = pVar;
            this.lUQ = bVar;
            this.lUR = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IF(i) || eVar == null || dy(i, 10)) {
                dqt().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dpi = eVar.dpi();
            if (dpi != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.lUR) {
                        aVar = this.lJg.a(this.lUQ, dpi);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dqt().aL(1.0f);
                                dqt().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dpi);
                }
            }
            dqt().g(eVar, i);
        }
    }
}
