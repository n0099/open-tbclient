package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> hYx;
    private final com.facebook.imagepipeline.c.f idq;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> igJ;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.hYx = tVar;
        this.idq = fVar;
        this.igJ = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al bXr = ajVar.bXr();
        String id = ajVar.getId();
        ImageRequest bXq = ajVar.bXq();
        Object bST = ajVar.bST();
        com.facebook.imagepipeline.request.b bYn = bXq.bYn();
        if (bYn == null || bYn.bYv() == null) {
            this.igJ.a(jVar, ajVar);
            return;
        }
        bXr.cX(id, bXB());
        com.facebook.cache.common.b b = this.idq.b(bXq, bST);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH = this.hYx.aH(b);
        if (aH != null) {
            bXr.a(id, bXB(), bXr.yD(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.ax(1.0f);
            jVar.e(aH, true);
            aH.close();
            return;
        }
        a aVar = new a(jVar, b, bYn instanceof com.facebook.imagepipeline.request.c, this.hYx);
        bXr.a(id, bXB(), bXr.yD(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.igJ.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b hWz;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> hYx;
        private final boolean iib;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.hWz = bVar;
            this.iib = z;
            this.hYx = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    bXD().e(null, true);
                }
            } else if (z || this.iib) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.hYx.a(this.hWz, aVar);
                try {
                    bXD().ax(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bXD = bXD();
                    if (a != null) {
                        aVar = a;
                    }
                    bXD.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String bXB() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
