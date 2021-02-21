package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class s implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pAS;
    private final com.facebook.imagepipeline.b.f pIP;
    private final aj<com.facebook.imagepipeline.f.e> pLO;

    public s(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pAS = pVar;
        this.pIP = fVar;
        this.pLO = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        String id = akVar.getId();
        am ezq = akVar.ezq();
        ezq.hv(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.pIP.c(akVar.ezp(), akVar.eud());
        com.facebook.common.references.a<PooledByteBuffer> bu = this.pAS.bu(c);
        try {
            if (bu != null) {
                com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(bu);
                ezq.b(id, "EncodedMemoryCacheProducer", ezq.ZG(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                ezq.M(id, "EncodedMemoryCacheProducer", true);
                kVar.ba(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
            } else if (akVar.ezr().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                ezq.b(id, "EncodedMemoryCacheProducer", ezq.ZG(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                ezq.M(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.pAS, c, akVar.ezp().eAm());
                ezq.b(id, "EncodedMemoryCacheProducer", ezq.ZG(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.pLO.a(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bu);
        }
    }

    /* loaded from: classes5.dex */
    private static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pAS;
        private final com.facebook.cache.common.b pMr;
        private final boolean pMs;

        public a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.pAS = pVar;
            this.pMr = bVar;
            this.pMs = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Ql(i) || eVar == null || ee(i, 10)) {
                ezC().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> eyv = eVar.eyv();
            if (eyv != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.pMs) {
                        aVar = this.pAS.a(this.pMr, eyv);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(aVar);
                            eVar2.c(eVar);
                            try {
                                ezC().ba(1.0f);
                                ezC().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(eyv);
                }
            }
            ezC().g(eVar, i);
        }
    }
}
