package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mSu;
    private final com.facebook.imagepipeline.c.f naU;
    private final aj<com.facebook.imagepipeline.g.e> ndV;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mSu = pVar;
        this.naU = fVar;
        this.ndV = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dJq = akVar.dJq();
        dJq.fW(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.naU.c(akVar.dJp(), akVar.dDU());
        com.facebook.common.references.a<PooledByteBuffer> bj = this.mSu.bj(c);
        try {
            if (bj != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bj);
                dJq.a(id, "EncodedMemoryCacheProducer", dJq.RB(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dJq.G(id, "EncodedMemoryCacheProducer", true);
                kVar.ax(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dJr().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dJq.a(id, "EncodedMemoryCacheProducer", dJq.RB(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dJq.G(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.mSu, c, akVar.dJp().dKo());
                dJq.a(id, "EncodedMemoryCacheProducer", dJq.RB(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.ndV.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bj);
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mSu;
        private final boolean neA;
        private final com.facebook.cache.common.b nez;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.mSu = pVar;
            this.nez = bVar;
            this.neA = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (JI(i) || eVar == null || dC(i, 10)) {
                dJB().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dIr = eVar.dIr();
            if (dIr != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.neA) {
                        aVar = this.mSu.a(this.nez, dIr);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dJB().ax(1.0f);
                                dJB().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dIr);
                }
            }
            dJB().h(eVar, i);
        }
    }
}
