package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> oOo;
    private final com.facebook.imagepipeline.c.f oWG;
    private final aj<com.facebook.imagepipeline.g.e> oZF;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oOo = pVar;
        this.oWG = fVar;
        this.oZF = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am eqU = akVar.eqU();
        eqU.gZ(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.oWG.c(akVar.eqT(), akVar.elx());
        com.facebook.common.references.a<PooledByteBuffer> bv = this.oOo.bv(c);
        try {
            if (bv != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bv);
                eqU.a(id, "EncodedMemoryCacheProducer", eqU.XX(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eqU.I(id, "EncodedMemoryCacheProducer", true);
                kVar.aU(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.eqV().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                eqU.a(id, "EncodedMemoryCacheProducer", eqU.XX(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                eqU.I(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.oOo, c, akVar.eqT().erS());
                eqU.a(id, "EncodedMemoryCacheProducer", eqU.XX(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.oZF.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bv);
        }
    }

    /* loaded from: classes15.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> oOo;
        private final com.facebook.cache.common.b paj;
        private final boolean pak;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.oOo = pVar;
            this.paj = bVar;
            this.pak = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Qm(i) || eVar == null || eb(i, 10)) {
                erf().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> epV = eVar.epV();
            if (epV != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.pak) {
                        aVar = this.oOo.a(this.paj, epV);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                erf().aU(1.0f);
                                erf().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(epV);
                }
            }
            erf().h(eVar, i);
        }
    }
}
