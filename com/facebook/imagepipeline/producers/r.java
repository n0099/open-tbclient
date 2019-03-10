package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jBG;
    private final com.facebook.imagepipeline.c.f jGF;
    private final ai<com.facebook.imagepipeline.f.d> jJY;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jBG = tVar;
        this.jGF = fVar;
        this.jJY = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al czF = ajVar.czF();
        czF.em(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.jGF.c(ajVar.czE(), ajVar.cva());
        com.facebook.common.references.a<PooledByteBuffer> aX = this.jBG.aX(c);
        try {
            if (aX != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aX);
                dVar.t(c);
                czF.a(id, "EncodedMemoryCacheProducer", czF.FK(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aM(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.czG().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                czF.a(id, "EncodedMemoryCacheProducer", czF.FK(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.jBG, c);
                czF.a(id, "EncodedMemoryCacheProducer", czF.FK(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.jJY.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c(aX);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jBG;
        private final com.facebook.cache.common.b jKA;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.jBG = tVar;
            this.jKA = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                czR().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> cyM = dVar.cyM();
            if (cyM != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.jBG.a(dVar.cyO() != null ? dVar.cyO() : this.jKA, cyM);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                czR().aM(1.0f);
                                czR().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(cyM);
                }
            }
            czR().e(dVar, true);
        }
    }
}
