package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> kbW;
    private final com.facebook.imagepipeline.c.f kgV;
    private final ai<com.facebook.imagepipeline.f.d> kkp;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.kbW = tVar;
        this.kgV = fVar;
        this.kkp = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al cKX = ajVar.cKX();
        cKX.eA(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.kgV.c(ajVar.cKW(), ajVar.cGp());
        com.facebook.common.references.a<PooledByteBuffer> aV = this.kbW.aV(c);
        try {
            if (aV != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aV);
                dVar.t(c);
                cKX.a(id, "EncodedMemoryCacheProducer", cKX.HQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aR(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.cKY().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                cKX.a(id, "EncodedMemoryCacheProducer", cKX.HQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.kbW, c);
                cKX.a(id, "EncodedMemoryCacheProducer", cKX.HQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.kkp.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c(aV);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> kbW;
        private final com.facebook.cache.common.b kkR;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.kbW = tVar;
            this.kkR = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                cLj().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> cKd = dVar.cKd();
            if (cKd != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.kbW.a(dVar.cKf() != null ? dVar.cKf() : this.kkR, cKd);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                cLj().aR(1.0f);
                                cLj().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(cKd);
                }
            }
            cLj().e(dVar, true);
        }
    }
}
