package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes9.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lFI;
    private final com.facebook.imagepipeline.c.f lNA;
    private final aj<com.facebook.imagepipeline.g.e> lQz;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lFI = pVar;
        this.lNA = fVar;
        this.lQz = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am doY = akVar.doY();
        doY.fc(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.lNA.c(akVar.doX(), akVar.djN());
        com.facebook.common.references.a<PooledByteBuffer> bk = this.lFI.bk(c);
        try {
            if (bk != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bk);
                doY.a(id, "EncodedMemoryCacheProducer", doY.OF(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                doY.C(id, "EncodedMemoryCacheProducer", true);
                kVar.aM(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.doZ().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                doY.a(id, "EncodedMemoryCacheProducer", doY.OF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                doY.C(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.lFI, c, akVar.doX().dpU());
                doY.a(id, "EncodedMemoryCacheProducer", doY.OF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.lQz.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bk);
        }
    }

    /* loaded from: classes9.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lFI;
        private final com.facebook.cache.common.b lRc;
        private final boolean lRd;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.lFI = pVar;
            this.lRc = bVar;
            this.lRd = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Iw(i) || eVar == null || dA(i, 10)) {
                dpj().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> doc = eVar.doc();
            if (doc != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.lRd) {
                        aVar = this.lFI.a(this.lRc, doc);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dpj().aM(1.0f);
                                dpj().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(doc);
                }
            }
            dpj().g(eVar, i);
        }
    }
}
