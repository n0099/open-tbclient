package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> nmF;
    private final com.facebook.imagepipeline.c.f nvc;
    private final aj<com.facebook.imagepipeline.g.e> nyd;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nmF = pVar;
        this.nvc = fVar;
        this.nyd = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dVy = akVar.dVy();
        dVy.go(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.nvc.c(akVar.dVx(), akVar.dQd());
        com.facebook.common.references.a<PooledByteBuffer> bl = this.nmF.bl(c);
        try {
            if (bl != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bl);
                dVy.a(id, "EncodedMemoryCacheProducer", dVy.UF(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dVy.F(id, "EncodedMemoryCacheProducer", true);
                kVar.aD(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dVz().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dVy.a(id, "EncodedMemoryCacheProducer", dVy.UF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dVy.F(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.nmF, c, akVar.dVx().dWw());
                dVy.a(id, "EncodedMemoryCacheProducer", dVy.UF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.nyd.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bl);
        }
    }

    /* loaded from: classes8.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> nmF;
        private final com.facebook.cache.common.b nyG;
        private final boolean nyH;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.nmF = pVar;
            this.nyG = bVar;
            this.nyH = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Mm(i) || eVar == null || dK(i, 10)) {
                dVJ().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dUz = eVar.dUz();
            if (dUz != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.nyH) {
                        aVar = this.nmF.a(this.nyG, dUz);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dVJ().aD(1.0f);
                                dVJ().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dUz);
                }
            }
            dVJ().h(eVar, i);
        }
    }
}
