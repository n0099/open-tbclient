package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> nmn;
    private final com.facebook.imagepipeline.c.f nuK;
    private final aj<com.facebook.imagepipeline.g.e> nxL;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nmn = pVar;
        this.nuK = fVar;
        this.nxL = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dVp = akVar.dVp();
        dVp.gn(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.nuK.c(akVar.dVo(), akVar.dPU());
        com.facebook.common.references.a<PooledByteBuffer> bl = this.nmn.bl(c);
        try {
            if (bl != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bl);
                dVp.a(id, "EncodedMemoryCacheProducer", dVp.UF(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dVp.F(id, "EncodedMemoryCacheProducer", true);
                kVar.aD(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dVq().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dVp.a(id, "EncodedMemoryCacheProducer", dVp.UF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dVp.F(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.nmn, c, akVar.dVo().dWn());
                dVp.a(id, "EncodedMemoryCacheProducer", dVp.UF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.nxL.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bl);
        }
    }

    /* loaded from: classes8.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> nmn;
        private final com.facebook.cache.common.b nyo;
        private final boolean nyp;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.nmn = pVar;
            this.nyo = bVar;
            this.nyp = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Mm(i) || eVar == null || dK(i, 10)) {
                dVA().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dUq = eVar.dUq();
            if (dUq != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.nyp) {
                        aVar = this.nmn.a(this.nyo, dUq);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dVA().aD(1.0f);
                                dVA().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dUq);
                }
            }
            dVA().h(eVar, i);
        }
    }
}
