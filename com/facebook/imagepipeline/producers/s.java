package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class s implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pdx;
    private final com.facebook.imagepipeline.b.f plx;
    private final aj<com.facebook.imagepipeline.f.e> poz;

    public s(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pdx = pVar;
        this.plx = fVar;
        this.poz = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        String id = akVar.getId();
        am ewx = akVar.ewx();
        ewx.hh(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.plx.c(akVar.eww(), akVar.ern());
        com.facebook.common.references.a<PooledByteBuffer> bu = this.pdx.bu(c);
        try {
            if (bu != null) {
                com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(bu);
                ewx.a(id, "EncodedMemoryCacheProducer", ewx.Zq(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                ewx.J(id, "EncodedMemoryCacheProducer", true);
                kVar.aV(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
            } else if (akVar.ewy().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                ewx.a(id, "EncodedMemoryCacheProducer", ewx.Zq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                ewx.J(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.pdx, c, akVar.eww().ext());
                ewx.a(id, "EncodedMemoryCacheProducer", ewx.Zq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.poz.a(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bu);
        }
    }

    /* loaded from: classes15.dex */
    private static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pdx;
        private final com.facebook.cache.common.b ppc;
        private final boolean ppd;

        public a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.pdx = pVar;
            this.ppc = bVar;
            this.ppd = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Ri(i) || eVar == null || eg(i, 10)) {
                ewJ().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> evB = eVar.evB();
            if (evB != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.ppd) {
                        aVar = this.pdx.a(this.ppc, evB);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(aVar);
                            eVar2.c(eVar);
                            try {
                                ewJ().aV(1.0f);
                                ewJ().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(evB);
                }
            }
            ewJ().h(eVar, i);
        }
    }
}
