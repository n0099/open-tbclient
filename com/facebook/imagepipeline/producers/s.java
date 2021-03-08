package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class s implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pCX;
    private final com.facebook.imagepipeline.b.f pKU;
    private final aj<com.facebook.imagepipeline.f.e> pNT;

    public s(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pCX = pVar;
        this.pKU = fVar;
        this.pNT = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        String id = akVar.getId();
        am ezz = akVar.ezz();
        ezz.hv(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.pKU.c(akVar.ezy(), akVar.eum());
        com.facebook.common.references.a<PooledByteBuffer> bw = this.pCX.bw(c);
        try {
            if (bw != null) {
                com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(bw);
                ezz.b(id, "EncodedMemoryCacheProducer", ezz.ZM(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                ezz.M(id, "EncodedMemoryCacheProducer", true);
                kVar.be(1.0f);
                kVar.f(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
            } else if (akVar.ezA().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                ezz.b(id, "EncodedMemoryCacheProducer", ezz.ZM(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                ezz.M(id, "EncodedMemoryCacheProducer", false);
                kVar.f(null, 1);
            } else {
                a aVar = new a(kVar, this.pCX, c, akVar.ezy().eAv());
                ezz.b(id, "EncodedMemoryCacheProducer", ezz.ZM(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.pNT.a(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bw);
        }
    }

    /* loaded from: classes5.dex */
    private static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pCX;
        private final com.facebook.cache.common.b pOw;
        private final boolean pOx;

        public a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.pCX = pVar;
            this.pOw = bVar;
            this.pOx = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Qp(i) || eVar == null || ee(i, 10)) {
                ezL().f(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> eyE = eVar.eyE();
            if (eyE != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.pOx) {
                        aVar = this.pCX.a(this.pOw, eyE);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(aVar);
                            eVar2.c(eVar);
                            try {
                                ezL().be(1.0f);
                                ezL().f(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(eyE);
                }
            }
            ezL().f(eVar, i);
        }
    }
}
