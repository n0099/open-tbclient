package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> kbL;
    private final com.facebook.imagepipeline.c.f kgN;
    private final ai<com.facebook.imagepipeline.f.d> kkh;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.kbL = tVar;
        this.kgN = fVar;
        this.kkh = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al cIG = ajVar.cIG();
        cIG.en(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.kgN.c(ajVar.cIF(), ajVar.cDZ());
        com.facebook.common.references.a<PooledByteBuffer> aQ = this.kbL.aQ(c);
        try {
            if (aQ != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aQ);
                dVar.t(c);
                cIG.a(id, "EncodedMemoryCacheProducer", cIG.GH(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.av(1.0f);
                jVar.f(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.cIH().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                cIG.a(id, "EncodedMemoryCacheProducer", cIG.GH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                jVar.f(null, true);
            } else {
                a aVar = new a(jVar, this.kbL, c);
                cIG.a(id, "EncodedMemoryCacheProducer", cIG.GH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.kkh.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aQ);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> kbL;
        private final com.facebook.cache.common.b kkJ;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.kbL = tVar;
            this.kkJ = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                cIS().f(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> cHM = dVar.cHM();
            if (cHM != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.kbL.a(dVar.cHO() != null ? dVar.cHO() : this.kkJ, cHM);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                cIS().av(1.0f);
                                cIS().f(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) cHM);
                }
            }
            cIS().f(dVar, true);
        }
    }
}
