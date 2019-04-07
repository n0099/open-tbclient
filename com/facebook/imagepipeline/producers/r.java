package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jAS;
    private final com.facebook.imagepipeline.c.f jFR;
    private final ai<com.facebook.imagepipeline.f.d> jJk;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jAS = tVar;
        this.jFR = fVar;
        this.jJk = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al czB = ajVar.czB();
        czB.em(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.jFR.c(ajVar.czA(), ajVar.cuW());
        com.facebook.common.references.a<PooledByteBuffer> aT = this.jAS.aT(c);
        try {
            if (aT != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aT);
                dVar.t(c);
                czB.a(id, "EncodedMemoryCacheProducer", czB.Fy(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aM(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.czC().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                czB.a(id, "EncodedMemoryCacheProducer", czB.Fy(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.jAS, c);
                czB.a(id, "EncodedMemoryCacheProducer", czB.Fy(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.jJk.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c(aT);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jAS;
        private final com.facebook.cache.common.b jJM;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.jAS = tVar;
            this.jJM = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                czN().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> cyI = dVar.cyI();
            if (cyI != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.jAS.a(dVar.cyK() != null ? dVar.cyK() : this.jJM, cyI);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                czN().aM(1.0f);
                                czN().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(cyI);
                }
            }
            czN().e(dVar, true);
        }
    }
}
