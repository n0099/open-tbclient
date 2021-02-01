package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class s implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pAs;
    private final com.facebook.imagepipeline.b.f pIp;
    private final aj<com.facebook.imagepipeline.f.e> pLo;

    public s(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pAs = pVar;
        this.pIp = fVar;
        this.pLo = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        String id = akVar.getId();
        am ezi = akVar.ezi();
        ezi.ht(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.pIp.c(akVar.ezh(), akVar.etV());
        com.facebook.common.references.a<PooledByteBuffer> bu = this.pAs.bu(c);
        try {
            if (bu != null) {
                com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(bu);
                ezi.b(id, "EncodedMemoryCacheProducer", ezi.Zu(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                ezi.M(id, "EncodedMemoryCacheProducer", true);
                kVar.ba(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
            } else if (akVar.ezj().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                ezi.b(id, "EncodedMemoryCacheProducer", ezi.Zu(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                ezi.M(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.pAs, c, akVar.ezh().eAe());
                ezi.b(id, "EncodedMemoryCacheProducer", ezi.Zu(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.pLo.a(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bu);
        }
    }

    /* loaded from: classes5.dex */
    private static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pAs;
        private final com.facebook.cache.common.b pLR;
        private final boolean pLS;

        public a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.pAs = pVar;
            this.pLR = bVar;
            this.pLS = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Qk(i) || eVar == null || ed(i, 10)) {
                ezu().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> eyn = eVar.eyn();
            if (eyn != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.pLS) {
                        aVar = this.pAs.a(this.pLR, eyn);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(aVar);
                            eVar2.c(eVar);
                            try {
                                ezu().ba(1.0f);
                                ezu().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(eyn);
                }
            }
            ezu().g(eVar, i);
        }
    }
}
