package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class r implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> hYw;
    private final com.facebook.imagepipeline.c.f idp;
    private final ai<com.facebook.imagepipeline.f.d> igI;

    public r(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.hYw = tVar;
        this.idp = fVar;
        this.igI = aiVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        String id = ajVar.getId();
        al bXr = ajVar.bXr();
        bXr.cX(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.idp.c(ajVar.bXq(), ajVar.bST());
        com.facebook.common.references.a<PooledByteBuffer> aH = this.hYw.aH(c);
        try {
            if (aH != null) {
                com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(aH);
                dVar.t(c);
                bXr.a(id, "EncodedMemoryCacheProducer", bXr.yD(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.ax(1.0f);
                jVar.e(dVar, true);
                com.facebook.imagepipeline.f.d.e(dVar);
            } else if (ajVar.bXs().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                bXr.a(id, "EncodedMemoryCacheProducer", bXr.yD(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
                jVar.e(null, true);
            } else {
                a aVar = new a(jVar, this.hYw, c);
                bXr.a(id, "EncodedMemoryCacheProducer", bXr.yD(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
                this.igI.a(aVar, ajVar);
            }
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aH);
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> hYw;
        private final com.facebook.cache.common.b ihk;

        public a(j<com.facebook.imagepipeline.f.d> jVar, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, PooledByteBuffer> tVar, com.facebook.cache.common.b bVar) {
            super(jVar);
            this.hYw = tVar;
            this.ihk = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!z || dVar == null) {
                bXD().e(dVar, z);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> bWy = dVar.bWy();
            if (bWy != null) {
                try {
                    com.facebook.common.references.a<PooledByteBuffer> a = this.hYw.a(dVar.bWA() != null ? dVar.bWA() : this.ihk, bWy);
                    if (a != null) {
                        try {
                            com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(a);
                            dVar2.c(dVar);
                            try {
                                bXD().ax(1.0f);
                                bXD().e(dVar2, true);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.d.e(dVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bWy);
                }
            }
            bXD().e(dVar, true);
        }
    }
}
