package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> ihu;
    private final com.facebook.imagepipeline.c.f imn;
    private final ai<com.facebook.imagepipeline.f.d> ipF;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.ihu = tVar;
        this.imn = fVar;
        this.ipF = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al bYR = ajVar.bYR();
        bYR.db(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.imn.c(ajVar.bYQ(), ajVar.bUt());
        com.facebook.common.references.a<PooledByteBuffer> aH = this.ihu.aH(c);
        try {
            if (aH != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aH);
                dVar.t(c);
                bYR.a(id, "EncodedMemoryCacheProducer", bYR.zl(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.az(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.bYS().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                bYR.a(id, "EncodedMemoryCacheProducer", bYR.zl(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.ihu, c);
                bYR.a(id, "EncodedMemoryCacheProducer", bYR.zl(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
                this.ipF.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aH);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> ihu;
        private final com.facebook.cache.common.b iqh;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.ihu = tVar;
            this.iqh = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                bZd().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> bXY = dVar.bXY();
            if (bXY != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.ihu.a(dVar.bYa() != null ? dVar.bYa() : this.iqh, bXY);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                bZd().az(1.0f);
                                bZd().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bXY);
                }
            }
            bZd().e(dVar, true);
        }
    }
}
