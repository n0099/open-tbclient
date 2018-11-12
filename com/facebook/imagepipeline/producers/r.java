package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> iah;
    private final com.facebook.imagepipeline.c.f ifc;
    private final ai<com.facebook.imagepipeline.f.d> iit;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.iah = tVar;
        this.ifc = fVar;
        this.iit = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al bWM = ajVar.bWM();
        bWM.cW(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.ifc.c(ajVar.bWL(), ajVar.bSo());
        com.facebook.common.references.a<PooledByteBuffer> aG = this.iah.aG(c);
        try {
            if (aG != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aG);
                dVar.t(c);
                bWM.a(id, "EncodedMemoryCacheProducer", bWM.yI(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.az(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.bWN().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                bWM.a(id, "EncodedMemoryCacheProducer", bWM.yI(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.iah, c);
                bWM.a(id, "EncodedMemoryCacheProducer", bWM.yI(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
                this.iit.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aG);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> iah;
        private final com.facebook.cache.common.b iiV;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.iah = tVar;
            this.iiV = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                bWY().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> bVT = dVar.bVT();
            if (bVT != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.iah.a(dVar.bVV() != null ? dVar.bVV() : this.iiV, bVT);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                bWY().az(1.0f);
                                bWY().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bVT);
                }
            }
            bWY().e(dVar, true);
        }
    }
}
