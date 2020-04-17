package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lTf;
    private final com.facebook.imagepipeline.c.f mbE;
    private final aj<com.facebook.imagepipeline.g.e> meD;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lTf = pVar;
        this.mbE = fVar;
        this.meD = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dtU = akVar.dtU();
        dtU.fi(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.mbE.c(akVar.dtT(), akVar.dow());
        com.facebook.common.references.a<PooledByteBuffer> bd = this.lTf.bd(c);
        try {
            if (bd != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bd);
                dtU.a(id, "EncodedMemoryCacheProducer", dtU.Ol(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dtU.D(id, "EncodedMemoryCacheProducer", true);
                kVar.au(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dtV().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dtU.a(id, "EncodedMemoryCacheProducer", dtU.Ol(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dtU.D(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.lTf, c, akVar.dtT().duS());
                dtU.a(id, "EncodedMemoryCacheProducer", dtU.Ol(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.meD.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bd);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lTf;
        private final com.facebook.cache.common.b mfg;
        private final boolean mfh;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.lTf = pVar;
            this.mfg = bVar;
            this.mfh = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Hs(i) || eVar == null || dm(i, 10)) {
                duf().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dsU = eVar.dsU();
            if (dsU != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.mfh) {
                        aVar = this.lTf.a(this.mfg, dsU);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                duf().au(1.0f);
                                duf().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) dsU);
                }
            }
            duf().h(eVar, i);
        }
    }
}
