package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class s implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.f pBa;
    private final aj<com.facebook.imagepipeline.f.e> pDZ;
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> puD;

    public s(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.puD = pVar;
        this.pBa = fVar;
        this.pDZ = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        String id = akVar.getId();
        am eAe = akVar.eAe();
        eAe.hm(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.pBa.c(akVar.eAd(), akVar.evp());
        com.facebook.common.references.a<PooledByteBuffer> bu = this.puD.bu(c);
        try {
            if (bu != null) {
                com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(bu);
                eAe.b(id, "EncodedMemoryCacheProducer", eAe.ZA(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eAe.M(id, "EncodedMemoryCacheProducer", true);
                kVar.aX(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
            } else if (akVar.eAf().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                eAe.b(id, "EncodedMemoryCacheProducer", eAe.ZA(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                eAe.M(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.puD, c, akVar.eAd().eBa());
                eAe.b(id, "EncodedMemoryCacheProducer", eAe.ZA(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.pDZ.a(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bu);
        }
    }

    /* loaded from: classes5.dex */
    private static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.cache.common.b pEC;
        private final boolean pED;
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> puD;

        public a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.puD = pVar;
            this.pEC = bVar;
            this.pED = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Rg(i) || eVar == null || ee(i, 10)) {
                eAq().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> ezi = eVar.ezi();
            if (ezi != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.pED) {
                        aVar = this.puD.a(this.pEC, ezi);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(aVar);
                            eVar2.c(eVar);
                            try {
                                eAq().aX(1.0f);
                                eAq().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(ezi);
                }
            }
            eAq().g(eVar, i);
        }
    }
}
