package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jTI;
    private final com.facebook.imagepipeline.c.f jYF;
    private final ai<com.facebook.imagepipeline.f.d> kbY;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jTI = tVar;
        this.jYF = fVar;
        this.kbY = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al cHx = ajVar.cHx();
        cHx.ez(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.jYF.c(ajVar.cHw(), ajVar.cCS());
        com.facebook.common.references.a<PooledByteBuffer> aV = this.jTI.aV(c);
        try {
            if (aV != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aV);
                dVar.t(c);
                cHx.a(id, "EncodedMemoryCacheProducer", cHx.GT(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aQ(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.cHy().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                cHx.a(id, "EncodedMemoryCacheProducer", cHx.GT(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.jTI, c);
                cHx.a(id, "EncodedMemoryCacheProducer", cHx.GT(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.kbY.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c(aV);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jTI;
        private final com.facebook.cache.common.b kcA;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.jTI = tVar;
            this.kcA = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                cHJ().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> cGE = dVar.cGE();
            if (cGE != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.jTI.a(dVar.cGG() != null ? dVar.cGG() : this.kcA, cGE);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                cHJ().aQ(1.0f);
                                cHJ().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(cGE);
                }
            }
            cHJ().e(dVar, true);
        }
    }
}
