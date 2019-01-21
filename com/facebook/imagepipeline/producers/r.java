package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> ilM;
    private final com.facebook.imagepipeline.c.f iqG;
    private final ai<com.facebook.imagepipeline.f.d> itX;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.ilM = tVar;
        this.iqG = fVar;
        this.itX = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al caq = ajVar.caq();
        caq.de(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.iqG.c(ajVar.cap(), ajVar.bVS());
        com.facebook.common.references.a<PooledByteBuffer> aH = this.ilM.aH(c);
        try {
            if (aH != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aH);
                dVar.t(c);
                caq.a(id, "EncodedMemoryCacheProducer", caq.zE(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.az(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.car().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                caq.a(id, "EncodedMemoryCacheProducer", caq.zE(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.ilM, c);
                caq.a(id, "EncodedMemoryCacheProducer", caq.zE(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
                this.itX.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aH);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> ilM;
        private final com.facebook.cache.common.b iuz;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.ilM = tVar;
            this.iuz = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                caC().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> bZx = dVar.bZx();
            if (bZx != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.ilM.a(dVar.bZz() != null ? dVar.bZz() : this.iuz, bZx);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                caC().az(1.0f);
                                caC().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bZx);
                }
            }
            caC().e(dVar, true);
        }
    }
}
