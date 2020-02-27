package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJS;
    private final com.facebook.imagepipeline.c.f lRY;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUZ;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lJS = pVar;
        this.lRY = fVar;
        this.lUZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am drw = akVar.drw();
        String id = akVar.getId();
        ImageRequest drv = akVar.drv();
        Object dmd = akVar.dmd();
        com.facebook.imagepipeline.request.b dsx = drv.dsx();
        if (dsx == null || dsx.dru() == null) {
            this.lUZ.c(kVar, akVar);
            return;
        }
        drw.fm(id, drF());
        com.facebook.cache.common.b b = this.lRY.b(drv, dmd);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.lJS.bn(b);
        if (bn != null) {
            drw.a(id, drF(), drw.Pd(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            drw.D(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aK(1.0f);
            kVar.g(bn, 1);
            bn.close();
            return;
        }
        a aVar = new a(kVar, b, dsx instanceof com.facebook.imagepipeline.request.c, this.lJS, akVar.drv().dsv());
        drw.a(id, drF(), drw.Pd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lUZ.c(aVar, akVar);
    }

    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b lHR;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJS;
        private final boolean lWs;
        private final boolean lWt;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.lHR = bVar;
            this.lWs = z;
            this.lJS = pVar;
            this.lWt = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (IJ(i)) {
                    drH().g(null, i);
                }
            } else if (!IK(i) || this.lWs) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.lWt ? this.lJS.a(this.lHR, aVar) : null;
                try {
                    drH().aK(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> drH = drH();
                    if (a != null) {
                        aVar = a;
                    }
                    drH.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String drF() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
