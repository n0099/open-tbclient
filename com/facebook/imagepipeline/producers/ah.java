package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lKf;
    private final com.facebook.imagepipeline.c.f lSl;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVm;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lKf = pVar;
        this.lSl = fVar;
        this.lVm = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am drz = akVar.drz();
        String id = akVar.getId();
        ImageRequest dry = akVar.dry();
        Object dmg = akVar.dmg();
        com.facebook.imagepipeline.request.b dsA = dry.dsA();
        if (dsA == null || dsA.drx() == null) {
            this.lVm.c(kVar, akVar);
            return;
        }
        drz.fm(id, drI());
        com.facebook.cache.common.b b = this.lSl.b(dry, dmg);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.lKf.bn(b);
        if (bn != null) {
            drz.a(id, drI(), drz.Pe(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            drz.D(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aK(1.0f);
            kVar.g(bn, 1);
            bn.close();
            return;
        }
        a aVar = new a(kVar, b, dsA instanceof com.facebook.imagepipeline.request.c, this.lKf, akVar.dry().dsy());
        drz.a(id, drI(), drz.Pe(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lVm.c(aVar, akVar);
    }

    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b lIe;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lKf;
        private final boolean lWF;
        private final boolean lWG;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.lIe = bVar;
            this.lWF = z;
            this.lKf = pVar;
            this.lWG = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (IJ(i)) {
                    drK().g(null, i);
                }
            } else if (!IK(i) || this.lWF) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.lWG ? this.lKf.a(this.lIe, aVar) : null;
                try {
                    drK().aK(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> drK = drK();
                    if (a != null) {
                        aVar = a;
                    }
                    drK.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String drI() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
