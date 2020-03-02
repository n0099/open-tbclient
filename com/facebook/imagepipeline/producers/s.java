package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lJU;
    private final com.facebook.imagepipeline.c.f lSa;
    private final aj<com.facebook.imagepipeline.g.e> lVb;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lJU = pVar;
        this.lSa = fVar;
        this.lVb = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dry = akVar.dry();
        dry.fm(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.lSa.c(akVar.drx(), akVar.dmf());
        com.facebook.common.references.a<PooledByteBuffer> bn = this.lJU.bn(c);
        try {
            if (bn != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bn);
                dry.a(id, "EncodedMemoryCacheProducer", dry.Pd(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dry.D(id, "EncodedMemoryCacheProducer", true);
                kVar.aK(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.drz().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dry.a(id, "EncodedMemoryCacheProducer", dry.Pd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dry.D(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.lJU, c, akVar.drx().dsx());
                dry.a(id, "EncodedMemoryCacheProducer", dry.Pd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.lVb.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bn);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lJU;
        private final com.facebook.cache.common.b lVE;
        private final boolean lVF;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.lJU = pVar;
            this.lVE = bVar;
            this.lVF = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IK(i) || eVar == null || dB(i, 10)) {
                drJ().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dqy = eVar.dqy();
            if (dqy != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.lVF) {
                        aVar = this.lJU.a(this.lVE, dqy);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                drJ().aK(1.0f);
                                drJ().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dqy);
                }
            }
            drJ().g(eVar, i);
        }
    }
}
