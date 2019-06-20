package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jTM;
    private final com.facebook.imagepipeline.c.f jYJ;
    private final ai<com.facebook.imagepipeline.f.d> kcc;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jTM = tVar;
        this.jYJ = fVar;
        this.kcc = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al cHy = ajVar.cHy();
        cHy.ez(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.jYJ.c(ajVar.cHx(), ajVar.cCT());
        com.facebook.common.references.a<PooledByteBuffer> aV = this.jTM.aV(c);
        try {
            if (aV != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aV);
                dVar.t(c);
                cHy.a(id, "EncodedMemoryCacheProducer", cHy.GV(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aQ(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.cHz().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                cHy.a(id, "EncodedMemoryCacheProducer", cHy.GV(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.jTM, c);
                cHy.a(id, "EncodedMemoryCacheProducer", cHy.GV(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.kcc.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c(aV);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> jTM;
        private final com.facebook.cache.common.b kcE;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.jTM = tVar;
            this.kcE = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                cHK().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> cGF = dVar.cGF();
            if (cGF != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.jTM.a(dVar.cGH() != null ? dVar.cGH() : this.kcE, cGF);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                cHK().aQ(1.0f);
                                cHK().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(cGF);
                }
            }
            cHK().e(dVar, true);
        }
    }
}
