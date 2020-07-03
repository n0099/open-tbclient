package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mKl;
    private final com.facebook.imagepipeline.c.f mSK;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mVP;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mKl = pVar;
        this.mSK = fVar;
        this.mVP = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dFZ = akVar.dFZ();
        String id = akVar.getId();
        ImageRequest dFY = akVar.dFY();
        Object dAD = akVar.dAD();
        com.facebook.imagepipeline.request.b dGY = dFY.dGY();
        if (dGY == null || dGY.dFX() == null) {
            this.mVP.c(kVar, akVar);
            return;
        }
        dFZ.fU(id, dGi());
        com.facebook.cache.common.b b = this.mSK.b(dFY, dAD);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj = this.mKl.bj(b);
        if (bj != null) {
            dFZ.a(id, dGi(), dFZ.QP(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dFZ.G(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.ay(1.0f);
            kVar.h(bj, 1);
            bj.close();
            return;
        }
        a aVar = new a(kVar, b, dGY instanceof com.facebook.imagepipeline.request.c, this.mKl, akVar.dFY().dGX());
        dFZ.a(id, dGi(), dFZ.QP(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.mVP.c(aVar, akVar);
    }

    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b mIi;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mKl;
        private final boolean mXj;
        private final boolean mXk;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.mIi = bVar;
            this.mXj = z;
            this.mKl = pVar;
            this.mXk = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Jm(i)) {
                    dGk().h(null, i);
                }
            } else if (!Jn(i) || this.mXj) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.mXk ? this.mKl.a(this.mIi, aVar) : null;
                try {
                    dGk().ay(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dGk = dGk();
                    if (a != null) {
                        aVar = a;
                    }
                    dGk.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dGi() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
