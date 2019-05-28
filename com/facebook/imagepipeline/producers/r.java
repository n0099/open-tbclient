package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jTJ;
    private final com.facebook.imagepipeline.c.f jYG;
    private final ai<com.facebook.imagepipeline.f.d> kbZ;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jTJ = tVar;
        this.jYG = fVar;
        this.kbZ = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al cHz = ajVar.cHz();
        cHz.ez(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.jYG.c(ajVar.cHy(), ajVar.cCU());
        com.facebook.common.references.a<PooledByteBuffer> aV = this.jTJ.aV(c);
        try {
            if (aV != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aV);
                dVar.t(c);
                cHz.a(id, "EncodedMemoryCacheProducer", cHz.GT(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aQ(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.cHA().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                cHz.a(id, "EncodedMemoryCacheProducer", cHz.GT(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.jTJ, c);
                cHz.a(id, "EncodedMemoryCacheProducer", cHz.GT(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.kbZ.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c(aV);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jTJ;
        private final com.facebook.cache.common.b kcB;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.jTJ = tVar;
            this.kcB = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                cHL().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> cGG = dVar.cGG();
            if (cGG != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.jTJ.a(dVar.cGI() != null ? dVar.cGI() : this.kcB, cGG);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                cHL().aQ(1.0f);
                                cHL().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(cGG);
                }
            }
            cHL().e(dVar, true);
        }
    }
}
