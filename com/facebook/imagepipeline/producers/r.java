package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> kaQ;
    private final com.facebook.imagepipeline.c.f kfP;
    private final ai<com.facebook.imagepipeline.f.d> kjj;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.kaQ = tVar;
        this.kfP = fVar;
        this.kjj = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al cKC = ajVar.cKC();
        cKC.eA(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.kfP.c(ajVar.cKB(), ajVar.cFU());
        com.facebook.common.references.a<PooledByteBuffer> aV = this.kaQ.aV(c);
        try {
            if (aV != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aV);
                dVar.t(c);
                cKC.a(id, "EncodedMemoryCacheProducer", cKC.HP(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aR(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.cKD().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                cKC.a(id, "EncodedMemoryCacheProducer", cKC.HP(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.kaQ, c);
                cKC.a(id, "EncodedMemoryCacheProducer", cKC.HP(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.kjj.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c(aV);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> kaQ;
        private final com.facebook.cache.common.b kjL;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.kaQ = tVar;
            this.kjL = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                cKO().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> cJI = dVar.cJI();
            if (cJI != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.kaQ.a(dVar.cJK() != null ? dVar.cJK() : this.kjL, cJI);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                cKO().aR(1.0f);
                                cKO().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(cJI);
                }
            }
            cKO().e(dVar, true);
        }
    }
}
