package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jBn;
    private final com.facebook.imagepipeline.c.f jGm;
    private final ai<com.facebook.imagepipeline.f.d> jJF;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jBn = tVar;
        this.jGm = fVar;
        this.jJF = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al czv = ajVar.czv();
        czv.em(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.jGm.c(ajVar.czu(), ajVar.cuQ());
        com.facebook.common.references.a<PooledByteBuffer> aW = this.jBn.aW(c);
        try {
            if (aW != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aW);
                dVar.t(c);
                czv.a(id, "EncodedMemoryCacheProducer", czv.FH(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aM(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.czw().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                czv.a(id, "EncodedMemoryCacheProducer", czv.FH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.jBn, c);
                czv.a(id, "EncodedMemoryCacheProducer", czv.FH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.jJF.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c(aW);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jBn;
        private final com.facebook.cache.common.b jKh;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.jBn = tVar;
            this.jKh = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                czH().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> cyC = dVar.cyC();
            if (cyC != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.jBn.a(dVar.cyE() != null ? dVar.cyE() : this.jKh, cyC);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                czH().aM(1.0f);
                                czH().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(cyC);
                }
            }
            czH().e(dVar, true);
        }
    }
}
