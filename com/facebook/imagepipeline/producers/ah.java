package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pdv;
    private final com.facebook.imagepipeline.b.f plv;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pox;

    public ah(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pdv = pVar;
        this.plv = fVar;
        this.pox = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am eww = akVar.eww();
        String id = akVar.getId();
        ImageRequest ewv = akVar.ewv();
        Object erm = akVar.erm();
        com.facebook.imagepipeline.request.b ext = ewv.ext();
        if (ext == null || ext.ewu() == null) {
            this.pox.a(kVar, akVar);
            return;
        }
        eww.hh(id, ewG());
        com.facebook.cache.common.b b = this.plv.b(ewv, erm);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pdv.bu(b);
        if (bu != null) {
            eww.a(id, ewG(), eww.Zq(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            eww.J(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aV(1.0f);
            kVar.h(bu, 1);
            bu.close();
            return;
        }
        a aVar = new a(kVar, b, ext instanceof com.facebook.imagepipeline.request.c, this.pdv, akVar.ewv().exs());
        eww.a(id, ewG(), eww.Zq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pox.a(aVar, akVar);
    }

    /* loaded from: classes15.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final com.facebook.cache.common.b pbw;
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pdv;
        private final boolean ppS;
        private final boolean ppT;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, boolean z2) {
            super(kVar);
            this.pbw = bVar;
            this.ppS = z;
            this.pdv = pVar;
            this.ppT = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (aVar == null) {
                if (Rh(i)) {
                    ewI().h(null, i);
                }
            } else if (!Ri(i) || this.ppS) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = this.ppT ? this.pdv.a(this.pbw, aVar) : null;
                try {
                    ewI().aV(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ewI = ewI();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    ewI.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String ewG() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
