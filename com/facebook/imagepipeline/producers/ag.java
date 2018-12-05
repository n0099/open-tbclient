package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class ag implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ihu;
    private final com.facebook.imagepipeline.c.f imn;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ipF;

    public ag(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.ihu = tVar;
        this.imn = fVar;
        this.ipF = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al bYS = ajVar.bYS();
        String id = ajVar.getId();
        ImageRequest bYR = ajVar.bYR();
        Object bUu = ajVar.bUu();
        com.facebook.imagepipeline.request.b bZO = bYR.bZO();
        if (bZO == null || bZO.bZW() == null) {
            this.ipF.a(jVar, ajVar);
            return;
        }
        bYS.db(id, bZc());
        com.facebook.cache.common.b b = this.imn.b(bYR, bUu);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH = this.ihu.aH(b);
        if (aH != null) {
            bYS.a(id, bZc(), bYS.zl(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            jVar.az(1.0f);
            jVar.e(aH, true);
            aH.close();
            return;
        }
        a aVar = new a(jVar, b, bZO instanceof com.facebook.imagepipeline.request.c, this.ihu);
        bYS.a(id, bZc(), bYS.zl(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.ipF.a(aVar, ajVar);
    }

    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.cache.common.b ifw;
        private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ihu;
        private final boolean iqX;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar) {
            super(jVar);
            this.ifw = bVar;
            this.iqX = z;
            this.ihu = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (aVar == null) {
                if (z) {
                    bZe().e(null, true);
                }
            } else if (z || this.iqX) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = this.ihu.a(this.ifw, aVar);
                try {
                    bZe().az(1.0f);
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZe = bZe();
                    if (a != null) {
                        aVar = a;
                    }
                    bZe.e(aVar, z);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                }
            }
        }
    }

    protected String bZc() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
