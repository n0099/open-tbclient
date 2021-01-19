package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class s implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pBg;
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pqj;
    private final com.facebook.imagepipeline.b.f pyh;

    public s(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pqj = pVar;
        this.pyh = fVar;
        this.pBg = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        String id = akVar.getId();
        am ewQ = akVar.ewQ();
        ewQ.hm(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.pyh.c(akVar.ewP(), akVar.erD());
        com.facebook.common.references.a<PooledByteBuffer> bu = this.pqj.bu(c);
        try {
            if (bu != null) {
                com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(bu);
                ewQ.b(id, "EncodedMemoryCacheProducer", ewQ.Yt(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                ewQ.M(id, "EncodedMemoryCacheProducer", true);
                kVar.aX(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
            } else if (akVar.ewR().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                ewQ.b(id, "EncodedMemoryCacheProducer", ewQ.Yt(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                ewQ.M(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.pqj, c, akVar.ewP().exM());
                ewQ.b(id, "EncodedMemoryCacheProducer", ewQ.Yt(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.pBg.a(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bu);
        }
    }

    /* loaded from: classes3.dex */
    private static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.cache.common.b pBJ;
        private final boolean pBK;
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pqj;

        public a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.pqj = pVar;
            this.pBJ = bVar;
            this.pBK = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (PP(i) || eVar == null || eg(i, 10)) {
                exc().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> evU = eVar.evU();
            if (evU != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.pBK) {
                        aVar = this.pqj.a(this.pBJ, evU);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(aVar);
                            eVar2.c(eVar);
                            try {
                                exc().aX(1.0f);
                                exc().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(evU);
                }
            }
            exc().g(eVar, i);
        }
    }
}
