package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mSs;
    private final com.facebook.imagepipeline.c.f naS;
    private final aj<com.facebook.imagepipeline.g.e> ndT;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mSs = pVar;
        this.naS = fVar;
        this.ndT = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dJp = akVar.dJp();
        dJp.fW(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.naS.c(akVar.dJo(), akVar.dDT());
        com.facebook.common.references.a<PooledByteBuffer> bj = this.mSs.bj(c);
        try {
            if (bj != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bj);
                dJp.a(id, "EncodedMemoryCacheProducer", dJp.RB(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dJp.G(id, "EncodedMemoryCacheProducer", true);
                kVar.ax(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dJq().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dJp.a(id, "EncodedMemoryCacheProducer", dJp.RB(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dJp.G(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.mSs, c, akVar.dJo().dKn());
                dJp.a(id, "EncodedMemoryCacheProducer", dJp.RB(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.ndT.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bj);
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mSs;
        private final com.facebook.cache.common.b nex;
        private final boolean ney;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.mSs = pVar;
            this.nex = bVar;
            this.ney = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (JI(i) || eVar == null || dC(i, 10)) {
                dJA().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dIq = eVar.dIq();
            if (dIq != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.ney) {
                        aVar = this.mSs.a(this.nex, dIq);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dJA().ax(1.0f);
                                dJA().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dIq);
                }
            }
            dJA().h(eVar, i);
        }
    }
}
