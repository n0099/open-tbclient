package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> ikE;
    private final com.facebook.imagepipeline.c.f ipy;
    private final ai<com.facebook.imagepipeline.f.d> isP;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.ikE = tVar;
        this.ipy = fVar;
        this.isP = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al bZI = ajVar.bZI();
        bZI.db(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.ipy.c(ajVar.bZH(), ajVar.bVk());
        com.facebook.common.references.a<PooledByteBuffer> aH = this.ikE.aH(c);
        try {
            if (aH != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aH);
                dVar.t(c);
                bZI.a(id, "EncodedMemoryCacheProducer", bZI.zo(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.az(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.bZJ().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                bZI.a(id, "EncodedMemoryCacheProducer", bZI.zo(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.ikE, c);
                bZI.a(id, "EncodedMemoryCacheProducer", bZI.zo(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
                this.isP.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aH);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> ikE;
        private final com.facebook.cache.common.b itr;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.ikE = tVar;
            this.itr = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                bZU().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> bYP = dVar.bYP();
            if (bYP != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.ikE.a(dVar.bYR() != null ? dVar.bYR() : this.itr, bYP);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                bZU().az(1.0f);
                                bZU().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bYP);
                }
            }
            bZU().e(dVar, true);
        }
    }
}
