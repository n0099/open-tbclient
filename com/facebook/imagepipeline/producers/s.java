package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class s implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.f pCH;
    private final aj<com.facebook.imagepipeline.f.e> pFG;
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> puK;

    public s(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.puK = pVar;
        this.pCH = fVar;
        this.pFG = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        String id = akVar.getId();
        am eAI = akVar.eAI();
        eAI.hn(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.pCH.c(akVar.eAH(), akVar.evw());
        com.facebook.common.references.a<PooledByteBuffer> bu = this.puK.bu(c);
        try {
            if (bu != null) {
                com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(bu);
                eAI.b(id, "EncodedMemoryCacheProducer", eAI.ZA(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eAI.M(id, "EncodedMemoryCacheProducer", true);
                kVar.aX(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
            } else if (akVar.eAJ().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                eAI.b(id, "EncodedMemoryCacheProducer", eAI.ZA(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                eAI.M(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.puK, c, akVar.eAH().eBE());
                eAI.b(id, "EncodedMemoryCacheProducer", eAI.ZA(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.pFG.a(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bu);
        }
    }

    /* loaded from: classes3.dex */
    private static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.cache.common.b pGj;
        private final boolean pGk;
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> puK;

        public a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.puK = pVar;
            this.pGj = bVar;
            this.pGk = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Rw(i) || eVar == null || eg(i, 10)) {
                eAU().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> ezM = eVar.ezM();
            if (ezM != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.pGk) {
                        aVar = this.puK.a(this.pGj, ezM);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(aVar);
                            eVar2.c(eVar);
                            try {
                                eAU().aX(1.0f);
                                eAU().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(ezM);
                }
            }
            eAU().g(eVar, i);
        }
    }
}
