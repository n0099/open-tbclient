package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lJl;
    private final com.facebook.imagepipeline.c.f lRr;
    private final aj<com.facebook.imagepipeline.g.e> lUs;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lJl = pVar;
        this.lRr = fVar;
        this.lUs = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dqk = akVar.dqk();
        dqk.fe(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.lRr.c(akVar.dqj(), akVar.dkQ());
        com.facebook.common.references.a<PooledByteBuffer> bl = this.lJl.bl(c);
        try {
            if (bl != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bl);
                dqk.a(id, "EncodedMemoryCacheProducer", dqk.OQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dqk.C(id, "EncodedMemoryCacheProducer", true);
                kVar.aL(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dql().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dqk.a(id, "EncodedMemoryCacheProducer", dqk.OQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dqk.C(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.lJl, c, akVar.dqj().drj());
                dqk.a(id, "EncodedMemoryCacheProducer", dqk.OQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.lUs.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bl);
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lJl;
        private final com.facebook.cache.common.b lUV;
        private final boolean lUW;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.lJl = pVar;
            this.lUV = bVar;
            this.lUW = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IF(i) || eVar == null || dy(i, 10)) {
                dqv().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dpk = eVar.dpk();
            if (dpk != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.lUW) {
                        aVar = this.lJl.a(this.lUV, dpk);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dqv().aL(1.0f);
                                dqv().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dpk);
                }
            }
            dqv().g(eVar, i);
        }
    }
}
