package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> oMK;
    private final com.facebook.imagepipeline.c.f oVd;
    private final aj<com.facebook.imagepipeline.g.e> oYc;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oMK = pVar;
        this.oVd = fVar;
        this.oYc = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am eqW = akVar.eqW();
        eqW.gZ(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.oVd.c(akVar.eqV(), akVar.elz());
        com.facebook.common.references.a<PooledByteBuffer> bu = this.oMK.bu(c);
        try {
            if (bu != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bu);
                eqW.a(id, "EncodedMemoryCacheProducer", eqW.Ym(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eqW.H(id, "EncodedMemoryCacheProducer", true);
                kVar.aN(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.eqX().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                eqW.a(id, "EncodedMemoryCacheProducer", eqW.Ym(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                eqW.H(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.oMK, c, akVar.eqV().erU());
                eqW.a(id, "EncodedMemoryCacheProducer", eqW.Ym(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.oYc.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bu);
        }
    }

    /* loaded from: classes18.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> oMK;
        private final com.facebook.cache.common.b oYF;
        private final boolean oYG;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.oMK = pVar;
            this.oYF = bVar;
            this.oYG = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (PJ(i) || eVar == null || ea(i, 10)) {
                erh().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> epX = eVar.epX();
            if (epX != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.oYG) {
                        aVar = this.oMK.a(this.oYF, epX);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                erh().aN(1.0f);
                                erh().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(epX);
                }
            }
            erh().h(eVar, i);
        }
    }
}
