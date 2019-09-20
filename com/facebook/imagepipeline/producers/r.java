package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> ket;
    private final com.facebook.imagepipeline.c.f kjt;
    private final ai<com.facebook.imagepipeline.f.d> kmM;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.ket = tVar;
        this.kjt = fVar;
        this.kmM = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al cLL = ajVar.cLL();
        cLL.eB(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.kjt.c(ajVar.cLK(), ajVar.cHd());
        com.facebook.common.references.a<PooledByteBuffer> aV = this.ket.aV(c);
        try {
            if (aV != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aV);
                dVar.t(c);
                cLL.a(id, "EncodedMemoryCacheProducer", cLL.Iq(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aS(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.cLM().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                cLL.a(id, "EncodedMemoryCacheProducer", cLL.Iq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.ket, c);
                cLL.a(id, "EncodedMemoryCacheProducer", cLL.Iq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.kmM.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c(aV);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> ket;
        private final com.facebook.cache.common.b kno;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.ket = tVar;
            this.kno = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                cLX().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> cKR = dVar.cKR();
            if (cKR != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.ket.a(dVar.cKT() != null ? dVar.cKT() : this.kno, cKR);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                cLX().aS(1.0f);
                                cLX().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(cKR);
                }
            }
            cLX().e(dVar, true);
        }
    }
}
