package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes25.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.f nEZ;
    private final aj<com.facebook.imagepipeline.g.e> nIa;
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> nwF;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nwF = pVar;
        this.nEZ = fVar;
        this.nIa = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dZw = akVar.dZw();
        dZw.gA(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.nEZ.c(akVar.dZv(), akVar.dUb());
        com.facebook.common.references.a<PooledByteBuffer> bn = this.nwF.bn(c);
        try {
            if (bn != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bn);
                dZw.a(id, "EncodedMemoryCacheProducer", dZw.Vh(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dZw.F(id, "EncodedMemoryCacheProducer", true);
                kVar.aD(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dZx().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dZw.a(id, "EncodedMemoryCacheProducer", dZw.Vh(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dZw.F(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.nwF, c, akVar.dZv().eau());
                dZw.a(id, "EncodedMemoryCacheProducer", dZw.Vh(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.nIa.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bn);
        }
    }

    /* loaded from: classes25.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.cache.common.b nID;
        private final boolean nIE;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> nwF;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.nwF = pVar;
            this.nID = bVar;
            this.nIE = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (MR(i) || eVar == null || dO(i, 10)) {
                dZH().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dYx = eVar.dYx();
            if (dYx != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.nIE) {
                        aVar = this.nwF.a(this.nID, dYx);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dZH().aD(1.0f);
                                dZH().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dYx);
                }
            }
            dZH().h(eVar, i);
        }
    }
}
