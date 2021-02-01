package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pAs;
    private final com.facebook.imagepipeline.b.f pIp;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pLo;

    public ah(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pAs = pVar;
        this.pIp = fVar;
        this.pLo = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am ezi = akVar.ezi();
        String id = akVar.getId();
        ImageRequest ezh = akVar.ezh();
        Object etV = akVar.etV();
        com.facebook.imagepipeline.request.b eAf = ezh.eAf();
        if (eAf == null || eAf.ezg() == null) {
            this.pLo.a(kVar, akVar);
            return;
        }
        ezi.ht(id, ezs());
        com.facebook.cache.common.b b2 = this.pIp.b(ezh, etV);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pAs.bu(b2);
        if (bu != null) {
            ezi.b(id, ezs(), ezi.Zu(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            ezi.M(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.ba(1.0f);
            kVar.g(bu, 1);
            bu.close();
            return;
        }
        a aVar = new a(kVar, b2, eAf instanceof com.facebook.imagepipeline.request.c, this.pAs, akVar.ezh().eAe());
        ezi.b(id, ezs(), ezi.Zu(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pLo.a(aVar, akVar);
    }

    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pAs;
        private final boolean pMI;
        private final boolean pMJ;
        private final com.facebook.cache.common.b pyv;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, boolean z2) {
            super(kVar);
            this.pyv = bVar;
            this.pMI = z;
            this.pAs = pVar;
            this.pMJ = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (aVar == null) {
                if (Qj(i)) {
                    ezu().g(null, i);
                }
            } else if (!Qk(i) || this.pMI) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = this.pMJ ? this.pAs.a(this.pyv, aVar) : null;
                try {
                    ezu().ba(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezu = ezu();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    ezu.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String ezs() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
