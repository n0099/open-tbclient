package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> nLY;
    private final com.facebook.imagepipeline.c.f nUs;
    private final aj<com.facebook.imagepipeline.g.e> nXr;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nLY = pVar;
        this.nUs = fVar;
        this.nXr = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am edh = akVar.edh();
        edh.gH(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.nUs.c(akVar.edg(), akVar.dXM());
        com.facebook.common.references.a<PooledByteBuffer> bq = this.nLY.bq(c);
        try {
            if (bq != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bq);
                edh.a(id, "EncodedMemoryCacheProducer", edh.VV(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                edh.F(id, "EncodedMemoryCacheProducer", true);
                kVar.aJ(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.edi().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                edh.a(id, "EncodedMemoryCacheProducer", edh.VV(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                edh.F(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.nLY, c, akVar.edg().eef());
                edh.a(id, "EncodedMemoryCacheProducer", edh.VV(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.nXr.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bq);
        }
    }

    /* loaded from: classes18.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> nLY;
        private final com.facebook.cache.common.b nXU;
        private final boolean nXV;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.nLY = pVar;
            this.nXU = bVar;
            this.nXV = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Nx(i) || eVar == null || dO(i, 10)) {
                eds().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> eci = eVar.eci();
            if (eci != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.nXV) {
                        aVar = this.nLY.a(this.nXU, eci);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                eds().aJ(1.0f);
                                eds().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(eci);
                }
            }
            eds().h(eVar, i);
        }
    }
}
