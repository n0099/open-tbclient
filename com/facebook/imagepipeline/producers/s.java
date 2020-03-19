package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lLL;
    private final com.facebook.imagepipeline.c.f lTR;
    private final aj<com.facebook.imagepipeline.g.e> lWS;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lLL = pVar;
        this.lTR = fVar;
        this.lWS = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am drW = akVar.drW();
        drW.fk(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.lTR.c(akVar.drV(), akVar.dmD());
        com.facebook.common.references.a<PooledByteBuffer> bn = this.lLL.bn(c);
        try {
            if (bn != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bn);
                drW.a(id, "EncodedMemoryCacheProducer", drW.Pe(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                drW.D(id, "EncodedMemoryCacheProducer", true);
                kVar.aK(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.drX().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                drW.a(id, "EncodedMemoryCacheProducer", drW.Pe(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                drW.D(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.lLL, c, akVar.drV().dsV());
                drW.a(id, "EncodedMemoryCacheProducer", drW.Pe(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.lWS.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bn);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lLL;
        private final com.facebook.cache.common.b lXv;
        private final boolean lXw;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.lLL = pVar;
            this.lXv = bVar;
            this.lXw = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IQ(i) || eVar == null || dC(i, 10)) {
                dsh().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dqW = eVar.dqW();
            if (dqW != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.lXw) {
                        aVar = this.lLL.a(this.lXv, dqW);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dsh().aK(1.0f);
                                dsh().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dqW);
                }
            }
            dsh().g(eVar, i);
        }
    }
}
