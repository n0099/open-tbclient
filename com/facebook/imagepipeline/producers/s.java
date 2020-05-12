package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lTj;
    private final com.facebook.imagepipeline.c.f mbI;
    private final aj<com.facebook.imagepipeline.g.e> meH;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lTj = pVar;
        this.mbI = fVar;
        this.meH = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dtS = akVar.dtS();
        dtS.fi(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.mbI.c(akVar.dtR(), akVar.dou());
        com.facebook.common.references.a<PooledByteBuffer> be = this.lTj.be(c);
        try {
            if (be != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(be);
                dtS.a(id, "EncodedMemoryCacheProducer", dtS.Oo(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dtS.D(id, "EncodedMemoryCacheProducer", true);
                kVar.au(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dtT().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dtS.a(id, "EncodedMemoryCacheProducer", dtS.Oo(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dtS.D(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.lTj, c, akVar.dtR().duQ());
                dtS.a(id, "EncodedMemoryCacheProducer", dtS.Oo(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.meH.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) be);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lTj;
        private final com.facebook.cache.common.b mfk;
        private final boolean mfl;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.lTj = pVar;
            this.mfk = bVar;
            this.mfl = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Hs(i) || eVar == null || dm(i, 10)) {
                dud().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dsS = eVar.dsS();
            if (dsS != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.mfl) {
                        aVar = this.lTj.a(this.mfk, dsS);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dud().au(1.0f);
                                dud().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) dsS);
                }
            }
            dud().h(eVar, i);
        }
    }
}
