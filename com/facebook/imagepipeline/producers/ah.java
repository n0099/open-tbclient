package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mKo;
    private final com.facebook.imagepipeline.c.f mSN;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mVS;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mKo = pVar;
        this.mSN = fVar;
        this.mVS = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dGd = akVar.dGd();
        String id = akVar.getId();
        ImageRequest dGc = akVar.dGc();
        Object dAH = akVar.dAH();
        com.facebook.imagepipeline.request.b dHc = dGc.dHc();
        if (dHc == null || dHc.dGb() == null) {
            this.mVS.c(kVar, akVar);
            return;
        }
        dGd.fU(id, dGm());
        com.facebook.cache.common.b b = this.mSN.b(dGc, dAH);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj = this.mKo.bj(b);
        if (bj != null) {
            dGd.a(id, dGm(), dGd.QQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            dGd.G(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.ay(1.0f);
            kVar.h(bj, 1);
            bj.close();
            return;
        }
        a aVar = new a(kVar, b, dHc instanceof com.facebook.imagepipeline.request.c, this.mKo, akVar.dGc().dHb());
        dGd.a(id, dGm(), dGd.QQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.mVS.c(aVar, akVar);
    }

    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b mIl;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mKo;
        private final boolean mXm;
        private final boolean mXn;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.mIl = bVar;
            this.mXm = z;
            this.mKo = pVar;
            this.mXn = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Jm(i)) {
                    dGo().h(null, i);
                }
            } else if (!Jn(i) || this.mXm) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.mXn ? this.mKo.a(this.mIl, aVar) : null;
                try {
                    dGo().ay(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dGo = dGo();
                    if (a != null) {
                        aVar = a;
                    }
                    dGo.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dGm() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
