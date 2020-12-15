package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pdx;
    private final com.facebook.imagepipeline.b.f plx;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> poz;

    public ah(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pdx = pVar;
        this.plx = fVar;
        this.poz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am ewx = akVar.ewx();
        String id = akVar.getId();
        ImageRequest eww = akVar.eww();
        Object ern = akVar.ern();
        com.facebook.imagepipeline.request.b exu = eww.exu();
        if (exu == null || exu.ewv() == null) {
            this.poz.a(kVar, akVar);
            return;
        }
        ewx.hh(id, ewH());
        com.facebook.cache.common.b b = this.plx.b(eww, ern);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pdx.bu(b);
        if (bu != null) {
            ewx.a(id, ewH(), ewx.Zq(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            ewx.J(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aV(1.0f);
            kVar.h(bu, 1);
            bu.close();
            return;
        }
        a aVar = new a(kVar, b, exu instanceof com.facebook.imagepipeline.request.c, this.pdx, akVar.eww().ext());
        ewx.a(id, ewH(), ewx.Zq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.poz.a(aVar, akVar);
    }

    /* loaded from: classes15.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final com.facebook.cache.common.b pby;
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pdx;
        private final boolean ppU;
        private final boolean ppV;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, boolean z2) {
            super(kVar);
            this.pby = bVar;
            this.ppU = z;
            this.pdx = pVar;
            this.ppV = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (aVar == null) {
                if (Rh(i)) {
                    ewJ().h(null, i);
                }
            } else if (!Ri(i) || this.ppU) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = this.ppV ? this.pdx.a(this.pby, aVar) : null;
                try {
                    ewJ().aV(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ewJ = ewJ();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    ewJ.h(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String ewH() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
